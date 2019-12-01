package com.google.android.gms.tasks;

final class n implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f6208a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ m f6209b;

    n(m mVar, g gVar) {
        this.f6209b = mVar;
        this.f6208a = gVar;
    }

    public final void run() {
        try {
            g gVar = (g) this.f6209b.f6206b.a(this.f6208a);
            if (gVar == null) {
                this.f6209b.a((Exception) new NullPointerException("Continuation returned null"));
                return;
            }
            gVar.a(i.f6197b, (e<? super TResult>) this.f6209b);
            gVar.a(i.f6197b, (d) this.f6209b);
            gVar.a(i.f6197b, (C0610b) this.f6209b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f6209b.f6207c.a((Exception) e2.getCause());
            } else {
                this.f6209b.f6207c.a((Exception) e2);
            }
        } catch (Exception e3) {
            this.f6209b.f6207c.a(e3);
        }
    }
}
