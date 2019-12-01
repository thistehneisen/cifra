package e.a.b;

import java.io.IOException;

/* renamed from: e.a.b.a reason: case insensitive filesystem */
/* compiled from: AsyncTimeout */
class C0707a implements A {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ A f7873a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0709c f7874b;

    C0707a(C0709c cVar, A a2) {
        this.f7874b = cVar;
        this.f7873a = a2;
    }

    public void close() throws IOException {
        this.f7874b.enter();
        try {
            this.f7873a.close();
            this.f7874b.exit(true);
        } catch (IOException e2) {
            throw this.f7874b.exit(e2);
        } catch (Throwable th) {
            this.f7874b.exit(false);
            throw th;
        }
    }

    public void flush() throws IOException {
        this.f7874b.enter();
        try {
            this.f7873a.flush();
            this.f7874b.exit(true);
        } catch (IOException e2) {
            throw this.f7874b.exit(e2);
        } catch (Throwable th) {
            this.f7874b.exit(false);
            throw th;
        }
    }

    public D timeout() {
        return this.f7874b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.sink(");
        sb.append(this.f7873a);
        sb.append(")");
        return sb.toString();
    }

    public void write(g gVar, long j2) throws IOException {
        E.a(gVar.f7883c, 0, j2);
        while (true) {
            long j3 = 0;
            if (j2 > 0) {
                x xVar = gVar.f7882b;
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    j3 += (long) (xVar.f7920c - xVar.f7919b);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    }
                    xVar = xVar.f7923f;
                }
                this.f7874b.enter();
                try {
                    this.f7873a.write(gVar, j3);
                    j2 -= j3;
                    this.f7874b.exit(true);
                } catch (IOException e2) {
                    throw this.f7874b.exit(e2);
                } catch (Throwable th) {
                    this.f7874b.exit(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
