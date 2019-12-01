package com.touchin.vtb.c.a;

import android.content.SharedPreferences;
import d.a.c;
import d.a.e;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: PersistentModule_ProvideIsFingerprintEnableStorableFactory */
public final class u implements c<i<String, Boolean, Boolean>> {

    /* renamed from: a reason: collision with root package name */
    private final r f7229a;

    /* renamed from: b reason: collision with root package name */
    private final a<SharedPreferences> f7230b;

    public u(r rVar, a<SharedPreferences> aVar) {
        this.f7229a = rVar;
        this.f7230b = aVar;
    }

    public static u a(r rVar, a<SharedPreferences> aVar) {
        return new u(rVar, aVar);
    }

    public static i<String, Boolean, Boolean> b(r rVar, a<SharedPreferences> aVar) {
        return a(rVar, (SharedPreferences) aVar.get());
    }

    public static i<String, Boolean, Boolean> a(r rVar, SharedPreferences sharedPreferences) {
        i<String, Boolean, Boolean> c2 = rVar.c(sharedPreferences);
        e.a(c2, "Cannot return null from a non-@Nullable @Provides method");
        return c2;
    }

    public i<String, Boolean, Boolean> get() {
        return b(this.f7229a, this.f7230b);
    }
}
