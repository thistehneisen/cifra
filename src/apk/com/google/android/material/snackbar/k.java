package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BaseTransientBottomBar */
class k extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6528a;

    k(BaseTransientBottomBar baseTransientBottomBar) {
        this.f6528a = baseTransientBottomBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6528a.j();
    }

    public void onAnimationStart(Animator animator) {
        this.f6528a.f6501g.a(70, 180);
    }
}
