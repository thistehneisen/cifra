package com.bumptech.glide.load.engine;

import b.g.h.d;
import com.bumptech.glide.h.a.d.a;
import com.bumptech.glide.h.a.d.c;
import com.bumptech.glide.h.a.g;
import com.bumptech.glide.h.l;

/* compiled from: LockedResource */
final class F<Z> implements G<Z>, c {

    /* renamed from: a reason: collision with root package name */
    private static final d<F<?>> f3862a = com.bumptech.glide.h.a.d.a(20, (a<T>) new E<T>());

    /* renamed from: b reason: collision with root package name */
    private final g f3863b = g.a();

    /* renamed from: c reason: collision with root package name */
    private G<Z> f3864c;

    /* renamed from: d reason: collision with root package name */
    private boolean f3865d;

    /* renamed from: e reason: collision with root package name */
    private boolean f3866e;

    F() {
    }

    static <Z> F<Z> a(G<Z> g2) {
        F<Z> f2 = (F) f3862a.a();
        l.a(f2);
        F<Z> f3 = f2;
        f3.b(g2);
        return f3;
    }

    private void b(G<Z> g2) {
        this.f3866e = false;
        this.f3865d = true;
        this.f3864c = g2;
    }

    private void f() {
        this.f3864c = null;
        f3862a.a(this);
    }

    public Class<Z> c() {
        return this.f3864c.c();
    }

    public g d() {
        return this.f3863b;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void e() {
        this.f3863b.b();
        if (this.f3865d) {
            this.f3865d = false;
            if (this.f3866e) {
                a();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Z get() {
        return this.f3864c.get();
    }

    public synchronized void a() {
        this.f3863b.b();
        this.f3866e = true;
        if (!this.f3865d) {
            this.f3864c.a();
            f();
        }
    }

    public int b() {
        return this.f3864c.b();
    }
}
