package io.intercom.com.bumptech.glide.load.b;

import b.g.h.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry */
public class w {

    /* renamed from: a reason: collision with root package name */
    private final y f9547a;

    /* renamed from: b reason: collision with root package name */
    private final a f9548b;

    /* compiled from: ModelLoaderRegistry */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        private final Map<Class<?>, C0109a<?>> f9549a = new HashMap();

        /* renamed from: io.intercom.com.bumptech.glide.load.b.w$a$a reason: collision with other inner class name */
        /* compiled from: ModelLoaderRegistry */
        private static class C0109a<Model> {

            /* renamed from: a reason: collision with root package name */
            final List<u<Model, ?>> f9550a;

            public C0109a(List<u<Model, ?>> list) {
                this.f9550a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f9549a.clear();
        }

        public <Model> void a(Class<Model> cls, List<u<Model, ?>> list) {
            if (((C0109a) this.f9549a.put(cls, new C0109a(list))) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Already cached loaders for model: ");
                sb.append(cls);
                throw new IllegalStateException(sb.toString());
            }
        }

        public <Model> List<u<Model, ?>> a(Class<Model> cls) {
            C0109a aVar = (C0109a) this.f9549a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f9550a;
        }
    }

    public w(d<List<Throwable>> dVar) {
        this(new y(dVar));
    }

    private <A> List<u<A, ?>> b(Class<A> cls) {
        List<u<A, ?>> a2 = this.f9548b.a(cls);
        if (a2 != null) {
            return a2;
        }
        List<u<A, ?>> unmodifiableList = Collections.unmodifiableList(this.f9547a.a(cls));
        this.f9548b.a(cls, unmodifiableList);
        return unmodifiableList;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        this.f9547a.a(cls, cls2, vVar);
        this.f9548b.a();
    }

    private w(y yVar) {
        this.f9548b = new a();
        this.f9547a = yVar;
    }

    private static <A> Class<A> b(A a2) {
        return a2.getClass();
    }

    public synchronized <A> List<u<A, ?>> a(A a2) {
        ArrayList arrayList;
        List b2 = b(b(a2));
        int size = b2.size();
        arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            u uVar = (u) b2.get(i2);
            if (uVar.a(a2)) {
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f9547a.b(cls);
    }
}
