package com.touchin.vtb.c.a;

import android.content.Context;
import com.touchin.vtb.b.i;
import d.a.c;
import d.a.e;
import f.a.a;

/* compiled from: ApplicationModule_ProvideVtbAnalyticsFactory */
public final class f implements c<i> {

    /* renamed from: a reason: collision with root package name */
    private final b f7188a;

    /* renamed from: b reason: collision with root package name */
    private final a<Context> f7189b;

    public f(b bVar, a<Context> aVar) {
        this.f7188a = bVar;
        this.f7189b = aVar;
    }

    public static f a(b bVar, a<Context> aVar) {
        return new f(bVar, aVar);
    }

    public static i b(b bVar, a<Context> aVar) {
        return a(bVar, (Context) aVar.get());
    }

    public static i a(b bVar, Context context) {
        i b2 = bVar.b(context);
        e.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }

    public i get() {
        return b(this.f7188a, this.f7189b);
    }
}
