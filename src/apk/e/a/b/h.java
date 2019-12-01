package e.a.b;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink */
public interface h extends A, WritableByteChannel {
    long a(B b2) throws IOException;

    h a(j jVar) throws IOException;

    h a(String str) throws IOException;

    h f(long j2) throws IOException;

    void flush() throws IOException;

    h g(long j2) throws IOException;

    g n();

    h u() throws IOException;

    h v() throws IOException;

    h write(byte[] bArr) throws IOException;

    h write(byte[] bArr, int i2, int i3) throws IOException;

    h writeByte(int i2) throws IOException;

    h writeInt(int i2) throws IOException;

    h writeShort(int i2) throws IOException;
}
