package io.fabric.sdk.android.services.network;

/* compiled from: DefaultHttpRequestFactory */
/* synthetic */ class b {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f9101a = new int[d.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    static {
        f9101a[d.GET.ordinal()] = 1;
        f9101a[d.POST.ordinal()] = 2;
        f9101a[d.PUT.ordinal()] = 3;
        try {
            f9101a[d.DELETE.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
    }
}
