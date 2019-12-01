package androidx.fragment.app;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: androidx.fragment.app.s reason: case insensitive filesystem */
/* compiled from: FragmentManagerImpl */
class C0203s implements AnimationListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ViewGroup f1549a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Fragment f1550b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ C0207w f1551c;

    C0203s(C0207w wVar, ViewGroup viewGroup, Fragment fragment) {
        this.f1551c = wVar;
        this.f1549a = viewGroup;
        this.f1550b = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1549a.post(new r(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
