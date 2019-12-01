package com.bumptech.glide.load.c.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.b;
import java.io.File;

/* compiled from: HardwareConfigState */
final class r {

    /* renamed from: a reason: collision with root package name */
    private static final File f3760a = new File("/proc/self/fd");

    /* renamed from: b reason: collision with root package name */
    private static volatile r f3761b;

    /* renamed from: c reason: collision with root package name */
    private volatile int f3762c;

    /* renamed from: d reason: collision with root package name */
    private volatile boolean f3763d = true;

    private r() {
    }

    static r a() {
        if (f3761b == null) {
            synchronized (r.class) {
                if (f3761b == null) {
                    f3761b = new r();
                }
            }
        }
        return f3761b;
    }

    private synchronized boolean b() {
        int i2 = this.f3762c + 1;
        this.f3762c = i2;
        if (i2 >= 50) {
            boolean z = false;
            this.f3762c = 0;
            int length = f3760a.list().length;
            if (length < 700) {
                z = true;
            }
            this.f3763d = z;
            if (!this.f3763d && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(length);
                sb.append(", limit ");
                sb.append(700);
                Log.w("Downsampler", sb.toString());
            }
        }
        return this.f3763d;
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(26)
    public boolean a(int i2, int i3, Options options, b bVar, boolean z, boolean z2) {
        if (!z || VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i2 >= 128 && i3 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
