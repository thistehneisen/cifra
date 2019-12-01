package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class Bc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5517a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f5518b;

    Bc(C0582uc ucVar, AtomicReference atomicReference) {
        this.f5518b = ucVar;
        this.f5517a = atomicReference;
    }

    public final void run() {
        synchronized (this.f5517a) {
            try {
                this.f5517a.set(this.f5518b.g().h(this.f5518b.q().C()));
                this.f5517a.notify();
            } catch (Throwable th) {
                this.f5517a.notify();
                throw th;
            }
        }
    }
}
