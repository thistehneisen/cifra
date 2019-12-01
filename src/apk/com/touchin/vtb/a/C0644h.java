package com.touchin.vtb.a;

import com.touchin.vtb.a.q.a;
import java.util.List;
import kotlin.e.a.b;
import kotlin.e.a.c;
import kotlin.e.b.i;

/* renamed from: com.touchin.vtb.a.h reason: case insensitive filesystem */
/* compiled from: BankOperationsAdapter.kt */
final class C0644h extends i implements b<Integer, Boolean> {
    final /* synthetic */ c $predicate;
    final /* synthetic */ C0640d this$0;

    C0644h(C0640d dVar, c cVar) {
        this.this$0 = dVar;
        this.$predicate = cVar;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return Boolean.valueOf(a(((Number) obj).intValue()));
    }

    public final boolean a(int i2) {
        if (i2 == 1) {
            return q.a(this.this$0.d(), i2 - 1) instanceof a;
        }
        int itemCount = this.this$0.getItemCount();
        if (2 > i2 || itemCount <= i2) {
            return false;
        }
        List d2 = this.this$0.d();
        q qVar = (q) q.a(d2, i2 - 2);
        q qVar2 = (q) q.a(d2, i2 - 1);
        if (qVar == null || qVar2 == null) {
            return false;
        }
        return ((Boolean) this.$predicate.a(qVar.a().b(), qVar2.a().b())).booleanValue();
    }
}
