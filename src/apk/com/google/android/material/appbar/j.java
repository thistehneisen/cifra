package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import c.b.a.c.b;
import c.b.a.c.g;
import com.google.android.material.internal.l;

/* compiled from: ViewUtilsLollipop */
class j {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f6299a = {16843848};

    static void a(View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void a(View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray a2 = l.a(context, attributeSet, f6299a, i2, i3, new int[0]);
        try {
            if (a2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, a2.getResourceId(0, 0)));
            }
        } finally {
            a2.recycle();
        }
    }

    static void a(View view, float f2) {
        int integer = view.getResources().getInteger(g.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        String str = "elevation";
        long j2 = (long) integer;
        stateListAnimator.addState(new int[]{16842766, b.state_liftable, -b.state_lifted}, ObjectAnimator.ofFloat(view, str, new float[]{0.0f}).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, str, new float[]{f2}).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, str, new float[]{0.0f}).setDuration(0));
        view.setStateListAnimator(stateListAnimator);
    }
}
