package io.intercom.com.bumptech.glide.h.a;

import android.util.Log;
import b.g.h.e;
import b.g.h.f;
import java.util.List;

/* compiled from: FactoryPools */
public final class d {

    /* renamed from: a reason: collision with root package name */
    private static final C0105d<Object> f9386a = new a();

    /* compiled from: FactoryPools */
    public interface a<T> {
        T create();
    }

    /* compiled from: FactoryPools */
    private static final class b<T> implements b.g.h.d<T> {

        /* renamed from: a reason: collision with root package name */
        private final a<T> f9387a;

        /* renamed from: b reason: collision with root package name */
        private final C0105d<T> f9388b;

        /* renamed from: c reason: collision with root package name */
        private final b.g.h.d<T> f9389c;

        b(b.g.h.d<T> dVar, a<T> aVar, C0105d<T> dVar2) {
            this.f9389c = dVar;
            this.f9387a = aVar;
            this.f9388b = dVar2;
        }

        public T a() {
            T a2 = this.f9389c.a();
            if (a2 == null) {
                a2 = this.f9387a.create();
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
            this.f9388b.a(t);
            return this.f9389c.a(t);
        }
    }

    /* compiled from: FactoryPools */
    public interface c {
        f d();
    }

    /* renamed from: io.intercom.com.bumptech.glide.h.a.d$d reason: collision with other inner class name */
    /* compiled from: FactoryPools */
    public interface C0105d<T> {
        void a(T t);
    }

    public static <T extends c> b.g.h.d<T> a(int i2, a<T> aVar) {
        return a((b.g.h.d<T>) new e<T>(i2), aVar);
    }

    public static <T extends c> b.g.h.d<T> b(int i2, a<T> aVar) {
        return a((b.g.h.d<T>) new f<T>(i2), aVar);
    }

    public static <T> b.g.h.d<List<T>> a() {
        return a(20);
    }

    private static <T> C0105d<T> b() {
        return f9386a;
    }

    public static <T> b.g.h.d<List<T>> a(int i2) {
        return a(new f(i2), new b(), new c());
    }

    private static <T extends c> b.g.h.d<T> a(b.g.h.d<T> dVar, a<T> aVar) {
        return a(dVar, aVar, b());
    }

    private static <T> b.g.h.d<T> a(b.g.h.d<T> dVar, a<T> aVar, C0105d<T> dVar2) {
        return new b(dVar, aVar, dVar2);
    }
}
