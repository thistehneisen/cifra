package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.hc reason: case insensitive filesystem */
final class C0518hc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f5937a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5938b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5939c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ long f5940d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ Pb f5941e;

    C0518hc(Pb pb, String str, String str2, String str3, long j2) {
        this.f5941e = pb;
        this.f5937a = str;
        this.f5938b = str2;
        this.f5939c = str3;
        this.f5940d = j2;
    }

    public final void run() {
        String str = this.f5937a;
        if (str == null) {
            this.f5941e.f5680a.r().B().a(this.f5938b, (Vc) null);
            return;
        }
        this.f5941e.f5680a.r().B().a(this.f5938b, new Vc(this.f5939c, str, this.f5940d));
    }
}
