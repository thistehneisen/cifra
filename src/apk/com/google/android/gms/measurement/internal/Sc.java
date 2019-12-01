package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;

public final class Sc {
    public static String a(String str, String[] strArr, String[] strArr2) {
        q.a(strArr);
        q.a(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            String str2 = strArr[i2];
            boolean z = (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
            if (z) {
                return strArr2[i2];
            }
        }
        return null;
    }
}
