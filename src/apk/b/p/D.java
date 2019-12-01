package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: Transition */
class D extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ E f2808a;

    D(E e2) {
        this.f2808a = e2;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2808a.a();
        animator.removeListener(this);
    }
}
