package com.touchin.vtb.h.a;

import com.touchin.vtb.f.b.C0648a;
import e.b.b.b;
import kotlin.e.b.h;
import l.a.c.c.l;
import l.a.c.c.s;

/* compiled from: BankUsageTimeViewModel.kt */
public class a extends s {

    /* renamed from: e reason: collision with root package name */
    private final C0648a f7478e;

    public a(C0648a aVar) {
        h.b(aVar, "bankRepository");
        super(null, null, 3, null);
        this.f7478e = aVar;
    }

    public final b a(long j2) {
        return l.a.c.c.l.a.a((l) this, this.f7478e.a(j2), (kotlin.e.a.a) null, (kotlin.e.a.b) null, 3, (Object) null);
    }

    public final long c() {
        Object c2 = this.f7478e.d().c();
        h.a(c2, "bankRepository.getBankUsageTime().blockingGet()");
        return ((Number) c2).longValue();
    }
}
