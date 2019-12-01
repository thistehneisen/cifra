package com.touchin.vtb.h.c;

import com.touchin.vtb.f.b.qa;
import d.a.c;
import f.a.a;

/* compiled from: SearchViewModel_Factory */
public final class x implements c<v> {

    /* renamed from: a reason: collision with root package name */
    private final a<qa> f7576a;

    public x(a<qa> aVar) {
        this.f7576a = aVar;
    }

    public static x a(a<qa> aVar) {
        return new x(aVar);
    }

    public static v b(a<qa> aVar) {
        return new v((qa) aVar.get());
    }

    public v get() {
        return b(this.f7576a);
    }
}
