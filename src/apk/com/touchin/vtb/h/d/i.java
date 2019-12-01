package com.touchin.vtb.h.d;

import com.touchin.vtb.f.b.C0669w;
import com.touchin.vtb.f.b.sa;
import d.a.c;
import f.a.a;

/* compiled from: TasksViewModel_Factory */
public final class i implements c<g> {

    /* renamed from: a reason: collision with root package name */
    private final a<sa> f7602a;

    /* renamed from: b reason: collision with root package name */
    private final a<C0669w> f7603b;

    public i(a<sa> aVar, a<C0669w> aVar2) {
        this.f7602a = aVar;
        this.f7603b = aVar2;
    }

    public static i a(a<sa> aVar, a<C0669w> aVar2) {
        return new i(aVar, aVar2);
    }

    public static g b(a<sa> aVar, a<C0669w> aVar2) {
        return new g((sa) aVar.get(), (C0669w) aVar2.get());
    }

    public g get() {
        return b(this.f7602a, this.f7603b);
    }
}
