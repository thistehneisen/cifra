package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.yb reason: case insensitive filesystem */
final /* synthetic */ class C0470yb {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f5425a = new int[Bb.values().length];

    /* renamed from: b reason: collision with root package name */
    static final /* synthetic */ int[] f5426b = new int[Pb.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
    static {
        try {
            f5426b[Pb.BYTE_STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5426b[Pb.MESSAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5426b[Pb.STRING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f5425a[Bb.MAP.ordinal()] = 1;
        f5425a[Bb.VECTOR.ordinal()] = 2;
        f5425a[Bb.SCALAR.ordinal()] = 3;
    }
}
