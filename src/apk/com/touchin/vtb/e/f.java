package com.touchin.vtb.e;

import com.touchin.vtb.api.PaymentSystem;

public final /* synthetic */ class f {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ int[] f7251a = new int[PaymentSystem.values().length];

    static {
        f7251a[PaymentSystem.AMERICAN_EXPRESS.ordinal()] = 1;
        f7251a[PaymentSystem.MAESTRO.ordinal()] = 2;
        f7251a[PaymentSystem.MASTERCARD.ordinal()] = 3;
        f7251a[PaymentSystem.VISA.ordinal()] = 4;
        f7251a[PaymentSystem.DINERS_CLUB.ordinal()] = 5;
        f7251a[PaymentSystem.JCB_INTERNATIONAL.ordinal()] = 6;
        f7251a[PaymentSystem.DISCOVER.ordinal()] = 7;
        f7251a[PaymentSystem.CHINA_UNIONPAY.ordinal()] = 8;
    }
}
