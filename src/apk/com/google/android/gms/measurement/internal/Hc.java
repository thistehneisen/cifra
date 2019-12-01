package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Hc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5583a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5584b;

    Hc(C0582uc ucVar, AtomicReference atomicReference) {
        this.f5584b = ucVar;
        this.f5583a = atomicReference;
    }

    public final void run() {
        synchronized (this.f5583a) {
            try {
                this.f5583a.set(Integer.valueOf(this.f5584b.g().b(this.f5584b.q().C(), C0535l.V)));
                this.f5583a.notify();
            } catch (Throwable th) {
                this.f5583a.notify();
                throw th;
            }
        }
    }
}
