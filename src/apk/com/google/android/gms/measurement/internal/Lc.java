package com.google.android.gms.measurement.internal;

final class Lc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ long f5644a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5645b;

    Lc(C0582uc ucVar, long j2) {
        this.f5645b = ucVar;
        this.f5644a = j2;
    }

    public final void run() {
        this.f5645b.f().q.a(this.f5644a);
        this.f5645b.e().A().a("Minimum session duration set", Long.valueOf(this.f5644a));
    }
}
