package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import c.b.a.c.j.b;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import com.google.android.material.internal.n;
import java.util.ArrayList;

/* compiled from: FloatingActionButtonImplLollipop */
class f extends e {
    private InsetDrawable I;

    /* compiled from: FloatingActionButtonImplLollipop */
    static class a extends GradientDrawable {
        a() {
        }

        public boolean isStateful() {
            return true;
        }
    }

    f(n nVar, b bVar) {
        super(nVar, bVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(ColorStateList colorStateList, Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        this.q = androidx.core.graphics.drawable.a.i(a());
        androidx.core.graphics.drawable.a.a(this.q, colorStateList);
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(this.q, mode);
        }
        if (i2 > 0) {
            this.s = a(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{this.s, this.q});
        } else {
            this.s = null;
            drawable = this.q;
        }
        this.r = new RippleDrawable(c.b.a.c.i.a.a(colorStateList2), drawable, null);
        Drawable drawable2 = this.r;
        this.t = drawable2;
        this.C.a(drawable2);
    }

    /* access modifiers changed from: 0000 */
    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(c.b.a.c.i.a.a(colorStateList));
        } else {
            super.b(colorStateList);
        }
    }

    public float c() {
        return this.B.getElevation();
    }

    /* access modifiers changed from: 0000 */
    public void j() {
    }

    /* access modifiers changed from: 0000 */
    public c k() {
        return new d();
    }

    /* access modifiers changed from: 0000 */
    public GradientDrawable l() {
        return new a();
    }

    /* access modifiers changed from: 0000 */
    public void n() {
        s();
    }

    /* access modifiers changed from: 0000 */
    public boolean q() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public void b(Rect rect) {
        if (this.C.a()) {
            InsetDrawable insetDrawable = new InsetDrawable(this.r, rect.left, rect.top, rect.right, rect.bottom);
            this.I = insetDrawable;
            this.C.a(this.I);
            return;
        }
        this.C.a(this.r);
    }

    /* access modifiers changed from: 0000 */
    public void a(float f2, float f3, float f4) {
        if (VERSION.SDK_INT == 21) {
            this.B.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(e.f6431b, a(f2, f4));
            stateListAnimator.addState(e.f6432c, a(f2, f3));
            stateListAnimator.addState(e.f6433d, a(f2, f3));
            stateListAnimator.addState(e.f6434e, a(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.B, "elevation", new float[]{f2}).setDuration(0));
            int i2 = VERSION.SDK_INT;
            if (i2 >= 22 && i2 <= 24) {
                n nVar = this.B;
                arrayList.add(ObjectAnimator.ofFloat(nVar, View.TRANSLATION_Z, new float[]{nVar.getTranslationZ()}).setDuration(100));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(e.f6430a);
            stateListAnimator.addState(e.f6435f, animatorSet);
            stateListAnimator.addState(e.f6436g, a(0.0f, 0.0f));
            this.B.setStateListAnimator(stateListAnimator);
        }
        if (this.C.a()) {
            s();
        }
    }

    private Animator a(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.B, "elevation", new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.B, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(e.f6430a);
        return animatorSet;
    }

    /* access modifiers changed from: 0000 */
    public void a(int[] iArr) {
        if (VERSION.SDK_INT != 21) {
            return;
        }
        if (this.B.isEnabled()) {
            this.B.setElevation(this.u);
            if (this.B.isPressed()) {
                this.B.setTranslationZ(this.w);
            } else if (this.B.isFocused() || this.B.isHovered()) {
                this.B.setTranslationZ(this.v);
            } else {
                this.B.setTranslationZ(0.0f);
            }
        } else {
            this.B.setElevation(0.0f);
            this.B.setTranslationZ(0.0f);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(Rect rect) {
        if (this.C.a()) {
            float b2 = this.C.b();
            float c2 = c() + this.w;
            int ceil = (int) Math.ceil((double) c.b.a.c.j.a.a(c2, b2, false));
            int ceil2 = (int) Math.ceil((double) c.b.a.c.j.a.b(c2, b2, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }
}
