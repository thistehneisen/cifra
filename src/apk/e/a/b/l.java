package e.a.b;

import java.io.IOException;

/* compiled from: ForwardingSource */
public abstract class l implements B {
    private final B delegate;

    public l(B b2) {
        if (b2 != null) {
            this.delegate = b2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final B delegate() {
        return this.delegate;
    }

    public long read(g gVar, long j2) throws IOException {
        return this.delegate.read(gVar, j2);
    }

    public D timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.delegate.toString());
        sb.append(")");
        return sb.toString();
    }
}
