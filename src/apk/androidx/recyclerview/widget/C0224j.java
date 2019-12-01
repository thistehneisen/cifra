package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.j reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0224j implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f1930a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0231q f1931b;

    C0224j(C0231q qVar, ArrayList arrayList) {
        this.f1931b = qVar;
        this.f1930a = arrayList;
    }

    public void run() {
        Iterator it = this.f1930a.iterator();
        while (it.hasNext()) {
            this.f1931b.a((a) it.next());
        }
        this.f1930a.clear();
        this.f1931b.o.remove(this.f1930a);
    }
}
