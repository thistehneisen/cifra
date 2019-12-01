package androidx.fragment.app;

import android.view.View;
import b.g.i.B;
import java.util.ArrayList;

/* compiled from: FragmentTransitionImpl */
class Q implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ int f1496a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ArrayList f1497b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ ArrayList f1498c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ ArrayList f1499d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ ArrayList f1500e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ U f1501f;

    Q(U u, int i2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1501f = u;
        this.f1496a = i2;
        this.f1497b = arrayList;
        this.f1498c = arrayList2;
        this.f1499d = arrayList3;
        this.f1500e = arrayList4;
    }

    public void run() {
        for (int i2 = 0; i2 < this.f1496a; i2++) {
            B.a((View) this.f1497b.get(i2), (String) this.f1498c.get(i2));
            B.a((View) this.f1499d.get(i2), (String) this.f1500e.get(i2));
        }
    }
}
