package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.x;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.k reason: case insensitive filesystem */
/* compiled from: DefaultItemAnimator */
class C0225k implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ArrayList f1932a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0231q f1933b;

    C0225k(C0231q qVar, ArrayList arrayList) {
        this.f1933b = qVar;
        this.f1932a = arrayList;
    }

    public void run() {
        Iterator it = this.f1932a.iterator();
        while (it.hasNext()) {
            this.f1933b.t((x) it.next());
        }
        this.f1932a.clear();
        this.f1933b.m.remove(this.f1932a);
    }
}
