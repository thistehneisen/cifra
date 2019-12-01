package com.touchin.vtb.f;

import e.b.o;
import kotlin.e.b.h;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: AuthorizedModel.kt */
public abstract class a {

    /* renamed from: a reason: collision with root package name */
    private final i<String, String, String> f7253a;

    public a(i<String, String, String> iVar) {
        h.b(iVar, "sessionStorable");
        this.f7253a = iVar;
    }

    /* access modifiers changed from: protected */
    public final o<String> a() {
        o<String> b2 = this.f7253a.b();
        h.a((Object) b2, "sessionStorable.get()");
        return b2;
    }
}
