package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class k<TResult, TContinuationResult> implements y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6200a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final C0609a<TResult, TContinuationResult> f6201b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final B<TContinuationResult> f6202c;

    public k(Executor executor, C0609a<TResult, TContinuationResult> aVar, B<TContinuationResult> b2) {
        this.f6200a = executor;
        this.f6201b = aVar;
        this.f6202c = b2;
    }

    public final void a(g<TResult> gVar) {
        this.f6200a.execute(new l(this, gVar));
    }
}
