package com.touchin.vtb.viewcontrollers.startup;

import android.text.Editable;
import com.touchin.vtb.R;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.t reason: case insensitive filesystem */
/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C0700t extends i implements b<Editable, m> {
    final /* synthetic */ GetAccessConfirmSmsViewController this$0;

    C0700t(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.this$0 = getAccessConfirmSmsViewController;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Editable) obj);
        return m.f10346a;
    }

    public final void a(Editable editable) {
        h.b(editable, "it");
        Editable text = this.this$0.editText.getText();
        h.a((Object) text, "editText.text");
        if (!n.a(text)) {
            this.this$0.progressButton.setVisibility(0);
            return;
        }
        this.this$0.progressButton.setVisibility(8);
        this.this$0.editText.setBackground(this.this$0.getDrawable(R.drawable.common_startup_edit_text_selector));
    }
}
