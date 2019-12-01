package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import io.intercom.com.bumptech.glide.Registry.NoSourceEncoderAvailableException;
import io.intercom.com.bumptech.glide.e;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.b.u.a;
import io.intercom.com.bumptech.glide.load.d;
import io.intercom.com.bumptech.glide.load.engine.a.b;
import io.intercom.com.bumptech.glide.load.g;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.l;
import io.intercom.com.bumptech.glide.load.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.h reason: case insensitive filesystem */
/* compiled from: DecodeHelper */
final class C0749h<Transcode> {

    /* renamed from: a reason: collision with root package name */
    private final List<a<?>> f9882a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    private final List<g> f9883b = new ArrayList();

    /* renamed from: c reason: collision with root package name */
    private e f9884c;

    /* renamed from: d reason: collision with root package name */
    private Object f9885d;

    /* renamed from: e reason: collision with root package name */
    private int f9886e;

    /* renamed from: f reason: collision with root package name */
    private int f9887f;

    /* renamed from: g reason: collision with root package name */
    private Class<?> f9888g;

    /* renamed from: h reason: collision with root package name */
    private d f9889h;

    /* renamed from: i reason: collision with root package name */
    private j f9890i;

    /* renamed from: j reason: collision with root package name */
    private Map<Class<?>, m<?>> f9891j;

    /* renamed from: k reason: collision with root package name */
    private Class<Transcode> f9892k;

    /* renamed from: l reason: collision with root package name */
    private boolean f9893l;
    private boolean m;
    private g n;
    private h o;
    private q p;
    private boolean q;
    private boolean r;

    C0749h() {
    }

    /* access modifiers changed from: 0000 */
    public <R> void a(e eVar, Object obj, g gVar, int i2, int i3, q qVar, Class<?> cls, Class<R> cls2, h hVar, j jVar, Map<Class<?>, m<?>> map, boolean z, boolean z2, d dVar) {
        this.f9884c = eVar;
        this.f9885d = obj;
        this.n = gVar;
        this.f9886e = i2;
        this.f9887f = i3;
        this.p = qVar;
        this.f9888g = cls;
        this.f9889h = dVar;
        this.f9892k = cls2;
        this.o = hVar;
        this.f9890i = jVar;
        this.f9891j = map;
        this.q = z;
        this.r = z2;
    }

    /* access modifiers changed from: 0000 */
    public b b() {
        return this.f9884c.a();
    }

    /* access modifiers changed from: 0000 */
    public boolean c(Class<?> cls) {
        return a(cls) != null;
    }

    /* access modifiers changed from: 0000 */
    public io.intercom.com.bumptech.glide.load.engine.b.a d() {
        return this.f9889h.a();
    }

    /* access modifiers changed from: 0000 */
    public q e() {
        return this.p;
    }

    /* access modifiers changed from: 0000 */
    public int f() {
        return this.f9887f;
    }

    /* access modifiers changed from: 0000 */
    public List<a<?>> g() {
        if (!this.f9893l) {
            this.f9893l = true;
            this.f9882a.clear();
            List a2 = this.f9884c.f().a(this.f9885d);
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a a3 = ((u) a2.get(i2)).a(this.f9885d, this.f9886e, this.f9887f, this.f9890i);
                if (a3 != null) {
                    this.f9882a.add(a3);
                }
            }
        }
        return this.f9882a;
    }

    /* access modifiers changed from: 0000 */
    public j h() {
        return this.f9890i;
    }

    /* access modifiers changed from: 0000 */
    public h i() {
        return this.o;
    }

    /* access modifiers changed from: 0000 */
    public List<Class<?>> j() {
        return this.f9884c.f().b(this.f9885d.getClass(), this.f9888g, this.f9892k);
    }

    /* access modifiers changed from: 0000 */
    public g k() {
        return this.n;
    }

    /* access modifiers changed from: 0000 */
    public int l() {
        return this.f9886e;
    }

    /* access modifiers changed from: 0000 */
    public boolean m() {
        return this.r;
    }

    /* access modifiers changed from: 0000 */
    public <Z> m<Z> b(Class<Z> cls) {
        m<Z> mVar = (m) this.f9891j.get(cls);
        if (mVar == null) {
            Iterator it = this.f9891j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    mVar = (m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.f9891j.isEmpty() || !this.q) {
            return io.intercom.com.bumptech.glide.load.c.b.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing transformation for ");
        sb.append(cls);
        sb.append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public List<g> c() {
        if (!this.m) {
            this.m = true;
            this.f9883b.clear();
            List g2 = g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = (a) g2.get(i2);
                if (!this.f9883b.contains(aVar.f9544a)) {
                    this.f9883b.add(aVar.f9544a);
                }
                for (int i3 = 0; i3 < aVar.f9545b.size(); i3++) {
                    if (!this.f9883b.contains(aVar.f9545b.get(i3))) {
                        this.f9883b.add(aVar.f9545b.get(i3));
                    }
                }
            }
        }
        return this.f9883b;
    }

    /* access modifiers changed from: 0000 */
    public boolean b(E<?> e2) {
        return this.f9884c.f().b(e2);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f9884c = null;
        this.f9885d = null;
        this.n = null;
        this.f9888g = null;
        this.f9892k = null;
        this.f9890i = null;
        this.o = null;
        this.f9891j = null;
        this.p = null;
        this.f9882a.clear();
        this.f9893l = false;
        this.f9883b.clear();
        this.m = false;
    }

    /* access modifiers changed from: 0000 */
    public <Data> B<Data, ?, Transcode> a(Class<Data> cls) {
        return this.f9884c.f().a(cls, this.f9888g, this.f9892k);
    }

    /* access modifiers changed from: 0000 */
    public <Z> l<Z> a(E<Z> e2) {
        return this.f9884c.f().a(e2);
    }

    /* access modifiers changed from: 0000 */
    public List<u<File, ?>> a(File file) throws NoModelLoaderAvailableException {
        return this.f9884c.f().a(file);
    }

    /* access modifiers changed from: 0000 */
    public boolean a(g gVar) {
        List g2 = g();
        int size = g2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((a) g2.get(i2)).f9544a.equals(gVar)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public <X> d<X> a(X x) throws NoSourceEncoderAvailableException {
        return this.f9884c.f().c(x);
    }
}
