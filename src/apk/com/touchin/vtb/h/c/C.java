package com.touchin.vtb.h.c;

import com.touchin.vtb.f.b.qa;
import d.a.c;
import f.a.a;

/* compiled from: WelcomeViewModel_Factory */
public final class C implements c<B> {

    /* renamed from: a reason: collision with root package name */
    private final a<qa> f7528a;

    public C(a<qa> aVar) {
        this.f7528a = aVar;
    }

    public static C a(a<qa> aVar) {
        return new C(aVar);
    }

    public static B b(a<qa> aVar) {
        return new B((qa) aVar.get());
    }

    public B get() {
        return b(this.f7528a);
    }
}
