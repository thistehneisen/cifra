package com.bumptech.glide.load.b;

import b.g.h.d;
import com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import com.bumptech.glide.h.l;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory */
public class y {

    /* renamed from: a reason: collision with root package name */
    private static final c f3690a = new c();

    /* renamed from: b reason: collision with root package name */
    private static final u<Object, Object> f3691b = new a();

    /* renamed from: c reason: collision with root package name */
    private final List<b<?, ?>> f3692c;

    /* renamed from: d reason: collision with root package name */
    private final c f3693d;

    /* renamed from: e reason: collision with root package name */
    private final Set<b<?, ?>> f3694e;

    /* renamed from: f reason: collision with root package name */
    private final d<List<Throwable>> f3695f;

    /* compiled from: MultiModelLoaderFactory */
    private static class a implements u<Object, Object> {
        a() {
        }

        public com.bumptech.glide.load.b.u.a<Object> a(Object obj, int i2, int i3, i iVar) {
            return null;
        }

        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    private static class b<Model, Data> {

        /* renamed from: a reason: collision with root package name */
        private final Class<Model> f3696a;

        /* renamed from: b reason: collision with root package name */
        final Class<Data> f3697b;

        /* renamed from: c reason: collision with root package name */
        final v<? extends Model, ? extends Data> f3698c;

        public b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
            this.f3696a = cls;
            this.f3697b = cls2;
            this.f3698c = vVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f3697b.isAssignableFrom(cls2);
        }

        public boolean a(Class<?> cls) {
            return this.f3696a.isAssignableFrom(cls);
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    static class c {
        c() {
        }

        public <Model, Data> x<Model, Data> a(List<u<Model, Data>> list, d<List<Throwable>> dVar) {
            return new x<>(list, dVar);
        }
    }

    public y(d<List<Throwable>> dVar) {
        this(dVar, f3690a);
    }

    /* access modifiers changed from: 0000 */
    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        a(cls, cls2, vVar, true);
    }

    /* access modifiers changed from: 0000 */
    public synchronized <Model, Data> List<v<? extends Model, ? extends Data>> b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        List<v<? extends Model, ? extends Data>> b2;
        b2 = b(cls, cls2);
        a(cls, cls2, vVar);
        return b2;
    }

    y(d<List<Throwable>> dVar, c cVar) {
        this.f3692c = new ArrayList();
        this.f3694e = new HashSet();
        this.f3695f = dVar;
        this.f3693d = cVar;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar, boolean z) {
        b bVar = new b(cls, cls2, vVar);
        List<b<?, ?>> list = this.f3692c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* access modifiers changed from: 0000 */
    public synchronized <Model, Data> List<v<? extends Model, ? extends Data>> b(Class<Model> cls, Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator it = this.f3692c.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.a(cls, cls2)) {
                it.remove();
                arrayList.add(b(bVar));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public synchronized <Model> List<u<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.f3692c) {
                if (!this.f3694e.contains(bVar)) {
                    if (bVar.a(cls)) {
                        this.f3694e.add(bVar);
                        arrayList.add(a(bVar));
                        this.f3694e.remove(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            this.f3694e.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.f3692c) {
            if (!arrayList.contains(bVar.f3697b) && bVar.a(cls)) {
                arrayList.add(bVar.f3697b);
            }
        }
        return arrayList;
    }

    public synchronized <Model, Data> u<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b bVar : this.f3692c) {
                if (this.f3694e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f3694e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f3694e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f3693d.a(arrayList, this.f3695f);
            } else if (arrayList.size() == 1) {
                return (u) arrayList.get(0);
            } else if (z) {
                return a();
            } else {
                throw new NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f3694e.clear();
            throw th;
        }
    }

    private <Model, Data> v<Model, Data> b(b<?, ?> bVar) {
        return bVar.f3698c;
    }

    private <Model, Data> u<Model, Data> a(b<?, ?> bVar) {
        u<Model, Data> a2 = bVar.f3698c.a(this);
        l.a(a2);
        return a2;
    }

    private static <Model, Data> u<Model, Data> a() {
        return f3691b;
    }
}
