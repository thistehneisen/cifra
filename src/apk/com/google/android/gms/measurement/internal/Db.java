package com.google.android.gms.measurement.internal;

final class Db implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Ob f5532a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0532kb f5533b;

    Db(Eb eb, Ob ob, C0532kb kbVar) {
        this.f5532a = ob;
        this.f5533b = kbVar;
    }

    public final void run() {
        if (this.f5532a.k() == null) {
            this.f5533b.t().a("Install Referrer Reporter is null");
            return;
        }
        C0606zb k2 = this.f5532a.k();
        k2.f6177a.w();
        k2.a(k2.f6177a.a().getPackageName());
    }
}
