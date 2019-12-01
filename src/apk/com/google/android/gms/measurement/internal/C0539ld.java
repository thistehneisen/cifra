package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.sf;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.measurement.internal.ld reason: case insensitive filesystem */
final class C0539ld implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f6017a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6018b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ ae f6019c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ sf f6020d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Zc f6021e;

    C0539ld(Zc zc, String str, String str2, ae aeVar, sf sfVar) {
        this.f6021e = zc;
        this.f6017a = str;
        this.f6018b = str2;
        this.f6019c = aeVar;
        this.f6020d = sfVar;
    }

    public final void run() {
        String str = "Failed to get conditional properties";
        ArrayList arrayList = new ArrayList();
        try {
            C0487bb d2 = this.f6021e.f5791d;
            if (d2 == null) {
                this.f6021e.e().t().a(str, this.f6017a, this.f6018b);
                return;
            }
            arrayList = Wd.b(d2.a(this.f6017a, this.f6018b, this.f6019c));
            this.f6021e.J();
            this.f6021e.m().a(this.f6020d, arrayList);
        } catch (RemoteException e2) {
            this.f6021e.e().t().a(str, this.f6017a, this.f6018b, e2);
        } finally {
            this.f6021e.m().a(this.f6020d, arrayList);
        }
    }
}
