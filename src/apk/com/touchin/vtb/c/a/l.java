package com.touchin.vtb.c.a;

import d.a.c;
import d.a.e;
import f.a.a;
import i.G;
import retrofit2.w;

/* compiled from: NetworkModule_ProvideDaDataRetrofitFactory */
public final class l implements c<w> {

    /* renamed from: a reason: collision with root package name */
    private final i f7212a;

    /* renamed from: b reason: collision with root package name */
    private final a<G> f7213b;

    public l(i iVar, a<G> aVar) {
        this.f7212a = iVar;
        this.f7213b = aVar;
    }

    public static l a(i iVar, a<G> aVar) {
        return new l(iVar, aVar);
    }

    public static w b(i iVar, a<G> aVar) {
        return a(iVar, (G) aVar.get());
    }

    public static w a(i iVar, G g2) {
        w a2 = iVar.a(g2);
        e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public w get() {
        return b(this.f7212a, this.f7213b);
    }
}
