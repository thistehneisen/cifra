package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.od reason: case insensitive filesystem */
public final class C0413od {

    /* renamed from: a reason: collision with root package name */
    private final byte[] f5300a;

    /* renamed from: b reason: collision with root package name */
    private final int f5301b;

    /* renamed from: c reason: collision with root package name */
    private final int f5302c;

    /* renamed from: d reason: collision with root package name */
    private int f5303d;

    /* renamed from: e reason: collision with root package name */
    private int f5304e;

    /* renamed from: f reason: collision with root package name */
    private int f5305f;

    /* renamed from: g reason: collision with root package name */
    private int f5306g;

    /* renamed from: h reason: collision with root package name */
    private int f5307h = Integer.MAX_VALUE;

    /* renamed from: i reason: collision with root package name */
    private int f5308i;

    /* renamed from: j reason: collision with root package name */
    private int f5309j = 64;

    /* renamed from: k reason: collision with root package name */
    private int f5310k = 67108864;

    /* renamed from: l reason: collision with root package name */
    private C0381jb f5311l;

    private C0413od(byte[] bArr, int i2, int i3) {
        this.f5300a = bArr;
        this.f5301b = 0;
        int i4 = i3 + 0;
        this.f5303d = i4;
        this.f5302c = i4;
        this.f5305f = 0;
    }

    public static C0413od a(byte[] bArr, int i2, int i3) {
        return new C0413od(bArr, 0, i3);
    }

    private final void b(int i2) throws zzit {
        if (this.f5306g != i2) {
            throw new zzit("Protocol message end-group tag did not match expected tag.");
        }
    }

    private final void g() {
        this.f5303d += this.f5304e;
        int i2 = this.f5303d;
        int i3 = this.f5307h;
        if (i2 > i3) {
            this.f5304e = i2 - i3;
            this.f5303d = i2 - this.f5304e;
            return;
        }
        this.f5304e = 0;
    }

    private final byte h() throws IOException {
        int i2 = this.f5305f;
        if (i2 != this.f5303d) {
            byte[] bArr = this.f5300a;
            this.f5305f = i2 + 1;
            return bArr[i2];
        }
        throw zzit.a();
    }

    public final int c() throws IOException {
        if (this.f5305f == this.f5303d) {
            this.f5306g = 0;
            return 0;
        }
        this.f5306g = e();
        int i2 = this.f5306g;
        if (i2 != 0) {
            return i2;
        }
        throw new zzit("Protocol message contained an invalid tag (zero).");
    }

    public final boolean d() throws IOException {
        return e() != 0;
    }

    public final int e() throws IOException {
        byte b2;
        int i2;
        byte h2 = h();
        if (h2 >= 0) {
            return h2;
        }
        byte b3 = h2 & Byte.MAX_VALUE;
        byte h3 = h();
        if (h3 >= 0) {
            i2 = h3 << 7;
        } else {
            b3 |= (h3 & Byte.MAX_VALUE) << 7;
            byte h4 = h();
            if (h4 >= 0) {
                i2 = h4 << 14;
            } else {
                b3 |= (h4 & Byte.MAX_VALUE) << 14;
                byte h5 = h();
                if (h5 >= 0) {
                    i2 = h5 << 21;
                } else {
                    byte b4 = b3 | ((h5 & Byte.MAX_VALUE) << 21);
                    byte h6 = h();
                    b2 = b4 | (h6 << 28);
                    if (h6 < 0) {
                        for (int i3 = 0; i3 < 5; i3++) {
                            if (h() >= 0) {
                                return b2;
                            }
                        }
                        throw zzit.c();
                    }
                    return b2;
                }
            }
        }
        b2 = b3 | i2;
        return b2;
    }

    public final long f() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte h2 = h();
            j2 |= ((long) (h2 & Byte.MAX_VALUE)) << i2;
            if ((h2 & 128) == 0) {
                return j2;
            }
        }
        throw zzit.c();
    }

    public final boolean a(int i2) throws IOException {
        int c2;
        int i3 = i2 & 7;
        if (i3 == 0) {
            e();
            return true;
        } else if (i3 == 1) {
            h();
            h();
            h();
            h();
            h();
            h();
            h();
            h();
            return true;
        } else if (i3 == 2) {
            c(e());
            return true;
        } else if (i3 == 3) {
            do {
                c2 = c();
                if (c2 == 0) {
                    break;
                }
            } while (a(c2));
            b(((i2 >>> 3) << 3) | 4);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                h();
                h();
                h();
                h();
                return true;
            }
            throw new zzit("Protocol message tag had invalid wire type.");
        }
    }

    public final String b() throws IOException {
        int e2 = e();
        if (e2 >= 0) {
            int i2 = this.f5303d;
            int i3 = this.f5305f;
            if (e2 <= i2 - i3) {
                String str = new String(this.f5300a, i3, e2, C0454vd.f5407a);
                this.f5305f += e2;
                return str;
            }
            throw zzit.a();
        }
        throw zzit.b();
    }

    private final void c(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f5305f;
            int i4 = i3 + i2;
            int i5 = this.f5307h;
            if (i4 > i5) {
                c(i5 - i3);
                throw zzit.a();
            } else if (i2 <= this.f5303d - i3) {
                this.f5305f = i3 + i2;
            } else {
                throw zzit.a();
            }
        } else {
            throw zzit.b();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(int i2, int i3) {
        int i4 = this.f5305f;
        int i5 = this.f5301b;
        if (i2 > i4 - i5) {
            int i6 = i4 - i5;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Position ");
            sb.append(i2);
            sb.append(" is beyond current ");
            sb.append(i6);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 >= 0) {
            this.f5305f = i5 + i2;
            this.f5306g = i3;
        } else {
            StringBuilder sb2 = new StringBuilder(24);
            sb2.append("Bad position ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final void a(C0466xd xdVar) throws IOException {
        int e2 = e();
        if (this.f5308i >= this.f5309j) {
            throw new zzit("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        } else if (e2 >= 0) {
            int i2 = e2 + this.f5305f;
            int i3 = this.f5307h;
            if (i2 <= i3) {
                this.f5307h = i2;
                g();
                this.f5308i++;
                xdVar.a(this);
                b(0);
                this.f5308i--;
                this.f5307h = i3;
                g();
                return;
            }
            throw zzit.a();
        } else {
            throw zzit.b();
        }
    }

    public final <T extends Eb<T, ?>> T a(C0447uc<T> ucVar) throws IOException {
        try {
            if (this.f5311l == null) {
                this.f5311l = C0381jb.a(this.f5300a, this.f5301b, this.f5302c);
            }
            int t = this.f5311l.t();
            int i2 = this.f5305f - this.f5301b;
            if (t <= i2) {
                this.f5311l.f(i2 - t);
                this.f5311l.c(this.f5309j - this.f5308i);
                T t2 = (Eb) this.f5311l.a(ucVar, C0428rb.c());
                a(this.f5306g);
                return t2;
            }
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(t), Integer.valueOf(i2)}));
        } catch (zzfi e2) {
            throw new zzit("", e2);
        }
    }

    public final int a() {
        return this.f5305f - this.f5301b;
    }

    public final byte[] a(int i2, int i3) {
        if (i3 == 0) {
            return C0472yd.f5438h;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f5300a, this.f5301b + i2, bArr, 0, i3);
        return bArr;
    }
}
