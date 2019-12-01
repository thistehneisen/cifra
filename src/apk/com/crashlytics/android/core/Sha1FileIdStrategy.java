package com.crashlytics.android.core;

import io.fabric.sdk.android.a.b.l;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class Sha1FileIdStrategy implements FileIdStrategy {
    Sha1FileIdStrategy() {
    }

    private static String getFileSHA(String str) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(str));
            try {
                String a2 = l.a((InputStream) bufferedInputStream2);
                l.a((Closeable) bufferedInputStream2);
                return a2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                l.a((Closeable) bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            l.a((Closeable) bufferedInputStream);
            throw th;
        }
    }

    public String createId(File file) throws IOException {
        return getFileSHA(file.getPath());
    }
}
