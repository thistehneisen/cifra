package com.touchin.vtb.viewcontrollers.base;

import com.touchin.vtb.api.BankConnectionStatus;

public final /* synthetic */ class b {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ int[] f7641a = new int[BankConnectionStatus.values().length];

    static {
        f7641a[BankConnectionStatus.PASSWORD_REQUIRED.ordinal()] = 1;
        f7641a[BankConnectionStatus.SMS_CODE_REQUIRED.ordinal()] = 2;
    }
}
