package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ExpandableTransformationBehavior */
class b extends AnimatorListenerAdapter {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ ExpandableTransformationBehavior f6616a;

    b(ExpandableTransformationBehavior expandableTransformationBehavior) {
        this.f6616a = expandableTransformationBehavior;
    }

    public void onAnimationEnd(Animator animator) {
        this.f6616a.f6602b = null;
    }
}
