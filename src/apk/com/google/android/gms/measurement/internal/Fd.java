package com.google.android.gms.measurement.internal;

final class Fd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ long f5566a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0608zd f5567b;

    Fd(C0608zd zdVar, long j2) {
        this.f5567b = zdVar;
        this.f5566a = j2;
    }

    public final void run() {
        this.f5567b.a(this.f5566a);
    }
}
