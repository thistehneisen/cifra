package c.b.a.c.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;
import c.b.a.c.d.f.a;
import c.b.a.c.d.f.d;

/* compiled from: CircularRevealCompat */
public final class b {
    public static Animator a(f fVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(fVar, c.b.a.c.d.f.b.f3139a, a.f3137a, new d[]{new d(f2, f3, f4)});
        if (VERSION.SDK_INT < 21) {
            return ofObject;
        }
        d revealInfo = fVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) fVar, (int) f2, (int) f3, revealInfo.f3143c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofObject, createCircularReveal});
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static AnimatorListener a(f fVar) {
        return new a(fVar);
    }
}
