package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.rd reason: case insensitive filesystem */
final class C0568rd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0487bb f6086a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0564qd f6087b;

    C0568rd(C0564qd qdVar, C0487bb bbVar) {
        this.f6087b = qdVar;
        this.f6086a = bbVar;
    }

    public final void run() {
        synchronized (this.f6087b) {
            this.f6087b.f6070a = false;
            if (!this.f6087b.f6072c.C()) {
                this.f6087b.f6072c.e().A().a("Connected to remote service");
                this.f6087b.f6072c.a(this.f6086a);
            }
        }
    }
}
