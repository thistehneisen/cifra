package com.fasterxml.jackson.core.b;

/* compiled from: NumberOutput */
public final class h {

    /* renamed from: a reason: collision with root package name */
    private static int f4219a = 1000000;

    /* renamed from: b reason: collision with root package name */
    private static int f4220b = 1000000000;

    /* renamed from: c reason: collision with root package name */
    private static long f4221c = 10000000000L;

    /* renamed from: d reason: collision with root package name */
    private static long f4222d = 1000;

    /* renamed from: e reason: collision with root package name */
    private static long f4223e = -2147483648L;

    /* renamed from: f reason: collision with root package name */
    private static long f4224f = 2147483647L;

    /* renamed from: g reason: collision with root package name */
    static final String f4225g = String.valueOf(Long.MIN_VALUE);

    /* renamed from: h reason: collision with root package name */
    static final char[] f4226h = new char[4000];

    /* renamed from: i reason: collision with root package name */
    static final char[] f4227i = new char[4000];

    /* renamed from: j reason: collision with root package name */
    static final byte[] f4228j = new byte[4000];

    /* renamed from: k reason: collision with root package name */
    static final String[] f4229k = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    /* renamed from: l reason: collision with root package name */
    static final String[] f4230l = {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};

    static {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 10) {
            char c2 = (char) (i2 + 48);
            char c3 = i2 == 0 ? 0 : c2;
            int i4 = i3;
            int i5 = 0;
            while (i5 < 10) {
                char c4 = (char) (i5 + 48);
                char c5 = (i2 == 0 && i5 == 0) ? 0 : c4;
                int i6 = i4;
                for (int i7 = 0; i7 < 10; i7++) {
                    char c6 = (char) (i7 + 48);
                    char[] cArr = f4226h;
                    cArr[i6] = c3;
                    int i8 = i6 + 1;
                    cArr[i8] = c5;
                    int i9 = i6 + 2;
                    cArr[i9] = c6;
                    char[] cArr2 = f4227i;
                    cArr2[i6] = c2;
                    cArr2[i8] = c4;
                    cArr2[i9] = c6;
                    i6 += 4;
                }
                i5++;
                i4 = i6;
            }
            i2++;
            i3 = i4;
        }
        for (int i10 = 0; i10 < 4000; i10++) {
            f4228j[i10] = (byte) f4227i[i10];
        }
    }

    public static int a(int i2, char[] cArr, int i3) {
        int i4;
        int i5;
        int i6;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return a((long) i2, cArr, i3);
            }
            int i7 = i3 + 1;
            cArr[i3] = '-';
            i2 = -i2;
            i3 = i7;
        }
        if (i2 < f4219a) {
            if (i2 >= 1000) {
                int i8 = i2 / 1000;
                i6 = b(i2 - (i8 * 1000), cArr, c(i8, cArr, i3));
            } else if (i2 < 10) {
                i6 = i3 + 1;
                cArr[i3] = (char) (i2 + 48);
            } else {
                i6 = c(i2, cArr, i3);
            }
            return i6;
        }
        boolean z = i2 >= f4220b;
        if (z) {
            int i9 = f4220b;
            i2 -= i9;
            if (i2 >= i9) {
                i2 -= i9;
                i4 = i3 + 1;
                cArr[i3] = '2';
            } else {
                i4 = i3 + 1;
                cArr[i3] = '1';
            }
        } else {
            i4 = i3;
        }
        int i10 = i2 / 1000;
        int i11 = i2 - (i10 * 1000);
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        if (z) {
            i5 = b(i12, cArr, i4);
        } else {
            i5 = c(i12, cArr, i4);
        }
        return b(i11, cArr, b(i13, cArr, i5));
    }

    private static int b(int i2, char[] cArr, int i3) {
        int i4 = i2 << 2;
        int i5 = i3 + 1;
        char[] cArr2 = f4227i;
        int i6 = i4 + 1;
        cArr[i3] = cArr2[i4];
        int i7 = i5 + 1;
        int i8 = i6 + 1;
        cArr[i5] = cArr2[i6];
        int i9 = i7 + 1;
        cArr[i7] = cArr2[i8];
        return i9;
    }

    private static int c(int i2, char[] cArr, int i3) {
        int i4 = i2 << 2;
        int i5 = i4 + 1;
        char c2 = f4226h[i4];
        if (c2 != 0) {
            int i6 = i3 + 1;
            cArr[i3] = c2;
            i3 = i6;
        }
        int i7 = i5 + 1;
        char c3 = f4226h[i5];
        if (c3 != 0) {
            int i8 = i3 + 1;
            cArr[i3] = c3;
            i3 = i8;
        }
        int i9 = i3 + 1;
        cArr[i3] = f4226h[i7];
        return i9;
    }

    private static int b(int i2, byte[] bArr, int i3) {
        int i4 = i2 << 2;
        int i5 = i3 + 1;
        byte[] bArr2 = f4228j;
        int i6 = i4 + 1;
        bArr[i3] = bArr2[i4];
        int i7 = i5 + 1;
        int i8 = i6 + 1;
        bArr[i5] = bArr2[i6];
        int i9 = i7 + 1;
        bArr[i7] = bArr2[i8];
        return i9;
    }

    private static int c(int i2, byte[] bArr, int i3) {
        int i4 = i2 << 2;
        int i5 = i4 + 1;
        char c2 = f4226h[i4];
        if (c2 != 0) {
            int i6 = i3 + 1;
            bArr[i3] = (byte) c2;
            i3 = i6;
        }
        int i7 = i5 + 1;
        char c3 = f4226h[i5];
        if (c3 != 0) {
            int i8 = i3 + 1;
            bArr[i3] = (byte) c3;
            i3 = i8;
        }
        int i9 = i3 + 1;
        bArr[i3] = (byte) f4226h[i7];
        return i9;
    }

    public static int a(int i2, byte[] bArr, int i3) {
        int i4;
        int i5;
        int i6;
        if (i2 < 0) {
            if (i2 == Integer.MIN_VALUE) {
                return a((long) i2, bArr, i3);
            }
            int i7 = i3 + 1;
            bArr[i3] = 45;
            i2 = -i2;
            i3 = i7;
        }
        if (i2 < f4219a) {
            if (i2 >= 1000) {
                int i8 = i2 / 1000;
                i6 = b(i2 - (i8 * 1000), bArr, c(i8, bArr, i3));
            } else if (i2 < 10) {
                i6 = i3 + 1;
                bArr[i3] = (byte) (i2 + 48);
            } else {
                i6 = c(i2, bArr, i3);
            }
            return i6;
        }
        boolean z = i2 >= f4220b;
        if (z) {
            int i9 = f4220b;
            i2 -= i9;
            if (i2 >= i9) {
                i2 -= i9;
                i4 = i3 + 1;
                bArr[i3] = 50;
            } else {
                i4 = i3 + 1;
                bArr[i3] = 49;
            }
        } else {
            i4 = i3;
        }
        int i10 = i2 / 1000;
        int i11 = i2 - (i10 * 1000);
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        if (z) {
            i5 = b(i12, bArr, i4);
        } else {
            i5 = c(i12, bArr, i4);
        }
        return b(i11, bArr, b(i13, bArr, i5));
    }

    public static int a(long j2, char[] cArr, int i2) {
        if (j2 < 0) {
            if (j2 > f4223e) {
                return a((int) j2, cArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                int length = f4225g.length();
                f4225g.getChars(0, length, cArr, i2);
                return i2 + length;
            }
            int i3 = i2 + 1;
            cArr[i2] = '-';
            j2 = -j2;
            i2 = i3;
        } else if (j2 <= f4224f) {
            return a((int) j2, cArr, i2);
        }
        int a2 = a(j2) + i2;
        int i4 = a2;
        while (j2 > f4224f) {
            i4 -= 3;
            long j3 = f4222d;
            long j4 = j2 / j3;
            b((int) (j2 - (j3 * j4)), cArr, i4);
            j2 = j4;
        }
        int i5 = (int) j2;
        while (i5 >= 1000) {
            i4 -= 3;
            int i6 = i5 / 1000;
            b(i5 - (i6 * 1000), cArr, i4);
            i5 = i6;
        }
        c(i5, cArr, i2);
        return a2;
    }

    public static int a(long j2, byte[] bArr, int i2) {
        if (j2 < 0) {
            if (j2 > f4223e) {
                return a((int) j2, bArr, i2);
            }
            if (j2 == Long.MIN_VALUE) {
                int length = f4225g.length();
                int i3 = 0;
                while (i3 < length) {
                    int i4 = i2 + 1;
                    bArr[i2] = (byte) f4225g.charAt(i3);
                    i3++;
                    i2 = i4;
                }
                return i2;
            }
            int i5 = i2 + 1;
            bArr[i2] = 45;
            j2 = -j2;
            i2 = i5;
        } else if (j2 <= f4224f) {
            return a((int) j2, bArr, i2);
        }
        int a2 = a(j2) + i2;
        int i6 = a2;
        while (j2 > f4224f) {
            i6 -= 3;
            long j3 = f4222d;
            long j4 = j2 / j3;
            b((int) (j2 - (j3 * j4)), bArr, i6);
            j2 = j4;
        }
        int i7 = (int) j2;
        while (i7 >= 1000) {
            i6 -= 3;
            int i8 = i7 / 1000;
            b(i7 - (i8 * 1000), bArr, i6);
            i7 = i8;
        }
        c(i7, bArr, i2);
        return a2;
    }

    private static int a(long j2) {
        int i2 = 10;
        for (long j3 = f4221c; j2 >= j3 && i2 != 19; j3 = (j3 << 1) + (j3 << 3)) {
            i2++;
        }
        return i2;
    }
}
