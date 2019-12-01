package b.g.i;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: ViewPropertyAnimatorCompat */
class I extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ L f2649a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f2650b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ K f2651c;

    I(K k2, L l2, View view) {
        this.f2651c = k2;
        this.f2649a = l2;
        this.f2650b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f2649a.a(this.f2650b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f2649a.b(this.f2650b);
    }

    public void onAnimationStart(Animator animator) {
        this.f2649a.c(this.f2650b);
    }
}
