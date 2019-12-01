package com.touchin.vtb.a;

import com.touchin.vtb.a.c.b;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* renamed from: com.touchin.vtb.a.j reason: case insensitive filesystem */
/* compiled from: BankOperationsAdapter.kt */
final class C0646j extends i implements c<Integer, b, m> {
    final /* synthetic */ C0640d this$0;

    C0646j(C0640d dVar) {
        this.this$0 = dVar;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        a(((Number) obj).intValue(), (b) obj2);
        return m.f10346a;
    }

    public final void a(int i2, b bVar) {
        h.b(bVar, "groupViewHolder");
        org.joda.time.b d2 = ((q) this.this$0.d().get(i2 - 1)).a().b().d();
        h.a((Object) d2, "getList()[adapterPositio…tion().operationInfo.date");
        bVar.a(d2);
    }
}
