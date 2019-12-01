package com.bumptech.glide.h.a;

import android.util.Log;
import b.g.h.f;
import java.util.List;

/* compiled from: FactoryPools */
public final class d {

    /* renamed from: a reason: collision with root package name */
    private static final C0049d<Object> f3509a = new a();

    /* compiled from: FactoryPools */
    public interface a<T> {
        T create();
    }

    /* compiled from: FactoryPools */
    private static final class b<T> implements b.g.h.d<T> {

        /* renamed from: a reason: collision with root package name */
        private final a<T> f3510a;

        /* renamed from: b reason: collision with root package name */
        private final C0049d<T> f3511b;

        /* renamed from: c reason: collision with root package name */
        private final b.g.h.d<T> f3512c;

        b(b.g.h.d<T> dVar, a<T> aVar, C0049d<T> dVar2) {
            this.f3512c = dVar;
            this.f3510a = aVar;
            this.f3511b = dVar2;
        }

        public T a() {
            T a2 = this.f3512c.a();
            if (a2 == null) {
                a2 = this.f3510a.create();
                String str = "FactoryPools";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Created new ");
                    sb.append(a2.getClass());
                    Log.v(str, sb.toString());
                }
            }
            if (a2 instanceof c) {
                ((c) a2).d().a(false);
            }
            return a2;
        }

        public boolean a(T t) {
            if (t instanceof c) {
                ((c) t).d().a(true);
            }
            this.f3511b.a(t);
            return this.f3512c.a(t);
        }
    }

    /* compiled from: FactoryPools */
    public interface c {
        g d();
    }

    /* renamed from: com.bumptech.glide.h.a.d$d reason: collision with other inner class name */
    /* compiled from: FactoryPools */
    public interface C0049d<T> {
        void a(T t);
    }

    public static <T extends c> b.g.h.d<T> a(int i2, a<T> aVar) {
        return a((b.g.h.d<T>) new f<T>(i2), aVar);
    }

    private static <T> C0049d<T> b() {
        return f3509a;
    }

    public static <T> b.g.h.d<List<T>> a() {
        return a(20);
    }

    public static <T> b.g.h.d<List<T>> a(int i2) {
        return a(new f(i2), new b(), new c());
    }

    private static <T extends c> b.g.h.d<T> a(b.g.h.d<T> dVar, a<T> aVar) {
        return a(dVar, aVar, b());
    }

    private static <T> b.g.h.d<T> a(b.g.h.d<T> dVar, a<T> aVar, C0049d<T> dVar2) {
        return new b(dVar, aVar, dVar2);
    }
}
