package com.bumptech.glide.e;

import com.bumptech.glide.load.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final List<String> f3410a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f3411b = new HashMap();

    /* compiled from: ResourceDecoderRegistry */
    private static class a<T, R> {

        /* renamed from: a reason: collision with root package name */
        private final Class<T> f3412a;

        /* renamed from: b reason: collision with root package name */
        final Class<R> f3413b;

        /* renamed from: c reason: collision with root package name */
        final j<T, R> f3414c;

        public a(Class<T> cls, Class<R> cls2, j<T, R> jVar) {
            this.f3412a = cls;
            this.f3413b = cls2;
            this.f3414c = jVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f3412a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f3413b);
        }
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f3410a);
        this.f3410a.clear();
        this.f3410a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f3410a.add(str);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f3410a) {
            List<a> list = (List) this.f3411b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f3413b)) {
                        arrayList.add(aVar.f3413b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<j<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f3410a) {
            List<a> list = (List) this.f3411b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f3414c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, j<T, R> jVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a(cls, cls2, jVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f3410a.contains(str)) {
            this.f3410a.add(str);
        }
        list = (List) this.f3411b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f3411b.put(str, list);
        }
        return list;
    }
}
