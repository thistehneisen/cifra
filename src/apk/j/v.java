package j;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSource */
final class v implements h {

    /* renamed from: a reason: collision with root package name */
    public final f f10279a = new f();

    /* renamed from: b reason: collision with root package name */
    public final A f10280b;

    /* renamed from: c reason: collision with root package name */
    boolean f10281c;

    v(A a2) {
        if (a2 != null) {
            this.f10280b = a2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    public boolean a(long j2) throws IOException {
        f fVar;
        if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f10281c) {
            do {
                fVar = this.f10279a;
                if (fVar.f10250c >= j2) {
                    return true;
                }
            } while (this.f10280b.b(fVar, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException(Action.CLOSED);
        }
    }

    public long b(f fVar, long j2) throws IOException {
        if (fVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (!this.f10281c) {
            f fVar2 = this.f10279a;
            if (fVar2.f10250c == 0 && this.f10280b.b(fVar2, 8192) == -1) {
                return -1;
            }
            return this.f10279a.b(fVar, Math.min(j2, this.f10279a.f10250c));
        } else {
            throw new IllegalStateException(Action.CLOSED);
        }
    }

    public String c(long j2) throws IOException {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            long a2 = a(10, 0, j3);
            if (a2 != -1) {
                return this.f10279a.j(a2);
            }
            if (j3 < Long.MAX_VALUE && a(j3) && this.f10279a.h(j3 - 1) == 13 && a(1 + j3) && this.f10279a.h(j3) == 10) {
                return this.f10279a.j(j3);
            }
            f fVar = new f();
            f fVar2 = this.f10279a;
            fVar2.a(fVar, 0, Math.min(32, fVar2.size()));
            StringBuilder sb = new StringBuilder();
            sb.append("\\n not found: limit=");
            sb.append(Math.min(this.f10279a.size(), j2));
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

    public void close() throws IOException {
        if (!this.f10281c) {
            this.f10281c = true;
            this.f10280b.close();
            this.f10279a.a();
        }
    }

    public byte[] d(long j2) throws IOException {
        e(j2);
        return this.f10279a.d(j2);
    }

    public void e(long j2) throws IOException {
        if (!a(j2)) {
            throw new EOFException();
        }
    }

    public f getBuffer() {
        return this.f10279a;
    }

    public boolean isOpen() {
        return !this.f10281c;
    }

    public f n() {
        return this.f10279a;
    }

    public boolean o() throws IOException {
        if (!this.f10281c) {
            return this.f10279a.o() && this.f10280b.b(this.f10279a, 8192) == -1;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public String p() throws IOException {
        return c(Long.MAX_VALUE);
    }

    public int q() throws IOException {
        e(4);
        return this.f10279a.q();
    }

    public short r() throws IOException {
        e(2);
        return this.f10279a.r();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        f fVar = this.f10279a;
        if (fVar.f10250c == 0 && this.f10280b.b(fVar, 8192) == -1) {
            return -1;
        }
        return this.f10279a.read(byteBuffer);
    }

    public byte readByte() throws IOException {
        e(1);
        return this.f10279a.readByte();
    }

    public void readFully(byte[] bArr) throws IOException {
        try {
            e((long) bArr.length);
            this.f10279a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                f fVar = this.f10279a;
                long j2 = fVar.f10250c;
                if (j2 > 0) {
                    int a2 = fVar.a(bArr, i2, (int) j2);
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
        return this.f10279a.readInt();
    }

    public short readShort() throws IOException {
        e(2);
        return this.f10279a.readShort();
    }

    public long s() throws IOException {
        e(1);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!a((long) i3)) {
                break;
            }
            byte h2 = this.f10279a.h((long) i2);
            if ((h2 >= 48 && h2 <= 57) || ((h2 >= 97 && h2 <= 102) || (h2 >= 65 && h2 <= 70))) {
                i2 = i3;
            } else if (i2 == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[]{Byte.valueOf(h2)}));
            }
        }
        return this.f10279a.s();
    }

    public void skip(long j2) throws IOException {
        if (!this.f10281c) {
            while (j2 > 0) {
                f fVar = this.f10279a;
                if (fVar.f10250c == 0 && this.f10280b.b(fVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.f10279a.size());
                this.f10279a.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public InputStream t() {
        return new u(this);
    }

    public C timeout() {
        return this.f10280b.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f10280b);
        sb.append(")");
        return sb.toString();
    }

    public long a(z zVar) throws IOException {
        if (zVar != null) {
            long j2 = 0;
            while (this.f10280b.b(this.f10279a, 8192) != -1) {
                long b2 = this.f10279a.b();
                if (b2 > 0) {
                    j2 += b2;
                    zVar.a(this.f10279a, b2);
                }
            }
            if (this.f10279a.size() <= 0) {
                return j2;
            }
            long size = j2 + this.f10279a.size();
            f fVar = this.f10279a;
            zVar.a(fVar, fVar.size());
            return size;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public i b(long j2) throws IOException {
        e(j2);
        return this.f10279a.b(j2);
    }

    public long a(byte b2) throws IOException {
        return a(b2, 0, Long.MAX_VALUE);
    }

    public long a(byte b2, long j2, long j3) throws IOException {
        if (this.f10281c) {
            throw new IllegalStateException(Action.CLOSED);
        } else if (j2 < 0 || j3 < j2) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(j2), Long.valueOf(j3)}));
        } else {
            while (j2 < j3) {
                long a2 = this.f10279a.a(b2, j2, j3);
                if (a2 == -1) {
                    f fVar = this.f10279a;
                    long j4 = fVar.f10250c;
                    if (j4 >= j3 || this.f10280b.b(fVar, 8192) == -1) {
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
}
