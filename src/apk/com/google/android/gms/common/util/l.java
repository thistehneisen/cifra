package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class l {

    /* renamed from: a reason: collision with root package name */
    private static String f4810a;

    /* renamed from: b reason: collision with root package name */
    private static int f4811b;

    public static String a() {
        if (f4810a == null) {
            if (f4811b == 0) {
                f4811b = Process.myPid();
            }
            f4810a = a(f4811b);
        }
        return f4810a;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    private static String a(int i2) {
        String str;
        ? r4;
        ? r0;
        ? r02 = 0;
        if (i2 <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i2);
            sb.append("/cmdline");
            BufferedReader a2 = a(sb.toString());
            try {
                String trim = a2.readLine().trim();
                j.a(a2);
                str = trim;
            } catch (IOException unused) {
                r4 = a2;
                j.a(r4);
                str = r02;
                return str;
            } catch (Throwable th) {
                Throwable th2 = th;
                r0 = a2;
                th = th2;
                j.a(r0);
                throw th;
            }
        } catch (IOException unused2) {
            r4 = 0;
            j.a(r4);
            str = r02;
            return str;
        } catch (Throwable th3) {
            th = th3;
            r0 = r02;
            j.a(r0);
            throw th;
        }
        return str;
    }

    private static BufferedReader a(String str) throws IOException {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
