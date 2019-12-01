package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class SessionReport implements Report {
    private final Map<String, String> customHeaders;
    private final File file;
    private final File[] files;

    public SessionReport(File file2) {
        this(file2, Collections.emptyMap());
    }

    public Map<String, String> getCustomHeaders() {
        return Collections.unmodifiableMap(this.customHeaders);
    }

    public File getFile() {
        return this.file;
    }

    public String getFileName() {
        return getFile().getName();
    }

    public File[] getFiles() {
        return this.files;
    }

    public String getIdentifier() {
        String fileName = getFileName();
        return fileName.substring(0, fileName.lastIndexOf(46));
    }

    public Type getType() {
        return Type.JAVA;
    }

    public void remove() {
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Removing report at ");
        sb.append(this.file.getPath());
        e2.d(CrashlyticsCore.TAG, sb.toString());
        this.file.delete();
    }

    public SessionReport(File file2, Map<String, String> map) {
        this.file = file2;
        this.files = new File[]{file2};
        this.customHeaders = new HashMap(map);
        if (this.file.length() == 0) {
            this.customHeaders.putAll(ReportUploader.HEADER_INVALID_CLS_FILE);
        }
    }
}
