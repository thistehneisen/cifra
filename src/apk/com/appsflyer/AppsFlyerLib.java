package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.appsflyer.AFLogger.LogLevel;
import com.appsflyer.AppsFlyerProperties.EmailsCryptType;
import com.appsflyer.OneLinkHttpTask.HttpsUrlConnectionProvider;
import com.appsflyer.cache.CacheManager;
import com.appsflyer.cache.RequestCacheData;
import com.appsflyer.share.Constants;
import io.fabric.sdk.android.a.b.C0730a;
import io.intercom.android.sdk.metrics.MetricTracker.Object;
import io.intercom.android.sdk.views.holder.AttributeType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyerLib implements d {
    public static final String AF_PRE_INSTALL_PATH = "AF_PRE_INSTALL_PATH";
    public static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final String ATTRIBUTION_ID_CONTENT_URI = "content://com.facebook.katana.provider.AttributionIdProvider";
    public static final String IS_STOP_TRACKING_USED = "is_stop_tracking_used";
    public static final String LOG_TAG = "AppsFlyer_4.9.0";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT = "/data/local/tmp/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_DEFAULT_ETC = "/etc/pre_install.appsflyer";
    public static final String PRE_INSTALL_SYSTEM_RO_PROP = "ro.appsflyer.preinstall.path";

    /* renamed from: ʻ reason: contains not printable characters */
    private static String f25;

    /* renamed from: ʻॱ reason: contains not printable characters */
    private static AppsFlyerTrackingRequestListener f26 = null;

    /* renamed from: ʼ reason: contains not printable characters */
    private static String f27;

    /* renamed from: ʼॱ reason: contains not printable characters */
    private static AppsFlyerLib f28 = new AppsFlyerLib();

    /* renamed from: ʽ reason: contains not printable characters */
    private static String f29;

    /* renamed from: ˊ reason: contains not printable characters */
    static final String f30;
    /* access modifiers changed from: private */

    /* renamed from: ˊॱ reason: contains not printable characters */
    public static final List<String> f31 = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});

    /* renamed from: ˎ reason: contains not printable characters */
    static AppsFlyerInAppPurchaseValidatorListener f32 = null;

    /* renamed from: ˏ reason: contains not printable characters */
    static final String f33;

    /* renamed from: ͺ reason: contains not printable characters */
    private static final List<String> f34 = Arrays.asList(new String[]{"is_cache"});
    /* access modifiers changed from: private */

    /* renamed from: ॱˊ reason: contains not printable characters */
    public static AppsFlyerConversionListener f35 = null;

    /* renamed from: ॱॱ reason: contains not printable characters */
    private static final String f36;
    protected Uri latestDeepLink = null;
    /* access modifiers changed from: private */

    /* renamed from: ʽॱ reason: contains not printable characters */
    public ScheduledExecutorService f37 = null;

    /* renamed from: ʾ reason: contains not printable characters */
    private long f38;

    /* renamed from: ʿ reason: contains not printable characters */
    private d f39;

    /* renamed from: ˈ reason: contains not printable characters */
    private long f40;

    /* renamed from: ˉ reason: contains not printable characters */
    private Map<Long, String> f41;

    /* renamed from: ˊˊ reason: contains not printable characters */
    private boolean f42 = false;

    /* renamed from: ˊˋ reason: contains not printable characters */
    private boolean f43 = false;

    /* renamed from: ˊᐝ reason: contains not printable characters */
    private long f44;

    /* renamed from: ˋ reason: contains not printable characters */
    String f45;

    /* renamed from: ˋˊ reason: contains not printable characters */
    private String f46;

    /* renamed from: ˋˋ reason: contains not printable characters */
    private q f47 = new q();

    /* renamed from: ˋॱ reason: contains not printable characters */
    private long f48 = TimeUnit.SECONDS.toMillis(5);

    /* renamed from: ˋᐝ reason: contains not printable characters */
    private boolean f49 = false;

    /* renamed from: ˌ reason: contains not printable characters */
    private boolean f50 = false;

    /* renamed from: ˍ reason: contains not printable characters */
    private boolean f51;

    /* renamed from: ˎˎ reason: contains not printable characters */
    private boolean f52;

    /* renamed from: ˏॱ reason: contains not printable characters */
    private long f53 = -1;

    /* renamed from: ॱ reason: contains not printable characters */
    String f54;

    /* renamed from: ॱˋ reason: contains not printable characters */
    private e f55 = null;
    /* access modifiers changed from: private */

    /* renamed from: ॱˎ reason: contains not printable characters */
    public boolean f56 = false;
    /* access modifiers changed from: private */

    /* renamed from: ॱᐝ reason: contains not printable characters */
    public long f57;

    /* renamed from: ᐝ reason: contains not printable characters */
    private long f58 = -1;
    /* access modifiers changed from: private */

    /* renamed from: ᐝॱ reason: contains not printable characters */
    public Map<String, String> f59;

    /* renamed from: com.appsflyer.AppsFlyerLib$5 reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: ˎ reason: contains not printable characters */
        static final /* synthetic */ int[] f66 = new int[EmailsCryptType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            f66[EmailsCryptType.SHA1.ordinal()] = 1;
            f66[EmailsCryptType.MD5.ordinal()] = 2;
            f66[EmailsCryptType.SHA256.ordinal()] = 3;
            try {
                f66[EmailsCryptType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    class a implements Runnable {

        /* renamed from: ʻ reason: contains not printable characters */
        private String f67;

        /* renamed from: ʼ reason: contains not printable characters */
        private boolean f68;

        /* renamed from: ˊ reason: contains not printable characters */
        private final String f70;

        /* renamed from: ˋ reason: contains not printable characters */
        private final Intent f71;

        /* renamed from: ˎ reason: contains not printable characters */
        private String f72;

        /* renamed from: ˏ reason: contains not printable characters */
        private String f73;

        /* renamed from: ॱ reason: contains not printable characters */
        private WeakReference<Context> f74;

        /* renamed from: ॱॱ reason: contains not printable characters */
        private String f75;

        /* renamed from: ᐝ reason: contains not printable characters */
        private boolean f76;

        /* synthetic */ a(AppsFlyerLib appsFlyerLib, WeakReference weakReference, String str, String str2, String str3, String str4, boolean z, Intent intent, String str5, byte b2) {
            this(weakReference, str, str2, str3, str4, z, intent, str5);
        }

        public final void run() {
            AppsFlyerLib.m67(AppsFlyerLib.this, (Context) this.f74.get(), this.f72, this.f73, this.f67, this.f75, this.f76, this.f68, this.f71, this.f70);
        }

        private a(WeakReference<Context> weakReference, String str, String str2, String str3, String str4, boolean z, Intent intent, String str5) {
            this.f74 = weakReference;
            this.f72 = str;
            this.f73 = str2;
            this.f67 = str3;
            this.f75 = str4;
            this.f76 = true;
            this.f68 = z;
            this.f71 = intent;
            this.f70 = str5;
        }
    }

    class b implements Runnable {

        /* renamed from: ˊ reason: contains not printable characters */
        private int f78;

        /* renamed from: ˋ reason: contains not printable characters */
        private WeakReference<Context> f79;

        /* renamed from: ˎ reason: contains not printable characters */
        private Map<String, Object> f80;

        /* renamed from: ˏ reason: contains not printable characters */
        private boolean f81;

        /* renamed from: ॱ reason: contains not printable characters */
        private String f82;

        /* synthetic */ b(AppsFlyerLib appsFlyerLib, String str, Map map, Context context, boolean z, int i2, byte b2) {
            this(str, map, context, z, i2);
        }

        public final void run() {
            if (!AppsFlyerLib.this.isTrackingStopped()) {
                String str = null;
                if (this.f81 && this.f78 <= 2 && AppsFlyerLib.m70(AppsFlyerLib.this)) {
                    this.f80.put("rfr", AppsFlyerLib.this.f59);
                }
                Map<String, Object> map = this.f80;
                map.putAll(new e(map, (Context) this.f79.get()));
                try {
                    String str2 = (String) this.f80.get("appsflyerKey");
                    synchronized (this.f80) {
                        str = AFHelper.convertToJsonObject(this.f80).toString();
                    }
                    AppsFlyerLib.m68(AppsFlyerLib.this, this.f82, str, str2, this.f79, null, this.f81);
                } catch (IOException e2) {
                    AFLogger.afErrorLog("Exception while sending request to server. ", e2);
                    if (!(str == null || this.f79 == null || this.f82.contains("&isCachedRequest=true&timeincache="))) {
                        CacheManager.getInstance().cacheRequest(new RequestCacheData(this.f82, str, BuildConfig.VERSION_NAME), (Context) this.f79.get());
                        AFLogger.afErrorLog(e2.getMessage(), e2);
                    }
                } catch (Throwable th) {
                    AFLogger.afErrorLog(th.getMessage(), th);
                }
            }
        }

        private b(String str, Map<String, Object> map, Context context, boolean z, int i2) {
            this.f79 = null;
            this.f82 = str;
            this.f80 = map;
            this.f79 = new WeakReference<>(context);
            this.f81 = z;
            this.f78 = i2;
        }
    }

    class c implements Runnable {

        /* renamed from: ˊ reason: contains not printable characters */
        private WeakReference<Context> f83 = null;

        public c(Context context) {
            this.f83 = new WeakReference<>(context);
        }

        public final void run() {
            if (!AppsFlyerLib.this.f56) {
                AppsFlyerLib.this.f57 = System.currentTimeMillis();
                if (this.f83 != null) {
                    AppsFlyerLib.this.f56 = true;
                    try {
                        String r1 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                        synchronized (this.f83) {
                            for (RequestCacheData requestCacheData : CacheManager.getInstance().getCachedRequests((Context) this.f83.get())) {
                                StringBuilder sb = new StringBuilder("resending request: ");
                                sb.append(requestCacheData.getRequestURL());
                                AFLogger.afInfoLog(sb.toString());
                                try {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    long parseLong = Long.parseLong(requestCacheData.getCacheKey(), 10);
                                    AppsFlyerLib appsFlyerLib = AppsFlyerLib.this;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(requestCacheData.getRequestURL());
                                    sb2.append("&isCachedRequest=true&timeincache=");
                                    sb2.append(Long.toString((currentTimeMillis - parseLong) / 1000));
                                    AppsFlyerLib.m68(appsFlyerLib, sb2.toString(), requestCacheData.getPostData(), r1, this.f83, requestCacheData.getCacheKey(), false);
                                } catch (Exception e2) {
                                    AFLogger.afErrorLog("Failed to resend cached request", e2);
                                }
                            }
                        }
                    } catch (Exception e3) {
                        try {
                            AFLogger.afErrorLog("failed to check cache. ", e3);
                        } catch (Throwable th) {
                            AppsFlyerLib.this.f56 = false;
                            throw th;
                        }
                    }
                    AppsFlyerLib.this.f56 = false;
                    AppsFlyerLib.this.f37.shutdown();
                    AppsFlyerLib.this.f37 = null;
                }
            }
        }
    }

    abstract class d implements Runnable {

        /* renamed from: ˊ reason: contains not printable characters */
        private String f85;

        /* renamed from: ˋ reason: contains not printable characters */
        private AtomicInteger f86 = new AtomicInteger(0);

        /* renamed from: ˎ reason: contains not printable characters */
        WeakReference<Context> f87 = null;

        /* renamed from: ˏ reason: contains not printable characters */
        private ScheduledExecutorService f88;

        d(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            this.f87 = new WeakReference<>(context);
            this.f85 = str;
            if (scheduledExecutorService == null) {
                this.f88 = AFExecutor.getInstance().m4();
            } else {
                this.f88 = scheduledExecutorService;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00f6 A[Catch:{ Throwable -> 0x0211, all -> 0x020f }] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x01d8 A[Catch:{ Throwable -> 0x0211, all -> 0x020f }] */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x020b  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x021e A[Catch:{ all -> 0x0214 }] */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0233  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0243  */
        public void run() {
            HttpURLConnection httpURLConnection;
            String str;
            int responseCode;
            String str2 = Constants.URL_SITE_ID;
            String str3 = this.f85;
            if (str3 != null && str3.length() != 0 && !AppsFlyerLib.this.isTrackingStopped()) {
                this.f86.incrementAndGet();
                HttpURLConnection httpURLConnection2 = null;
                try {
                    Context context = (Context) this.f87.get();
                    if (context == null) {
                        this.f86.decrementAndGet();
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String r6 = AppsFlyerLib.m72(context, AppsFlyerLib.m33(new WeakReference<>(context)));
                    String str4 = "";
                    if (r6 != null) {
                        if (!AppsFlyerLib.f31.contains(r6.toLowerCase())) {
                            str = "-".concat(String.valueOf(r6));
                            StringBuilder sb = new StringBuilder();
                            sb.append(m86());
                            sb.append(context.getPackageName());
                            sb.append(str);
                            sb.append("?devkey=");
                            sb.append(this.f85);
                            sb.append("&device_id=");
                            sb.append(C0280r.m186(new WeakReference(context)));
                            s.m191().m198(sb.toString(), str4);
                            StringBuilder sb2 = new StringBuilder("Calling server for attribution url: ");
                            sb2.append(sb.toString());
                            a.m141(sb2.toString());
                            httpURLConnection = (HttpURLConnection) new URL(sb.toString()).openConnection();
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(C0730a.DEFAULT_TIMEOUT);
                            httpURLConnection.setRequestProperty("Connection", "close");
                            httpURLConnection.connect();
                            responseCode = httpURLConnection.getResponseCode();
                            String r7 = AppsFlyerLib.m47(httpURLConnection);
                            s.m191().m204(sb.toString(), responseCode, r7);
                            if (responseCode != 200) {
                                AppsFlyerLib.m52(context, "appsflyerGetConversionDataTiming", System.currentTimeMillis() - currentTimeMillis);
                                a.m141("Attribution data: ".concat(String.valueOf(r7)));
                                if (r7.length() > 0 && context != null) {
                                    Map r1 = AppsFlyerLib.m35(r7);
                                    String str5 = (String) r1.get("iscache");
                                    if (str5 != null && Boolean.toString(false).equals(str5)) {
                                        AppsFlyerLib.m52(context, "appsflyerConversionDataCacheExpiration", System.currentTimeMillis());
                                    }
                                    boolean containsKey = r1.containsKey(str2);
                                    String str6 = Constants.LOG_INVITE_DETECTED_APP_INVITE_VIA_CHANNEL;
                                    String str7 = "af_channel";
                                    if (containsKey) {
                                        if (r1.containsKey(str7)) {
                                            StringBuilder sb3 = new StringBuilder(str6);
                                            sb3.append((String) r1.get(str7));
                                            AFLogger.afDebugLog(sb3.toString());
                                        } else {
                                            AFLogger.afDebugLog(String.format(Constants.LOG_CROSS_PROMOTION_APP_INSTALLED_FROM_CROSS_PROMOTION, new Object[]{r1.get(str2)}));
                                        }
                                    }
                                    if (r1.containsKey(str2)) {
                                        StringBuilder sb4 = new StringBuilder(str6);
                                        sb4.append((String) r1.get(str7));
                                        AFLogger.afDebugLog(sb4.toString());
                                    }
                                    r1.put("is_first_launch", Boolean.toString(false));
                                    String jSONObject = new JSONObject(r1).toString();
                                    String str8 = "attributionId";
                                    if (jSONObject != null) {
                                        AppsFlyerLib.m53(context, str8, jSONObject);
                                    } else {
                                        AppsFlyerLib.m53(context, str8, r7);
                                    }
                                    StringBuilder sb5 = new StringBuilder("iscache=");
                                    sb5.append(str5);
                                    sb5.append(" caching conversion data");
                                    AFLogger.afDebugLog(sb5.toString());
                                    if (AppsFlyerLib.f35 != null && this.f86.intValue() <= 1) {
                                        try {
                                            r1 = AppsFlyerLib.m25(context);
                                        } catch (k e2) {
                                            AFLogger.afErrorLog("Exception while trying to fetch attribution data. ", e2);
                                        }
                                        m85(r1);
                                    }
                                }
                            } else {
                                if (AppsFlyerLib.f35 != null) {
                                    m87("Error connection to server: ".concat(String.valueOf(responseCode)), responseCode);
                                }
                                StringBuilder sb6 = new StringBuilder("AttributionIdFetcher response code: ");
                                sb6.append(responseCode);
                                sb6.append("  url: ");
                                sb6.append(sb);
                                a.m141(sb6.toString());
                            }
                            this.f86.decrementAndGet();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f88.shutdown();
                        }
                        AFLogger.afWarnLog(String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", new Object[]{r6}));
                    }
                    str = str4;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(m86());
                    sb7.append(context.getPackageName());
                    sb7.append(str);
                    sb7.append("?devkey=");
                    sb7.append(this.f85);
                    sb7.append("&device_id=");
                    sb7.append(C0280r.m186(new WeakReference(context)));
                    s.m191().m198(sb7.toString(), str4);
                    StringBuilder sb22 = new StringBuilder("Calling server for attribution url: ");
                    sb22.append(sb7.toString());
                    a.m141(sb22.toString());
                    httpURLConnection = (HttpURLConnection) new URL(sb7.toString()).openConnection();
                    try {
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(C0730a.DEFAULT_TIMEOUT);
                        httpURLConnection.setRequestProperty("Connection", "close");
                        httpURLConnection.connect();
                        responseCode = httpURLConnection.getResponseCode();
                        String r72 = AppsFlyerLib.m47(httpURLConnection);
                        s.m191().m204(sb7.toString(), responseCode, r72);
                        if (responseCode != 200) {
                        }
                        this.f86.decrementAndGet();
                        if (httpURLConnection != null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.f86.decrementAndGet();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                    this.f88.shutdown();
                } catch (Throwable th2) {
                    th = th2;
                    if (AppsFlyerLib.f35 != null) {
                    }
                    AFLogger.afErrorLog(th.getMessage(), th);
                    this.f86.decrementAndGet();
                    if (httpURLConnection2 != null) {
                    }
                    this.f88.shutdown();
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˋ reason: contains not printable characters */
        public abstract void m85(Map<String, String> map);

        /* renamed from: ॱ reason: contains not printable characters */
        public abstract String m86();

        /* access modifiers changed from: protected */
        /* renamed from: ॱ reason: contains not printable characters */
        public abstract void m87(String str, int i2);
    }

    class e extends d {
        public e(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
            super(context, str, scheduledExecutorService);
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˋ reason: contains not printable characters */
        public final void m88(Map<String, String> map) {
            map.put("is_first_launch", Boolean.toString(true));
            AppsFlyerLib.f35.onInstallConversionDataLoaded(map);
            AppsFlyerLib.m57((Context) this.f87.get(), "appsflyerConversionDataRequestRetries", 0);
        }

        /* renamed from: ॱ reason: contains not printable characters */
        public final String m89() {
            return ServerConfigHandler.getUrl("https://%sapi.%s/install_data/v3/");
        }

        /* access modifiers changed from: protected */
        /* renamed from: ॱ reason: contains not printable characters */
        public final void m90(String str, int i2) {
            AppsFlyerLib.f35.onInstallConversionFailure(str);
            if (i2 >= 400 && i2 < 500) {
                String str2 = "appsflyerConversionDataRequestRetries";
                AppsFlyerLib.m57((Context) this.f87.get(), str2, AppsFlyerLib.m44((Context) this.f87.get()).getInt(str2, 0) + 1);
            }
        }
    }

    static {
        String str = BuildConfig.VERSION_NAME;
        f33 = str.substring(0, str.indexOf("."));
        StringBuilder sb = new StringBuilder();
        sb.append(f33);
        sb.append("/androidevent?buildnumber=4.9.0&app_id=");
        f36 = sb.toString();
        StringBuilder sb2 = new StringBuilder("https://%sattr.%s/api/v");
        sb2.append(f36);
        f29 = sb2.toString();
        StringBuilder sb3 = new StringBuilder("https://%st.%s/api/v");
        sb3.append(f36);
        f25 = sb3.toString();
        StringBuilder sb4 = new StringBuilder("https://%sevents.%s/api/v");
        sb4.append(f36);
        f27 = sb4.toString();
        StringBuilder sb5 = new StringBuilder("https://%sregister.%s/api/v");
        sb5.append(f36);
        f30 = sb5.toString();
    }

    private AppsFlyerLib() {
        AFVersionDeclaration.init();
    }

    public static AppsFlyerLib getInstance() {
        return f28;
    }

    /* renamed from: ʻ reason: contains not printable characters */
    private static boolean m20(Context context) {
        if (context != null) {
            int i2 = VERSION.SDK_INT;
            String str = "Failed collecting ivc data";
            if (i2 >= 23) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    for (Network networkCapabilities : connectivityManager.getAllNetworks()) {
                        NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(networkCapabilities);
                        if (networkCapabilities2.hasTransport(4) && !networkCapabilities2.hasCapability(15)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Exception e2) {
                    AFLogger.afErrorLog(str, e2);
                }
            } else if (i2 >= 16) {
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp()) {
                            arrayList.add(networkInterface.getName());
                        }
                    }
                    return arrayList.contains("tun0");
                } catch (Exception e3) {
                    AFLogger.afErrorLog(str, e3);
                }
            }
        }
        return false;
    }

    /* renamed from: ʼ reason: contains not printable characters */
    private static String m21(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String r2 = m46(new WeakReference<>(context), "AF_STORE");
        if (r2 != null) {
            return r2;
        }
        return null;
    }

    /* renamed from: ʽ reason: contains not printable characters */
    private static float m22(Context context) {
        float f2;
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                return 50.0f;
            }
            f2 = (((float) intExtra) / ((float) intExtra2)) * 100.0f;
            return f2;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            f2 = 1.0f;
        }
    }

    /* renamed from: ˊ reason: contains not printable characters */
    static /* synthetic */ void m29(Map map) {
        AppsFlyerConversionListener appsFlyerConversionListener = f35;
        if (appsFlyerConversionListener != null) {
            try {
                appsFlyerConversionListener.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    /* renamed from: ॱॱ reason: contains not printable characters */
    private static boolean m71(Context context) {
        if ((AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) || !m69(context)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: ᐝ reason: contains not printable characters */
    public static String m72(Context context, String str) throws NameNotFoundException {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        String str2 = "CACHED_CHANNEL";
        if (sharedPreferences.contains(str2)) {
            return sharedPreferences.getString(str2, null);
        }
        m53(context, str2, str);
        return str;
    }

    public AppsFlyerLib enableLocationCollection(boolean z) {
        this.f42 = z;
        return this;
    }

    public void enableUninstallTracking(String str) {
        s.m191().m199("enableUninstallTracking", str);
        AppsFlyerProperties.getInstance().set("gcmProjectNumber", str);
    }

    public String getAppsFlyerUID(Context context) {
        s.m191().m199("getAppsFlyerUID", new String[0]);
        return C0280r.m186(new WeakReference(context));
    }

    public String getAttributionId(ContentResolver contentResolver) {
        String str = ATTRIBUTION_ID_COLUMN_NAME;
        String[] strArr = {str};
        Cursor query = contentResolver.query(Uri.parse(ATTRIBUTION_ID_CONTENT_URI), strArr, null, null, null);
        String str2 = null;
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex(str));
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e2) {
                            AFLogger.afErrorLog(e2.getMessage(), e2);
                        }
                    }
                    return str2;
                }
            } catch (Exception e3) {
                AFLogger.afErrorLog("Could not collect cursor attribution. ", e3);
                if (query != null) {
                    query.close();
                }
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        AFLogger.afErrorLog(e4.getMessage(), e4);
                    }
                }
            }
        }
        if (query != null) {
            try {
                query.close();
            } catch (Exception e5) {
                AFLogger.afErrorLog(e5.getMessage(), e5);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void getConversionData(Context context, final ConversionDataListener conversionDataListener) {
        f35 = new AppsFlyerConversionListener() {
            public final void onAppOpenAttribution(Map<String, String> map) {
            }

            public final void onAttributionFailure(String str) {
            }

            public final void onInstallConversionDataLoaded(Map<String, String> map) {
                conversionDataListener.onConversionDataLoaded(map);
            }

            public final void onInstallConversionFailure(String str) {
                conversionDataListener.onConversionFailure(str);
            }
        };
    }

    public String getHostName() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host");
        return string != null ? string : ServerParameters.DEFAULT_HOST;
    }

    public String getHostPrefix() {
        String string = AppsFlyerProperties.getInstance().getString("custom_host_prefix");
        return string != null ? string : "";
    }

    public String getOutOfStore(Context context) {
        String string = AppsFlyerProperties.getInstance().getString("api_store_value");
        if (string != null) {
            return string;
        }
        String r3 = m46(new WeakReference<>(context), "AF_STORE");
        if (r3 != null) {
            return r3;
        }
        AFLogger.afInfoLog("No out-of-store value set");
        return null;
    }

    public String getSdkVersion() {
        s.m191().m199("getSdkVersion", new String[0]);
        return "version: 4.9.0 (build 184)";
    }

    /* access modifiers changed from: protected */
    public void handleDeepLinkCallback(Context context, Map<String, Object> map, Uri uri) {
        final Map map2;
        String uri2 = uri.toString();
        boolean z = true;
        if (uri2 == null) {
            uri2 = null;
        } else {
            Matcher matcher = Pattern.compile("fb\\d*?://authorize.*access_token=([^&]*)").matcher(uri2);
            if (matcher.find()) {
                String str = "";
                uri2 = new StringBuilder(uri2).replace(matcher.start(1), matcher.end(1), str).toString().replaceFirst("&access_token=", str).replaceFirst("access_token=&", str).replaceFirst("access_token=", str);
            }
        }
        String str2 = "af_deeplink";
        if (!map.containsKey(str2)) {
            map.put(str2, uri2);
        }
        if (uri.getQueryParameter(str2) != null) {
            String queryParameter = uri.getQueryParameter("media_source");
            String queryParameter2 = uri.getQueryParameter("is_retargeting");
            if (!"AppsFlyer_Test".equals(queryParameter) || !Boolean.parseBoolean(queryParameter2)) {
                z = false;
            }
            this.f43 = z;
            map2 = m34(context, uri.getQuery());
            String path = uri.getPath();
            if (path != null) {
                map2.put("path", path);
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                map2.put("scheme", scheme);
            }
            String host = uri.getHost();
            if (host != null) {
                map2.put("host", host);
            }
        } else {
            map2 = new HashMap();
            map2.put("link", uri.toString());
        }
        final WeakReference weakReference = new WeakReference(context);
        t tVar = new t(uri, this);
        tVar.setConnProvider(new HttpsUrlConnectionProvider());
        if (tVar.m220()) {
            tVar.m217(new c() {
                /* renamed from: ˋ reason: contains not printable characters */
                private void m80(Map<String, String> map) {
                    if (weakReference.get() != null) {
                        AppsFlyerLib.m53((Context) weakReference.get(), "deeplinkAttribution", new JSONObject(map).toString());
                    }
                }

                /* renamed from: ˊ reason: contains not printable characters */
                public final void m81(Map<String, String> map) {
                    for (String str : map.keySet()) {
                        map2.put(str, map.get(str));
                    }
                    m80(map2);
                    AppsFlyerLib.m29(map2);
                }

                /* renamed from: ˏ reason: contains not printable characters */
                public final void m82(String str) {
                    if (AppsFlyerLib.f35 != null) {
                        m80(map2);
                        AppsFlyerLib.f35.onAttributionFailure(str);
                    }
                }
            });
            AFExecutor.getInstance().getThreadPoolExecutor().execute(tVar);
            return;
        }
        AppsFlyerConversionListener appsFlyerConversionListener = f35;
        if (appsFlyerConversionListener != null) {
            try {
                appsFlyerConversionListener.onAppOpenAttribution(map2);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener) {
        s r0 = s.m191();
        String[] strArr = new String[2];
        strArr[0] = str;
        strArr[1] = appsFlyerConversionListener == null ? "null" : "conversionDataListener";
        r0.m199("init", strArr);
        AFLogger.m17(String.format("Initializing AppsFlyer SDK: (v%s.%s)", new Object[]{BuildConfig.VERSION_NAME, "184"}));
        this.f52 = true;
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_KEY, str);
        a.m142(str);
        f35 = appsFlyerConversionListener;
        return this;
    }

    public boolean isPreInstalledApp(Context context) {
        try {
            if ((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 1) != 0) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e2) {
            AFLogger.afErrorLog("Could not check if app is pre installed", e2);
        }
    }

    public boolean isTrackingStopped() {
        return this.f50;
    }

    public void onHandleReferrer(Map<String, String> map) {
        this.f59 = map;
    }

    public void onPause(Context context) {
        AnonymousClass3.m1(context);
        i r2 = i.m147(context);
        r2.f157.post(r2.f155);
    }

    public void registerConversionListener(Context context, AppsFlyerConversionListener appsFlyerConversionListener) {
        s.m191().m199("registerConversionListener", new String[0]);
        if (appsFlyerConversionListener != null) {
            f35 = appsFlyerConversionListener;
        }
    }

    public void registerValidatorListener(Context context, AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener) {
        s.m191().m199("registerValidatorListener", new String[0]);
        AFLogger.afDebugLog("registerValidatorListener called");
        if (appsFlyerInAppPurchaseValidatorListener == null) {
            AFLogger.afDebugLog("registerValidatorListener null listener");
        } else {
            f32 = appsFlyerInAppPurchaseValidatorListener;
        }
    }

    public void reportTrackSession(Context context) {
        s.m191().m199("reportTrackSession", new String[0]);
        s.m191().m207();
        m73(context, (String) null, null);
    }

    public void sendDeepLinkData(Activity activity) {
        String str = "sendDeepLinkData";
        if (activity != null && activity.getIntent() != null) {
            s r4 = s.m191();
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            r4.m199(str, activity.getLocalClassName(), sb.toString());
        } else if (activity != null) {
            s.m191().m199(str, activity.getLocalClassName(), "activity_intent_null");
        } else {
            s.m191().m199(str, "activity_null");
        }
        try {
            m37(activity.getApplication());
            StringBuilder sb2 = new StringBuilder("getDeepLinkData with activity ");
            sb2.append(activity.getIntent().getDataString());
            AFLogger.afInfoLog(sb2.toString());
        } catch (Exception e2) {
            AFLogger.afInfoLog("getDeepLinkData Exception: ".concat(String.valueOf(e2)));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0174  */
    public void sendPushNotificationData(Activity activity) {
        String str;
        long j2;
        Activity activity2 = activity;
        String str2 = Constants.URL_CAMPAIGN;
        String str3 = Constants.URL_MEDIA_SOURCE;
        String str4 = "sendPushNotificationData";
        if (activity2 != null && activity.getIntent() != null) {
            s r8 = s.m191();
            StringBuilder sb = new StringBuilder("activity_intent_");
            sb.append(activity.getIntent().toString());
            r8.m199(str4, activity.getLocalClassName(), sb.toString());
        } else if (activity2 != null) {
            s.m191().m199(str4, activity.getLocalClassName(), "activity_intent_null");
        } else {
            s.m191().m199(str4, "activity_null");
        }
        if (activity2 instanceof Activity) {
            Intent intent = activity.getIntent();
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String str5 = "af";
                    str = extras.getString(str5);
                    if (str != null) {
                        AFLogger.afInfoLog("Push Notification received af payload = ".concat(String.valueOf(str)));
                        extras.remove(str5);
                        activity2.setIntent(intent.putExtras(extras));
                    }
                    this.f46 = str;
                    if (this.f46 != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        String str6 = ")";
                        if (this.f41 == null) {
                            AFLogger.afInfoLog("pushes: initializing pushes history..");
                            this.f41 = new ConcurrentHashMap();
                            j2 = currentTimeMillis;
                        } else {
                            try {
                                long j3 = AppsFlyerProperties.getInstance().getLong("pushPayloadMaxAging", 1800000);
                                j2 = currentTimeMillis;
                                for (Long l2 : this.f41.keySet()) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(this.f46);
                                        JSONObject jSONObject2 = new JSONObject((String) this.f41.get(l2));
                                        if (!jSONObject.get(str3).equals(jSONObject2.get(str3)) || !jSONObject.get(str2).equals(jSONObject2.get(str2))) {
                                            if (currentTimeMillis - l2.longValue() > j3) {
                                                this.f41.remove(l2);
                                            }
                                            if (l2.longValue() <= j2) {
                                                j2 = l2.longValue();
                                            }
                                            Activity activity3 = activity;
                                        } else {
                                            StringBuilder sb2 = new StringBuilder("PushNotificationMeasurement: A previous payload with same PID was already acknowledged! (old: ");
                                            sb2.append(jSONObject2);
                                            sb2.append(", new: ");
                                            sb2.append(jSONObject);
                                            sb2.append(str6);
                                            AFLogger.afInfoLog(sb2.toString());
                                            this.f46 = null;
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        StringBuilder sb3 = new StringBuilder("Error while handling push notification measurement: ");
                                        sb3.append(th.getClass().getSimpleName());
                                        AFLogger.afErrorLog(sb3.toString(), th);
                                        if (this.f41.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", 2)) {
                                        }
                                        this.f41.put(Long.valueOf(currentTimeMillis), this.f46);
                                        m37(activity.getApplication());
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                j2 = currentTimeMillis;
                                StringBuilder sb32 = new StringBuilder("Error while handling push notification measurement: ");
                                sb32.append(th.getClass().getSimpleName());
                                AFLogger.afErrorLog(sb32.toString(), th);
                                if (this.f41.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", 2)) {
                                }
                                this.f41.put(Long.valueOf(currentTimeMillis), this.f46);
                                m37(activity.getApplication());
                            }
                        }
                        if (this.f41.size() == AppsFlyerProperties.getInstance().getInt("pushPayloadHistorySize", 2)) {
                            StringBuilder sb4 = new StringBuilder("pushes: removing oldest overflowing push (oldest push:");
                            sb4.append(j2);
                            sb4.append(str6);
                            AFLogger.afInfoLog(sb4.toString());
                            this.f41.remove(Long.valueOf(j2));
                        }
                        this.f41.put(Long.valueOf(currentTimeMillis), this.f46);
                        m37(activity.getApplication());
                    }
                }
            }
        }
        str = null;
        this.f46 = str;
        if (this.f46 != null) {
        }
    }

    public void setAdditionalData(HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            s.m191().m199("setAdditionalData", hashMap.toString());
            AppsFlyerProperties.getInstance().setCustomData(new JSONObject(hashMap).toString());
        }
    }

    public void setAndroidIdData(String str) {
        s.m191().m199("setAndroidIdData", str);
        this.f45 = str;
    }

    public void setAppId(String str) {
        s.m191().m199("setAppId", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_ID, str);
    }

    public void setAppInviteOneLink(String str) {
        s.m191().m199("setAppInviteOneLink", str);
        AFLogger.afInfoLog("setAppInviteOneLink = ".concat(String.valueOf(str)));
        String str2 = AppsFlyerProperties.ONELINK_ID;
        if (str == null || !str.equals(AppsFlyerProperties.getInstance().getString(str2))) {
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_DOMAIN);
            AppsFlyerProperties.getInstance().remove("onelinkVersion");
            AppsFlyerProperties.getInstance().remove(AppsFlyerProperties.ONELINK_SCHEME);
        }
        AppsFlyerProperties.getInstance().set(str2, str);
    }

    @Deprecated
    public void setAppUserId(String str) {
        s.m191().m199("setAppUserId", str);
        setCustomerUserId(str);
    }

    public void setCollectAndroidID(boolean z) {
        s.m191().m199("setCollectAndroidID", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, Boolean.toString(z));
    }

    @Deprecated
    public void setCollectFingerPrint(boolean z) {
        s.m191().m199("setCollectFingerPrint", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_FINGER_PRINT, Boolean.toString(z));
    }

    public void setCollectIMEI(boolean z) {
        s.m191().m199("setCollectIMEI", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI, Boolean.toString(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, Boolean.toString(z));
    }

    public void setConsumeAFDeepLinks(boolean z) {
        AppsFlyerProperties.getInstance().set("consumeAfDeepLink", z);
        s.m191().m199("setConsumeAFDeepLinks: ".concat(String.valueOf(z)), new String[0]);
    }

    public void setCurrencyCode(String str) {
        s.m191().m199("setCurrencyCode", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.CURRENCY_CODE, str);
    }

    public void setCustomerIdAndTrack(String str, Context context) {
        if (context != null) {
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            String str2 = AppsFlyerProperties.AF_WAITFOR_CUSTOMERID;
            if (instance.getBoolean(str2, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
                setCustomerUserId(str);
                AppsFlyerProperties.getInstance().set(str2, false);
                StringBuilder sb = new StringBuilder("CustomerUserId set: ");
                sb.append(str);
                sb.append(" - Initializing AppsFlyer Tacking");
                AFLogger.afInfoLog(sb.toString(), true);
                String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
                String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                if (referrer == null) {
                    referrer = "";
                }
                m58(context, string, null, null, referrer, context instanceof Activity ? ((Activity) context).getIntent() : null, null);
                String str3 = "afUninstallToken";
                if (AppsFlyerProperties.getInstance().getString(str3) != null) {
                    m75(context, AppsFlyerProperties.getInstance().getString(str3));
                }
                return;
            }
            setCustomerUserId(str);
            AFLogger.afInfoLog("waitForCustomerUserId is false; setting CustomerUserID: ".concat(String.valueOf(str)), true);
        }
    }

    public void setCustomerUserId(String str) {
        s.m191().m199("setCustomerUserId", str);
        AFLogger.afInfoLog("setCustomerUserId = ".concat(String.valueOf(str)));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.APP_USER_ID, str);
    }

    public void setDebugLog(boolean z) {
        s.m191().m199("setDebugLog", String.valueOf(z));
        AppsFlyerProperties.getInstance().set("shouldLog", z);
        AppsFlyerProperties.getInstance().set("logLevel", (z ? LogLevel.DEBUG : LogLevel.NONE).getLevel());
    }

    /* access modifiers changed from: protected */
    public void setDeepLinkData(Intent intent) {
        if (intent != null) {
            try {
                if ("android.intent.action.VIEW".equals(intent.getAction())) {
                    this.latestDeepLink = intent.getData();
                    StringBuilder sb = new StringBuilder("Unity setDeepLinkData = ");
                    sb.append(this.latestDeepLink);
                    AFLogger.afDebugLog(sb.toString());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while setting deeplink data (unity). ", th);
            }
        }
    }

    public void setDeviceTrackingDisabled(boolean z) {
        s.m191().m199("setDeviceTrackingDisabled", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, z);
    }

    public void setExtension(String str) {
        s.m191().m199("setExtension", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EXTENSION, str);
    }

    @Deprecated
    public void setGCMProjectID(String str) {
        s.m191().m199("setGCMProjectID", str);
        AFLogger.afWarnLog("Method 'setGCMProjectNumber' is deprecated. Please follow the documentation.");
        enableUninstallTracking(str);
    }

    @Deprecated
    public void setGCMProjectNumber(String str) {
        s.m191().m199("setGCMProjectNumber", str);
        AFLogger.afWarnLog("Method 'setGCMProjectNumber' is deprecated. Please follow the documentation.");
        enableUninstallTracking(str);
    }

    public void setHost(String str, String str2) {
        if (str != null) {
            AppsFlyerProperties.getInstance().set("custom_host_prefix", str);
        }
        if (str2 == null || str2.isEmpty()) {
            AFLogger.afWarnLog("hostName cannot be null or empty");
        } else {
            AppsFlyerProperties.getInstance().set("custom_host", str2);
        }
    }

    @Deprecated
    public void setHostName(String str) {
        AppsFlyerProperties.getInstance().set("custom_host", str);
    }

    public void setImeiData(String str) {
        s.m191().m199("setImeiData", str);
        this.f54 = str;
    }

    public void setIsUpdate(boolean z) {
        s.m191().m199("setIsUpdate", String.valueOf(z));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.IS_UPDATE, z);
    }

    public void setLogLevel(LogLevel logLevel) {
        AppsFlyerProperties.getInstance().set("logLevel", logLevel.getLevel());
    }

    public void setMinTimeBetweenSessions(int i2) {
        this.f48 = TimeUnit.SECONDS.toMillis((long) i2);
    }

    public void setOutOfStore(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            AppsFlyerProperties.getInstance().set("api_store_value", lowerCase);
            AFLogger.afInfoLog("Store API set with value: ".concat(String.valueOf(lowerCase)), true);
            return;
        }
        AFLogger.m15("Cannot set setOutOfStore with null");
    }

    public void setPluginDeepLinkData(Intent intent) {
        setDeepLinkData(intent);
    }

    public void setPreinstallAttribution(String str, String str2, String str3) {
        AFLogger.afDebugLog("setPreinstallAttribution API called");
        JSONObject jSONObject = new JSONObject();
        String str4 = Constants.URL_MEDIA_SOURCE;
        if (str != null) {
            try {
                jSONObject.put(str4, str);
            } catch (JSONException e2) {
                AFLogger.afErrorLog(e2.getMessage(), e2);
            }
        }
        if (str2 != null) {
            jSONObject.put(Constants.URL_CAMPAIGN, str2);
        }
        if (str3 != null) {
            jSONObject.put(Constants.URL_SITE_ID, str3);
        }
        if (jSONObject.has(str4)) {
            AppsFlyerProperties.getInstance().set("preInstallName", jSONObject.toString());
            return;
        }
        AFLogger.afWarnLog("Cannot set preinstall attribution data without a media source");
    }

    public void setResolveDeepLinkURLs(String... strArr) {
        s.m191().m199("setResolveDeepLinkURLs", Arrays.asList(strArr).toString());
        AFDeepLinkManager.f1 = strArr;
    }

    @Deprecated
    public void setUserEmail(String str) {
        s.m191().m199("setUserEmail", str);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.USER_EMAIL, str);
    }

    public void setUserEmails(String... strArr) {
        s.m191().m199("setUserEmails", strArr);
        setUserEmails(EmailsCryptType.NONE, strArr);
    }

    public void startTracking(Application application) {
        if (!this.f52) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! The API call 'startTracking(Application)' must be called after the 'init(String, AppsFlyerConversionListener)' API method, which should be called on the Application's onCreate.");
        } else {
            startTracking(application, null);
        }
    }

    public void stopTracking(boolean z, Context context) {
        this.f50 = z;
        CacheManager.getInstance().clearCache(context);
        if (this.f50) {
            Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
            edit.putBoolean(IS_STOP_TRACKING_USED, true);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
                return;
            }
            edit.commit();
        }
    }

    public void trackAppLaunch(Context context, String str) {
        if (m42(context)) {
            if (this.f55 == null) {
                this.f55 = new e();
                this.f55.m124(context, this);
            } else {
                AFLogger.afWarnLog("AFInstallReferrer instance already created");
            }
        }
        m58(context, str, null, null, "", null, null);
    }

    public void trackEvent(Context context, String str, Map<String, Object> map) {
        s.m191().m199("trackEvent", str, new JSONObject(map == null ? new HashMap<>() : map).toString());
        m73(context, str, map);
    }

    public void trackLocation(Context context, double d2, double d3) {
        s.m191().m199("trackLocation", String.valueOf(d2), String.valueOf(d3));
        HashMap hashMap = new HashMap();
        hashMap.put(AFInAppEventParameterName.LONGTITUDE, Double.toString(d3));
        hashMap.put(AFInAppEventParameterName.LATITUDE, Double.toString(d2));
        m73(context, AFInAppEventType.LOCATION_COORDINATES, (Map<String, Object>) hashMap);
    }

    public void unregisterConversionListener() {
        s.m191().m199("unregisterConversionListener", new String[0]);
        f35 = null;
    }

    public void updateServerUninstallToken(Context context, String str) {
        if (str != null) {
            y.m228(context, new b(str));
        }
    }

    public void validateAndTrackInAppPurchase(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Context context2 = context;
        String str6 = str3;
        String str7 = str4;
        String str8 = str5;
        s r1 = s.m191();
        String[] strArr = new String[6];
        strArr[0] = str;
        strArr[1] = str2;
        strArr[2] = str6;
        strArr[3] = str7;
        strArr[4] = str8;
        strArr[5] = map == null ? "" : map.toString();
        r1.m199("validateAndTrackInAppPurchase", strArr);
        if (!isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("Validate in app called with parameters: ");
            sb.append(str6);
            String str9 = " ";
            sb.append(str9);
            sb.append(str7);
            sb.append(str9);
            sb.append(str8);
            AFLogger.afInfoLog(sb.toString());
        }
        if (str == null || str7 == null || str2 == null || str8 == null || str6 == null) {
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = f32;
            if (appsFlyerInAppPurchaseValidatorListener != null) {
                appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure("Please provide purchase parameters");
                return;
            }
            return;
        }
        ScheduledThreadPoolExecutor r10 = AFExecutor.getInstance().m4();
        j jVar = new j(context.getApplicationContext(), AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY), str, str2, str3, str4, str5, map, context2 instanceof Activity ? ((Activity) context2).getIntent() : null);
        m40((ScheduledExecutorService) r10, (Runnable) jVar, 10, TimeUnit.MILLISECONDS);
    }

    public void waitForCustomerUserId(boolean z) {
        AFLogger.afInfoLog("initAfterCustomerUserID: ".concat(String.valueOf(z)), true);
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, z);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static /* synthetic */ void m67(AppsFlyerLib appsFlyerLib, Context context, String str, String str2, String str3, String str4, boolean z, boolean z2, Intent intent, String str5) {
        ScheduledExecutorService scheduledExecutorService;
        AppsFlyerLib appsFlyerLib2 = appsFlyerLib;
        if (context == null) {
            AFLogger.afDebugLog("sendTrackingWithEvent - got null context. skipping event/launch.");
            return;
        }
        int i2 = 0;
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
        AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
        if (!appsFlyerLib.isTrackingStopped()) {
            StringBuilder sb = new StringBuilder("sendTrackingWithEvent from activity: ");
            sb.append(context.getClass().getName());
            AFLogger.afInfoLog(sb.toString());
        }
        boolean z3 = true;
        boolean z4 = str2 == null;
        Map r1 = appsFlyerLib.m74(context, str, str2, str3, str4, z, sharedPreferences, z4, intent, str5);
        String str6 = (String) r1.get("appsflyerKey");
        if (str6 == null || str6.length() == 0) {
            AFLogger.afDebugLog("Not sending data yet, waiting for dev key");
            return;
        }
        if (!appsFlyerLib.isTrackingStopped()) {
            AFLogger.afInfoLog("AppsFlyerLib.sendTrackingWithEvent");
        }
        String str7 = z4 ? z2 ? f29 : f25 : f27;
        String url = ServerConfigHandler.getUrl(str7);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(url);
        sb2.append(context.getPackageName());
        String sb3 = sb2.toString();
        int r3 = m43(sharedPreferences, "appsFlyerCount", false);
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false)) && r1.get(ServerParameters.ADVERTISING_ID_PARAM) != null) {
            try {
                if (TextUtils.isEmpty(appsFlyerLib2.f45) && r1.remove("android_id") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: android_id");
                }
                if (TextUtils.isEmpty(appsFlyerLib2.f54) && r1.remove("imei") != null) {
                    AFLogger.afInfoLog("validateGaidAndIMEI :: removing: imei");
                }
            } catch (Exception e2) {
                AFLogger.afErrorLog("failed to remove IMEI or AndroidID key from params; ", e2);
            }
        }
        b bVar = new b(appsFlyerLib, sb3, r1, context.getApplicationContext(), z4, r3, 0);
        if (z4 && m42(context)) {
            Map<String, String> map = appsFlyerLib2.f59;
            if (map == null || map.size() <= 0) {
                z3 = false;
            }
            if (!z3) {
                i2 = 500;
                AFLogger.afDebugLog("Failed to get new referrer, wait ...");
            }
        }
        if (AFDeepLinkManager.f5) {
            AFLogger.afRDLog("ESP deeplink: execute launch on SerialExecutor");
            scheduledExecutorService = AFExecutor.getInstance().getSerialExecutor();
        } else {
            scheduledExecutorService = AFExecutor.getInstance().m4();
        }
        m40(scheduledExecutorService, (Runnable) bVar, (long) i2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static /* synthetic */ void m68(AppsFlyerLib appsFlyerLib, String str, String str2, String str3, WeakReference weakReference, String str4, boolean z) throws IOException {
        String str5 = str;
        URL url = new URL(str5);
        StringBuilder sb = new StringBuilder("url: ");
        sb.append(url.toString());
        AFLogger.afInfoLog(sb.toString());
        a.m141("data: ".concat(String.valueOf(str2)));
        Context context = (Context) weakReference.get();
        String str6 = LOG_TAG;
        m39(context, str6, "EVENT_DATA", str2);
        try {
            appsFlyerLib.m60(url, str2, str3, weakReference, str4, z);
        } catch (IOException e2) {
            IOException iOException = e2;
            AFLogger.afErrorLog("Exception in sendRequestToServer. ", iOException);
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.USE_HTTP_FALLBACK, false)) {
                appsFlyerLib.m60(new URL(str5.replace("https:", "http:")), str2, str3, weakReference, str4, z);
                return;
            }
            StringBuilder sb2 = new StringBuilder("failed to send requeset to server. ");
            sb2.append(iOException.getLocalizedMessage());
            AFLogger.afInfoLog(sb2.toString());
            m39((Context) weakReference.get(), str6, "ERROR", iOException.getLocalizedMessage());
            throw iOException;
        }
    }

    public void setUserEmails(EmailsCryptType emailsCryptType, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length + 1);
        arrayList.add(emailsCryptType.toString());
        arrayList.addAll(Arrays.asList(strArr));
        s.m191().m199("setUserEmails", (String[]) arrayList.toArray(new String[(strArr.length + 1)]));
        AppsFlyerProperties.getInstance().set(AppsFlyerProperties.EMAIL_CRYPT_TYPE, emailsCryptType.getValue());
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        String str = null;
        for (String str2 : strArr) {
            int i2 = AnonymousClass5.f66[emailsCryptType.ordinal()];
            if (i2 == 2) {
                arrayList2.add(p.m178(str2));
                str = "md5_el_arr";
            } else if (i2 == 3) {
                arrayList2.add(p.m177(str2));
                str = "sha256_el_arr";
            } else if (i2 != 4) {
                arrayList2.add(p.m175(str2));
                str = "sha1_el_arr";
            } else {
                arrayList2.add(str2);
                str = "plain_el_arr";
            }
        }
        hashMap.put(str, arrayList2);
        AppsFlyerProperties.getInstance().setUserEmails(new JSONObject(hashMap).toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˊ reason: contains not printable characters */
    public final void m73(Context context, String str, Map<String, Object> map) {
        String str2;
        Intent intent;
        String str3 = "";
        Uri uri = null;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Intent intent2 = activity.getIntent();
            AFDeepLinkManager.getInstance().currentActivityHash = System.identityHashCode(activity);
            try {
                uri = androidx.core.app.b.c(activity);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
            str2 = uri != null ? uri.toString() : str3;
            intent = intent2;
        } else {
            str2 = str3;
            intent = null;
        }
        if (AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY) == null) {
            AFLogger.afWarnLog("[TrackEvent/Launch] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        JSONObject jSONObject = new JSONObject(map);
        String referrer = AppsFlyerProperties.getInstance().getReferrer(context);
        m58(context, null, str, jSONObject.toString(), referrer == null ? str3 : referrer, intent, str2);
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static void m41(JSONObject jSONObject) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator keys = jSONObject.keys();
        while (true) {
            if (!keys.hasNext()) {
                break;
            }
            try {
                JSONArray jSONArray = new JSONArray((String) jSONObject.get((String) keys.next()));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
                }
            } catch (JSONException unused) {
            }
        }
        Collections.sort(arrayList);
        Iterator keys2 = jSONObject.keys();
        loop2:
        while (true) {
            str = null;
            while (keys2.hasNext() && str == null) {
                String str2 = (String) keys2.next();
                try {
                    JSONArray jSONArray2 = new JSONArray((String) jSONObject.get(str2));
                    String str3 = str;
                    int i3 = 0;
                    while (i3 < jSONArray2.length()) {
                        try {
                            if (jSONArray2.getLong(i3) != ((Long) arrayList.get(0)).longValue() && jSONArray2.getLong(i3) != ((Long) arrayList.get(1)).longValue() && jSONArray2.getLong(i3) != ((Long) arrayList.get(arrayList.size() - 1)).longValue()) {
                                i3++;
                                str3 = str2;
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                    str = str3;
                } catch (JSONException unused3) {
                }
            }
        }
        if (str != null) {
            jSONObject.remove(str);
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static /* synthetic */ boolean m70(AppsFlyerLib appsFlyerLib) {
        Map<String, String> map = appsFlyerLib.f59;
        return map != null && map.size() > 0;
    }

    @Deprecated
    public void setGCMProjectNumber(Context context, String str) {
        s.m191().m199("setGCMProjectNumber", str);
        AFLogger.afWarnLog("Method 'setGCMProjectNumber' is deprecated. Please use 'enableUninstallTracking'.");
        enableUninstallTracking(str);
    }

    public void startTracking(Application application, String str) {
        startTracking(application, str, null);
    }

    public void startTracking(Application application, String str, AppsFlyerTrackingRequestListener appsFlyerTrackingRequestListener) {
        s.m191().m199("startTracking", str);
        AFLogger.afInfoLog(String.format("Starting AppsFlyer Tracking: (v%s.%s)", new Object[]{BuildConfig.VERSION_NAME, "184"}));
        AFLogger.afInfoLog("Build Number: 184");
        AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = AppsFlyerProperties.AF_KEY;
        if (!isEmpty) {
            AppsFlyerProperties.getInstance().set(str2, str);
            a.m142(str);
        } else if (TextUtils.isEmpty(AppsFlyerProperties.getInstance().getString(str2))) {
            AFLogger.afWarnLog("ERROR: AppsFlyer SDK is not initialized! You must provide AppsFlyer Dev-Key either in the 'init' API method (should be called on Application's onCreate),or in the startTracking API method (should be called on Activity's onCreate).");
            return;
        }
        if (appsFlyerTrackingRequestListener != null) {
            f26 = appsFlyerTrackingRequestListener;
        }
        m37(application);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m76() {
        this.f40 = System.currentTimeMillis();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m78() {
        this.f38 = System.currentTimeMillis();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˎ reason: contains not printable characters */
    public final void m75(Context context, String str) {
        boolean z = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false);
        String str2 = AppsFlyerProperties.APP_USER_ID;
        if (z && AppsFlyerProperties.getInstance().getString(str2) == null) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        HashMap hashMap = new HashMap();
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string == null) {
            AFLogger.afWarnLog("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
            hashMap.put("app_version_name", packageInfo.versionName);
            hashMap.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j2 = packageInfo.firstInstallTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            hashMap.put("installDate", simpleDateFormat.format(new Date(j2)));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Exception while collecting application version info.", th);
        }
        m59(context, (Map<String, ? super String>) hashMap);
        String string2 = AppsFlyerProperties.getInstance().getString(str2);
        if (string2 != null) {
            hashMap.put("appUserId", string2);
        }
        try {
            hashMap.put("model", Build.MODEL);
            hashMap.put("brand", Build.BRAND);
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
        }
        AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
        String str3 = AppsFlyerProperties.DEVICE_TRACKING_DISABLED;
        if (instance.getBoolean(str3, false)) {
            hashMap.put(str3, "true");
        }
        l r2 = n.m169(context.getContentResolver());
        if (r2 != null) {
            hashMap.put("amazon_aid", r2.m156());
            hashMap.put("amazon_aid_limit", String.valueOf(r2.m157()));
        }
        AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
        String str4 = ServerParameters.ADVERTISING_ID_PARAM;
        String string3 = instance2.getString(str4);
        if (string3 != null) {
            hashMap.put(str4, string3);
        }
        hashMap.put("devkey", string);
        hashMap.put("uid", C0280r.m186(new WeakReference(context)));
        hashMap.put("af_gcm_token", str);
        hashMap.put("launch_counter", Integer.toString(m43(context.getApplicationContext().getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false)));
        hashMap.put("sdk", Integer.toString(VERSION.SDK_INT));
        String r13 = m33(new WeakReference<>(context));
        if (r13 != null) {
            hashMap.put(AppsFlyerProperties.CHANNEL, r13);
        }
        try {
            o oVar = new o(context, isTrackingStopped());
            oVar.f196 = hashMap;
            StringBuilder sb = new StringBuilder();
            sb.append(ServerConfigHandler.getUrl(f30));
            sb.append(packageName);
            oVar.execute(new String[]{sb.toString()});
        } catch (Throwable th3) {
            AFLogger.afErrorLog(th3.getMessage(), th3);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ˏ reason: contains not printable characters */
    public final void m77(WeakReference<Context> weakReference) {
        if (weakReference.get() != null) {
            AFLogger.afInfoLog("app went to background");
            SharedPreferences sharedPreferences = ((Context) weakReference.get()).getApplicationContext().getSharedPreferences("appsflyer-data", 0);
            AppsFlyerProperties.getInstance().saveProperties(sharedPreferences);
            long j2 = this.f38 - this.f40;
            HashMap hashMap = new HashMap();
            String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
            if (string == null) {
                AFLogger.afWarnLog("[callStats] AppsFlyer's SDK cannot send any event without providing DevKey.");
                return;
            }
            String string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
            AppsFlyerProperties instance = AppsFlyerProperties.getInstance();
            String str = AppsFlyerProperties.DEVICE_TRACKING_DISABLED;
            if (instance.getBoolean(str, false)) {
                hashMap.put(str, "true");
            }
            l r7 = n.m169(((Context) weakReference.get()).getContentResolver());
            if (r7 != null) {
                hashMap.put("amazon_aid", r7.m156());
                hashMap.put("amazon_aid_limit", String.valueOf(r7.m157()));
            }
            AppsFlyerProperties instance2 = AppsFlyerProperties.getInstance();
            String str2 = ServerParameters.ADVERTISING_ID_PARAM;
            String string3 = instance2.getString(str2);
            if (string3 != null) {
                hashMap.put(str2, string3);
            }
            hashMap.put("app_id", ((Context) weakReference.get()).getPackageName());
            hashMap.put("devkey", string);
            hashMap.put("uid", C0280r.m186(weakReference));
            hashMap.put("time_in_app", String.valueOf(j2 / 1000));
            hashMap.put("statType", "user_closed_app");
            hashMap.put("platform", "Android");
            hashMap.put("launch_counter", Integer.toString(m43(sharedPreferences, "appsFlyerCount", false)));
            hashMap.put(AppsFlyerProperties.CHANNEL, m33(weakReference));
            if (string2 == null) {
                string2 = "";
            }
            hashMap.put("originalAppsflyerId", string2);
            if (this.f49) {
                try {
                    o oVar = new o(null, isTrackingStopped());
                    oVar.f196 = hashMap;
                    String str3 = "https://%sstats.%s/stats";
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        AFLogger.afDebugLog("Main thread detected. Running callStats task in a new thread.");
                        oVar.execute(new String[]{ServerConfigHandler.getUrl(str3)});
                        return;
                    }
                    StringBuilder sb = new StringBuilder("Running callStats task (on current thread: ");
                    sb.append(Thread.currentThread().toString());
                    sb.append(" )");
                    AFLogger.afDebugLog(sb.toString());
                    oVar.onPreExecute();
                    oVar.onPostExecute(oVar.doInBackground(ServerConfigHandler.getUrl(str3)));
                } catch (Throwable th) {
                    AFLogger.afErrorLog("Could not send callStats request", th);
                }
            } else {
                AFLogger.afDebugLog("Stats call is disabled, ignore ...");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ॱ reason: contains not printable characters */
    public final void m79(Context context, Intent intent) {
        String str = AppsFlyerProperties.IS_MONITOR;
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            AFLogger.afInfoLog("Turning on monitoring.");
            AppsFlyerProperties.getInstance().set(str, stringExtra.equals("true"));
            m39(context, (String) null, "START_TRACKING", context.getPackageName());
            return;
        }
        AFLogger.afInfoLog("****** onReceive called *******");
        AppsFlyerProperties.getInstance().setOnReceiveCalled();
        String str2 = "referrer";
        String stringExtra2 = intent.getStringExtra(str2);
        AFLogger.afInfoLog("Play store referrer: ".concat(String.valueOf(stringExtra2)));
        if (stringExtra2 != null) {
            String str3 = "appsflyer-data";
            if ("AppsFlyer_Test".equals(intent.getStringExtra("TestIntegrationMode"))) {
                Editor edit = context.getApplicationContext().getSharedPreferences(str3, 0).edit();
                edit.clear();
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                AppsFlyerProperties.getInstance().setFirstLaunchCalled(false);
                AFLogger.afInfoLog("Test mode started..");
                this.f44 = System.currentTimeMillis();
            }
            Editor edit2 = context.getApplicationContext().getSharedPreferences(str3, 0).edit();
            edit2.putString(str2, stringExtra2);
            if (VERSION.SDK_INT >= 9) {
                edit2.apply();
            } else {
                edit2.commit();
            }
            AppsFlyerProperties.getInstance().setReferrer(stringExtra2);
            if (AppsFlyerProperties.getInstance().isFirstLaunchCalled()) {
                AFLogger.afInfoLog("onReceive: isLaunchCalled");
                if (stringExtra2 != null && stringExtra2.length() > 5) {
                    ScheduledThreadPoolExecutor r0 = AFExecutor.getInstance().m4();
                    a aVar = new a(this, new WeakReference(context.getApplicationContext()), null, null, null, stringExtra2, true, intent, null, 0);
                    m40((ScheduledExecutorService) r0, (Runnable) aVar, 5, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public AppsFlyerLib init(String str, AppsFlyerConversionListener appsFlyerConversionListener, Context context) {
        if (context == null) {
            AFLogger.afWarnLog("init :: context is null, Google Install Referrer will be not initialized!");
        } else if (m42(context)) {
            if (this.f55 == null) {
                this.f55 = new e();
                this.f55.m124(context, this);
            } else {
                AFLogger.afWarnLog("AFInstallReferrer instance already created");
            }
        }
        return init(str, appsFlyerConversionListener);
    }

    /* renamed from: ˊ reason: contains not printable characters */
    private static void m27(Context context, String str) {
        Intent intent = new Intent("com.appsflyer.testIntgrationBroadcast");
        intent.putExtra("params", str);
        if (VERSION.SDK_INT >= 26) {
            String str2 = "com.appsflyer.referrerSender";
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).toString().contains(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setComponent(new ComponentName(str2, "com.appsflyer.referrerSender.Receiver"));
                context.sendBroadcast(intent2);
            }
            return;
        }
        context.sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ reason: contains not printable characters */
    public static Map<String, String> m25(Context context) throws k {
        String string = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).getString("attributionId", null);
        if (string != null && string.length() > 0) {
            return m35(string);
        }
        throw new k();
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private void m37(Application application) {
        AppsFlyerProperties.getInstance().loadProperties(application.getApplicationContext());
        int i2 = VERSION.SDK_INT;
        if (i2 < 14) {
            AFLogger.afInfoLog("SDK<14 call trackEvent manually");
            AFLogger.afInfoLog("onBecameForeground");
            getInstance().f40 = System.currentTimeMillis();
            getInstance().m73((Context) application, (String) null, null);
            AFLogger.resetDeltaTime();
        } else if (i2 >= 14 && this.f39 == null) {
            m.m161();
            this.f39 = new d() {
                /* renamed from: ˊ reason: contains not printable characters */
                public final void m83(Activity activity) {
                    if (2 > AppsFlyerLib.m23(AppsFlyerLib.m44((Context) activity))) {
                        i r0 = i.m147(activity);
                        r0.f157.post(r0.f155);
                        r0.f157.post(r0.f160);
                    }
                    AFLogger.afInfoLog("onBecameForeground");
                    AppsFlyerLib.getInstance().m76();
                    AppsFlyerLib.getInstance().m73((Context) activity, (String) null, null);
                    AFLogger.resetDeltaTime();
                }

                /* renamed from: ˊ reason: contains not printable characters */
                public final void m84(WeakReference<Context> weakReference) {
                    AnonymousClass3.m1((Context) weakReference.get());
                    i r2 = i.m147((Context) weakReference.get());
                    r2.f157.post(r2.f155);
                }
            };
            m.m162().m164(application, this.f39);
        }
    }

    /* renamed from: ˊ reason: contains not printable characters */
    private boolean m30() {
        if (this.f58 > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f58;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS Z", Locale.US);
            long j2 = this.f58;
            String str = "UTC";
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
            String format = simpleDateFormat.format(new Date(j2));
            long j3 = this.f53;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
            String format2 = simpleDateFormat.format(new Date(j3));
            if (currentTimeMillis < this.f48 && !isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nThis launch is blocked: %s ms < %s ms", new Object[]{format, format2, Long.valueOf(currentTimeMillis), Long.valueOf(this.f48)}));
                return true;
            } else if (!isTrackingStopped()) {
                AFLogger.afInfoLog(String.format(Locale.US, "Last Launch attempt: %s;\nLast successful Launch event: %s;\nSending launch (+%s ms)", new Object[]{format, format2, Long.valueOf(currentTimeMillis)}));
            }
        } else if (!isTrackingStopped()) {
            AFLogger.afInfoLog("Sending first launch for this session!");
        }
        return false;
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static boolean m42(Context context) {
        if (m43(context.getApplicationContext().getSharedPreferences("appsflyer-data", 0), "appsFlyerCount", false) > 2) {
            AFLogger.afRDLog("Install referrer will not load, the counter > 2, ");
            return false;
        }
        try {
            Class.forName("c.a.a.a.b");
            if (AnonymousClass5.m5(context, "com.google.android.finsky.permission.BIND_GET_INSTALL_REFERRER_SERVICE")) {
                AFLogger.afDebugLog("Install referrer is allowed");
                return true;
            }
            AFLogger.afDebugLog("Install referrer is not allowed");
            return false;
        } catch (ClassNotFoundException unused) {
            AFLogger.afRDLog("Class com.android.installreferrer.api.InstallReferrerClient not found");
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog("An error occurred while trying to verify manifest : com.android.installreferrer.api.InstallReferrerClient", th);
            return false;
        }
    }

    /* renamed from: ˊ reason: contains not printable characters */
    static int m23(SharedPreferences sharedPreferences) {
        return m43(sharedPreferences, "appsFlyerCount", false);
    }

    /* renamed from: ॱ reason: contains not printable characters */
    static void m66(Context context, String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        String str2 = "extraReferrers";
        String str3 = "appsflyer-data";
        AFLogger.afDebugLog("received a new (extra) referrer: ".concat(String.valueOf(str)));
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String string = context.getApplicationContext().getSharedPreferences(str3, 0).getString(str2, null);
            if (string == null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                jSONObject = jSONObject2;
                jSONArray = jSONArray2;
            } else {
                jSONObject = new JSONObject(string);
                if (jSONObject.has(str)) {
                    jSONArray = new JSONArray((String) jSONObject.get(str));
                } else {
                    jSONArray = new JSONArray();
                }
            }
            if (((long) jSONArray.length()) < 5) {
                jSONArray.put(currentTimeMillis);
            }
            if (((long) jSONObject.length()) >= 4) {
                m41(jSONObject);
            }
            jSONObject.put(str, jSONArray.toString());
            String jSONObject3 = jSONObject.toString();
            Editor edit = context.getApplicationContext().getSharedPreferences(str3, 0).edit();
            edit.putString(str2, jSONObject3);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Couldn't save referrer - ");
            sb.append(str);
            sb.append(": ");
            AFLogger.afErrorLog(sb.toString(), th);
        }
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static void m39(Context context, String str, String str2, String str3) {
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.IS_MONITOR, false)) {
            Intent intent = new Intent("com.appsflyer.MonitorBroadcast");
            intent.setPackage("com.appsflyer.nightvision");
            intent.putExtra(Object.MESSAGE, str2);
            intent.putExtra("value", str3);
            intent.putExtra("packageName", "true");
            intent.putExtra(Constants.URL_MEDIA_SOURCE, new Integer(Process.myPid()));
            intent.putExtra("eventIdentifier", str);
            intent.putExtra("sdk", BuildConfig.VERSION_NAME);
            context.sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private void m58(Context context, String str, String str2, String str3, String str4, Intent intent, String str5) {
        Context applicationContext = context.getApplicationContext();
        boolean z = false;
        boolean z2 = str2 == null;
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false) && AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID) == null) {
            z = true;
        }
        if (z) {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        if (z2) {
            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.LAUNCH_PROTECT_ENABLED, true)) {
                AFLogger.afInfoLog("Allowing multiple launches within a 5 second time window.");
            } else if (m30()) {
                return;
            }
            this.f58 = System.currentTimeMillis();
        }
        ScheduledThreadPoolExecutor r1 = AFExecutor.getInstance().m4();
        a aVar = new a(this, new WeakReference(applicationContext), str, str2, str3, str4, false, intent, str5, 0);
        m40((ScheduledExecutorService) r1, (Runnable) aVar, 150, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0305 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0318 A[Catch:{ Exception -> 0x031e }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x034b A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0374 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x037c A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x039b A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x03b7 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03ee A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0402 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x040e A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0416 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0422 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x042a A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0436 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0445 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0446 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0461 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0470 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x047f A[SYNTHETIC, Splitter:B:197:0x047f] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0495 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04aa A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x04bb A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04c1 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04d8 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04f0 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0507 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0535 A[Catch:{ Exception -> 0x00b4, Throwable -> 0x0be6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0554 A[SYNTHETIC, Splitter:B:233:0x0554] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0586 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x058c A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x059f  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x05a8 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0611  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x0620 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x062b A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x063a A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0650 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x065b A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0674 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:323:0x06c0 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x06c6 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x06d1 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x06e1 A[Catch:{ Exception -> 0x06e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x079b A[Catch:{ Throwable -> 0x083a }] */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x07ff A[Catch:{ Throwable -> 0x0838 }] */
    /* JADX WARNING: Removed duplicated region for block: B:392:0x084d A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:395:0x085d A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x086e A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0898 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x08a3 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x08d3 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:413:0x08fe A[ADDED_TO_REGION, Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x090d A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0938 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:428:0x095e A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:438:0x09be A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:439:0x09c0 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x09e7 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x09f7 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x09f8 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x0a33 A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0b9e A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:475:0x0bba A[Catch:{ NameNotFoundException -> 0x057a, Throwable -> 0x056d, Throwable -> 0x0be4 }] */
    /* renamed from: ˎ reason: contains not printable characters */
    public final Map<String, Object> m74(Context context, String str, String str2, String str3, String str4, boolean z, SharedPreferences sharedPreferences, boolean z2, Intent intent, String str5) {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String string;
        String string2;
        String string3;
        String string4;
        String r1;
        String r3;
        SharedPreferences sharedPreferences2;
        String str11;
        String str12;
        String str13;
        String string5;
        String r12;
        String str14;
        String string6;
        String string7;
        String str15;
        String string8;
        String string9;
        String str16;
        AppsFlyerLib appsFlyerLib;
        String str17;
        SimpleDateFormat simpleDateFormat;
        String str18;
        SharedPreferences sharedPreferences3;
        String string10;
        String string11;
        boolean z3;
        long currentTimeMillis;
        String referrer;
        l r32;
        String referrer2;
        boolean equals;
        boolean z4;
        PackageInfo packageInfo;
        String string12;
        String r5;
        String str19;
        boolean z5;
        String str20;
        String str21;
        String str22;
        String string13;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        String installerPackageName;
        int i2;
        Context context2 = context;
        String str23 = str;
        String str24 = str2;
        String str25 = str3;
        SharedPreferences sharedPreferences4 = sharedPreferences;
        boolean z10 = z2;
        String str26 = AppsFlyerProperties.APP_ID;
        String str27 = "INSTALL_STORE";
        String str28 = "prev_event_name";
        String str29 = "preInstallName";
        HashMap hashMap = new HashMap();
        n.m168(context2, hashMap);
        long time = new Date().getTime();
        String str30 = "af_timestamp";
        hashMap.put(str30, Long.toString(time));
        String r13 = a.m104(context2, time);
        if (r13 != null) {
            hashMap.put("cksm_v1", r13);
        }
        try {
            if (!isTrackingStopped()) {
                StringBuilder sb = new StringBuilder("******* sendTrackingWithEvent: ");
                sb.append(z10 ? "Launch" : str24);
                AFLogger.afInfoLog(sb.toString());
            } else {
                AFLogger.afInfoLog("SDK tracking has been stopped");
            }
            m39(context2, LOG_TAG, "EVENT_CREATED_WITH_NAME", z10 ? "Launch" : str24);
            CacheManager.getInstance().init(context2);
            List asList = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE).requestedPermissions);
            if (!asList.contains("android.permission.INTERNET")) {
                AFLogger.afWarnLog("Permission android.permission.INTERNET is missing in the AndroidManifest.xml");
                m39(context2, (String) null, "PERMISSION_INTERNET_MISSING", (String) null);
            }
            if (!asList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                AFLogger.afWarnLog("Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml");
            }
            if (!asList.contains("android.permission.ACCESS_WIFI_STATE")) {
                AFLogger.afWarnLog("Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml");
            }
        } catch (Exception e2) {
            AFLogger.afErrorLog("Exception while validation permissions. ", e2);
        } catch (Throwable th) {
            th = th;
            Throwable th2 = th;
            AFLogger.afErrorLog(th2.getLocalizedMessage(), th2);
            return hashMap;
        }
        if (z) {
            hashMap.put("af_events_api", "1");
        }
        hashMap.put("brand", Build.BRAND);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("product", Build.PRODUCT);
        hashMap.put("sdk", Integer.toString(VERSION.SDK_INT));
        hashMap.put("model", Build.MODEL);
        hashMap.put("deviceType", Build.TYPE);
        String str31 = "appsFlyerCount";
        String str32 = "appsflyer-data";
        if (z10) {
            if (!context.getApplicationContext().getSharedPreferences(str32, 0).contains(str31)) {
                if (!AppsFlyerProperties.getInstance().isOtherSdkStringDisabled()) {
                    hashMap.put("batteryLevel", String.valueOf(m22(context)));
                }
                if ("OPPO".equals(Build.BRAND)) {
                    i2 = 23;
                    AFLogger.afRDLog("OPPO device found");
                } else {
                    i2 = 18;
                }
                if (VERSION.SDK_INT >= i2) {
                    str10 = str30;
                    if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DISABLE_KEYSTORE, false)) {
                        StringBuilder sb2 = new StringBuilder("OS SDK is=");
                        sb2.append(VERSION.SDK_INT);
                        sb2.append("; use KeyStore");
                        AFLogger.afRDLog(sb2.toString());
                        AFKeystoreWrapper aFKeystoreWrapper = new AFKeystoreWrapper(context2);
                        if (!aFKeystoreWrapper.m11()) {
                            aFKeystoreWrapper.m13(C0280r.m186(new WeakReference(context2)));
                        } else {
                            aFKeystoreWrapper.m9();
                        }
                        AppsFlyerProperties.getInstance().set("KSAppsFlyerId", aFKeystoreWrapper.m12());
                        AppsFlyerProperties.getInstance().set("KSAppsFlyerRICounter", String.valueOf(aFKeystoreWrapper.m10()));
                    }
                } else {
                    str10 = str30;
                }
                StringBuilder sb3 = new StringBuilder("OS SDK is=");
                sb3.append(VERSION.SDK_INT);
                sb3.append("; no KeyStore usage");
                AFLogger.afRDLog(sb3.toString());
            } else {
                str10 = str30;
            }
            String str33 = "timepassedsincelastlaunch";
            String str34 = str26;
            str9 = str27;
            long j2 = context.getApplicationContext().getSharedPreferences(str32, 0).getLong("AppsFlyerTimePassedSincePrevLaunch", 0);
            long currentTimeMillis2 = System.currentTimeMillis();
            m52(context2, "AppsFlyerTimePassedSincePrevLaunch", currentTimeMillis2);
            hashMap.put(str33, Long.toString(j2 > 0 ? (currentTimeMillis2 - j2) / 1000 : -1));
            String string14 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_ID);
            if (string14 != null) {
                hashMap.put("onelink_id", string14);
                hashMap.put("ol_ver", AppsFlyerProperties.getInstance().getString("onelinkVersion"));
            }
            long j3 = sharedPreferences4.getLong("appsflyerGetConversionDataTiming", 0);
            if (j3 > 0) {
                hashMap.put("gcd_timing", Long.toString(j3));
                Editor edit = sharedPreferences.edit();
                edit.putLong("appsflyerGetConversionDataTiming", 0);
                if (VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
            }
            str7 = str31;
            str6 = str32;
            str8 = str34;
        } else {
            str10 = str30;
            String str35 = str26;
            str9 = str27;
            SharedPreferences sharedPreferences5 = context.getApplicationContext().getSharedPreferences(str32, 0);
            Editor edit2 = sharedPreferences5.edit();
            try {
                String string15 = sharedPreferences5.getString(str28, null);
                String str36 = "prev_event_timestamp";
                str8 = str35;
                String str37 = "prev_event_value";
                if (string15 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        StringBuilder sb4 = new StringBuilder();
                        str7 = str31;
                        str6 = str32;
                        try {
                            sb4.append(sharedPreferences5.getLong(str36, -1));
                            jSONObject.put(str36, sb4.toString());
                            jSONObject.put(str37, sharedPreferences5.getString(str37, null));
                            jSONObject.put(str28, string15);
                            hashMap.put("prev_event", jSONObject.toString());
                        } catch (Exception e3) {
                            e = e3;
                            AFLogger.afErrorLog("Error while processing previous event.", e);
                            string = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
                            string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
                            hashMap.put("reinstallCounter", string2);
                            hashMap.put("originalAppsflyerId", string);
                            string3 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
                            if (string3 != null) {
                            }
                            installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                            if (installerPackageName != null) {
                            }
                            string4 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.EXTENSION);
                            hashMap.put(AppsFlyerProperties.EXTENSION, string4);
                            r1 = m33(new WeakReference<>(context2));
                            r3 = m72(context2, r1);
                            if (r3 != null) {
                            }
                            hashMap.put("af_latestchannel", r1);
                            String str38 = str6;
                            sharedPreferences2 = context.getApplicationContext().getSharedPreferences(str38, 0);
                            str11 = str9;
                            if (!sharedPreferences2.contains(str11)) {
                            }
                            if (str13 != null) {
                            }
                            SharedPreferences sharedPreferences6 = context.getApplicationContext().getSharedPreferences(str38, 0);
                            string5 = AppsFlyerProperties.getInstance().getString(str29);
                            if (string5 == null) {
                            }
                            if (string5 != null) {
                            }
                            r12 = m21(context);
                            if (r12 != null) {
                            }
                            String str39 = "appsflyerKey";
                            str14 = str;
                            if (str14 != null) {
                            }
                            string13 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                            if (string13 != null) {
                            }
                            AFLogger.afInfoLog("AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ");
                            m39(context2, LOG_TAG, "DEV_KEY_MISSING", (String) null);
                            AFLogger.afInfoLog("AppsFlyer will not track this event.");
                            return null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str7 = str31;
                        str6 = str32;
                        AFLogger.afErrorLog("Error while processing previous event.", e);
                        string = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
                        string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
                        hashMap.put("reinstallCounter", string2);
                        hashMap.put("originalAppsflyerId", string);
                        string3 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
                        if (string3 != null) {
                        }
                        installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                        if (installerPackageName != null) {
                        }
                        string4 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.EXTENSION);
                        hashMap.put(AppsFlyerProperties.EXTENSION, string4);
                        r1 = m33(new WeakReference<>(context2));
                        r3 = m72(context2, r1);
                        if (r3 != null) {
                        }
                        hashMap.put("af_latestchannel", r1);
                        String str382 = str6;
                        sharedPreferences2 = context.getApplicationContext().getSharedPreferences(str382, 0);
                        str11 = str9;
                        if (!sharedPreferences2.contains(str11)) {
                        }
                        if (str13 != null) {
                        }
                        SharedPreferences sharedPreferences62 = context.getApplicationContext().getSharedPreferences(str382, 0);
                        string5 = AppsFlyerProperties.getInstance().getString(str29);
                        if (string5 == null) {
                        }
                        if (string5 != null) {
                        }
                        r12 = m21(context);
                        if (r12 != null) {
                        }
                        String str392 = "appsflyerKey";
                        str14 = str;
                        if (str14 != null) {
                        }
                        string13 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                        if (string13 != null) {
                        }
                        AFLogger.afInfoLog("AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ");
                        m39(context2, LOG_TAG, "DEV_KEY_MISSING", (String) null);
                        AFLogger.afInfoLog("AppsFlyer will not track this event.");
                        return null;
                    }
                } else {
                    str7 = str31;
                    str6 = str32;
                }
                edit2.putString(str28, str24);
                edit2.putString(str37, str25);
                edit2.putLong(str36, System.currentTimeMillis());
                if (VERSION.SDK_INT >= 9) {
                    edit2.apply();
                } else {
                    edit2.commit();
                }
            } catch (Exception e5) {
                e = e5;
                str7 = str31;
                str6 = str32;
                str8 = str35;
                AFLogger.afErrorLog("Error while processing previous event.", e);
                string = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
                string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
                hashMap.put("reinstallCounter", string2);
                hashMap.put("originalAppsflyerId", string);
                string3 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
                if (string3 != null) {
                }
                installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (installerPackageName != null) {
                }
                string4 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.EXTENSION);
                hashMap.put(AppsFlyerProperties.EXTENSION, string4);
                r1 = m33(new WeakReference<>(context2));
                r3 = m72(context2, r1);
                if (r3 != null) {
                }
                hashMap.put("af_latestchannel", r1);
                String str3822 = str6;
                sharedPreferences2 = context.getApplicationContext().getSharedPreferences(str3822, 0);
                str11 = str9;
                if (!sharedPreferences2.contains(str11)) {
                }
                if (str13 != null) {
                }
                SharedPreferences sharedPreferences622 = context.getApplicationContext().getSharedPreferences(str3822, 0);
                string5 = AppsFlyerProperties.getInstance().getString(str29);
                if (string5 == null) {
                }
                if (string5 != null) {
                }
                r12 = m21(context);
                if (r12 != null) {
                }
                String str3922 = "appsflyerKey";
                str14 = str;
                if (str14 != null) {
                }
                string13 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
                if (string13 != null) {
                }
                AFLogger.afInfoLog("AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ");
                m39(context2, LOG_TAG, "DEV_KEY_MISSING", (String) null);
                AFLogger.afInfoLog("AppsFlyer will not track this event.");
                return null;
            }
        }
        string = AppsFlyerProperties.getInstance().getString("KSAppsFlyerId");
        string2 = AppsFlyerProperties.getInstance().getString("KSAppsFlyerRICounter");
        if (!(string == null || string2 == null || Integer.valueOf(string2).intValue() <= 0)) {
            hashMap.put("reinstallCounter", string2);
            hashMap.put("originalAppsflyerId", string);
        }
        string3 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ADDITIONAL_CUSTOM_DATA);
        if (string3 != null) {
            hashMap.put("customData", string3);
        }
        try {
            installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            if (installerPackageName != null) {
                hashMap.put("installer_package", installerPackageName);
            }
        } catch (Exception e6) {
            AFLogger.afErrorLog("Exception while getting the app's installer package. ", e6);
        }
        string4 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.EXTENSION);
        if (string4 != null && string4.length() > 0) {
            hashMap.put(AppsFlyerProperties.EXTENSION, string4);
        }
        r1 = m33(new WeakReference<>(context2));
        r3 = m72(context2, r1);
        if (r3 != null) {
            hashMap.put(AppsFlyerProperties.CHANNEL, r3);
        }
        if ((r3 != null && !r3.equals(r1)) || (r3 == null && r1 != null)) {
            hashMap.put("af_latestchannel", r1);
        }
        String str38222 = str6;
        sharedPreferences2 = context.getApplicationContext().getSharedPreferences(str38222, 0);
        str11 = str9;
        if (!sharedPreferences2.contains(str11)) {
            str13 = sharedPreferences2.getString(str11, null);
            str12 = str7;
        } else {
            str12 = str7;
            str13 = context.getApplicationContext().getSharedPreferences(str38222, 0).contains(str12) ^ true ? m21(context) : null;
            m53(context2, str11, str13);
        }
        if (str13 != null) {
            hashMap.put("af_installstore", str13.toLowerCase());
        }
        SharedPreferences sharedPreferences6222 = context.getApplicationContext().getSharedPreferences(str38222, 0);
        string5 = AppsFlyerProperties.getInstance().getString(str29);
        if (string5 == null) {
            if (sharedPreferences6222.contains(str29)) {
                string5 = sharedPreferences6222.getString(str29, null);
            } else {
                if (!context.getApplicationContext().getSharedPreferences(str38222, 0).contains(str12)) {
                    File r14 = m64(m55(PRE_INSTALL_SYSTEM_RO_PROP));
                    if (r14 != null) {
                        if (r14.exists()) {
                            z6 = false;
                            if (z6) {
                                r14 = m64(m32(AF_PRE_INSTALL_PATH, context.getPackageManager(), context.getPackageName()));
                            }
                            if (r14 != null) {
                                if (r14.exists()) {
                                    z7 = false;
                                    if (z7) {
                                        r14 = m64(PRE_INSTALL_SYSTEM_DEFAULT);
                                    }
                                    if (r14 != null) {
                                        if (r14.exists()) {
                                            z8 = false;
                                            if (z8) {
                                                r14 = m64(PRE_INSTALL_SYSTEM_DEFAULT_ETC);
                                            }
                                            if (r14 != null) {
                                                if (r14.exists()) {
                                                    z9 = false;
                                                    if (!z9) {
                                                        String r132 = m65(r14, context.getPackageName());
                                                        if (r132 != null) {
                                                            string5 = r132;
                                                            if (string5 != null) {
                                                                string5 = m46(new WeakReference<>(context2), "AF_PRE_INSTALL_NAME");
                                                            }
                                                        }
                                                    }
                                                    string5 = null;
                                                    if (string5 != null) {
                                                    }
                                                }
                                            }
                                            z9 = true;
                                            if (!z9) {
                                            }
                                            string5 = null;
                                            if (string5 != null) {
                                            }
                                        }
                                    }
                                    z8 = true;
                                    if (z8) {
                                    }
                                    if (r14 != null) {
                                    }
                                    z9 = true;
                                    if (!z9) {
                                    }
                                    string5 = null;
                                    if (string5 != null) {
                                    }
                                }
                            }
                            z7 = true;
                            if (z7) {
                            }
                            if (r14 != null) {
                            }
                            z8 = true;
                            if (z8) {
                            }
                            if (r14 != null) {
                            }
                            z9 = true;
                            if (!z9) {
                            }
                            string5 = null;
                            if (string5 != null) {
                            }
                        }
                    }
                    z6 = true;
                    if (z6) {
                    }
                    if (r14 != null) {
                    }
                    z7 = true;
                    if (z7) {
                    }
                    if (r14 != null) {
                    }
                    z8 = true;
                    if (z8) {
                    }
                    if (r14 != null) {
                    }
                    z9 = true;
                    if (!z9) {
                    }
                    string5 = null;
                    if (string5 != null) {
                    }
                }
                if (string5 != null) {
                    m53(context2, str29, string5);
                }
            }
            if (string5 != null) {
                AppsFlyerProperties.getInstance().set(str29, string5);
            }
        }
        if (string5 != null) {
            hashMap.put("af_preinstall_name", string5.toLowerCase());
        }
        r12 = m21(context);
        if (r12 != null) {
            hashMap.put("af_currentstore", r12.toLowerCase());
        }
        String str39222 = "appsflyerKey";
        str14 = str;
        if (str14 != null) {
            if (str.length() >= 0) {
                hashMap.put(str39222, str14);
                string6 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
                if (string6 != null) {
                    hashMap.put("appUserId", string6);
                }
                string7 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.USER_EMAILS);
                if (string7 == null) {
                    hashMap.put("user_emails", string7);
                } else {
                    String string16 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.USER_EMAIL);
                    if (string16 != null) {
                        hashMap.put("sha1_el", p.m175(string16));
                    }
                }
                if (str24 != null) {
                    hashMap.put("eventName", str24);
                    if (str25 != null) {
                        hashMap.put("eventValue", str25);
                    }
                }
                str15 = str8;
                if (AppsFlyerProperties.getInstance().getString(str15) != null) {
                    hashMap.put(str15, AppsFlyerProperties.getInstance().getString(str15));
                }
                string8 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CURRENCY_CODE);
                if (string8 != null) {
                    if (string8.length() != 3) {
                        StringBuilder sb5 = new StringBuilder("WARNING: currency code should be 3 characters!!! '");
                        sb5.append(string8);
                        sb5.append("' is not a legal value.");
                        AFLogger.afWarnLog(sb5.toString());
                    }
                    hashMap.put("currency", string8);
                }
                string9 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.IS_UPDATE);
                if (string9 != null) {
                    hashMap.put("isUpdate", string9);
                }
                hashMap.put("af_preinstalled", Boolean.toString(isPreInstalledApp(context)));
                if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
                    try {
                        context.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                        appsFlyerLib = this;
                        str16 = str10;
                        try {
                            str22 = appsFlyerLib.getAttributionId(context.getContentResolver());
                        } catch (NameNotFoundException unused) {
                            AFLogger.afWarnLog("Exception while collecting facebook's attribution ID. ");
                            str22 = null;
                            if (str22 != null) {
                            }
                            String str40 = "true";
                            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                            }
                            r5 = C0280r.m186(new WeakReference(context2));
                            if (r5 != null) {
                            }
                            hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                            hashMap.put("lang_code", Locale.getDefault().getLanguage());
                            hashMap.put("country", Locale.getDefault().getCountry());
                            hashMap.put("platformextension", appsFlyerLib.f47.m180());
                            m59(context2, (Map<String, ? super String>) hashMap);
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                            long j4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("installDate", simpleDateFormat.format(new Date(j4)));
                            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            sharedPreferences3 = sharedPreferences;
                            try {
                                if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                                }
                                hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                                hashMap.put("app_version_name", packageInfo.versionName);
                                long j5 = packageInfo.firstInstallTime;
                                long j6 = packageInfo.lastUpdateTime;
                                String str41 = "date1";
                                str18 = str39222;
                            } catch (Throwable th3) {
                                th = th3;
                                str18 = str39222;
                                AFLogger.afErrorLog("Exception while collecting app version data ", th);
                                if (str4.length() > 0) {
                                }
                                string10 = sharedPreferences3.getString("extraReferrers", null);
                                if (string10 != null) {
                                }
                                string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                                if (string11 != null) {
                                }
                                appsFlyerLib.f51 = y.m226(context);
                                StringBuilder sb6 = new StringBuilder("didConfigureTokenRefreshService=");
                                sb6.append(appsFlyerLib.f51);
                                AFLogger.afDebugLog(sb6.toString());
                                if (!appsFlyerLib.f51) {
                                }
                                z3 = z2;
                                if (z3) {
                                }
                                if (appsFlyerLib.f43) {
                                }
                                currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                                referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                                if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                                }
                                if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                                }
                                r32 = n.m169(context.getContentResolver());
                                if (r32 != null) {
                                }
                                referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                                hashMap.put("referrer", referrer2);
                                equals = str40.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                                hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                                int r52 = m43(sharedPreferences3, str12, z3);
                                hashMap.put("counter", Integer.toString(r52));
                                hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                                AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                                }
                                z4 = true;
                                String str42 = "isFirstCall";
                                if (!equals) {
                                }
                                hashMap.put(str42, Boolean.toString(z4));
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("cpu_abi", m55("ro.product.cpu.abi"));
                                hashMap2.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                                hashMap2.put("arch", m55("os.arch"));
                                hashMap2.put("build_display_id", m55("ro.build.display.id"));
                                if (z3) {
                                }
                                hashMap2.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                                hashMap.put("deviceData", hashMap2);
                                new p();
                                String str43 = str18;
                                String str44 = (String) hashMap.get(str43);
                                String str45 = str17;
                                String str46 = (String) hashMap.get(str45);
                                String str47 = (String) hashMap.get("uid");
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(str44.substring(0, 7));
                                sb7.append(str47.substring(0, 7));
                                sb7.append(str46.substring(str46.length() - 7));
                                hashMap.put("af_v", p.m175(sb7.toString()));
                                new p();
                                String str48 = (String) hashMap.get(str43);
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append(str48);
                                sb8.append(hashMap.get(str45));
                                String sb9 = sb8.toString();
                                StringBuilder sb10 = new StringBuilder();
                                sb10.append(sb9);
                                sb10.append(hashMap.get("uid"));
                                String sb11 = sb10.toString();
                                StringBuilder sb12 = new StringBuilder();
                                sb12.append(sb11);
                                sb12.append(hashMap.get("installDate"));
                                String sb13 = sb12.toString();
                                StringBuilder sb14 = new StringBuilder();
                                sb14.append(sb13);
                                sb14.append(hashMap.get("counter"));
                                String sb15 = sb14.toString();
                                StringBuilder sb16 = new StringBuilder();
                                sb16.append(sb15);
                                sb16.append(hashMap.get("iaecounter"));
                                hashMap.put("af_v2", p.m175(p.m178(sb16.toString())));
                                hashMap.put("ivc", Boolean.valueOf(m20(context)));
                                if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                                }
                                if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                                }
                                return hashMap;
                            }
                            try {
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put(str41, simpleDateFormat.format(new Date(j5)));
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put("date2", simpleDateFormat.format(new Date(j6)));
                                string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                                if (string12 == null) {
                                }
                                AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                                hashMap.put("firstLaunchDate", string12);
                            } catch (Throwable th4) {
                                th = th4;
                                AFLogger.afErrorLog("Exception while collecting app version data ", th);
                                if (str4.length() > 0) {
                                }
                                string10 = sharedPreferences3.getString("extraReferrers", null);
                                if (string10 != null) {
                                }
                                string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                                if (string11 != null) {
                                }
                                appsFlyerLib.f51 = y.m226(context);
                                StringBuilder sb62 = new StringBuilder("didConfigureTokenRefreshService=");
                                sb62.append(appsFlyerLib.f51);
                                AFLogger.afDebugLog(sb62.toString());
                                if (!appsFlyerLib.f51) {
                                }
                                z3 = z2;
                                if (z3) {
                                }
                                if (appsFlyerLib.f43) {
                                }
                                currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                                referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                                if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                                }
                                if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                                }
                                r32 = n.m169(context.getContentResolver());
                                if (r32 != null) {
                                }
                                referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                                hashMap.put("referrer", referrer2);
                                equals = str40.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                                hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                                int r522 = m43(sharedPreferences3, str12, z3);
                                hashMap.put("counter", Integer.toString(r522));
                                hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                                AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                                }
                                z4 = true;
                                String str422 = "isFirstCall";
                                if (!equals) {
                                }
                                hashMap.put(str422, Boolean.toString(z4));
                                HashMap hashMap22 = new HashMap();
                                hashMap22.put("cpu_abi", m55("ro.product.cpu.abi"));
                                hashMap22.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                                hashMap22.put("arch", m55("os.arch"));
                                hashMap22.put("build_display_id", m55("ro.build.display.id"));
                                if (z3) {
                                }
                                hashMap22.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                                hashMap.put("deviceData", hashMap22);
                                new p();
                                String str432 = str18;
                                String str442 = (String) hashMap.get(str432);
                                String str452 = str17;
                                String str462 = (String) hashMap.get(str452);
                                String str472 = (String) hashMap.get("uid");
                                StringBuilder sb72 = new StringBuilder();
                                sb72.append(str442.substring(0, 7));
                                sb72.append(str472.substring(0, 7));
                                sb72.append(str462.substring(str462.length() - 7));
                                hashMap.put("af_v", p.m175(sb72.toString()));
                                new p();
                                String str482 = (String) hashMap.get(str432);
                                StringBuilder sb82 = new StringBuilder();
                                sb82.append(str482);
                                sb82.append(hashMap.get(str452));
                                String sb92 = sb82.toString();
                                StringBuilder sb102 = new StringBuilder();
                                sb102.append(sb92);
                                sb102.append(hashMap.get("uid"));
                                String sb112 = sb102.toString();
                                StringBuilder sb122 = new StringBuilder();
                                sb122.append(sb112);
                                sb122.append(hashMap.get("installDate"));
                                String sb132 = sb122.toString();
                                StringBuilder sb142 = new StringBuilder();
                                sb142.append(sb132);
                                sb142.append(hashMap.get("counter"));
                                String sb152 = sb142.toString();
                                StringBuilder sb162 = new StringBuilder();
                                sb162.append(sb152);
                                sb162.append(hashMap.get("iaecounter"));
                                hashMap.put("af_v2", p.m175(p.m178(sb162.toString())));
                                hashMap.put("ivc", Boolean.valueOf(m20(context)));
                                if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                                }
                                if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                                }
                                return hashMap;
                            }
                            if (str4.length() > 0) {
                            }
                            string10 = sharedPreferences3.getString("extraReferrers", null);
                            if (string10 != null) {
                            }
                            string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                            if (string11 != null) {
                            }
                            appsFlyerLib.f51 = y.m226(context);
                            StringBuilder sb622 = new StringBuilder("didConfigureTokenRefreshService=");
                            sb622.append(appsFlyerLib.f51);
                            AFLogger.afDebugLog(sb622.toString());
                            if (!appsFlyerLib.f51) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (appsFlyerLib.f43) {
                            }
                            currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                            referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                            if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                            }
                            if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                            }
                            r32 = n.m169(context.getContentResolver());
                            if (r32 != null) {
                            }
                            referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                            hashMap.put("referrer", referrer2);
                            equals = str40.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                            hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                            int r5222 = m43(sharedPreferences3, str12, z3);
                            hashMap.put("counter", Integer.toString(r5222));
                            hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                            AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                            }
                            z4 = true;
                            String str4222 = "isFirstCall";
                            if (!equals) {
                            }
                            hashMap.put(str4222, Boolean.toString(z4));
                            HashMap hashMap222 = new HashMap();
                            hashMap222.put("cpu_abi", m55("ro.product.cpu.abi"));
                            hashMap222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                            hashMap222.put("arch", m55("os.arch"));
                            hashMap222.put("build_display_id", m55("ro.build.display.id"));
                            if (z3) {
                            }
                            hashMap222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                            hashMap.put("deviceData", hashMap222);
                            new p();
                            String str4322 = str18;
                            String str4422 = (String) hashMap.get(str4322);
                            String str4522 = str17;
                            String str4622 = (String) hashMap.get(str4522);
                            String str4722 = (String) hashMap.get("uid");
                            StringBuilder sb722 = new StringBuilder();
                            sb722.append(str4422.substring(0, 7));
                            sb722.append(str4722.substring(0, 7));
                            sb722.append(str4622.substring(str4622.length() - 7));
                            hashMap.put("af_v", p.m175(sb722.toString()));
                            new p();
                            String str4822 = (String) hashMap.get(str4322);
                            StringBuilder sb822 = new StringBuilder();
                            sb822.append(str4822);
                            sb822.append(hashMap.get(str4522));
                            String sb922 = sb822.toString();
                            StringBuilder sb1022 = new StringBuilder();
                            sb1022.append(sb922);
                            sb1022.append(hashMap.get("uid"));
                            String sb1122 = sb1022.toString();
                            StringBuilder sb1222 = new StringBuilder();
                            sb1222.append(sb1122);
                            sb1222.append(hashMap.get("installDate"));
                            String sb1322 = sb1222.toString();
                            StringBuilder sb1422 = new StringBuilder();
                            sb1422.append(sb1322);
                            sb1422.append(hashMap.get("counter"));
                            String sb1522 = sb1422.toString();
                            StringBuilder sb1622 = new StringBuilder();
                            sb1622.append(sb1522);
                            sb1622.append(hashMap.get("iaecounter"));
                            hashMap.put("af_v2", p.m175(p.m178(sb1622.toString())));
                            hashMap.put("ivc", Boolean.valueOf(m20(context)));
                            if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                            }
                            if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                            }
                            return hashMap;
                        } catch (Throwable th5) {
                            th = th5;
                            AFLogger.afErrorLog("Exception while collecting facebook's attribution ID. ", th);
                            str22 = null;
                            if (str22 != null) {
                            }
                            String str402 = "true";
                            if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                            }
                            r5 = C0280r.m186(new WeakReference(context2));
                            if (r5 != null) {
                            }
                            hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                            hashMap.put("lang_code", Locale.getDefault().getLanguage());
                            hashMap.put("country", Locale.getDefault().getCountry());
                            hashMap.put("platformextension", appsFlyerLib.f47.m180());
                            m59(context2, (Map<String, ? super String>) hashMap);
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                            long j42 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("installDate", simpleDateFormat.format(new Date(j42)));
                            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            sharedPreferences3 = sharedPreferences;
                            if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                            }
                            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                            hashMap.put("app_version_name", packageInfo.versionName);
                            long j52 = packageInfo.firstInstallTime;
                            long j62 = packageInfo.lastUpdateTime;
                            String str412 = "date1";
                            str18 = str39222;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put(str412, simpleDateFormat.format(new Date(j52)));
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("date2", simpleDateFormat.format(new Date(j62)));
                            string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                            if (string12 == null) {
                            }
                            AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                            hashMap.put("firstLaunchDate", string12);
                            if (str4.length() > 0) {
                            }
                            string10 = sharedPreferences3.getString("extraReferrers", null);
                            if (string10 != null) {
                            }
                            string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                            if (string11 != null) {
                            }
                            appsFlyerLib.f51 = y.m226(context);
                            StringBuilder sb6222 = new StringBuilder("didConfigureTokenRefreshService=");
                            sb6222.append(appsFlyerLib.f51);
                            AFLogger.afDebugLog(sb6222.toString());
                            if (!appsFlyerLib.f51) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (appsFlyerLib.f43) {
                            }
                            currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                            referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                            if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                            }
                            if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                            }
                            r32 = n.m169(context.getContentResolver());
                            if (r32 != null) {
                            }
                            referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                            hashMap.put("referrer", referrer2);
                            equals = str402.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                            hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                            int r52222 = m43(sharedPreferences3, str12, z3);
                            hashMap.put("counter", Integer.toString(r52222));
                            hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                            AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                            }
                            z4 = true;
                            String str42222 = "isFirstCall";
                            if (!equals) {
                            }
                            hashMap.put(str42222, Boolean.toString(z4));
                            HashMap hashMap2222 = new HashMap();
                            hashMap2222.put("cpu_abi", m55("ro.product.cpu.abi"));
                            hashMap2222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                            hashMap2222.put("arch", m55("os.arch"));
                            hashMap2222.put("build_display_id", m55("ro.build.display.id"));
                            if (z3) {
                            }
                            hashMap2222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                            hashMap.put("deviceData", hashMap2222);
                            new p();
                            String str43222 = str18;
                            String str44222 = (String) hashMap.get(str43222);
                            String str45222 = str17;
                            String str46222 = (String) hashMap.get(str45222);
                            String str47222 = (String) hashMap.get("uid");
                            StringBuilder sb7222 = new StringBuilder();
                            sb7222.append(str44222.substring(0, 7));
                            sb7222.append(str47222.substring(0, 7));
                            sb7222.append(str46222.substring(str46222.length() - 7));
                            hashMap.put("af_v", p.m175(sb7222.toString()));
                            new p();
                            String str48222 = (String) hashMap.get(str43222);
                            StringBuilder sb8222 = new StringBuilder();
                            sb8222.append(str48222);
                            sb8222.append(hashMap.get(str45222));
                            String sb9222 = sb8222.toString();
                            StringBuilder sb10222 = new StringBuilder();
                            sb10222.append(sb9222);
                            sb10222.append(hashMap.get("uid"));
                            String sb11222 = sb10222.toString();
                            StringBuilder sb12222 = new StringBuilder();
                            sb12222.append(sb11222);
                            sb12222.append(hashMap.get("installDate"));
                            String sb13222 = sb12222.toString();
                            StringBuilder sb14222 = new StringBuilder();
                            sb14222.append(sb13222);
                            sb14222.append(hashMap.get("counter"));
                            String sb15222 = sb14222.toString();
                            StringBuilder sb16222 = new StringBuilder();
                            sb16222.append(sb15222);
                            sb16222.append(hashMap.get("iaecounter"));
                            hashMap.put("af_v2", p.m175(p.m178(sb16222.toString())));
                            hashMap.put("ivc", Boolean.valueOf(m20(context)));
                            if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                            }
                            if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                            }
                            return hashMap;
                        }
                    } catch (NameNotFoundException unused2) {
                        appsFlyerLib = this;
                        str16 = str10;
                        AFLogger.afWarnLog("Exception while collecting facebook's attribution ID. ");
                        str22 = null;
                        if (str22 != null) {
                        }
                        String str4022 = "true";
                        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                        }
                        r5 = C0280r.m186(new WeakReference(context2));
                        if (r5 != null) {
                        }
                        hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                        hashMap.put("lang_code", Locale.getDefault().getLanguage());
                        hashMap.put("country", Locale.getDefault().getCountry());
                        hashMap.put("platformextension", appsFlyerLib.f47.m180());
                        m59(context2, (Map<String, ? super String>) hashMap);
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                        long j422 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        hashMap.put("installDate", simpleDateFormat.format(new Date(j422)));
                        packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        sharedPreferences3 = sharedPreferences;
                        if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                        }
                        hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                        hashMap.put("app_version_name", packageInfo.versionName);
                        long j522 = packageInfo.firstInstallTime;
                        long j622 = packageInfo.lastUpdateTime;
                        String str4122 = "date1";
                        str18 = str39222;
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        hashMap.put(str4122, simpleDateFormat.format(new Date(j522)));
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        hashMap.put("date2", simpleDateFormat.format(new Date(j622)));
                        string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                        if (string12 == null) {
                        }
                        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                        hashMap.put("firstLaunchDate", string12);
                        if (str4.length() > 0) {
                        }
                        string10 = sharedPreferences3.getString("extraReferrers", null);
                        if (string10 != null) {
                        }
                        string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                        if (string11 != null) {
                        }
                        appsFlyerLib.f51 = y.m226(context);
                        StringBuilder sb62222 = new StringBuilder("didConfigureTokenRefreshService=");
                        sb62222.append(appsFlyerLib.f51);
                        AFLogger.afDebugLog(sb62222.toString());
                        if (!appsFlyerLib.f51) {
                        }
                        z3 = z2;
                        if (z3) {
                        }
                        if (appsFlyerLib.f43) {
                        }
                        currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                        referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                        if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                        }
                        if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                        }
                        r32 = n.m169(context.getContentResolver());
                        if (r32 != null) {
                        }
                        referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                        hashMap.put("referrer", referrer2);
                        equals = str4022.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                        hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                        int r522222 = m43(sharedPreferences3, str12, z3);
                        hashMap.put("counter", Integer.toString(r522222));
                        hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                        AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                        }
                        z4 = true;
                        String str422222 = "isFirstCall";
                        if (!equals) {
                        }
                        hashMap.put(str422222, Boolean.toString(z4));
                        HashMap hashMap22222 = new HashMap();
                        hashMap22222.put("cpu_abi", m55("ro.product.cpu.abi"));
                        hashMap22222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                        hashMap22222.put("arch", m55("os.arch"));
                        hashMap22222.put("build_display_id", m55("ro.build.display.id"));
                        if (z3) {
                        }
                        hashMap22222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                        hashMap.put("deviceData", hashMap22222);
                        new p();
                        String str432222 = str18;
                        String str442222 = (String) hashMap.get(str432222);
                        String str452222 = str17;
                        String str462222 = (String) hashMap.get(str452222);
                        String str472222 = (String) hashMap.get("uid");
                        StringBuilder sb72222 = new StringBuilder();
                        sb72222.append(str442222.substring(0, 7));
                        sb72222.append(str472222.substring(0, 7));
                        sb72222.append(str462222.substring(str462222.length() - 7));
                        hashMap.put("af_v", p.m175(sb72222.toString()));
                        new p();
                        String str482222 = (String) hashMap.get(str432222);
                        StringBuilder sb82222 = new StringBuilder();
                        sb82222.append(str482222);
                        sb82222.append(hashMap.get(str452222));
                        String sb92222 = sb82222.toString();
                        StringBuilder sb102222 = new StringBuilder();
                        sb102222.append(sb92222);
                        sb102222.append(hashMap.get("uid"));
                        String sb112222 = sb102222.toString();
                        StringBuilder sb122222 = new StringBuilder();
                        sb122222.append(sb112222);
                        sb122222.append(hashMap.get("installDate"));
                        String sb132222 = sb122222.toString();
                        StringBuilder sb142222 = new StringBuilder();
                        sb142222.append(sb132222);
                        sb142222.append(hashMap.get("counter"));
                        String sb152222 = sb142222.toString();
                        StringBuilder sb162222 = new StringBuilder();
                        sb162222.append(sb152222);
                        sb162222.append(hashMap.get("iaecounter"));
                        hashMap.put("af_v2", p.m175(p.m178(sb162222.toString())));
                        hashMap.put("ivc", Boolean.valueOf(m20(context)));
                        if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                        }
                        if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                        }
                        return hashMap;
                    } catch (Throwable th6) {
                        th = th6;
                        Throwable th22 = th;
                        AFLogger.afErrorLog(th22.getLocalizedMessage(), th22);
                        return hashMap;
                    }
                    if (str22 != null) {
                        hashMap.put("fb", str22);
                    }
                } else {
                    appsFlyerLib = this;
                    str16 = str10;
                }
                String str40222 = "true";
                if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                    hashMap.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, str40222);
                    str17 = str16;
                } else {
                    SharedPreferences sharedPreferences7 = context.getApplicationContext().getSharedPreferences(str38222, 0);
                    boolean z11 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI, true);
                    String string17 = sharedPreferences7.getString("imeiCached", null);
                    if (!z11 || !TextUtils.isEmpty(appsFlyerLib.f54)) {
                        str17 = str16;
                        if (appsFlyerLib.f54 != null) {
                            str19 = appsFlyerLib.f54;
                            if (str19 != null) {
                                m53(context2, "imeiCached", str19);
                                hashMap.put("imei", str19);
                            } else {
                                AFLogger.afInfoLog("IMEI was not collected.");
                            }
                            z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                            String string18 = sharedPreferences7.getString("androidIdCached", null);
                            if (z5 || !TextUtils.isEmpty(appsFlyerLib.f45)) {
                                if (appsFlyerLib.f45 != null) {
                                    str20 = appsFlyerLib.f45;
                                    if (str20 != null) {
                                        m53(context2, "androidIdCached", str20);
                                        hashMap.put("android_id", str20);
                                    } else {
                                        AFLogger.afInfoLog("Android ID was not collected.");
                                    }
                                }
                            } else if (m71(context)) {
                                try {
                                    str20 = Secure.getString(context.getContentResolver(), "android_id");
                                    if (str20 == null) {
                                        if (string18 != null) {
                                            AFLogger.afDebugLog("use cached AndroidId: ".concat(String.valueOf(string18)));
                                            str20 = string18;
                                        }
                                    }
                                } catch (Exception e7) {
                                    Exception exc = e7;
                                    if (string18 != null) {
                                        AFLogger.afDebugLog("use cached AndroidId: ".concat(String.valueOf(string18)));
                                        str20 = string18;
                                    } else {
                                        str20 = null;
                                    }
                                    AFLogger.afErrorLog(exc.getMessage(), exc);
                                }
                                if (str20 != null) {
                                }
                            }
                            str20 = null;
                            if (str20 != null) {
                            }
                        }
                    } else if (m71(context)) {
                        try {
                            TelephonyManager telephonyManager = (TelephonyManager) context2.getSystemService(AttributeType.PHONE);
                            str17 = str16;
                            try {
                                str19 = (String) telephonyManager.getClass().getMethod("getDeviceId", new Class[0]).invoke(telephonyManager, new Object[0]);
                                if (str19 == null) {
                                    if (string17 != null) {
                                        AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(string17)));
                                        str19 = string17;
                                    }
                                }
                            } catch (InvocationTargetException unused3) {
                                if (string17 == null) {
                                }
                                AFLogger.afWarnLog("WARNING: READ_PHONE_STATE is missing.");
                                if (str19 != null) {
                                }
                                z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                                String string182 = sharedPreferences7.getString("androidIdCached", null);
                                if (z5) {
                                }
                                if (appsFlyerLib.f45 != null) {
                                }
                                str20 = null;
                                if (str20 != null) {
                                }
                                r5 = C0280r.m186(new WeakReference(context2));
                                if (r5 != null) {
                                }
                                hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                                hashMap.put("lang_code", Locale.getDefault().getLanguage());
                                hashMap.put("country", Locale.getDefault().getCountry());
                                hashMap.put("platformextension", appsFlyerLib.f47.m180());
                                m59(context2, (Map<String, ? super String>) hashMap);
                                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                                long j4222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put("installDate", simpleDateFormat.format(new Date(j4222)));
                                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                                sharedPreferences3 = sharedPreferences;
                                if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                                }
                                hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                                hashMap.put("app_version_name", packageInfo.versionName);
                                long j5222 = packageInfo.firstInstallTime;
                                long j6222 = packageInfo.lastUpdateTime;
                                String str41222 = "date1";
                                str18 = str39222;
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put(str41222, simpleDateFormat.format(new Date(j5222)));
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put("date2", simpleDateFormat.format(new Date(j6222)));
                                string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                                if (string12 == null) {
                                }
                                AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                                hashMap.put("firstLaunchDate", string12);
                                if (str4.length() > 0) {
                                }
                                string10 = sharedPreferences3.getString("extraReferrers", null);
                                if (string10 != null) {
                                }
                                string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                                if (string11 != null) {
                                }
                                appsFlyerLib.f51 = y.m226(context);
                                StringBuilder sb622222 = new StringBuilder("didConfigureTokenRefreshService=");
                                sb622222.append(appsFlyerLib.f51);
                                AFLogger.afDebugLog(sb622222.toString());
                                if (!appsFlyerLib.f51) {
                                }
                                z3 = z2;
                                if (z3) {
                                }
                                if (appsFlyerLib.f43) {
                                }
                                currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                                referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                                if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                                }
                                if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                                }
                                r32 = n.m169(context.getContentResolver());
                                if (r32 != null) {
                                }
                                referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                                hashMap.put("referrer", referrer2);
                                equals = str40222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                                hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                                int r5222222 = m43(sharedPreferences3, str12, z3);
                                hashMap.put("counter", Integer.toString(r5222222));
                                hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                                AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                                }
                                z4 = true;
                                String str4222222 = "isFirstCall";
                                if (!equals) {
                                }
                                hashMap.put(str4222222, Boolean.toString(z4));
                                HashMap hashMap222222 = new HashMap();
                                hashMap222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                                hashMap222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                                hashMap222222.put("arch", m55("os.arch"));
                                hashMap222222.put("build_display_id", m55("ro.build.display.id"));
                                if (z3) {
                                }
                                hashMap222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                                hashMap.put("deviceData", hashMap222222);
                                new p();
                                String str4322222 = str18;
                                String str4422222 = (String) hashMap.get(str4322222);
                                String str4522222 = str17;
                                String str4622222 = (String) hashMap.get(str4522222);
                                String str4722222 = (String) hashMap.get("uid");
                                StringBuilder sb722222 = new StringBuilder();
                                sb722222.append(str4422222.substring(0, 7));
                                sb722222.append(str4722222.substring(0, 7));
                                sb722222.append(str4622222.substring(str4622222.length() - 7));
                                hashMap.put("af_v", p.m175(sb722222.toString()));
                                new p();
                                String str4822222 = (String) hashMap.get(str4322222);
                                StringBuilder sb822222 = new StringBuilder();
                                sb822222.append(str4822222);
                                sb822222.append(hashMap.get(str4522222));
                                String sb922222 = sb822222.toString();
                                StringBuilder sb1022222 = new StringBuilder();
                                sb1022222.append(sb922222);
                                sb1022222.append(hashMap.get("uid"));
                                String sb1122222 = sb1022222.toString();
                                StringBuilder sb1222222 = new StringBuilder();
                                sb1222222.append(sb1122222);
                                sb1222222.append(hashMap.get("installDate"));
                                String sb1322222 = sb1222222.toString();
                                StringBuilder sb1422222 = new StringBuilder();
                                sb1422222.append(sb1322222);
                                sb1422222.append(hashMap.get("counter"));
                                String sb1522222 = sb1422222.toString();
                                StringBuilder sb1622222 = new StringBuilder();
                                sb1622222.append(sb1522222);
                                sb1622222.append(hashMap.get("iaecounter"));
                                hashMap.put("af_v2", p.m175(p.m178(sb1622222.toString())));
                                hashMap.put("ivc", Boolean.valueOf(m20(context)));
                                if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                                }
                                if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                                }
                                return hashMap;
                            } catch (Exception e8) {
                                e = e8;
                                Throwable th7 = e;
                                if (string17 == null) {
                                }
                                AFLogger.afErrorLog("WARNING: other reason: ", th7);
                                if (str19 != null) {
                                }
                                z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                                String string1822 = sharedPreferences7.getString("androidIdCached", null);
                                if (z5) {
                                }
                                if (appsFlyerLib.f45 != null) {
                                }
                                str20 = null;
                                if (str20 != null) {
                                }
                                r5 = C0280r.m186(new WeakReference(context2));
                                if (r5 != null) {
                                }
                                hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                                hashMap.put("lang_code", Locale.getDefault().getLanguage());
                                hashMap.put("country", Locale.getDefault().getCountry());
                                hashMap.put("platformextension", appsFlyerLib.f47.m180());
                                m59(context2, (Map<String, ? super String>) hashMap);
                                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                                long j42222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put("installDate", simpleDateFormat.format(new Date(j42222)));
                                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                                sharedPreferences3 = sharedPreferences;
                                if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                                }
                                hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                                hashMap.put("app_version_name", packageInfo.versionName);
                                long j52222 = packageInfo.firstInstallTime;
                                long j62222 = packageInfo.lastUpdateTime;
                                String str412222 = "date1";
                                str18 = str39222;
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put(str412222, simpleDateFormat.format(new Date(j52222)));
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                hashMap.put("date2", simpleDateFormat.format(new Date(j62222)));
                                string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                                if (string12 == null) {
                                }
                                AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                                hashMap.put("firstLaunchDate", string12);
                                if (str4.length() > 0) {
                                }
                                string10 = sharedPreferences3.getString("extraReferrers", null);
                                if (string10 != null) {
                                }
                                string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                                if (string11 != null) {
                                }
                                appsFlyerLib.f51 = y.m226(context);
                                StringBuilder sb6222222 = new StringBuilder("didConfigureTokenRefreshService=");
                                sb6222222.append(appsFlyerLib.f51);
                                AFLogger.afDebugLog(sb6222222.toString());
                                if (!appsFlyerLib.f51) {
                                }
                                z3 = z2;
                                if (z3) {
                                }
                                if (appsFlyerLib.f43) {
                                }
                                currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                                referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                                if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                                }
                                if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                                }
                                r32 = n.m169(context.getContentResolver());
                                if (r32 != null) {
                                }
                                referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                                hashMap.put("referrer", referrer2);
                                equals = str40222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                                hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                                int r52222222 = m43(sharedPreferences3, str12, z3);
                                hashMap.put("counter", Integer.toString(r52222222));
                                hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                                AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                                if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                                }
                                z4 = true;
                                String str42222222 = "isFirstCall";
                                if (!equals) {
                                }
                                hashMap.put(str42222222, Boolean.toString(z4));
                                HashMap hashMap2222222 = new HashMap();
                                hashMap2222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                                hashMap2222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                                hashMap2222222.put("arch", m55("os.arch"));
                                hashMap2222222.put("build_display_id", m55("ro.build.display.id"));
                                if (z3) {
                                }
                                hashMap2222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                                hashMap.put("deviceData", hashMap2222222);
                                new p();
                                String str43222222 = str18;
                                String str44222222 = (String) hashMap.get(str43222222);
                                String str45222222 = str17;
                                String str46222222 = (String) hashMap.get(str45222222);
                                String str47222222 = (String) hashMap.get("uid");
                                StringBuilder sb7222222 = new StringBuilder();
                                sb7222222.append(str44222222.substring(0, 7));
                                sb7222222.append(str47222222.substring(0, 7));
                                sb7222222.append(str46222222.substring(str46222222.length() - 7));
                                hashMap.put("af_v", p.m175(sb7222222.toString()));
                                new p();
                                String str48222222 = (String) hashMap.get(str43222222);
                                StringBuilder sb8222222 = new StringBuilder();
                                sb8222222.append(str48222222);
                                sb8222222.append(hashMap.get(str45222222));
                                String sb9222222 = sb8222222.toString();
                                StringBuilder sb10222222 = new StringBuilder();
                                sb10222222.append(sb9222222);
                                sb10222222.append(hashMap.get("uid"));
                                String sb11222222 = sb10222222.toString();
                                StringBuilder sb12222222 = new StringBuilder();
                                sb12222222.append(sb11222222);
                                sb12222222.append(hashMap.get("installDate"));
                                String sb13222222 = sb12222222.toString();
                                StringBuilder sb14222222 = new StringBuilder();
                                sb14222222.append(sb13222222);
                                sb14222222.append(hashMap.get("counter"));
                                String sb15222222 = sb14222222.toString();
                                StringBuilder sb16222222 = new StringBuilder();
                                sb16222222.append(sb15222222);
                                sb16222222.append(hashMap.get("iaecounter"));
                                hashMap.put("af_v2", p.m175(p.m178(sb16222222.toString())));
                                hashMap.put("ivc", Boolean.valueOf(m20(context)));
                                if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                                }
                                if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                                }
                                return hashMap;
                            }
                        } catch (InvocationTargetException unused4) {
                            str17 = str16;
                            if (string17 == null) {
                                AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(string17)));
                                str21 = string17;
                            } else {
                                str21 = null;
                            }
                            AFLogger.afWarnLog("WARNING: READ_PHONE_STATE is missing.");
                            if (str19 != null) {
                            }
                            z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                            String string18222 = sharedPreferences7.getString("androidIdCached", null);
                            if (z5) {
                            }
                            if (appsFlyerLib.f45 != null) {
                            }
                            str20 = null;
                            if (str20 != null) {
                            }
                            r5 = C0280r.m186(new WeakReference(context2));
                            if (r5 != null) {
                            }
                            hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                            hashMap.put("lang_code", Locale.getDefault().getLanguage());
                            hashMap.put("country", Locale.getDefault().getCountry());
                            hashMap.put("platformextension", appsFlyerLib.f47.m180());
                            m59(context2, (Map<String, ? super String>) hashMap);
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                            long j422222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("installDate", simpleDateFormat.format(new Date(j422222)));
                            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            sharedPreferences3 = sharedPreferences;
                            if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                            }
                            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                            hashMap.put("app_version_name", packageInfo.versionName);
                            long j522222 = packageInfo.firstInstallTime;
                            long j622222 = packageInfo.lastUpdateTime;
                            String str4122222 = "date1";
                            str18 = str39222;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put(str4122222, simpleDateFormat.format(new Date(j522222)));
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("date2", simpleDateFormat.format(new Date(j622222)));
                            string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                            if (string12 == null) {
                            }
                            AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                            hashMap.put("firstLaunchDate", string12);
                            if (str4.length() > 0) {
                            }
                            string10 = sharedPreferences3.getString("extraReferrers", null);
                            if (string10 != null) {
                            }
                            string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                            if (string11 != null) {
                            }
                            appsFlyerLib.f51 = y.m226(context);
                            StringBuilder sb62222222 = new StringBuilder("didConfigureTokenRefreshService=");
                            sb62222222.append(appsFlyerLib.f51);
                            AFLogger.afDebugLog(sb62222222.toString());
                            if (!appsFlyerLib.f51) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (appsFlyerLib.f43) {
                            }
                            currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                            referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                            if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                            }
                            if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                            }
                            r32 = n.m169(context.getContentResolver());
                            if (r32 != null) {
                            }
                            referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                            hashMap.put("referrer", referrer2);
                            equals = str40222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                            hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                            int r522222222 = m43(sharedPreferences3, str12, z3);
                            hashMap.put("counter", Integer.toString(r522222222));
                            hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                            AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                            }
                            z4 = true;
                            String str422222222 = "isFirstCall";
                            if (!equals) {
                            }
                            hashMap.put(str422222222, Boolean.toString(z4));
                            HashMap hashMap22222222 = new HashMap();
                            hashMap22222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                            hashMap22222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                            hashMap22222222.put("arch", m55("os.arch"));
                            hashMap22222222.put("build_display_id", m55("ro.build.display.id"));
                            if (z3) {
                            }
                            hashMap22222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                            hashMap.put("deviceData", hashMap22222222);
                            new p();
                            String str432222222 = str18;
                            String str442222222 = (String) hashMap.get(str432222222);
                            String str452222222 = str17;
                            String str462222222 = (String) hashMap.get(str452222222);
                            String str472222222 = (String) hashMap.get("uid");
                            StringBuilder sb72222222 = new StringBuilder();
                            sb72222222.append(str442222222.substring(0, 7));
                            sb72222222.append(str472222222.substring(0, 7));
                            sb72222222.append(str462222222.substring(str462222222.length() - 7));
                            hashMap.put("af_v", p.m175(sb72222222.toString()));
                            new p();
                            String str482222222 = (String) hashMap.get(str432222222);
                            StringBuilder sb82222222 = new StringBuilder();
                            sb82222222.append(str482222222);
                            sb82222222.append(hashMap.get(str452222222));
                            String sb92222222 = sb82222222.toString();
                            StringBuilder sb102222222 = new StringBuilder();
                            sb102222222.append(sb92222222);
                            sb102222222.append(hashMap.get("uid"));
                            String sb112222222 = sb102222222.toString();
                            StringBuilder sb122222222 = new StringBuilder();
                            sb122222222.append(sb112222222);
                            sb122222222.append(hashMap.get("installDate"));
                            String sb132222222 = sb122222222.toString();
                            StringBuilder sb142222222 = new StringBuilder();
                            sb142222222.append(sb132222222);
                            sb142222222.append(hashMap.get("counter"));
                            String sb152222222 = sb142222222.toString();
                            StringBuilder sb162222222 = new StringBuilder();
                            sb162222222.append(sb152222222);
                            sb162222222.append(hashMap.get("iaecounter"));
                            hashMap.put("af_v2", p.m175(p.m178(sb162222222.toString())));
                            hashMap.put("ivc", Boolean.valueOf(m20(context)));
                            if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                            }
                            if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                            }
                            return hashMap;
                        } catch (Exception e9) {
                            e = e9;
                            str17 = str16;
                            Throwable th72 = e;
                            if (string17 == null) {
                                AFLogger.afDebugLog("use cached IMEI: ".concat(String.valueOf(string17)));
                                str19 = string17;
                            } else {
                                str19 = null;
                            }
                            AFLogger.afErrorLog("WARNING: other reason: ", th72);
                            if (str19 != null) {
                            }
                            z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                            String string182222 = sharedPreferences7.getString("androidIdCached", null);
                            if (z5) {
                            }
                            if (appsFlyerLib.f45 != null) {
                            }
                            str20 = null;
                            if (str20 != null) {
                            }
                            r5 = C0280r.m186(new WeakReference(context2));
                            if (r5 != null) {
                            }
                            hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                            hashMap.put("lang_code", Locale.getDefault().getLanguage());
                            hashMap.put("country", Locale.getDefault().getCountry());
                            hashMap.put("platformextension", appsFlyerLib.f47.m180());
                            m59(context2, (Map<String, ? super String>) hashMap);
                            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                            long j4222222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("installDate", simpleDateFormat.format(new Date(j4222222)));
                            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            sharedPreferences3 = sharedPreferences;
                            if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                            }
                            hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                            hashMap.put("app_version_name", packageInfo.versionName);
                            long j5222222 = packageInfo.firstInstallTime;
                            long j6222222 = packageInfo.lastUpdateTime;
                            String str41222222 = "date1";
                            str18 = str39222;
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put(str41222222, simpleDateFormat.format(new Date(j5222222)));
                            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                            hashMap.put("date2", simpleDateFormat.format(new Date(j6222222)));
                            string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                            if (string12 == null) {
                            }
                            AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                            hashMap.put("firstLaunchDate", string12);
                            if (str4.length() > 0) {
                            }
                            string10 = sharedPreferences3.getString("extraReferrers", null);
                            if (string10 != null) {
                            }
                            string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                            if (string11 != null) {
                            }
                            appsFlyerLib.f51 = y.m226(context);
                            StringBuilder sb622222222 = new StringBuilder("didConfigureTokenRefreshService=");
                            sb622222222.append(appsFlyerLib.f51);
                            AFLogger.afDebugLog(sb622222222.toString());
                            if (!appsFlyerLib.f51) {
                            }
                            z3 = z2;
                            if (z3) {
                            }
                            if (appsFlyerLib.f43) {
                            }
                            currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                            referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                            if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                            }
                            if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                            }
                            r32 = n.m169(context.getContentResolver());
                            if (r32 != null) {
                            }
                            referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                            hashMap.put("referrer", referrer2);
                            equals = str40222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                            hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                            int r5222222222 = m43(sharedPreferences3, str12, z3);
                            hashMap.put("counter", Integer.toString(r5222222222));
                            hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                            AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                            }
                            z4 = true;
                            String str4222222222 = "isFirstCall";
                            if (!equals) {
                            }
                            hashMap.put(str4222222222, Boolean.toString(z4));
                            HashMap hashMap222222222 = new HashMap();
                            hashMap222222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                            hashMap222222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                            hashMap222222222.put("arch", m55("os.arch"));
                            hashMap222222222.put("build_display_id", m55("ro.build.display.id"));
                            if (z3) {
                            }
                            hashMap222222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                            hashMap.put("deviceData", hashMap222222222);
                            new p();
                            String str4322222222 = str18;
                            String str4422222222 = (String) hashMap.get(str4322222222);
                            String str4522222222 = str17;
                            String str4622222222 = (String) hashMap.get(str4522222222);
                            String str4722222222 = (String) hashMap.get("uid");
                            StringBuilder sb722222222 = new StringBuilder();
                            sb722222222.append(str4422222222.substring(0, 7));
                            sb722222222.append(str4722222222.substring(0, 7));
                            sb722222222.append(str4622222222.substring(str4622222222.length() - 7));
                            hashMap.put("af_v", p.m175(sb722222222.toString()));
                            new p();
                            String str4822222222 = (String) hashMap.get(str4322222222);
                            StringBuilder sb822222222 = new StringBuilder();
                            sb822222222.append(str4822222222);
                            sb822222222.append(hashMap.get(str4522222222));
                            String sb922222222 = sb822222222.toString();
                            StringBuilder sb1022222222 = new StringBuilder();
                            sb1022222222.append(sb922222222);
                            sb1022222222.append(hashMap.get("uid"));
                            String sb1122222222 = sb1022222222.toString();
                            StringBuilder sb1222222222 = new StringBuilder();
                            sb1222222222.append(sb1122222222);
                            sb1222222222.append(hashMap.get("installDate"));
                            String sb1322222222 = sb1222222222.toString();
                            StringBuilder sb1422222222 = new StringBuilder();
                            sb1422222222.append(sb1322222222);
                            sb1422222222.append(hashMap.get("counter"));
                            String sb1522222222 = sb1422222222.toString();
                            StringBuilder sb1622222222 = new StringBuilder();
                            sb1622222222.append(sb1522222222);
                            sb1622222222.append(hashMap.get("iaecounter"));
                            hashMap.put("af_v2", p.m175(p.m178(sb1622222222.toString())));
                            hashMap.put("ivc", Boolean.valueOf(m20(context)));
                            if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                            }
                            if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                            }
                            return hashMap;
                        }
                        if (str19 != null) {
                        }
                        z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                        String string1822222 = sharedPreferences7.getString("androidIdCached", null);
                        if (z5) {
                        }
                        if (appsFlyerLib.f45 != null) {
                        }
                        str20 = null;
                        if (str20 != null) {
                        }
                    } else {
                        str17 = str16;
                    }
                    str19 = null;
                    if (str19 != null) {
                    }
                    z5 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID, true);
                    String string18222222 = sharedPreferences7.getString("androidIdCached", null);
                    if (z5) {
                    }
                    if (appsFlyerLib.f45 != null) {
                    }
                    str20 = null;
                    if (str20 != null) {
                    }
                }
                try {
                    r5 = C0280r.m186(new WeakReference(context2));
                    if (r5 != null) {
                        hashMap.put("uid", r5);
                    }
                } catch (Exception e10) {
                    Exception exc2 = e10;
                    StringBuilder sb17 = new StringBuilder("ERROR: could not get uid ");
                    sb17.append(exc2.getMessage());
                    AFLogger.afErrorLog(sb17.toString(), exc2);
                }
                try {
                    hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
                } catch (Exception e11) {
                    AFLogger.afErrorLog("Exception while collecting display language name. ", e11);
                }
                try {
                    hashMap.put("lang_code", Locale.getDefault().getLanguage());
                } catch (Exception e12) {
                    AFLogger.afErrorLog("Exception while collecting display language code. ", e12);
                }
                try {
                    hashMap.put("country", Locale.getDefault().getCountry());
                } catch (Exception e13) {
                    AFLogger.afErrorLog("Exception while collecting country name. ", e13);
                }
                hashMap.put("platformextension", appsFlyerLib.f47.m180());
                m59(context2, (Map<String, ? super String>) hashMap);
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
                try {
                    long j42222222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    hashMap.put("installDate", simpleDateFormat.format(new Date(j42222222)));
                } catch (Exception e14) {
                    AFLogger.afErrorLog("Exception while collecting install date. ", e14);
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    sharedPreferences3 = sharedPreferences;
                    if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
                        m57(context2, "appsflyerConversionDataRequestRetries", 0);
                        m57(context2, "versionCode", packageInfo.versionCode);
                    }
                    hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
                    hashMap.put("app_version_name", packageInfo.versionName);
                    long j52222222 = packageInfo.firstInstallTime;
                    long j62222222 = packageInfo.lastUpdateTime;
                    String str412222222 = "date1";
                    str18 = str39222;
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    hashMap.put(str412222222, simpleDateFormat.format(new Date(j52222222)));
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    hashMap.put("date2", simpleDateFormat.format(new Date(j62222222)));
                    string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
                    if (string12 == null) {
                        if (!context.getApplicationContext().getSharedPreferences(str38222, 0).contains(str12)) {
                            AFLogger.afDebugLog("AppsFlyer: first launch detected");
                            string12 = simpleDateFormat.format(new Date());
                        } else {
                            string12 = "";
                        }
                        m53(context2, "appsFlyerFirstInstall", string12);
                    }
                    AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
                    hashMap.put("firstLaunchDate", string12);
                } catch (Throwable th8) {
                    th = th8;
                    sharedPreferences3 = sharedPreferences;
                    str18 = str39222;
                    AFLogger.afErrorLog("Exception while collecting app version data ", th);
                    if (str4.length() > 0) {
                    }
                    string10 = sharedPreferences3.getString("extraReferrers", null);
                    if (string10 != null) {
                    }
                    string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                    if (string11 != null) {
                    }
                    appsFlyerLib.f51 = y.m226(context);
                    StringBuilder sb6222222222 = new StringBuilder("didConfigureTokenRefreshService=");
                    sb6222222222.append(appsFlyerLib.f51);
                    AFLogger.afDebugLog(sb6222222222.toString());
                    if (!appsFlyerLib.f51) {
                    }
                    z3 = z2;
                    if (z3) {
                    }
                    if (appsFlyerLib.f43) {
                    }
                    currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                    referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                    if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                    }
                    if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                    }
                    r32 = n.m169(context.getContentResolver());
                    if (r32 != null) {
                    }
                    referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                    hashMap.put("referrer", referrer2);
                    equals = str40222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                    hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                    int r52222222222 = m43(sharedPreferences3, str12, z3);
                    hashMap.put("counter", Integer.toString(r52222222222));
                    hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                    AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                    if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                    }
                    z4 = true;
                    String str42222222222 = "isFirstCall";
                    if (!equals) {
                    }
                    hashMap.put(str42222222222, Boolean.toString(z4));
                    HashMap hashMap2222222222 = new HashMap();
                    hashMap2222222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                    hashMap2222222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                    hashMap2222222222.put("arch", m55("os.arch"));
                    hashMap2222222222.put("build_display_id", m55("ro.build.display.id"));
                    if (z3) {
                    }
                    hashMap2222222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                    hashMap.put("deviceData", hashMap2222222222);
                    new p();
                    String str43222222222 = str18;
                    String str44222222222 = (String) hashMap.get(str43222222222);
                    String str45222222222 = str17;
                    String str46222222222 = (String) hashMap.get(str45222222222);
                    String str47222222222 = (String) hashMap.get("uid");
                    StringBuilder sb7222222222 = new StringBuilder();
                    sb7222222222.append(str44222222222.substring(0, 7));
                    sb7222222222.append(str47222222222.substring(0, 7));
                    sb7222222222.append(str46222222222.substring(str46222222222.length() - 7));
                    hashMap.put("af_v", p.m175(sb7222222222.toString()));
                    new p();
                    String str48222222222 = (String) hashMap.get(str43222222222);
                    StringBuilder sb8222222222 = new StringBuilder();
                    sb8222222222.append(str48222222222);
                    sb8222222222.append(hashMap.get(str45222222222));
                    String sb9222222222 = sb8222222222.toString();
                    StringBuilder sb10222222222 = new StringBuilder();
                    sb10222222222.append(sb9222222222);
                    sb10222222222.append(hashMap.get("uid"));
                    String sb11222222222 = sb10222222222.toString();
                    StringBuilder sb12222222222 = new StringBuilder();
                    sb12222222222.append(sb11222222222);
                    sb12222222222.append(hashMap.get("installDate"));
                    String sb13222222222 = sb12222222222.toString();
                    StringBuilder sb14222222222 = new StringBuilder();
                    sb14222222222.append(sb13222222222);
                    sb14222222222.append(hashMap.get("counter"));
                    String sb15222222222 = sb14222222222.toString();
                    StringBuilder sb16222222222 = new StringBuilder();
                    sb16222222222.append(sb15222222222);
                    sb16222222222.append(hashMap.get("iaecounter"));
                    hashMap.put("af_v2", p.m175(p.m178(sb16222222222.toString())));
                    hashMap.put("ivc", Boolean.valueOf(m20(context)));
                    if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                    }
                    if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                    }
                    return hashMap;
                }
                if (str4.length() > 0) {
                    hashMap.put("referrer", str4);
                }
                string10 = sharedPreferences3.getString("extraReferrers", null);
                if (string10 != null) {
                    hashMap.put("extraReferrers", string10);
                }
                string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                if (string11 != null) {
                    hashMap.put("af_gcm_token", b.m114(string11).m116());
                }
                appsFlyerLib.f51 = y.m226(context);
                StringBuilder sb62222222222 = new StringBuilder("didConfigureTokenRefreshService=");
                sb62222222222.append(appsFlyerLib.f51);
                AFLogger.afDebugLog(sb62222222222.toString());
                if (!appsFlyerLib.f51) {
                    hashMap.put("tokenRefreshConfigured", Boolean.FALSE);
                }
                z3 = z2;
                if (z3) {
                    AFDeepLinkManager.getInstance().processIntentForDeepLink(intent, context2, hashMap);
                    if (appsFlyerLib.f46 != null) {
                        JSONObject jSONObject2 = new JSONObject(appsFlyerLib.f46);
                        jSONObject2.put("isPush", str40222);
                        hashMap.put("af_deeplink", jSONObject2.toString());
                    }
                    appsFlyerLib.f46 = null;
                    hashMap.put("open_referrer", str5);
                }
                if (appsFlyerLib.f43) {
                    hashMap.put("testAppMode_retargeting", str40222);
                    m27(context2, new JSONObject(hashMap).toString());
                    AFLogger.afInfoLog("Sent retargeting params to test app");
                }
                currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
                referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
                if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
                    hashMap.put("testAppMode", str40222);
                    m27(context2, new JSONObject(hashMap).toString());
                    AFLogger.afInfoLog("Sent params to test app");
                    AFLogger.afInfoLog("Test mode ended!");
                    appsFlyerLib.f44 = 0;
                }
                if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
                    n.m168(context2, hashMap);
                    if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) != null) {
                        hashMap.put("GAID_retry", str40222);
                    } else {
                        hashMap.put("GAID_retry", "false");
                    }
                }
                r32 = n.m169(context.getContentResolver());
                if (r32 != null) {
                    hashMap.put("amazon_aid", r32.m156());
                    hashMap.put("amazon_aid_limit", String.valueOf(r32.m157()));
                }
                referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
                if (referrer2 != null && referrer2.length() > 0 && hashMap.get("referrer") == null) {
                    hashMap.put("referrer", referrer2);
                }
                equals = str40222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
                hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
                int r522222222222 = m43(sharedPreferences3, str12, z3);
                hashMap.put("counter", Integer.toString(r522222222222));
                hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
                if (z3 && r522222222222 == 1) {
                    AppsFlyerProperties.getInstance().setFirstLaunchCalled();
                    if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                        z4 = true;
                        hashMap.put("wait_cid", Boolean.toString(true));
                        String str422222222222 = "isFirstCall";
                        if (!equals) {
                            z4 = false;
                        }
                        hashMap.put(str422222222222, Boolean.toString(z4));
                        HashMap hashMap22222222222 = new HashMap();
                        hashMap22222222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                        hashMap22222222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                        hashMap22222222222.put("arch", m55("os.arch"));
                        hashMap22222222222.put("build_display_id", m55("ro.build.display.id"));
                        if (z3) {
                            if (appsFlyerLib.f42) {
                                b bVar = a.f121;
                                Location r15 = b.m119(context);
                                HashMap hashMap3 = new HashMap(3);
                                if (r15 != null) {
                                    hashMap3.put("lat", String.valueOf(r15.getLatitude()));
                                    hashMap3.put("lon", String.valueOf(r15.getLongitude()));
                                    hashMap3.put("ts", String.valueOf(r15.getTime()));
                                }
                                if (!hashMap3.isEmpty()) {
                                    hashMap22222222222.put("loc", hashMap3);
                                }
                            }
                            d r16 = a.f123.m120(context2);
                            hashMap22222222222.put("btl", Float.toString(r16.m122()));
                            if (r16.m121() != null) {
                                hashMap22222222222.put("btch", r16.m121());
                            }
                            if (2 >= r522222222222) {
                                List r17 = i.m147(context).m148();
                                if (!r17.isEmpty()) {
                                    hashMap22222222222.put("sensors", r17);
                                }
                            }
                        }
                        hashMap22222222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                        hashMap.put("deviceData", hashMap22222222222);
                        new p();
                        String str432222222222 = str18;
                        String str442222222222 = (String) hashMap.get(str432222222222);
                        String str452222222222 = str17;
                        String str462222222222 = (String) hashMap.get(str452222222222);
                        String str472222222222 = (String) hashMap.get("uid");
                        StringBuilder sb72222222222 = new StringBuilder();
                        sb72222222222.append(str442222222222.substring(0, 7));
                        sb72222222222.append(str472222222222.substring(0, 7));
                        sb72222222222.append(str462222222222.substring(str462222222222.length() - 7));
                        hashMap.put("af_v", p.m175(sb72222222222.toString()));
                        new p();
                        String str482222222222 = (String) hashMap.get(str432222222222);
                        StringBuilder sb82222222222 = new StringBuilder();
                        sb82222222222.append(str482222222222);
                        sb82222222222.append(hashMap.get(str452222222222));
                        String sb92222222222 = sb82222222222.toString();
                        StringBuilder sb102222222222 = new StringBuilder();
                        sb102222222222.append(sb92222222222);
                        sb102222222222.append(hashMap.get("uid"));
                        String sb112222222222 = sb102222222222.toString();
                        StringBuilder sb122222222222 = new StringBuilder();
                        sb122222222222.append(sb112222222222);
                        sb122222222222.append(hashMap.get("installDate"));
                        String sb132222222222 = sb122222222222.toString();
                        StringBuilder sb142222222222 = new StringBuilder();
                        sb142222222222.append(sb132222222222);
                        sb142222222222.append(hashMap.get("counter"));
                        String sb152222222222 = sb142222222222.toString();
                        StringBuilder sb162222222222 = new StringBuilder();
                        sb162222222222.append(sb152222222222);
                        sb162222222222.append(hashMap.get("iaecounter"));
                        hashMap.put("af_v2", p.m175(p.m178(sb162222222222.toString())));
                        hashMap.put("ivc", Boolean.valueOf(m20(context)));
                        if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                            hashMap.put("istu", String.valueOf(sharedPreferences3.getBoolean(IS_STOP_TRACKING_USED, false)));
                        }
                        if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                            hashMap.put("is_dp_api", String.valueOf(AppsFlyerProperties.getInstance().getBoolean("consumeAfDeepLink", false)));
                        }
                        return hashMap;
                    }
                }
                z4 = true;
                String str4222222222222 = "isFirstCall";
                if (!equals) {
                }
                hashMap.put(str4222222222222, Boolean.toString(z4));
                HashMap hashMap222222222222 = new HashMap();
                hashMap222222222222.put("cpu_abi", m55("ro.product.cpu.abi"));
                hashMap222222222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
                hashMap222222222222.put("arch", m55("os.arch"));
                hashMap222222222222.put("build_display_id", m55("ro.build.display.id"));
                if (z3) {
                }
                hashMap222222222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
                hashMap.put("deviceData", hashMap222222222222);
                new p();
                String str4322222222222 = str18;
                String str4422222222222 = (String) hashMap.get(str4322222222222);
                String str4522222222222 = str17;
                String str4622222222222 = (String) hashMap.get(str4522222222222);
                String str4722222222222 = (String) hashMap.get("uid");
                StringBuilder sb722222222222 = new StringBuilder();
                sb722222222222.append(str4422222222222.substring(0, 7));
                sb722222222222.append(str4722222222222.substring(0, 7));
                sb722222222222.append(str4622222222222.substring(str4622222222222.length() - 7));
                hashMap.put("af_v", p.m175(sb722222222222.toString()));
                new p();
                String str4822222222222 = (String) hashMap.get(str4322222222222);
                StringBuilder sb822222222222 = new StringBuilder();
                sb822222222222.append(str4822222222222);
                sb822222222222.append(hashMap.get(str4522222222222));
                String sb922222222222 = sb822222222222.toString();
                StringBuilder sb1022222222222 = new StringBuilder();
                sb1022222222222.append(sb922222222222);
                sb1022222222222.append(hashMap.get("uid"));
                String sb1122222222222 = sb1022222222222.toString();
                StringBuilder sb1222222222222 = new StringBuilder();
                sb1222222222222.append(sb1122222222222);
                sb1222222222222.append(hashMap.get("installDate"));
                String sb1322222222222 = sb1222222222222.toString();
                StringBuilder sb1422222222222 = new StringBuilder();
                sb1422222222222.append(sb1322222222222);
                sb1422222222222.append(hashMap.get("counter"));
                String sb1522222222222 = sb1422222222222.toString();
                StringBuilder sb1622222222222 = new StringBuilder();
                sb1622222222222.append(sb1522222222222);
                sb1622222222222.append(hashMap.get("iaecounter"));
                hashMap.put("af_v2", p.m175(p.m178(sb1622222222222.toString())));
                hashMap.put("ivc", Boolean.valueOf(m20(context)));
                if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
                }
                if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
                }
                return hashMap;
            }
        }
        string13 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY);
        if (string13 != null || string13.length() < 0) {
            AFLogger.afInfoLog("AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.getInstance().setAppsFlyerKey(...) to set it. ");
            m39(context2, LOG_TAG, "DEV_KEY_MISSING", (String) null);
            AFLogger.afInfoLog("AppsFlyer will not track this event.");
            return null;
        }
        hashMap.put(str39222, string13);
        string6 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string6 != null) {
        }
        string7 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.USER_EMAILS);
        if (string7 == null) {
        }
        if (str24 != null) {
        }
        str15 = str8;
        if (AppsFlyerProperties.getInstance().getString(str15) != null) {
        }
        string8 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CURRENCY_CODE);
        if (string8 != null) {
        }
        string9 = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.IS_UPDATE);
        if (string9 != null) {
        }
        hashMap.put("af_preinstalled", Boolean.toString(isPreInstalledApp(context)));
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_FACEBOOK_ATTR_ID, true)) {
        }
        String str402222 = "true";
        if (!AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
        }
        r5 = C0280r.m186(new WeakReference(context2));
        if (r5 != null) {
        }
        hashMap.put("lang", Locale.getDefault().getDisplayLanguage());
        hashMap.put("lang_code", Locale.getDefault().getLanguage());
        hashMap.put("country", Locale.getDefault().getCountry());
        hashMap.put("platformextension", appsFlyerLib.f47.m180());
        m59(context2, (Map<String, ? super String>) hashMap);
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US);
        long j422222222 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        hashMap.put("installDate", simpleDateFormat.format(new Date(j422222222)));
        packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        sharedPreferences3 = sharedPreferences;
        if (packageInfo.versionCode > sharedPreferences3.getInt("versionCode", 0)) {
        }
        hashMap.put("app_version_code", Integer.toString(packageInfo.versionCode));
        hashMap.put("app_version_name", packageInfo.versionName);
        long j522222222 = packageInfo.firstInstallTime;
        long j622222222 = packageInfo.lastUpdateTime;
        String str4122222222 = "date1";
        str18 = str39222;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        hashMap.put(str4122222222, simpleDateFormat.format(new Date(j522222222)));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        hashMap.put("date2", simpleDateFormat.format(new Date(j622222222)));
        string12 = context.getApplicationContext().getSharedPreferences(str38222, 0).getString("appsFlyerFirstInstall", null);
        if (string12 == null) {
        }
        AFLogger.afInfoLog("AppsFlyer: first launch date: ".concat(String.valueOf(string12)));
        hashMap.put("firstLaunchDate", string12);
        if (str4.length() > 0) {
        }
        string10 = sharedPreferences3.getString("extraReferrers", null);
        if (string10 != null) {
        }
        string11 = AppsFlyerProperties.getInstance().getString("afUninstallToken");
        if (string11 != null) {
        }
        appsFlyerLib.f51 = y.m226(context);
        StringBuilder sb622222222222 = new StringBuilder("didConfigureTokenRefreshService=");
        sb622222222222.append(appsFlyerLib.f51);
        AFLogger.afDebugLog(sb622222222222.toString());
        if (!appsFlyerLib.f51) {
        }
        z3 = z2;
        if (z3) {
        }
        if (appsFlyerLib.f43) {
        }
        currentTimeMillis = System.currentTimeMillis() - appsFlyerLib.f44;
        referrer = AppsFlyerProperties.getInstance().getReferrer(context2);
        if (currentTimeMillis > 30000 && referrer != null && referrer.contains("AppsFlyer_Test")) {
        }
        if (AppsFlyerProperties.getInstance().getString(ServerParameters.ADVERTISING_ID_PARAM) == null) {
        }
        r32 = n.m169(context.getContentResolver());
        if (r32 != null) {
        }
        referrer2 = AppsFlyerProperties.getInstance().getReferrer(context2);
        hashMap.put("referrer", referrer2);
        equals = str402222.equals(sharedPreferences3.getString("sentSuccessfully", ""));
        hashMap.put("registeredUninstall", Boolean.valueOf(sharedPreferences3.getBoolean("sentRegisterRequestToAF", false)));
        int r5222222222222 = m43(sharedPreferences3, str12, z3);
        hashMap.put("counter", Integer.toString(r5222222222222));
        hashMap.put("iaecounter", Integer.toString(m43(sharedPreferences3, "appsFlyerInAppEventCount", str24 != null)));
        AppsFlyerProperties.getInstance().setFirstLaunchCalled();
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
        }
        z4 = true;
        String str42222222222222 = "isFirstCall";
        if (!equals) {
        }
        hashMap.put(str42222222222222, Boolean.toString(z4));
        HashMap hashMap2222222222222 = new HashMap();
        hashMap2222222222222.put("cpu_abi", m55("ro.product.cpu.abi"));
        hashMap2222222222222.put("cpu_abi2", m55("ro.product.cpu.abi2"));
        hashMap2222222222222.put("arch", m55("os.arch"));
        hashMap2222222222222.put("build_display_id", m55("ro.build.display.id"));
        if (z3) {
        }
        hashMap2222222222222.put(AFScreenManager.SCREEN_KEY, AFScreenManager.getScreenMetrics(context));
        hashMap.put("deviceData", hashMap2222222222222);
        new p();
        String str43222222222222 = str18;
        String str44222222222222 = (String) hashMap.get(str43222222222222);
        String str45222222222222 = str17;
        String str46222222222222 = (String) hashMap.get(str45222222222222);
        String str47222222222222 = (String) hashMap.get("uid");
        StringBuilder sb7222222222222 = new StringBuilder();
        sb7222222222222.append(str44222222222222.substring(0, 7));
        sb7222222222222.append(str47222222222222.substring(0, 7));
        sb7222222222222.append(str46222222222222.substring(str46222222222222.length() - 7));
        hashMap.put("af_v", p.m175(sb7222222222222.toString()));
        new p();
        String str48222222222222 = (String) hashMap.get(str43222222222222);
        StringBuilder sb8222222222222 = new StringBuilder();
        sb8222222222222.append(str48222222222222);
        sb8222222222222.append(hashMap.get(str45222222222222));
        String sb9222222222222 = sb8222222222222.toString();
        StringBuilder sb10222222222222 = new StringBuilder();
        sb10222222222222.append(sb9222222222222);
        sb10222222222222.append(hashMap.get("uid"));
        String sb11222222222222 = sb10222222222222.toString();
        StringBuilder sb12222222222222 = new StringBuilder();
        sb12222222222222.append(sb11222222222222);
        sb12222222222222.append(hashMap.get("installDate"));
        String sb13222222222222 = sb12222222222222.toString();
        StringBuilder sb14222222222222 = new StringBuilder();
        sb14222222222222.append(sb13222222222222);
        sb14222222222222.append(hashMap.get("counter"));
        String sb15222222222222 = sb14222222222222.toString();
        StringBuilder sb16222222222222 = new StringBuilder();
        sb16222222222222.append(sb15222222222222);
        sb16222222222222.append(hashMap.get("iaecounter"));
        hashMap.put("af_v2", p.m175(p.m178(sb16222222222222.toString())));
        hashMap.put("ivc", Boolean.valueOf(m20(context)));
        if (sharedPreferences3.contains(IS_STOP_TRACKING_USED)) {
        }
        if (AppsFlyerProperties.getInstance().getObject("consumeAfDeepLink") != null) {
        }
        return hashMap;
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static Map<String, String> m34(Context context, String str) {
        String str2;
        String str3;
        String str4 = "install_time";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] split = str.split("&");
        int length = split.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            str2 = "media_source";
            if (i2 < length) {
                String str5 = split[i2];
                int indexOf = str5.indexOf("=");
                String substring = indexOf > 0 ? str5.substring(0, indexOf) : str5;
                if (!linkedHashMap.containsKey(substring)) {
                    if (substring.equals(Constants.URL_CAMPAIGN)) {
                        str2 = "campaign";
                    } else if (!substring.equals(Constants.URL_MEDIA_SOURCE)) {
                        if (substring.equals("af_prt")) {
                            z = true;
                            str2 = "agency";
                        }
                        linkedHashMap.put(substring, "");
                    }
                    substring = str2;
                    linkedHashMap.put(substring, "");
                }
                if (indexOf > 0) {
                    int i3 = indexOf + 1;
                    if (str5.length() > i3) {
                        str3 = str5.substring(i3);
                        linkedHashMap.put(substring, str3);
                        i2++;
                    }
                }
                str3 = null;
                linkedHashMap.put(substring, str3);
                i2++;
            } else {
                try {
                    break;
                } catch (Exception e2) {
                    AFLogger.afErrorLog("Could not fetch install time. ", e2);
                }
            }
        }
        if (!linkedHashMap.containsKey(str4)) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
            long j2 = packageInfo.firstInstallTime;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            linkedHashMap.put(str4, simpleDateFormat.format(new Date(j2)));
        }
        String str6 = "af_status";
        if (!linkedHashMap.containsKey(str6)) {
            linkedHashMap.put(str6, "Non-organic");
        }
        if (z) {
            linkedHashMap.remove(str2);
        }
        return linkedHashMap;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private static void m59(Context context, Map<String, ? super String> map) {
        h hVar = d.f151;
        a r2 = h.m140(context);
        map.put("network", r2.m143());
        if (r2.m144() != null) {
            map.put("operator", r2.m144());
        }
        if (r2.m145() != null) {
            map.put("carrier", r2.m145());
        }
    }

    /* renamed from: ˏ reason: contains not printable characters */
    private static String m55(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0227 A[SYNTHETIC, Splitter:B:103:0x0227] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0235 A[Catch:{ k -> 0x020e, all -> 0x0233 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0243  */
    /* renamed from: ˏ reason: contains not printable characters */
    private void m60(URL url, String str, String str2, WeakReference<Context> weakReference, String str3, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        OutputStreamWriter outputStreamWriter;
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        String str7 = "is_first_launch";
        String str8 = "appsflyerConversionDataCacheExpiration";
        Context context = (Context) weakReference.get();
        boolean z2 = z && f35 != null;
        try {
            s.m191().m198(url.toString(), str4);
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(str.getBytes().length));
                httpURLConnection2.setRequestProperty("Content-Type", C0730a.ACCEPT_JSON_VALUE);
                httpURLConnection2.setConnectTimeout(C0730a.DEFAULT_TIMEOUT);
                httpURLConnection2.setDoOutput(true);
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(httpURLConnection2.getOutputStream(), "UTF-8");
                    try {
                        outputStreamWriter2.write(str4);
                        outputStreamWriter2.close();
                        int responseCode = httpURLConnection2.getResponseCode();
                        String r12 = m47(httpURLConnection2);
                        s.m191().m204(url.toString(), responseCode, r12);
                        AFLogger.afInfoLog("response code: ".concat(String.valueOf(responseCode)));
                        m39(context, LOG_TAG, "SERVER_RESPONSE_CODE", Integer.toString(responseCode));
                        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
                        if (responseCode == 200) {
                            if (weakReference.get() != null && z) {
                                this.f53 = System.currentTimeMillis();
                                if (f26 != null) {
                                    f26.onTrackingRequestSuccess();
                                }
                            }
                            String string = AppsFlyerProperties.getInstance().getString("afUninstallToken");
                            if (string != null) {
                                AFLogger.afDebugLog("Uninstall Token exists: ".concat(String.valueOf(string)));
                                if (!sharedPreferences.getBoolean("sentRegisterRequestToAF", false)) {
                                    AFLogger.afDebugLog("Resending Uninstall token to AF servers: ".concat(String.valueOf(string)));
                                    y.m228(context, new b(string));
                                }
                            } else {
                                if (AppsFlyerProperties.getInstance().getString("gcmProjectNumber") != null) {
                                    AFLogger.afDebugLog("GCM Project number exists. Fetching token and sending to AF servers");
                                    new a(new WeakReference(context)).execute(new Void[0]);
                                }
                            }
                            if (this.latestDeepLink != null) {
                                this.latestDeepLink = null;
                            }
                            if (str6 != null) {
                                CacheManager.getInstance().deleteRequest(str6, context);
                            }
                            if (weakReference.get() != null && str6 == null) {
                                m53(context, "sentSuccessfully", "true");
                                if (!this.f56) {
                                    httpURLConnection = httpURLConnection2;
                                    try {
                                        if (System.currentTimeMillis() - this.f57 >= 15000) {
                                            if (this.f37 == null) {
                                                this.f37 = AFExecutor.getInstance().m4();
                                                m40(this.f37, (Runnable) new c(context), 1, TimeUnit.SECONDS);
                                            }
                                        }
                                        this.f49 = ServerConfigHandler.m100(r12).optBoolean("send_background", false);
                                    } catch (k e2) {
                                        AFLogger.afErrorLog(e2.getMessage(), e2);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            httpURLConnection = httpURLConnection2;
                            this.f49 = ServerConfigHandler.m100(r12).optBoolean("send_background", false);
                        } else {
                            httpURLConnection = httpURLConnection2;
                            if (f26 != null) {
                                f26.onTrackingRequestFailure("Failure: ".concat(String.valueOf(responseCode)));
                            }
                        }
                        int i2 = sharedPreferences.getInt("appsflyerConversionDataRequestRetries", 0);
                        long j2 = sharedPreferences.getLong(str8, 0);
                        String str9 = "attributionId";
                        if (j2 != 0) {
                            if (System.currentTimeMillis() - j2 > 5184000000L) {
                                m53(context, str9, (String) null);
                                m52(context, str8, 0);
                            }
                        }
                        if (sharedPreferences.getString(str9, null) == null && str5 != null && z2 && f35 != null && i2 <= 5) {
                            ScheduledThreadPoolExecutor r0 = AFExecutor.getInstance().m4();
                            m40((ScheduledExecutorService) r0, (Runnable) new e(context.getApplicationContext(), str5, r0), 10, TimeUnit.MILLISECONDS);
                        } else if (str5 == null) {
                            AFLogger.afWarnLog("AppsFlyer dev key is missing.");
                        } else if (z2 && f35 != null && sharedPreferences.getString(str9, null) != null && m43(sharedPreferences, "appsFlyerCount", false) > 1) {
                            Map r02 = m25(context);
                            if (r02 != null) {
                                try {
                                    if (!r02.containsKey(str7)) {
                                        r02.put(str7, Boolean.toString(false));
                                    }
                                    f35.onInstallConversionDataLoaded(r02);
                                } catch (Throwable th2) {
                                    AFLogger.afErrorLog(th2.getLocalizedMessage(), th2);
                                }
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpURLConnection = httpURLConnection2;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter == null) {
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStreamWriter = null;
                    httpURLConnection = httpURLConnection2;
                    if (outputStreamWriter == null) {
                        outputStreamWriter.close();
                    } else if (f26 != null) {
                        f26.onTrackingRequestFailure("No Connectivity");
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static boolean m69(Context context) {
        try {
            if (com.google.android.gms.common.e.a().b(context) == 0) {
                return true;
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("WARNING:  Google play services is unavailable. ", th);
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            return true;
        } catch (NameNotFoundException e2) {
            AFLogger.afErrorLog("WARNING:  Google Play Services is unavailable. ", e2);
            return false;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0042 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034 A[SYNTHETIC, Splitter:B:18:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC, Splitter:B:32:0x0060] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0042=Splitter:B:24:0x0042, B:15:0x002b=Splitter:B:15:0x002b} */
    /* renamed from: ॱ reason: contains not printable characters */
    private static String m65(File file, String str) {
        InputStreamReader inputStreamReader;
        try {
            Properties properties = new Properties();
            inputStreamReader = new FileReader(file);
            try {
                properties.load(inputStreamReader);
                AFLogger.afInfoLog("Found PreInstall property!");
                String property = properties.getProperty(str);
                try {
                    inputStreamReader.close();
                } catch (Throwable th) {
                    AFLogger.afErrorLog(th.getMessage(), th);
                }
                return property;
            } catch (FileNotFoundException ) {
                StringBuilder sb = new StringBuilder("PreInstall file wasn't found: ");
                sb.append(file.getAbsolutePath());
                AFLogger.afDebugLog(sb.toString());
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                try {
                    AFLogger.afErrorLog(th.getMessage(), th);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable th3) {
                            AFLogger.afErrorLog(th3.getMessage(), th3);
                        }
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    if (inputStreamReader != null) {
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException unused) {
            inputStreamReader = null;
        } catch (Throwable th5) {
            th = th5;
            inputStreamReader = null;
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Throwable th6) {
                    AFLogger.afErrorLog(th6.getMessage(), th6);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ reason: contains not printable characters */
    public static Map<String, String> m35(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!f34.contains(str2)) {
                    String string = jSONObject.getString(str2);
                    if (!TextUtils.isEmpty(string) && !"null".equals(string)) {
                        hashMap.put(str2, string);
                    }
                }
            }
            return hashMap;
        } catch (JSONException e2) {
            AFLogger.afErrorLog(e2.getMessage(), e2);
            return null;
        }
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static String m32(String str, PackageManager packageManager, String str2) {
        try {
            Bundle bundle = packageManager.getApplicationInfo(str2, 128).metaData;
            if (bundle == null) {
                return null;
            }
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Could not find ");
            sb.append(str);
            sb.append(" value in the manifest");
            AFLogger.afErrorLog(sb.toString(), th);
            return null;
        }
    }

    /* renamed from: ॱ reason: contains not printable characters */
    private static File m64(String str) {
        if (str != null) {
            try {
                if (str.trim().length() > 0) {
                    return new File(str.trim());
                }
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˋ reason: contains not printable characters */
    public static String m33(WeakReference<Context> weakReference) {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = m46(weakReference, "CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }

    /* renamed from: ˋ reason: contains not printable characters */
    private static void m40(ScheduledExecutorService scheduledExecutorService, Runnable runnable, long j2, TimeUnit timeUnit) {
        if (scheduledExecutorService != null) {
            try {
                if (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    scheduledExecutorService.schedule(runnable, j2, timeUnit);
                    return;
                }
            } catch (RejectedExecutionException e2) {
                AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e2);
                return;
            } catch (Throwable th) {
                AFLogger.afErrorLog("scheduleJob failed with Exception", th);
                return;
            }
        }
        AFLogger.afWarnLog("scheduler is null, shut downed or terminated");
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ reason: contains not printable characters */
    public static void m57(Context context, String str, int i2) {
        Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putInt(str, i2);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private static String m46(WeakReference<Context> weakReference, String str) {
        if (weakReference.get() == null) {
            return null;
        }
        return m32(str, ((Context) weakReference.get()).getPackageManager(), ((Context) weakReference.get()).getPackageName());
    }

    /* renamed from: ˎ reason: contains not printable characters */
    static SharedPreferences m44(Context context) {
        return context.getApplicationContext().getSharedPreferences("appsflyer-data", 0);
    }

    /* renamed from: ˎ reason: contains not printable characters */
    private static int m43(SharedPreferences sharedPreferences, String str, boolean z) {
        int i2 = sharedPreferences.getInt(str, 0);
        if (z) {
            i2++;
            Editor edit = sharedPreferences.edit();
            edit.putInt(str, i2);
            if (VERSION.SDK_INT >= 9) {
                edit.apply();
            } else {
                edit.commit();
            }
        }
        if (s.m191().m196()) {
            s.m191().m203(String.valueOf(i2));
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r3 != null) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[SYNTHETIC, Splitter:B:27:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0086 A[SYNTHETIC, Splitter:B:45:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A[Catch:{ Throwable -> 0x008e }] */
    /* renamed from: ˎ reason: contains not printable characters */
    static String m47(HttpURLConnection httpURLConnection) {
        InputStreamReader inputStreamReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream == null) {
                errorStream = httpURLConnection.getInputStream();
            }
            inputStreamReader = new InputStreamReader(errorStream);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                            sb.append(10);
                        } else {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (Throwable th2) {
                th = th2;
                StringBuilder sb2 = new StringBuilder("Could not read connection response from: ");
                sb2.append(httpURLConnection.getURL().toString());
                AFLogger.afErrorLog(sb2.toString(), th);
                if (bufferedReader != null) {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused2) {
                    throw th;
                }
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            throw th;
        }
        inputStreamReader.close();
        String sb3 = sb.toString();
        try {
            new JSONObject(sb3);
            return sb3;
        } catch (JSONException unused3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("string_response", sb3);
                return jSONObject.toString();
            } catch (JSONException unused4) {
                return new JSONObject().toString();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ reason: contains not printable characters */
    public static void m53(Context context, String str, String str2) {
        Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putString(str, str2);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ reason: contains not printable characters */
    public static void m52(Context context, String str, long j2) {
        Editor edit = context.getApplicationContext().getSharedPreferences("appsflyer-data", 0).edit();
        edit.putLong(str, j2);
        if (VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
    }
}
