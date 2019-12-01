package com.crashlytics.android.core;

import android.content.Context;
import android.util.Log;
import com.appsflyer.share.Constants;
import com.crashlytics.android.answers.AppMeasurementEventLogger;
import com.crashlytics.android.answers.EventLogger;
import io.fabric.sdk.android.a.b.i;
import io.fabric.sdk.android.a.b.u;
import io.fabric.sdk.android.a.b.x;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.a.d.b;
import io.fabric.sdk.android.a.e.v;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.o;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.j;
import io.fabric.sdk.android.services.concurrency.k;
import io.fabric.sdk.android.services.concurrency.n;
import io.fabric.sdk.android.services.concurrency.s;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.c;
import io.fabric.sdk.android.services.network.d;
import io.fabric.sdk.android.services.network.g;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

@j({CrashlyticsNdkDataProvider.class})
public class CrashlyticsCore extends l<Void> {
    static final float CLS_DEFAULT_PROCESS_DELAY = 1.0f;
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_ATTRIBUTES = 64;
    static final int MAX_ATTRIBUTE_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.";
    private static final String PREFERENCE_STORE_NAME = "com.crashlytics.android.core.CrashlyticsCore";
    public static final String TAG = "CrashlyticsCore";
    private final ConcurrentHashMap<String, String> attributes;
    private CrashlyticsBackgroundWorker backgroundWorker;
    private CrashlyticsController controller;
    private CrashlyticsFileMarker crashMarker;
    private CrashlyticsNdkDataProvider crashlyticsNdkDataProvider;
    private float delay;
    private boolean disabled;
    private g httpRequestFactory;
    /* access modifiers changed from: private */
    public CrashlyticsFileMarker initializationMarker;
    private CrashlyticsListener listener;
    private final PinningInfoProvider pinningInfo;
    private final long startTime;
    private String userEmail;
    private String userId;
    private String userName;

    public static class Builder {
        private float delay = -1.0f;
        private boolean disabled = false;
        private CrashlyticsListener listener;
        private PinningInfoProvider pinningInfoProvider;

        public CrashlyticsCore build() {
            if (this.delay < 0.0f) {
                this.delay = CrashlyticsCore.CLS_DEFAULT_PROCESS_DELAY;
            }
            return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
        }

        public Builder delay(float f2) {
            if (f2 <= 0.0f) {
                throw new IllegalArgumentException("delay must be greater than 0");
            } else if (this.delay <= 0.0f) {
                this.delay = f2;
                return this;
            } else {
                throw new IllegalStateException("delay already set.");
            }
        }

        public Builder disabled(boolean z) {
            this.disabled = z;
            return this;
        }

        public Builder listener(CrashlyticsListener crashlyticsListener) {
            if (crashlyticsListener == null) {
                throw new IllegalArgumentException("listener must not be null.");
            } else if (this.listener == null) {
                this.listener = crashlyticsListener;
                return this;
            } else {
                throw new IllegalStateException("listener already set.");
            }
        }

        @Deprecated
        public Builder pinningInfo(PinningInfoProvider pinningInfoProvider2) {
            if (pinningInfoProvider2 == null) {
                throw new IllegalArgumentException("pinningInfoProvider must not be null.");
            } else if (this.pinningInfoProvider == null) {
                this.pinningInfoProvider = pinningInfoProvider2;
                return this;
            } else {
                throw new IllegalStateException("pinningInfoProvider already set.");
            }
        }
    }

    private static final class CrashMarkerCheck implements Callable<Boolean> {
        private final CrashlyticsFileMarker crashMarker;

        public CrashMarkerCheck(CrashlyticsFileMarker crashlyticsFileMarker) {
            this.crashMarker = crashlyticsFileMarker;
        }

        public Boolean call() throws Exception {
            if (!this.crashMarker.isPresent()) {
                return Boolean.FALSE;
            }
            f.e().d(CrashlyticsCore.TAG, "Found previous crash marker.");
            this.crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    private static final class NoOpListener implements CrashlyticsListener {
        private NoOpListener() {
        }

        public void crashlyticsDidDetectCrashDuringPreviousExecution() {
        }
    }

    public CrashlyticsCore() {
        this(CLS_DEFAULT_PROCESS_DELAY, null, null, false);
    }

    private void checkForPreviousCrash() {
        if (Boolean.TRUE.equals((Boolean) this.backgroundWorker.submitAndWait(new CrashMarkerCheck(this.crashMarker)))) {
            try {
                this.listener.crashlyticsDidDetectCrashDuringPreviousExecution();
            } catch (Exception e2) {
                f.e().b(TAG, "Exception thrown by CrashlyticsListener while notifying of previous crash.", e2);
            }
        }
    }

    private void doLog(int i2, String str, String str2) {
        if (!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
            this.controller.writeToLog(System.currentTimeMillis() - this.startTime, formatLogMessage(i2, str, str2));
        }
    }

    private static boolean ensureFabricWithCalled(String str) {
        CrashlyticsCore instance = getInstance();
        if (instance != null && instance.controller != null) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics must be initialized by calling Fabric.with(Context) ");
        sb.append(str);
        e2.b(TAG, sb.toString(), null);
        return false;
    }

    private void finishInitSynchronously() {
        AnonymousClass1 r0 = new n<Void>() {
            public k getPriority() {
                return k.IMMEDIATE;
            }

            public Void call() throws Exception {
                return CrashlyticsCore.this.doInBackground();
            }
        };
        for (s addDependency : getDependencies()) {
            r0.addDependency(addDependency);
        }
        Future submit = getFabric().b().submit(r0);
        o e2 = f.e();
        String str = TAG;
        e2.d(str, "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e3) {
            f.e().b(str, "Crashlytics was interrupted during initialization.", e3);
        } catch (ExecutionException e4) {
            f.e().b(str, "Problem encountered during Crashlytics initialization.", e4);
        } catch (TimeoutException e5) {
            f.e().b(str, "Crashlytics timed out during initialization.", e5);
        }
    }

    private static String formatLogMessage(int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(io.fabric.sdk.android.a.b.l.a(i2));
        sb.append(Constants.URL_PATH_DELIMITER);
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        return sb.toString();
    }

    public static CrashlyticsCore getInstance() {
        return (CrashlyticsCore) f.a(CrashlyticsCore.class);
    }

    static boolean isBuildIdValid(String str, boolean z) {
        String str2 = TAG;
        if (!z) {
            f.e().d(str2, "Configured not to require a build ID.");
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } else if (!io.fabric.sdk.android.a.b.l.b(str)) {
            return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        } else {
            String str3 = ".";
            Log.e(str2, str3);
            Log.e(str2, ".     |  | ");
            String str4 = ".     |  |";
            Log.e(str2, str4);
            Log.e(str2, str4);
            Log.e(str2, ".   \\ |  | /");
            Log.e(str2, ".    \\    /");
            Log.e(str2, ".     \\  /");
            Log.e(str2, ".      \\/");
            Log.e(str2, str3);
            Log.e(str2, MISSING_BUILD_ID_MSG);
            Log.e(str2, str3);
            Log.e(str2, ".      /\\");
            Log.e(str2, ".     /  \\");
            Log.e(str2, ".    /    \\");
            Log.e(str2, ".   / |  | \\");
            Log.e(str2, str4);
            Log.e(str2, str4);
            Log.e(str2, str4);
            Log.e(str2, str3);
            return false;
        }
    }

    private static String sanitizeAttribute(String str) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > MAX_ATTRIBUTE_SIZE ? trim.substring(0, MAX_ATTRIBUTE_SIZE) : trim;
    }

    public void crash() {
        new CrashTest().indexOutOfBounds();
    }

    /* access modifiers changed from: 0000 */
    public void createCrashMarker() {
        this.crashMarker.create();
    }

    /* access modifiers changed from: 0000 */
    public boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    /* access modifiers changed from: 0000 */
    public Map<String, String> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }

    /* access modifiers changed from: 0000 */
    public CrashlyticsController getController() {
        return this.controller;
    }

    public String getIdentifier() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    /* access modifiers changed from: 0000 */
    public CrashlyticsNdkData getNativeCrashData() {
        CrashlyticsNdkDataProvider crashlyticsNdkDataProvider2 = this.crashlyticsNdkDataProvider;
        if (crashlyticsNdkDataProvider2 != null) {
            return crashlyticsNdkDataProvider2.getCrashlyticsNdkData();
        }
        return null;
    }

    public PinningInfoProvider getPinningInfoProvider() {
        if (!this.disabled) {
            return this.pinningInfo;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public String getUserEmail() {
        if (getIdManager().a()) {
            return this.userEmail;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public String getUserIdentifier() {
        if (getIdManager().a()) {
            return this.userId;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public String getUserName() {
        if (getIdManager().a()) {
            return this.userName;
        }
        return null;
    }

    public String getVersion() {
        return "2.6.8.32";
    }

    /* access modifiers changed from: 0000 */
    public boolean internalVerifyPinning(URL url) {
        if (getPinningInfoProvider() == null) {
            return false;
        }
        HttpRequest a2 = this.httpRequestFactory.a(d.GET, url.toString());
        ((HttpsURLConnection) a2.j()).setInstanceFollowRedirects(false);
        a2.g();
        return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
    }

    public void log(String str) {
        doLog(3, TAG, str);
    }

    public void logException(Throwable th) {
        if (this.disabled || !ensureFabricWithCalled("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            f.e().a(5, TAG, "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.controller.writeNonFatalException(Thread.currentThread(), th);
        }
    }

    /* access modifiers changed from: 0000 */
    public void markInitializationComplete() {
        this.backgroundWorker.submit((Callable<T>) new Callable<Boolean>() {
            public Boolean call() throws Exception {
                String str = CrashlyticsCore.TAG;
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    o e2 = f.e();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Initialization marker file removed: ");
                    sb.append(remove);
                    e2.d(str, sb.toString());
                    return Boolean.valueOf(remove);
                } catch (Exception e3) {
                    f.e().b(str, "Problem encountered deleting Crashlytics initialization marker.", e3);
                    return Boolean.valueOf(false);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void markInitializationStarted() {
        this.backgroundWorker.submitAndWait(new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsCore.this.initializationMarker.create();
                f.e().d(CrashlyticsCore.TAG, "Initialization marker file created.");
                return null;
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean onPreExecute() {
        return onPreExecute(super.getContext());
    }

    public void setBool(String str, boolean z) {
        setString(str, Boolean.toString(z));
    }

    /* access modifiers changed from: 0000 */
    public void setCrashlyticsNdkDataProvider(CrashlyticsNdkDataProvider crashlyticsNdkDataProvider2) {
        this.crashlyticsNdkDataProvider = crashlyticsNdkDataProvider2;
    }

    public void setDouble(String str, double d2) {
        setString(str, Double.toString(d2));
    }

    public void setFloat(String str, float f2) {
        setString(str, Float.toString(f2));
    }

    public void setInt(String str, int i2) {
        setString(str, Integer.toString(i2));
    }

    @Deprecated
    public synchronized void setListener(CrashlyticsListener crashlyticsListener) {
        f.e().a(TAG, "Use of setListener is deprecated.");
        if (crashlyticsListener != null) {
            this.listener = crashlyticsListener;
        } else {
            throw new IllegalArgumentException("listener must not be null.");
        }
    }

    public void setLong(String str, long j2) {
        setString(str, Long.toString(j2));
    }

    public void setString(String str, String str2) {
        String str3;
        if (!this.disabled && ensureFabricWithCalled("prior to setting keys.")) {
            String str4 = TAG;
            if (str == null) {
                Context context = getContext();
                if (context == null || !io.fabric.sdk.android.a.b.l.j(context)) {
                    f.e().b(str4, "Attempting to set custom attribute with null key, ignoring.", null);
                    return;
                }
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
            String sanitizeAttribute = sanitizeAttribute(str);
            if (this.attributes.size() < 64 || this.attributes.containsKey(sanitizeAttribute)) {
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = sanitizeAttribute(str2);
                }
                this.attributes.put(sanitizeAttribute, str3);
                this.controller.cacheKeyData(this.attributes);
                return;
            }
            f.e().d(str4, "Exceeded maximum number of custom attributes (64)");
        }
    }

    public void setUserEmail(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userEmail = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserIdentifier(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userId = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public void setUserName(String str) {
        if (!this.disabled && ensureFabricWithCalled("prior to setting user data.")) {
            this.userName = sanitizeAttribute(str);
            this.controller.cacheUserData(this.userId, this.userName, this.userEmail);
        }
    }

    public boolean verifyPinning(URL url) {
        try {
            return internalVerifyPinning(url);
        } catch (Exception e2) {
            f.e().b(TAG, "Could not verify SSL pinning", e2);
            return false;
        }
    }

    CrashlyticsCore(float f2, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z) {
        this(f2, crashlyticsListener, pinningInfoProvider, z, u.a("Crashlytics Exception Handler"));
    }

    /* access modifiers changed from: protected */
    public Void doInBackground() {
        String str = TAG;
        markInitializationStarted();
        this.controller.cleanInvalidTempFiles();
        try {
            this.controller.registerDevicePowerStateListener();
            v a2 = io.fabric.sdk.android.a.e.s.b().a();
            if (a2 == null) {
                f.e().a(str, "Received null settings, skipping report submission!");
                markInitializationComplete();
                return null;
            }
            this.controller.registerAnalyticsEventListener(a2);
            if (!a2.f8974d.f8941c) {
                f.e().d(str, "Collection of crash reports disabled in Crashlytics settings.");
                markInitializationComplete();
                return null;
            } else if (!io.fabric.sdk.android.a.b.o.a(getContext()).a()) {
                f.e().d(str, "Automatic collection of crash reports disabled by Firebase settings.");
                markInitializationComplete();
                return null;
            } else {
                CrashlyticsNdkData nativeCrashData = getNativeCrashData();
                if (nativeCrashData != null && !this.controller.finalizeNativeReport(nativeCrashData)) {
                    f.e().d(str, "Could not finalize previous NDK sessions.");
                }
                if (!this.controller.finalizeSessions(a2.f8972b)) {
                    f.e().d(str, "Could not finalize previous sessions.");
                }
                this.controller.submitAllReports(this.delay, a2);
                markInitializationComplete();
                return null;
            }
        } catch (Exception e2) {
            f.e().b(str, "Crashlytics encountered a problem during asynchronous initialization.", e2);
        } catch (Throwable th) {
            markInitializationComplete();
            throw th;
        }
    }

    public void log(int i2, String str, String str2) {
        doLog(i2, str, str2);
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        String str3 = "";
        sb.append(str3);
        sb.append(str);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(str2);
        e2.a(i2, sb2, sb3.toString(), CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT);
    }

    /* access modifiers changed from: 0000 */
    public boolean onPreExecute(Context context) {
        Context context2 = context;
        boolean a2 = io.fabric.sdk.android.a.b.o.a(context).a();
        String str = TAG;
        if (!a2) {
            f.e().d(str, "Crashlytics is disabled, because data collection is disabled by Firebase.");
            this.disabled = CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
        }
        if (this.disabled) {
            return false;
        }
        String d2 = new i().d(context2);
        if (d2 == null) {
            return false;
        }
        String n = io.fabric.sdk.android.a.b.l.n(context);
        if (isBuildIdValid(n, io.fabric.sdk.android.a.b.l.a(context2, CRASHLYTICS_REQUIRE_BUILD_ID, (boolean) CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT))) {
            try {
                o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Initializing Crashlytics ");
                sb.append(getVersion());
                e2.e(str, sb.toString());
                b bVar = new b(this);
                this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, bVar);
                this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, bVar);
                PreferenceManager create = PreferenceManager.create(new io.fabric.sdk.android.a.d.d(getContext(), PREFERENCE_STORE_NAME), this);
                io.fabric.sdk.android.services.network.i crashlyticsPinningInfoProvider = this.pinningInfo != null ? new CrashlyticsPinningInfoProvider(this.pinningInfo) : null;
                this.httpRequestFactory = new c(f.e());
                this.httpRequestFactory.a(crashlyticsPinningInfoProvider);
                y idManager = getIdManager();
                AppData create2 = AppData.create(context2, idManager, d2, n);
                ResourceUnityVersionProvider resourceUnityVersionProvider = new ResourceUnityVersionProvider(context2, new ManifestUnityVersionProvider(context2, create2.packageName));
                DefaultAppMeasurementEventListenerRegistrar defaultAppMeasurementEventListenerRegistrar = new DefaultAppMeasurementEventListenerRegistrar(this);
                EventLogger eventLogger = AppMeasurementEventLogger.getEventLogger(context);
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Installer package name is: ");
                sb2.append(create2.installerPackageName);
                e3.d(str, sb2.toString());
                CrashlyticsController crashlyticsController = r1;
                CrashlyticsController crashlyticsController2 = new CrashlyticsController(this, this.backgroundWorker, this.httpRequestFactory, idManager, create, bVar, create2, resourceUnityVersionProvider, defaultAppMeasurementEventListenerRegistrar, eventLogger);
                this.controller = crashlyticsController;
                boolean didPreviousInitializationFail = didPreviousInitializationFail();
                checkForPreviousCrash();
                this.controller.enableExceptionHandling(Thread.getDefaultUncaughtExceptionHandler(), new x().e(context2));
                if (!didPreviousInitializationFail || !io.fabric.sdk.android.a.b.l.b(context)) {
                    f.e().d(str, "Exception handling initialization successful");
                    return CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT;
                }
                f.e().d(str, "Crashlytics did not finish previous background initialization. Initializing synchronously.");
                finishInitSynchronously();
                return false;
            } catch (Exception e4) {
                f.e().b(str, "Crashlytics was not started due to an exception during initialization", e4);
                this.controller = null;
                return false;
            }
        } else {
            throw new UnmetDependencyException(MISSING_BUILD_ID_MSG);
        }
    }

    CrashlyticsCore(float f2, CrashlyticsListener crashlyticsListener, PinningInfoProvider pinningInfoProvider, boolean z, ExecutorService executorService) {
        this.userId = null;
        this.userEmail = null;
        this.userName = null;
        this.delay = f2;
        if (crashlyticsListener == null) {
            crashlyticsListener = new NoOpListener();
        }
        this.listener = crashlyticsListener;
        this.pinningInfo = pinningInfoProvider;
        this.disabled = z;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.attributes = new ConcurrentHashMap<>();
        this.startTime = System.currentTimeMillis();
    }
}
