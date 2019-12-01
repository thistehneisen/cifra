package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.x;

/* compiled from: RecyclerView */
class O implements b {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecyclerView f1730a;

    O(RecyclerView recyclerView) {
        this.f1730a = recyclerView;
    }

    public void a(x xVar, c cVar, c cVar2) {
        this.f1730a.a(xVar, cVar, cVar2);
    }

    public void b(x xVar, c cVar, c cVar2) {
        this.f1730a.f1744l.c(xVar);
        this.f1730a.b(xVar, cVar, cVar2);
    }

    public void c(x xVar, c cVar, c cVar2) {
        xVar.setIsRecyclable(false);
        RecyclerView recyclerView = this.f1730a;
        if (recyclerView.N) {
            if (recyclerView.W.a(xVar, xVar, cVar, cVar2)) {
                this.f1730a.t();
            }
        } else if (recyclerView.W.c(xVar, cVar, cVar2)) {
            this.f1730a.t();
        }
    }

    public void a(x xVar) {
        RecyclerView recyclerView = this.f1730a;
        recyclerView.w.a(xVar.itemView, recyclerView.f1744l);
    }
}
