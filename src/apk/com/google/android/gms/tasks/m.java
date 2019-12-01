package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class m<TResult, TContinuationResult> implements C0610b, d, e<TContinuationResult>, y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6205a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final C0609a<TResult, g<TContinuationResult>> f6206b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final B<TContinuationResult> f6207c;

    public m(Executor executor, C0609a<TResult, g<TContinuationResult>> aVar, B<TContinuationResult> b2) {
        this.f6205a = executor;
        this.f6206b = aVar;
        this.f6207c = b2;
    }

    public final void a(g<TResult> gVar) {
        this.f6205a.execute(new n(this, gVar));
    }

    public final void b(TContinuationResult tcontinuationresult) {
        this.f6207c.a(tcontinuationresult);
    }

    public final void a(Exception exc) {
        this.f6207c.a(exc);
    }

    public final void a() {
        this.f6207c.f();
    }
}
