package com.touchin.vtb.f.a;

import android.content.Context;
import d.a.c;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: FingerprintInteractor_Factory */
public final class d implements c<c> {

    /* renamed from: a reason: collision with root package name */
    private final a<Context> f7261a;

    /* renamed from: b reason: collision with root package name */
    private final a<i<String, Boolean, Boolean>> f7262b;

    public d(a<Context> aVar, a<i<String, Boolean, Boolean>> aVar2) {
        this.f7261a = aVar;
        this.f7262b = aVar2;
    }

    public static d a(a<Context> aVar, a<i<String, Boolean, Boolean>> aVar2) {
        return new d(aVar, aVar2);
    }

    public static c b(a<Context> aVar, a<i<String, Boolean, Boolean>> aVar2) {
        return new c((Context) aVar.get(), (i) aVar2.get());
    }

    public c get() {
        return b(this.f7261a, this.f7262b);
    }
}
