package com.google.android.gms.measurement.internal;

final class Jc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ boolean f5612a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5613b;

    Jc(C0582uc ucVar, boolean z) {
        this.f5613b = ucVar;
        this.f5612a = z;
    }

    public final void run() {
        this.f5613b.c(this.f5612a);
    }
}
