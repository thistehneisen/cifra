package com.touchin.vtb.f.b;

import com.touchin.vtb.api.y;
import d.a.c;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: TaxesRepository_Factory */
public final class P implements c<O> {

    /* renamed from: a reason: collision with root package name */
    private final a<y> f7294a;

    /* renamed from: b reason: collision with root package name */
    private final a<i<String, String, String>> f7295b;

    public P(a<y> aVar, a<i<String, String, String>> aVar2) {
        this.f7294a = aVar;
        this.f7295b = aVar2;
    }

    public static P a(a<y> aVar, a<i<String, String, String>> aVar2) {
        return new P(aVar, aVar2);
    }

    public static O b(a<y> aVar, a<i<String, String, String>> aVar2) {
        return new O((y) aVar.get(), (i) aVar2.get());
    }

    public O get() {
        return b(this.f7294a, this.f7295b);
    }
}
