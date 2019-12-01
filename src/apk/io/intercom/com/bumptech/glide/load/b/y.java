package io.intercom.com.bumptech.glide.load.b;

import b.g.h.d;
import io.intercom.com.bumptech.glide.Registry.NoModelLoaderAvailableException;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MultiModelLoaderFactory */
public class y {

    /* renamed from: a reason: collision with root package name */
    private static final c f9559a = new c();

    /* renamed from: b reason: collision with root package name */
    private static final u<Object, Object> f9560b = new a();

    /* renamed from: c reason: collision with root package name */
    private final List<b<?, ?>> f9561c;

    /* renamed from: d reason: collision with root package name */
    private final c f9562d;

    /* renamed from: e reason: collision with root package name */
    private final Set<b<?, ?>> f9563e;

    /* renamed from: f reason: collision with root package name */
    private final d<List<Throwable>> f9564f;

    /* compiled from: MultiModelLoaderFactory */
    private static class a implements u<Object, Object> {
        a() {
        }

        public io.intercom.com.bumptech.glide.load.b.u.a<Object> a(Object obj, int i2, int i3, j jVar) {
            return null;
        }

        public boolean a(Object obj) {
            return false;
        }
    }

    /* compiled from: MultiModelLoaderFactory */
    private static class b<Model, Data> {

        /* renamed from: a reason: collision with root package name */
        private final Class<Model> f9565a;

        /* renamed from: b reason: collision with root package name */
        final Class<Data> f9566b;

        /* renamed from: c reason: collision with root package name */
        final v<? extends Model, ? extends Data> f9567c;

        public b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
            this.f9565a = cls;
            this.f9566b = cls2;
            this.f9567c = vVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f9566b.isAssignableFrom(cls2);
        }

        public boolean a(Class<?> cls) {
            return this.f9565a.isAssignableFrom(cls);
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
        this(dVar, f9559a);
    }

    /* access modifiers changed from: 0000 */
    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        a(cls, cls2, vVar, true);
    }

    /* access modifiers changed from: 0000 */
    public synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.f9561c) {
            if (!arrayList.contains(bVar.f9566b) && bVar.a(cls)) {
                arrayList.add(bVar.f9566b);
            }
        }
        return arrayList;
    }

    y(d<List<Throwable>> dVar, c cVar) {
        this.f9561c = new ArrayList();
        this.f9563e = new HashSet();
        this.f9564f = dVar;
        this.f9562d = cVar;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar, boolean z) {
        b bVar = new b(cls, cls2, vVar);
        List<b<?, ?>> list = this.f9561c;
        list.add(z ? list.size() : 0, bVar);
    }

    /* access modifiers changed from: 0000 */
    public synchronized <Model> List<u<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.f9561c) {
                if (!this.f9563e.contains(bVar)) {
                    if (bVar.a(cls)) {
                        this.f9563e.add(bVar);
                        arrayList.add(a(bVar));
                        this.f9563e.remove(bVar);
                    }
                }
            }
        } catch (Throwable th) {
            this.f9563e.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized <Model, Data> u<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b bVar : this.f9561c) {
                if (this.f9563e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f9563e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f9563e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f9562d.a(arrayList, this.f9564f);
            } else if (arrayList.size() == 1) {
                return (u) arrayList.get(0);
            } else if (z) {
                return a();
            } else {
                throw new NoModelLoaderAvailableException(cls, cls2);
            }
        } catch (Throwable th) {
            this.f9563e.clear();
            throw th;
        }
    }

    private <Model, Data> u<Model, Data> a(b<?, ?> bVar) {
        u<Model, Data> a2 = bVar.f9567c.a(this);
        h.a(a2);
        return a2;
    }

    private static <Model, Data> u<Model, Data> a() {
        return f9560b;
    }
}
