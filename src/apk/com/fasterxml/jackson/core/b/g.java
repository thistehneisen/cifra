package com.fasterxml.jackson.core.b;

import java.math.BigDecimal;

/* compiled from: NumberInput */
public final class g {

    /* renamed from: a reason: collision with root package name */
    static final String f4217a = String.valueOf(Long.MIN_VALUE).substring(1);

    /* renamed from: b reason: collision with root package name */
    static final String f4218b = String.valueOf(Long.MAX_VALUE);

    public static boolean a(char[] cArr, int i2, int i3, boolean z) {
        String str = z ? f4217a : f4218b;
        int length = str.length();
        boolean z2 = true;
        if (i3 < length) {
            return true;
        }
        if (i3 > length) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            int charAt = cArr[i2 + i4] - str.charAt(i4);
            if (charAt != 0) {
                if (charAt >= 0) {
                    z2 = false;
                }
                return z2;
            }
        }
        return true;
    }

    public static int b(char[] cArr, int i2, int i3) {
        int i4 = cArr[i2] - '0';
        if (i3 > 4) {
            int i5 = i2 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            i2 = i7 + 1;
            i4 = (((((((i4 * 10) + (cArr[i5] - '0')) * 10) + (cArr[i6] - '0')) * 10) + (cArr[i7] - '0')) * 10) + (cArr[i2] - '0');
            i3 -= 4;
            if (i3 > 4) {
                int i8 = i2 + 1;
                int i9 = i8 + 1;
                int i10 = i9 + 1;
                return (((((((i4 * 10) + (cArr[i8] - '0')) * 10) + (cArr[i9] - '0')) * 10) + (cArr[i10] - '0')) * 10) + (cArr[i10 + 1] - '0');
            }
        }
        if (i3 > 1) {
            int i11 = i2 + 1;
            i4 = (i4 * 10) + (cArr[i11] - '0');
            if (i3 > 2) {
                int i12 = i11 + 1;
                i4 = (i4 * 10) + (cArr[i12] - '0');
                if (i3 > 3) {
                    i4 = (i4 * 10) + (cArr[i12 + 1] - '0');
                }
            }
        }
        return i4;
    }

    public static long c(char[] cArr, int i2, int i3) {
        int i4 = i3 - 9;
        return (((long) b(cArr, i2, i4)) * 1000000000) + ((long) b(cArr, i2 + i4, 9));
    }

    public static int a(String str, int i2) {
        if (str == null) {
            return i2;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            return i2;
        }
        int i3 = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i3 = 1;
            }
        }
        while (i3 < length) {
            char charAt2 = trim.charAt(i3);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (int) a(trim);
                } catch (NumberFormatException unused) {
                    return i2;
                }
            } else {
                i3++;
            }
        }
        try {
            return Integer.parseInt(trim);
        } catch (NumberFormatException unused2) {
            return i2;
        }
    }

    public static long a(String str, long j2) {
        if (str == null) {
            return j2;
        }
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            return j2;
        }
        int i2 = 0;
        if (length > 0) {
            char charAt = trim.charAt(0);
            if (charAt == '+') {
                trim = trim.substring(1);
                length = trim.length();
            } else if (charAt == '-') {
                i2 = 1;
            }
        }
        while (i2 < length) {
            char charAt2 = trim.charAt(i2);
            if (charAt2 > '9' || charAt2 < '0') {
                try {
                    return (long) a(trim);
                } catch (NumberFormatException unused) {
                    return j2;
                }
            } else {
                i2++;
            }
        }
        try {
            return Long.parseLong(trim);
        } catch (NumberFormatException unused2) {
            return j2;
        }
    }

    private static NumberFormatException b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Value \"");
        sb.append(str);
        sb.append("\" can not be represented as BigDecimal");
        return new NumberFormatException(sb.toString());
    }

    public static double a(String str, double d2) {
        if (str == null) {
            return d2;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return d2;
        }
        try {
            return a(trim);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public static double a(String str) throws NumberFormatException {
        if ("2.2250738585072012e-308".equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static BigDecimal a(char[] cArr) throws NumberFormatException {
        return a(cArr, 0, cArr.length);
    }

    public static BigDecimal a(char[] cArr, int i2, int i3) throws NumberFormatException {
        try {
            return new BigDecimal(cArr, i2, i3);
        } catch (NumberFormatException unused) {
            throw b(new String(cArr, i2, i3));
        }
    }
}
