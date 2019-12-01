package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.R;
import com.touchin.vtb.g.e;
import kotlin.e.a.a;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.y reason: case insensitive filesystem */
/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C0705y extends i implements a<m> {
    final /* synthetic */ GetAccessConfirmSmsViewController this$0;

    C0705y(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.this$0 = getAccessConfirmSmsViewController;
        super(0);
    }

    public final void b() {
        if (h.a((Object) this.this$0.repeatTextView.getText(), (Object) this.this$0.getString(R.string.common_registration_code_resend_button_title))) {
            this.this$0.repeatTextView.setText(this.this$0.getString(R.string.common_registration_code_sent_button_title));
            this.this$0.startTimer();
            if (((e) this.this$0.getState()).n()) {
                if (((e) this.this$0.getState()).s().length() > 0) {
                    com.touchin.vtb.h.c.m access$getViewModel$p = this.this$0.viewModel;
                    String q = ((e) this.this$0.getState()).q();
                    if (q == null) {
                        q = "";
                    }
                    access$getViewModel$p.b(q);
                    return;
                }
            }
            this.this$0.viewModel.a(((e) this.this$0.getState()).o(), ((e) this.this$0.getState()).s(), ((e) this.this$0.getState()).u(), ((e) this.this$0.getState()).q());
        }
    }
}
