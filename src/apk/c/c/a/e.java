package c.c.a;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.n;

/* compiled from: ItemTouchHelperExtension */
class e extends n {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f3190a;

    e(k kVar) {
        this.f3190a = kVar;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
        if (i2 == 1) {
            k kVar = this.f3190a;
            if (kVar.f3199e != null) {
                kVar.c();
            }
        }
    }
}
