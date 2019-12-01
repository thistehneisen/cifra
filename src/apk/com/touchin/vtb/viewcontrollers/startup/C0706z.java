package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.g.e;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.z reason: case insensitive filesystem */
/* compiled from: GetAccessConfirmSmsViewController.kt */
final class C0706z extends i implements a<m> {
    final /* synthetic */ GetAccessConfirmSmsViewController this$0;

    C0706z(GetAccessConfirmSmsViewController getAccessConfirmSmsViewController) {
        this.this$0 = getAccessConfirmSmsViewController;
        super(0);
    }

    public final void b() {
        com.touchin.vtb.h.c.m access$getViewModel$p = this.this$0.viewModel;
        String q = ((e) this.this$0.getState()).q();
        if (q == null) {
            q = "";
        }
        access$getViewModel$p.a(q, this.this$0.editText.getText().toString());
    }
}
