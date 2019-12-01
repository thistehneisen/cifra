package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.dd reason: case insensitive filesystem */
final class C0347dd {
    /* access modifiers changed from: private */
    public static void b(byte b2, char[] cArr, int i2) {
        cArr[i2] = (char) b2;
    }

    /* access modifiers changed from: private */
    public static boolean d(byte b2) {
        return b2 >= 0;
    }

    /* access modifiers changed from: private */
    public static boolean e(byte b2) {
        return b2 < -32;
    }

    /* access modifiers changed from: private */
    public static boolean f(byte b2) {
        return b2 < -16;
    }

    private static boolean g(byte b2) {
        return b2 > -65;
    }

    /* access modifiers changed from: private */
    public static void b(byte b2, byte b3, char[] cArr, int i2) throws zzfi {
        if (b2 < -62 || g(b3)) {
            throw zzfi.i();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    /* access modifiers changed from: private */
    public static void b(byte b2, byte b3, byte b4, char[] cArr, int i2) throws zzfi {
        if (g(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || g(b4)))) {
            throw zzfi.i();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    /* access modifiers changed from: private */
    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws zzfi {
        if (g(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || g(b4) || g(b5)) {
            throw zzfi.i();
        }
        byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
        cArr[i2] = (char) ((b6 >>> 10) + 55232);
        cArr[i2 + 1] = (char) ((b6 & 1023) + 56320);
    }
}
