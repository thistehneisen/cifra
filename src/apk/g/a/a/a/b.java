package g.a.a.a;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BaseItemAnimator */
class b implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f8380a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ g f8381b;

    b(g gVar, ArrayList arrayList) {
        this.f8381b = gVar;
        this.f8380a = arrayList;
    }

    public void run() {
        if (this.f8381b.n.remove(this.f8380a)) {
            Iterator it = this.f8380a.iterator();
            while (it.hasNext()) {
                this.f8381b.a((a) it.next());
            }
            this.f8380a.clear();
        }
    }
}
