package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import b.g.i.C0240a;
import b.g.i.a.d;

/* compiled from: CheckableImageButton */
class a extends C0240a {

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ CheckableImageButton f6453d;

    a(CheckableImageButton checkableImageButton) {
        this.f6453d = checkableImageButton;
    }

    public void a(View view, d dVar) {
        super.a(view, dVar);
        dVar.b(true);
        dVar.c(this.f6453d.isChecked());
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.f6453d.isChecked());
    }
}
