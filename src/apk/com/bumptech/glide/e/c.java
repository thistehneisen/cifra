package com.bumptech.glide.e;

import b.d.b;
import com.bumptech.glide.h.k;
import com.bumptech.glide.load.c.f.g;
import com.bumptech.glide.load.engine.D;
import com.bumptech.glide.load.engine.m;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache */
public class c {

    /* renamed from: a reason: collision with root package name */
    private static final D<?, ?, ?> f3405a;

    /* renamed from: b reason: collision with root package name */
    private final b<k, D<?, ?, ?>> f3406b = new b<>();

    /* renamed from: c reason: collision with root package name */
    private final AtomicReference<k> f3407c = new AtomicReference<>();

    static {
        m mVar = new m(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null);
        D d2 = new D(Object.class, Object.class, Object.class, Collections.singletonList(mVar), null);
        f3405a = d2;
    }

    private k b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        k kVar = (k) this.f3407c.getAndSet(null);
        if (kVar == null) {
            kVar = new k();
        }
        kVar.a(cls, cls2, cls3);
        return kVar;
    }

    public boolean a(D<?, ?, ?> d2) {
        return f3405a.equals(d2);
    }

    public <Data, TResource, Transcode> D<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        D<Data, TResource, Transcode> d2;
        k b2 = b(cls, cls2, cls3);
        synchronized (this.f3406b) {
            d2 = (D) this.f3406b.get(b2);
        }
        this.f3407c.set(b2);
        return d2;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, D<?, ?, ?> d2) {
        synchronized (this.f3406b) {
            b<k, D<?, ?, ?>> bVar = this.f3406b;
            k kVar = new k(cls, cls2, cls3);
            if (d2 == null) {
                d2 = f3405a;
            }
            bVar.put(kVar, d2);
        }
    }
}
