package b.p;

import android.view.View;
import b.p.E.c;
import java.util.ArrayList;

/* renamed from: b.p.q reason: case insensitive filesystem */
/* compiled from: FragmentTransitionSupport */
class C0271q implements c {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ View f2925a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ArrayList f2926b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ C0273t f2927c;

    C0271q(C0273t tVar, View view, ArrayList arrayList) {
        this.f2927c = tVar;
        this.f2925a = view;
        this.f2926b = arrayList;
    }

    public void a(E e2) {
    }

    public void b(E e2) {
    }

    public void c(E e2) {
        e2.b((c) this);
        this.f2925a.setVisibility(8);
        int size = this.f2926b.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((View) this.f2926b.get(i2)).setVisibility(0);
        }
    }

    public void d(E e2) {
    }
}
