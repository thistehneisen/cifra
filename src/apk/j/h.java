package j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;

/* compiled from: BufferedSource */
public interface h extends A, ReadableByteChannel {
    long a(byte b2) throws IOException;

    long a(z zVar) throws IOException;

    boolean a(long j2) throws IOException;

    i b(long j2) throws IOException;

    String c(long j2) throws IOException;

    byte[] d(long j2) throws IOException;

    void e(long j2) throws IOException;

    f getBuffer();

    @Deprecated
    f n();

    boolean o() throws IOException;

    String p() throws IOException;

    int q() throws IOException;

    short r() throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    long s() throws IOException;

    void skip(long j2) throws IOException;

    InputStream t();
}
