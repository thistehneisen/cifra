package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: HideBottomViewOnScrollBehavior */
class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ HideBottomViewOnScrollBehavior f6316a;

    a(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f6316a = hideBottomViewOnScrollBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6316a.f6302c = null;
    }
}
