package com.touchin.vtb.views.maskededittext;

import android.view.View;
import android.view.View.OnFocusChangeListener;

/* compiled from: MaskedEditText.kt */
final class f implements OnFocusChangeListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ MaskedEditText f7835a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ OnFocusChangeListener f7836b;

    f(MaskedEditText maskedEditText, OnFocusChangeListener onFocusChangeListener) {
        this.f7835a = maskedEditText;
        this.f7836b = onFocusChangeListener;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f7836b.onFocusChange(view, z);
        if (z) {
            this.f7835a.p = false;
            MaskedEditText maskedEditText = this.f7835a;
            maskedEditText.setSelection(maskedEditText.e());
        }
    }
}
