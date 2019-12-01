package com.google.android.gms.measurement.internal;

final class Rb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ de f5696a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ae f5697b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5698c;

    Rb(Pb pb, de deVar, ae aeVar) {
        this.f5698c = pb;
        this.f5696a = deVar;
        this.f5697b = aeVar;
    }

    public final void run() {
        this.f5698c.f5680a.p();
        this.f5698c.f5680a.b(this.f5696a, this.f5697b);
    }
}
