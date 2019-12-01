package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class s<TResult> implements y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6219a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Object f6220b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public d f6221c;

    public s(Executor executor, d dVar) {
        this.f6219a = executor;
        this.f6221c = dVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        r2.f6219a.execute(new com.google.android.gms.tasks.t(r2, r3));
     */
    public final void a(g<TResult> gVar) {
        if (!gVar.e() && !gVar.c()) {
            synchronized (this.f6220b) {
                if (this.f6221c == null) {
                }
            }
        }
    }
}
