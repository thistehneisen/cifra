package b.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: Visibility */
class ga extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Q f2882a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ View f2883b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ ha f2884c;

    ga(ha haVar, Q q, View view) {
        this.f2884c = haVar;
        this.f2882a = q;
        this.f2883b = view;
    }

    public void onAnimationEnd(Animator animator) {
        this.f2882a.b(this.f2883b);
    }
}
