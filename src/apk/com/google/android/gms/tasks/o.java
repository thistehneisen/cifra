package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class o<TResult> implements y<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Executor f6210a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Object f6211b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public C0610b f6212c;

    public o(Executor executor, C0610b bVar) {
        this.f6210a = executor;
        this.f6212c = bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0010, code lost:
        r1.f6210a.execute(new com.google.android.gms.tasks.p(r1));
     */
    public final void a(g gVar) {
        if (gVar.c()) {
            synchronized (this.f6211b) {
                if (this.f6212c == null) {
                }
            }
        }
    }
}
