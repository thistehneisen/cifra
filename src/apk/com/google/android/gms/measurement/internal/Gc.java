package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Gc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5570a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5571b;

    Gc(C0582uc ucVar, AtomicReference atomicReference) {
        this.f5571b = ucVar;
        this.f5570a = atomicReference;
    }

    public final void run() {
        synchronized (this.f5570a) {
            try {
                this.f5570a.set(Double.valueOf(this.f5571b.g().c(this.f5571b.q().C(), C0535l.W)));
                this.f5570a.notify();
            } catch (Throwable th) {
                this.f5570a.notify();
                throw th;
            }
        }
    }
}
