package com.google.android.gms.tasks;

final class l implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f6203a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ k f6204b;

    l(k kVar, g gVar) {
        this.f6204b = kVar;
        this.f6203a = gVar;
    }

    public final void run() {
        if (this.f6203a.c()) {
            this.f6204b.f6202c.f();
            return;
        }
        try {
            this.f6204b.f6202c.a(this.f6204b.f6201b.a(this.f6203a));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f6204b.f6202c.a((Exception) e2.getCause());
            } else {
                this.f6204b.f6202c.a((Exception) e2);
            }
        } catch (Exception e3) {
            this.f6204b.f6202c.a(e3);
        }
    }
}
