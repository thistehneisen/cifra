package j;

import java.io.IOException;

/* compiled from: ForwardingSink */
public abstract class j implements z {

    /* renamed from: a reason: collision with root package name */
    private final z f10255a;

    public j(z zVar) {
        if (zVar != null) {
            this.f10255a = zVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void a(f fVar, long j2) throws IOException {
        this.f10255a.a(fVar, j2);
    }

    public void close() throws IOException {
        this.f10255a.close();
    }

    public void flush() throws IOException {
        this.f10255a.flush();
    }

    public C timeout() {
        return this.f10255a.timeout();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        sb.append(this.f10255a.toString());
        sb.append(")");
        return sb.toString();
    }
}
