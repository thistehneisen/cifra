package com.google.android.gms.measurement.internal;

final class Qb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0567rc f5687a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Ob f5688b;

    Qb(Ob ob, C0567rc rcVar) {
        this.f5688b = ob;
        this.f5687a = rcVar;
    }

    public final void run() {
        this.f5688b.a(this.f5687a);
        this.f5688b.g();
    }
}
