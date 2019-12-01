package com.touchin.vtb.e;

import com.touchin.vtb.R;
import com.touchin.vtb.api.PaymentSystem;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e.b.h;

/* compiled from: PaymentSystem.kt */
public final class g {
    public static final int a(PaymentSystem paymentSystem) {
        h.b(paymentSystem, "$this$getLogoResId");
        switch (f.f7251a[paymentSystem.ordinal()]) {
            case 1:
                return R.drawable.common_logo_american_express;
            case 2:
                return R.drawable.common_logo_maestro;
            case 3:
                return R.drawable.common_logo_mastercard;
            case 4:
                return R.drawable.common_logo_visa;
            case 5:
                return R.drawable.common_logo_diners_club;
            case 6:
                return R.drawable.common_logo_jcb_international;
            case 7:
                return R.drawable.common_logo_discover;
            case 8:
                return R.drawable.common_logo_china_unionpay;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
