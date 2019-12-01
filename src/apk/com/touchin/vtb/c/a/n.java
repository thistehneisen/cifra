package com.touchin.vtb.c.a;

import com.touchin.vtb.api.d;
import d.a.c;
import d.a.e;
import f.a.a;
import i.G;
import retrofit2.w;

/* compiled from: NetworkModule_ProvidePublicRetrofitFactory */
public final class n implements c<w> {

    /* renamed from: a reason: collision with root package name */
    private final i f7216a;

    /* renamed from: b reason: collision with root package name */
    private final a<G> f7217b;

    /* renamed from: c reason: collision with root package name */
    private final a<d> f7218c;

    public n(i iVar, a<G> aVar, a<d> aVar2) {
        this.f7216a = iVar;
        this.f7217b = aVar;
        this.f7218c = aVar2;
    }

    public static n a(i iVar, a<G> aVar, a<d> aVar2) {
        return new n(iVar, aVar, aVar2);
    }

    public static w b(i iVar, a<G> aVar, a<d> aVar2) {
        return a(iVar, (G) aVar.get(), (d) aVar2.get());
    }

    public static w a(i iVar, G g2, d dVar) {
        w a2 = iVar.a(g2, dVar);
        e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public w get() {
        return b(this.f7216a, this.f7217b, this.f7218c);
    }
}
