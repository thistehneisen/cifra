package com.touchin.vtb.h.a;

import com.touchin.vtb.f.b.O;
import d.a.c;
import f.a.a;

/* compiled from: TaxesViewModel_Factory */
public final class s implements c<r> {

    /* renamed from: a reason: collision with root package name */
    private final a<O> f7502a;

    public s(a<O> aVar) {
        this.f7502a = aVar;
    }

    public static s a(a<O> aVar) {
        return new s(aVar);
    }

    public static r b(a<O> aVar) {
        return new r((O) aVar.get());
    }

    public r get() {
        return b(this.f7502a);
    }
}
