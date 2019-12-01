package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton */
public class n extends ImageButton {

    /* renamed from: a reason: collision with root package name */
    private int f6494a;

    public n(Context context) {
        this(context, null);
    }

    public final void a(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f6494a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f6494a;
    }

    public void setVisibility(int i2) {
        a(i2, true);
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6494a = getVisibility();
    }
}
