package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.e.b;
import java.lang.ref.SoftReference;

/* compiled from: JsonStringEncoder */
public final class e {

    /* renamed from: a reason: collision with root package name */
    private static final char[] f4207a = a.b();

    /* renamed from: b reason: collision with root package name */
    private static final byte[] f4208b = a.a();

    /* renamed from: c reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<e>> f4209c = new ThreadLocal<>();

    /* renamed from: d reason: collision with root package name */
    protected b f4210d;

    /* renamed from: e reason: collision with root package name */
    protected final char[] f4211e = new char[6];

    public e() {
        char[] cArr = this.f4211e;
        cArr[0] = '\\';
        cArr[2] = '0';
        cArr[3] = '0';
    }

    public static e a() {
        e eVar;
        SoftReference softReference = (SoftReference) f4209c.get();
        if (softReference == null) {
            eVar = null;
        } else {
            eVar = (e) softReference.get();
        }
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        f4209c.set(new SoftReference(eVar2));
        return eVar2;
    }

    public byte[] a(String str) {
        int i2;
        b bVar = this.f4210d;
        if (bVar == null) {
            bVar = new b(null);
            this.f4210d = bVar;
        }
        int length = str.length();
        byte[] c2 = bVar.c();
        int length2 = c2.length;
        byte[] bArr = c2;
        int i3 = 0;
        int i4 = 0;
        loop0:
        while (true) {
            if (i3 >= length) {
                break;
            }
            int i5 = i3 + 1;
            int charAt = str.charAt(i3);
            while (charAt <= 127) {
                if (i4 >= length2) {
                    byte[] a2 = bVar.a();
                    i4 = 0;
                    bArr = a2;
                    length2 = a2.length;
                }
                int i6 = i4 + 1;
                bArr[i4] = (byte) charAt;
                if (i5 >= length) {
                    i4 = i6;
                    break loop0;
                }
                int i7 = i5 + 1;
                int charAt2 = str.charAt(i5);
                i5 = i7;
                charAt = charAt2;
                i4 = i6;
            }
            if (i4 >= length2) {
                bArr = bVar.a();
                length2 = bArr.length;
                i4 = 0;
            }
            if (charAt < 2048) {
                int i8 = i4 + 1;
                bArr[i4] = (byte) ((charAt >> 6) | 192);
                i2 = i8;
            } else if (charAt < 55296 || charAt > 57343) {
                int i9 = i4 + 1;
                bArr[i4] = (byte) ((charAt >> 12) | 224);
                if (i9 >= length2) {
                    bArr = bVar.a();
                    length2 = bArr.length;
                    i9 = 0;
                }
                i2 = i9 + 1;
                bArr[i9] = (byte) (((charAt >> 6) & 63) | 128);
            } else if (charAt > 56319) {
                a(charAt);
                throw null;
            } else if (i5 < length) {
                int i10 = i5 + 1;
                charAt = a(charAt, str.charAt(i5));
                if (charAt <= 1114111) {
                    int i11 = i4 + 1;
                    bArr[i4] = (byte) ((charAt >> 18) | 240);
                    if (i11 >= length2) {
                        bArr = bVar.a();
                        length2 = bArr.length;
                        i11 = 0;
                    }
                    int i12 = i11 + 1;
                    bArr[i11] = (byte) (((charAt >> 12) & 63) | 128);
                    if (i12 >= length2) {
                        byte[] a3 = bVar.a();
                        i12 = 0;
                        bArr = a3;
                        length2 = a3.length;
                    }
                    int i13 = i12 + 1;
                    bArr[i12] = (byte) (((charAt >> 6) & 63) | 128);
                    i2 = i13;
                    i5 = i10;
                } else {
                    a(charAt);
                    throw null;
                }
            } else {
                a(charAt);
                throw null;
            }
            if (i2 >= length2) {
                byte[] a4 = bVar.a();
                i2 = 0;
                bArr = a4;
                length2 = a4.length;
            }
            int i14 = i2 + 1;
            bArr[i2] = (byte) ((charAt & 63) | 128);
            i3 = i5;
            i4 = i14;
        }
        return this.f4210d.b(i4);
    }

    private static int a(int i2, int i3) {
        if (i3 >= 56320 && i3 <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i3 - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(i2));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(i3));
        sb.append("; illegal combination");
        throw new IllegalArgumentException(sb.toString());
    }

    private static void a(int i2) {
        throw new IllegalArgumentException(l.c(i2));
    }
}
