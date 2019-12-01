package com.google.firebase.components;

import com.google.firebase.b.a;

/* compiled from: com.google.firebase:firebase-common@@17.0.0 */
class t<T> implements a<T> {

    /* renamed from: a reason: collision with root package name */
    private static final Object f6720a = new Object();

    /* renamed from: b reason: collision with root package name */
    private volatile Object f6721b = f6720a;

    /* renamed from: c reason: collision with root package name */
    private volatile a<T> f6722c;

    t(a<T> aVar) {
        this.f6722c = aVar;
    }

    public T get() {
        T t = this.f6721b;
        if (t == f6720a) {
            synchronized (this) {
                t = this.f6721b;
                if (t == f6720a) {
                    t = this.f6722c.get();
                    this.f6721b = t;
                    this.f6722c = null;
                }
            }
        }
        return t;
    }
}
