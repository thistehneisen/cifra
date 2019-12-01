package io.intercom.android.sdk.errorreporting;

import android.content.Context;
import io.intercom.android.sdk.Provider;
import io.intercom.android.sdk.api.Api;
import io.intercom.com.google.gson.o;

public class ErrorReporter {
    private final Provider<Api> apiProvider;
    private final ExceptionParser exceptionParser;
    private final ErrorReportStore reportStore;

    ErrorReporter(ErrorReportStore errorReportStore, Provider<Api> provider, ExceptionParser exceptionParser2) {
        this.reportStore = errorReportStore;
        this.apiProvider = provider;
        this.exceptionParser = exceptionParser2;
    }

    public static ErrorReporter create(Context context, o oVar, Provider<Api> provider) {
        return new ErrorReporter(ErrorReportStore.create(context.getApplicationContext(), oVar), provider, new ExceptionParser());
    }

    public void disableExceptionHandler() {
        IntercomExceptionHandler.disable();
        this.reportStore.deleteFromDisk();
    }

    public void enableExceptionHandler() {
        IntercomExceptionHandler.enable(this);
    }

    /* access modifiers changed from: 0000 */
    public void saveReport(Throwable th) {
        if (this.exceptionParser.containsIntercomMethod(th)) {
            this.reportStore.saveToDisk(this.exceptionParser.createReportFrom(th));
        }
    }

    public void sendSavedReport() {
        this.reportStore.sendSavedReport(this.apiProvider);
    }
}
