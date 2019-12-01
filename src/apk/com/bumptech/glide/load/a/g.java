package com.bumptech.glide.load.a;

import com.bumptech.glide.h.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DataRewinderRegistry */
public class g {

    /* renamed from: a reason: collision with root package name */
    private static final com.bumptech.glide.load.a.e.a<?> f3577a = new f();

    /* renamed from: b reason: collision with root package name */
    private final Map<Class<?>, com.bumptech.glide.load.a.e.a<?>> f3578b = new HashMap();

    /* compiled from: DataRewinderRegistry */
    private static final class a implements e<Object> {

        /* renamed from: a reason: collision with root package name */
        private final Object f3579a;

        a(Object obj) {
            this.f3579a = obj;
        }

        public Object a() {
            return this.f3579a;
        }

        public void b() {
        }
    }

    public synchronized void a(com.bumptech.glide.load.a.e.a<?> aVar) {
        this.f3578b.put(aVar.a(), aVar);
    }

    public synchronized <T> e<T> a(T t) {
        com.bumptech.glide.load.a.e.a aVar;
        l.a(t);
        aVar = (com.bumptech.glide.load.a.e.a) this.f3578b.get(t.getClass());
        if (aVar == null) {
            Iterator it = this.f3578b.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bumptech.glide.load.a.e.a aVar2 = (com.bumptech.glide.load.a.e.a) it.next();
                if (aVar2.a().isAssignableFrom(t.getClass())) {
                    aVar = aVar2;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f3577a;
        }
        return aVar.a(t);
    }
}
