package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.a;

/* renamed from: com.google.android.gms.measurement.internal.kd reason: case insensitive filesystem */
final class C0534kd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f5988a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ boolean f5989b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ C0525j f5990c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ ae f5991d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ String f5992e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Zc f5993f;

    C0534kd(Zc zc, boolean z, boolean z2, C0525j jVar, ae aeVar, String str) {
        this.f5993f = zc;
        this.f5988a = z;
        this.f5989b = z2;
        this.f5990c = jVar;
        this.f5991d = aeVar;
        this.f5992e = str;
    }

    public final void run() {
        C0487bb d2 = this.f5993f.f5791d;
        if (d2 == null) {
            this.f5993f.e().t().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f5988a) {
            this.f5993f.a(d2, (a) this.f5989b ? null : this.f5990c, this.f5991d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f5992e)) {
                    d2.a(this.f5990c, this.f5991d);
                } else {
                    d2.a(this.f5990c, this.f5992e, this.f5993f.e().C());
                }
            } catch (RemoteException e2) {
                this.f5993f.e().t().a("Failed to send event to the service", e2);
            }
        }
        this.f5993f.J();
    }
}
