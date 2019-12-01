package io.intercom.com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

/* compiled from: LogTime */
public final class d {

    /* renamed from: a reason: collision with root package name */
    private static final double f9396a;

    static {
        double d2 = 1.0d;
        if (17 <= VERSION.SDK_INT) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f9396a = d2;
    }

    @TargetApi(17)
    public static long a() {
        if (17 <= VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double a(long j2) {
        return ((double) (a() - j2)) * f9396a;
    }
}
