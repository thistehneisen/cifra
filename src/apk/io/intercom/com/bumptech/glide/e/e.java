package io.intercom.com.bumptech.glide.e;

import io.intercom.com.bumptech.glide.load.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ResourceDecoderRegistry */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final List<String> f9286a = new ArrayList();

    /* renamed from: b reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f9287b = new HashMap();

    /* compiled from: ResourceDecoderRegistry */
    private static class a<T, R> {

        /* renamed from: a reason: collision with root package name */
        private final Class<T> f9288a;

        /* renamed from: b reason: collision with root package name */
        final Class<R> f9289b;

        /* renamed from: c reason: collision with root package name */
        final k<T, R> f9290c;

        public a(Class<T> cls, Class<R> cls2, k<T, R> kVar) {
            this.f9288a = cls;
            this.f9289b = cls2;
            this.f9290c = kVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f9288a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f9289b);
        }
    }

    public synchronized void a(List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.f9286a);
        this.f9286a.clear();
        this.f9286a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f9286a.add(str);
            }
        }
    }

    public synchronized <T, R> List<Class<R>> b(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f9286a) {
            List<a> list = (List) this.f9287b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f9289b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> List<k<T, R>> a(Class<T> cls, Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f9286a) {
            List<a> list = (List) this.f9287b.get(str);
            if (list != null) {
                for (a aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f9290c);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void a(String str, k<T, R> kVar, Class<T> cls, Class<R> cls2) {
        a(str).add(new a(cls, cls2, kVar));
    }

    private synchronized List<a<?, ?>> a(String str) {
        List<a<?, ?>> list;
        if (!this.f9286a.contains(str)) {
            this.f9286a.add(str);
        }
        list = (List) this.f9287b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f9287b.put(str, list);
        }
        return list;
    }
}
