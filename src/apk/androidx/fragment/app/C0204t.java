package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.t reason: case insensitive filesystem */
/* compiled from: FragmentManagerImpl */
class C0204t extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewGroup f1552a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f1553b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Fragment f1554c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0207w f1555d;

    C0204t(C0207w wVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1555d = wVar;
        this.f1552a = viewGroup;
        this.f1553b = view;
        this.f1554c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1552a.endViewTransition(this.f1553b);
        Animator animator2 = this.f1554c.getAnimator();
        this.f1554c.setAnimator(null);
        if (animator2 != null && this.f1552a.indexOfChild(this.f1553b) < 0) {
            C0207w wVar = this.f1555d;
            Fragment fragment = this.f1554c;
            wVar.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
