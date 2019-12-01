package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.measurement.wc reason: case insensitive filesystem */
final class C0459wc {

    /* renamed from: a reason: collision with root package name */
    private static final C0459wc f5412a = new C0459wc();

    /* renamed from: b reason: collision with root package name */
    private final Ec f5413b = new _b();

    /* renamed from: c reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Ac<?>> f5414c = new ConcurrentHashMap();

    private C0459wc() {
    }

    public static C0459wc a() {
        return f5412a;
    }

    public final <T> Ac<T> a(Class<T> cls) {
        String str = "messageType";
        Fb.a(cls, str);
        Ac<T> ac = (Ac) this.f5414c.get(cls);
        if (ac != null) {
            return ac;
        }
        Ac<T> a2 = this.f5413b.a(cls);
        Fb.a(cls, str);
        Fb.a(a2, "schema");
        Ac ac2 = (Ac) this.f5414c.putIfAbsent(cls, a2);
        return ac2 != null ? ac2 : a2;
    }

    public final <T> Ac<T> a(T t) {
        return a(t.getClass());
    }
}
