package com.crashlytics.android.core;

import com.crashlytics.android.core.Report.Type;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.File;
import java.util.Map;

class NativeSessionReport implements Report {
    private final File reportDirectory;

    public NativeSessionReport(File file) {
        this.reportDirectory = file;
    }

    public Map<String, String> getCustomHeaders() {
        return null;
    }

    public File getFile() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public File[] getFiles() {
        return this.reportDirectory.listFiles();
    }

    public String getIdentifier() {
        return this.reportDirectory.getName();
    }

    public Type getType() {
        return Type.NATIVE;
    }

    public void remove() {
        File[] files = getFiles();
        int length = files.length;
        int i2 = 0;
        while (true) {
            String str = CrashlyticsCore.TAG;
            if (i2 < length) {
                File file = files[i2];
                o e2 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Removing native report file at ");
                sb.append(file.getPath());
                e2.d(str, sb.toString());
                file.delete();
                i2++;
            } else {
                o e3 = f.e();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Removing native report directory at ");
                sb2.append(this.reportDirectory);
                e3.d(str, sb2.toString());
                this.reportDirectory.delete();
                return;
            }
        }
    }
}
