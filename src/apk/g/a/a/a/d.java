package g.a.a.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* compiled from: BaseItemAnimator */
class d extends e {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ x f8384a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f8385b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ int f8386c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ K f8387d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ g f8388e;

    d(g gVar, x xVar, int i2, int i3, K k2) {
        this.f8388e = gVar;
        this.f8384a = xVar;
        this.f8385b = i2;
        this.f8386c = i3;
        this.f8387d = k2;
        super(null);
    }

    public void a(View view) {
        if (this.f8385b != 0) {
            B.j(view, 0.0f);
        }
        if (this.f8386c != 0) {
            B.k(view, 0.0f);
        }
    }

    public void b(View view) {
        this.f8387d.a((L) null);
        this.f8388e.j(this.f8384a);
        this.f8388e.p.remove(this.f8384a);
        this.f8388e.j();
    }

    public void c(View view) {
        this.f8388e.k(this.f8384a);
    }
}
