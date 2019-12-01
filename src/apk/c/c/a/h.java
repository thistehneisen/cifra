package c.c.a;

import androidx.recyclerview.widget.RecyclerView.d;

/* compiled from: ItemTouchHelperExtension */
class h implements d {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f3194a;

    h(k kVar) {
        this.f3194a = kVar;
    }

    public int a(int i2, int i3) {
        if (this.f3194a.z == null) {
            return i3;
        }
        int h2 = this.f3194a.A;
        if (h2 == -1) {
            h2 = this.f3194a.t.indexOfChild(this.f3194a.z);
            this.f3194a.A = h2;
        }
        if (i3 == i2 - 1) {
            return h2;
        }
        if (i3 >= h2) {
            i3++;
        }
        return i3;
    }
}
