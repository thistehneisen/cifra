package c.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.recyclerview.widget.RecyclerView.x;

/* compiled from: ItemTouchHelperExtension */
class d extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f3189a;

    d(k kVar) {
        this.f3189a = kVar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f3189a.r.clear();
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        k kVar = this.f3189a;
        if (kVar.f3199e != null) {
            kVar.o.a(kVar.t, this.f3189a.f3199e);
        }
        k kVar2 = this.f3189a;
        x xVar = kVar2.f3199e;
        if (xVar != null) {
            kVar2.f3196b.remove(xVar.itemView);
        }
        k kVar3 = this.f3189a;
        kVar3.a(kVar3.f3199e, true);
        k kVar4 = this.f3189a;
        kVar4.f3199e = kVar4.f3198d;
    }
}
