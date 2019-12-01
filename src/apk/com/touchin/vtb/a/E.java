package com.touchin.vtb.a;

import com.touchin.vtb.a.c.f;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;
import org.joda.time.b;

/* compiled from: TasksArchiveAdapter.kt */
final class E extends i implements c<Integer, f, m> {
    final /* synthetic */ G this$0;

    E(G g2) {
        this.this$0 = g2;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        a(((Number) obj).intValue(), (f) obj2);
        return m.f10346a;
    }

    public final void a(int i2, f fVar) {
        h.b(fVar, "groupViewHolder");
        fVar.a(new b(((H) this.this$0.d().get(i2)).a().c()));
    }
}
