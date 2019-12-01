package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.yc reason: case insensitive filesystem */
final class C0602yc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ long f6170a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f6171b;

    C0602yc(C0582uc ucVar, long j2) {
        this.f6171b = ucVar;
        this.f6170a = j2;
    }

    public final void run() {
        C0582uc ucVar = this.f6171b;
        long j2 = this.f6170a;
        ucVar.j();
        ucVar.h();
        ucVar.x();
        ucVar.e().A().a("Resetting analytics data (FE)");
        ucVar.u().B();
        if (ucVar.g().j(ucVar.q().C())) {
            ucVar.f().f6108k.a(j2);
        }
        boolean f2 = ucVar.f5987a.f();
        if (!ucVar.g().q()) {
            ucVar.f().d(!f2);
        }
        ucVar.r().D();
        ucVar.f6122h = !f2;
        this.f6171b.r().a(new AtomicReference<>());
    }
}
