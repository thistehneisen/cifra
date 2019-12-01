package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.sf;

/* renamed from: com.google.android.gms.measurement.internal.ed reason: case insensitive filesystem */
final class C0504ed implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5894a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ sf f5895b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Zc f5896c;

    C0504ed(Zc zc, ae aeVar, sf sfVar) {
        this.f5896c = zc;
        this.f5894a = aeVar;
        this.f5895b = sfVar;
    }

    public final void run() {
        String str = "Failed to get app instance id";
        try {
            C0487bb d2 = this.f5896c.f5791d;
            if (d2 == null) {
                this.f5896c.e().t().a(str);
                return;
            }
            String a2 = d2.a(this.f5894a);
            if (a2 != null) {
                this.f5896c.p().a(a2);
                this.f5896c.f().m.a(a2);
            }
            this.f5896c.J();
            this.f5896c.m().a(this.f5895b, a2);
        } catch (RemoteException e2) {
            this.f5896c.e().t().a(str, e2);
        } finally {
            this.f5896c.m().a(this.f5895b, (String) null);
        }
    }
}
