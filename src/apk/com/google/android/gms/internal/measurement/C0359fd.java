package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;

/* renamed from: com.google.android.gms.internal.measurement.fd reason: case insensitive filesystem */
final class C0359fd extends C0333bd {
    C0359fd() {
    }

    /* access modifiers changed from: 0000 */
    public final int a(int i2, byte[] bArr, int i3, int i4) {
        while (r9 < i4 && bArr[r9] >= 0) {
            i3 = r9 + 1;
        }
        if (r9 >= i4) {
            return 0;
        }
        while (r9 < i4) {
            int i5 = r9 + 1;
            byte b2 = bArr[r9];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i5 >= i4) {
                        return b2;
                    }
                    if (b2 >= -62) {
                        r9 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    return -1;
                } else if (b2 < -16) {
                    if (i5 >= i4 - 1) {
                        return C0326ad.d(bArr, i5, i4);
                    }
                    int i6 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        r9 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return -1;
                } else if (i5 >= i4 - 2) {
                    return C0326ad.d(bArr, i5, i4);
                } else {
                    int i7 = i5 + 1;
                    byte b4 = bArr[i5];
                    if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            i5 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            r9 = i5;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final String b(byte[] bArr, int i2, int i3) throws zzfi {
        if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
            int i4 = i2 + i3;
            char[] cArr = new char[i3];
            int i5 = 0;
            while (r13 < i4) {
                byte b2 = bArr[r13];
                if (!C0347dd.d(b2)) {
                    break;
                }
                i2 = r13 + 1;
                int i6 = i5 + 1;
                C0347dd.b(b2, cArr, i5);
                i5 = i6;
            }
            int i7 = i5;
            while (r13 < i4) {
                int i8 = r13 + 1;
                byte b3 = bArr[r13];
                if (C0347dd.d(b3)) {
                    int i9 = i7 + 1;
                    C0347dd.b(b3, cArr, i7);
                    while (i8 < i4) {
                        byte b4 = bArr[i8];
                        if (!C0347dd.d(b4)) {
                            break;
                        }
                        i8++;
                        int i10 = i9 + 1;
                        C0347dd.b(b4, cArr, i9);
                        i9 = i10;
                    }
                    r13 = i8;
                    i7 = i9;
                } else if (C0347dd.e(b3)) {
                    if (i8 < i4) {
                        int i11 = i8 + 1;
                        int i12 = i7 + 1;
                        C0347dd.b(b3, bArr[i8], cArr, i7);
                        r13 = i11;
                        i7 = i12;
                    } else {
                        throw zzfi.i();
                    }
                } else if (C0347dd.f(b3)) {
                    if (i8 < i4 - 1) {
                        int i13 = i8 + 1;
                        int i14 = i13 + 1;
                        int i15 = i7 + 1;
                        C0347dd.b(b3, bArr[i8], bArr[i13], cArr, i7);
                        r13 = i14;
                        i7 = i15;
                    } else {
                        throw zzfi.i();
                    }
                } else if (i8 < i4 - 2) {
                    int i16 = i8 + 1;
                    byte b5 = bArr[i8];
                    int i17 = i16 + 1;
                    int i18 = i17 + 1;
                    int i19 = i7 + 1;
                    C0347dd.b(b3, b5, bArr[i16], bArr[i17], cArr, i7);
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
        int i4;
        int length = charSequence.length();
        int i5 = i3 + i2;
        int i6 = 0;
        while (i6 < length) {
            int i7 = i6 + i2;
            if (i7 >= i5) {
                break;
            }
            char charAt = charSequence.charAt(i6);
            if (charAt >= 128) {
                break;
            }
            bArr[i7] = (byte) charAt;
            i6++;
        }
        if (i6 == length) {
            return i2 + length;
        }
        int i8 = i2 + i6;
        while (i6 < length) {
            char charAt2 = charSequence.charAt(i6);
            if (charAt2 < 128 && i8 < i5) {
                i4 = i8 + 1;
                bArr[i8] = (byte) charAt2;
            } else if (charAt2 < 2048 && i8 <= i5 - 2) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                i8 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
                i6++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i5 - 3) {
                int i10 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i4 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            } else if (i8 <= i5 - 4) {
                int i12 = i6 + 1;
                if (i12 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i12);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i13 = i8 + 1;
                        bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i8 = i15 + 1;
                        bArr[i15] = (byte) ((codePoint & 63) | 128);
                        i6 = i12;
                        i6++;
                    } else {
                        i6 = i12;
                    }
                }
                throw new C0353ed(i6 - 1, length);
            } else {
                if (55296 <= charAt2 && charAt2 <= 57343) {
                    int i16 = i6 + 1;
                    if (i16 == charSequence.length() || !Character.isSurrogatePair(charAt2, charSequence.charAt(i16))) {
                        throw new C0353ed(i6, length);
                    }
                }
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i8);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            i8 = i4;
            i6++;
        }
        return i8;
    }

    /* access modifiers changed from: 0000 */
    public final void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        C0333bd.b(charSequence, byteBuffer);
    }
}
