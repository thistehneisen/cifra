package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.R;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.s reason: case insensitive filesystem */
/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C0699s extends i implements a<m> {
    final /* synthetic */ GetAccessConfirmSmsViewController this$0;

    C0699s(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.this$0 = getAccessConfirmSmsViewController;
        super(0);
    }

    public final void b() {
        this.this$0.repeatTextView.setText(this.this$0.getString(R.string.common_registration_code_resend_button_title));
    }
}
