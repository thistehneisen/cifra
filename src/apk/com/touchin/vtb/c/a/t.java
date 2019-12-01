package com.touchin.vtb.c.a;

import android.content.SharedPreferences;
import d.a.c;
import d.a.e;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: PersistentModule_ProvideIsFastEntranceEnabledStorableFactory */
public final class t implements c<i<String, Boolean, Boolean>> {

    /* renamed from: a reason: collision with root package name */
    private final r f7227a;

    /* renamed from: b reason: collision with root package name */
    private final a<SharedPreferences> f7228b;

    public t(r rVar, a<SharedPreferences> aVar) {
        this.f7227a = rVar;
        this.f7228b = aVar;
    }

    public static t a(r rVar, a<SharedPreferences> aVar) {
        return new t(rVar, aVar);
    }

    public static i<String, Boolean, Boolean> b(r rVar, a<SharedPreferences> aVar) {
        return a(rVar, (SharedPreferences) aVar.get());
    }

    public static i<String, Boolean, Boolean> a(r rVar, SharedPreferences sharedPreferences) {
        i<String, Boolean, Boolean> b2 = rVar.b(sharedPreferences);
        e.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }

    public i<String, Boolean, Boolean> get() {
        return b(this.f7227a, this.f7228b);
    }
}
