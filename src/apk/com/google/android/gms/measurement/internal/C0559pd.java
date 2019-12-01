package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.pd reason: case insensitive filesystem */
final class C0559pd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0487bb f6064a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0564qd f6065b;

    C0559pd(C0564qd qdVar, C0487bb bbVar) {
        this.f6065b = qdVar;
        this.f6064a = bbVar;
    }

    public final void run() {
        synchronized (this.f6065b) {
            this.f6065b.f6070a = false;
            if (!this.f6065b.f6072c.C()) {
                this.f6065b.f6072c.e().B().a("Connected to service");
                this.f6065b.f6072c.a(this.f6064a);
            }
        }
    }
}
