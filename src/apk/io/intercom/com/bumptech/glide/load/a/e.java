package io.intercom.com.bumptech.glide.load.a;

import io.intercom.com.bumptech.glide.h.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry */
public class e {

    /* renamed from: a reason: collision with root package name */
    private static final io.intercom.com.bumptech.glide.load.a.c.a<?> f9447a = new d();

    /* renamed from: b reason: collision with root package name */
    private final Map<Class<?>, io.intercom.com.bumptech.glide.load.a.c.a<?>> f9448b = new HashMap();

    /* compiled from: DataRewinderRegistry */
    private static final class a implements c<Object> {

        /* renamed from: a reason: collision with root package name */
        private final Object f9449a;

        a(Object obj) {
            this.f9449a = obj;
        }

        public Object a() {
            return this.f9449a;
        }

        public void b() {
        }
    }

    public synchronized void a(io.intercom.com.bumptech.glide.load.a.c.a<?> aVar) {
        this.f9448b.put(aVar.a(), aVar);
    }

    public synchronized <T> c<T> a(T t) {
        io.intercom.com.bumptech.glide.load.a.c.a aVar;
        h.a(t);
        aVar = (io.intercom.com.bumptech.glide.load.a.c.a) this.f9448b.get(t.getClass());
        if (aVar == null) {
            Iterator it = this.f9448b.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                io.intercom.com.bumptech.glide.load.a.c.a aVar2 = (io.intercom.com.bumptech.glide.load.a.c.a) it.next();
                if (aVar2.a().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f9447a;
        }
        return aVar.a(t);
    }
}
