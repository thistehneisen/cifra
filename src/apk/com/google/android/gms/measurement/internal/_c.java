package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.safeparcel.a;

final class _c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f5805a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Rd f5806b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ ae f5807c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Zc f5808d;

    _c(Zc zc, boolean z, Rd rd, ae aeVar) {
        this.f5808d = zc;
        this.f5805a = z;
        this.f5806b = rd;
        this.f5807c = aeVar;
    }

    public final void run() {
        C0487bb d2 = this.f5808d.f5791d;
        if (d2 == null) {
            this.f5808d.e().t().a("Discarding data. Failed to set user attribute");
            return;
        }
        this.f5808d.a(d2, (a) this.f5805a ? null : this.f5806b, this.f5807c);
        this.f5808d.J();
    }
}
