package e.a.b;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: BufferedSource */
public interface i extends B, ReadableByteChannel {
    long a(byte b2) throws IOException;

    long a(A a2) throws IOException;

    String a(Charset charset) throws IOException;

    void a(g gVar, long j2) throws IOException;

    boolean a(long j2) throws IOException;

    boolean a(long j2, j jVar) throws IOException;

    j b(long j2) throws IOException;

    String c(long j2) throws IOException;

    byte[] d(long j2) throws IOException;

    void e(long j2) throws IOException;

    g n();

    boolean o() throws IOException;

    String p() throws IOException;

    int q() throws IOException;

    short r() throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    long s() throws IOException;

    void skip(long j2) throws IOException;

    InputStream t();

    byte[] w() throws IOException;

    long x() throws IOException;
}
