package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Ec implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5542a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5543b;

    Ec(C0582uc ucVar, AtomicReference atomicReference) {
        this.f5543b = ucVar;
        this.f5542a = atomicReference;
    }

    public final void run() {
        synchronized (this.f5542a) {
            try {
                this.f5542a.set(Long.valueOf(this.f5543b.g().a(this.f5543b.q().C(), C0535l.U)));
                this.f5542a.notify();
            } catch (Throwable th) {
                this.f5542a.notify();
                throw th;
            }
        }
    }
}
