package com.touchin.vtb.c.a;

import android.content.Context;
import d.a.c;
import d.a.e;

/* compiled from: ApplicationModule_ProvideContextFactory */
public final class d implements c<Context> {

    /* renamed from: a reason: collision with root package name */
    private final b f7185a;

    public d(b bVar) {
        this.f7185a = bVar;
    }

    public static d a(b bVar) {
        return new d(bVar);
    }

    public static Context b(b bVar) {
        return c(bVar);
    }

    public static Context c(b bVar) {
        Context a2 = bVar.a();
        e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public Context get() {
        return b(this.f7185a);
    }
}
