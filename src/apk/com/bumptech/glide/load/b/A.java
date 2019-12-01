package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamEncoder */
public class A implements d<InputStream> {

    /* renamed from: a reason: collision with root package name */
    private final b f3602a;

    public A(b bVar) {
        this.f3602a = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A[Catch:{ all -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003f A[SYNTHETIC, Splitter:B:23:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004a A[SYNTHETIC, Splitter:B:29:0x004a] */
    public boolean a(InputStream inputStream, File file, i iVar) {
        String str = "StreamEncoder";
        byte[] bArr = (byte[]) this.f3602a.b(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        if (Log.isLoggable(str, 3)) {
                        }
                        if (fileOutputStream != null) {
                        }
                        this.f3602a.put(bArr);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        this.f3602a.put(bArr);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    this.f3602a.put(bArr);
                    throw th;
                }
            }
            fileOutputStream2.close();
            z = true;
            try {
                fileOutputStream2.close();
            } catch (IOException unused2) {
            }
        } catch (IOException e3) {
            e = e3;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Failed to encode data onto the OutputStream", e);
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            this.f3602a.put(bArr);
            return z;
        }
        this.f3602a.put(bArr);
        return z;
    }
}
