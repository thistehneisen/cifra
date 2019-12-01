package b.p;

import android.view.ViewGroup;
import b.p.E.c;

/* renamed from: b.p.l reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0266l extends F {

    /* renamed from: a reason: collision with root package name */
    boolean f2909a = false;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ ViewGroup f2910b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ C0267m f2911c;

    C0266l(C0267m mVar, ViewGroup viewGroup) {
        this.f2911c = mVar;
        this.f2910b = viewGroup;
    }

    public void b(E e2) {
        S.a(this.f2910b, false);
    }

    public void c(E e2) {
        if (!this.f2909a) {
            S.a(this.f2910b, false);
        }
        e2.b((c) this);
    }

    public void d(E e2) {
        S.a(this.f2910b, true);
    }
}
