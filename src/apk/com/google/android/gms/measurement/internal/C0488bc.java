package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.bc reason: case insensitive filesystem */
final class C0488bc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0525j f5836a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ae f5837b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5838c;

    C0488bc(Pb pb, C0525j jVar, ae aeVar) {
        this.f5838c = pb;
        this.f5836a = jVar;
        this.f5837b = aeVar;
    }

    public final void run() {
        C0525j b2 = this.f5838c.b(this.f5836a, this.f5837b);
        this.f5838c.f5680a.p();
        this.f5838c.f5680a.a(b2, this.f5837b);
    }
}
