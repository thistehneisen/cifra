package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class Xc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f5765a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Vc f5766b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Vc f5767c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Uc f5768d;

    Xc(Uc uc, boolean z, Vc vc, Vc vc2) {
        this.f5768d = uc;
        this.f5765a = z;
        this.f5766b = vc;
        this.f5767c = vc2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (com.google.android.gms.measurement.internal.Wd.e(r10.f5766b.f5743a, r10.f5767c.f5743a) != false) goto L_0x0064;
     */
    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.f5768d.g().r(this.f5768d.q().C())) {
            z = this.f5765a && this.f5768d.f5731c != null;
            if (z) {
                Uc uc = this.f5768d;
                uc.a(uc.f5731c, true);
            }
        } else {
            if (this.f5765a) {
                Uc uc2 = this.f5768d;
                Vc vc = uc2.f5731c;
                if (vc != null) {
                    uc2.a(vc, true);
                }
            }
            z = false;
        }
        Vc vc2 = this.f5766b;
        if (vc2 != null) {
            long j2 = vc2.f5745c;
            Vc vc3 = this.f5767c;
            if (j2 == vc3.f5745c) {
                if (Wd.e(vc2.f5744b, vc3.f5744b)) {
                }
            }
        }
        z2 = true;
        if (z2) {
            Bundle bundle = new Bundle();
            Uc.a(this.f5767c, bundle, true);
            Vc vc4 = this.f5766b;
            if (vc4 != null) {
                String str = vc4.f5743a;
                if (str != null) {
                    bundle.putString("_pn", str);
                }
                bundle.putString("_pc", this.f5766b.f5744b);
                bundle.putLong("_pi", this.f5766b.f5745c);
            }
            if (this.f5768d.g().r(this.f5768d.q().C()) && z) {
                long D = this.f5768d.u().D();
                if (D > 0) {
                    this.f5768d.m().a(bundle, D);
                }
            }
            this.f5768d.p().c("auto", "_vs", bundle);
        }
        Uc uc3 = this.f5768d;
        uc3.f5731c = this.f5767c;
        uc3.r().a(this.f5767c);
    }
}
