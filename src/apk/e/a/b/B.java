package e.a.b;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Source */
public interface B extends Closeable {
    void close() throws IOException;

    long read(g gVar, long j2) throws IOException;

    D timeout();
}
