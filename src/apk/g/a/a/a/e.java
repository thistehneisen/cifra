package g.a.a.a;

import android.view.View;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* compiled from: BaseItemAnimator */
class e extends e {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f8389a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ K f8390b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ g f8391c;

    e(g gVar, a aVar, K k2) {
        this.f8391c = gVar;
        this.f8389a = aVar;
        this.f8390b = k2;
        super(null);
    }

    public void b(View view) {
        this.f8390b.a((L) null);
        B.a(view, 1.0f);
        B.j(view, 0.0f);
        B.k(view, 0.0f);
        this.f8391c.a(this.f8389a.f8401a, true);
        this.f8391c.r.remove(this.f8389a.f8401a);
        this.f8391c.j();
    }

    public void c(View view) {
        this.f8391c.b(this.f8389a.f8401a, true);
    }
}
