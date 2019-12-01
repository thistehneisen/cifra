package com.touchin.vtb.c.a;

import android.content.SharedPreferences;
import d.a.c;
import d.a.e;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: PersistentModule_ProvideBankUsageTimeStorableFactory */
public final class s implements c<i<String, Long, Long>> {

    /* renamed from: a reason: collision with root package name */
    private final r f7225a;

    /* renamed from: b reason: collision with root package name */
    private final a<SharedPreferences> f7226b;

    public s(r rVar, a<SharedPreferences> aVar) {
        this.f7225a = rVar;
        this.f7226b = aVar;
    }

    public static s a(r rVar, a<SharedPreferences> aVar) {
        return new s(rVar, aVar);
    }

    public static i<String, Long, Long> b(r rVar, a<SharedPreferences> aVar) {
        return a(rVar, (SharedPreferences) aVar.get());
    }

    public static i<String, Long, Long> a(r rVar, SharedPreferences sharedPreferences) {
        i<String, Long, Long> a2 = rVar.a(sharedPreferences);
        e.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    public i<String, Long, Long> get() {
        return b(this.f7225a, this.f7226b);
    }
}
