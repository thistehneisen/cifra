package com.touchin.vtb.c.a;

import android.content.SharedPreferences;
import d.a.c;
import d.a.e;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: PersistentModule_ProvideSessionStorableFactory */
public final class w implements c<i<String, String, String>> {

    /* renamed from: a reason: collision with root package name */
    private final r f7233a;

    /* renamed from: b reason: collision with root package name */
    private final a<SharedPreferences> f7234b;

    public w(r rVar, a<SharedPreferences> aVar) {
        this.f7233a = rVar;
        this.f7234b = aVar;
    }

    public static w a(r rVar, a<SharedPreferences> aVar) {
        return new w(rVar, aVar);
    }

    public static i<String, String, String> b(r rVar, a<SharedPreferences> aVar) {
        return a(rVar, (SharedPreferences) aVar.get());
    }

    public static i<String, String, String> a(r rVar, SharedPreferences sharedPreferences) {
        i<String, String, String> e2 = rVar.e(sharedPreferences);
        e.a(e2, "Cannot return null from a non-@Nullable @Provides method");
        return e2;
    }

    public i<String, String, String> get() {
        return b(this.f7233a, this.f7234b);
    }
}
