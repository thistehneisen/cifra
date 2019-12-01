package e.a.b;

import java.io.IOException;

/* compiled from: Okio */
class r implements A {
    r() {
    }

    public void close() throws IOException {
    }

    public void flush() throws IOException {
    }

    public D timeout() {
        return D.NONE;
    }

    public void write(g gVar, long j2) throws IOException {
        gVar.skip(j2);
    }
}
