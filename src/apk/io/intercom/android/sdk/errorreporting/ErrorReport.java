package io.intercom.android.sdk.errorreporting;

import io.intercom.com.google.gson.a.c;
import java.util.List;

public class ErrorReport {
    @c("exception_reports")
    private final List<ExceptionReport> exceptionReports;
    private final long timestamp;

    ErrorReport(List<ExceptionReport> list, long j2) {
        this.exceptionReports = list;
        this.timestamp = j2;
    }

    public List<ExceptionReport> getExceptionReports() {
        return this.exceptionReports;
    }

    public long getTimestamp() {
        return this.timestamp;
    }
}
