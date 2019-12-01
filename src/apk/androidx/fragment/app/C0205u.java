package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.u reason: case insensitive filesystem */
/* compiled from: FragmentManagerImpl */
class C0205u extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewGroup f1556a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f1557b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ Fragment f1558c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ C0207w f1559d;

    C0205u(C0207w wVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1559d = wVar;
        this.f1556a = viewGroup;
        this.f1557b = view;
        this.f1558c = fragment;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1556a.endViewTransition(this.f1557b);
        animator.removeListener(this);
        Fragment fragment = this.f1558c;
        View view = fragment.mView;
        if (view != null && fragment.mHidden) {
            view.setVisibility(8);
        }
    }
}
