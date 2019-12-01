package io.intercom.com.bumptech.glide.load.engine.a;

import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.engine.a.m;
import java.util.Queue;

/* compiled from: BaseKeyPool */
abstract class d<T extends m> {

    /* renamed from: a reason: collision with root package name */
    private final Queue<T> f9767a = j.a(20);

    d() {
    }

    /* access modifiers changed from: 0000 */
    public abstract T a();

    public void a(T t) {
        if (this.f9767a.size() < 20) {
            this.f9767a.offer(t);
        }
    }

    /* access modifiers changed from: 0000 */
    public T b() {
        T t = (m) this.f9767a.poll();
        return t == null ? a() : t;
    }
}
