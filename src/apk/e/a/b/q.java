package e.a.b;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Okio */
class q implements B {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f7907a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ InputStream f7908b;

    q(D d2, InputStream inputStream) {
        this.f7907a = d2;
        this.f7908b = inputStream;
    }

    public void close() throws IOException {
        this.f7908b.close();
    }

    public long read(g gVar, long j2) throws IOException {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("byteCount < 0: ");
            sb.append(j2);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 == 0) {
            return 0;
        } else {
            try {
                this.f7907a.throwIfReached();
                x b2 = gVar.b(1);
                int read = this.f7908b.read(b2.f7918a, b2.f7920c, (int) Math.min(j2, (long) (8192 - b2.f7920c)));
                if (read == -1) {
                    return -1;
                }
                b2.f7920c += read;
                long j3 = (long) read;
                gVar.f7883c += j3;
                return j3;
            } catch (AssertionError e2) {
                if (t.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    public D timeout() {
        return this.f7907a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("source(");
        sb.append(this.f7908b);
        sb.append(")");
        return sb.toString();
    }
}
