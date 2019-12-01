package com.touchin.vtb.views.focus_edit_text;

import com.touchin.vtb.views.focus_edit_text.FocusawareEditText.b;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: FocusawareEditText.kt */
final class d extends i implements a<m> {
    final /* synthetic */ FocusawareEditText this$0;

    d(FocusawareEditText focusawareEditText) {
        this.this$0 = focusawareEditText;
        super(0);
    }

    public final void b() {
        int i2;
        FocusawareEditText focusawareEditText = this.this$0;
        int inputType = focusawareEditText.f7795g.getInputType();
        if (inputType == b.PASSWORD.a()) {
            i2 = b.TEXT.a();
        } else if (inputType == b.TEXT.a()) {
            i2 = b.PASSWORD.a();
        } else {
            i2 = b.TEXT.a();
        }
        focusawareEditText.setInputType(i2);
        this.this$0.f7795g.setSelection(this.this$0.f7795g.length());
    }
}
