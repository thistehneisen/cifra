package com.touchin.vtb.views.focus_edit_text;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import kotlin.e.b.h;

/* compiled from: FocusawareEditText.kt */
final class c implements OnFocusChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ FocusawareEditText f7806a;

    c(FocusawareEditText focusawareEditText) {
        this.f7806a = focusawareEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.f7806a.f7794f.setVisibility(0);
            this.f7806a.f7796h.setText(this.f7806a.o);
            this.f7806a.f7796h.setTextColor(this.f7806a.f7798j);
            this.f7806a.getOnFocusAction().b();
            return;
        }
        Editable text = this.f7806a.f7795g.getText();
        h.a((Object) text, "editText.text");
        if (n.a(text)) {
            this.f7806a.f7794f.setVisibility(4);
            this.f7806a.f7796h.setText(this.f7806a.f7794f.getText());
            this.f7806a.f7796h.setTextColor(this.f7806a.f7799k);
            return;
        }
        this.f7806a.f7796h.setTextColor(this.f7806a.f7798j);
    }
}
