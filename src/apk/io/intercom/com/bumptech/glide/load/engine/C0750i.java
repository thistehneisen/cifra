package io.intercom.com.bumptech.glide.load.engine;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.i reason: case insensitive filesystem */
/* compiled from: DecodeJob */
/* synthetic */ class C0750i {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f9894a = new int[f.values().length];

    /* renamed from: b reason: collision with root package name */
    static final /* synthetic */ int[] f9895b = new int[g.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
    /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005d */
    static {
        try {
            f9895b[g.RESOURCE_CACHE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f9895b[g.DATA_CACHE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f9895b[g.SOURCE.ordinal()] = 3;
        f9895b[g.FINISHED.ordinal()] = 4;
        f9895b[g.INITIALIZE.ordinal()] = 5;
        f9894a[f.INITIALIZE.ordinal()] = 1;
        f9894a[f.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        try {
            f9894a[f.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
