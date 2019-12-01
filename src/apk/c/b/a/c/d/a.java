package c.b.a.c.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: CircularRevealCompat */
class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f3133a;

    a(f fVar) {
        this.f3133a = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f3133a.b();
    }

    public void onAnimationStart(Animator animator) {
        this.f3133a.a();
    }
}
