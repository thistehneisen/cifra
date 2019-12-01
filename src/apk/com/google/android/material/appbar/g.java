package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.e;
import b.g.e.a;
import b.g.i.B;
import b.g.i.C0243d;
import b.g.i.O;
import java.util.List;

/* compiled from: HeaderScrollingViewBehavior */
abstract class g extends h<View> {

    /* renamed from: d reason: collision with root package name */
    final Rect f6287d = new Rect();

    /* renamed from: e reason: collision with root package name */
    final Rect f6288e = new Rect();

    /* renamed from: f reason: collision with root package name */
    private int f6289f = 0;

    /* renamed from: g reason: collision with root package name */
    private int f6290g;

    public g() {
    }

    private static int c(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public abstract View a(List<View> list);

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        int i6 = view.getLayoutParams().height;
        if (i6 == -1 || i6 == -2) {
            View a2 = a(coordinatorLayout.b(view));
            if (a2 != null) {
                if (!B.j(a2) || B.j(view)) {
                    View view2 = view;
                } else {
                    View view3 = view;
                    B.a(view, true);
                    if (B.j(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i4);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.a(view, i2, i3, MeasureSpec.makeMeasureSpec((size - a2.getMeasuredHeight()) + c(a2), i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public abstract float b(View view);

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View a2 = a(coordinatorLayout.b(view));
        if (a2 != null) {
            e eVar = (e) view.getLayoutParams();
            Rect rect = this.f6287d;
            rect.set(coordinatorLayout.getPaddingLeft() + eVar.leftMargin, a2.getBottom() + eVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - eVar.rightMargin, ((coordinatorLayout.getHeight() + a2.getBottom()) - coordinatorLayout.getPaddingBottom()) - eVar.bottomMargin);
            O lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && B.j(coordinatorLayout) && !B.j(view)) {
                rect.left += lastWindowInsets.c();
                rect.right -= lastWindowInsets.d();
            }
            Rect rect2 = this.f6288e;
            C0243d.a(c(eVar.f1223c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int a3 = a(a2);
            view.layout(rect2.left, rect2.top - a3, rect2.right, rect2.bottom - a3);
            this.f6289f = rect2.top - a2.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i2);
        this.f6289f = 0;
    }

    /* access modifiers changed from: 0000 */
    public int c(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: 0000 */
    public final int d() {
        return this.f6289f;
    }

    public final int c() {
        return this.f6290g;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: 0000 */
    public final int a(View view) {
        if (this.f6290g == 0) {
            return 0;
        }
        float b2 = b(view);
        int i2 = this.f6290g;
        return a.a((int) (b2 * ((float) i2)), 0, i2);
    }

    public final void b(int i2) {
        this.f6290g = i2;
    }
}
