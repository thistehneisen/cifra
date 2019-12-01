package com.google.android.gms.measurement.internal;

final class Sb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5715a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Pb f5716b;

    Sb(Pb pb, ae aeVar) {
        this.f5716b = pb;
        this.f5715a = aeVar;
    }

    public final void run() {
        this.f5716b.f5680a.p();
        this.f5716b.f5680a.b(this.f5715a);
    }
}
