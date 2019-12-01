package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.c;

/* renamed from: com.bumptech.glide.load.engine.k reason: case insensitive filesystem */
/* compiled from: DecodeJob */
/* synthetic */ class C0297k {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f4033a = new int[f.values().length];

    /* renamed from: b reason: collision with root package name */
    static final /* synthetic */ int[] f4034b = new int[g.values().length];

    /* renamed from: c reason: collision with root package name */
    static final /* synthetic */ int[] f4035c = new int[c.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0070 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
    static {
        try {
            f4035c[c.SOURCE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4035c[c.TRANSFORMED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        f4034b[g.RESOURCE_CACHE.ordinal()] = 1;
        f4034b[g.DATA_CACHE.ordinal()] = 2;
        f4034b[g.SOURCE.ordinal()] = 3;
        f4034b[g.FINISHED.ordinal()] = 4;
        f4034b[g.INITIALIZE.ordinal()] = 5;
        f4033a[f.INITIALIZE.ordinal()] = 1;
        f4033a[f.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        try {
            f4033a[f.DECODE_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
