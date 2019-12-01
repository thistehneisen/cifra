package com.google.android.gms.measurement.internal;

final class Kc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ long f5620a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5621b;

    Kc(C0582uc ucVar, long j2) {
        this.f5621b = ucVar;
        this.f5620a = j2;
    }

    public final void run() {
        this.f5621b.f().r.a(this.f5620a);
        this.f5621b.e().A().a("Session timeout duration set", Long.valueOf(this.f5620a));
    }
}
