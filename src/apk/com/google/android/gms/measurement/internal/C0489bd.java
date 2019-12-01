package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.bd reason: case insensitive filesystem */
final class C0489bd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5839a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Zc f5840b;

    C0489bd(Zc zc, ae aeVar) {
        this.f5840b = zc;
        this.f5839a = aeVar;
    }

    public final void run() {
        C0487bb d2 = this.f5840b.f5791d;
        if (d2 == null) {
            this.f5840b.e().t().a("Failed to reset data on the service; null service");
            return;
        }
        try {
            d2.b(this.f5839a);
        } catch (RemoteException e2) {
            this.f5840b.e().t().a("Failed to reset data on the service", e2);
        }
        this.f5840b.J();
    }
}
