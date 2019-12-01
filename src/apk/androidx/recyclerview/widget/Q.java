package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.x;

/* compiled from: RecyclerView */
class Q implements C0014a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ RecyclerView f1732a;

    Q(RecyclerView recyclerView) {
        this.f1732a = recyclerView;
    }

    public x a(int i2) {
        x a2 = this.f1732a.a(i2, true);
        if (a2 != null && !this.f1732a.o.c(a2.itemView)) {
            return a2;
        }
        return null;
    }

    public void b(int i2, int i3) {
        this.f1732a.a(i2, i3, false);
        this.f1732a.ua = true;
    }

    /* access modifiers changed from: 0000 */
    public void c(b bVar) {
        int i2 = bVar.f1877a;
        if (i2 == 1) {
            RecyclerView recyclerView = this.f1732a;
            recyclerView.w.a(recyclerView, bVar.f1878b, bVar.f1880d);
        } else if (i2 == 2) {
            RecyclerView recyclerView2 = this.f1732a;
            recyclerView2.w.b(recyclerView2, bVar.f1878b, bVar.f1880d);
        } else if (i2 == 4) {
            RecyclerView recyclerView3 = this.f1732a;
            recyclerView3.w.a(recyclerView3, bVar.f1878b, bVar.f1880d, bVar.f1879c);
        } else if (i2 == 8) {
            RecyclerView recyclerView4 = this.f1732a;
            recyclerView4.w.a(recyclerView4, bVar.f1878b, bVar.f1880d, 1);
        }
    }

    public void d(int i2, int i3) {
        this.f1732a.a(i2, i3, true);
        RecyclerView recyclerView = this.f1732a;
        recyclerView.ua = true;
        recyclerView.ra.f1811d += i3;
    }

    public void a(int i2, int i3, Object obj) {
        this.f1732a.a(i2, i3, obj);
        this.f1732a.va = true;
    }

    public void b(b bVar) {
        c(bVar);
    }

    public void a(b bVar) {
        c(bVar);
    }

    public void a(int i2, int i3) {
        this.f1732a.g(i2, i3);
        this.f1732a.ua = true;
    }

    public void c(int i2, int i3) {
        this.f1732a.f(i2, i3);
        this.f1732a.ua = true;
    }
}
