package com.touchin.vtb.api;

import android.content.Context;
import com.touchin.vtb.b.i;
import d.a.c;
import f.a.a;

/* compiled from: ExceptionsInterceptor_Factory */
public final class n implements c<m> {

    /* renamed from: a reason: collision with root package name */
    private final a<i> f7124a;

    /* renamed from: b reason: collision with root package name */
    private final a<Context> f7125b;

    public n(a<i> aVar, a<Context> aVar2) {
        this.f7124a = aVar;
        this.f7125b = aVar2;
    }

    public static n a(a<i> aVar, a<Context> aVar2) {
        return new n(aVar, aVar2);
    }

    public static m b(a<i> aVar, a<Context> aVar2) {
        return new m((i) aVar.get(), (Context) aVar2.get());
    }

    public m get() {
        return b(this.f7124a, this.f7125b);
    }
}
