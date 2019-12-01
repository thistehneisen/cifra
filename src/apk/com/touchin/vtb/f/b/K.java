package com.touchin.vtb.f.b;

import com.touchin.vtb.api.v;
import d.a.c;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: TasksRepository_Factory */
public final class K implements c<C0669w> {

    /* renamed from: a reason: collision with root package name */
    private final a<v> f7287a;

    /* renamed from: b reason: collision with root package name */
    private final a<i<String, String, String>> f7288b;

    public K(a<v> aVar, a<i<String, String, String>> aVar2) {
        this.f7287a = aVar;
        this.f7288b = aVar2;
    }

    public static K a(a<v> aVar, a<i<String, String, String>> aVar2) {
        return new K(aVar, aVar2);
    }

    public static C0669w b(a<v> aVar, a<i<String, String, String>> aVar2) {
        return new C0669w((v) aVar.get(), (i) aVar2.get());
    }

    public C0669w get() {
        return b(this.f7287a, this.f7288b);
    }
}
