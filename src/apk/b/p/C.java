package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import b.d.b;

/* compiled from: Transition */
class C extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ b f2806a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ E f2807b;

    C(E e2, b bVar) {
        this.f2807b = e2;
        this.f2806a = bVar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2806a.remove(animator);
        this.f2807b.A.remove(animator);
    }

    public void onAnimationStart(Animator animator) {
        this.f2807b.A.add(animator);
    }
}
