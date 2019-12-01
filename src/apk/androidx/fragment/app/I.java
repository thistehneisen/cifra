package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import b.d.b;

/* compiled from: FragmentTransition */
class I implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Fragment f1454a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Fragment f1455b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ boolean f1456c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ b f1457d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ View f1458e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ U f1459f;

    /* renamed from: g reason: collision with root package name */
    final /* synthetic */ Rect f1460g;

    I(Fragment fragment, Fragment fragment2, boolean z, b bVar, View view, U u, Rect rect) {
        this.f1454a = fragment;
        this.f1455b = fragment2;
        this.f1456c = z;
        this.f1457d = bVar;
        this.f1458e = view;
        this.f1459f = u;
        this.f1460g = rect;
    }

    public void run() {
        K.a(this.f1454a, this.f1455b, this.f1456c, this.f1457d, false);
        View view = this.f1458e;
        if (view != null) {
            this.f1459f.a(view, this.f1460g);
        }
    }
}
