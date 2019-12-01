package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import b.g.i.B;
import b.g.i.L;
import b.g.i.M;

/* compiled from: AppCompatDelegateImpl */
class z extends M {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f542a;

    z(c cVar) {
        this.f542a = cVar;
    }

    public void b(View view) {
        y.this.q.setVisibility(8);
        y yVar = y.this;
        PopupWindow popupWindow = yVar.r;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else if (yVar.q.getParent() instanceof View) {
            B.H((View) y.this.q.getParent());
        }
        y.this.q.removeAllViews();
        y.this.t.a((L) null);
        y.this.t = null;
    }
}
