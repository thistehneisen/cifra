package com.bumptech.glide.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
class d implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private final InputStream f3305a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Charset f3306b;

    /* renamed from: c reason: collision with root package name */
    private byte[] f3307c;

    /* renamed from: d reason: collision with root package name */
    private int f3308d;

    /* renamed from: e reason: collision with root package name */
    private int f3309e;

    public d(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f3305a;
        byte[] bArr = this.f3307c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f3308d = 0;
            this.f3309e = read;
            return;
        }
        throw new EOFException();
    }

    public String b() throws IOException {
        int i2;
        int i3;
        synchronized (this.f3305a) {
            if (this.f3307c != null) {
                if (this.f3308d >= this.f3309e) {
                    c();
                }
                for (int i4 = this.f3308d; i4 != this.f3309e; i4++) {
                    if (this.f3307c[i4] == 10) {
                        if (i4 != this.f3308d) {
                            i3 = i4 - 1;
                            if (this.f3307c[i3] == 13) {
                                String str = new String(this.f3307c, this.f3308d, i3 - this.f3308d, this.f3306b.name());
                                this.f3308d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f3307c, this.f3308d, i3 - this.f3308d, this.f3306b.name());
                        this.f3308d = i4 + 1;
                        return str2;
                    }
                }
                c cVar = new c(this, (this.f3309e - this.f3308d) + 80);
                loop1:
                while (true) {
                    cVar.write(this.f3307c, this.f3308d, this.f3309e - this.f3308d);
                    this.f3309e = -1;
                    c();
                    i2 = this.f3308d;
                    while (true) {
                        if (i2 != this.f3309e) {
                            if (this.f3307c[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                if (i2 != this.f3308d) {
                    cVar.write(this.f3307c, this.f3308d, i2 - this.f3308d);
                }
                this.f3308d = i2 + 1;
                String cVar2 = cVar.toString();
                return cVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public void close() throws IOException {
        synchronized (this.f3305a) {
            if (this.f3307c != null) {
                this.f3307c = null;
                this.f3305a.close();
            }
        }
    }

    public d(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(e.f3310a)) {
            this.f3305a = inputStream;
            this.f3306b = charset;
            this.f3307c = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public boolean a() {
        return this.f3309e == -1;
    }
}
