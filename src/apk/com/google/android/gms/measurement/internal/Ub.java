package com.google.android.gms.measurement.internal;

final class Ub implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ de f5728a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ae f5729b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5730c;

    Ub(Pb pb, de deVar, ae aeVar) {
        this.f5730c = pb;
        this.f5728a = deVar;
        this.f5729b = aeVar;
    }

    public final void run() {
        this.f5730c.f5680a.p();
        this.f5730c.f5680a.a(this.f5728a, this.f5729b);
    }
}
