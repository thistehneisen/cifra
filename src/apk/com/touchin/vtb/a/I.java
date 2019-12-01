package com.touchin.vtb.a;

import androidx.recyclerview.widget.C0232s.c;
import com.touchin.vtb.api.PaymentInfo;
import kotlin.e.b.h;

/* compiled from: TaxesAdapter.kt */
public final class I extends c<PaymentInfo> {
    I() {
    }

    public boolean a(PaymentInfo paymentInfo, PaymentInfo paymentInfo2) {
        h.b(paymentInfo, "oldItem");
        h.b(paymentInfo2, "newItem");
        return h.a((Object) paymentInfo, (Object) paymentInfo2);
    }

    public boolean b(PaymentInfo paymentInfo, PaymentInfo paymentInfo2) {
        h.b(paymentInfo, "oldItem");
        h.b(paymentInfo2, "newItem");
        return h.a((Object) paymentInfo.d(), (Object) paymentInfo2.d());
    }
}
