package com.touchin.vtb.views.focus_edit_text;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FocusawareEditText.kt */
final class b implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ FocusawareEditText f7805a;

    b(FocusawareEditText focusawareEditText) {
        this.f7805a = focusawareEditText;
    }

    public final void onClick(View view) {
        this.f7805a.requestFocus();
        this.f7805a.getOnEditTextClickListener().b();
    }
}
