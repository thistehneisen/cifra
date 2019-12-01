package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import b.g.i.B;
import b.g.i.C0246g;
import c.b.a.c.k;

/* compiled from: FlowLayout */
public class g extends ViewGroup {

    /* renamed from: a reason: collision with root package name */
    private int f6481a;

    /* renamed from: b reason: collision with root package name */
    private int f6482b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6483c;

    public g(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, k.FlowLayout, 0, 0);
        this.f6481a = obtainStyledAttributes.getDimensionPixelSize(k.FlowLayout_lineSpacing, 0);
        this.f6482b = obtainStyledAttributes.getDimensionPixelSize(k.FlowLayout_itemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.f6482b;
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.f6481a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (getChildCount() != 0) {
            boolean z2 = true;
            if (B.m(this) != 1) {
                z2 = false;
            }
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i8 = (i4 - i2) - paddingLeft;
            int i9 = paddingRight;
            int i10 = paddingTop;
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof MarginLayoutParams) {
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        i6 = C0246g.b(marginLayoutParams);
                        i7 = C0246g.a(marginLayoutParams);
                    } else {
                        i7 = 0;
                        i6 = 0;
                    }
                    int measuredWidth = i9 + i6 + childAt.getMeasuredWidth();
                    if (!this.f6483c && measuredWidth > i8) {
                        i10 = paddingTop + this.f6481a;
                        i9 = paddingRight;
                    }
                    int i12 = i9 + i6;
                    int measuredWidth2 = childAt.getMeasuredWidth() + i12;
                    int measuredHeight = childAt.getMeasuredHeight() + i10;
                    if (z2) {
                        childAt.layout(i8 - measuredWidth2, i10, (i8 - i9) - i6, measuredHeight);
                    } else {
                        childAt.layout(i12, i10, measuredWidth2, measuredHeight);
                    }
                    i9 += i6 + i7 + childAt.getMeasuredWidth() + this.f6482b;
                    paddingTop = measuredHeight;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int size = MeasureSpec.getSize(i2);
        int mode = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i3);
        int mode2 = MeasureSpec.getMode(i3);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingRight = i6 - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = paddingTop;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                int i10 = i2;
                int i11 = i3;
            } else {
                measureChild(childAt, i2, i3);
                LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin + 0;
                    i4 = marginLayoutParams.rightMargin + 0;
                } else {
                    i5 = 0;
                    i4 = 0;
                }
                int i12 = paddingLeft;
                if (paddingLeft + i5 + childAt.getMeasuredWidth() > paddingRight && !a()) {
                    i7 = this.f6481a + paddingTop;
                    i12 = getPaddingLeft();
                }
                int measuredWidth = i12 + i5 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                if (measuredWidth > i8) {
                    i8 = measuredWidth;
                }
                paddingTop = measuredHeight;
                paddingLeft = i12 + i5 + i4 + childAt.getMeasuredWidth() + this.f6482b;
            }
        }
        setMeasuredDimension(a(size, mode, i8), a(size2, mode2, paddingTop));
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i2) {
        this.f6482b = i2;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i2) {
        this.f6481a = i2;
    }

    public void setSingleLine(boolean z) {
        this.f6483c = z;
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6483c = false;
        a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return this.f6483c;
    }

    @TargetApi(21)
    public g(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f6483c = false;
        a(context, attributeSet);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 != Integer.MIN_VALUE) {
            return i3 != 1073741824 ? i4 : i2;
        }
        return Math.min(i4, i2);
    }
}
