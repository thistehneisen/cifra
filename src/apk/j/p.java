package j;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Okio */
class p implements A {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C f10269a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ InputStream f10270b;

    p(C c2, InputStream inputStream) {
        this.f10269a = c2;
        this.f10270b = inputStream;
    }

    public long b(f fVar, long j2) throws IOException {
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
                this.f10269a.e();
                w b2 = fVar.b(1);
                int read = this.f10270b.read(b2.f10282a, b2.f10284c, (int) Math.min(j2, (long) (8192 - b2.f10284c)));
                if (read == -1) {
                    return -1;
                }
                b2.f10284c += read;
                long j3 = (long) read;
                fVar.f10250c += j3;
                return j3;
            } catch (AssertionError e2) {
                if (r.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    public void close() throws IOException {
        this.f10270b.close();
    }

    public C timeout() {
        return this.f10269a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("source(");
        sb.append(this.f10270b);
        sb.append(")");
        return sb.toString();
    }
}
