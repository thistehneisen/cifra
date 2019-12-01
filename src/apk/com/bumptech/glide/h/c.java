package com.bumptech.glide.h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream */
public final class c extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    private final long f3515a;

    /* renamed from: b reason: collision with root package name */
    private int f3516b;

    private c(InputStream inputStream, long j2) {
        super(inputStream);
        this.f3515a = j2;
    }

    public static InputStream a(InputStream inputStream, long j2) {
        return new c(inputStream, j2);
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f3515a - ((long) this.f3516b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    private int a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f3516b += i2;
        } else if (this.f3515a - ((long) this.f3516b) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to read all expected data, expected: ");
            sb.append(this.f3515a);
            sb.append(", but read: ");
            sb.append(this.f3516b);
            throw new IOException(sb.toString());
        }
        return i2;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int read;
        read = super.read(bArr, i2, i3);
        a(read);
        return read;
    }
}
