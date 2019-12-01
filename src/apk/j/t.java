package j;

import io.intercom.android.sdk.metrics.MetricTracker.Action;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: RealBufferedSink */
final class t implements g {

    /* renamed from: a reason: collision with root package name */
    public final f f10275a = new f();

    /* renamed from: b reason: collision with root package name */
    public final z f10276b;

    /* renamed from: c reason: collision with root package name */
    boolean f10277c;

    t(z zVar) {
        if (zVar != null) {
            this.f10276b = zVar;
            return;
        }
        throw new NullPointerException("sink == null");
    }

    public void a(f fVar, long j2) throws IOException {
        if (!this.f10277c) {
            this.f10275a.a(fVar, j2);
            u();
            return;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public void close() throws IOException {
        if (!this.f10277c) {
            try {
                if (this.f10275a.f10250c > 0) {
                    this.f10276b.a(this.f10275a, this.f10275a.f10250c);
                }
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.f10276b.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.f10277c = true;
            if (th != null) {
                D.a(th);
                throw null;
            }
        }
    }

    public g f(long j2) throws IOException {
        if (!this.f10277c) {
            this.f10275a.f(j2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public void flush() throws IOException {
        if (!this.f10277c) {
            f fVar = this.f10275a;
            long j2 = fVar.f10250c;
            if (j2 > 0) {
                this.f10276b.a(fVar, j2);
            }
            this.f10276b.flush();
            return;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g g(long j2) throws IOException {
        if (!this.f10277c) {
            this.f10275a.g(j2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public boolean isOpen() {
        return !this.f10277c;
    }

    public f n() {
        return this.f10275a;
    }

    public C timeout() {
        return this.f10276b.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("buffer(");
        sb.append(this.f10276b);
        sb.append(")");
        return sb.toString();
    }

    public g u() throws IOException {
        if (!this.f10277c) {
            long b2 = this.f10275a.b();
            if (b2 > 0) {
                this.f10276b.a(this.f10275a, b2);
            }
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g write(byte[] bArr) throws IOException {
        if (!this.f10277c) {
            this.f10275a.write(bArr);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g writeByte(int i2) throws IOException {
        if (!this.f10277c) {
            this.f10275a.writeByte(i2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g writeInt(int i2) throws IOException {
        if (!this.f10277c) {
            this.f10275a.writeInt(i2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g writeShort(int i2) throws IOException {
        if (!this.f10277c) {
            this.f10275a.writeShort(i2);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g a(i iVar) throws IOException {
        if (!this.f10277c) {
            this.f10275a.a(iVar);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g write(byte[] bArr, int i2, int i3) throws IOException {
        if (!this.f10277c) {
            this.f10275a.write(bArr, i2, i3);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public g a(String str) throws IOException {
        if (!this.f10277c) {
            this.f10275a.a(str);
            u();
            return this;
        }
        throw new IllegalStateException(Action.CLOSED);
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f10277c) {
            int write = this.f10275a.write(byteBuffer);
            u();
            return write;
        }
        throw new IllegalStateException(Action.CLOSED);
    }
}
