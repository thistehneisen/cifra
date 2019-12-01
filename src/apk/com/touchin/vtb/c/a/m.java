package com.touchin.vtb.c.a;

import d.a.c;
import d.a.e;
import f.a.a;
import i.G;

/* compiled from: NetworkModule_ProvidePublicClientFactory */
public final class m implements c<G> {

    /* renamed from: a reason: collision with root package name */
    private final i f7214a;

    /* renamed from: b reason: collision with root package name */
    private final a<com.touchin.vtb.api.m> f7215b;

    public m(i iVar, a<com.touchin.vtb.api.m> aVar) {
        this.f7214a = iVar;
        this.f7215b = aVar;
    }

    public static m a(i iVar, a<com.touchin.vtb.api.m> aVar) {
        return new m(iVar, aVar);
    }

    public static G b(i iVar, a<com.touchin.vtb.api.m> aVar) {
        return a(iVar, (com.touchin.vtb.api.m) aVar.get());
    }

    public static G a(i iVar, com.touchin.vtb.api.m mVar) {
        G a2 = iVar.a(mVar);
        e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public G get() {
        return b(this.f7214a, this.f7215b);
    }
}
