package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.measurement.internal.hd reason: case insensitive filesystem */
final class C0519hd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5942a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Zc f5943b;

    C0519hd(Zc zc, ae aeVar) {
        this.f5943b = zc;
        this.f5942a = aeVar;
    }

    public final void run() {
        C0487bb d2 = this.f5943b.f5791d;
        if (d2 == null) {
            this.f5943b.e().t().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            d2.d(this.f5942a);
            this.f5943b.J();
        } catch (RemoteException e2) {
            this.f5943b.e().t().a("Failed to send measurementEnabled to the service", e2);
        }
    }
}
