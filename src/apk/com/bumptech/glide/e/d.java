package com.bumptech.glide.e;

import b.d.b;
import com.bumptech.glide.h.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache */
public class d {

    /* renamed from: a reason: collision with root package name */
    private final AtomicReference<k> f3408a = new AtomicReference<>();

    /* renamed from: b reason: collision with root package name */
    private final b<k, List<Class<?>>> f3409b = new b<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        k kVar = (k) this.f3408a.getAndSet(null);
        if (kVar == null) {
            kVar = new k(cls, cls2, cls3);
        } else {
            kVar.a(cls, cls2, cls3);
        }
        synchronized (this.f3409b) {
            list = (List) this.f3409b.get(kVar);
        }
        this.f3408a.set(kVar);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f3409b) {
            this.f3409b.put(new k(cls, cls2, cls3), list);
        }
    }
}
