package com.bumptech.glide.load.b;

import b.g.h.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ModelLoaderRegistry */
public class w {

    /* renamed from: a reason: collision with root package name */
    private final y f3677a;

    /* renamed from: b reason: collision with root package name */
    private final a f3678b;

    /* compiled from: ModelLoaderRegistry */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        private final Map<Class<?>, C0053a<?>> f3679a = new HashMap();

        /* renamed from: com.bumptech.glide.load.b.w$a$a reason: collision with other inner class name */
        /* compiled from: ModelLoaderRegistry */
        private static class C0053a<Model> {

            /* renamed from: a reason: collision with root package name */
            final List<u<Model, ?>> f3680a;

            public C0053a(List<u<Model, ?>> list) {
                this.f3680a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f3679a.clear();
        }

        public <Model> void a(Class<Model> cls, List<u<Model, ?>> list) {
            if (((C0053a) this.f3679a.put(cls, new C0053a(list))) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Already cached loaders for model: ");
                sb.append(cls);
                throw new IllegalStateException(sb.toString());
            }
        }

        public <Model> List<u<Model, ?>> a(Class<Model> cls) {
            C0053a aVar = (C0053a) this.f3679a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f3680a;
        }
    }

    public w(d<List<Throwable>> dVar) {
        this(new y(dVar));
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        this.f3677a.a(cls, cls2, vVar);
        this.f3678b.a();
    }

    public synchronized <Model, Data> void b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        a(this.f3677a.b(cls, cls2, vVar));
        this.f3678b.a();
    }

    private w(y yVar) {
        this.f3678b = new a();
        this.f3677a = yVar;
    }

    private <Model, Data> void a(List<v<? extends Model, ? extends Data>> list) {
        for (v a2 : list) {
            a2.a();
        }
    }

    private synchronized <A> List<u<A, ?>> b(Class<A> cls) {
        List<u<A, ?>> a2;
        a2 = this.f3678b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f3677a.a(cls));
            this.f3678b.a(cls, a2);
        }
        return a2;
    }

    public <A> List<u<A, ?>> a(A a2) {
        List b2 = b(b(a2));
        int size = b2.size();
        List emptyList = Collections.emptyList();
        boolean z = true;
        for (int i2 = 0; i2 < size; i2++) {
            u uVar = (u) b2.get(i2);
            if (uVar.a(a2)) {
                if (z) {
                    emptyList = new ArrayList(size - i2);
                    z = false;
                }
                emptyList.add(uVar);
            }
        }
        return emptyList;
    }

    private static <A> Class<A> b(A a2) {
        return a2.getClass();
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f3677a.b(cls);
    }
}
