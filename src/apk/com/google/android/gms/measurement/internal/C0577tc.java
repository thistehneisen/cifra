package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.tc reason: case insensitive filesystem */
final class C0577tc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6110a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0582uc f6111b;

    C0577tc(C0582uc ucVar, AtomicReference atomicReference) {
        this.f6111b = ucVar;
        this.f6110a = atomicReference;
    }

    public final void run() {
        synchronized (this.f6110a) {
            try {
                this.f6110a.set(Boolean.valueOf(this.f6111b.g().g(this.f6111b.q().C())));
                this.f6110a.notify();
            } catch (Throwable th) {
                this.f6110a.notify();
                throw th;
            }
        }
    }
}
