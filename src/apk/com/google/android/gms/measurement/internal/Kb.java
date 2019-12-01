package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;
import java.lang.Thread.UncaughtExceptionHandler;

final class Kb implements UncaughtExceptionHandler {

    /* renamed from: a reason: collision with root package name */
    private final String f5618a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Ib f5619b;

    public Kb(Ib ib, String str) {
        this.f5619b = ib;
        q.a(str);
        this.f5618a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f5619b.e().t().a(this.f5618a, th);
    }
}
