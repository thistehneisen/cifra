package g.a.a.a;

import android.view.View;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* compiled from: BaseItemAnimator */
class f extends e {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f8392a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ K f8393b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ View f8394c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ g f8395d;

    f(g gVar, a aVar, K k2, View view) {
        this.f8395d = gVar;
        this.f8392a = aVar;
        this.f8393b = k2;
        this.f8394c = view;
        super(null);
    }

    public void b(View view) {
        this.f8393b.a((L) null);
        B.a(this.f8394c, 1.0f);
        B.j(this.f8394c, 0.0f);
        B.k(this.f8394c, 0.0f);
        this.f8395d.a(this.f8392a.f8402b, false);
        this.f8395d.r.remove(this.f8392a.f8402b);
        this.f8395d.j();
    }

    public void c(View view) {
        this.f8395d.b(this.f8392a.f8402b, false);
    }
}
