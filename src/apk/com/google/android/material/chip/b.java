package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: Chip */
class b extends ViewOutlineProvider {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Chip f6391a;

    b(Chip chip) {
        this.f6391a = chip;
    }

    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        if (this.f6391a.f6371e != null) {
            this.f6391a.f6371e.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
