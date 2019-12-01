package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.a;

/* renamed from: com.google.android.gms.measurement.internal.dd reason: case insensitive filesystem */
final class C0499dd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5874a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ boolean f5875b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Zc f5876c;

    C0499dd(Zc zc, ae aeVar, boolean z) {
        this.f5876c = zc;
        this.f5874a = aeVar;
        this.f5875b = z;
    }

    public final void run() {
        C0487bb d2 = this.f5876c.f5791d;
        if (d2 == null) {
            this.f5876c.e().t().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            d2.c(this.f5874a);
            if (this.f5875b) {
                this.f5876c.t().D();
            }
            this.f5876c.a(d2, (a) null, this.f5874a);
            this.f5876c.J();
        } catch (RemoteException e2) {
            this.f5876c.e().t().a("Failed to send app launch to the service", e2);
        }
    }
}
