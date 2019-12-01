package j;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: Sink */
public interface z extends Closeable, Flushable {
    void a(f fVar, long j2) throws IOException;

    void close() throws IOException;

    void flush() throws IOException;

    C timeout();
}
