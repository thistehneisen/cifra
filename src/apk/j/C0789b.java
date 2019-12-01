package j;

import java.io.IOException;

/* renamed from: j.b reason: case insensitive filesystem */
/* compiled from: AsyncTimeout */
class C0789b implements A {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ A f10237a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0790c f10238b;

    C0789b(C0790c cVar, A a2) {
        this.f10238b = cVar;
        this.f10237a = a2;
    }

    public long b(f fVar, long j2) throws IOException {
        this.f10238b.h();
        try {
            long b2 = this.f10237a.b(fVar, j2);
            this.f10238b.a(true);
            return b2;
        } catch (IOException e2) {
            throw this.f10238b.a(e2);
        } catch (Throwable th) {
            this.f10238b.a(false);
            throw th;
        }
    }

    public void close() throws IOException {
        this.f10238b.h();
        try {
            this.f10237a.close();
            this.f10238b.a(true);
        } catch (IOException e2) {
            throw this.f10238b.a(e2);
        } catch (Throwable th) {
            this.f10238b.a(false);
            throw th;
        }
    }

    public C timeout() {
        return this.f10238b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.source(");
        sb.append(this.f10237a);
        sb.append(")");
        return sb.toString();
    }
}
