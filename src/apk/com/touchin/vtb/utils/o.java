package com.touchin.vtb.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.m;

/* compiled from: SimpleAnimatorListener.kt */
public final class o implements AnimatorListener {

    /* renamed from: a reason: collision with root package name */
    private final a<m> f7629a;

    /* renamed from: b reason: collision with root package name */
    private final a<m> f7630b;

    public o(a<m> aVar, a<m> aVar2) {
        h.b(aVar, "onAnimationStartAction");
        h.b(aVar2, "onAnimationEndAction");
        this.f7629a = aVar;
        this.f7630b = aVar2;
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f7630b.b();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
        this.f7629a.b();
    }
}
