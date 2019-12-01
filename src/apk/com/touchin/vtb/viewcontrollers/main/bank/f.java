package com.touchin.vtb.viewcontrollers.main.bank;

import com.touchin.vtb.api.ApiError;
import com.touchin.vtb.api.BankConnectionStatus;

public final /* synthetic */ class f {

    /* renamed from: a reason: collision with root package name */
    public static final /* synthetic */ int[] f7646a = new int[ApiError.values().length];

    /* renamed from: b reason: collision with root package name */
    public static final /* synthetic */ int[] f7647b = new int[BankConnectionStatus.values().length];

    static {
        f7646a[ApiError.NO_CONNECTED_BANK.ordinal()] = 1;
        f7646a[ApiError.NO_CONNECTED_COMPANY.ordinal()] = 2;
        f7646a[ApiError.BANK_SESSION_EXPIRED.ordinal()] = 3;
        f7647b[BankConnectionStatus.PASSWORD_REQUIRED.ordinal()] = 1;
        f7647b[BankConnectionStatus.SMS_CODE_REQUIRED.ordinal()] = 2;
    }
}
