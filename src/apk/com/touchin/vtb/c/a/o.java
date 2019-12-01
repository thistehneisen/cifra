package com.touchin.vtb.c.a;

import com.touchin.vtb.api.v;
import d.a.c;
import d.a.e;
import f.a.a;
import retrofit2.w;

/* compiled from: NetworkModule_ProvideTasksApiFactory */
public final class o implements c<v> {

    /* renamed from: a reason: collision with root package name */
    private final i f7219a;

    /* renamed from: b reason: collision with root package name */
    private final a<w> f7220b;

    public o(i iVar, a<w> aVar) {
        this.f7219a = iVar;
        this.f7220b = aVar;
    }

    public static o a(i iVar, a<w> aVar) {
        return new o(iVar, aVar);
    }

    public static v b(i iVar, a<w> aVar) {
        return a(iVar, (w) aVar.get());
    }

    public static v a(i iVar, w wVar) {
        v c2 = iVar.c(wVar);
        e.a(c2, "Cannot return null from a non-@Nullable @Provides method");
        return c2;
    }

    public v get() {
        return b(this.f7219a, this.f7220b);
    }
}
