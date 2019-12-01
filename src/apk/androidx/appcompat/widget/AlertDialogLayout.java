package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.appcompat.widget.O.a;
import b.a.f;
import b.g.i.B;
import b.g.i.C0243d;

public class AlertDialogLayout extends O {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    private void b(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private static int c(View view) {
        int n = B.n(view);
        if (n > 0) {
            return n;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void e(int i2, int i3) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i5 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                    aVar.height = i5;
                }
            }
        }
    }

    private boolean f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i3;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == f.topPanel) {
                    view = childAt;
                } else if (id == f.buttonPanel) {
                    view2 = childAt;
                } else if ((id != f.contentPanel && id != f.customPanel) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = MeasureSpec.getMode(i3);
        int size = MeasureSpec.getSize(i3);
        int mode2 = MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i9, 0);
            paddingTop += view.getMeasuredHeight();
            i4 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i4 = 0;
        }
        if (view2 != null) {
            view2.measure(i9, 0);
            i6 = c(view2);
            i5 = view2.getMeasuredHeight() - i6;
            paddingTop += i6;
            i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
        }
        if (view3 != null) {
            if (mode == 0) {
                i8 = 0;
            } else {
                i8 = MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode);
            }
            view3.measure(i9, i8);
            i7 = view3.getMeasuredHeight();
            paddingTop += i7;
            i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
        } else {
            i7 = 0;
        }
        int i12 = size - paddingTop;
        if (view2 != null) {
            int i13 = paddingTop - i6;
            int min = Math.min(i12, i5);
            if (min > 0) {
                i12 -= min;
                i6 += min;
            }
            view2.measure(i9, MeasureSpec.makeMeasureSpec(i6, 1073741824));
            paddingTop = i13 + view2.getMeasuredHeight();
            i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
        }
        if (view3 != null && i12 > 0) {
            int i14 = paddingTop - i7;
            view3.measure(i9, MeasureSpec.makeMeasureSpec(i7 + i12, mode));
            paddingTop = i14 + view3.getMeasuredHeight();
            i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
        }
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt2 = getChildAt(i16);
            if (childAt2.getVisibility() != 8) {
                i15 = Math.max(i15, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i15 + getPaddingLeft() + getPaddingRight(), i9, i4), View.resolveSizeAndState(paddingTop, i10, 0));
        if (mode2 != 1073741824) {
            e(childCount, i10);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int paddingLeft = getPaddingLeft();
        int i11 = i4 - i2;
        int paddingRight = i11 - getPaddingRight();
        int paddingRight2 = (i11 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i12 = gravity & 112;
        int i13 = gravity & 8388615;
        if (i12 == 16) {
            i6 = getPaddingTop() + (((i5 - i3) - measuredHeight) / 2);
        } else if (i12 != 80) {
            i6 = getPaddingTop();
        } else {
            i6 = ((getPaddingTop() + i5) - i3) - measuredHeight;
        }
        Drawable dividerDrawable = getDividerDrawable();
        if (dividerDrawable == null) {
            i7 = 0;
        } else {
            i7 = dividerDrawable.getIntrinsicHeight();
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                a aVar = (a) childAt.getLayoutParams();
                int i15 = aVar.f851b;
                if (i15 < 0) {
                    i15 = i13;
                }
                int a2 = C0243d.a(i15, B.m(this)) & 7;
                if (a2 == 1) {
                    i10 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + aVar.leftMargin;
                    i9 = aVar.rightMargin;
                } else if (a2 != 5) {
                    i8 = aVar.leftMargin + paddingLeft;
                    if (b(i14)) {
                        i6 += i7;
                    }
                    int i16 = i6 + aVar.topMargin;
                    b(childAt, i8, i16, measuredWidth, measuredHeight2);
                    i6 = i16 + measuredHeight2 + aVar.bottomMargin;
                } else {
                    i10 = paddingRight - measuredWidth;
                    i9 = aVar.rightMargin;
                }
                i8 = i10 - i9;
                if (b(i14)) {
                }
                int i162 = i6 + aVar.topMargin;
                b(childAt, i8, i162, measuredWidth, measuredHeight2);
                i6 = i162 + measuredHeight2 + aVar.bottomMargin;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!f(i2, i3)) {
            super.onMeasure(i2, i3);
        }
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
