package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

/* compiled from: LogTime */
public final class h {

    /* renamed from: a reason: collision with root package name */
    private static final double f3523a;

    static {
        double d2 = 1.0d;
        if (VERSION.SDK_INT >= 17) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f3523a = d2;
    }

    @TargetApi(17)
    public static long a() {
        if (VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double a(long j2) {
        return ((double) (a() - j2)) * f3523a;
    }
}
