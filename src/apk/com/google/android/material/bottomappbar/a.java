package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BottomAppBar */
class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ BottomAppBar f6333a;

    a(BottomAppBar bottomAppBar) {
        this.f6333a = bottomAppBar;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6333a.f6324e = null;
    }
}
