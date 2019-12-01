package com.touchin.vtb.f.b;

import com.touchin.vtb.api.e;
import d.a.c;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* renamed from: com.touchin.vtb.f.b.v reason: case insensitive filesystem */
/* compiled from: BankRepository_Factory */
public final class C0668v implements c<C0648a> {

    /* renamed from: a reason: collision with root package name */
    private final a<e> f7377a;

    /* renamed from: b reason: collision with root package name */
    private final a<qa> f7378b;

    /* renamed from: c reason: collision with root package name */
    private final a<i<String, String, String>> f7379c;

    /* renamed from: d reason: collision with root package name */
    private final a<i<String, Long, Long>> f7380d;

    public C0668v(a<e> aVar, a<qa> aVar2, a<i<String, String, String>> aVar3, a<i<String, Long, Long>> aVar4) {
        this.f7377a = aVar;
        this.f7378b = aVar2;
        this.f7379c = aVar3;
        this.f7380d = aVar4;
    }

    public static C0668v a(a<e> aVar, a<qa> aVar2, a<i<String, String, String>> aVar3, a<i<String, Long, Long>> aVar4) {
        return new C0668v(aVar, aVar2, aVar3, aVar4);
    }

    public static C0648a b(a<e> aVar, a<qa> aVar2, a<i<String, String, String>> aVar3, a<i<String, Long, Long>> aVar4) {
        return new C0648a((e) aVar.get(), (qa) aVar2.get(), (i) aVar3.get(), (i) aVar4.get());
    }

    public C0648a get() {
        return b(this.f7377a, this.f7378b, this.f7379c, this.f7380d);
    }
}
