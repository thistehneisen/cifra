package io.intercom.com.bumptech.glide.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream */
public class f extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    private int f9401a = Integer.MIN_VALUE;

    public f(InputStream inputStream) {
        super(inputStream);
    }

    private long h(long j2) {
        int i2 = this.f9401a;
        if (i2 == 0) {
            return -1;
        }
        if (i2 != Integer.MIN_VALUE && j2 > ((long) i2)) {
            j2 = (long) i2;
        }
        return j2;
    }

    private void i(long j2) {
        int i2 = this.f9401a;
        if (i2 != Integer.MIN_VALUE && j2 != -1) {
            this.f9401a = (int) (((long) i2) - j2);
        }
    }

    public int available() throws IOException {
        int i2 = this.f9401a;
        if (i2 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i2, super.available());
    }

    public void mark(int i2) {
        super.mark(i2);
        this.f9401a = i2;
    }

    public int read() throws IOException {
        if (h(1) == -1) {
            return -1;
        }
        int read = super.read();
        i(1);
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        this.f9401a = Integer.MIN_VALUE;
    }

    public long skip(long j2) throws IOException {
        long h2 = h(j2);
        if (h2 == -1) {
            return 0;
        }
        long skip = super.skip(h2);
        i(skip);
        return skip;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int h2 = (int) h((long) i3);
        if (h2 == -1) {
            return -1;
        }
        int read = super.read(bArr, i2, h2);
        i((long) read);
        return read;
    }
}
