package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.a.m;
import java.util.Queue;

/* compiled from: BaseKeyPool */
abstract class d<T extends m> {

    /* renamed from: a reason: collision with root package name */
    private final Queue<T> f3906a = n.a(20);

    d() {
    }

    /* access modifiers changed from: 0000 */
    public abstract T a();

    public void a(T t) {
        if (this.f3906a.size() < 20) {
            this.f3906a.offer(t);
        }
    }

    /* access modifiers changed from: 0000 */
    public T b() {
        T t = (m) this.f3906a.poll();
        return t == null ? a() : t;
    }
}
