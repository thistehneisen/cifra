package com.google.android.gms.tasks;

final class v implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f6227a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ u f6228b;

    v(u uVar, g gVar) {
        this.f6228b = uVar;
        this.f6227a = gVar;
    }

    public final void run() {
        synchronized (this.f6228b.f6225b) {
            if (this.f6228b.f6226c != null) {
                this.f6228b.f6226c.b(this.f6227a.b());
            }
        }
    }
}
