package io.intercom.android.sdk.errorreporting;

import java.lang.Thread.UncaughtExceptionHandler;

class IntercomExceptionHandler implements UncaughtExceptionHandler {
    private final UncaughtExceptionHandler originalHandler;
    private final ErrorReporter reporter;

    IntercomExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler, ErrorReporter errorReporter) {
        this.originalHandler = uncaughtExceptionHandler;
        this.reporter = errorReporter;
    }

    static void disable() {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof IntercomExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(((IntercomExceptionHandler) defaultUncaughtExceptionHandler).originalHandler);
        }
    }

    static void enable(ErrorReporter errorReporter) {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (!(defaultUncaughtExceptionHandler instanceof IntercomExceptionHandler)) {
            Thread.setDefaultUncaughtExceptionHandler(new IntercomExceptionHandler(defaultUncaughtExceptionHandler, errorReporter));
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.reporter.saveReport(th);
        UncaughtExceptionHandler uncaughtExceptionHandler = this.originalHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        System.err.printf("Exception in thread \"%s\" ", new Object[]{thread.getName()});
        th.printStackTrace(System.err);
    }
}
