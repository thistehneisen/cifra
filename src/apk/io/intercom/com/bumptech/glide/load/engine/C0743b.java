package io.intercom.com.bumptech.glide.load.engine;

import android.os.Process;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.b reason: case insensitive filesystem */
/* compiled from: ActiveResources */
class C0743b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0744c f9805a;

    C0743b(C0744c cVar) {
        this.f9805a = cVar;
    }

    public void run() {
        Process.setThreadPriority(10);
        while (!this.f9805a.f9846g) {
            try {
                this.f9805a.f9841b.obtainMessage(1, (b) this.f9805a.f9844e.remove()).sendToTarget();
                a d2 = this.f9805a.f9847h;
                if (d2 != null) {
                    d2.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
