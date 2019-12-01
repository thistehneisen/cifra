package io.intercom.com.bumptech.glide.e;

import b.d.b;
import io.intercom.com.bumptech.glide.h.g;
import io.intercom.com.bumptech.glide.load.engine.B;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LoadPathCache */
public class c {

    /* renamed from: a reason: collision with root package name */
    private final b<g, B<?, ?, ?>> f9282a = new b<>();

    /* renamed from: b reason: collision with root package name */
    private final AtomicReference<g> f9283b = new AtomicReference<>();

    private g c(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        g gVar = (g) this.f9283b.getAndSet(null);
        if (gVar == null) {
            gVar = new g();
        }
        gVar.a(cls, cls2, cls3);
        return gVar;
    }

    public boolean a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        boolean containsKey;
        g c2 = c(cls, cls2, cls3);
        synchronized (this.f9282a) {
            containsKey = this.f9282a.containsKey(c2);
        }
        this.f9283b.set(c2);
        return containsKey;
    }

    public <Data, TResource, Transcode> B<Data, TResource, Transcode> b(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        B<Data, TResource, Transcode> b2;
        g c2 = c(cls, cls2, cls3);
        synchronized (this.f9282a) {
            b2 = (B) this.f9282a.get(c2);
        }
        this.f9283b.set(c2);
        return b2;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, B<?, ?, ?> b2) {
        synchronized (this.f9282a) {
            this.f9282a.put(new g(cls, cls2, cls3), b2);
        }
    }
}
