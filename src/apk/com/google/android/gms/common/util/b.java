package com.google.android.gms.common.util;

import com.google.android.gms.common.internal.C0321p;
import java.lang.reflect.Array;
import java.util.Arrays;

public final class b {
    public static <T> boolean a(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (C0321p.a(tArr[i2], t)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    public static <T> T[] a(T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i2 = 0;
        for (T[] length : tArr) {
            i2 += length.length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i2);
        int length2 = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr2 = tArr[i3];
            System.arraycopy(tArr2, 0, copyOf, length2, tArr2.length);
            length2 += tArr2.length;
        }
        return copyOf;
    }
}
