package com.touchin.vtb.c.a;

import com.touchin.vtb.api.e;
import d.a.c;
import f.a.a;
import retrofit2.w;

/* compiled from: NetworkModule_ProvideBankApiFactory */
public final class j implements c<e> {

    /* renamed from: a reason: collision with root package name */
    private final i f7208a;

    /* renamed from: b reason: collision with root package name */
    private final a<w> f7209b;

    public j(i iVar, a<w> aVar) {
        this.f7208a = iVar;
        this.f7209b = aVar;
    }

    public static j a(i iVar, a<w> aVar) {
        return new j(iVar, aVar);
    }

    public static e b(i iVar, a<w> aVar) {
        return a(iVar, (w) aVar.get());
    }

    public static e a(i iVar, w wVar) {
        e a2 = iVar.a(wVar);
        d.a.e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public e get() {
        return b(this.f7208a, this.f7209b);
    }
}
