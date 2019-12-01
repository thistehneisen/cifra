package io.intercom.com.bumptech.glide.load.engine;

import android.util.Log;
import io.intercom.com.bumptech.glide.e;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.engine.b.a.C0112a;
import io.intercom.com.bumptech.glide.load.engine.b.i;
import io.intercom.com.bumptech.glide.load.g;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.m;
import java.util.Map;

/* compiled from: Engine */
public class s implements v, io.intercom.com.bumptech.glide.load.engine.b.i.a, a {

    /* renamed from: a reason: collision with root package name */
    private final A f9938a;

    /* renamed from: b reason: collision with root package name */
    private final x f9939b;

    /* renamed from: c reason: collision with root package name */
    private final i f9940c;

    /* renamed from: d reason: collision with root package name */
    private final b f9941d;

    /* renamed from: e reason: collision with root package name */
    private final H f9942e;

    /* renamed from: f reason: collision with root package name */
    private final c f9943f;

    /* renamed from: g reason: collision with root package name */
    private final a f9944g;

    /* renamed from: h reason: collision with root package name */
    private final C0744c f9945h;

    /* compiled from: Engine */
    static class a {

        /* renamed from: a reason: collision with root package name */
        final d f9946a;

        /* renamed from: b reason: collision with root package name */
        final b.g.h.d<j<?>> f9947b = io.intercom.com.bumptech.glide.h.a.d.a(150, (io.intercom.com.bumptech.glide.h.a.d.a<T>) new r<T>(this));

        /* renamed from: c reason: collision with root package name */
        private int f9948c;

        a(d dVar) {
            this.f9946a = dVar;
        }

        /* access modifiers changed from: 0000 */
        public <R> j<R> a(e eVar, Object obj, w wVar, g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, h hVar, q qVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, boolean z3, j jVar, a<R> aVar) {
            e eVar2 = eVar;
            Object obj2 = obj;
            w wVar2 = wVar;
            g gVar2 = gVar;
            int i4 = i2;
            int i5 = i3;
            Class<?> cls3 = cls;
            Class<R> cls4 = cls2;
            h hVar2 = hVar;
            q qVar2 = qVar;
            Map<Class<?>, m<?>> map2 = map;
            boolean z4 = z;
            boolean z5 = z2;
            boolean z6 = z3;
            j jVar2 = jVar;
            a<R> aVar2 = aVar;
            j jVar3 = (j) this.f9947b.a();
            io.intercom.com.bumptech.glide.h.h.a(jVar3);
            j<R> jVar4 = jVar3;
            j<R> jVar5 = jVar4;
            int i6 = this.f9948c;
            int i7 = i6;
            this.f9948c = i6 + 1;
            jVar5.a(eVar2, obj2, wVar2, gVar2, i4, i5, cls3, cls4, hVar2, qVar2, map2, z4, z5, z6, jVar2, aVar2, i7);
            return jVar4;
        }
    }

    /* compiled from: Engine */
    static class b {

        /* renamed from: a reason: collision with root package name */
        final io.intercom.com.bumptech.glide.load.engine.c.b f9949a;

        /* renamed from: b reason: collision with root package name */
        final io.intercom.com.bumptech.glide.load.engine.c.b f9950b;

        /* renamed from: c reason: collision with root package name */
        final io.intercom.com.bumptech.glide.load.engine.c.b f9951c;

        /* renamed from: d reason: collision with root package name */
        final io.intercom.com.bumptech.glide.load.engine.c.b f9952d;

        /* renamed from: e reason: collision with root package name */
        final v f9953e;

        /* renamed from: f reason: collision with root package name */
        final b.g.h.d<u<?>> f9954f = io.intercom.com.bumptech.glide.h.a.d.a(150, (io.intercom.com.bumptech.glide.h.a.d.a<T>) new t<T>(this));

        b(io.intercom.com.bumptech.glide.load.engine.c.b bVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar2, io.intercom.com.bumptech.glide.load.engine.c.b bVar3, io.intercom.com.bumptech.glide.load.engine.c.b bVar4, v vVar) {
            this.f9949a = bVar;
            this.f9950b = bVar2;
            this.f9951c = bVar3;
            this.f9952d = bVar4;
            this.f9953e = vVar;
        }

        /* access modifiers changed from: 0000 */
        public <R> u<R> a(g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
            u<R> uVar = (u) this.f9954f.a();
            io.intercom.com.bumptech.glide.h.h.a(uVar);
            u<R> uVar2 = uVar;
            uVar2.a(gVar, z, z2, z3, z4);
            return uVar2;
        }
    }

    /* compiled from: Engine */
    private static class c implements d {

        /* renamed from: a reason: collision with root package name */
        private final C0112a f9955a;

        /* renamed from: b reason: collision with root package name */
        private volatile io.intercom.com.bumptech.glide.load.engine.b.a f9956b;

        c(C0112a aVar) {
            this.f9955a = aVar;
        }

        public io.intercom.com.bumptech.glide.load.engine.b.a a() {
            if (this.f9956b == null) {
                synchronized (this) {
                    if (this.f9956b == null) {
                        this.f9956b = this.f9955a.build();
                    }
                    if (this.f9956b == null) {
                        this.f9956b = new io.intercom.com.bumptech.glide.load.engine.b.b();
                    }
                }
            }
            return this.f9956b;
        }
    }

    /* compiled from: Engine */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        private final u<?> f9957a;

        /* renamed from: b reason: collision with root package name */
        private final io.intercom.com.bumptech.glide.f.h f9958b;

        d(io.intercom.com.bumptech.glide.f.h hVar, u<?> uVar) {
            this.f9958b = hVar;
            this.f9957a = uVar;
        }

        public void a() {
            this.f9957a.b(this.f9958b);
        }
    }

    public s(i iVar, C0112a aVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar2, io.intercom.com.bumptech.glide.load.engine.c.b bVar3, io.intercom.com.bumptech.glide.load.engine.c.b bVar4, boolean z) {
        this(iVar, aVar, bVar, bVar2, bVar3, bVar4, null, null, null, null, null, null, z);
    }

    private y<?> b(g gVar, boolean z) {
        if (!z) {
            return null;
        }
        y<?> a2 = a(gVar);
        if (a2 != null) {
            a2.d();
            this.f9945h.a(gVar, a2);
        }
        return a2;
    }

    public <R> d a(e eVar, Object obj, g gVar, int i2, int i3, Class<?> cls, Class<R> cls2, h hVar, q qVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, j jVar, boolean z3, boolean z4, boolean z5, boolean z6, io.intercom.com.bumptech.glide.f.h hVar2) {
        boolean z7 = z3;
        io.intercom.com.bumptech.glide.f.h hVar3 = hVar2;
        io.intercom.com.bumptech.glide.h.j.b();
        long a2 = io.intercom.com.bumptech.glide.h.d.a();
        w a3 = this.f9939b.a(obj, gVar, i2, i3, map, cls, cls2, jVar);
        y a4 = a((g) a3, z7);
        String str = "Engine";
        if (a4 != null) {
            hVar3.a(a4, io.intercom.com.bumptech.glide.load.a.MEMORY_CACHE);
            if (Log.isLoggable(str, 2)) {
                a("Loaded resource from active resources", a2, (g) a3);
            }
            return null;
        }
        y b2 = b(a3, z7);
        if (b2 != null) {
            hVar3.a(b2, io.intercom.com.bumptech.glide.load.a.MEMORY_CACHE);
            if (Log.isLoggable(str, 2)) {
                a("Loaded resource from cache", a2, (g) a3);
            }
            return null;
        }
        u a5 = this.f9938a.a((g) a3, z6);
        if (a5 != null) {
            a5.a(hVar3);
            if (Log.isLoggable(str, 2)) {
                a("Added to existing load", a2, (g) a3);
            }
            return new d(hVar3, a5);
        }
        u a6 = this.f9941d.a(a3, z3, z4, z5, z6);
        String str2 = str;
        j a7 = this.f9944g.a(eVar, obj, a3, gVar, i2, i3, cls, cls2, hVar, qVar, map, z, z2, z6, jVar, a6);
        this.f9938a.a((g) a3, a6);
        a6.a(hVar3);
        a6.b(a7);
        if (Log.isLoggable(str2, 2)) {
            a("Started new load", a2, (g) a3);
        }
        return new d(hVar3, a6);
    }

    s(i iVar, C0112a aVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar2, io.intercom.com.bumptech.glide.load.engine.c.b bVar3, io.intercom.com.bumptech.glide.load.engine.c.b bVar4, A a2, x xVar, C0744c cVar, b bVar5, a aVar2, H h2, boolean z) {
        this.f9940c = iVar;
        C0112a aVar3 = aVar;
        this.f9943f = new c(aVar);
        C0744c cVar2 = cVar == null ? new C0744c(z) : cVar;
        this.f9945h = cVar2;
        cVar2.a((a) this);
        this.f9939b = xVar == null ? new x() : xVar;
        this.f9938a = a2 == null ? new A() : a2;
        this.f9941d = bVar5 == null ? new b(bVar, bVar2, bVar3, bVar4, this) : bVar5;
        this.f9944g = aVar2 == null ? new a(this.f9943f) : aVar2;
        this.f9942e = h2 == null ? new H() : h2;
        iVar.a((io.intercom.com.bumptech.glide.load.engine.b.i.a) this);
    }

    public void b(E<?> e2) {
        io.intercom.com.bumptech.glide.h.j.b();
        if (e2 instanceof y) {
            ((y) e2).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    private static void a(String str, long j2, g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(io.intercom.com.bumptech.glide.h.d.a(j2));
        sb.append("ms, key: ");
        sb.append(gVar);
        Log.v("Engine", sb.toString());
    }

    private y<?> a(g gVar, boolean z) {
        if (!z) {
            return null;
        }
        y<?> b2 = this.f9945h.b(gVar);
        if (b2 != null) {
            b2.d();
        }
        return b2;
    }

    private y<?> a(g gVar) {
        E a2 = this.f9940c.a(gVar);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof y) {
            return (y) a2;
        }
        return new y(a2, true, true);
    }

    public void a(u<?> uVar, g gVar, y<?> yVar) {
        io.intercom.com.bumptech.glide.h.j.b();
        if (yVar != null) {
            yVar.a(gVar, this);
            if (yVar.f()) {
                this.f9945h.a(gVar, yVar);
            }
        }
        this.f9938a.b(gVar, uVar);
    }

    public void a(u<?> uVar, g gVar) {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f9938a.b(gVar, uVar);
    }

    public void a(E<?> e2) {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f9942e.a(e2);
    }

    public void a(g gVar, y<?> yVar) {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f9945h.a(gVar);
        if (yVar.f()) {
            this.f9940c.a(gVar, yVar);
        } else {
            this.f9942e.a(yVar);
        }
    }
}
