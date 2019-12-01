package com.google.android.gms.measurement.internal;

final class Ic implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f5599a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5600b;

    Ic(C0582uc ucVar, boolean z) {
        this.f5600b = ucVar;
        this.f5599a = z;
    }

    public final void run() {
        boolean f2 = this.f5600b.f5987a.f();
        boolean r = this.f5600b.f5987a.r();
        this.f5600b.f5987a.a(this.f5599a);
        if (r == this.f5599a) {
            this.f5600b.f5987a.e().B().a("Default data collection state already set to", Boolean.valueOf(this.f5599a));
        }
        if (this.f5600b.f5987a.f() == f2 || this.f5600b.f5987a.f() != this.f5600b.f5987a.r()) {
            this.f5600b.f5987a.e().y().a("Default data collection is different than actual status", Boolean.valueOf(this.f5599a), Boolean.valueOf(f2));
        }
        this.f5600b.M();
    }
}
