package com.touchin.vtb.a.c;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import kotlin.e.b.h;

/* compiled from: TaskInfoViewHolder.kt */
public final class i implements AnimationListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ m f6923a;

    i(m mVar) {
        this.f6923a = mVar;
    }

    public void onAnimationEnd(Animation animation) {
        h.b(animation, "animation");
        boolean z = true;
        int i2 = 0;
        if (this.f6923a.f6930i.getVisibility() == 0) {
            View b2 = this.f6923a.b();
            if (this.f6923a.f6930i.getVisibility() != 0) {
                z = false;
            }
            if (z) {
                i2 = 4;
            }
            b2.setVisibility(i2);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        h.b(animation, "animation");
    }

    public void onAnimationStart(Animation animation) {
        h.b(animation, "animation");
        boolean z = true;
        int i2 = 0;
        if (!(this.f6923a.f6930i.getVisibility() == 0)) {
            View b2 = this.f6923a.b();
            if (this.f6923a.f6930i.getVisibility() != 0) {
                z = false;
            }
            if (z) {
                i2 = 4;
            }
            b2.setVisibility(i2);
        }
    }
}
