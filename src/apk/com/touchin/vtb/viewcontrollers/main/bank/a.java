package com.touchin.vtb.viewcontrollers.main.bank;

import androidx.recyclerview.widget.RecyclerView.x;
import com.touchin.vtb.a.q;
import com.touchin.vtb.g.g;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;
import ru.touchin.roboswag.components.navigation.viewcontrollers.d;

/* compiled from: BankViewController.kt */
final class a extends i implements c<q, x, m> {
    final /* synthetic */ BankViewController this$0;

    a(BankViewController bankViewController) {
        this.this$0 = bankViewController;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        a((q) obj, (x) obj2);
        return m.f10346a;
    }

    public final void a(q qVar, x xVar) {
        h.b(qVar, "operationInfo");
        h.b(xVar, "viewHolder");
        if (xVar instanceof com.touchin.vtb.a.c.c) {
            d.a(((com.touchin.vtb.activities.c) this.this$0.getActivity()).c(), PaymentDetailsViewController.class, new g(qVar.a().b()), false, null, null, 28, null);
        }
    }
}
