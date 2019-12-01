package io.intercom.com.bumptech.glide.load.c.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import io.intercom.com.bumptech.glide.load.b;
import java.io.File;

/* compiled from: HardwareConfigState */
final class q {

    /* renamed from: a reason: collision with root package name */
    private static final File f9619a = new File("/proc/self/fd");

    /* renamed from: b reason: collision with root package name */
    private static volatile q f9620b;

    /* renamed from: c reason: collision with root package name */
    private volatile int f9621c;

    /* renamed from: d reason: collision with root package name */
    private volatile boolean f9622d = true;

    private q() {
    }

    static q a() {
        if (f9620b == null) {
            synchronized (q.class) {
                if (f9620b == null) {
                    f9620b = new q();
                }
            }
        }
        return f9620b;
    }

    private synchronized boolean b() {
        int i2 = this.f9621c + 1;
        this.f9621c = i2;
        if (i2 >= 50) {
            boolean z = false;
            this.f9621c = 0;
            int length = f9619a.list().length;
            if (length < 700) {
                z = true;
            }
            this.f9622d = z;
            if (!this.f9622d && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(length);
                sb.append(", limit ");
                sb.append(700);
                Log.w("Downsampler", sb.toString());
            }
        }
        return this.f9622d;
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(26)
    public boolean a(int i2, int i3, Options options, b bVar, boolean z, boolean z2) {
        if (!z || VERSION.SDK_INT < 26 || bVar == b.PREFER_ARGB_8888_DISALLOW_HARDWARE || z2) {
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
