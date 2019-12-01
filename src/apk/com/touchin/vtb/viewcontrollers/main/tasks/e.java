package com.touchin.vtb.viewcontrollers.main.tasks;

import com.touchin.vtb.api.TaxPaymentStatus;

public final /* synthetic */ class e {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ int[] f7665a = new int[TaxPaymentStatus.values().length];

    static {
        f7665a[TaxPaymentStatus.ERROR.ordinal()] = 1;
        f7665a[TaxPaymentStatus.CREATED.ordinal()] = 2;
        f7665a[TaxPaymentStatus.SMS_CODE_REQUIRED.ordinal()] = 3;
        f7665a[TaxPaymentStatus.COMPLETED.ordinal()] = 4;
    }
}
