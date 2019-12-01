package j;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* compiled from: BufferedSink */
public interface g extends z, WritableByteChannel {
    g a(i iVar) throws IOException;

    g a(String str) throws IOException;

    g f(long j2) throws IOException;

    void flush() throws IOException;

    g g(long j2) throws IOException;

    f n();

    g u() throws IOException;

    g write(byte[] bArr) throws IOException;

    g write(byte[] bArr, int i2, int i3) throws IOException;

    g writeByte(int i2) throws IOException;

    g writeInt(int i2) throws IOException;

    g writeShort(int i2) throws IOException;
}
