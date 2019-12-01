package c.c.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.i.B;

/* compiled from: ItemTouchHelperExtension */
class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f3185a;

    b(k kVar) {
        this.f3185a = kVar;
    }

    public void run() {
        k kVar = this.f3185a;
        if (kVar.f3198d != null && kVar.j()) {
            k kVar2 = this.f3185a;
            x xVar = kVar2.f3198d;
            if (xVar != null) {
                kVar2.b(xVar);
            }
            this.f3185a.t.removeCallbacks(this.f3185a.u);
            B.a((View) this.f3185a.t, (Runnable) this);
        }
    }
}
