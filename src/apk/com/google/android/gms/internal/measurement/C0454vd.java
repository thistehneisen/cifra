package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.measurement.vd reason: case insensitive filesystem */
public final class C0454vd {

    /* renamed from: a reason: collision with root package name */
    protected static final Charset f5407a = Charset.forName("UTF-8");

    /* renamed from: b reason: collision with root package name */
    private static final Charset f5408b = Charset.forName("ISO-8859-1");

    /* renamed from: c reason: collision with root package name */
    public static final Object f5409c = new Object();

    public static boolean a(Object[] objArr, Object[] objArr2) {
        int i2;
        int length = objArr == null ? 0 : objArr.length;
        if (objArr2 == null) {
            i2 = 0;
        } else {
            i2 = objArr2.length;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length || objArr[i3] != null) {
                while (i4 < i2 && objArr2[i4] == null) {
                    i4++;
                }
                boolean z = i3 >= length;
                boolean z2 = i4 >= i2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i3].equals(objArr2[i4])) {
                    return false;
                }
                i3++;
                i4++;
            } else {
                i3++;
            }
        }
    }

    public static int a(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            Object obj = objArr[i3];
            if (obj != null) {
                i2 = (i2 * 31) + obj.hashCode();
            }
        }
        return i2;
    }

    public static void a(C0436sd sdVar, C0436sd sdVar2) {
        C0448ud udVar = sdVar.f5365b;
        if (udVar != null) {
            sdVar2.f5365b = (C0448ud) udVar.clone();
        }
    }
}
