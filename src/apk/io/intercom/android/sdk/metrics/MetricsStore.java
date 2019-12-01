package io.intercom.android.sdk.metrics;

import android.content.Context;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.metrics.ops.OpsMetricObject;
import io.intercom.android.sdk.persistence.JsonStorage;
import io.intercom.android.sdk.persistence.JsonStorage.LoadFailureHandler;
import io.intercom.android.sdk.persistence.JsonStorage.LoadHandler;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.android.sdk.utilities.IoUtils;
import io.intercom.com.google.gson.o;
import io.intercom.retrofit2.Call;
import io.intercom.retrofit2.Callback;
import io.intercom.retrofit2.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MetricsStore {
    private static final String METRICS_DIR = "intercomMetrics";
    private static final String OPS_METRICS_DIR = "intercomOpsMetrics";
    private static final int STORED_METRIC_LIMIT = 200;
    private static final int STORED_OP_METRIC_LIMIT = 100;
    private final Provider<Api> apiProvider;
    private final Provider<AppConfig> appConfigProvider;
    private final LoadFailureHandler deleteOnFailureHandler;
    /* access modifiers changed from: private */
    public final Executor executor;
    private final String installerPackageName;
    private final boolean isDebugBuild;
    private final File metricsDir;
    private final File opsMetricsDir;
    /* access modifiers changed from: private */
    public final JsonStorage storage;
    /* access modifiers changed from: private */
    public final Twig twig;

    public MetricsStore(Context context, Provider<Api> provider, Provider<AppConfig> provider2) {
        this(provider, provider2, Executors.newSingleThreadExecutor(), new JsonStorage(new o()), new File(context.getCacheDir(), METRICS_DIR), new File(context.getCacheDir(), OPS_METRICS_DIR), AppTypeDetector.isDebugBuild(context), AppTypeDetector.getInstallerPackageName(context), LumberMill.getLogger());
    }

    /* access modifiers changed from: private */
    public static <T> void copyNonNullItems(List<T> list, List<T> list2) {
        for (Object next : list) {
            if (next != null) {
                list2.add(next);
            }
        }
    }

    /* access modifiers changed from: private */
    public File getFile(MetricObject metricObject) {
        File file = this.metricsDir;
        StringBuilder sb = new StringBuilder();
        sb.append(metricObject.getId());
        sb.append(".json");
        return new File(file, sb.toString());
    }

    /* access modifiers changed from: private */
    public boolean hasReachedMetricStorageLimit() {
        return this.storage.getDirectoryFileCount(this.metricsDir) > STORED_METRIC_LIMIT;
    }

    /* access modifiers changed from: private */
    public boolean hasReachedOpsMetricStorageLimit() {
        return this.storage.getDirectoryFileCount(this.opsMetricsDir) > 100;
    }

    private boolean isDisabled() {
        return !((AppConfig) this.appConfigProvider.get()).isMetricsEnabled();
    }

    /* access modifiers changed from: private */
    public void uploadMetrics(final List<MetricObject> list, final List<OpsMetricObject> list2) {
        ((Api) this.apiProvider.get()).sendMetrics(list, list2, new Callback<Void>() {
            public void onFailure(Call<Void> call, Throwable th) {
            }

            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful() || response.code() == 400) {
                    MetricsStore.this.executor.execute(new Runnable() {
                        public void run() {
                            AnonymousClass4 r0 = AnonymousClass4.this;
                            MetricsStore.this.deleteFilesFor(list, list2);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void deleteFilesFor(List<MetricObject> list, List<OpsMetricObject> list2) {
        for (MetricObject file : list) {
            IoUtils.safelyDelete(getFile(file));
        }
        for (OpsMetricObject file2 : list2) {
            IoUtils.safelyDelete(getFile(file2));
        }
    }

    public void loadAndSendMetrics() {
        this.executor.execute(new Runnable() {
            public void run() {
                List loadMetrics = MetricsStore.this.loadMetrics();
                List loadOpsMetrics = MetricsStore.this.loadOpsMetrics();
                if (!loadMetrics.isEmpty() || !loadOpsMetrics.isEmpty()) {
                    MetricsStore.this.uploadMetrics(loadMetrics, loadOpsMetrics);
                }
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public List<MetricObject> loadMetrics() {
        final ArrayList arrayList = new ArrayList();
        this.storage.loadFilesInDirectory(this.metricsDir, MetricObject.class, new LoadHandler<List<MetricObject>>() {
            public void onLoad(List<MetricObject> list) {
                MetricsStore.copyNonNullItems(list, arrayList);
            }
        }, this.deleteOnFailureHandler);
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public List<OpsMetricObject> loadOpsMetrics() {
        final ArrayList arrayList = new ArrayList();
        this.storage.loadFilesInDirectory(this.opsMetricsDir, OpsMetricObject.class, new LoadHandler<List<OpsMetricObject>>() {
            public void onLoad(List<OpsMetricObject> list) {
                MetricsStore.copyNonNullItems(list, arrayList);
            }
        }, this.deleteOnFailureHandler);
        return arrayList;
    }

    public void track(final MetricObject metricObject) {
        if (!isDisabled()) {
            metricObject.addInstallerPackageName(this.installerPackageName).addIsDebugBuild(this.isDebugBuild);
            this.executor.execute(new Runnable() {
                public void run() {
                    if (!MetricsStore.this.hasReachedMetricStorageLimit()) {
                        JsonStorage access$200 = MetricsStore.this.storage;
                        MetricObject metricObject = metricObject;
                        access$200.saveToFileAsJson(metricObject, MetricsStore.this.getFile(metricObject));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public File getFile(OpsMetricObject opsMetricObject) {
        File file = this.opsMetricsDir;
        StringBuilder sb = new StringBuilder();
        sb.append(opsMetricObject.getId());
        sb.append(".json");
        return new File(file, sb.toString());
    }

    public void track(final OpsMetricObject opsMetricObject) {
        if (!isDisabled()) {
            this.executor.execute(new Runnable() {
                public void run() {
                    if (!MetricsStore.this.hasReachedOpsMetricStorageLimit()) {
                        JsonStorage access$200 = MetricsStore.this.storage;
                        OpsMetricObject opsMetricObject = opsMetricObject;
                        access$200.saveToFileAsJson(opsMetricObject, MetricsStore.this.getFile(opsMetricObject));
                    }
                }
            });
        }
    }

    MetricsStore(Provider<Api> provider, Provider<AppConfig> provider2, Executor executor2, JsonStorage jsonStorage, File file, File file2, boolean z, String str, Twig twig2) {
        this.deleteOnFailureHandler = new LoadFailureHandler() {
            public void onLoadFailed(File file, Exception exc) {
                IoUtils.safelyDelete(file);
                Twig access$800 = MetricsStore.this.twig;
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't load file ");
                sb.append(file.getAbsolutePath());
                access$800.v(exc, sb.toString(), new Object[0]);
            }
        };
        this.apiProvider = provider;
        this.appConfigProvider = provider2;
        this.executor = executor2;
        this.storage = jsonStorage;
        this.metricsDir = file;
        this.opsMetricsDir = file2;
        this.isDebugBuild = z;
        this.installerPackageName = str;
        this.twig = twig2;
    }
}
