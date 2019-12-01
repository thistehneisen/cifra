package com.touchin.vtb.c.a;

import com.touchin.vtb.api.A;
import d.a.c;
import d.a.e;
import f.a.a;
import retrofit2.w;

/* compiled from: NetworkModule_ProvideUserApiFactory */
public final class q implements c<A> {

    /* renamed from: a reason: collision with root package name */
    private final i f7223a;

    /* renamed from: b reason: collision with root package name */
    private final a<w> f7224b;

    public q(i iVar, a<w> aVar) {
        this.f7223a = iVar;
        this.f7224b = aVar;
    }

    public static q a(i iVar, a<w> aVar) {
        return new q(iVar, aVar);
    }

    public static A b(i iVar, a<w> aVar) {
        return a(iVar, (w) aVar.get());
    }

    public static A a(i iVar, w wVar) {
        A e2 = iVar.e(wVar);
        e.a(e2, "Cannot return null from a non-@Nullable @Provides method");
        return e2;
    }

    public A get() {
        return b(this.f7223a, this.f7224b);
    }
}
