package com.touchin.vtb.h.d;

import com.touchin.vtb.f.b.C0669w;
import com.touchin.vtb.f.b.qa;
import d.a.c;
import f.a.a;

/* compiled from: TaskTaxViewModel_Factory */
public final class d implements c<c> {

    /* renamed from: a reason: collision with root package name */
    private final a<C0669w> f7588a;

    /* renamed from: b reason: collision with root package name */
    private final a<qa> f7589b;

    public d(a<C0669w> aVar, a<qa> aVar2) {
        this.f7588a = aVar;
        this.f7589b = aVar2;
    }

    public static d a(a<C0669w> aVar, a<qa> aVar2) {
        return new d(aVar, aVar2);
    }

    public static c b(a<C0669w> aVar, a<qa> aVar2) {
        return new c((C0669w) aVar.get(), (qa) aVar2.get());
    }

    public c get() {
        return b(this.f7588a, this.f7589b);
    }
}
