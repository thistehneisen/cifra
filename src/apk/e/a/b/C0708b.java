package e.a.b;

import java.io.IOException;

/* renamed from: e.a.b.b reason: case insensitive filesystem */
/* compiled from: AsyncTimeout */
class C0708b implements B {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ B f7875a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0709c f7876b;

    C0708b(C0709c cVar, B b2) {
        this.f7876b = cVar;
        this.f7875a = b2;
    }

    public void close() throws IOException {
        try {
            this.f7875a.close();
            this.f7876b.exit(true);
        } catch (IOException e2) {
            throw this.f7876b.exit(e2);
        } catch (Throwable th) {
            this.f7876b.exit(false);
            throw th;
        }
    }

    public long read(g gVar, long j2) throws IOException {
        this.f7876b.enter();
        try {
            long read = this.f7875a.read(gVar, j2);
            this.f7876b.exit(true);
            return read;
        } catch (IOException e2) {
            throw this.f7876b.exit(e2);
        } catch (Throwable th) {
            this.f7876b.exit(false);
            throw th;
        }
    }

    public D timeout() {
        return this.f7876b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.source(");
        sb.append(this.f7875a);
        sb.append(")");
        return sb.toString();
    }
}
