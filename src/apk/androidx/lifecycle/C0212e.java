package androidx.lifecycle;

import androidx.lifecycle.h.a;

/* renamed from: androidx.lifecycle.e reason: case insensitive filesystem */
/* compiled from: FullLifecycleObserverAdapter */
/* synthetic */ class C0212e {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f1641a = new int[a.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
    static {
        f1641a[a.ON_CREATE.ordinal()] = 1;
        f1641a[a.ON_START.ordinal()] = 2;
        f1641a[a.ON_RESUME.ordinal()] = 3;
        f1641a[a.ON_PAUSE.ordinal()] = 4;
        f1641a[a.ON_STOP.ordinal()] = 5;
        f1641a[a.ON_DESTROY.ordinal()] = 6;
        try {
            f1641a[a.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused) {
        }
    }
}
