package com.google.android.gms.measurement.internal;

final class Wc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Vc f5752a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Uc f5753b;

    Wc(Uc uc, Vc vc) {
        this.f5753b = uc;
        this.f5752a = vc;
    }

    public final void run() {
        this.f5753b.a(this.f5752a, false);
        Uc uc = this.f5753b;
        uc.f5731c = null;
        uc.r().a((Vc) null);
    }
}
