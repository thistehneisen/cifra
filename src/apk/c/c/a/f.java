package c.c.a;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.x;

/* compiled from: ItemTouchHelperExtension */
class f extends c {
    final /* synthetic */ int p;
    final /* synthetic */ x q;
    final /* synthetic */ k r;

    f(k kVar, x xVar, int i2, int i3, float f2, float f3, float f4, float f5, int i4, x xVar2) {
        this.r = kVar;
        this.p = i4;
        this.q = xVar2;
        super(xVar, i2, i3, f2, f3, f4, f5);
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.f3223l) {
            if (this.p <= 0) {
                k kVar = this.r;
                kVar.o.a(kVar.t, this.q);
            } else {
                this.r.f3196b.add(this.q.itemView);
                k kVar2 = this.r;
                kVar2.f3199e = this.q;
                this.f3220i = true;
                int i2 = this.p;
                if (i2 > 0) {
                    kVar2.a((c) this, i2);
                }
            }
            View e2 = this.r.z;
            View view = this.q.itemView;
            if (e2 == view) {
                this.r.c(view);
            }
        }
    }
}
