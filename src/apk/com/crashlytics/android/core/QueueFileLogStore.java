package com.crashlytics.android.core;

import io.fabric.sdk.android.a.b.C;
import io.fabric.sdk.android.a.b.C.c;
import io.fabric.sdk.android.a.b.l;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class QueueFileLogStore implements FileLogStore {
    private C logFile;
    private final int maxLogSize;
    private final File workingFile;

    public class LogBytes {
        public final byte[] bytes;
        public final int offset;

        public LogBytes(byte[] bArr, int i2) {
            this.bytes = bArr;
            this.offset = i2;
        }
    }

    public QueueFileLogStore(File file, int i2) {
        this.workingFile = file;
        this.maxLogSize = i2;
    }

    private void doWriteToLog(long j2, String str) {
        String str2 = " ";
        if (this.logFile != null) {
            if (str == null) {
                str = "null";
            }
            try {
                int i2 = this.maxLogSize / 4;
                if (str.length() > i2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("...");
                    sb.append(str.substring(str.length() - i2));
                    str = sb.toString();
                }
                this.logFile.a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j2), str.replaceAll("\r", str2).replaceAll("\n", str2)}).getBytes("UTF-8"));
                while (!this.logFile.b() && this.logFile.d() > this.maxLogSize) {
                    this.logFile.c();
                }
            } catch (IOException e2) {
                f.e().b(CrashlyticsCore.TAG, "There was a problem writing to the Crashlytics log.", e2);
            }
        }
    }

    private LogBytes getLogBytes() {
        if (!this.workingFile.exists()) {
            return null;
        }
        openLogFile();
        C c2 = this.logFile;
        if (c2 == null) {
            return null;
        }
        final int[] iArr = {0};
        final byte[] bArr = new byte[c2.d()];
        try {
            this.logFile.a((c) new c() {
                public void read(InputStream inputStream, int i2) throws IOException {
                    try {
                        inputStream.read(bArr, iArr[0], i2);
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + i2;
                    } finally {
                        inputStream.close();
                    }
                }
            });
        } catch (IOException e2) {
            f.e().b(CrashlyticsCore.TAG, "A problem occurred while reading the Crashlytics log file.", e2);
        }
        return new LogBytes(bArr, iArr[0]);
    }

    private void openLogFile() {
        if (this.logFile == null) {
            try {
                this.logFile = new C(this.workingFile);
            } catch (IOException e2) {
                o e3 = f.e();
                StringBuilder sb = new StringBuilder();
                sb.append("Could not open log file: ");
                sb.append(this.workingFile);
                e3.b(CrashlyticsCore.TAG, sb.toString(), e2);
            }
        }
    }

    public void closeLogFile() {
        l.a((Closeable) this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        closeLogFile();
        this.workingFile.delete();
    }

    public ByteString getLogAsByteString() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        return ByteString.copyFrom(logBytes.bytes, 0, logBytes.offset);
    }

    public byte[] getLogAsBytes() {
        LogBytes logBytes = getLogBytes();
        if (logBytes == null) {
            return null;
        }
        return logBytes.bytes;
    }

    public void writeToLog(long j2, String str) {
        openLogFile();
        doWriteToLog(j2, str);
    }
}
