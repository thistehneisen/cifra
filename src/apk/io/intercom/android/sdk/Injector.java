package io.intercom.android.sdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import e.a.a.a.a.d;
import e.a.a.a.a.n;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.api.ApiFactory;
import io.intercom.android.sdk.api.DeDuper;
import io.intercom.android.sdk.api.TaggingSocketFactory;
import io.intercom.android.sdk.api.UserUpdateBatcher;
import io.intercom.android.sdk.commons.utilities.TimeProvider;
import io.intercom.android.sdk.conversation.SoundPlayer;
import io.intercom.android.sdk.errorreporting.ErrorReporter;
import io.intercom.android.sdk.exceptions.IntercomIntegrationException;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.identity.AppIdentity;
import io.intercom.android.sdk.identity.UserIdentity;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.MetricTracker;
import io.intercom.android.sdk.metrics.MetricsStore;
import io.intercom.android.sdk.metrics.ops.OpsMetricTracker;
import io.intercom.android.sdk.nexus.NexusClient;
import io.intercom.android.sdk.overlay.OverlayPresenter;
import io.intercom.android.sdk.push.SystemNotificationManager;
import io.intercom.android.sdk.state.State;
import io.intercom.android.sdk.store.Store;
import io.intercom.android.sdk.store.StoreFactory;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.ActivityFinisher;
import io.intercom.android.sdk.utilities.PreferenceKeys;
import io.intercom.android.sdk.utilities.SystemSettings;
import io.intercom.android.sdk.utilities.UuidStringProvider;
import io.intercom.com.bumptech.glide.c;
import io.intercom.com.google.gson.o;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;

public class Injector {
    private static final int NEXUS_TRAFFIC_TAG = 63987;
    private static final Twig TWIG = LumberMill.getLogger();
    @SuppressLint({"StaticFieldLeak"})
    private static Injector instance;
    private final ActivityFinisher activityFinisher = new ActivityFinisher();
    private Api api;
    private final Provider<Api> apiProvider = new Provider<Api>() {
        public Api get() {
            return Injector.this.getApi();
        }
    };
    /* access modifiers changed from: private */
    public final AppConfig appConfig;
    private final Provider<AppConfig> appConfigProvider = new Provider<AppConfig>() {
        public AppConfig get() {
            return Injector.this.appConfig;
        }
    };
    private final AppIdentity appIdentity;
    private final Application application;
    private MainThreadBus bus;
    private ErrorReporter errorReporter;
    private o gson;
    private LifecycleTracker lifecycleTracker;
    private MetricTracker metricTracker;
    private final Provider<MetricTracker> metricTrackerProvider = new Provider<MetricTracker>() {
        public MetricTracker get() {
            return Injector.this.getMetricTracker();
        }
    };
    private MetricsStore metricsStore;
    private NexusWrapper nexusClient;
    private final Provider<NexusClient> nexusClientProvider = new Provider<NexusClient>() {
        public NexusClient get() {
            return Injector.this.getNexusClient();
        }
    };
    private OpsMetricTracker opsMetricTracker;
    private final Provider<OverlayPresenter> overlayManagerProvider = new Provider<OverlayPresenter>() {
        public OverlayPresenter get() {
            return Injector.this.getOverlayPresenter();
        }
    };
    private OverlayPresenter overlayPresenter;
    private ResetManager resetManager;
    private Store<State> store;
    private DeDuper superDeDuper;
    private SystemNotificationManager systemNotificationManager;
    private final UserIdentity userIdentity;
    private final Provider<UserIdentity> userIdentityProvider = new Provider<UserIdentity>() {
        public UserIdentity get() {
            return Injector.this.getUserIdentity();
        }
    };
    private UserUpdateBatcher userUpdateBatcher;
    private final Provider<UserUpdateBatcher> userUpdateBatcherProvider = new Provider<UserUpdateBatcher>() {
        public UserUpdateBatcher get() {
            return Injector.this.getUserUpdateBatcher();
        }
    };

    protected Injector(Application application2, AppIdentity appIdentity2, AppConfig appConfig2, UserIdentity userIdentity2) {
        this.application = application2;
        this.appIdentity = appIdentity2;
        this.appConfig = appConfig2;
        this.userIdentity = userIdentity2;
    }

    public static synchronized Injector get() {
        Injector injector;
        synchronized (Injector.class) {
            if (instance != null) {
                injector = instance;
            } else {
                throw new IntercomIntegrationException("Intercom was not initialized correctly, Intercom.initialize() needs to be called in onCreate() in your Application class.");
            }
        }
        return injector;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        return;
     */
    public static synchronized void initIfCachedCredentials(Application application2) {
        synchronized (Injector.class) {
            if (instance == null) {
                AppIdentity loadFromDevice = AppIdentity.loadFromDevice(application2);
                String apiKey = loadFromDevice.apiKey();
                String appId = loadFromDevice.appId();
                if (!appId.isEmpty() && !apiKey.isEmpty()) {
                    initWithAppCredentials(application2, apiKey, appId);
                }
            }
        }
    }

    public static synchronized void initWithAppCredentials(Application application2, String str, String str2) {
        synchronized (Injector.class) {
            if (instance == null) {
                TWIG.internal("Injector", "Initializing");
                AppIdentity create = AppIdentity.create(str, str2);
                create.persist(application2);
                instance = new Injector(application2, create, new AppConfig(application2), new UserIdentity(application2));
                application2.registerActivityLifecycleCallbacks(instance.getLifecycleTracker());
            }
        }
    }

    public static synchronized boolean isNotInitialised() {
        boolean z;
        synchronized (Injector.class) {
            z = instance == null;
        }
        return z;
    }

    static void setSharedInstance(Injector injector) {
        instance = injector;
    }

    public ActivityFinisher getActivityFinisher() {
        return this.activityFinisher;
    }

    public synchronized Api getApi() {
        if (this.api == null) {
            this.api = ApiFactory.create(getApplication(), this.appIdentity, this.userIdentity, getBus(), getStore(), ApiFactory.getHostname(this.appIdentity), this.appConfigProvider, getGson());
        }
        this.api.updateMaxRequests();
        return this.api;
    }

    public Provider<Api> getApiProvider() {
        return this.apiProvider;
    }

    public Provider<AppConfig> getAppConfigProvider() {
        return this.appConfigProvider;
    }

    public AppIdentity getAppIdentity() {
        return this.appIdentity;
    }

    public Application getApplication() {
        return this.application;
    }

    public synchronized d getBus() {
        if (this.bus == null) {
            this.bus = new MainThreadBus(n.f7870a);
        }
        return this.bus;
    }

    public synchronized DeDuper getDeDuper() {
        if (this.superDeDuper == null) {
            this.superDeDuper = new DeDuper(this.appConfigProvider, this.application.getSharedPreferences(PreferenceKeys.INTERCOM_DEDUPER_PREFS, 0));
            this.superDeDuper.readPersistedCachedAttributes();
        }
        return this.superDeDuper;
    }

    public synchronized ErrorReporter getErrorReporter() {
        if (this.errorReporter == null) {
            this.errorReporter = ErrorReporter.create(this.application, getGson(), this.apiProvider);
        }
        return this.errorReporter;
    }

    public synchronized o getGson() {
        if (this.gson == null) {
            this.gson = new o();
        }
        return this.gson;
    }

    public synchronized LifecycleTracker getLifecycleTracker() {
        if (this.lifecycleTracker == null) {
            this.lifecycleTracker = LifecycleTracker.create(getSystemNotificationManager(), getMetricsStore(), getErrorReporter(), getDeDuper(), getTimeProvider(), getUserUpdateBatcher(), getStore(), getResetManager(), SystemSettings.getTransitionScale(this.application));
        }
        return this.lifecycleTracker;
    }

    public synchronized MetricTracker getMetricTracker() {
        if (this.metricTracker == null) {
            this.metricTracker = new MetricTracker(this.userIdentity, getMetricsStore(), getApplication());
        }
        return this.metricTracker;
    }

    public synchronized MetricsStore getMetricsStore() {
        if (this.metricsStore == null) {
            this.metricsStore = new MetricsStore(getApplication(), getApiProvider(), this.appConfigProvider);
        }
        return this.metricsStore;
    }

    public synchronized NexusClient getNexusClient() {
        if (this.nexusClient == null) {
            NexusWrapper nexusWrapper = new NexusWrapper(LumberMill.getNexusTwig(), NexusClient.defaultOkHttpClientBuilder().socketFactory(new TaggingSocketFactory(SocketFactory.getDefault(), NEXUS_TRAFFIC_TAG)).build(), getBus(), getStore(), getNexusDebouncePeriod());
            this.nexusClient = nexusWrapper;
        }
        return this.nexusClient;
    }

    /* access modifiers changed from: protected */
    public long getNexusDebouncePeriod() {
        return TimeUnit.SECONDS.toMillis(1);
    }

    public synchronized OpsMetricTracker getOpsMetricTracker() {
        if (this.opsMetricTracker == null) {
            this.opsMetricTracker = new OpsMetricTracker(getMetricsStore(), getTimeProvider(), UuidStringProvider.SYSTEM);
        }
        return this.opsMetricTracker;
    }

    public synchronized OverlayPresenter getOverlayPresenter() {
        if (this.overlayPresenter == null) {
            OverlayPresenter overlayPresenter2 = new OverlayPresenter(getApplication(), getBus(), getStore(), this.appConfigProvider, getMetricTracker(), this.userIdentity, c.b((Context) this.application));
            this.overlayPresenter = overlayPresenter2;
        }
        return this.overlayPresenter;
    }

    public synchronized ResetManager getResetManager() {
        if (this.resetManager == null) {
            ResetManager resetManager2 = new ResetManager(getApiProvider(), getUserIdentity(), getOverlayPresenter(), this.appConfigProvider, getStore(), getUserUpdateBatcher(), this.application, this.activityFinisher);
            this.resetManager = resetManager2;
        }
        return this.resetManager;
    }

    public synchronized Store<State> getStore() {
        if (this.store == null) {
            this.store = StoreFactory.createStore(this.apiProvider, this.appConfigProvider, this.nexusClientProvider, this.overlayManagerProvider, this.userUpdateBatcherProvider, new SoundPlayer(this.application, this.appConfigProvider), this.userIdentityProvider, this.application, LumberMill.getLogger(), getBus(), this.metricTrackerProvider);
        }
        return this.store;
    }

    public synchronized SystemNotificationManager getSystemNotificationManager() {
        if (this.systemNotificationManager == null) {
            this.systemNotificationManager = new SystemNotificationManager((NotificationManager) this.application.getSystemService("notification"));
        }
        return this.systemNotificationManager;
    }

    public TimeProvider getTimeProvider() {
        return TimeProvider.SYSTEM;
    }

    public UserIdentity getUserIdentity() {
        return this.userIdentity;
    }

    public synchronized UserUpdateBatcher getUserUpdateBatcher() {
        if (this.userUpdateBatcher == null) {
            this.userUpdateBatcher = UserUpdateBatcher.create(getApiProvider(), this.appConfigProvider, getStore());
        }
        return this.userUpdateBatcher;
    }

    public Provider<UserUpdateBatcher> getUserUpdateBatcherProvider() {
        return this.userUpdateBatcherProvider;
    }
}
