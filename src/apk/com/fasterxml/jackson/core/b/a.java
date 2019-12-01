package com.fasterxml.jackson.core.b;

import java.util.Arrays;

/* compiled from: CharTypes */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static final char[] f4187a = "0123456789ABCDEF".toCharArray();

    /* renamed from: b reason: collision with root package name */
    private static final byte[] f4188b;

    /* renamed from: c reason: collision with root package name */
    static final int[] f4189c;

    /* renamed from: d reason: collision with root package name */
    static final int[] f4190d;

    /* renamed from: e reason: collision with root package name */
    static final int[] f4191e;

    /* renamed from: f reason: collision with root package name */
    static final int[] f4192f;

    /* renamed from: g reason: collision with root package name */
    static final int[] f4193g;

    /* renamed from: h reason: collision with root package name */
    static final int[] f4194h;

    /* renamed from: i reason: collision with root package name */
    static final int[] f4195i;

    /* renamed from: j reason: collision with root package name */
    static final int[] f4196j = new int[128];

    static {
        int length = f4187a.length;
        f4188b = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            f4188b[i2] = (byte) f4187a[i2];
        }
        int[] iArr = new int[256];
        for (int i3 = 0; i3 < 32; i3++) {
            iArr[i3] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f4189c = iArr;
        int[] iArr2 = f4189c;
        int[] iArr3 = new int[iArr2.length];
        System.arraycopy(iArr2, 0, iArr3, 0, iArr3.length);
        for (int i4 = 128; i4 < 256; i4++) {
            int i5 = (i4 & 224) == 192 ? 2 : (i4 & 240) == 224 ? 3 : (i4 & 248) == 240 ? 4 : -1;
            iArr3[i4] = i5;
        }
        f4190d = iArr3;
        int[] iArr4 = new int[256];
        Arrays.fill(iArr4, -1);
        for (int i6 = 33; i6 < 256; i6++) {
            if (Character.isJavaIdentifierPart((char) i6)) {
                iArr4[i6] = 0;
            }
        }
        iArr4[64] = 0;
        iArr4[35] = 0;
        iArr4[42] = 0;
        iArr4[45] = 0;
        iArr4[43] = 0;
        f4191e = iArr4;
        int[] iArr5 = new int[256];
        System.arraycopy(f4191e, 0, iArr5, 0, iArr5.length);
        Arrays.fill(iArr5, 128, 128, 0);
        f4192f = iArr5;
        int[] iArr6 = new int[256];
        System.arraycopy(f4190d, 128, iArr6, 128, 128);
        Arrays.fill(iArr6, 0, 32, -1);
        iArr6[9] = 0;
        iArr6[10] = 10;
        iArr6[13] = 13;
        iArr6[42] = 42;
        f4193g = iArr6;
        int[] iArr7 = new int[256];
        System.arraycopy(f4190d, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        f4194h = iArr7;
        int[] iArr8 = new int[128];
        for (int i7 = 0; i7 < 32; i7++) {
            iArr8[i7] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        f4195i = iArr8;
        Arrays.fill(f4196j, -1);
        for (int i8 = 0; i8 < 10; i8++) {
            f4196j[i8 + 48] = i8;
        }
        for (int i9 = 0; i9 < 6; i9++) {
            int[] iArr9 = f4196j;
            int i10 = i9 + 10;
            iArr9[i9 + 97] = i10;
            iArr9[i9 + 65] = i10;
        }
    }

    public static int a(int i2) {
        if (i2 > 127) {
            return -1;
        }
        return f4196j[i2];
    }

    public static char[] b() {
        return (char[]) f4187a.clone();
    }

    public static int[] c() {
        return f4195i;
    }

    public static int[] d() {
        return f4193g;
    }

    public static int[] e() {
        return f4189c;
    }

    public static int[] f() {
        return f4191e;
    }

    public static int[] g() {
        return f4190d;
    }

    public static int[] h() {
        return f4192f;
    }

    public static void a(StringBuilder sb, String str) {
        int[] iArr = f4195i;
        int length = iArr.length;
        int length2 = str.length();
        for (int i2 = 0; i2 < length2; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= length || iArr[charAt] == 0) {
                sb.append(charAt);
            } else {
                sb.append('\\');
                int i3 = iArr[charAt];
                if (i3 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    sb.append(f4187a[charAt >> 4]);
                    sb.append(f4187a[charAt & 15]);
                } else {
                    sb.append((char) i3);
                }
            }
        }
    }

    public static byte[] a() {
        return (byte[]) f4188b.clone();
    }
}
