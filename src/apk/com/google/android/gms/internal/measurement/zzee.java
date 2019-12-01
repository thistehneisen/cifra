package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzee extends Ua {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f5467a = Logger.getLogger(zzee.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static final boolean f5468b = Yc.a();

    /* renamed from: c reason: collision with root package name */
    C0411ob f5469c = this;

    static class a extends zzee {

        /* renamed from: d reason: collision with root package name */
        private final byte[] f5470d;

        /* renamed from: e reason: collision with root package name */
        private final int f5471e;

        /* renamed from: f reason: collision with root package name */
        private final int f5472f;

        /* renamed from: g reason: collision with root package name */
        private int f5473g;

        a(byte[] bArr, int i2, int i3) {
            super();
            if (bArr != null) {
                int i4 = i2 + i3;
                if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                    this.f5470d = bArr;
                    this.f5471e = i2;
                    this.f5473g = i2;
                    this.f5472f = i4;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            throw new NullPointerException("buffer");
        }

        public void a() {
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void d(int i2) throws IOException {
            try {
                byte[] bArr = this.f5470d;
                int i3 = this.f5473g;
                this.f5473g = i3 + 1;
                bArr[i3] = (byte) i2;
                byte[] bArr2 = this.f5470d;
                int i4 = this.f5473g;
                this.f5473g = i4 + 1;
                bArr2[i4] = (byte) (i2 >> 8);
                byte[] bArr3 = this.f5470d;
                int i5 = this.f5473g;
                this.f5473g = i5 + 1;
                bArr3[i5] = (byte) (i2 >> 16);
                byte[] bArr4 = this.f5470d;
                int i6 = this.f5473g;
                this.f5473g = i6 + 1;
                bArr4[i6] = (byte) (i2 >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5473g), Integer.valueOf(this.f5472f), Integer.valueOf(1)}), e2);
            }
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public final void a(int i2, long j2) throws IOException {
            a(i2, 0);
            a(j2);
        }

        public final void b(Xa xa) throws IOException {
            b(xa.size());
            xa.a((Ua) this);
        }

        public final void c(int i2, long j2) throws IOException {
            a(i2, 1);
            c(j2);
        }

        public final int e() {
            return this.f5473g - this.f5471e;
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void b(int i2, C0400mc mcVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, mcVar);
            a(1, 4);
        }

        public final void c(C0400mc mcVar) throws IOException {
            b(mcVar.c());
            mcVar.a(this);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            b(str);
        }

        public final void c(long j2) throws IOException {
            try {
                byte[] bArr = this.f5470d;
                int i2 = this.f5473g;
                this.f5473g = i2 + 1;
                bArr[i2] = (byte) ((int) j2);
                byte[] bArr2 = this.f5470d;
                int i3 = this.f5473g;
                this.f5473g = i3 + 1;
                bArr2[i3] = (byte) ((int) (j2 >> 8));
                byte[] bArr3 = this.f5470d;
                int i4 = this.f5473g;
                this.f5473g = i4 + 1;
                bArr3[i4] = (byte) ((int) (j2 >> 16));
                byte[] bArr4 = this.f5470d;
                int i5 = this.f5473g;
                this.f5473g = i5 + 1;
                bArr4[i5] = (byte) ((int) (j2 >> 24));
                byte[] bArr5 = this.f5470d;
                int i6 = this.f5473g;
                this.f5473g = i6 + 1;
                bArr5[i6] = (byte) ((int) (j2 >> 32));
                byte[] bArr6 = this.f5470d;
                int i7 = this.f5473g;
                this.f5473g = i7 + 1;
                bArr6[i7] = (byte) ((int) (j2 >> 40));
                byte[] bArr7 = this.f5470d;
                int i8 = this.f5473g;
                this.f5473g = i8 + 1;
                bArr7[i8] = (byte) ((int) (j2 >> 48));
                byte[] bArr8 = this.f5470d;
                int i9 = this.f5473g;
                this.f5473g = i9 + 1;
                bArr8[i9] = (byte) ((int) (j2 >> 56));
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5473g), Integer.valueOf(this.f5472f), Integer.valueOf(1)}), e2);
            }
        }

        public final void a(int i2, Xa xa) throws IOException {
            a(i2, 2);
            b(xa);
        }

        public final void b(int i2, Xa xa) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, xa);
            a(1, 4);
        }

        public final void a(int i2, C0400mc mcVar) throws IOException {
            a(i2, 2);
            c(mcVar);
        }

        /* access modifiers changed from: 0000 */
        public final void a(int i2, C0400mc mcVar, Ac ac) throws IOException {
            a(i2, 2);
            Na na = (Na) mcVar;
            int h2 = na.h();
            if (h2 == -1) {
                h2 = ac.b(na);
                na.a(h2);
            }
            b(h2);
            ac.a(mcVar, (C0419pd) this.f5469c);
        }

        public final void b(int i2) throws IOException {
            if (!zzee.f5468b || Qa.a() || b() < 5) {
                while ((i2 & -128) != 0) {
                    byte[] bArr = this.f5470d;
                    int i3 = this.f5473g;
                    this.f5473g = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f5470d;
                    int i4 = this.f5473g;
                    this.f5473g = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5473g), Integer.valueOf(this.f5472f), Integer.valueOf(1)}), e2);
                }
            } else if ((i2 & -128) == 0) {
                byte[] bArr3 = this.f5470d;
                int i5 = this.f5473g;
                this.f5473g = i5 + 1;
                Yc.a(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.f5470d;
                int i6 = this.f5473g;
                this.f5473g = i6 + 1;
                Yc.a(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & -128) == 0) {
                    byte[] bArr5 = this.f5470d;
                    int i8 = this.f5473g;
                    this.f5473g = i8 + 1;
                    Yc.a(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.f5470d;
                int i9 = this.f5473g;
                this.f5473g = i9 + 1;
                Yc.a(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & -128) == 0) {
                    byte[] bArr7 = this.f5470d;
                    int i11 = this.f5473g;
                    this.f5473g = i11 + 1;
                    Yc.a(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.f5470d;
                int i12 = this.f5473g;
                this.f5473g = i12 + 1;
                Yc.a(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & -128) == 0) {
                    byte[] bArr9 = this.f5470d;
                    int i14 = this.f5473g;
                    this.f5473g = i14 + 1;
                    Yc.a(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.f5470d;
                int i15 = this.f5473g;
                this.f5473g = i15 + 1;
                Yc.a(bArr10, (long) i15, (byte) (i13 | 128));
                int i16 = i13 >>> 7;
                byte[] bArr11 = this.f5470d;
                int i17 = this.f5473g;
                this.f5473g = i17 + 1;
                Yc.a(bArr11, (long) i17, (byte) i16);
            }
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f5470d;
                int i2 = this.f5473g;
                this.f5473g = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5473g), Integer.valueOf(this.f5472f), Integer.valueOf(1)}), e2);
            }
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void a(long j2) throws IOException {
            if (!zzee.f5468b || b() < 10) {
                while ((j2 & -128) != 0) {
                    byte[] bArr = this.f5470d;
                    int i2 = this.f5473g;
                    this.f5473g = i2 + 1;
                    bArr[i2] = (byte) ((((int) j2) & 127) | 128);
                    j2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.f5470d;
                    int i3 = this.f5473g;
                    this.f5473g = i3 + 1;
                    bArr2[i3] = (byte) ((int) j2);
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5473g), Integer.valueOf(this.f5472f), Integer.valueOf(1)}), e2);
                }
            } else {
                while ((j2 & -128) != 0) {
                    byte[] bArr3 = this.f5470d;
                    int i4 = this.f5473g;
                    this.f5473g = i4 + 1;
                    Yc.a(bArr3, (long) i4, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                byte[] bArr4 = this.f5470d;
                int i5 = this.f5473g;
                this.f5473g = i5 + 1;
                Yc.a(bArr4, (long) i5, (byte) ((int) j2));
            }
        }

        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.f5470d, this.f5473g, i3);
                this.f5473g += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f5473g), Integer.valueOf(this.f5472f), Integer.valueOf(i3)}), e2);
            }
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void b(String str) throws IOException {
            int i2 = this.f5473g;
            try {
                int g2 = zzee.g(str.length() * 3);
                int g3 = zzee.g(str.length());
                if (g3 == g2) {
                    this.f5473g = i2 + g3;
                    int a2 = C0326ad.a(str, this.f5470d, this.f5473g, b());
                    this.f5473g = i2;
                    b((a2 - i2) - g3);
                    this.f5473g = a2;
                    return;
                }
                b(C0326ad.a((CharSequence) str));
                this.f5473g = C0326ad.a(str, this.f5470d, this.f5473g, b());
            } catch (C0353ed e2) {
                this.f5473g = i2;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzb((Throwable) e3);
            }
        }

        public final int b() {
            return this.f5472f - this.f5473g;
        }
    }

    static final class b extends a {

        /* renamed from: h reason: collision with root package name */
        private final ByteBuffer f5474h;

        /* renamed from: i reason: collision with root package name */
        private int f5475i;

        b(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.f5474h = byteBuffer;
            this.f5475i = byteBuffer.position();
        }

        public final void a() {
            this.f5474h.position(this.f5475i + e());
        }
    }

    static final class c extends zzee {

        /* renamed from: d reason: collision with root package name */
        private final ByteBuffer f5476d;

        /* renamed from: e reason: collision with root package name */
        private final ByteBuffer f5477e;

        /* renamed from: f reason: collision with root package name */
        private final long f5478f;

        /* renamed from: g reason: collision with root package name */
        private final long f5479g;

        /* renamed from: h reason: collision with root package name */
        private final long f5480h;

        /* renamed from: i reason: collision with root package name */
        private final long f5481i = (this.f5480h - 10);

        /* renamed from: j reason: collision with root package name */
        private long f5482j = this.f5479g;

        c(ByteBuffer byteBuffer) {
            super();
            this.f5476d = byteBuffer;
            this.f5477e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f5478f = Yc.a(byteBuffer);
            this.f5479g = this.f5478f + ((long) byteBuffer.position());
            this.f5480h = this.f5478f + ((long) byteBuffer.limit());
        }

        private final void j(long j2) {
            this.f5477e.position((int) (j2 - this.f5478f));
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void d(int i2) throws IOException {
            this.f5477e.putInt((int) (this.f5482j - this.f5478f), i2);
            this.f5482j += 4;
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public final void a(int i2, long j2) throws IOException {
            a(i2, 0);
            a(j2);
        }

        public final void b(int i2, C0400mc mcVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, mcVar);
            a(1, 4);
        }

        public final void c(int i2, long j2) throws IOException {
            a(i2, 1);
            c(j2);
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void c(C0400mc mcVar) throws IOException {
            b(mcVar.c());
            mcVar.a(this);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            b(str);
        }

        public final void b(int i2, Xa xa) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, xa);
            a(1, 4);
        }

        public final void c(long j2) throws IOException {
            this.f5477e.putLong((int) (this.f5482j - this.f5478f), j2);
            this.f5482j += 8;
        }

        public final void a(int i2, Xa xa) throws IOException {
            a(i2, 2);
            b(xa);
        }

        public final void a(int i2, C0400mc mcVar) throws IOException {
            a(i2, 2);
            c(mcVar);
        }

        /* access modifiers changed from: 0000 */
        public final void b(C0400mc mcVar, Ac ac) throws IOException {
            Na na = (Na) mcVar;
            int h2 = na.h();
            if (h2 == -1) {
                h2 = ac.b(na);
                na.a(h2);
            }
            b(h2);
            ac.a(mcVar, (C0419pd) this.f5469c);
        }

        /* access modifiers changed from: 0000 */
        public final void a(int i2, C0400mc mcVar, Ac ac) throws IOException {
            a(i2, 2);
            b(mcVar, ac);
        }

        public final void a(byte b2) throws IOException {
            long j2 = this.f5482j;
            if (j2 < this.f5480h) {
                this.f5482j = 1 + j2;
                Yc.a(j2, b2);
                return;
            }
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j2), Long.valueOf(this.f5480h), Integer.valueOf(1)}));
        }

        public final void b(Xa xa) throws IOException {
            b(xa.size());
            xa.a((Ua) this);
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void b(int i2) throws IOException {
            if (this.f5482j <= this.f5481i) {
                while ((i2 & -128) != 0) {
                    long j2 = this.f5482j;
                    this.f5482j = j2 + 1;
                    Yc.a(j2, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                long j3 = this.f5482j;
                this.f5482j = 1 + j3;
                Yc.a(j3, (byte) i2);
                return;
            }
            while (true) {
                long j4 = this.f5482j;
                if (j4 >= this.f5480h) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j4), Long.valueOf(this.f5480h), Integer.valueOf(1)}));
                } else if ((i2 & -128) == 0) {
                    this.f5482j = 1 + j4;
                    Yc.a(j4, (byte) i2);
                    return;
                } else {
                    this.f5482j = j4 + 1;
                    Yc.a(j4, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
        }

        public final void a(long j2) throws IOException {
            if (this.f5482j <= this.f5481i) {
                while ((j2 & -128) != 0) {
                    long j3 = this.f5482j;
                    this.f5482j = j3 + 1;
                    Yc.a(j3, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
                long j4 = this.f5482j;
                this.f5482j = 1 + j4;
                Yc.a(j4, (byte) ((int) j2));
                return;
            }
            while (true) {
                long j5 = this.f5482j;
                if (j5 >= this.f5480h) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j5), Long.valueOf(this.f5480h), Integer.valueOf(1)}));
                } else if ((j2 & -128) == 0) {
                    this.f5482j = 1 + j5;
                    Yc.a(j5, (byte) ((int) j2));
                    return;
                } else {
                    this.f5482j = j5 + 1;
                    Yc.a(j5, (byte) ((((int) j2) & 127) | 128));
                    j2 >>>= 7;
                }
            }
        }

        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = (long) i3;
                long j3 = this.f5480h - j2;
                long j4 = this.f5482j;
                if (j3 >= j4) {
                    Yc.a(bArr, (long) i2, j4, j2);
                    this.f5482j += j2;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new zzb(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.f5482j), Long.valueOf(this.f5480h), Integer.valueOf(i3)}));
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void a() {
            this.f5476d.position((int) (this.f5482j - this.f5478f));
        }

        public final void b(String str) throws IOException {
            long j2 = this.f5482j;
            try {
                int g2 = zzee.g(str.length() * 3);
                int g3 = zzee.g(str.length());
                if (g3 == g2) {
                    int i2 = ((int) (this.f5482j - this.f5478f)) + g3;
                    this.f5477e.position(i2);
                    C0326ad.a((CharSequence) str, this.f5477e);
                    int position = this.f5477e.position() - i2;
                    b(position);
                    this.f5482j += (long) position;
                    return;
                }
                int a2 = C0326ad.a((CharSequence) str);
                b(a2);
                j(this.f5482j);
                C0326ad.a((CharSequence) str, this.f5477e);
                this.f5482j += (long) a2;
            } catch (C0353ed e2) {
                this.f5482j = j2;
                j(this.f5482j);
                a(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzb((Throwable) e3);
            } catch (IndexOutOfBoundsException e4) {
                throw new zzb((Throwable) e4);
            }
        }

        public final int b() {
            return (int) (this.f5480h - this.f5482j);
        }
    }

    static final class d extends zzee {

        /* renamed from: d reason: collision with root package name */
        private final ByteBuffer f5483d;

        /* renamed from: e reason: collision with root package name */
        private final ByteBuffer f5484e;

        /* renamed from: f reason: collision with root package name */
        private final int f5485f;

        d(ByteBuffer byteBuffer) {
            super();
            this.f5483d = byteBuffer;
            this.f5484e = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.f5485f = byteBuffer.position();
        }

        public final void a(int i2, int i3) throws IOException {
            b((i2 << 3) | i3);
        }

        public final void b(int i2, int i3) throws IOException {
            a(i2, 0);
            a(i3);
        }

        public final void c(int i2, int i3) throws IOException {
            a(i2, 0);
            b(i3);
        }

        public final void d(int i2) throws IOException {
            try {
                this.f5484e.putInt(i2);
            } catch (BufferOverflowException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void e(int i2, int i3) throws IOException {
            a(i2, 5);
            d(i3);
        }

        public final void a(int i2, long j2) throws IOException {
            a(i2, 0);
            a(j2);
        }

        public final void b(int i2, C0400mc mcVar) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, mcVar);
            a(1, 4);
        }

        public final void c(int i2, long j2) throws IOException {
            a(i2, 1);
            c(j2);
        }

        public final void a(int i2, boolean z) throws IOException {
            a(i2, 0);
            a(z ? (byte) 1 : 0);
        }

        public final void c(C0400mc mcVar) throws IOException {
            b(mcVar.c());
            mcVar.a(this);
        }

        public final void a(int i2, String str) throws IOException {
            a(i2, 2);
            b(str);
        }

        public final void b(int i2, Xa xa) throws IOException {
            a(1, 3);
            c(2, i2);
            a(3, xa);
            a(1, 4);
        }

        public final void c(long j2) throws IOException {
            try {
                this.f5484e.putLong(j2);
            } catch (BufferOverflowException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void a(int i2, Xa xa) throws IOException {
            a(i2, 2);
            b(xa);
        }

        private final void c(String str) throws IOException {
            try {
                C0326ad.a((CharSequence) str, this.f5484e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void a(int i2, C0400mc mcVar) throws IOException {
            a(i2, 2);
            c(mcVar);
        }

        /* access modifiers changed from: 0000 */
        public final void b(C0400mc mcVar, Ac ac) throws IOException {
            Na na = (Na) mcVar;
            int h2 = na.h();
            if (h2 == -1) {
                h2 = ac.b(na);
                na.a(h2);
            }
            b(h2);
            ac.a(mcVar, (C0419pd) this.f5469c);
        }

        /* access modifiers changed from: 0000 */
        public final void a(int i2, C0400mc mcVar, Ac ac) throws IOException {
            a(i2, 2);
            b(mcVar, ac);
        }

        public final void a(byte b2) throws IOException {
            try {
                this.f5484e.put(b2);
            } catch (BufferOverflowException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void a(int i2) throws IOException {
            if (i2 >= 0) {
                b(i2);
            } else {
                a((long) i2);
            }
        }

        public final void b(Xa xa) throws IOException {
            b(xa.size());
            xa.a((Ua) this);
        }

        public final void a(long j2) throws IOException {
            while ((-128 & j2) != 0) {
                this.f5484e.put((byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            try {
                this.f5484e.put((byte) ((int) j2));
            } catch (BufferOverflowException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void b(int i2) throws IOException {
            while ((i2 & -128) != 0) {
                this.f5484e.put((byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            try {
                this.f5484e.put((byte) i2);
            } catch (BufferOverflowException e2) {
                throw new zzb((Throwable) e2);
            }
        }

        public final void a(byte[] bArr, int i2, int i3) throws IOException {
            b(bArr, i2, i3);
        }

        public final void a() {
            this.f5483d.position(this.f5484e.position());
        }

        public final void b(byte[] bArr, int i2, int i3) throws IOException {
            try {
                this.f5484e.put(bArr, i2, i3);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb((Throwable) e2);
            } catch (BufferOverflowException e3) {
                throw new zzb((Throwable) e3);
            }
        }

        public final void b(String str) throws IOException {
            int position = this.f5484e.position();
            try {
                int g2 = zzee.g(str.length() * 3);
                int g3 = zzee.g(str.length());
                if (g3 == g2) {
                    int position2 = this.f5484e.position() + g3;
                    this.f5484e.position(position2);
                    c(str);
                    int position3 = this.f5484e.position();
                    this.f5484e.position(position);
                    b(position3 - position2);
                    this.f5484e.position(position3);
                    return;
                }
                b(C0326ad.a((CharSequence) str));
                c(str);
            } catch (C0353ed e2) {
                this.f5484e.position(position);
                a(str, e2);
            } catch (IllegalArgumentException e3) {
                throw new zzb((Throwable) e3);
            }
        }

        public final int b() {
            return this.f5484e.remaining();
        }
    }

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(String str) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        zzb(String str, Throwable th) {
            String valueOf = String.valueOf(str);
            String str2 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
            super(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
        }
    }

    private zzee() {
    }

    public static zzee a(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int b(double d2) {
        return 8;
    }

    public static int b(float f2) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int e(int i2, long j2) {
        return e(i2) + e(j2);
    }

    public static int e(long j2) {
        int i2;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if ((-34359738368L & j2) != 0) {
            i2 = 6;
            j2 >>>= 28;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        if ((j2 & -16384) != 0) {
            i2++;
        }
        return i2;
    }

    public static int f(int i2, int i3) {
        return e(i2) + f(i3);
    }

    public static int g(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int g(int i2, int i3) {
        return e(i2) + g(i3);
    }

    public static int g(long j2) {
        return 8;
    }

    public static int h(int i2, int i3) {
        return e(i2) + g(m(i3));
    }

    public static int h(long j2) {
        return 8;
    }

    public static int i(int i2) {
        return 4;
    }

    public static int i(int i2, int i3) {
        return e(i2) + 4;
    }

    private static long i(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public static int j(int i2) {
        return 4;
    }

    public static int j(int i2, int i3) {
        return e(i2) + 4;
    }

    public static int k(int i2, int i3) {
        return e(i2) + f(i3);
    }

    @Deprecated
    public static int l(int i2) {
        return g(i2);
    }

    private static int m(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public abstract void a() throws IOException;

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i2) throws IOException;

    public abstract void a(int i2, int i3) throws IOException;

    public abstract void a(int i2, long j2) throws IOException;

    public abstract void a(int i2, Xa xa) throws IOException;

    public abstract void a(int i2, C0400mc mcVar) throws IOException;

    /* access modifiers changed from: 0000 */
    public abstract void a(int i2, C0400mc mcVar, Ac ac) throws IOException;

    public abstract void a(int i2, String str) throws IOException;

    public abstract void a(int i2, boolean z) throws IOException;

    public abstract void a(long j2) throws IOException;

    public abstract int b();

    public abstract void b(int i2) throws IOException;

    public abstract void b(int i2, int i3) throws IOException;

    public final void b(int i2, long j2) throws IOException {
        a(i2, i(j2));
    }

    public abstract void b(int i2, Xa xa) throws IOException;

    public abstract void b(int i2, C0400mc mcVar) throws IOException;

    public abstract void b(byte[] bArr, int i2, int i3) throws IOException;

    public final void c(int i2) throws IOException {
        b(m(i2));
    }

    public abstract void c(int i2, int i3) throws IOException;

    public abstract void c(int i2, long j2) throws IOException;

    public abstract void c(long j2) throws IOException;

    public abstract void d(int i2) throws IOException;

    public final void d(int i2, int i3) throws IOException {
        c(i2, m(i3));
    }

    public abstract void e(int i2, int i3) throws IOException;

    public static int c(int i2, Xa xa) {
        int e2 = e(i2);
        int size = xa.size();
        return e2 + g(size) + size;
    }

    public static int d(int i2, long j2) {
        return e(i2) + e(j2);
    }

    public static int e(int i2) {
        return g(i2 << 3);
    }

    public static int f(int i2, long j2) {
        return e(i2) + e(i(j2));
    }

    public static int g(int i2, long j2) {
        return e(i2) + 8;
    }

    public final void b(long j2) throws IOException {
        a(i(j2));
    }

    public static zzee a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (Yc.b()) {
            return new c(byteBuffer);
        } else {
            return new d(byteBuffer);
        }
    }

    public static int b(int i2, float f2) {
        return e(i2) + 4;
    }

    public static int h(int i2, long j2) {
        return e(i2) + 8;
    }

    public static int k(int i2) {
        return f(i2);
    }

    public static int b(int i2, double d2) {
        return e(i2) + 8;
    }

    public static int d(int i2, C0400mc mcVar) {
        return (e(1) << 1) + g(2, i2) + c(3, mcVar);
    }

    public static int f(int i2) {
        if (i2 >= 0) {
            return g(i2);
        }
        return 10;
    }

    public static int h(int i2) {
        return g(m(i2));
    }

    public static int b(int i2, boolean z) {
        return e(i2) + 1;
    }

    public static int c(int i2, C0400mc mcVar) {
        return e(i2) + a(mcVar);
    }

    public static int f(long j2) {
        return e(i(j2));
    }

    public static int b(int i2, String str) {
        return e(i2) + a(str);
    }

    public final void c() {
        if (b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    static int b(int i2, C0400mc mcVar, Ac ac) {
        return e(i2) + a(mcVar, ac);
    }

    public static int d(int i2, Xa xa) {
        return (e(1) << 1) + g(2, i2) + c(3, xa);
    }

    public static int b(int i2, Sb sb) {
        return (e(1) << 1) + g(2, i2) + a(3, sb);
    }

    @Deprecated
    static int c(int i2, C0400mc mcVar, Ac ac) {
        int e2 = e(i2) << 1;
        Na na = (Na) mcVar;
        int h2 = na.h();
        if (h2 == -1) {
            h2 = ac.b(na);
            na.a(h2);
        }
        return e2 + h2;
    }

    public static int d(long j2) {
        return e(j2);
    }

    public final void a(int i2, float f2) throws IOException {
        e(i2, Float.floatToRawIntBits(f2));
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return g(length) + length;
    }

    public final void a(int i2, double d2) throws IOException {
        c(i2, Double.doubleToRawLongBits(d2));
    }

    public final void a(float f2) throws IOException {
        d(Float.floatToRawIntBits(f2));
    }

    @Deprecated
    public static int b(C0400mc mcVar) {
        return mcVar.c();
    }

    public final void a(double d2) throws IOException {
        c(Double.doubleToRawLongBits(d2));
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : 0);
    }

    public static int a(int i2, Sb sb) {
        int e2 = e(i2);
        int b2 = sb.b();
        return e2 + g(b2) + b2;
    }

    public static int a(String str) {
        int i2;
        try {
            i2 = C0326ad.a((CharSequence) str);
        } catch (C0353ed unused) {
            i2 = str.getBytes(Fb.f4930a).length;
        }
        return g(i2) + i2;
    }

    public static int a(Sb sb) {
        int b2 = sb.b();
        return g(b2) + b2;
    }

    public static int a(Xa xa) {
        int size = xa.size();
        return g(size) + size;
    }

    public static int a(C0400mc mcVar) {
        int c2 = mcVar.c();
        return g(c2) + c2;
    }

    static int a(C0400mc mcVar, Ac ac) {
        Na na = (Na) mcVar;
        int h2 = na.h();
        if (h2 == -1) {
            h2 = ac.b(na);
            na.a(h2);
        }
        return g(h2) + h2;
    }

    /* access modifiers changed from: 0000 */
    public final void a(String str, C0353ed edVar) throws IOException {
        f5467a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", edVar);
        byte[] bytes = str.getBytes(Fb.f4930a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb((Throwable) e2);
        } catch (zzb e3) {
            throw e3;
        }
    }
}
