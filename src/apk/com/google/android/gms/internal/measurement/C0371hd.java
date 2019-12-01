package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.measurement.hd reason: case insensitive filesystem */
final class C0371hd extends C0333bd {
    C0371hd() {
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b9, code lost:
        return -1;
     */
    public final int a(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        long j2;
        long j3;
        byte[] bArr2 = bArr;
        int i6 = i3;
        int i7 = i4;
        if ((i6 | i7 | (bArr2.length - i7)) >= 0) {
            long j4 = (long) i6;
            int i8 = (int) (((long) i7) - j4);
            if (i8 >= 16) {
                long j5 = j4;
                i5 = 0;
                while (true) {
                    if (i5 >= i8) {
                        i5 = i8;
                        break;
                    }
                    long j6 = j5 + 1;
                    if (Yc.a(bArr2, j5) < 0) {
                        break;
                    }
                    i5++;
                    j5 = j6;
                }
            } else {
                i5 = 0;
            }
            int i9 = i8 - i5;
            long j7 = j4 + ((long) i5);
            while (true) {
                byte b2 = 0;
                while (true) {
                    if (i9 <= 0) {
                        j2 = j7;
                        break;
                    }
                    j2 = j7 + 1;
                    b2 = Yc.a(bArr2, j7);
                    if (b2 < 0) {
                        break;
                    }
                    i9--;
                    j7 = j2;
                }
                if (i9 == 0) {
                    return 0;
                }
                int i10 = i9 - 1;
                if (b2 >= -32) {
                    if (b2 >= -16) {
                        if (i10 >= 3) {
                            i9 = i10 - 3;
                            long j8 = j2 + 1;
                            byte a2 = Yc.a(bArr2, j2);
                            if (a2 > -65 || (((b2 << 28) + (a2 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j9 = j8 + 1;
                            if (Yc.a(bArr2, j8) > -65) {
                                break;
                            }
                            j3 = j9 + 1;
                            if (Yc.a(bArr2, j9) > -65) {
                                break;
                            }
                        } else {
                            return a(bArr2, (int) b2, j2, i10);
                        }
                    } else if (i10 >= 2) {
                        i9 = i10 - 2;
                        long j10 = j2 + 1;
                        byte a3 = Yc.a(bArr2, j2);
                        if (a3 > -65 || ((b2 == -32 && a3 < -96) || (b2 == -19 && a3 >= -96))) {
                            break;
                        }
                        long j11 = j10 + 1;
                        if (Yc.a(bArr2, j10) > -65) {
                            break;
                        }
                        j7 = j11;
                    } else {
                        return a(bArr2, (int) b2, j2, i10);
                    }
                } else if (i10 != 0) {
                    i9 = i10 - 1;
                    if (b2 < -62) {
                        break;
                    }
                    j3 = j2 + 1;
                    if (Yc.a(bArr2, j2) > -65) {
                        break;
                    }
                } else {
                    return b2;
                }
                j7 = j3;
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i3), Integer.valueOf(i4)}));
    }

    /* access modifiers changed from: 0000 */
    public final String b(byte[] bArr, int i2, int i3) throws zzfi {
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r13 < i4) {
                byte a2 = Yc.a(bArr, (long) r13);
                if (!C0347dd.d(a2)) {
                    break;
                }
                i2 = r13 + 1;
                int i6 = i5 + 1;
                C0347dd.b(a2, cArr, i5);
                i5 = i6;
            }
            int i7 = i5;
            while (r13 < i4) {
                int i8 = r13 + 1;
                byte a3 = Yc.a(bArr, (long) r13);
                if (C0347dd.d(a3)) {
                    int i9 = i7 + 1;
                    C0347dd.b(a3, cArr, i7);
                    while (i8 < i4) {
                        byte a4 = Yc.a(bArr, (long) i8);
                        if (!C0347dd.d(a4)) {
                            break;
                        }
                        i8++;
                        int i10 = i9 + 1;
                        C0347dd.b(a4, cArr, i9);
                        i9 = i10;
                    }
                    r13 = i8;
                    i7 = i9;
                } else if (C0347dd.e(a3)) {
                    if (i8 < i4) {
                        int i11 = i8 + 1;
                        int i12 = i7 + 1;
                        C0347dd.b(a3, Yc.a(bArr, (long) i8), cArr, i7);
                        r13 = i11;
                        i7 = i12;
                    } else {
                        throw zzfi.i();
                    }
                } else if (C0347dd.f(a3)) {
                    if (i8 < i4 - 1) {
                        int i13 = i8 + 1;
                        int i14 = i13 + 1;
                        int i15 = i7 + 1;
                        C0347dd.b(a3, Yc.a(bArr, (long) i8), Yc.a(bArr, (long) i13), cArr, i7);
                        r13 = i14;
                        i7 = i15;
                    } else {
                        throw zzfi.i();
                    }
                } else if (i8 < i4 - 2) {
                    int i16 = i8 + 1;
                    byte a5 = Yc.a(bArr, (long) i8);
                    int i17 = i16 + 1;
                    int i18 = i17 + 1;
                    int i19 = i7 + 1;
                    C0347dd.b(a3, a5, Yc.a(bArr, (long) i16), Yc.a(bArr, (long) i17), cArr, i7);
                    r13 = i18;
                    i7 = i19 + 1;
                } else {
                    throw zzfi.i();
                }
            }
            return new String(cArr, 0, i7);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    /* access modifiers changed from: 0000 */
    public final int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        char c2;
        long j2;
        long j3;
        long j4;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i2;
        int i5 = i3;
        long j5 = (long) i4;
        long j6 = ((long) i5) + j5;
        int length = charSequence.length();
        String str = " at index ";
        String str2 = "Failed writing ";
        if (length > i5 || bArr2.length - i5 < i4) {
            char charAt = charSequence2.charAt(length - 1);
            int i6 = i4 + i5;
            StringBuilder sb = new StringBuilder(37);
            sb.append(str2);
            sb.append(charAt);
            sb.append(str);
            sb.append(i6);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i7 = 0;
        while (true) {
            c2 = 128;
            j2 = 1;
            if (i7 >= length) {
                break;
            }
            char charAt2 = charSequence2.charAt(i7);
            if (charAt2 >= 128) {
                break;
            }
            long j7 = 1 + j5;
            Yc.a(bArr2, j5, (byte) charAt2);
            i7++;
            j5 = j7;
        }
        if (i7 == length) {
            return (int) j5;
        }
        while (i7 < length) {
            char charAt3 = charSequence2.charAt(i7);
            if (charAt3 < c2 && j5 < j6) {
                long j8 = j5 + j2;
                Yc.a(bArr2, j5, (byte) charAt3);
                j4 = j2;
                j3 = j8;
            } else if (charAt3 < 2048 && j5 <= j6 - 2) {
                long j9 = j5 + j2;
                Yc.a(bArr2, j5, (byte) ((charAt3 >>> 6) | 960));
                long j10 = j9 + j2;
                Yc.a(bArr2, j9, (byte) ((charAt3 & '?') | 128));
                j3 = j10;
                j4 = j2;
                i7++;
                c2 = 128;
                long j11 = j4;
                j5 = j3;
                j2 = j11;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j5 <= j6 - 3) {
                long j12 = j5 + j2;
                Yc.a(bArr2, j5, (byte) ((charAt3 >>> 12) | 480));
                long j13 = j12 + j2;
                Yc.a(bArr2, j12, (byte) (((charAt3 >>> 6) & 63) | 128));
                long j14 = j13 + 1;
                Yc.a(bArr2, j13, (byte) ((charAt3 & '?') | 128));
                j3 = j14;
                j4 = 1;
            } else if (j5 <= j6 - 4) {
                int i8 = i7 + 1;
                if (i8 != length) {
                    char charAt4 = charSequence2.charAt(i8);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j15 = j5 + 1;
                        Yc.a(bArr2, j5, (byte) ((codePoint >>> 18) | 240));
                        long j16 = j15 + 1;
                        Yc.a(bArr2, j15, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j17 = j16 + 1;
                        Yc.a(bArr2, j16, (byte) (((codePoint >>> 6) & 63) | 128));
                        j4 = 1;
                        j3 = j17 + 1;
                        Yc.a(bArr2, j17, (byte) ((codePoint & 63) | 128));
                        i7 = i8;
                        i7++;
                        c2 = 128;
                        long j112 = j4;
                        j5 = j3;
                        j2 = j112;
                    } else {
                        i7 = i8;
                    }
                }
                throw new C0353ed(i7 - 1, length);
            } else {
                if (55296 <= charAt3 && charAt3 <= 57343) {
                    int i9 = i7 + 1;
                    if (i9 == length || !Character.isSurrogatePair(charAt3, charSequence2.charAt(i9))) {
                        throw new C0353ed(i7, length);
                    }
                }
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append(str2);
                sb2.append(charAt3);
                sb2.append(str);
                sb2.append(j5);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            }
            i7++;
            c2 = 128;
            long j1122 = j4;
            j5 = j3;
            j2 = j1122;
        }
        return (int) j5;
    }

    /* access modifiers changed from: 0000 */
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        long j2;
        char c2;
        long j3;
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        long a2 = Yc.a(byteBuffer);
        long position = ((long) byteBuffer.position()) + a2;
        long limit = ((long) byteBuffer.limit()) + a2;
        int length = charSequence.length();
        String str = " at index ";
        String str2 = "Failed writing ";
        if (((long) length) <= limit - position) {
            int i2 = 0;
            while (true) {
                c2 = 128;
                if (i2 >= length) {
                    break;
                }
                char charAt = charSequence2.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                long j4 = j2 + 1;
                Yc.a(j2, (byte) charAt);
                i2++;
                position = j4;
            }
            if (i2 == length) {
                byteBuffer2.position((int) (j2 - a2));
                return;
            }
            while (i2 < length) {
                char charAt2 = charSequence2.charAt(i2);
                if (charAt2 < c2 && j2 < limit) {
                    long j5 = j2 + 1;
                    Yc.a(j2, (byte) charAt2);
                    j2 = j5;
                    j3 = a2;
                } else if (charAt2 >= 2048 || j2 > limit - 2) {
                    j3 = a2;
                    if ((charAt2 < 55296 || 57343 < charAt2) && j2 <= limit - 3) {
                        long j6 = j2 + 1;
                        Yc.a(j2, (byte) ((charAt2 >>> 12) | 480));
                        long j7 = j6 + 1;
                        Yc.a(j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                        long j8 = j7 + 1;
                        Yc.a(j7, (byte) ((charAt2 & '?') | 128));
                        j2 = j8;
                    } else if (j2 <= limit - 4) {
                        int i3 = i2 + 1;
                        if (i3 != length) {
                            char charAt3 = charSequence2.charAt(i3);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j9 = j2 + 1;
                                Yc.a(j2, (byte) ((codePoint >>> 18) | 240));
                                long j10 = j9 + 1;
                                Yc.a(j9, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = j10 + 1;
                                Yc.a(j10, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j12 = j11 + 1;
                                Yc.a(j11, (byte) ((codePoint & 63) | 128));
                                i2 = i3;
                                j2 = j12;
                            }
                        } else {
                            i3 = i2;
                        }
                        throw new C0353ed(i3 - 1, length);
                    } else {
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            int i4 = i2 + 1;
                            if (i4 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i4))) {
                                throw new C0353ed(i2, length);
                            }
                        }
                        StringBuilder sb = new StringBuilder(46);
                        sb.append(str2);
                        sb.append(charAt2);
                        sb.append(str);
                        sb.append(j2);
                        throw new ArrayIndexOutOfBoundsException(sb.toString());
                    }
                } else {
                    j3 = a2;
                    long j13 = j2 + 1;
                    Yc.a(j2, (byte) ((charAt2 >>> 6) | 960));
                    long j14 = j13 + 1;
                    Yc.a(j13, (byte) ((charAt2 & '?') | 128));
                    j2 = j14;
                }
                i2++;
                ByteBuffer byteBuffer3 = byteBuffer;
                a2 = j3;
                c2 = 128;
            }
            byteBuffer.position((int) (j2 - a2));
            return;
        }
        char charAt4 = charSequence2.charAt(length - 1);
        int limit2 = byteBuffer.limit();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append(str2);
        sb2.append(charAt4);
        sb2.append(str);
        sb2.append(limit2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    private static int a(byte[] bArr, int i2, long j2, int i3) {
        if (i3 == 0) {
            return C0326ad.b(i2);
        }
        if (i3 == 1) {
            return C0326ad.b(i2, Yc.a(bArr, j2));
        }
        if (i3 == 2) {
            return C0326ad.b(i2, (int) Yc.a(bArr, j2), (int) Yc.a(bArr, j2 + 1));
        }
        throw new AssertionError();
    }
}
