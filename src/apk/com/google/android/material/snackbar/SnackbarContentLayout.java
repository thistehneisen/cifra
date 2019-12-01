package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.g.i.B;
import c.b.a.c.d;
import c.b.a.c.f;
import c.b.a.c.k;

public class SnackbarContentLayout extends LinearLayout implements n {

    /* renamed from: a reason: collision with root package name */
    private TextView f6513a;

    /* renamed from: b reason: collision with root package name */
    private Button f6514b;

    /* renamed from: c reason: collision with root package name */
    private int f6515c;

    /* renamed from: d reason: collision with root package name */
    private int f6516d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    private boolean a(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.f6513a.getPaddingTop() == i3 && this.f6513a.getPaddingBottom() == i4) {
            return z;
        }
        a((View) this.f6513a, i3, i4);
        return true;
    }

    public void b(int i2, int i3) {
        this.f6513a.setAlpha(1.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.f6513a.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f6514b.getVisibility() == 0) {
            this.f6514b.setAlpha(1.0f);
            this.f6514b.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    public Button getActionView() {
        return this.f6514b;
    }

    public TextView getMessageView() {
        return this.f6513a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6513a = (TextView) findViewById(f.snackbar_text);
        this.f6514b = (Button) findViewById(f.snackbar_action);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0062;
     */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f6515c > 0) {
            int measuredWidth = getMeasuredWidth();
            int i4 = this.f6515c;
            if (measuredWidth > i4) {
                i2 = MeasureSpec.makeMeasureSpec(i4, 1073741824);
                super.onMeasure(i2, i3);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        boolean z = true;
        boolean z2 = this.f6513a.getLayout().getLineCount() > 1;
        if (!z2 || this.f6516d <= 0 || this.f6514b.getMeasuredWidth() <= this.f6516d) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        z = false;
        if (z) {
            super.onMeasure(i2, i3);
        }
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.SnackbarLayout);
        this.f6515c = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_android_maxWidth, -1);
        this.f6516d = obtainStyledAttributes.getDimensionPixelSize(k.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i2, int i3) {
        if (B.E(view)) {
            B.a(view, B.q(view), i2, B.p(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    public void a(int i2, int i3) {
        this.f6513a.setAlpha(0.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.f6513a.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f6514b.getVisibility() == 0) {
            this.f6514b.setAlpha(0.0f);
            this.f6514b.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }
}
