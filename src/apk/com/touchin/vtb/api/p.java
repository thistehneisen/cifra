package com.touchin.vtb.api;

/* compiled from: PaymentSystem$$JsonTypeConverter */
/* synthetic */ class p {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f7127a = new int[PaymentSystem.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    static {
        f7127a[PaymentSystem.MAESTRO.ordinal()] = 1;
        f7127a[PaymentSystem.CHINA_UNIONPAY.ordinal()] = 2;
        f7127a[PaymentSystem.MASTERCARD.ordinal()] = 3;
        f7127a[PaymentSystem.DISCOVER.ordinal()] = 4;
        f7127a[PaymentSystem.VISA.ordinal()] = 5;
        f7127a[PaymentSystem.AMERICAN_EXPRESS.ordinal()] = 6;
        f7127a[PaymentSystem.JCB_INTERNATIONAL.ordinal()] = 7;
        try {
            f7127a[PaymentSystem.DINERS_CLUB.ordinal()] = 8;
        } catch (NoSuchFieldError unused) {
        }
    }
}
