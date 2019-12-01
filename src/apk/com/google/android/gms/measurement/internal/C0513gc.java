package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.gc reason: case insensitive filesystem */
final class C0513gc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Rd f5929a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ae f5930b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5931c;

    C0513gc(Pb pb, Rd rd, ae aeVar) {
        this.f5931c = pb;
        this.f5929a = rd;
        this.f5930b = aeVar;
    }

    public final void run() {
        this.f5931c.f5680a.p();
        this.f5931c.f5680a.a(this.f5929a, this.f5930b);
    }
}
