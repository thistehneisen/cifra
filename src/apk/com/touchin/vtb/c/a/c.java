package com.touchin.vtb.c.a;

import com.touchin.vtb.api.d;
import com.touchin.vtb.b.i;
import d.a.e;
import f.a.a;

/* compiled from: ApplicationModule_ProvideApiJsonFactoryFactory */
public final class c implements d.a.c<d> {

    /* renamed from: a reason: collision with root package name */
    private final b f7183a;

    /* renamed from: b reason: collision with root package name */
    private final a<i> f7184b;

    public c(b bVar, a<i> aVar) {
        this.f7183a = bVar;
        this.f7184b = aVar;
    }

    public static c a(b bVar, a<i> aVar) {
        return new c(bVar, aVar);
    }

    public static d b(b bVar, a<i> aVar) {
        return a(bVar, (i) aVar.get());
    }

    public static d a(b bVar, i iVar) {
        d a2 = bVar.a(iVar);
        e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public d get() {
        return b(this.f7183a, this.f7184b);
    }
}
