package com.touchin.vtb.c.a;

import com.touchin.vtb.api.j;
import d.a.c;
import d.a.e;
import f.a.a;
import retrofit2.w;

/* compiled from: NetworkModule_ProvideDaDataApiFactory */
public final class k implements c<j> {

    /* renamed from: a reason: collision with root package name */
    private final i f7210a;

    /* renamed from: b reason: collision with root package name */
    private final a<w> f7211b;

    public k(i iVar, a<w> aVar) {
        this.f7210a = iVar;
        this.f7211b = aVar;
    }

    public static k a(i iVar, a<w> aVar) {
        return new k(iVar, aVar);
    }

    public static j b(i iVar, a<w> aVar) {
        return a(iVar, (w) aVar.get());
    }

    public static j a(i iVar, w wVar) {
        j b2 = iVar.b(wVar);
        e.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }

    public j get() {
        return b(this.f7210a, this.f7211b);
    }
}
