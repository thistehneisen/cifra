package org.joda.time.d;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.c;
import org.joda.time.d;

/* compiled from: FieldUtils */
public class h {
    public static int a(int i2, int i3) {
        int i4 = i2 + i3;
        if ((i2 ^ i4) >= 0 || (i2 ^ i3) < 0) {
            return i4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The calculation caused an overflow: ");
        sb.append(i2);
        sb.append(" + ");
        sb.append(i3);
        throw new ArithmeticException(sb.toString());
    }

    public static long b(long j2, long j3) {
        if (j3 == 1) {
            return j2;
        }
        if (j2 == 1) {
            return j3;
        }
        if (j2 == 0 || j3 == 0) {
            return 0;
        }
        long j4 = j2 * j3;
        if (j4 / j3 == j2 && ((j2 != Long.MIN_VALUE || j3 != -1) && (j3 != Long.MIN_VALUE || j2 != -1))) {
            return j4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Multiplication overflows a long: ");
        sb.append(j2);
        sb.append(" * ");
        sb.append(j3);
        throw new ArithmeticException(sb.toString());
    }

    public static long a(long j2, long j3) {
        long j4 = j2 + j3;
        if ((j2 ^ j4) >= 0 || (j2 ^ j3) < 0) {
            return j4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The calculation caused an overflow: ");
        sb.append(j2);
        sb.append(" + ");
        sb.append(j3);
        throw new ArithmeticException(sb.toString());
    }

    public static long a(long j2, int i2) {
        String str = " * ";
        String str2 = "Multiplication overflows a long: ";
        if (i2 != -1) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return j2;
            }
            long j3 = (long) i2;
            long j4 = j2 * j3;
            if (j4 / j3 == j2) {
                return j4;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(j2);
            sb.append(str);
            sb.append(i2);
            throw new ArithmeticException(sb.toString());
        } else if (j2 != Long.MIN_VALUE) {
            return -j2;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(j2);
            sb2.append(str);
            sb2.append(i2);
            throw new ArithmeticException(sb2.toString());
        }
    }

    public static int a(long j2) {
        if (-2147483648L <= j2 && j2 <= 2147483647L) {
            return (int) j2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Value cannot fit in an int: ");
        sb.append(j2);
        throw new ArithmeticException(sb.toString());
    }

    public static void a(c cVar, int i2, int i3, int i4) {
        if (i2 < i3 || i2 > i4) {
            throw new IllegalFieldValueException(cVar.g(), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
    }

    public static void a(d dVar, int i2, int i3, int i4) {
        if (i2 < i3 || i2 > i4) {
            throw new IllegalFieldValueException(dVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }
}
