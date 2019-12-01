package io.intercom.com.bumptech.glide.load.engine;

import b.g.h.d;
import io.intercom.com.bumptech.glide.h.a.d.c;
import io.intercom.com.bumptech.glide.h.a.f;
import io.intercom.com.bumptech.glide.h.h;

/* compiled from: LockedResource */
final class D<Z> implements E<Z>, c {

    /* renamed from: a reason: collision with root package name */
    private static final d<D<?>> f9724a = io.intercom.com.bumptech.glide.h.a.d.b(20, new C());

    /* renamed from: b reason: collision with root package name */
    private final f f9725b = f.a();

    /* renamed from: c reason: collision with root package name */
    private E<Z> f9726c;

    /* renamed from: d reason: collision with root package name */
    private boolean f9727d;

    /* renamed from: e reason: collision with root package name */
    private boolean f9728e;

    D() {
    }

    static <Z> D<Z> a(E<Z> e2) {
        D<Z> d2 = (D) f9724a.a();
        h.a(d2);
        D<Z> d3 = d2;
        d3.b(e2);
        return d3;
    }

    private void b(E<Z> e2) {
        this.f9728e = false;
        this.f9727d = true;
        this.f9726c = e2;
    }

    private void f() {
        this.f9726c = null;
        f9724a.a(this);
    }

    public Class<Z> c() {
        return this.f9726c.c();
    }

    public f d() {
        return this.f9725b;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void e() {
        this.f9725b.b();
        if (this.f9727d) {
            this.f9727d = false;
            if (this.f9728e) {
                a();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public Z get() {
        return this.f9726c.get();
    }

    public synchronized void a() {
        this.f9725b.b();
        this.f9728e = true;
        if (!this.f9727d) {
            this.f9726c.a();
            f();
        }
    }

    public int b() {
        return this.f9726c.b();
    }
}
