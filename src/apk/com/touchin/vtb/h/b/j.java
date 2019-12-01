package com.touchin.vtb.h.b;

import com.touchin.vtb.f.b.qa;
import com.touchin.vtb.f.b.sa;
import d.a.c;
import f.a.a;

/* compiled from: MoreViewModel_Factory */
public final class j implements c<i> {

    /* renamed from: a reason: collision with root package name */
    private final a<qa> f7523a;

    /* renamed from: b reason: collision with root package name */
    private final a<sa> f7524b;

    public j(a<qa> aVar, a<sa> aVar2) {
        this.f7523a = aVar;
        this.f7524b = aVar2;
    }

    public static j a(a<qa> aVar, a<sa> aVar2) {
        return new j(aVar, aVar2);
    }

    public static i b(a<qa> aVar, a<sa> aVar2) {
        return new i((qa) aVar.get(), (sa) aVar2.get());
    }

    public i get() {
        return b(this.f7523a, this.f7524b);
    }
}
