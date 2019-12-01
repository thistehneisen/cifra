package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.i reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0223i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f1928a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0231q f1929b;

    C0223i(C0231q qVar, ArrayList arrayList) {
        this.f1929b = qVar;
        this.f1928a = arrayList;
    }

    public void run() {
        Iterator it = this.f1928a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            this.f1929b.b(bVar.f1967a, bVar.f1968b, bVar.f1969c, bVar.f1970d, bVar.f1971e);
        }
        this.f1928a.clear();
        this.f1929b.n.remove(this.f1928a);
    }
}
