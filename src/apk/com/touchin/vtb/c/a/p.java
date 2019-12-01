package com.touchin.vtb.c.a;

import com.touchin.vtb.api.y;
import d.a.c;
import d.a.e;
import f.a.a;
import retrofit2.w;

/* compiled from: NetworkModule_ProvideTaxesApiFactory */
public final class p implements c<y> {

    /* renamed from: a reason: collision with root package name */
    private final i f7221a;

    /* renamed from: b reason: collision with root package name */
    private final a<w> f7222b;

    public p(i iVar, a<w> aVar) {
        this.f7221a = iVar;
        this.f7222b = aVar;
    }

    public static p a(i iVar, a<w> aVar) {
        return new p(iVar, aVar);
    }

    public static y b(i iVar, a<w> aVar) {
        return a(iVar, (w) aVar.get());
    }

    public static y a(i iVar, w wVar) {
        y d2 = iVar.d(wVar);
        e.a(d2, "Cannot return null from a non-@Nullable @Provides method");
        return d2;
    }

    public y get() {
        return b(this.f7221a, this.f7222b);
    }
}
