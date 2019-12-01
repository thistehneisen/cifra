package com.touchin.vtb.api;

/* renamed from: com.touchin.vtb.api.a reason: case insensitive filesystem */
/* compiled from: AccountType$$JsonTypeConverter */
/* synthetic */ class C0647a {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f7107a = new int[AccountType.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|(3:11|12|14)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    static {
        f7107a[AccountType.CREDIT.ordinal()] = 1;
        f7107a[AccountType.ACCOUNT.ordinal()] = 2;
        f7107a[AccountType.WALLET.ordinal()] = 3;
        f7107a[AccountType.DEPOSIT.ordinal()] = 4;
        f7107a[AccountType.CELL.ordinal()] = 5;
        try {
            f7107a[AccountType.CARD.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
    }
}
