package e.a.b;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: RealBufferedSource */
final class w implements i {

    /* renamed from: a reason: collision with root package name */
    public final g f7915a = new g();

    /* renamed from: b reason: collision with root package name */
    public final B f7916b;

    /* renamed from: c reason: collision with root package name */
    boolean f7917c;

    w(B b2) {
        if (b2 != null) {
            this.f7916b = b2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public boolean a(long j2) throws IOException {
        g gVar;
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f7917c) {
            do {
                gVar = this.f7915a;
                if (gVar.f7883c >= j2) {
                    return true;
                }
            } while (this.f7916b.read(gVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException(Action.CLOSED);
        }
    }

    public j b(long j2) throws IOException {
        e(j2);
        return this.f7915a.b(j2);
    }

    public String c(long j2) throws IOException {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            long a2 = a(10, 0, j3);
            if (a2 != -1) {
                return this.f7915a.j(a2);
            }
            if (j3 < Long.MAX_VALUE && a(j3) && this.f7915a.h(j3 - 1) == 13 && a(1 + j3) && this.f7915a.h(j3) == 10) {
                return this.f7915a.j(j3);
            }
            g gVar = new g();
            g gVar2 = this.f7915a;
            gVar2.a(gVar, 0, Math.min(32, gVar2.size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(this.f7915a.size(), j2));
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

    public void close() throws IOException {
        if (!this.f7917c) {
            this.f7917c = true;
            this.f7916b.close();
            this.f7915a.a();
        }
    }

    public byte[] d(long j2) throws IOException {
        e(j2);
        return this.f7915a.d(j2);
    }

    public void e(long j2) throws IOException {
        if (!a(j2)) {
            throw new EOFException();
        }
    }

    public boolean isOpen() {
        return !this.f7917c;
    }

    public g n() {
        return this.f7915a;
    }

    public boolean o() throws IOException {
        if (!this.f7917c) {
            return this.f7915a.o() && this.f7916b.read(this.f7915a, 8192) == -1;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public String p() throws IOException {
        return c(Long.MAX_VALUE);
    }

    public int q() throws IOException {
        e(4);
        return this.f7915a.q();
    }

    public short r() throws IOException {
        e(2);
        return this.f7915a.r();
    }

    public long read(g gVar, long j2) throws IOException {
        if (gVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f7917c) {
            g gVar2 = this.f7915a;
            if (gVar2.f7883c == 0 && this.f7916b.read(gVar2, 8192) == -1) {
                return -1;
            }
            return this.f7915a.read(gVar, Math.min(j2, this.f7915a.f7883c));
        } else {
            throw new IllegalStateException(Action.CLOSED);
        }
    }

    public byte readByte() throws IOException {
        e(1);
        return this.f7915a.readByte();
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            e((long) bArr.length);
            this.f7915a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                g gVar = this.f7915a;
                long j2 = gVar.f7883c;
                if (j2 > 0) {
                    int a2 = gVar.a(bArr, i2, (int) j2);
                    if (a2 != -1) {
                        i2 += a2;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e2;
                }
            }
        }
    }

    public int readInt() throws IOException {
        e(4);
        return this.f7915a.readInt();
    }

    public long readLong() throws IOException {
        e(8);
        return this.f7915a.readLong();
    }

    public short readShort() throws IOException {
        e(2);
        return this.f7915a.readShort();
    }

    public long s() throws IOException {
        e(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!a((long) i3)) {
                break;
            }
            byte h2 = this.f7915a.h((long) i2);
            if ((h2 >= 48 && h2 <= 57) || ((h2 >= 97 && h2 <= 102) || (h2 >= 65 && h2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(h2)}));
            }
        }
        return this.f7915a.s();
    }

    public void skip(long j2) throws IOException {
        if (!this.f7917c) {
            while (j2 > 0) {
                g gVar = this.f7915a;
                if (gVar.f7883c == 0 && this.f7916b.read(gVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f7915a.size());
                this.f7915a.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public InputStream t() {
        return new v(this);
    }

    public D timeout() {
        return this.f7916b.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f7916b);
        sb.append(")");
        return sb.toString();
    }

    public byte[] w() throws IOException {
        this.f7915a.a(this.f7916b);
        return this.f7915a.w();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    public long x() throws IOException {
        e(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!a((long) i3)) {
                break;
            }
            byte h2 = this.f7915a.h((long) i2);
            if ((h2 >= 48 && h2 <= 57) || (i2 == 0 && h2 == 45)) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[]{Byte.valueOf(h2)}));
            }
        }
        if (i2 == 0) {
        }
        return this.f7915a.x();
    }

    public void a(g gVar, long j2) throws IOException {
        try {
            e(j2);
            this.f7915a.a(gVar, j2);
        } catch (EOFException e2) {
            gVar.a((B) this.f7915a);
            throw e2;
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        g gVar = this.f7915a;
        if (gVar.f7883c == 0 && this.f7916b.read(gVar, 8192) == -1) {
            return -1;
        }
        return this.f7915a.read(byteBuffer);
    }

    public long a(A a2) throws IOException {
        if (a2 != null) {
            long j2 = 0;
            while (this.f7916b.read(this.f7915a, 8192) != -1) {
                long b2 = this.f7915a.b();
                if (b2 > 0) {
                    j2 += b2;
                    a2.write(this.f7915a, b2);
                }
            }
            if (this.f7915a.size() <= 0) {
                return j2;
            }
            long size = j2 + this.f7915a.size();
            g gVar = this.f7915a;
            a2.write(gVar, gVar.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public String a(Charset charset) throws IOException {
        if (charset != null) {
            this.f7915a.a(this.f7916b);
            return this.f7915a.a(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j2, long j3) throws IOException {
        if (this.f7917c) {
            throw new IllegalStateException(Action.CLOSED);
        } else if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j2), Long.valueOf(j3)}));
        } else {
            while (j2 < j3) {
                long a2 = this.f7915a.a(b2, j2, j3);
                if (a2 == -1) {
                    g gVar = this.f7915a;
                    long j4 = gVar.f7883c;
                    if (j4 >= j3 || this.f7916b.read(gVar, 8192) == -1) {
                        break;
                    }
                    j2 = Math.max(j2, j4);
                } else {
                    return a2;
                }
            }
            return -1;
        }
    }

    public boolean a(long j2, j jVar) throws IOException {
        return a(j2, jVar, 0, jVar.size());
    }

    public boolean a(long j2, j jVar, int i2, int i3) throws IOException {
        if (this.f7917c) {
            throw new IllegalStateException(Action.CLOSED);
        } else if (j2 < 0 || i2 < 0 || i3 < 0 || jVar.size() - i2 < i3) {
            return false;
        } else {
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = ((long) i4) + j2;
                if (!a(1 + j3) || this.f7915a.h(j3) != jVar.b(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
    }
}
