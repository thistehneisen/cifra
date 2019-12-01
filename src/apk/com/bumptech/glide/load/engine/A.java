package com.bumptech.glide.load.engine;

import com.bumptech.glide.h.l;
import com.bumptech.glide.load.f;

/* compiled from: EngineResource */
class A<Z> implements G<Z> {

    /* renamed from: a reason: collision with root package name */
    private final boolean f3849a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f3850b;

    /* renamed from: c reason: collision with root package name */
    private final G<Z> f3851c;

    /* renamed from: d reason: collision with root package name */
    private a f3852d;

    /* renamed from: e reason: collision with root package name */
    private f f3853e;

    /* renamed from: f reason: collision with root package name */
    private int f3854f;

    /* renamed from: g reason: collision with root package name */
    private boolean f3855g;

    /* compiled from: EngineResource */
    interface a {
        void a(f fVar, A<?> a2);
    }

    A(G<Z> g2, boolean z, boolean z2) {
        l.a(g2);
        this.f3851c = g2;
        this.f3849a = z;
        this.f3850b = z2;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(f fVar, a aVar) {
        this.f3853e = fVar;
        this.f3852d = aVar;
    }

    public int b() {
        return this.f3851c.b();
    }

    public Class<Z> c() {
        return this.f3851c.c();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void d() {
        if (!this.f3855g) {
            this.f3854f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: 0000 */
    public G<Z> e() {
        return this.f3851c;
    }

    /* access modifiers changed from: 0000 */
    public boolean f() {
        return this.f3849a;
    }

    /* access modifiers changed from: 0000 */
    public void g() {
        synchronized (this.f3852d) {
            synchronized (this) {
                if (this.f3854f > 0) {
                    int i2 = this.f3854f - 1;
                    this.f3854f = i2;
                    if (i2 == 0) {
                        this.f3852d.a(this.f3853e, this);
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
        }
    }

    public Z get() {
        return this.f3851c.get();
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("EngineResource{isCacheable=");
        sb.append(this.f3849a);
        sb.append(", listener=");
        sb.append(this.f3852d);
        sb.append(", key=");
        sb.append(this.f3853e);
        sb.append(", acquired=");
        sb.append(this.f3854f);
        sb.append(", isRecycled=");
        sb.append(this.f3855g);
        sb.append(", resource=");
        sb.append(this.f3851c);
        sb.append('}');
        return sb.toString();
    }

    public synchronized void a() {
        if (this.f3854f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f3855g) {
            this.f3855g = true;
            if (this.f3850b) {
                this.f3851c.a();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }
}
