package com.google.android.gms.measurement.internal;

final class Zb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5788a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Pb f5789b;

    Zb(Pb pb, ae aeVar) {
        this.f5789b = pb;
        this.f5788a = aeVar;
    }

    public final void run() {
        this.f5789b.f5680a.p();
        this.f5789b.f5680a.a(this.f5788a);
    }
}
