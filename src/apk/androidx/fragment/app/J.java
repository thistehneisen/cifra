package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import b.d.b;
import java.util.ArrayList;

/* compiled from: FragmentTransition */
class J implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ U f1461a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ b f1462b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Object f1463c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ a f1464d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ ArrayList f1465e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ View f1466f;

    /* renamed from: g reason: collision with root package name */
    final /* synthetic */ Fragment f1467g;

    /* renamed from: h reason: collision with root package name */
    final /* synthetic */ Fragment f1468h;

    /* renamed from: i reason: collision with root package name */
    final /* synthetic */ boolean f1469i;

    /* renamed from: j reason: collision with root package name */
    final /* synthetic */ ArrayList f1470j;

    /* renamed from: k reason: collision with root package name */
    final /* synthetic */ Object f1471k;

    /* renamed from: l reason: collision with root package name */
    final /* synthetic */ Rect f1472l;

    J(U u, b bVar, Object obj, a aVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f1461a = u;
        this.f1462b = bVar;
        this.f1463c = obj;
        this.f1464d = aVar;
        this.f1465e = arrayList;
        this.f1466f = view;
        this.f1467g = fragment;
        this.f1468h = fragment2;
        this.f1469i = z;
        this.f1470j = arrayList2;
        this.f1471k = obj2;
        this.f1472l = rect;
    }

    public void run() {
        b a2 = K.a(this.f1461a, this.f1462b, this.f1463c, this.f1464d);
        if (a2 != null) {
            this.f1465e.addAll(a2.values());
            this.f1465e.add(this.f1466f);
        }
        K.a(this.f1467g, this.f1468h, this.f1469i, a2, false);
        Object obj = this.f1463c;
        if (obj != null) {
            this.f1461a.b(obj, this.f1470j, this.f1465e);
            View a3 = K.a(a2, this.f1464d, this.f1471k, this.f1469i);
            if (a3 != null) {
                this.f1461a.a(a3, this.f1472l);
            }
        }
    }
}
