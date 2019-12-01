package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap.Config;

/* compiled from: SizeConfigStrategy */
/* synthetic */ class n {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f3933a = new int[Config.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    static {
        f3933a[Config.ARGB_8888.ordinal()] = 1;
        f3933a[Config.RGB_565.ordinal()] = 2;
        f3933a[Config.ARGB_4444.ordinal()] = 3;
        try {
            f3933a[Config.ALPHA_8.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
    }
}
