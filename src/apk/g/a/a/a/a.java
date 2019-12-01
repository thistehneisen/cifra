package g.a.a.a;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BaseItemAnimator */
class a implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f8378a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ g f8379b;

    a(g gVar, ArrayList arrayList) {
        this.f8379b = gVar;
        this.f8378a = arrayList;
    }

    public void run() {
        if (this.f8379b.m.remove(this.f8378a)) {
            Iterator it = this.f8378a.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                this.f8379b.b(dVar.f8411a, dVar.f8412b, dVar.f8413c, dVar.f8414d, dVar.f8415e);
            }
            this.f8378a.clear();
        }
    }
}
