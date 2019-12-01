package com.google.android.gms.common.util;

import android.os.SystemClock;

public class g implements d {

    /* renamed from: a reason: collision with root package name */
    private static final g f4804a = new g();

    private g() {
    }

    public static d c() {
        return f4804a;
    }

    public long a() {
        return SystemClock.elapsedRealtime();
    }

    public long b() {
        return System.nanoTime();
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
