package com.touchin.vtb.views.focus_edit_text;

import android.text.Editable;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: FocusawareEditText.kt */
final class a extends i implements b<Editable, m> {
    final /* synthetic */ FocusawareEditText this$0;

    a(FocusawareEditText focusawareEditText) {
        this.this$0 = focusawareEditText;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Editable) obj);
        return m.f10346a;
    }

    public final void a(Editable editable) {
        h.b(editable, "editable");
        this.this$0.f7796h.setVisibility(n.a(editable) ? 0 : 8);
    }
}
