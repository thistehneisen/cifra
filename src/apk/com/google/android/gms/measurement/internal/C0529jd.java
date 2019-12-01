package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.a;

/* renamed from: com.google.android.gms.measurement.internal.jd reason: case insensitive filesystem */
final class C0529jd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f5965a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ boolean f5966b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ de f5967c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ ae f5968d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ de f5969e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Zc f5970f;

    C0529jd(Zc zc, boolean z, boolean z2, de deVar, ae aeVar, de deVar2) {
        this.f5970f = zc;
        this.f5965a = z;
        this.f5966b = z2;
        this.f5967c = deVar;
        this.f5968d = aeVar;
        this.f5969e = deVar2;
    }

    public final void run() {
        C0487bb d2 = this.f5970f.f5791d;
        if (d2 == null) {
            this.f5970f.e().t().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f5965a) {
            this.f5970f.a(d2, (a) this.f5966b ? null : this.f5967c, this.f5968d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f5969e.f5877a)) {
                    d2.a(this.f5967c, this.f5968d);
                } else {
                    d2.a(this.f5967c);
                }
            } catch (RemoteException e2) {
                this.f5970f.e().t().a("Failed to send conditional user property to the service", e2);
            }
        }
        this.f5970f.J();
    }
}
