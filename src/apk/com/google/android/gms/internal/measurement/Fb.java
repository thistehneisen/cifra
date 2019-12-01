package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class Fb {

    /* renamed from: a reason: collision with root package name */
    static final Charset f4930a = Charset.forName("UTF-8");

    /* renamed from: b reason: collision with root package name */
    private static final Charset f4931b = Charset.forName("ISO-8859-1");

    /* renamed from: c reason: collision with root package name */
    public static final byte[] f4932c;

    /* renamed from: d reason: collision with root package name */
    private static final ByteBuffer f4933d;

    /* renamed from: e reason: collision with root package name */
    private static final C0381jb f4934e;

    static {
        byte[] bArr = new byte[0];
        f4932c = bArr;
        f4933d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f4932c;
        f4934e = C0381jb.a(bArr2, 0, bArr2.length, false);
    }

    public static int a(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static boolean a(C0400mc mcVar) {
        return false;
    }

    public static boolean b(byte[] bArr) {
        return C0326ad.a(bArr);
    }

    public static String c(byte[] bArr) {
        return new String(bArr, f4930a);
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int a(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4) {
        int i5 = i2;
        for (int i6 = i3; i6 < i3 + i4; i6++) {
            i5 = (i5 * 31) + bArr[i6];
        }
        return i5;
    }

    static Object a(Object obj, Object obj2) {
        C0394lc f2 = ((C0400mc) obj).f();
        f2.a((C0400mc) obj2);
        return f2.z();
    }
}
