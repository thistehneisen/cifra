package com.google.android.gms.measurement.internal;

final class Wb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ de f5750a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Pb f5751b;

    Wb(Pb pb, de deVar) {
        this.f5751b = pb;
        this.f5750a = deVar;
    }

    public final void run() {
        this.f5751b.f5680a.p();
        this.f5751b.f5680a.a(this.f5750a);
    }
}
