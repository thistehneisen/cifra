package com.touchin.vtb.api;

/* compiled from: TaxPaymentStatus$$JsonTypeConverter */
/* synthetic */ class w {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f7133a = new int[TaxPaymentStatus.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    static {
        f7133a[TaxPaymentStatus.CREATED.ordinal()] = 1;
        f7133a[TaxPaymentStatus.COMPLETED.ordinal()] = 2;
        f7133a[TaxPaymentStatus.ERROR.ordinal()] = 3;
        try {
            f7133a[TaxPaymentStatus.SMS_CODE_REQUIRED.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
    }
}
