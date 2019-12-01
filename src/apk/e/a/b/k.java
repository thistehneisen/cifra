package e.a.b;

import java.io.IOException;

/* compiled from: ForwardingSink */
public abstract class k implements A {
    private final A delegate;

    public k(A a2) {
        if (a2 != null) {
            this.delegate = a2;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final A delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
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

    public void write(g gVar, long j2) throws IOException {
        this.delegate.write(gVar, j2);
    }
}
