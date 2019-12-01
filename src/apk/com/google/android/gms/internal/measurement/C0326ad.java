package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.measurement.ad reason: case insensitive filesystem */
final class C0326ad {

    /* renamed from: a reason: collision with root package name */
    private static final C0333bd f5122a;

    static {
        C0333bd bdVar;
        if (!(Yc.a() && Yc.b()) || Qa.a()) {
            bdVar = new C0359fd();
        } else {
            bdVar = new C0371hd();
        }
        f5122a = bdVar;
    }

    public static boolean a(byte[] bArr) {
        return f5122a.a(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: private */
    public static int b(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int b(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* access modifiers changed from: private */
    public static int b(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    static String b(byte[] bArr, int i2, int i3) throws zzfi {
        return f5122a.b(bArr, i2, i3);
    }

    /* access modifiers changed from: private */
    public static int d(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return b(b2);
        }
        if (i4 == 1) {
            return b(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return b((int) b2, (int) bArr[i2], (int) bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean a(byte[] bArr, int i2, int i3) {
        return f5122a.a(bArr, i2, i3);
    }

    static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new C0353ed(i3, length2);
                            }
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = ((long) i4) + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    static int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return f5122a.a(charSequence, bArr, i2, i3);
    }

    static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        C0333bd bdVar = f5122a;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            bdVar.a(charSequence, byteBuffer);
        } else {
            C0333bd.b(charSequence, byteBuffer);
        }
    }
}
