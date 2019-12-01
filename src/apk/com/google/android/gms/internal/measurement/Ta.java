package com.google.android.gms.internal.measurement;

import java.io.IOException;

final class Ta {
    static int a(byte[] bArr, int i2, Sa sa) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return a((int) b2, bArr, i3, sa);
        }
        sa.f5038a = b2;
        return i3;
    }

    static int b(byte[] bArr, int i2, Sa sa) {
        int i3 = i2 + 1;
        long j2 = (long) bArr[i2];
        if (j2 >= 0) {
            sa.f5039b = j2;
            return i3;
        }
        long j3 = j2 & 127;
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j4 = j3 | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j4 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            int i7 = i6;
            b2 = b3;
            i4 = i7;
        }
        sa.f5039b = j4;
        return i4;
    }

    static double c(byte[] bArr, int i2) {
        return Double.longBitsToDouble(b(bArr, i2));
    }

    static float d(byte[] bArr, int i2) {
        return Float.intBitsToFloat(a(bArr, i2));
    }

    static int e(byte[] bArr, int i2, Sa sa) throws zzfi {
        int a2 = a(bArr, i2, sa);
        int i3 = sa.f5038a;
        if (i3 < 0) {
            throw zzfi.b();
        } else if (i3 > bArr.length - a2) {
            throw zzfi.a();
        } else if (i3 == 0) {
            sa.f5040c = Xa.f5082a;
            return a2;
        } else {
            sa.f5040c = Xa.a(bArr, a2, i3);
            return a2 + i3;
        }
    }

    static int c(byte[] bArr, int i2, Sa sa) throws zzfi {
        int a2 = a(bArr, i2, sa);
        int i3 = sa.f5038a;
        if (i3 < 0) {
            throw zzfi.b();
        } else if (i3 == 0) {
            sa.f5040c = "";
            return a2;
        } else {
            sa.f5040c = new String(bArr, a2, i3, Fb.f4930a);
            return a2 + i3;
        }
    }

    static int d(byte[] bArr, int i2, Sa sa) throws zzfi {
        int a2 = a(bArr, i2, sa);
        int i3 = sa.f5038a;
        if (i3 < 0) {
            throw zzfi.b();
        } else if (i3 == 0) {
            sa.f5040c = "";
            return a2;
        } else {
            sa.f5040c = C0326ad.b(bArr, a2, i3);
            return a2 + i3;
        }
    }

    static int a(int i2, byte[] bArr, int i3, Sa sa) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            sa.f5038a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            sa.f5038a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            sa.f5038a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            sa.f5038a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                sa.f5038a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    static long b(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    static int a(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [int] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    static int a(Ac ac, byte[] bArr, int i2, int i3, Sa sa) throws IOException {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            i4 = a((int) b2, bArr, i4, sa);
            b2 = sa.f5038a;
        }
        int i5 = i4;
        if (b2 < 0 || b2 > i3 - i5) {
            throw zzfi.a();
        }
        Object a2 = ac.a();
        int i6 = b2 + i5;
        ac.a(a2, bArr, i5, i6, sa);
        ac.c(a2);
        sa.f5040c = a2;
        return i6;
    }

    static int a(Ac ac, byte[] bArr, int i2, int i3, int i4, Sa sa) throws IOException {
        C0418pc pcVar = (C0418pc) ac;
        Object a2 = pcVar.a();
        int a3 = pcVar.a(a2, bArr, i2, i3, i4, sa);
        pcVar.c(a2);
        sa.f5040c = a2;
        return a3;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, Mb<?> mb, Sa sa) {
        Hb hb = (Hb) mb;
        int a2 = a(bArr, i3, sa);
        hb.f(sa.f5038a);
        while (a2 < i4) {
            int a3 = a(bArr, a2, sa);
            if (i2 != sa.f5038a) {
                break;
            }
            a2 = a(bArr, a3, sa);
            hb.f(sa.f5038a);
        }
        return a2;
    }

    static int a(byte[] bArr, int i2, Mb<?> mb, Sa sa) throws IOException {
        Hb hb = (Hb) mb;
        int a2 = a(bArr, i2, sa);
        int i3 = sa.f5038a + a2;
        while (a2 < i3) {
            a2 = a(bArr, a2, sa);
            hb.f(sa.f5038a);
        }
        if (a2 == i3) {
            return a2;
        }
        throw zzfi.a();
    }

    static int a(Ac<?> ac, int i2, byte[] bArr, int i3, int i4, Mb<?> mb, Sa sa) throws IOException {
        int a2 = a((Ac) ac, bArr, i3, i4, sa);
        mb.add(sa.f5040c);
        while (a2 < i4) {
            int a3 = a(bArr, a2, sa);
            if (i2 != sa.f5038a) {
                break;
            }
            a2 = a((Ac) ac, bArr, a3, i4, sa);
            mb.add(sa.f5040c);
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4, Vc vc, Sa sa) throws zzfi {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int b2 = b(bArr, i3, sa);
                vc.a(i2, (Object) Long.valueOf(sa.f5039b));
                return b2;
            } else if (i5 == 1) {
                vc.a(i2, (Object) Long.valueOf(b(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int a2 = a(bArr, i3, sa);
                int i6 = sa.f5038a;
                if (i6 < 0) {
                    throw zzfi.b();
                } else if (i6 <= bArr.length - a2) {
                    if (i6 == 0) {
                        vc.a(i2, (Object) Xa.f5082a);
                    } else {
                        vc.a(i2, (Object) Xa.a(bArr, a2, i6));
                    }
                    return a2 + i6;
                } else {
                    throw zzfi.a();
                }
            } else if (i5 == 3) {
                Vc d2 = Vc.d();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int a3 = a(bArr, i3, sa);
                    int i9 = sa.f5038a;
                    if (i9 == i7) {
                        i8 = i9;
                        i3 = a3;
                        break;
                    }
                    i8 = i9;
                    i3 = a(i9, bArr, a3, i4, d2, sa);
                }
                if (i3 > i4 || i8 != i7) {
                    throw zzfi.h();
                }
                vc.a(i2, (Object) d2);
                return i3;
            } else if (i5 == 5) {
                vc.a(i2, (Object) Integer.valueOf(a(bArr, i3)));
                return i3 + 4;
            } else {
                throw zzfi.d();
            }
        } else {
            throw zzfi.d();
        }
    }

    static int a(int i2, byte[] bArr, int i3, int i4, Sa sa) throws zzfi {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return b(bArr, i3, sa);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return a(bArr, i3, sa) + sa.f5038a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = a(bArr, i3, sa);
                    i7 = sa.f5038a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = a(i7, bArr, i3, i4, sa);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw zzfi.h();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw zzfi.d();
            }
        } else {
            throw zzfi.d();
        }
    }
}
