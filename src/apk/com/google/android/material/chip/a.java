package com.google.android.material.chip;

import android.graphics.Typeface;

/* compiled from: Chip */
class a extends b.g.a.a.h.a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Chip f6390a;

    a(Chip chip) {
        this.f6390a = chip;
    }

    public void a(int i2) {
    }

    public void a(Typeface typeface) {
        Chip chip = this.f6390a;
        chip.setText(chip.getText());
        this.f6390a.requestLayout();
        this.f6390a.invalidate();
    }
}
