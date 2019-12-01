package com.touchin.vtb.h.a;

import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.sa;
import d.a.c;
import f.a.a;

/* compiled from: BankViewModel_Factory */
public final class j implements c<d> {

    /* renamed from: a reason: collision with root package name */
    private final a<sa> f7491a;

    /* renamed from: b reason: collision with root package name */
    private final a<C0648a> f7492b;

    public j(a<sa> aVar, a<C0648a> aVar2) {
        this.f7491a = aVar;
        this.f7492b = aVar2;
    }

    public static j a(a<sa> aVar, a<C0648a> aVar2) {
        return new j(aVar, aVar2);
    }

    public static d b(a<sa> aVar, a<C0648a> aVar2) {
        return new d((sa) aVar.get(), (C0648a) aVar2.get());
    }

    public d get() {
        return b(this.f7491a, this.f7492b);
    }
}
