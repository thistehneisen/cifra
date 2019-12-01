package com.touchin.vtb.h.c;

import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.sa;
import d.a.c;
import f.a.a;

/* compiled from: GetAccessConfirmSmsViewModel_Factory */
public final class n implements c<m> {

    /* renamed from: a reason: collision with root package name */
    private final a<C0648a> f7557a;

    /* renamed from: b reason: collision with root package name */
    private final a<sa> f7558b;

    public n(a<C0648a> aVar, a<sa> aVar2) {
        this.f7557a = aVar;
        this.f7558b = aVar2;
    }

    public static n a(a<C0648a> aVar, a<sa> aVar2) {
        return new n(aVar, aVar2);
    }

    public static m b(a<C0648a> aVar, a<sa> aVar2) {
        return new m((C0648a) aVar.get(), (sa) aVar2.get());
    }

    public m get() {
        return b(this.f7557a, this.f7558b);
    }
}
