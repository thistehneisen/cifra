package e.a.b;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer */
public final class g implements i, h, Cloneable, ByteChannel {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f7881a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b reason: collision with root package name */
    x f7882b;

    /* renamed from: c reason: collision with root package name */
    long f7883c;

    /* compiled from: Buffer */
    public static final class a implements Closeable {

        /* renamed from: a reason: collision with root package name */
        public g f7884a;

        /* renamed from: b reason: collision with root package name */
        public boolean f7885b;

        /* renamed from: c reason: collision with root package name */
        private x f7886c;

        /* renamed from: d reason: collision with root package name */
        public long f7887d = -1;

        /* renamed from: e reason: collision with root package name */
        public byte[] f7888e;

        /* renamed from: f reason: collision with root package name */
        public int f7889f = -1;

        /* renamed from: g reason: collision with root package name */
        public int f7890g = -1;

        public int a() {
            long j2 = this.f7887d;
            if (j2 == this.f7884a.f7883c) {
                throw new IllegalStateException();
            } else if (j2 == -1) {
                return h(0);
            } else {
                return h(j2 + ((long) (this.f7890g - this.f7889f)));
            }
        }

        public void close() {
            if (this.f7884a != null) {
                this.f7884a = null;
                this.f7886c = null;
                this.f7887d = -1;
                this.f7888e = null;
                this.f7889f = -1;
                this.f7890g = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public int h(long j2) {
            x xVar;
            long j3;
            x xVar2;
            int i2 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
            if (i2 >= 0) {
                g gVar = this.f7884a;
                long j4 = gVar.f7883c;
                if (j2 <= j4) {
                    if (i2 == 0 || j2 == j4) {
                        this.f7886c = null;
                        this.f7887d = j2;
                        this.f7888e = null;
                        this.f7889f = -1;
                        this.f7890g = -1;
                        return -1;
                    }
                    long j5 = 0;
                    x xVar3 = gVar.f7882b;
                    x xVar4 = this.f7886c;
                    if (xVar4 != null) {
                        long j6 = this.f7887d - ((long) (this.f7889f - xVar4.f7919b));
                        if (j6 > j2) {
                            j4 = j6;
                            x xVar5 = xVar4;
                            xVar4 = xVar3;
                            xVar3 = xVar5;
                        } else {
                            j5 = j6;
                        }
                    } else {
                        xVar4 = xVar3;
                    }
                    if (j4 - j2 > j2 - j5) {
                        while (true) {
                            int i3 = xVar.f7920c;
                            int i4 = xVar.f7919b;
                            if (j2 < ((long) (i3 - i4)) + j3) {
                                break;
                            }
                            j5 = j3 + ((long) (i3 - i4));
                            xVar4 = xVar.f7923f;
                        }
                    } else {
                        xVar = xVar3;
                        j3 = j4;
                        while (j3 > j2) {
                            xVar = xVar.f7924g;
                            j3 -= (long) (xVar.f7920c - xVar.f7919b);
                        }
                    }
                    if (!this.f7885b || !xVar.f7921d) {
                        xVar2 = xVar;
                    } else {
                        xVar2 = xVar.d();
                        g gVar2 = this.f7884a;
                        if (gVar2.f7882b == xVar) {
                            gVar2.f7882b = xVar2;
                        }
                        xVar.a(xVar2);
                        xVar2.f7924g.b();
                    }
                    this.f7886c = xVar2;
                    this.f7887d = j2;
                    this.f7888e = xVar2.f7918a;
                    this.f7889f = xVar2.f7919b + ((int) (j2 - j3));
                    this.f7890g = xVar2.f7920c;
                    return this.f7890g - this.f7889f;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j2), Long.valueOf(this.f7884a.f7883c)}));
        }
    }

    public long b() {
        long j2 = this.f7883c;
        if (j2 == 0) {
            return 0;
        }
        x xVar = this.f7882b.f7924g;
        int i2 = xVar.f7920c;
        if (i2 < 8192 && xVar.f7922e) {
            j2 -= (long) (i2 - xVar.f7919b);
        }
        return j2;
    }

    public OutputStream c() {
        return new C0711e(this);
    }

    public void close() {
    }

    public j d() {
        return new j(w());
    }

    public void e(long j2) throws EOFException {
        if (this.f7883c < j2) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        long j2 = this.f7883c;
        if (j2 != gVar.f7883c) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        x xVar = this.f7882b;
        x xVar2 = gVar.f7882b;
        int i2 = xVar.f7919b;
        int i3 = xVar2.f7919b;
        while (j3 < this.f7883c) {
            long min = (long) Math.min(xVar.f7920c - i2, xVar2.f7920c - i3);
            int i4 = i3;
            int i5 = i2;
            int i6 = 0;
            while (((long) i6) < min) {
                int i7 = i5 + 1;
                int i8 = i4 + 1;
                if (xVar.f7918a[i5] != xVar2.f7918a[i4]) {
                    return false;
                }
                i6++;
                i5 = i7;
                i4 = i8;
            }
            if (i5 == xVar.f7920c) {
                xVar = xVar.f7923f;
                i2 = xVar.f7919b;
            } else {
                i2 = i5;
            }
            if (i4 == xVar2.f7920c) {
                xVar2 = xVar2.f7923f;
                i3 = xVar2.f7919b;
            } else {
                i3 = i4;
            }
            j3 += min;
        }
        return true;
    }

    public void flush() {
    }

    public byte h(long j2) {
        int i2;
        E.a(this.f7883c, j2, 1);
        long j3 = this.f7883c;
        if (j3 - j2 > j2) {
            x xVar = this.f7882b;
            while (true) {
                int i3 = xVar.f7920c;
                int i4 = xVar.f7919b;
                long j4 = (long) (i3 - i4);
                if (j2 < j4) {
                    return xVar.f7918a[i4 + ((int) j2)];
                }
                j2 -= j4;
                xVar = xVar.f7923f;
            }
        } else {
            long j5 = j2 - j3;
            x xVar2 = this.f7882b;
            do {
                xVar2 = xVar2.f7924g;
                int i5 = xVar2.f7920c;
                i2 = xVar2.f7919b;
                j5 += (long) (i5 - i2);
            } while (j5 < 0);
            return xVar2.f7918a[i2 + ((int) j5)];
        }
    }

    public int hashCode() {
        x xVar = this.f7882b;
        if (xVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            for (int i3 = xVar.f7919b; i3 < xVar.f7920c; i3++) {
                i2 = (i2 * 31) + xVar.f7918a[i3];
            }
            xVar = xVar.f7923f;
        } while (xVar != this.f7882b);
        return i2;
    }

    public String i(long j2) throws EOFException {
        return a(j2, E.f7872a);
    }

    public boolean isOpen() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public String j(long j2) throws EOFException {
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (h(j3) == 13) {
                String i2 = i(j3);
                skip(2);
                return i2;
            }
        }
        String i3 = i(j2);
        skip(1);
        return i3;
    }

    public g k(long j2) {
        x b2 = b(8);
        byte[] bArr = b2.f7918a;
        int i2 = b2.f7920c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j2 >>> 56) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j2 >>> 48) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j2 >>> 40) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j2 >>> 32) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j2 >>> 24) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j2 >>> 16) & 255));
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((int) ((j2 >>> 8) & 255));
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((int) (j2 & 255));
        b2.f7920c = i10;
        this.f7883c += 8;
        return this;
    }

    public g n() {
        return this;
    }

    public boolean o() {
        return this.f7883c == 0;
    }

    public String p() throws EOFException {
        return c(Long.MAX_VALUE);
    }

    public int q() {
        return E.a(readInt());
    }

    public short r() {
        return E.a(readShort());
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        x xVar = this.f7882b;
        if (xVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), xVar.f7920c - xVar.f7919b);
        byteBuffer.put(xVar.f7918a, xVar.f7919b, min);
        xVar.f7919b += min;
        this.f7883c -= (long) min;
        if (xVar.f7919b == xVar.f7920c) {
            this.f7882b = xVar.b();
            y.a(xVar);
        }
        return min;
    }

    public byte readByte() {
        long j2 = this.f7883c;
        if (j2 != 0) {
            x xVar = this.f7882b;
            int i2 = xVar.f7919b;
            int i3 = xVar.f7920c;
            int i4 = i2 + 1;
            byte b2 = xVar.f7918a[i2];
            this.f7883c = j2 - 1;
            if (i4 == i3) {
                this.f7882b = xVar.b();
                y.a(xVar);
            } else {
                xVar.f7919b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int a2 = a(bArr, i2, bArr.length - i2);
            if (a2 != -1) {
                i2 += a2;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() {
        long j2 = this.f7883c;
        if (j2 >= 4) {
            x xVar = this.f7882b;
            int i2 = xVar.f7919b;
            int i3 = xVar.f7920c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = xVar.f7918a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            this.f7883c = j2 - 4;
            if (i7 == i3) {
                this.f7882b = xVar.b();
                y.a(xVar);
            } else {
                xVar.f7919b = i7;
            }
            return b4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 4: ");
        sb.append(this.f7883c);
        throw new IllegalStateException(sb.toString());
    }

    public long readLong() {
        long j2 = this.f7883c;
        if (j2 >= 8) {
            x xVar = this.f7882b;
            int i2 = xVar.f7919b;
            int i3 = xVar.f7920c;
            if (i3 - i2 < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = xVar.f7918a;
            int i4 = i2 + 1;
            long j3 = (((long) bArr[i2]) & 255) << 56;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j4 = ((((long) bArr[i4]) & 255) << 48) | j3 | ((((long) bArr[i5]) & 255) << 40) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 24) | ((((long) bArr[i8]) & 255) << 16) | ((((long) bArr[i9]) & 255) << 8) | (((long) bArr[i10]) & 255);
            this.f7883c = j2 - 8;
            if (i11 == i3) {
                this.f7882b = xVar.b();
                y.a(xVar);
            } else {
                xVar.f7919b = i11;
            }
            return j4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 8: ");
        sb.append(this.f7883c);
        throw new IllegalStateException(sb.toString());
    }

    public short readShort() {
        long j2 = this.f7883c;
        if (j2 >= 2) {
            x xVar = this.f7882b;
            int i2 = xVar.f7919b;
            int i3 = xVar.f7920c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = xVar.f7918a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f7883c = j2 - 2;
            if (i5 == i3) {
                this.f7882b = xVar.b();
                y.a(xVar);
            } else {
                xVar.f7919b = i5;
            }
            return (short) b2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 2: ");
        sb.append(this.f7883c);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r8 != r9) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r15.f7882b = r6.b();
        e.a.b.y.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        r6.f7919b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r0 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
    public long s() {
        int i2;
        int i3;
        if (this.f7883c != 0) {
            boolean z = false;
            long j2 = 0;
            int i4 = 0;
            do {
                x xVar = this.f7882b;
                byte[] bArr = xVar.f7918a;
                int i5 = xVar.f7919b;
                int i6 = xVar.f7920c;
                while (true) {
                    if (i5 >= i6) {
                        break;
                    }
                    byte b2 = bArr[i5];
                    if (b2 < 48 || b2 > 57) {
                        if (b2 >= 97 && b2 <= 102) {
                            i3 = b2 - 97;
                        } else if (b2 >= 65 && b2 <= 70) {
                            i3 = b2 - 65;
                        } else if (i4 == 0) {
                            z = true;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                            sb.append(Integer.toHexString(b2));
                            throw new NumberFormatException(sb.toString());
                        }
                        i2 = i3 + 10;
                    } else {
                        i2 = b2 - 48;
                    }
                    if ((-1152921504606846976L & j2) == 0) {
                        j2 = (j2 << 4) | ((long) i2);
                        i5++;
                        i4++;
                    } else {
                        g gVar = new g();
                        gVar.f(j2);
                        gVar.writeByte((int) b2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Number too large: ");
                        sb2.append(gVar.e());
                        throw new NumberFormatException(sb2.toString());
                    }
                }
                if (i4 == 0) {
                }
            } while (this.f7882b != null);
            this.f7883c -= (long) i4;
            return j2;
        }
        throw new IllegalStateException("size == 0");
    }

    public long size() {
        return this.f7883c;
    }

    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            x xVar = this.f7882b;
            if (xVar != null) {
                int min = (int) Math.min(j2, (long) (xVar.f7920c - xVar.f7919b));
                long j3 = (long) min;
                this.f7883c -= j3;
                j2 -= j3;
                x xVar2 = this.f7882b;
                xVar2.f7919b += min;
                if (xVar2.f7919b == xVar2.f7920c) {
                    this.f7882b = xVar2.b();
                    y.a(xVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public InputStream t() {
        return new f(this);
    }

    public D timeout() {
        return D.NONE;
    }

    public String toString() {
        return f().toString();
    }

    public g u() {
        return this;
    }

    public h v() {
        return this;
    }

    public byte[] w() {
        try {
            return d(this.f7883c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r5 != false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        r3 = new java.lang.StringBuilder();
        r3.append("Number too large: ");
        r3.append(r1.e());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    public long x() {
        long j2 = 0;
        if (this.f7883c != 0) {
            int i2 = 0;
            long j3 = -7;
            boolean z = false;
            boolean z2 = false;
            loop0:
            do {
                x xVar = this.f7882b;
                byte[] bArr = xVar.f7918a;
                int i3 = xVar.f7919b;
                int i4 = xVar.f7920c;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    byte b2 = bArr[i3];
                    if (b2 >= 48 && b2 <= 57) {
                        int i5 = 48 - b2;
                        int i6 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                        if (i6 < 0 || (i6 == 0 && ((long) i5) < j3)) {
                            g gVar = new g();
                            gVar.g(j2);
                            gVar.writeByte((int) b2);
                        } else {
                            j2 = (j2 * 10) + ((long) i5);
                        }
                    } else if (b2 == 45 && i2 == 0) {
                        j3--;
                        z = true;
                    } else if (i2 != 0) {
                        z2 = true;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected leading [0-9] or '-' character but was 0x");
                        sb.append(Integer.toHexString(b2));
                        throw new NumberFormatException(sb.toString());
                    }
                    i3++;
                    i2++;
                }
                if (i3 == i4) {
                    this.f7882b = xVar.b();
                    y.a(xVar);
                } else {
                    xVar.f7919b = i3;
                }
                if (z2) {
                    break;
                }
            } while (this.f7882b != null);
            this.f7883c -= (long) i2;
            return z ? j2 : -j2;
        }
        throw new IllegalStateException("size == 0");
    }

    public String c(long j2) throws EOFException {
        if (j2 >= 0) {
            long j3 = Long.MAX_VALUE;
            if (j2 != Long.MAX_VALUE) {
                j3 = j2 + 1;
            }
            long a2 = a(10, 0, j3);
            if (a2 != -1) {
                return j(a2);
            }
            if (j3 < size() && h(j3 - 1) == 13 && h(j3) == 10) {
                return j(j3);
            }
            g gVar = new g();
            a(gVar, 0, Math.min(32, size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(size(), j2));
            sb.append(" content=");
            sb.append(gVar.d().b());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public g clone() {
        g gVar = new g();
        if (this.f7883c == 0) {
            return gVar;
        }
        gVar.f7882b = this.f7882b.c();
        x xVar = gVar.f7882b;
        xVar.f7924g = xVar;
        xVar.f7923f = xVar;
        x xVar2 = this.f7882b;
        while (true) {
            xVar2 = xVar2.f7923f;
            if (xVar2 != this.f7882b) {
                gVar.f7882b.f7924g.a(xVar2.c());
            } else {
                gVar.f7883c = this.f7883c;
                return gVar;
            }
        }
    }

    public byte[] d(long j2) throws EOFException {
        E.a(this.f7883c, 0, j2);
        if (j2 <= 2147483647L) {
            byte[] bArr = new byte[((int) j2)];
            readFully(bArr);
            return bArr;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("byteCount > Integer.MAX_VALUE: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    public String e() {
        try {
            return a(this.f7883c, E.f7872a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public g f(long j2) {
        if (j2 == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        x b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f7918a;
        int i2 = b2.f7920c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f7881a[(int) (15 & j2)];
            j2 >>>= 4;
        }
        b2.f7920c += numberOfTrailingZeros;
        this.f7883c += (long) numberOfTrailingZeros;
        return this;
    }

    public g g(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                a("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i3 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= 10000) {
            i3 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i3 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        x b2 = b(i3);
        byte[] bArr = b2.f7918a;
        int i4 = b2.f7920c + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = f7881a[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        b2.f7920c += i3;
        this.f7883c += (long) i3;
        return this;
    }

    public g writeByte(int i2) {
        x b2 = b(1);
        byte[] bArr = b2.f7918a;
        int i3 = b2.f7920c;
        b2.f7920c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f7883c++;
        return this;
    }

    public g writeInt(int i2) {
        x b2 = b(4);
        byte[] bArr = b2.f7918a;
        int i3 = b2.f7920c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i2 & 255);
        b2.f7920c = i7;
        this.f7883c += 4;
        return this;
    }

    public g writeShort(int i2) {
        x b2 = b(2);
        byte[] bArr = b2.f7918a;
        int i3 = b2.f7920c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 & 255);
        b2.f7920c = i5;
        this.f7883c += 2;
        return this;
    }

    public boolean a(long j2) {
        return this.f7883c >= j2;
    }

    public g write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public g a(g gVar, long j2, long j3) {
        if (gVar != null) {
            E.a(this.f7883c, j2, j3);
            if (j3 == 0) {
                return this;
            }
            gVar.f7883c += j3;
            x xVar = this.f7882b;
            while (true) {
                int i2 = xVar.f7920c;
                int i3 = xVar.f7919b;
                if (j2 < ((long) (i2 - i3))) {
                    break;
                }
                j2 -= (long) (i2 - i3);
                xVar = xVar.f7923f;
            }
            while (j3 > 0) {
                x c2 = xVar.c();
                c2.f7919b = (int) (((long) c2.f7919b) + j2);
                c2.f7920c = Math.min(c2.f7919b + ((int) j3), c2.f7920c);
                x xVar2 = gVar.f7882b;
                if (xVar2 == null) {
                    c2.f7924g = c2;
                    c2.f7923f = c2;
                    gVar.f7882b = c2;
                } else {
                    xVar2.f7924g.a(c2);
                }
                j3 -= (long) (c2.f7920c - c2.f7919b);
                xVar = xVar.f7923f;
                j2 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public j b(long j2) throws EOFException {
        return new j(d(j2));
    }

    public g write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = (long) i3;
            E.a((long) bArr.length, (long) i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                x b2 = b(1);
                int min = Math.min(i4 - i2, 8192 - b2.f7920c);
                System.arraycopy(bArr, i2, b2.f7918a, b2.f7920c, min);
                i2 += min;
                b2.f7920c += min;
            }
            this.f7883c += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* access modifiers changed from: 0000 */
    public x b(int i2) {
        x xVar;
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        x xVar2 = this.f7882b;
        if (xVar2 == null) {
            this.f7882b = y.a();
            x xVar3 = this.f7882b;
            xVar3.f7924g = xVar3;
            xVar3.f7923f = xVar3;
            return xVar3;
        }
        x xVar4 = xVar2.f7924g;
        if (xVar4.f7920c + i2 > 8192 || !xVar4.f7922e) {
            xVar = y.a();
            xVar4.a(xVar);
        } else {
            xVar = xVar4;
        }
        return xVar;
    }

    public long read(g gVar, long j2) {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 >= 0) {
            long j3 = this.f7883c;
            if (j3 == 0) {
                return -1;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            gVar.write(this, j2);
            return j2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public j f() {
        long j2 = this.f7883c;
        if (j2 <= 2147483647L) {
            return a((int) j2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.f7883c);
        throw new IllegalArgumentException(sb.toString());
    }

    public g c(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | 192);
            writeByte((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                writeByte((i2 >> 12) | 224);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i2 <= 1114111) {
            writeByte((i2 >> 18) | 240);
            writeByte(((i2 >> 12) & 63) | 128);
            writeByte(((i2 >> 6) & 63) | 128);
            writeByte((i2 & 63) | 128);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected code point: ");
            sb.append(Integer.toHexString(i2));
            throw new IllegalArgumentException(sb.toString());
        }
        return this;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                x b2 = b(1);
                int min = Math.min(i2, 8192 - b2.f7920c);
                byteBuffer.get(b2.f7918a, b2.f7920c, min);
                i2 -= min;
                b2.f7920c += min;
            }
            this.f7883c += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void a(g gVar, long j2) throws EOFException {
        long j3 = this.f7883c;
        if (j3 >= j2) {
            gVar.write(this, j2);
        } else {
            gVar.write(this, j3);
            throw new EOFException();
        }
    }

    public void write(g gVar, long j2) {
        int i2;
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (gVar != this) {
            E.a(gVar.f7883c, 0, j2);
            while (j2 > 0) {
                x xVar = gVar.f7882b;
                if (j2 < ((long) (xVar.f7920c - xVar.f7919b))) {
                    x xVar2 = this.f7882b;
                    x xVar3 = xVar2 != null ? xVar2.f7924g : null;
                    if (xVar3 != null && xVar3.f7922e) {
                        long j3 = ((long) xVar3.f7920c) + j2;
                        if (xVar3.f7921d) {
                            i2 = 0;
                        } else {
                            i2 = xVar3.f7919b;
                        }
                        if (j3 - ((long) i2) <= 8192) {
                            gVar.f7882b.a(xVar3, (int) j2);
                            gVar.f7883c -= j2;
                            this.f7883c += j2;
                            return;
                        }
                    }
                    gVar.f7882b = gVar.f7882b.a((int) j2);
                }
                x xVar4 = gVar.f7882b;
                long j4 = (long) (xVar4.f7920c - xVar4.f7919b);
                gVar.f7882b = xVar4.b();
                x xVar5 = this.f7882b;
                if (xVar5 == null) {
                    this.f7882b = xVar4;
                    x xVar6 = this.f7882b;
                    xVar6.f7924g = xVar6;
                    xVar6.f7923f = xVar6;
                } else {
                    xVar5.f7924g.a(xVar4);
                    xVar4.a();
                }
                gVar.f7883c -= j4;
                this.f7883c += j4;
                j2 -= j4;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long a(A a2) throws IOException {
        long j2 = this.f7883c;
        if (j2 > 0) {
            a2.write(this, j2);
        }
        return j2;
    }

    public String a(Charset charset) {
        try {
            return a(this.f7883c, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j2, Charset charset) throws EOFException {
        E.a(this.f7883c, 0, j2);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j2 > 2147483647L) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount > Integer.MAX_VALUE: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (j2 == 0) {
            return "";
        } else {
            x xVar = this.f7882b;
            int i2 = xVar.f7919b;
            if (((long) i2) + j2 > ((long) xVar.f7920c)) {
                return new String(d(j2), charset);
            }
            String str = new String(xVar.f7918a, i2, (int) j2, charset);
            xVar.f7919b = (int) (((long) xVar.f7919b) + j2);
            this.f7883c -= j2;
            if (xVar.f7919b == xVar.f7920c) {
                this.f7882b = xVar.b();
                y.a(xVar);
            }
            return str;
        }
    }

    public int a(byte[] bArr, int i2, int i3) {
        E.a((long) bArr.length, (long) i2, (long) i3);
        x xVar = this.f7882b;
        if (xVar == null) {
            return -1;
        }
        int min = Math.min(i3, xVar.f7920c - xVar.f7919b);
        System.arraycopy(xVar.f7918a, xVar.f7919b, bArr, i2, min);
        xVar.f7919b += min;
        this.f7883c -= (long) min;
        if (xVar.f7919b == xVar.f7920c) {
            this.f7882b = xVar.b();
            y.a(xVar);
        }
        return min;
    }

    public void a() {
        try {
            skip(this.f7883c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public g a(j jVar) {
        if (jVar != null) {
            jVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public g a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public g a(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i3);
            sb2.append(" < ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    x b2 = b(1);
                    byte[] bArr = b2.f7918a;
                    int i4 = b2.f7920c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt;
                    while (i5 < min) {
                        char charAt2 = str.charAt(i5);
                        if (charAt2 >= 128) {
                            break;
                        }
                        int i6 = i5 + 1;
                        bArr[i5 + i4] = (byte) charAt2;
                        i5 = i6;
                    }
                    int i7 = i4 + i5;
                    int i8 = b2.f7920c;
                    int i9 = i7 - i8;
                    b2.f7920c = i8 + i9;
                    this.f7883c += (long) i9;
                    i2 = i5;
                } else {
                    if (charAt < 2048) {
                        writeByte((charAt >> 6) | 192);
                        writeByte((int) (charAt & '?') | 128);
                    } else if (charAt < 55296 || charAt > 57343) {
                        writeByte((charAt >> 12) | 224);
                        writeByte(((charAt >> 6) & 63) | 128);
                        writeByte((int) (charAt & '?') | 128);
                    } else {
                        int i10 = i2 + 1;
                        char charAt3 = i10 < i3 ? str.charAt(i10) : 0;
                        if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i2 = i10;
                        } else {
                            int i11 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 0;
                            writeByte((i11 >> 18) | 240);
                            writeByte(((i11 >> 12) & 63) | 128);
                            writeByte(((i11 >> 6) & 63) | 128);
                            writeByte((i11 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i2++;
                }
            }
            return this;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(i3);
            sb3.append(" > ");
            sb3.append(str.length());
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public g a(String str, Charset charset) {
        a(str, 0, str.length(), charset);
        return this;
    }

    public g a(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("beginIndex < 0: ");
            sb.append(i2);
            throw new IllegalAccessError(sb.toString());
        } else if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("endIndex < beginIndex: ");
            sb2.append(i3);
            sb2.append(" < ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i3 > str.length()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("endIndex > string.length: ");
            sb3.append(i3);
            sb3.append(" > ");
            sb3.append(str.length());
            throw new IllegalArgumentException(sb3.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(E.f7872a)) {
            a(str, i2, i3);
            return this;
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    public long a(B b2) throws IOException {
        if (b2 != null) {
            long j2 = 0;
            while (true) {
                long read = b2.read(this, 8192);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public long a(byte b2) {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j2, long j3) {
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f7883c), Long.valueOf(j2), Long.valueOf(j3)}));
        }
        long j5 = this.f7883c;
        if (j3 <= j5) {
            j5 = j3;
        }
        if (j2 == j5) {
            return -1;
        }
        x xVar = this.f7882b;
        if (xVar == null) {
            return -1;
        }
        long j6 = this.f7883c;
        if (j6 - j2 >= j2) {
            while (true) {
                j6 = j4;
                j4 = ((long) (xVar.f7920c - xVar.f7919b)) + j6;
                if (j4 >= j2) {
                    break;
                }
                xVar = xVar.f7923f;
            }
        } else {
            while (j6 > j2) {
                xVar = xVar.f7924g;
                j6 -= (long) (xVar.f7920c - xVar.f7919b);
            }
        }
        long j7 = j2;
        while (j6 < j5) {
            byte[] bArr = xVar.f7918a;
            int min = (int) Math.min((long) xVar.f7920c, (((long) xVar.f7919b) + j5) - j6);
            for (int i2 = (int) ((((long) xVar.f7919b) + j7) - j6); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - xVar.f7919b)) + j6;
                }
            }
            byte b3 = b2;
            j7 = ((long) (xVar.f7920c - xVar.f7919b)) + j6;
            xVar = xVar.f7923f;
            j6 = j7;
        }
        return -1;
    }

    public boolean a(long j2, j jVar) {
        return a(j2, jVar, 0, jVar.size());
    }

    public boolean a(long j2, j jVar, int i2, int i3) {
        if (j2 < 0 || i2 < 0 || i3 < 0 || this.f7883c - j2 < ((long) i3) || jVar.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (h(((long) i4) + j2) != jVar.b(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public j a(int i2) {
        if (i2 == 0) {
            return j.f7892b;
        }
        return new z(this, i2);
    }

    public a a(a aVar) {
        if (aVar.f7884a == null) {
            aVar.f7884a = this;
            aVar.f7885b = true;
            return aVar;
        }
        throw new IllegalStateException("already attached to a buffer");
    }
}
