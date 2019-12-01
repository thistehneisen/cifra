package io.intercom.com.google.gson.b;

import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator */
class C extends G {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Method f10021a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Object f10022b;

    C(Method method, Object obj) {
        this.f10021a = method;
        this.f10022b = obj;
    }

    public <T> T b(Class<T> cls) throws Exception {
        G.a(cls);
        return this.f10021a.invoke(this.f10022b, new Object[]{cls});
    }
}
