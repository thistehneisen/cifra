package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.sf;

/* renamed from: com.google.android.gms.measurement.internal.nd reason: case insensitive filesystem */
final class C0549nd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f6038a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6039b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ boolean f6040c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ ae f6041d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ sf f6042e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Zc f6043f;

    C0549nd(Zc zc, String str, String str2, boolean z, ae aeVar, sf sfVar) {
        this.f6043f = zc;
        this.f6038a = str;
        this.f6039b = str2;
        this.f6040c = z;
        this.f6041d = aeVar;
        this.f6042e = sfVar;
    }

    public final void run() {
        String str = "Failed to get user properties";
        Bundle bundle = new Bundle();
        try {
            C0487bb d2 = this.f6043f.f5791d;
            if (d2 == null) {
                this.f6043f.e().t().a(str, this.f6038a, this.f6039b);
                return;
            }
            bundle = Wd.a(d2.a(this.f6038a, this.f6039b, this.f6040c, this.f6041d));
            this.f6043f.J();
            this.f6043f.m().a(this.f6042e, bundle);
        } catch (RemoteException e2) {
            this.f6043f.e().t().a(str, this.f6038a, e2);
        } finally {
            this.f6043f.m().a(this.f6042e, bundle);
        }
    }
}
