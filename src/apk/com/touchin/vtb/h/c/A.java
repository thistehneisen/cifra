package com.touchin.vtb.h.c;

import com.touchin.vtb.f.b.qa;
import d.a.c;
import f.a.a;

/* compiled from: StartupViewModel_Factory */
public final class A implements c<z> {

    /* renamed from: a reason: collision with root package name */
    private final a<qa> f7525a;

    public A(a<qa> aVar) {
        this.f7525a = aVar;
    }

    public static A a(a<qa> aVar) {
        return new A(aVar);
    }

    public static z b(a<qa> aVar) {
        return new z((qa) aVar.get());
    }

    public z get() {
        return b(this.f7525a);
    }
}
