package com.google.android.gms.tasks;

final class t implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f6222a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ s f6223b;

    t(s sVar, g gVar) {
        this.f6223b = sVar;
        this.f6222a = gVar;
    }

    public final void run() {
        synchronized (this.f6223b.f6220b) {
            if (this.f6223b.f6221c != null) {
                this.f6223b.f6221c.a(this.f6222a.a());
            }
        }
    }
}
