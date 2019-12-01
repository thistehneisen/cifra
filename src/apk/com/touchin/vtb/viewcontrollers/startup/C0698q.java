package com.touchin.vtb.viewcontrollers.startup;

import com.touchin.vtb.R;
import com.touchin.vtb.utils.h;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* renamed from: com.touchin.vtb.viewcontrollers.startup.q reason: case insensitive filesystem */
/* compiled from: EnterPinViewController.kt */
final class C0698q extends i implements a<m> {
    final /* synthetic */ EnterPinViewController this$0;

    C0698q(EnterPinViewController enterPinViewController) {
        this.this$0 = enterPinViewController;
        super(0);
    }

    public final void b() {
        h.a(h.f7619a, this.this$0.getActivity(), this.this$0.getString(R.string.common_pin_code_forget_pin_title), this.this$0.getString(R.string.common_pin_code_forget_pin_description), this.this$0.getString(R.string.common_more_logout), this.this$0.getString(R.string.common_global_cancellation), new C0697p(this), null, false, 0, 448, null);
    }
}
