package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import b.g.i.B;
import java.util.List;

public abstract class ExpandableBehavior extends b<View> {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public int f6601a = 0;

    public ExpandableBehavior() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z, boolean z2);

    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        c.b.a.c.f.b bVar = (c.b.a.c.f.b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f6601a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* access modifiers changed from: protected */
    public c.b.a.c.f.b e(CoordinatorLayout coordinatorLayout, View view) {
        List b2 = coordinatorLayout.b(view);
        int size = b2.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = (View) b2.get(i2);
            if (a(coordinatorLayout, view, view2)) {
                return (c.b.a.c.f.b) view2;
            }
        }
        return null;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
        if (!B.C(view)) {
            c.b.a.c.f.b e2 = e(coordinatorLayout, view);
            if (e2 != null && a(e2.a())) {
                this.f6601a = e2.a() ? 1 : 2;
                view.getViewTreeObserver().addOnPreDrawListener(new a(this, view, this.f6601a, e2));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(boolean z) {
        boolean z2 = false;
        if (z) {
            int i2 = this.f6601a;
            if (i2 == 0 || i2 == 2) {
                z2 = true;
            }
            return z2;
        }
        if (this.f6601a == 1) {
            z2 = true;
        }
        return z2;
    }
}
