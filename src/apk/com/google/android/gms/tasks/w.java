package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class w<TResult, TContinuationResult> implements C0610b, d, e<TContinuationResult>, y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6229a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final f<TResult, TContinuationResult> f6230b;

    /* renamed from: c reason: collision with root package name */
    private final B<TContinuationResult> f6231c;

    public w(Executor executor, f<TResult, TContinuationResult> fVar, B<TContinuationResult> b2) {
        this.f6229a = executor;
        this.f6230b = fVar;
        this.f6231c = b2;
    }

    public final void a(g<TResult> gVar) {
        this.f6229a.execute(new x(this, gVar));
    }

    public final void b(TContinuationResult tcontinuationresult) {
        this.f6231c.a(tcontinuationresult);
    }

    public final void a(Exception exc) {
        this.f6231c.a(exc);
    }

    public final void a() {
        this.f6231c.f();
    }
}
