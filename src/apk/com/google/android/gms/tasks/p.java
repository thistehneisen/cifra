package com.google.android.gms.tasks;

final class p implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ o f6213a;

    p(o oVar) {
        this.f6213a = oVar;
    }

    public final void run() {
        synchronized (this.f6213a.f6211b) {
            if (this.f6213a.f6212c != null) {
                this.f6213a.f6212c.a();
            }
        }
    }
}
