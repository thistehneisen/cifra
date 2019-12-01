package com.touchin.vtb.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import kotlin.e.b.h;

/* compiled from: InterceptLinearLayout.kt */
public final class InterceptLinearLayout extends LinearLayout {

    /* renamed from: a reason: collision with root package name */
    private boolean f7751a;

    public InterceptLinearLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public InterceptLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ InterceptLinearLayout(Context context, AttributeSet attributeSet, int i2, int i3, e eVar) {
        if ((i3 & 2) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        this(context, attributeSet, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f7751a;
    }

    public final void setNeedToInterceptTouch(boolean z) {
        this.f7751a = z;
    }

    public InterceptLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        h.b(context, "context");
        super(context, attributeSet, i2);
    }
}
