package com.google.android.gms.tasks;

final class r implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f6217a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ q f6218b;

    r(q qVar, g gVar) {
        this.f6218b = qVar;
        this.f6217a = gVar;
    }

    public final void run() {
        synchronized (this.f6218b.f6215b) {
            if (this.f6218b.f6216c != null) {
                this.f6218b.f6216c.a(this.f6217a);
            }
        }
    }
}
