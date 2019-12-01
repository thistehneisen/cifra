package com.touchin.vtb.h.c;

import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.sa;
import d.a.c;
import f.a.a;

/* compiled from: GetAccessViewModel_Factory */
public final class q implements c<p> {

    /* renamed from: a reason: collision with root package name */
    private final a<C0648a> f7563a;

    /* renamed from: b reason: collision with root package name */
    private final a<sa> f7564b;

    public q(a<C0648a> aVar, a<sa> aVar2) {
        this.f7563a = aVar;
        this.f7564b = aVar2;
    }

    public static q a(a<C0648a> aVar, a<sa> aVar2) {
        return new q(aVar, aVar2);
    }

    public static p b(a<C0648a> aVar, a<sa> aVar2) {
        return new p((C0648a) aVar.get(), (sa) aVar2.get());
    }

    public p get() {
        return b(this.f7563a, this.f7564b);
    }
}
