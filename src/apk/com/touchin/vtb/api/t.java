package com.touchin.vtb.api;

/* compiled from: TaskStatus$$JsonTypeConverter */
/* synthetic */ class t {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f7131a = new int[TaskStatus.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    static {
        f7131a[TaskStatus.IN_PROGRESS.ordinal()] = 1;
        f7131a[TaskStatus.COMPLETED.ordinal()] = 2;
        f7131a[TaskStatus.ACTIVE.ordinal()] = 3;
        try {
            f7131a[TaskStatus.DELETED.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
    }
}
