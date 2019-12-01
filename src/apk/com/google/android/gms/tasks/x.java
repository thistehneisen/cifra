package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

final class x implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ g f6232a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ w f6233b;

    x(w wVar, g gVar) {
        this.f6233b = wVar;
        this.f6232a = gVar;
    }

    public final void run() {
        try {
            g a2 = this.f6233b.f6230b.a(this.f6232a.b());
            if (a2 == null) {
                this.f6233b.a((Exception) new NullPointerException("Continuation returned null"));
                return;
            }
            a2.a(i.f6197b, (e<? super TResult>) this.f6233b);
            a2.a(i.f6197b, (d) this.f6233b);
            a2.a(i.f6197b, (C0610b) this.f6233b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.f6233b.a((Exception) e2.getCause());
            } else {
                this.f6233b.a((Exception) e2);
            }
        } catch (CancellationException unused) {
            this.f6233b.a();
        } catch (Exception e3) {
            this.f6233b.a(e3);
        }
    }
}
