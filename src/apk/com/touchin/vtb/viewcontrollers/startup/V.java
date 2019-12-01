package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.R;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: RegistrationConfirmSmsViewController.kt */
final class V extends i implements a<m> {
    final /* synthetic */ RegistrationConfirmSmsViewController this$0;

    V(RegistrationConfirmSmsViewController registrationConfirmSmsViewController) {
        this.this$0 = registrationConfirmSmsViewController;
        super(0);
    }

    public final void b() {
        if (h.a((Object) this.this$0.repeatTextView.getText(), (Object) this.this$0.getString(R.string.common_registration_code_resend_button_title))) {
            this.this$0.repeatTextView.setEnabled(false);
            this.this$0.viewModel.a(((com.touchin.vtb.g.h) this.this$0.getState()).p());
        }
    }
}
