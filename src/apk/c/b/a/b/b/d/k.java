package c.b.a.b.b.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class k extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    private long f3057a;

    /* renamed from: b reason: collision with root package name */
    private long f3058b = -1;

    k(InputStream inputStream, long j2) {
        super(inputStream);
        g.a(inputStream);
        this.f3057a = 1048576;
    }

    public final int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.f3057a);
    }

    public final synchronized void mark(int i2) {
        this.in.mark(i2);
        this.f3058b = this.f3057a;
    }

    public final int read() throws IOException {
        if (this.f3057a == 0) {
            return -1;
        }
        int read = this.in.read();
        if (read != -1) {
            this.f3057a--;
        }
        return read;
    }

    public final synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.f3058b != -1) {
            this.in.reset();
            this.f3057a = this.f3058b;
        } else {
            throw new IOException("Mark not set");
        }
    }

    public final long skip(long j2) throws IOException {
        long skip = this.in.skip(Math.min(j2, this.f3057a));
        this.f3057a -= skip;
        return skip;
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.f3057a;
        if (j2 == 0) {
            return -1;
        }
        int read = this.in.read(bArr, i2, (int) Math.min((long) i3, j2));
        if (read != -1) {
            this.f3057a -= (long) read;
        }
        return read;
    }
}
