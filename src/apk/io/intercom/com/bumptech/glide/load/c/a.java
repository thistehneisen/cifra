package io.intercom.com.bumptech.glide.load.c;

import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.engine.E;

/* compiled from: SimpleResource */
public class a<T> implements E<T> {

    /* renamed from: a reason: collision with root package name */
    protected final T f9577a;

    public a(T t) {
        h.a(t);
        this.f9577a = t;
    }

    public void a() {
    }

    public final int b() {
        return 1;
    }

    public Class<T> c() {
        return this.f9577a.getClass();
    }

    public final T get() {
        return this.f9577a;
    }
}
