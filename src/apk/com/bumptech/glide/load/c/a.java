package com.bumptech.glide.load.c;

import com.bumptech.glide.h.l;
import com.bumptech.glide.load.engine.G;

/* compiled from: SimpleResource */
public class a<T> implements G<T> {

    /* renamed from: a reason: collision with root package name */
    protected final T f3709a;

    public a(T t) {
        l.a(t);
        this.f3709a = t;
    }

    public void a() {
    }

    public final int b() {
        return 1;
    }

    public Class<T> c() {
        return this.f3709a.getClass();
    }

    public final T get() {
        return this.f3709a;
    }
}
