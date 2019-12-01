package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.cc reason: case insensitive filesystem */
final class C0493cc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Rd f5854a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ae f5855b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5856c;

    C0493cc(Pb pb, Rd rd, ae aeVar) {
        this.f5856c = pb;
        this.f5854a = rd;
        this.f5855b = aeVar;
    }

    public final void run() {
        this.f5856c.f5680a.p();
        this.f5856c.f5680a.b(this.f5854a, this.f5855b);
    }
}
