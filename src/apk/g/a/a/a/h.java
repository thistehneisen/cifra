package g.a.a.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;
import b.g.i.B;
import b.g.i.K;
import b.g.i.L;

/* compiled from: SlideInLeftAnimator */
public class h extends g {
    /* access modifiers changed from: protected */
    public void t(x xVar) {
        K a2 = B.a(xVar.itemView);
        a2.b(0.0f);
        a2.a(c());
        a2.a(this.s);
        a2.a((L) new b(xVar));
        a2.b(v(xVar));
        a2.c();
    }

    /* access modifiers changed from: protected */
    public void u(x xVar) {
        K a2 = B.a(xVar.itemView);
        a2.b((float) (-xVar.itemView.getRootView().getWidth()));
        a2.a(f());
        a2.a(this.s);
        a2.a((L) new c(xVar));
        a2.b(w(xVar));
        a2.c();
    }

    /* access modifiers changed from: protected */
    public void x(x xVar) {
        View view = xVar.itemView;
        B.j(view, (float) (-view.getRootView().getWidth()));
    }
}
