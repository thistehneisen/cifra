package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class q<TResult> implements y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6214a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Object f6215b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public C0611c<TResult> f6216c;

    public q(Executor executor, C0611c<TResult> cVar) {
        this.f6214a = executor;
        this.f6216c = cVar;
    }

    public final void a(g<TResult> gVar) {
        synchronized (this.f6215b) {
            if (this.f6216c != null) {
                this.f6214a.execute(new r(this, gVar));
            }
        }
    }
}
