package e.a.b;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink */
final class u implements h {

    /* renamed from: a reason: collision with root package name */
    public final g f7911a = new g();

    /* renamed from: b reason: collision with root package name */
    public final A f7912b;

    /* renamed from: c reason: collision with root package name */
    boolean f7913c;

    u(A a2) {
        if (a2 != null) {
            this.f7912b = a2;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public h a(j jVar) throws IOException {
        if (!this.f7913c) {
            this.f7911a.a(jVar);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public void close() throws IOException {
        if (!this.f7913c) {
            try {
                if (this.f7911a.f7883c > 0) {
                    this.f7912b.write(this.f7911a, this.f7911a.f7883c);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f7912b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f7913c = true;
            if (th != null) {
                E.a(th);
                throw null;
            }
        }
    }

    public h f(long j2) throws IOException {
        if (!this.f7913c) {
            this.f7911a.f(j2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public void flush() throws IOException {
        if (!this.f7913c) {
            g gVar = this.f7911a;
            long j2 = gVar.f7883c;
            if (j2 > 0) {
                this.f7912b.write(gVar, j2);
            }
            this.f7912b.flush();
            return;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h g(long j2) throws IOException {
        if (!this.f7913c) {
            this.f7911a.g(j2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public boolean isOpen() {
        return !this.f7913c;
    }

    public g n() {
        return this.f7911a;
    }

    public D timeout() {
        return this.f7912b.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f7912b);
        sb.append(")");
        return sb.toString();
    }

    public h u() throws IOException {
        if (!this.f7913c) {
            long b2 = this.f7911a.b();
            if (b2 > 0) {
                this.f7912b.write(this.f7911a, b2);
            }
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h v() throws IOException {
        if (!this.f7913c) {
            long size = this.f7911a.size();
            if (size > 0) {
                this.f7912b.write(this.f7911a, size);
            }
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public void write(g gVar, long j2) throws IOException {
        if (!this.f7913c) {
            this.f7911a.write(gVar, j2);
            u();
            return;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h writeByte(int i2) throws IOException {
        if (!this.f7913c) {
            this.f7911a.writeByte(i2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h writeInt(int i2) throws IOException {
        if (!this.f7913c) {
            this.f7911a.writeInt(i2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h writeShort(int i2) throws IOException {
        if (!this.f7913c) {
            this.f7911a.writeShort(i2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h a(String str) throws IOException {
        if (!this.f7913c) {
            this.f7911a.a(str);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public h write(byte[] bArr) throws IOException {
        if (!this.f7913c) {
            this.f7911a.write(bArr);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public long a(B b2) throws IOException {
        if (b2 != null) {
            long j2 = 0;
            while (true) {
                long read = b2.read(this.f7911a, 8192);
                if (read == -1) {
                    return j2;
                }
                j2 += read;
                u();
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public h write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f7913c) {
            this.f7911a.write(bArr, i2, i3);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f7913c) {
            int write = this.f7911a.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException(Action.CLOSED);
    }
}
