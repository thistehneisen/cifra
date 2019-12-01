package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.b.a.c.d.f.d;

/* compiled from: FabTransformationBehavior */
class f extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c.b.a.c.d.f f6626a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f6627b;

    f(FabTransformationBehavior fabTransformationBehavior, c.b.a.c.d.f fVar) {
        this.f6627b = fabTransformationBehavior;
        this.f6626a = fVar;
    }

    public void onAnimationEnd(Animator animator) {
        d revealInfo = this.f6626a.getRevealInfo();
        revealInfo.f3143c = Float.MAX_VALUE;
        this.f6626a.setRevealInfo(revealInfo);
    }
}
