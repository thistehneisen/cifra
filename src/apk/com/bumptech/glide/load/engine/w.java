package com.bumptech.glide.load.engine;

import com.bumptech.glide.h.a.g;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: EngineJob */
class w<R> implements a<R>, com.bumptech.glide.h.a.d.c {

    /* renamed from: a reason: collision with root package name */
    private static final c f4102a = new c();

    /* renamed from: b reason: collision with root package name */
    final e f4103b;

    /* renamed from: c reason: collision with root package name */
    private final g f4104c;

    /* renamed from: d reason: collision with root package name */
    private final b.g.h.d<w<?>> f4105d;

    /* renamed from: e reason: collision with root package name */
    private final c f4106e;

    /* renamed from: f reason: collision with root package name */
    private final x f4107f;

    /* renamed from: g reason: collision with root package name */
    private final com.bumptech.glide.load.engine.c.b f4108g;

    /* renamed from: h reason: collision with root package name */
    private final com.bumptech.glide.load.engine.c.b f4109h;

    /* renamed from: i reason: collision with root package name */
    private final com.bumptech.glide.load.engine.c.b f4110i;

    /* renamed from: j reason: collision with root package name */
    private final com.bumptech.glide.load.engine.c.b f4111j;

    /* renamed from: k reason: collision with root package name */
    private final AtomicInteger f4112k;

    /* renamed from: l reason: collision with root package name */
    private f f4113l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private G<?> q;
    com.bumptech.glide.load.a r;
    private boolean s;
    GlideException t;
    private boolean u;
    A<?> v;
    private l<R> w;
    private volatile boolean x;

    /* compiled from: EngineJob */
    private class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final com.bumptech.glide.f.g f4114a;

        a(com.bumptech.glide.f.g gVar) {
            this.f4114a = gVar;
        }

        public void run() {
            synchronized (w.this) {
                if (w.this.f4103b.a(this.f4114a)) {
                    w.this.a(this.f4114a);
                }
                w.this.b();
            }
        }
    }

    /* compiled from: EngineJob */
    private class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final com.bumptech.glide.f.g f4116a;

        b(com.bumptech.glide.f.g gVar) {
            this.f4116a = gVar;
        }

        public void run() {
            synchronized (w.this) {
                if (w.this.f4103b.a(this.f4116a)) {
                    w.this.v.d();
                    w.this.b(this.f4116a);
                    w.this.c(this.f4116a);
                }
                w.this.b();
            }
        }
    }

    /* compiled from: EngineJob */
    static class c {
        c() {
        }

        public <R> A<R> a(G<R> g2, boolean z) {
            return new A<>(g2, z, true);
        }
    }

    /* compiled from: EngineJob */
    static final class d {

        /* renamed from: a reason: collision with root package name */
        final com.bumptech.glide.f.g f4118a;

        /* renamed from: b reason: collision with root package name */
        final Executor f4119b;

        d(com.bumptech.glide.f.g gVar, Executor executor) {
            this.f4118a = gVar;
            this.f4119b = executor;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            return this.f4118a.equals(((d) obj).f4118a);
        }

        public int hashCode() {
            return this.f4118a.hashCode();
        }
    }

    /* compiled from: EngineJob */
    static final class e implements Iterable<d> {

        /* renamed from: a reason: collision with root package name */
        private final List<d> f4120a;

        e() {
            this(new ArrayList(2));
        }

        private static d c(com.bumptech.glide.f.g gVar) {
            return new d(gVar, com.bumptech.glide.h.g.a());
        }

        /* access modifiers changed from: 0000 */
        public void a(com.bumptech.glide.f.g gVar, Executor executor) {
            this.f4120a.add(new d(gVar, executor));
        }

        /* access modifiers changed from: 0000 */
        public void b(com.bumptech.glide.f.g gVar) {
            this.f4120a.remove(c(gVar));
        }

        /* access modifiers changed from: 0000 */
        public void clear() {
            this.f4120a.clear();
        }

        /* access modifiers changed from: 0000 */
        public e e() {
            return new e(new ArrayList(this.f4120a));
        }

        /* access modifiers changed from: 0000 */
        public boolean isEmpty() {
            return this.f4120a.isEmpty();
        }

        public Iterator<d> iterator() {
            return this.f4120a.iterator();
        }

        /* access modifiers changed from: 0000 */
        public int size() {
            return this.f4120a.size();
        }

        e(List<d> list) {
            this.f4120a = list;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(com.bumptech.glide.f.g gVar) {
            return this.f4120a.contains(c(gVar));
        }
    }

    w(com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, x xVar, b.g.h.d<w<?>> dVar) {
        this(bVar, bVar2, bVar3, bVar4, xVar, dVar, f4102a);
    }

    private com.bumptech.glide.load.engine.c.b g() {
        if (this.n) {
            return this.f4110i;
        }
        return this.o ? this.f4111j : this.f4109h;
    }

    private boolean h() {
        return this.u || this.s || this.x;
    }

    private synchronized void i() {
        if (this.f4113l != null) {
            this.f4103b.clear();
            this.f4113l = null;
            this.v = null;
            this.q = null;
            this.u = false;
            this.x = false;
            this.s = false;
            this.w.a(false);
            this.w = null;
            this.t = null;
            this.r = null;
            this.f4105d.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized w<R> a(f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f4113l = fVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public synchronized void b(l<R> lVar) {
        com.bumptech.glide.load.engine.c.b bVar;
        this.w = lVar;
        if (lVar.c()) {
            bVar = this.f4108g;
        } else {
            bVar = g();
        }
        bVar.execute(lVar);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void c(com.bumptech.glide.f.g gVar) {
        boolean z;
        this.f4104c.b();
        this.f4103b.b(gVar);
        if (this.f4103b.isEmpty()) {
            a();
            if (!this.s) {
                if (!this.u) {
                    z = false;
                    if (z && this.f4112k.get() == 0) {
                        i();
                    }
                }
            }
            z = true;
            i();
        }
    }

    public g d() {
        return this.f4104c;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r4.f4107f.a(r4, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r0.hasNext() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r1 = (com.bumptech.glide.load.engine.w.d) r0.next();
        r1.f4119b.execute(new com.bumptech.glide.load.engine.w.b(r4, r1.f4118a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        return;
     */
    public void e() {
        synchronized (this) {
            this.f4104c.b();
            if (this.x) {
                this.q.a();
                i();
            } else if (this.f4103b.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            } else if (!this.s) {
                this.v = this.f4106e.a(this.q, this.m);
                this.s = true;
                e e2 = this.f4103b.e();
                a(e2.size() + 1);
                f fVar = this.f4113l;
                A<?> a2 = this.v;
            } else {
                throw new IllegalStateException("Already have resource");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean f() {
        return this.p;
    }

    w(com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, x xVar, b.g.h.d<w<?>> dVar, c cVar) {
        this.f4103b = new e();
        this.f4104c = g.a();
        this.f4112k = new AtomicInteger();
        this.f4108g = bVar;
        this.f4109h = bVar2;
        this.f4110i = bVar3;
        this.f4111j = bVar4;
        this.f4107f = xVar;
        this.f4105d = dVar;
        this.f4106e = cVar;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(com.bumptech.glide.f.g gVar, Executor executor) {
        this.f4104c.b();
        this.f4103b.a(gVar, executor);
        boolean z = true;
        if (this.s) {
            a(1);
            executor.execute(new b(gVar));
        } else if (this.u) {
            a(1);
            executor.execute(new a(gVar));
        } else {
            if (this.x) {
                z = false;
            }
            l.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void b(com.bumptech.glide.f.g gVar) {
        try {
            gVar.a(this.v, this.r);
        } catch (Throwable th) {
            throw new C0291e(th);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f4107f.a(r4, r1, null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = (com.bumptech.glide.load.engine.w.d) r0.next();
        r1.f4119b.execute(new com.bumptech.glide.load.engine.w.a(r4, r1.f4118a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    public void c() {
        synchronized (this) {
            this.f4104c.b();
            if (this.x) {
                i();
            } else if (this.f4103b.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            } else if (!this.u) {
                this.u = true;
                f fVar = this.f4113l;
                e e2 = this.f4103b.e();
                a(e2.size() + 1);
            } else {
                throw new IllegalStateException("Already failed once");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void b() {
        this.f4104c.b();
        l.a(h(), "Not yet complete!");
        int decrementAndGet = this.f4112k.decrementAndGet();
        l.a(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.v != null) {
                this.v.g();
            }
            i();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(com.bumptech.glide.f.g gVar) {
        try {
            gVar.a(this.t);
        } catch (Throwable th) {
            throw new C0291e(th);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (!h()) {
            this.x = true;
            this.w.a();
            this.f4107f.a(this, this.f4113l);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(int i2) {
        l.a(h(), "Not yet complete!");
        if (this.f4112k.getAndAdd(i2) == 0 && this.v != null) {
            this.v.d();
        }
    }

    public void a(G<R> g2, com.bumptech.glide.load.a aVar) {
        synchronized (this) {
            this.q = g2;
            this.r = aVar;
        }
        e();
    }

    public void a(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        c();
    }

    public void a(l<?> lVar) {
        g().execute(lVar);
    }
}
