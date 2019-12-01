package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.r;
import b.a.a;
import b.g.i.B;
import b.g.i.C0240a;

public class CheckableImageButton extends r implements Checkable {

    /* renamed from: c reason: collision with root package name */
    private static final int[] f6451c = {16842912};

    /* renamed from: d reason: collision with root package name */
    private boolean f6452d;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public boolean isChecked() {
        return this.f6452d;
    }

    public int[] onCreateDrawableState(int i2) {
        if (this.f6452d) {
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + f6451c.length), f6451c);
        }
        return super.onCreateDrawableState(i2);
    }

    public void setChecked(boolean z) {
        if (this.f6452d != z) {
            this.f6452d = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void toggle() {
        setChecked(!this.f6452d);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        B.a((View) this, (C0240a) new a(this));
    }
}
