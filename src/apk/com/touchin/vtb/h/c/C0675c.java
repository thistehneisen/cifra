package com.touchin.vtb.h.c;

import androidx.lifecycle.u;
import com.touchin.vtb.f.b.qa;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;
import l.a.c.a.b;
import l.a.c.b.c;
import l.a.c.c.l;
import l.a.c.c.s;

/* renamed from: com.touchin.vtb.h.c.c reason: case insensitive filesystem */
/* compiled from: CreatePinViewModel.kt */
public final class C0675c extends s {

    /* renamed from: e reason: collision with root package name */
    private final c<b> f7533e = new c<>();

    /* renamed from: f reason: collision with root package name */
    private final qa f7534f;

    public C0675c(qa qaVar) {
        h.b(qaVar, "userInfoRepository");
        super(null, null, 3, null);
        this.f7534f = qaVar;
    }

    public final e.b.b.b a(String str) {
        h.b(str, "pin");
        return a(this.f7534f.d(str), (u<b>) this.f7533e);
    }

    public final c<b> c() {
        return this.f7533e;
    }

    public final e.b.b.b a(a<m> aVar) {
        h.b(aVar, "doOnCompleteAction");
        return l.a.a((l) this, this.f7534f.g(), (a) aVar, (kotlin.e.a.b) null, 2, (Object) null);
    }
}
