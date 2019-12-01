package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.measurement.lb reason: case insensitive filesystem */
final class C0393lb extends C0381jb {

    /* renamed from: f reason: collision with root package name */
    private final byte[] f5262f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f5263g;

    /* renamed from: h reason: collision with root package name */
    private int f5264h;

    /* renamed from: i reason: collision with root package name */
    private int f5265i;

    /* renamed from: j reason: collision with root package name */
    private int f5266j;

    /* renamed from: k reason: collision with root package name */
    private int f5267k;

    /* renamed from: l reason: collision with root package name */
    private int f5268l;
    private int m;

    private C0393lb(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.m = Integer.MAX_VALUE;
        this.f5262f = bArr;
        this.f5264h = i3 + i2;
        this.f5266j = i2;
        this.f5267k = this.f5266j;
        this.f5263g = z;
    }

    private final byte A() throws IOException {
        int i2 = this.f5266j;
        if (i2 != this.f5264h) {
            byte[] bArr = this.f5262f;
            this.f5266j = i2 + 1;
            return bArr[i2];
        }
        throw zzfi.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    private final int v() throws IOException {
        byte b2;
        int i2 = this.f5266j;
        int i3 = this.f5264h;
        if (i3 != i2) {
            byte[] bArr = this.f5262f;
            int i4 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                this.f5266j = i4;
                return b3;
            } else if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                byte b4 = b3 ^ (bArr[i4] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b5 = b4 ^ (bArr[i5] << 14);
                    if (b5 >= 0) {
                        b2 = b5 ^ 16256;
                    } else {
                        i5 = i6 + 1;
                        byte b6 = b5 ^ (bArr[i6] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ -2080896;
                        } else {
                            i6 = i5 + 1;
                            byte b7 = bArr[i5];
                            b2 = (b6 ^ (b7 << 28)) ^ 266354560;
                            if (b7 < 0) {
                                i5 = i6 + 1;
                                if (bArr[i6] < 0) {
                                    i6 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i6 + 1;
                                        if (bArr[i6] < 0) {
                                            i6 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i6 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i5 = i6;
                }
                this.f5266j = i5;
                return b2;
            }
        }
        return (int) u();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    private final long w() throws IOException {
        long j2;
        int i2;
        long j3;
        long j4;
        byte b2;
        int i3 = this.f5266j;
        int i4 = this.f5264h;
        if (i4 != i3) {
            byte[] bArr = this.f5262f;
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                this.f5266j = i5;
                return (long) b3;
            } else if (i4 - i5 >= 9) {
                int i6 = i5 + 1;
                byte b4 = b3 ^ (bArr[i5] << 7);
                if (b4 < 0) {
                    b2 = b4 ^ Byte.MIN_VALUE;
                } else {
                    int i7 = i6 + 1;
                    byte b5 = b4 ^ (bArr[i6] << 14);
                    if (b5 >= 0) {
                        i2 = i7;
                        j2 = (long) (b5 ^ 16256);
                    } else {
                        i6 = i7 + 1;
                        byte b6 = b5 ^ (bArr[i7] << 21);
                        if (b6 < 0) {
                            b2 = b6 ^ -2080896;
                        } else {
                            long j5 = (long) b6;
                            int i8 = i6 + 1;
                            long j6 = j5 ^ (((long) bArr[i6]) << 28);
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i9 = i8 + 1;
                                long j7 = j6 ^ (((long) bArr[i8]) << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i8 = i9 + 1;
                                    j6 = j7 ^ (((long) bArr[i9]) << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i9 = i8 + 1;
                                        j7 = j6 ^ (((long) bArr[i8]) << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            int i10 = i9 + 1;
                                            long j8 = (j7 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                i2 = i10 + 1;
                                            } else {
                                                i2 = i10;
                                            }
                                            j2 = j8;
                                        }
                                    }
                                }
                                j2 = j7 ^ j3;
                            }
                            j2 = j6 ^ j4;
                            i2 = i8;
                        }
                    }
                    this.f5266j = i2;
                    return j2;
                }
                j2 = (long) b2;
                this.f5266j = i2;
                return j2;
            }
        }
        return u();
    }

    private final int x() throws IOException {
        int i2 = this.f5266j;
        if (this.f5264h - i2 >= 4) {
            byte[] bArr = this.f5262f;
            this.f5266j = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw zzfi.a();
    }

    private final long y() throws IOException {
        int i2 = this.f5266j;
        if (this.f5264h - i2 >= 8) {
            byte[] bArr = this.f5262f;
            this.f5266j = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }
        throw zzfi.a();
    }

    private final void z() {
        this.f5264h += this.f5265i;
        int i2 = this.f5264h;
        int i3 = i2 - this.f5267k;
        int i4 = this.m;
        if (i3 > i4) {
            this.f5265i = i3 - i4;
            this.f5264h = i2 - this.f5265i;
            return;
        }
        this.f5265i = 0;
    }

    public final void a(int i2) throws zzfi {
        if (this.f5268l != i2) {
            throw zzfi.e();
        }
    }

    public final boolean b(int i2) throws IOException {
        int d2;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.f5264h - this.f5266j >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.f5262f;
                    int i5 = this.f5266j;
                    this.f5266j = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw zzfi.c();
            }
            while (i4 < 10) {
                if (A() < 0) {
                    i4++;
                }
            }
            throw zzfi.c();
            return true;
        } else if (i3 == 1) {
            f(8);
            return true;
        } else if (i3 == 2) {
            f(v());
            return true;
        } else if (i3 == 3) {
            do {
                d2 = d();
                if (d2 == 0) {
                    break;
                }
            } while (b(d2));
            a(((i2 >>> 3) << 3) | 4);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                f(4);
                return true;
            }
            throw zzfi.f();
        }
    }

    public final String c() throws IOException {
        int v = v();
        if (v > 0) {
            int i2 = this.f5264h;
            int i3 = this.f5266j;
            if (v <= i2 - i3) {
                String str = new String(this.f5262f, i3, v, Fb.f4930a);
                this.f5266j += v;
                return str;
            }
        }
        if (v == 0) {
            return "";
        }
        if (v < 0) {
            throw zzfi.b();
        }
        throw zzfi.a();
    }

    public final int d() throws IOException {
        if (s()) {
            this.f5268l = 0;
            return 0;
        }
        this.f5268l = v();
        int i2 = this.f5268l;
        if ((i2 >>> 3) != 0) {
            return i2;
        }
        throw zzfi.d();
    }

    public final long e() throws IOException {
        return w();
    }

    public final long f() throws IOException {
        return w();
    }

    public final int g() throws IOException {
        return v();
    }

    public final long h() throws IOException {
        return y();
    }

    public final int i() throws IOException {
        return x();
    }

    public final boolean j() throws IOException {
        return w() != 0;
    }

    public final String k() throws IOException {
        int v = v();
        if (v > 0) {
            int i2 = this.f5264h;
            int i3 = this.f5266j;
            if (v <= i2 - i3) {
                String b2 = C0326ad.b(this.f5262f, i3, v);
                this.f5266j += v;
                return b2;
            }
        }
        if (v == 0) {
            return "";
        }
        if (v <= 0) {
            throw zzfi.b();
        }
        throw zzfi.a();
    }

    public final Xa l() throws IOException {
        byte[] bArr;
        int v = v();
        if (v > 0) {
            int i2 = this.f5264h;
            int i3 = this.f5266j;
            if (v <= i2 - i3) {
                Xa a2 = Xa.a(this.f5262f, i3, v);
                this.f5266j += v;
                return a2;
            }
        }
        if (v == 0) {
            return Xa.f5082a;
        }
        if (v > 0) {
            int i4 = this.f5264h;
            int i5 = this.f5266j;
            if (v <= i4 - i5) {
                this.f5266j = v + i5;
                bArr = Arrays.copyOfRange(this.f5262f, i5, this.f5266j);
                return Xa.a(bArr);
            }
        }
        if (v > 0) {
            throw zzfi.a();
        } else if (v == 0) {
            bArr = Fb.f4932c;
            return Xa.a(bArr);
        } else {
            throw zzfi.b();
        }
    }

    public final int m() throws IOException {
        return v();
    }

    public final int n() throws IOException {
        return v();
    }

    public final int o() throws IOException {
        return x();
    }

    public final long p() throws IOException {
        return y();
    }

    public final int q() throws IOException {
        return C0381jb.g(v());
    }

    public final long r() throws IOException {
        return C0381jb.a(w());
    }

    public final boolean s() throws IOException {
        return this.f5266j == this.f5264h;
    }

    public final int t() {
        return this.f5266j - this.f5267k;
    }

    /* access modifiers changed from: 0000 */
    public final long u() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte A = A();
            j2 |= ((long) (A & Byte.MAX_VALUE)) << i2;
            if ((A & 128) == 0) {
                return j2;
            }
        }
        throw zzfi.c();
    }

    public final void e(int i2) {
        this.m = i2;
        z();
    }

    public final void f(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f5264h;
            int i4 = this.f5266j;
            if (i2 <= i3 - i4) {
                this.f5266j = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw zzfi.b();
        }
        throw zzfi.a();
    }

    public final double a() throws IOException {
        return Double.longBitsToDouble(y());
    }

    public final <T extends C0400mc> T a(C0447uc<T> ucVar, C0428rb rbVar) throws IOException {
        int v = v();
        if (this.f5229a < this.f5230b) {
            int d2 = d(v);
            this.f5229a++;
            T t = (C0400mc) ucVar.a(this, rbVar);
            a(0);
            this.f5229a--;
            e(d2);
            return t;
        }
        throw zzfi.g();
    }

    public final int d(int i2) throws zzfi {
        if (i2 >= 0) {
            int t = i2 + t();
            int i3 = this.m;
            if (t <= i3) {
                this.m = t;
                z();
                return i3;
            }
            throw zzfi.a();
        }
        throw zzfi.b();
    }

    public final float b() throws IOException {
        return Float.intBitsToFloat(x());
    }
}
