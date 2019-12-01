package com.bumptech.glide.load.engine;

import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.Registry.NoSourceEncoderAvailableException;
import com.bumptech.glide.g;
import com.bumptech.glide.j;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.b.u.a;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.a.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.engine.j reason: case insensitive filesystem */
/* compiled from: DecodeHelper */
final class C0296j<Transcode> {

    /* renamed from: a reason: collision with root package name */
    private final List<a<?>> f4021a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    private final List<f> f4022b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private g f4023c;

    /* renamed from: d reason: collision with root package name */
    private Object f4024d;

    /* renamed from: e reason: collision with root package name */
    private int f4025e;

    /* renamed from: f reason: collision with root package name */
    private int f4026f;

    /* renamed from: g reason: collision with root package name */
    private Class<?> f4027g;

    /* renamed from: h reason: collision with root package name */
    private d f4028h;

    /* renamed from: i reason: collision with root package name */
    private i f4029i;

    /* renamed from: j reason: collision with root package name */
    private Map<Class<?>, l<?>> f4030j;

    /* renamed from: k reason: collision with root package name */
    private Class<Transcode> f4031k;

    /* renamed from: l reason: collision with root package name */
    private boolean f4032l;
    private boolean m;
    private f n;
    private j o;
    private s p;
    private boolean q;
    private boolean r;

    C0296j() {
    }

    /* access modifiers changed from: 0000 */
    public <R> void a(g gVar, Object obj, f fVar, int i2, int i3, s sVar, Class<?> cls, Class<R> cls2, j jVar, i iVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, d dVar) {
        this.f4023c = gVar;
        this.f4024d = obj;
        this.n = fVar;
        this.f4025e = i2;
        this.f4026f = i3;
        this.p = sVar;
        this.f4027g = cls;
        this.f4028h = dVar;
        this.f4031k = cls2;
        this.o = jVar;
        this.f4029i = iVar;
        this.f4030j = map;
        this.q = z;
        this.r = z2;
    }

    /* access modifiers changed from: 0000 */
    public b b() {
        return this.f4023c.a();
    }

    /* access modifiers changed from: 0000 */
    public boolean c(Class<?> cls) {
        return a(cls) != null;
    }

    /* access modifiers changed from: 0000 */
    public com.bumptech.glide.load.engine.b.a d() {
        return this.f4028h.a();
    }

    /* access modifiers changed from: 0000 */
    public s e() {
        return this.p;
    }

    /* access modifiers changed from: 0000 */
    public int f() {
        return this.f4026f;
    }

    /* access modifiers changed from: 0000 */
    public List<a<?>> g() {
        if (!this.f4032l) {
            this.f4032l = true;
            this.f4021a.clear();
            List a2 = this.f4023c.f().a(this.f4024d);
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a a3 = ((u) a2.get(i2)).a(this.f4024d, this.f4025e, this.f4026f, this.f4029i);
                if (a3 != null) {
                    this.f4021a.add(a3);
                }
            }
        }
        return this.f4021a;
    }

    /* access modifiers changed from: 0000 */
    public Class<?> h() {
        return this.f4024d.getClass();
    }

    /* access modifiers changed from: 0000 */
    public i i() {
        return this.f4029i;
    }

    /* access modifiers changed from: 0000 */
    public j j() {
        return this.o;
    }

    /* access modifiers changed from: 0000 */
    public List<Class<?>> k() {
        return this.f4023c.f().b(this.f4024d.getClass(), this.f4027g, this.f4031k);
    }

    /* access modifiers changed from: 0000 */
    public f l() {
        return this.n;
    }

    /* access modifiers changed from: 0000 */
    public Class<?> m() {
        return this.f4031k;
    }

    /* access modifiers changed from: 0000 */
    public int n() {
        return this.f4025e;
    }

    /* access modifiers changed from: 0000 */
    public boolean o() {
        return this.r;
    }

    /* access modifiers changed from: 0000 */
    public <Z> l<Z> b(Class<Z> cls) {
        l<Z> lVar = (l) this.f4030j.get(cls);
        if (lVar == null) {
            Iterator it = this.f4030j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f4030j.isEmpty() || !this.q) {
            return com.bumptech.glide.load.c.b.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing transformation for ");
        sb.append(cls);
        sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public List<f> c() {
        if (!this.m) {
            this.m = true;
            this.f4022b.clear();
            List g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) g2.get(i2);
                if (!this.f4022b.contains(aVar.f3674a)) {
                    this.f4022b.add(aVar.f3674a);
                }
                for (int i3 = 0; i3 < aVar.f3675b.size(); i3++) {
                    if (!this.f4022b.contains(aVar.f3675b.get(i3))) {
                        this.f4022b.add(aVar.f3675b.get(i3));
                    }
                }
            }
        }
        return this.f4022b;
    }

    /* access modifiers changed from: 0000 */
    public boolean b(G<?> g2) {
        return this.f4023c.f().b(g2);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f4023c = null;
        this.f4024d = null;
        this.n = null;
        this.f4027g = null;
        this.f4031k = null;
        this.f4029i = null;
        this.o = null;
        this.f4030j = null;
        this.p = null;
        this.f4021a.clear();
        this.f4032l = false;
        this.f4022b.clear();
        this.m = false;
    }

    /* access modifiers changed from: 0000 */
    public <Data> D<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f4023c.f().a(cls, this.f4027g, this.f4031k);
    }

    /* access modifiers changed from: 0000 */
    public <Z> k<Z> a(G<Z> g2) {
        return this.f4023c.f().a(g2);
    }

    /* access modifiers changed from: 0000 */
    public List<u<File, ?>> a(File file) throws NoModelLoaderAvailableException {
        return this.f4023c.f().a(file);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(f fVar) {
        List g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((a) g2.get(i2)).f3674a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public <X> d<X> a(X x) throws NoSourceEncoderAvailableException {
        return this.f4023c.f().c(x);
    }
}
