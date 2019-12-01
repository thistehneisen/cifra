package g.a.a.a;

import androidx.recyclerview.widget.RecyclerView.x;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BaseItemAnimator */
class c implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f8382a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ g f8383b;

    c(g gVar, ArrayList arrayList) {
        this.f8383b = gVar;
        this.f8382a = arrayList;
    }

    public void run() {
        if (this.f8383b.f8400l.remove(this.f8382a)) {
            Iterator it = this.f8382a.iterator();
            while (it.hasNext()) {
                this.f8383b.z((x) it.next());
            }
            this.f8382a.clear();
        }
    }
}
