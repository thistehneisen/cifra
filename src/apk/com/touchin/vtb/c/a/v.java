package com.touchin.vtb.c.a;

import android.content.SharedPreferences;
import d.a.c;
import d.a.e;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: PersistentModule_ProvidePinStorableFactory */
public final class v implements c<i<String, String, String>> {

    /* renamed from: a reason: collision with root package name */
    private final r f7231a;

    /* renamed from: b reason: collision with root package name */
    private final a<SharedPreferences> f7232b;

    public v(r rVar, a<SharedPreferences> aVar) {
        this.f7231a = rVar;
        this.f7232b = aVar;
    }

    public static v a(r rVar, a<SharedPreferences> aVar) {
        return new v(rVar, aVar);
    }

    public static i<String, String, String> b(r rVar, a<SharedPreferences> aVar) {
        return a(rVar, (SharedPreferences) aVar.get());
    }

    public static i<String, String, String> a(r rVar, SharedPreferences sharedPreferences) {
        i<String, String, String> d2 = rVar.d(sharedPreferences);
        e.a(d2, "Cannot return null from a non-@Nullable @Provides method");
        return d2;
    }

    public i<String, String, String> get() {
        return b(this.f7231a, this.f7232b);
    }
}
