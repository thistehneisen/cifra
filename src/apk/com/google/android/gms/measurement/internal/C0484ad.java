package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.ad reason: case insensitive filesystem */
final class C0484ad implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5816a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ ae f5817b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Zc f5818c;

    C0484ad(Zc zc, AtomicReference atomicReference, ae aeVar) {
        this.f5818c = zc;
        this.f5816a = atomicReference;
        this.f5817b = aeVar;
    }

    public final void run() {
        synchronized (this.f5816a) {
            try {
                C0487bb d2 = this.f5818c.f5791d;
                if (d2 == null) {
                    this.f5818c.e().t().a("Failed to get app instance id");
                    this.f5816a.notify();
                    return;
                }
                this.f5816a.set(d2.a(this.f5817b));
                String str = (String) this.f5816a.get();
                if (str != null) {
                    this.f5818c.p().a(str);
                    this.f5818c.f().m.a(str);
                }
                this.f5818c.J();
                this.f5816a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f5818c.e().t().a("Failed to get app instance id", e2);
                    this.f5816a.notify();
                } catch (Throwable th) {
                    this.f5816a.notify();
                    throw th;
                }
            }
        }
    }
}
