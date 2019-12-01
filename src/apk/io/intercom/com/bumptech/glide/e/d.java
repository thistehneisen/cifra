package io.intercom.com.bumptech.glide.e;

import b.d.b;
import io.intercom.com.bumptech.glide.h.g;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ModelToResourceClassCache */
public class d {

    /* renamed from: a reason: collision with root package name */
    private final AtomicReference<g> f9284a = new AtomicReference<>();

    /* renamed from: b reason: collision with root package name */
    private final b<g, List<Class<?>>> f9285b = new b<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2) {
        List<Class<?>> list;
        g gVar = (g) this.f9284a.getAndSet(null);
        if (gVar == null) {
            gVar = new g(cls, cls2);
        } else {
            gVar.a(cls, cls2);
        }
        synchronized (this.f9285b) {
            list = (List) this.f9285b.get(gVar);
        }
        this.f9284a.set(gVar);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, List<Class<?>> list) {
        synchronized (this.f9285b) {
            this.f9285b.put(new g(cls, cls2), list);
        }
    }
}
