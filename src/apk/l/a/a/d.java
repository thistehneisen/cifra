package l.a.a;

import androidx.recyclerview.widget.RecyclerView.x;
import kotlin.e.a.a;
import kotlin.e.a.c;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: DelegationListAdapter.kt */
final class d extends i implements a<m> {
    final /* synthetic */ x $holder;
    final /* synthetic */ e this$0;

    d(e eVar, x xVar) {
        this.this$0 = eVar;
        this.$holder = xVar;
        super(0);
    }

    public final void b() {
        c c2 = this.this$0.c();
        if (c2 != null) {
            m mVar = (m) c2.a(this.this$0.d().get(this.this$0.d(this.$holder.getAdapterPosition())), this.$holder);
        }
    }
}
