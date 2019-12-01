package com.google.android.gms.measurement.internal;

final class Tb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ de f5719a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Pb f5720b;

    Tb(Pb pb, de deVar) {
        this.f5720b = pb;
        this.f5719a = deVar;
    }

    public final void run() {
        this.f5720b.f5680a.p();
        this.f5720b.f5680a.b(this.f5719a);
    }
}
