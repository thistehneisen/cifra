package com.touchin.vtb.f.b;

import com.touchin.vtb.api.A;
import com.touchin.vtb.api.j;
import d.a.c;
import f.a.a;
import ru.touchin.roboswag.core.observables.storable.i;

/* compiled from: UserInfoRepository_Factory */
public final class ra implements c<qa> {

    /* renamed from: a reason: collision with root package name */
    private final a<A> f7365a;

    /* renamed from: b reason: collision with root package name */
    private final a<j> f7366b;

    /* renamed from: c reason: collision with root package name */
    private final a<com.touchin.vtb.f.a.c> f7367c;

    /* renamed from: d reason: collision with root package name */
    private final a<sa> f7368d;

    /* renamed from: e reason: collision with root package name */
    private final a<i<String, String, String>> f7369e;

    /* renamed from: f reason: collision with root package name */
    private final a<i<String, String, String>> f7370f;

    /* renamed from: g reason: collision with root package name */
    private final a<i<String, Boolean, Boolean>> f7371g;

    public ra(a<A> aVar, a<j> aVar2, a<com.touchin.vtb.f.a.c> aVar3, a<sa> aVar4, a<i<String, String, String>> aVar5, a<i<String, String, String>> aVar6, a<i<String, Boolean, Boolean>> aVar7) {
        this.f7365a = aVar;
        this.f7366b = aVar2;
        this.f7367c = aVar3;
        this.f7368d = aVar4;
        this.f7369e = aVar5;
        this.f7370f = aVar6;
        this.f7371g = aVar7;
    }

    public static ra a(a<A> aVar, a<j> aVar2, a<com.touchin.vtb.f.a.c> aVar3, a<sa> aVar4, a<i<String, String, String>> aVar5, a<i<String, String, String>> aVar6, a<i<String, Boolean, Boolean>> aVar7) {
        ra raVar = new ra(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
        return raVar;
    }

    public static qa b(a<A> aVar, a<j> aVar2, a<com.touchin.vtb.f.a.c> aVar3, a<sa> aVar4, a<i<String, String, String>> aVar5, a<i<String, String, String>> aVar6, a<i<String, Boolean, Boolean>> aVar7) {
        qa qaVar = new qa((A) aVar.get(), (j) aVar2.get(), (com.touchin.vtb.f.a.c) aVar3.get(), (sa) aVar4.get(), (i) aVar5.get(), (i) aVar6.get(), (i) aVar7.get());
        return qaVar;
    }

    public qa get() {
        return b(this.f7365a, this.f7366b, this.f7367c, this.f7368d, this.f7369e, this.f7370f, this.f7371g);
    }
}
