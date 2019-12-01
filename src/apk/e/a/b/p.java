package e.a.b;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Okio */
class p implements A {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f7905a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ OutputStream f7906b;

    p(D d2, OutputStream outputStream) {
        this.f7905a = d2;
        this.f7906b = outputStream;
    }

    public void close() throws IOException {
        this.f7906b.close();
    }

    public void flush() throws IOException {
        this.f7906b.flush();
    }

    public D timeout() {
        return this.f7905a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sink(");
        sb.append(this.f7906b);
        sb.append(")");
        return sb.toString();
    }

    public void write(g gVar, long j2) throws IOException {
        E.a(gVar.f7883c, 0, j2);
        while (j2 > 0) {
            this.f7905a.throwIfReached();
            x xVar = gVar.f7882b;
            int min = (int) Math.min(j2, (long) (xVar.f7920c - xVar.f7919b));
            this.f7906b.write(xVar.f7918a, xVar.f7919b, min);
            xVar.f7919b += min;
            long j3 = (long) min;
            j2 -= j3;
            gVar.f7883c -= j3;
            if (xVar.f7919b == xVar.f7920c) {
                gVar.f7882b = xVar.b();
                y.a(xVar);
            }
        }
    }
}
