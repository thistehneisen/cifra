package io.intercom.android.sdk.errorreporting;

import android.content.Context;
import android.os.AsyncTask;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.logger.LumberMill;
import io.intercom.android.sdk.persistence.JsonStorage;
import io.intercom.android.sdk.persistence.JsonStorage.LoadHandler;
import io.intercom.android.sdk.twig.Twig;
import io.intercom.com.google.gson.o;
import java.io.File;
import java.util.concurrent.RejectedExecutionException;

class ErrorReportStore {
    private static final String REPORT_FILE_PATH = "intercom-error.json";
    private static final Twig TWIG = LumberMill.getLogger();
    /* access modifiers changed from: private */
    public final File reportFile;
    private final JsonStorage storage;

    ErrorReportStore(File file, JsonStorage jsonStorage) {
        this.reportFile = file;
        this.storage = jsonStorage;
    }

    public static ErrorReportStore create(Context context, o oVar) {
        return new ErrorReportStore(new File(context.getCacheDir(), REPORT_FILE_PATH), new JsonStorage(oVar));
    }

    /* access modifiers changed from: private */
    public void readAndSendReport(final Api api) {
        this.storage.loadThenDelete(this.reportFile, ErrorReport.class, new LoadHandler<ErrorReport>() {
            public void onLoad(ErrorReport errorReport) {
                api.sendErrorReport(errorReport);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void deleteFromDisk() {
        this.storage.loadThenDelete(this.reportFile, ErrorReport.class, new LoadHandler<ErrorReport>() {
            public void onLoad(ErrorReport errorReport) {
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void saveToDisk(ErrorReport errorReport) {
        this.storage.saveToFileAsJson(errorReport, this.reportFile);
    }

    /* access modifiers changed from: 0000 */
    public void sendSavedReport(final Provider<Api> provider) {
        try {
            AsyncTask.execute(new Runnable() {
                public void run() {
                    if (ErrorReportStore.this.reportFile.exists()) {
                        ErrorReportStore.this.readAndSendReport((Api) provider.get());
                    }
                }
            });
        } catch (RejectedExecutionException e2) {
            Twig twig = TWIG;
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't queue up sending of event: ");
            sb.append(e2);
            twig.internal(sb.toString());
        }
    }
}
