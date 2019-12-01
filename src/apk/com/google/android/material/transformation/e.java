package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import c.b.a.c.d.f;

/* compiled from: FabTransformationBehavior */
class e extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f6623a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Drawable f6624b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f6625c;

    e(FabTransformationBehavior fabTransformationBehavior, f fVar, Drawable drawable) {
        this.f6625c = fabTransformationBehavior;
        this.f6623a = fVar;
        this.f6624b = drawable;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6623a.setCircularRevealOverlayDrawable(null);
    }

    public void onAnimationStart(Animator animator) {
        this.f6623a.setCircularRevealOverlayDrawable(this.f6624b);
    }
}
