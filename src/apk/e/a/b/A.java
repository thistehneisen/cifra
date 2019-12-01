package e.a.b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink */
public interface A extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    D timeout();

    void write(g gVar, long j2) throws IOException;
}
