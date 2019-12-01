package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: BaseTransientBottomBar */
class a extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ int f6517a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f6518b;

    a(BaseTransientBottomBar baseTransientBottomBar, int i2) {
        this.f6518b = baseTransientBottomBar;
        this.f6517a = i2;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6518b.c(this.f6517a);
    }

    public void onAnimationStart(Animator animator) {
        this.f6518b.f6501g.b(0, 180);
    }
}
