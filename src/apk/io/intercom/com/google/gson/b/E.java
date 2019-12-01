package io.intercom.com.google.gson.b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class E extends G {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Method f10025a;

    E(Method method) {
        this.f10025a = method;
    }

    public <T> T b(Class<T> cls) throws Exception {
        G.a(cls);
        return this.f10025a.invoke(null, new Object[]{cls, Object.class});
    }
}
