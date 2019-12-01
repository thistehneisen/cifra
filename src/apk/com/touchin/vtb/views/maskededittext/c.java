package com.touchin.vtb.views.maskededittext;

import android.view.View;
import android.view.View.OnClickListener;
import l.a.d.a.b.a.b;

/* compiled from: FocusawarePhoneMaskedEditText.kt */
final class c implements OnClickListener {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ FocusawarePhoneMaskedEditText f7832a;

    c(FocusawarePhoneMaskedEditText focusawarePhoneMaskedEditText) {
        this.f7832a = focusawarePhoneMaskedEditText;
    }

    public final void onClick(View view) {
        this.f7832a.f7817d.setVisibility(0);
        this.f7832a.f7819f.setVisibility(8);
        this.f7832a.f7819f.setEnabled(false);
        this.f7832a.f7818e.setEnabled(true);
        this.f7832a.f7818e.setHint("0000000000");
        this.f7832a.f7818e.setMask("+7 (###) ### – ## – ##");
        this.f7832a.f7818e.setHintVisible(true);
        b.b(this.f7832a.f7818e);
        this.f7832a.getOnClickAction().b();
    }
}
