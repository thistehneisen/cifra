package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: CircularProgressDrawable */
class c implements AnimatorListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ a f2081a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ d f2082b;

    c(d dVar, a aVar) {
        this.f2082b = dVar;
        this.f2081a = aVar;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.f2082b.a(1.0f, this.f2081a, true);
        this.f2081a.l();
        this.f2081a.j();
        d dVar = this.f2082b;
        if (dVar.f2091i) {
            dVar.f2091i = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            this.f2081a.a(false);
            return;
        }
        dVar.f2090h += 1.0f;
    }

    public void onAnimationStart(Animator animator) {
        this.f2082b.f2090h = 0.0f;
    }
}
