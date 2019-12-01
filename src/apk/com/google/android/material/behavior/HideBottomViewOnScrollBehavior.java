package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import c.b.a.c.a.a;

public class HideBottomViewOnScrollBehavior<V extends View> extends b<V> {

    /* renamed from: a reason: collision with root package name */
    private int f6300a = 0;

    /* renamed from: b reason: collision with root package name */
    private int f6301b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public ViewPropertyAnimator f6302c;

    public HideBottomViewOnScrollBehavior() {
    }

    /* access modifiers changed from: protected */
    public void b(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6302c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f6301b = 2;
        a(v, 0, 225, a.f3094d);
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        return i2 == 2;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
        this.f6300a = v.getMeasuredHeight();
        return super.a(coordinatorLayout, v, i2);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        if (this.f6301b != 1 && i3 > 0) {
            a(v);
        } else if (this.f6301b != 2 && i3 < 0) {
            b(v);
        }
    }

    /* access modifiers changed from: protected */
    public void a(V v) {
        ViewPropertyAnimator viewPropertyAnimator = this.f6302c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f6301b = 1;
        a(v, this.f6300a, 175, a.f3093c);
    }

    private void a(V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f6302c = v.animate().translationY((float) i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a(this));
    }
}
