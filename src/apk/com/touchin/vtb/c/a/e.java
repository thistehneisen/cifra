package com.touchin.vtb.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import d.a.c;
import f.a.a;

/* compiled from: ApplicationModule_ProvideDefaultSharedPreferencesFactory */
public final class e implements c<SharedPreferences> {

    /* renamed from: a reason: collision with root package name */
    private final b f7186a;

    /* renamed from: b reason: collision with root package name */
    private final a<Context> f7187b;

    public e(b bVar, a<Context> aVar) {
        this.f7186a = bVar;
        this.f7187b = aVar;
    }

    public static e a(b bVar, a<Context> aVar) {
        return new e(bVar, aVar);
    }

    public static SharedPreferences b(b bVar, a<Context> aVar) {
        return a(bVar, (Context) aVar.get());
    }

    public static SharedPreferences a(b bVar, Context context) {
        SharedPreferences a2 = bVar.a(context);
        d.a.e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public SharedPreferences get() {
        return b(this.f7186a, this.f7187b);
    }
}
