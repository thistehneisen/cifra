package j;

import java.io.IOException;

/* compiled from: ForwardingSource */
public abstract class k implements A {

    /* renamed from: a reason: collision with root package name */
    private final A f10256a;

    public k(A a2) {
        if (a2 != null) {
            this.f10256a = a2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final A a() {
        return this.f10256a;
    }

    public long b(f fVar, long j2) throws IOException {
        return this.f10256a.b(fVar, j2);
    }

    public void close() throws IOException {
        this.f10256a.close();
    }

    public C timeout() {
        return this.f10256a.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f10256a.toString());
        sb.append(")");
        return sb.toString();
    }
}
