package com.touchin.vtb.views.maskededittext;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FocusawarePhoneMaskedEditText.kt */
final class b implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ FocusawarePhoneMaskedEditText f7831a;

    b(FocusawarePhoneMaskedEditText focusawarePhoneMaskedEditText) {
        this.f7831a = focusawarePhoneMaskedEditText;
    }

    public final void onClick(View view) {
        this.f7831a.getOnClickAction().b();
    }
}
