package io.intercom.android.sdk.errorreporting;

import io.intercom.android.sdk.commons.utilities.TimeProvider;
import java.util.ArrayList;
import java.util.List;

class ExceptionParser {
    private static final String[] ALLOWED_PACKAGES = {"io.intercom.android.sdk.sdk", "java.", "android.", "com.android.", "com.google."};
    private static final String INTERCOM_SDK_PACKAGE = "io.intercom.android.sdk.sdk";
    private static final String REDACTION_LINE = "[Non Intercom/OS method]";

    ExceptionParser() {
    }

    private List<ExceptionReport> createExceptionReports(Throwable th) {
        ArrayList arrayList = new ArrayList();
        while (th != null) {
            arrayList.add(new ExceptionReport(th.getClass().getName(), th.getLocalizedMessage(), getStacktraceString(th.getStackTrace())));
            th = th.getCause();
        }
        return arrayList;
    }

    private String getStacktraceString(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            sb.append(isFromAllowedPackage(stackTraceElement) ? stackTraceElement.toString() : REDACTION_LINE);
            if (i2 < stackTraceElementArr.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private boolean isFromAllowedPackage(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        for (String startsWith : ALLOWED_PACKAGES) {
            if (className.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public boolean containsIntercomMethod(Throwable th) {
        while (true) {
            if (th == null) {
                return false;
            }
            for (StackTraceElement className : th.getStackTrace()) {
                if (className.getClassName().startsWith("io.intercom.android.sdk.sdk")) {
                    return true;
                }
            }
            th = th.getCause();
        }
    }

    /* access modifiers changed from: 0000 */
    public ErrorReport createReportFrom(Throwable th) {
        return new ErrorReport(createExceptionReports(th), TimeProvider.SYSTEM.currentTimeMillis());
    }
}
