package com.google.android.gms.measurement.internal;

final class Ed implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ long f5544a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0608zd f5545b;

    Ed(C0608zd zdVar, long j2) {
        this.f5545b = zdVar;
        this.f5544a = j2;
    }

    public final void run() {
        this.f5545b.b(this.f5544a);
    }
}
