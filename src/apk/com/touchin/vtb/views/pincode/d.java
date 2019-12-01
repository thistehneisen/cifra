package com.touchin.vtb.views.pincode;

import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;

/* compiled from: PincodeView.kt */
final class d extends i implements a<m> {
    final /* synthetic */ PincodeView this$0;

    d(PincodeView pincodeView) {
        this.this$0 = pincodeView;
        super(0);
    }

    public final void b() {
        if (this.this$0.e()) {
            if (this.this$0.A.length() == 0) {
                a onFingerprintClickListener = this.this$0.getOnFingerprintClickListener();
                if (onFingerprintClickListener != null) {
                    m mVar = (m) onFingerprintClickListener.b();
                    return;
                }
                return;
            }
        }
        this.this$0.f();
    }
}
