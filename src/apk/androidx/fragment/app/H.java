package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
class H implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Object f1446a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ U f1447b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f1448c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ Fragment f1449d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ ArrayList f1450e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ ArrayList f1451f;

    /* renamed from: g reason: collision with root package name */
    final /* synthetic */ ArrayList f1452g;

    /* renamed from: h reason: collision with root package name */
    final /* synthetic */ Object f1453h;

    H(Object obj, U u, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f1446a = obj;
        this.f1447b = u;
        this.f1448c = view;
        this.f1449d = fragment;
        this.f1450e = arrayList;
        this.f1451f = arrayList2;
        this.f1452g = arrayList3;
        this.f1453h = obj2;
    }

    public void run() {
        Object obj = this.f1446a;
        if (obj != null) {
            this.f1447b.b(obj, this.f1448c);
            this.f1451f.addAll(K.a(this.f1447b, this.f1446a, this.f1449d, this.f1450e, this.f1448c));
        }
        if (this.f1452g != null) {
            if (this.f1453h != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f1448c);
                this.f1447b.a(this.f1453h, this.f1452g, arrayList);
            }
            this.f1452g.clear();
            this.f1452g.add(this.f1448c);
        }
    }
}
