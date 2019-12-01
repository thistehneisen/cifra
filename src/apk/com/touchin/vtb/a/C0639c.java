package com.touchin.vtb.a;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.C0232s.c;
import com.touchin.vtb.a.q.a;
import kotlin.e.b.h;

/* renamed from: com.touchin.vtb.a.c reason: case insensitive filesystem */
/* compiled from: BankOperationsAdapter.kt */
public final class C0639c extends c<q> {
    C0639c() {
    }

    @SuppressLint({"DiffUtilEquals"})
    public boolean a(q qVar, q qVar2) {
        h.b(qVar, "oldItem");
        h.b(qVar2, "newItem");
        return h.a((Object) qVar, (Object) qVar2);
    }

    public boolean b(q qVar, q qVar2) {
        h.b(qVar, "oldItem");
        h.b(qVar2, "newItem");
        if (!(qVar instanceof a) || !(qVar2 instanceof a)) {
            return false;
        }
        return h.a((Object) ((a) qVar).b().e(), (Object) ((a) qVar2).b().e());
    }
}
