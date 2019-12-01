package com.touchin.vtb.h.b;

import com.touchin.vtb.f.b.C0648a;
import com.touchin.vtb.f.b.qa;
import com.touchin.vtb.f.b.sa;
import d.a.c;
import f.a.a;

/* compiled from: BanksManagementViewModel_Factory */
public final class e implements c<d> {

    /* renamed from: a reason: collision with root package name */
    private final a<C0648a> f7513a;

    /* renamed from: b reason: collision with root package name */
    private final a<qa> f7514b;

    /* renamed from: c reason: collision with root package name */
    private final a<sa> f7515c;

    public e(a<C0648a> aVar, a<qa> aVar2, a<sa> aVar3) {
        this.f7513a = aVar;
        this.f7514b = aVar2;
        this.f7515c = aVar3;
    }

    public static e a(a<C0648a> aVar, a<qa> aVar2, a<sa> aVar3) {
        return new e(aVar, aVar2, aVar3);
    }

    public static d b(a<C0648a> aVar, a<qa> aVar2, a<sa> aVar3) {
        return new d((C0648a) aVar.get(), (qa) aVar2.get(), (sa) aVar3.get());
    }

    public d get() {
        return b(this.f7513a, this.f7514b, this.f7515c);
    }
}
