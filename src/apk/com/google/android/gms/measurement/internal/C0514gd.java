package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.gd reason: case insensitive filesystem */
final class C0514gd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Vc f5932a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Zc f5933b;

    C0514gd(Zc zc, Vc vc) {
        this.f5933b = zc;
        this.f5932a = vc;
    }

    public final void run() {
        C0487bb d2 = this.f5933b.f5791d;
        if (d2 == null) {
            this.f5933b.e().t().a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f5932a == null) {
                d2.a(0, (String) null, (String) null, this.f5933b.a().getPackageName());
            } else {
                d2.a(this.f5932a.f5745c, this.f5932a.f5743a, this.f5932a.f5744b, this.f5933b.a().getPackageName());
            }
            this.f5933b.J();
        } catch (RemoteException e2) {
            this.f5933b.e().t().a("Failed to send current screen to the service", e2);
        }
    }
}
