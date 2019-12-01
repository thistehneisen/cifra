package io.intercom.com.google.gson.b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class D extends G {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Method f10023a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10024b;

    D(Method method, int i2) {
        this.f10023a = method;
        this.f10024b = i2;
    }

    public <T> T b(Class<T> cls) throws Exception {
        G.a(cls);
        return this.f10023a.invoke(null, new Object[]{cls, Integer.valueOf(this.f10024b)});
    }
}
