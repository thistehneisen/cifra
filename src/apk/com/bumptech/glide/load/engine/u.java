package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.h.h;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.b.a.C0056a;
import com.bumptech.glide.load.engine.b.i;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.l;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: Engine */
public class u implements x, com.bumptech.glide.load.engine.b.i.a, a {

    /* renamed from: a reason: collision with root package name */
    private static final boolean f4078a = Log.isLoggable("Engine", 2);

    /* renamed from: b reason: collision with root package name */
    private final C f4079b;

    /* renamed from: c reason: collision with root package name */
    private final z f4080c;

    /* renamed from: d reason: collision with root package name */
    private final i f4081d;

    /* renamed from: e reason: collision with root package name */
    private final b f4082e;

    /* renamed from: f reason: collision with root package name */
    private final J f4083f;

    /* renamed from: g reason: collision with root package name */
    private final c f4084g;

    /* renamed from: h reason: collision with root package name */
    private final a f4085h;

    /* renamed from: i reason: collision with root package name */
    private final C0290d f4086i;

    /* compiled from: Engine */
    static class a {

        /* renamed from: a reason: collision with root package name */
        final d f4087a;

        /* renamed from: b reason: collision with root package name */
        final b.g.h.d<l<?>> f4088b = com.bumptech.glide.h.a.d.a(150, (com.bumptech.glide.h.a.d.a<T>) new t<T>(this));

        /* renamed from: c reason: collision with root package name */
        private int f4089c;

        a(d dVar) {
            this.f4087a = dVar;
        }

        /* access modifiers changed from: 0000 */
        public <R> l<R> a(g gVar, Object obj, y yVar, f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, j jVar, s sVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.i iVar, a<R> aVar) {
            g gVar2 = gVar;
            Object obj2 = obj;
            y yVar2 = yVar;
            f fVar2 = fVar;
            int i4 = i2;
            int i5 = i3;
            Class<?> cls3 = cls;
            Class<R> cls4 = cls2;
            j jVar2 = jVar;
            s sVar2 = sVar;
            Map<Class<?>, l<?>> map2 = map;
            boolean z4 = z;
            boolean z5 = z2;
            boolean z6 = z3;
            com.bumptech.glide.load.i iVar2 = iVar;
            a<R> aVar2 = aVar;
            l lVar = (l) this.f4088b.a();
            com.bumptech.glide.h.l.a(lVar);
            l<R> lVar2 = lVar;
            l<R> lVar3 = lVar2;
            int i6 = this.f4089c;
            int i7 = i6;
            this.f4089c = i6 + 1;
            lVar3.a(gVar2, obj2, yVar2, fVar2, i4, i5, cls3, cls4, jVar2, sVar2, map2, z4, z5, z6, iVar2, aVar2, i7);
            return lVar2;
        }
    }

    /* compiled from: Engine */
    static class b {

        /* renamed from: a reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f4090a;

        /* renamed from: b reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f4091b;

        /* renamed from: c reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f4092c;

        /* renamed from: d reason: collision with root package name */
        final com.bumptech.glide.load.engine.c.b f4093d;

        /* renamed from: e reason: collision with root package name */
        final x f4094e;

        /* renamed from: f reason: collision with root package name */
        final b.g.h.d<w<?>> f4095f = com.bumptech.glide.h.a.d.a(150, (com.bumptech.glide.h.a.d.a<T>) new v<T>(this));

        b(com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, x xVar) {
            this.f4090a = bVar;
            this.f4091b = bVar2;
            this.f4092c = bVar3;
            this.f4093d = bVar4;
            this.f4094e = xVar;
        }

        /* access modifiers changed from: 0000 */
        public <R> w<R> a(f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            w<R> wVar = (w) this.f4095f.a();
            com.bumptech.glide.h.l.a(wVar);
            w<R> wVar2 = wVar;
            wVar2.a(fVar, z, z2, z3, z4);
            return wVar2;
        }
    }

    /* compiled from: Engine */
    private static class c implements d {

        /* renamed from: a reason: collision with root package name */
        private final C0056a f4096a;

        /* renamed from: b reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.b.a f4097b;

        c(C0056a aVar) {
            this.f4096a = aVar;
        }

        public com.bumptech.glide.load.engine.b.a a() {
            if (this.f4097b == null) {
                synchronized (this) {
                    if (this.f4097b == null) {
                        this.f4097b = this.f4096a.build();
                    }
                    if (this.f4097b == null) {
                        this.f4097b = new com.bumptech.glide.load.engine.b.b();
                    }
                }
            }
            return this.f4097b;
        }
    }

    /* compiled from: Engine */
    public class d {

        /* renamed from: a reason: collision with root package name */
        private final w<?> f4098a;

        /* renamed from: b reason: collision with root package name */
        private final com.bumptech.glide.f.g f4099b;

        d(com.bumptech.glide.f.g gVar, w<?> wVar) {
            this.f4099b = gVar;
            this.f4098a = wVar;
        }

        public void a() {
            synchronized (u.this) {
                this.f4098a.c(this.f4099b);
            }
        }
    }

    public u(i iVar, C0056a aVar, com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, boolean z) {
        this(iVar, aVar, bVar, bVar2, bVar3, bVar4, null, null, null, null, null, null, z);
    }

    private A<?> b(f fVar, boolean z) {
        if (!z) {
            return null;
        }
        A<?> a2 = a(fVar);
        if (a2 != null) {
            a2.d();
            this.f4086i.a(fVar, a2);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        return null;
     */
    public synchronized <R> d a(g gVar, Object obj, f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, j jVar, s sVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, com.bumptech.glide.load.i iVar, boolean z3, boolean z4, boolean z5, boolean z6, com.bumptech.glide.f.g gVar2, Executor executor) {
        boolean z7 = z3;
        com.bumptech.glide.f.g gVar3 = gVar2;
        Executor executor2 = executor;
        synchronized (this) {
            long a2 = f4078a ? h.a() : 0;
            y a3 = this.f4080c.a(obj, fVar, i2, i3, map, cls, cls2, iVar);
            A a4 = a((f) a3, z7);
            if (a4 != null) {
                gVar3.a(a4, com.bumptech.glide.load.a.MEMORY_CACHE);
                if (f4078a) {
                    a("Loaded resource from active resources", a2, (f) a3);
                }
            } else {
                A b2 = b(a3, z7);
                if (b2 != null) {
                    gVar3.a(b2, com.bumptech.glide.load.a.MEMORY_CACHE);
                    if (f4078a) {
                        a("Loaded resource from cache", a2, (f) a3);
                    }
                } else {
                    w a5 = this.f4079b.a((f) a3, z6);
                    if (a5 != null) {
                        a5.a(gVar3, executor2);
                        if (f4078a) {
                            a("Added to existing load", a2, (f) a3);
                        }
                        d dVar = new d(gVar3, a5);
                        return dVar;
                    }
                    w a6 = this.f4082e.a(a3, z3, z4, z5, z6);
                    l a7 = this.f4085h.a(gVar, obj, a3, fVar, i2, i3, cls, cls2, jVar, sVar, map, z, z2, z6, iVar, a6);
                    this.f4079b.a((f) a3, a6);
                    a6.a(gVar3, executor2);
                    a6.b(a7);
                    if (f4078a) {
                        a("Started new load", a2, (f) a3);
                    }
                    d dVar2 = new d(gVar3, a6);
                    return dVar2;
                }
            }
        }
    }

    u(i iVar, C0056a aVar, com.bumptech.glide.load.engine.c.b bVar, com.bumptech.glide.load.engine.c.b bVar2, com.bumptech.glide.load.engine.c.b bVar3, com.bumptech.glide.load.engine.c.b bVar4, C c2, z zVar, C0290d dVar, b bVar5, a aVar2, J j2, boolean z) {
        this.f4081d = iVar;
        C0056a aVar3 = aVar;
        this.f4084g = new c(aVar);
        C0290d dVar2 = dVar == null ? new C0290d(z) : dVar;
        this.f4086i = dVar2;
        dVar2.a((a) this);
        this.f4080c = zVar == null ? new z() : zVar;
        this.f4079b = c2 == null ? new C() : c2;
        this.f4082e = bVar5 == null ? new b(bVar, bVar2, bVar3, bVar4, this) : bVar5;
        this.f4085h = aVar2 == null ? new a(this.f4084g) : aVar2;
        this.f4083f = j2 == null ? new J() : j2;
        iVar.a((com.bumptech.glide.load.engine.b.i.a) this);
    }

    public void b(G<?> g2) {
        if (g2 instanceof A) {
            ((A) g2).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    private static void a(String str, long j2, f fVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(h.a(j2));
        sb.append("ms, key: ");
        sb.append(fVar);
        Log.v("Engine", sb.toString());
    }

    private A<?> a(f fVar, boolean z) {
        if (!z) {
            return null;
        }
        A<?> b2 = this.f4086i.b(fVar);
        if (b2 != null) {
            b2.d();
        }
        return b2;
    }

    private A<?> a(f fVar) {
        G a2 = this.f4081d.a(fVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof A) {
            return (A) a2;
        }
        return new A(a2, true, true);
    }

    public synchronized void a(w<?> wVar, f fVar, A<?> a2) {
        if (a2 != null) {
            a2.a(fVar, this);
            if (a2.f()) {
                this.f4086i.a(fVar, a2);
            }
        }
        this.f4079b.b(fVar, wVar);
    }

    public synchronized void a(w<?> wVar, f fVar) {
        this.f4079b.b(fVar, wVar);
    }

    public void a(G<?> g2) {
        this.f4083f.a(g2);
    }

    public synchronized void a(f fVar, A<?> a2) {
        this.f4086i.a(fVar);
        if (a2.f()) {
            this.f4081d.a(fVar, a2);
        } else {
            this.f4083f.a(a2);
        }
    }
}
