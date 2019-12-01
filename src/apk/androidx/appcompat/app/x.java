package androidx.appcompat.app;

import android.view.View;
import b.g.i.B;
import b.g.i.L;
import b.g.i.M;

/* compiled from: AppCompatDelegateImpl */
class x extends M {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ y f506a;

    x(y yVar) {
        this.f506a = yVar;
    }

    public void b(View view) {
        this.f506a.q.setAlpha(1.0f);
        this.f506a.t.a((L) null);
        this.f506a.t = null;
    }

    public void c(View view) {
        this.f506a.q.setVisibility(0);
        this.f506a.q.sendAccessibilityEvent(32);
        if (this.f506a.q.getParent() instanceof View) {
            B.H((View) this.f506a.q.getParent());
        }
    }
}
