package j;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Okio */
class o implements z {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C f10267a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ OutputStream f10268b;

    o(C c2, OutputStream outputStream) {
        this.f10267a = c2;
        this.f10268b = outputStream;
    }

    public void a(f fVar, long j2) throws IOException {
        D.a(fVar.f10250c, 0, j2);
        while (j2 > 0) {
            this.f10267a.e();
            w wVar = fVar.f10249b;
            int min = (int) Math.min(j2, (long) (wVar.f10284c - wVar.f10283b));
            this.f10268b.write(wVar.f10282a, wVar.f10283b, min);
            wVar.f10283b += min;
            long j3 = (long) min;
            j2 -= j3;
            fVar.f10250c -= j3;
            if (wVar.f10283b == wVar.f10284c) {
                fVar.f10249b = wVar.b();
                x.a(wVar);
            }
        }
    }

    public void close() throws IOException {
        this.f10268b.close();
    }

    public void flush() throws IOException {
        this.f10268b.flush();
    }

    public C timeout() {
        return this.f10267a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sink(");
        sb.append(this.f10268b);
        sb.append(")");
        return sb.toString();
    }
}
