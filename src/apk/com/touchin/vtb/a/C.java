package com.touchin.vtb.a;

import java.util.List;
import kotlin.e.a.b;
import kotlin.e.a.c;
import kotlin.e.b.i;

/* compiled from: TasksArchiveAdapter.kt */
final class C extends i implements b<Integer, Boolean> {
    final /* synthetic */ c $predicate;
    final /* synthetic */ G this$0;

    C(G g2, c cVar) {
        this.this$0 = g2;
        this.$predicate = cVar;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return Boolean.valueOf(a(((Number) obj).intValue()));
    }

    public final boolean a(int i2) {
        if (i2 == 0) {
            return true;
        }
        int itemCount = this.this$0.getItemCount();
        if (1 > i2 || itemCount <= i2) {
            return false;
        }
        List d2 = this.this$0.d();
        H h2 = (H) q.a(d2, i2 - 1);
        H h3 = (H) q.a(d2, i2);
        if (h2 != null && h3 != null) {
            return ((Boolean) this.$predicate.a(h2, h3)).booleanValue();
        }
        l.a.d.b.a.c.a("List element is null");
        return false;
    }
}
