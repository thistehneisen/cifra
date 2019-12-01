package com.google.android.gms.measurement.internal;

/* renamed from: com.google.android.gms.measurement.internal.xd reason: case insensitive filesystem */
final class C0598xd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Kd f6161a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Runnable f6162b;

    C0598xd(C0593wd wdVar, Kd kd, Runnable runnable) {
        this.f6161a = kd;
        this.f6162b = runnable;
    }

    public final void run() {
        this.f6161a.p();
        this.f6161a.a(this.f6162b);
        this.f6161a.o();
    }
}
