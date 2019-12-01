package com.google.android.gms.measurement.internal;

final class Nd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Qd f5660a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Kd f5661b;

    Nd(Kd kd, Qd qd) {
        this.f5661b = kd;
        this.f5660a = qd;
    }

    public final void run() {
        this.f5661b.a(this.f5660a);
        this.f5661b.f();
    }
}
