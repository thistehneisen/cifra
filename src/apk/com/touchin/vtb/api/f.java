package com.touchin.vtb.api;

/* compiled from: BankConnectionStatus$$JsonTypeConverter */
/* synthetic */ class f {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f7117a = new int[BankConnectionStatus.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    static {
        f7117a[BankConnectionStatus.PASSWORD_REQUIRED.ordinal()] = 1;
        f7117a[BankConnectionStatus.CONNECTED.ordinal()] = 2;
        try {
            f7117a[BankConnectionStatus.SMS_CODE_REQUIRED.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
    }
}
