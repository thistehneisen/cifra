package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class u<TResult> implements y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6224a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Object f6225b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public e<? super TResult> f6226c;

    public u(Executor executor, e<? super TResult> eVar) {
        this.f6224a = executor;
        this.f6226c = eVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r2.f6224a.execute(new com.google.android.gms.tasks.v(r2, r3));
     */
    public final void a(g<TResult> gVar) {
        if (gVar.e()) {
            synchronized (this.f6225b) {
                if (this.f6226c == null) {
                }
            }
        }
    }
}
