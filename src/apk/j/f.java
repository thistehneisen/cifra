package j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: Buffer */
public final class f implements h, g, Cloneable, ByteChannel {

    /* renamed from: a reason: collision with root package name */
    private static final byte[] f10248a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b reason: collision with root package name */
    w f10249b;

    /* renamed from: c reason: collision with root package name */
    long f10250c;

    public final long b() {
        long j2 = this.f10250c;
        if (j2 == 0) {
            return 0;
        }
        w wVar = this.f10249b.f10288g;
        int i2 = wVar.f10284c;
        if (i2 < 8192 && wVar.f10286e) {
            j2 -= (long) (i2 - wVar.f10283b);
        }
        return j2;
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
            f fVar = new f();
            a(fVar, 0, Math.min(32, size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(size(), j2));
            sb.append(" content=");
            sb.append(fVar.d().b());
            sb.append(8230);
            throw new EOFException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("limit < 0: ");
        sb2.append(j2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public void close() {
    }

    public i d() {
        return new i(c());
    }

    public void e(long j2) throws EOFException {
        if (this.f10250c < j2) {
            throw new EOFException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        long j2 = this.f10250c;
        if (j2 != fVar.f10250c) {
            return false;
        }
        long j3 = 0;
        if (j2 == 0) {
            return true;
        }
        w wVar = this.f10249b;
        w wVar2 = fVar.f10249b;
        int i2 = wVar.f10283b;
        int i3 = wVar2.f10283b;
        while (j3 < this.f10250c) {
            long min = (long) Math.min(wVar.f10284c - i2, wVar2.f10284c - i3);
            int i4 = i3;
            int i5 = i2;
            int i6 = 0;
            while (((long) i6) < min) {
                int i7 = i5 + 1;
                int i8 = i4 + 1;
                if (wVar.f10282a[i5] != wVar2.f10282a[i4]) {
                    return false;
                }
                i6++;
                i5 = i7;
                i4 = i8;
            }
            if (i5 == wVar.f10284c) {
                wVar = wVar.f10287f;
                i2 = wVar.f10283b;
            } else {
                i2 = i5;
            }
            if (i4 == wVar2.f10284c) {
                wVar2 = wVar2.f10287f;
                i3 = wVar2.f10283b;
            } else {
                i3 = i4;
            }
            j3 += min;
        }
        return true;
    }

    public void flush() {
    }

    public f getBuffer() {
        return this;
    }

    public final byte h(long j2) {
        int i2;
        D.a(this.f10250c, j2, 1);
        long j3 = this.f10250c;
        if (j3 - j2 > j2) {
            w wVar = this.f10249b;
            while (true) {
                int i3 = wVar.f10284c;
                int i4 = wVar.f10283b;
                long j4 = (long) (i3 - i4);
                if (j2 < j4) {
                    return wVar.f10282a[i4 + ((int) j2)];
                }
                j2 -= j4;
                wVar = wVar.f10287f;
            }
        } else {
            long j5 = j2 - j3;
            w wVar2 = this.f10249b;
            do {
                wVar2 = wVar2.f10288g;
                int i5 = wVar2.f10284c;
                i2 = wVar2.f10283b;
                j5 += (long) (i5 - i2);
            } while (j5 < 0);
            return wVar2.f10282a[i2 + ((int) j5)];
        }
    }

    public int hashCode() {
        w wVar = this.f10249b;
        if (wVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            for (int i3 = wVar.f10283b; i3 < wVar.f10284c; i3++) {
                i2 = (i2 * 31) + wVar.f10282a[i3];
            }
            wVar = wVar.f10287f;
        } while (wVar != this.f10249b);
        return i2;
    }

    public String i(long j2) throws EOFException {
        return a(j2, D.f10234a);
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

    public f n() {
        return this;
    }

    public boolean o() {
        return this.f10250c == 0;
    }

    public String p() throws EOFException {
        return c(Long.MAX_VALUE);
    }

    public int q() {
        return D.a(readInt());
    }

    public short r() {
        return D.a(readShort());
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        w wVar = this.f10249b;
        if (wVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), wVar.f10284c - wVar.f10283b);
        byteBuffer.put(wVar.f10282a, wVar.f10283b, min);
        wVar.f10283b += min;
        this.f10250c -= (long) min;
        if (wVar.f10283b == wVar.f10284c) {
            this.f10249b = wVar.b();
            x.a(wVar);
        }
        return min;
    }

    public byte readByte() {
        long j2 = this.f10250c;
        if (j2 != 0) {
            w wVar = this.f10249b;
            int i2 = wVar.f10283b;
            int i3 = wVar.f10284c;
            int i4 = i2 + 1;
            byte b2 = wVar.f10282a[i2];
            this.f10250c = j2 - 1;
            if (i4 == i3) {
                this.f10249b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f10283b = i4;
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
        long j2 = this.f10250c;
        if (j2 >= 4) {
            w wVar = this.f10249b;
            int i2 = wVar.f10283b;
            int i3 = wVar.f10284c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = wVar.f10282a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            this.f10250c = j2 - 4;
            if (i7 == i3) {
                this.f10249b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f10283b = i7;
            }
            return b4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 4: ");
        sb.append(this.f10250c);
        throw new IllegalStateException(sb.toString());
    }

    public short readShort() {
        long j2 = this.f10250c;
        if (j2 >= 2) {
            w wVar = this.f10249b;
            int i2 = wVar.f10283b;
            int i3 = wVar.f10284c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = wVar.f10282a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.f10250c = j2 - 2;
            if (i5 == i3) {
                this.f10249b = wVar.b();
                x.a(wVar);
            } else {
                wVar.f10283b = i5;
            }
            return (short) b2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size < 2: ");
        sb.append(this.f10250c);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008f, code lost:
        if (r8 != r9) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0091, code lost:
        r15.f10249b = r6.b();
        j.x.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        r6.f10283b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        if (r0 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074 A[SYNTHETIC] */
    public long s() {
        int i2;
        int i3;
        if (this.f10250c != 0) {
            boolean z = false;
            long j2 = 0;
            int i4 = 0;
            do {
                w wVar = this.f10249b;
                byte[] bArr = wVar.f10282a;
                int i5 = wVar.f10283b;
                int i6 = wVar.f10284c;
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
                        f fVar = new f();
                        fVar.f(j2);
                        fVar.writeByte((int) b2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Number too large: ");
                        sb2.append(fVar.e());
                        throw new NumberFormatException(sb2.toString());
                    }
                }
                if (i4 == 0) {
                }
            } while (this.f10249b != null);
            this.f10250c -= (long) i4;
            return j2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final long size() {
        return this.f10250c;
    }

    public void skip(long j2) throws EOFException {
        while (j2 > 0) {
            w wVar = this.f10249b;
            if (wVar != null) {
                int min = (int) Math.min(j2, (long) (wVar.f10284c - wVar.f10283b));
                long j3 = (long) min;
                this.f10250c -= j3;
                j2 -= j3;
                w wVar2 = this.f10249b;
                wVar2.f10283b += min;
                if (wVar2.f10283b == wVar2.f10284c) {
                    this.f10249b = wVar2.b();
                    x.a(wVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public InputStream t() {
        return new e(this);
    }

    public C timeout() {
        return C.f10230a;
    }

    public String toString() {
        return f().toString();
    }

    public f u() {
        return this;
    }

    public f clone() {
        f fVar = new f();
        if (this.f10250c == 0) {
            return fVar;
        }
        fVar.f10249b = this.f10249b.c();
        w wVar = fVar.f10249b;
        wVar.f10288g = wVar;
        wVar.f10287f = wVar;
        w wVar2 = this.f10249b;
        while (true) {
            wVar2 = wVar2.f10287f;
            if (wVar2 != this.f10249b) {
                fVar.f10249b.f10288g.a(wVar2.c());
            } else {
                fVar.f10250c = this.f10250c;
                return fVar;
            }
        }
    }

    public byte[] d(long j2) throws EOFException {
        D.a(this.f10250c, 0, j2);
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
            return a(this.f10250c, D.f10234a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public f f(long j2) {
        if (j2 == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j2)) / 4) + 1;
        w b2 = b(numberOfTrailingZeros);
        byte[] bArr = b2.f10282a;
        int i2 = b2.f10284c;
        for (int i3 = (i2 + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = f10248a[(int) (15 & j2)];
            j2 >>>= 4;
        }
        b2.f10284c += numberOfTrailingZeros;
        this.f10250c += (long) numberOfTrailingZeros;
        return this;
    }

    public f g(long j2) {
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
        w b2 = b(i3);
        byte[] bArr = b2.f10282a;
        int i4 = b2.f10284c + i3;
        while (j2 != 0) {
            i4--;
            bArr[i4] = f10248a[(int) (j2 % 10)];
            j2 /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        b2.f10284c += i3;
        this.f10250c += (long) i3;
        return this;
    }

    public f writeByte(int i2) {
        w b2 = b(1);
        byte[] bArr = b2.f10282a;
        int i3 = b2.f10284c;
        b2.f10284c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f10250c++;
        return this;
    }

    public f writeInt(int i2) {
        w b2 = b(4);
        byte[] bArr = b2.f10282a;
        int i3 = b2.f10284c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i2 & 255);
        b2.f10284c = i7;
        this.f10250c += 4;
        return this;
    }

    public f writeShort(int i2) {
        w b2 = b(2);
        byte[] bArr = b2.f10282a;
        int i3 = b2.f10284c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i2 & 255);
        b2.f10284c = i5;
        this.f10250c += 2;
        return this;
    }

    public boolean a(long j2) {
        return this.f10250c >= j2;
    }

    public f write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final f a(f fVar, long j2, long j3) {
        if (fVar != null) {
            D.a(this.f10250c, j2, j3);
            if (j3 == 0) {
                return this;
            }
            fVar.f10250c += j3;
            w wVar = this.f10249b;
            while (true) {
                int i2 = wVar.f10284c;
                int i3 = wVar.f10283b;
                if (j2 < ((long) (i2 - i3))) {
                    break;
                }
                j2 -= (long) (i2 - i3);
                wVar = wVar.f10287f;
            }
            while (j3 > 0) {
                w c2 = wVar.c();
                c2.f10283b = (int) (((long) c2.f10283b) + j2);
                c2.f10284c = Math.min(c2.f10283b + ((int) j3), c2.f10284c);
                w wVar2 = fVar.f10249b;
                if (wVar2 == null) {
                    c2.f10288g = c2;
                    c2.f10287f = c2;
                    fVar.f10249b = c2;
                } else {
                    wVar2.f10288g.a(c2);
                }
                j3 -= (long) (c2.f10284c - c2.f10283b);
                wVar = wVar.f10287f;
                j2 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public i b(long j2) throws EOFException {
        return new i(d(j2));
    }

    public f write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j2 = (long) i3;
            D.a((long) bArr.length, (long) i2, j2);
            int i4 = i3 + i2;
            while (i2 < i4) {
                w b2 = b(1);
                int min = Math.min(i4 - i2, 8192 - b2.f10284c);
                System.arraycopy(bArr, i2, b2.f10282a, b2.f10284c, min);
                i2 += min;
                b2.f10284c += min;
            }
            this.f10250c += j2;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    /* access modifiers changed from: 0000 */
    public w b(int i2) {
        w wVar;
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        w wVar2 = this.f10249b;
        if (wVar2 == null) {
            this.f10249b = x.a();
            w wVar3 = this.f10249b;
            wVar3.f10288g = wVar3;
            wVar3.f10287f = wVar3;
            return wVar3;
        }
        w wVar4 = wVar2.f10288g;
        if (wVar4.f10284c + i2 > 8192 || !wVar4.f10286e) {
            wVar = x.a();
            wVar4.a(wVar);
        } else {
            wVar = wVar4;
        }
        return wVar;
    }

    public final i f() {
        long j2 = this.f10250c;
        if (j2 <= 2147483647L) {
            return a((int) j2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("size > Integer.MAX_VALUE: ");
        sb.append(this.f10250c);
        throw new IllegalArgumentException(sb.toString());
    }

    public byte[] c() {
        try {
            return d(this.f10250c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                w b2 = b(1);
                int min = Math.min(i2, 8192 - b2.f10284c);
                byteBuffer.get(b2.f10282a, b2.f10284c, min);
                i2 -= min;
                b2.f10284c += min;
            }
            this.f10250c += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long b(f fVar, long j2) {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 >= 0) {
            long j3 = this.f10250c;
            if (j3 == 0) {
                return -1;
            }
            if (j2 > j3) {
                j2 = j3;
            }
            fVar.a(this, j2);
            return j2;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public f c(int i2) {
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

    public long a(z zVar) throws IOException {
        long j2 = this.f10250c;
        if (j2 > 0) {
            zVar.a(this, j2);
        }
        return j2;
    }

    public String a(Charset charset) {
        try {
            return a(this.f10250c, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public String a(long j2, Charset charset) throws EOFException {
        D.a(this.f10250c, 0, j2);
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
            w wVar = this.f10249b;
            int i2 = wVar.f10283b;
            if (((long) i2) + j2 > ((long) wVar.f10284c)) {
                return new String(d(j2), charset);
            }
            String str = new String(wVar.f10282a, i2, (int) j2, charset);
            wVar.f10283b = (int) (((long) wVar.f10283b) + j2);
            this.f10250c -= j2;
            if (wVar.f10283b == wVar.f10284c) {
                this.f10249b = wVar.b();
                x.a(wVar);
            }
            return str;
        }
    }

    public int a(byte[] bArr, int i2, int i3) {
        D.a((long) bArr.length, (long) i2, (long) i3);
        w wVar = this.f10249b;
        if (wVar == null) {
            return -1;
        }
        int min = Math.min(i3, wVar.f10284c - wVar.f10283b);
        System.arraycopy(wVar.f10282a, wVar.f10283b, bArr, i2, min);
        wVar.f10283b += min;
        this.f10250c -= (long) min;
        if (wVar.f10283b == wVar.f10284c) {
            this.f10249b = wVar.b();
            x.a(wVar);
        }
        return min;
    }

    public final void a() {
        try {
            skip(this.f10250c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public f a(i iVar) {
        if (iVar != null) {
            iVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public f a(String str) {
        a(str, 0, str.length());
        return this;
    }

    public f a(String str, int i2, int i3) {
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
                    w b2 = b(1);
                    byte[] bArr = b2.f10282a;
                    int i4 = b2.f10284c - i2;
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
                    int i8 = b2.f10284c;
                    int i9 = i7 - i8;
                    b2.f10284c = i8 + i9;
                    this.f10250c += (long) i9;
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

    public f a(String str, int i2, int i3, Charset charset) {
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
        } else if (charset.equals(D.f10234a)) {
            a(str, i2, i3);
            return this;
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    public long a(A a2) throws IOException {
        if (a2 != null) {
            long j2 = 0;
            while (true) {
                long b2 = a2.b(this, 8192);
                if (b2 == -1) {
                    return j2;
                }
                j2 += b2;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public void a(f fVar, long j2) {
        int i2;
        if (fVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (fVar != this) {
            D.a(fVar.f10250c, 0, j2);
            while (j2 > 0) {
                w wVar = fVar.f10249b;
                if (j2 < ((long) (wVar.f10284c - wVar.f10283b))) {
                    w wVar2 = this.f10249b;
                    w wVar3 = wVar2 != null ? wVar2.f10288g : null;
                    if (wVar3 != null && wVar3.f10286e) {
                        long j3 = ((long) wVar3.f10284c) + j2;
                        if (wVar3.f10285d) {
                            i2 = 0;
                        } else {
                            i2 = wVar3.f10283b;
                        }
                        if (j3 - ((long) i2) <= 8192) {
                            fVar.f10249b.a(wVar3, (int) j2);
                            fVar.f10250c -= j2;
                            this.f10250c += j2;
                            return;
                        }
                    }
                    fVar.f10249b = fVar.f10249b.a((int) j2);
                }
                w wVar4 = fVar.f10249b;
                long j4 = (long) (wVar4.f10284c - wVar4.f10283b);
                fVar.f10249b = wVar4.b();
                w wVar5 = this.f10249b;
                if (wVar5 == null) {
                    this.f10249b = wVar4;
                    w wVar6 = this.f10249b;
                    wVar6.f10288g = wVar6;
                    wVar6.f10287f = wVar6;
                } else {
                    wVar5.f10288g.a(wVar4);
                    wVar4.a();
                }
                fVar.f10250c -= j4;
                this.f10250c += j4;
                j2 -= j4;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public long a(byte b2) {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j2, long j3) {
        long j4 = 0;
        if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.f10250c), Long.valueOf(j2), Long.valueOf(j3)}));
        }
        long j5 = this.f10250c;
        if (j3 <= j5) {
            j5 = j3;
        }
        if (j2 == j5) {
            return -1;
        }
        w wVar = this.f10249b;
        if (wVar == null) {
            return -1;
        }
        long j6 = this.f10250c;
        if (j6 - j2 >= j2) {
            while (true) {
                j6 = j4;
                j4 = ((long) (wVar.f10284c - wVar.f10283b)) + j6;
                if (j4 >= j2) {
                    break;
                }
                wVar = wVar.f10287f;
            }
        } else {
            while (j6 > j2) {
                wVar = wVar.f10288g;
                j6 -= (long) (wVar.f10284c - wVar.f10283b);
            }
        }
        long j7 = j2;
        while (j6 < j5) {
            byte[] bArr = wVar.f10282a;
            int min = (int) Math.min((long) wVar.f10284c, (((long) wVar.f10283b) + j5) - j6);
            for (int i2 = (int) ((((long) wVar.f10283b) + j7) - j6); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - wVar.f10283b)) + j6;
                }
            }
            byte b3 = b2;
            j7 = ((long) (wVar.f10284c - wVar.f10283b)) + j6;
            wVar = wVar.f10287f;
            j6 = j7;
        }
        return -1;
    }

    public final i a(int i2) {
        if (i2 == 0) {
            return i.f10252b;
        }
        return new y(this, i2);
    }
}
