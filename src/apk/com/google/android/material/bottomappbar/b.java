package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BottomAppBar */
class b extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BottomAppBar f6334a;

    b(BottomAppBar bottomAppBar) {
        this.f6334a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6334a.f6325f = null;
    }
}
