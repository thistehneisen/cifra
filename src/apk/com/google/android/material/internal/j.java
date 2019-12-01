package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: StateListAnimator */
class j extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f6485a;

    j(k kVar) {
        this.f6485a = kVar;
    }

    public void onAnimationEnd(Animator animator) {
        k kVar = this.f6485a;
        if (kVar.f6488c == animator) {
            kVar.f6488c = null;
        }
    }
}
