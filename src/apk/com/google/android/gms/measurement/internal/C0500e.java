package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.e reason: case insensitive filesystem */
final class C0500e implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0543mc f5888a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0485b f5889b;

    C0500e(C0485b bVar, C0543mc mcVar) {
        this.f5889b = bVar;
        this.f5888a = mcVar;
    }

    public final void run() {
        this.f5888a.b();
        if (ee.a()) {
            this.f5888a.d().a((Runnable) this);
            return;
        }
        boolean c2 = this.f5889b.c();
        this.f5889b.f5834d = 0;
        if (c2) {
            this.f5889b.b();
        }
    }
}
