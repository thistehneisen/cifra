package io.intercom.com.bumptech.glide.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
class d implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private final InputStream f9163a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Charset f9164b;

    /* renamed from: c reason: collision with root package name */
    private byte[] f9165c;

    /* renamed from: d reason: collision with root package name */
    private int f9166d;

    /* renamed from: e reason: collision with root package name */
    private int f9167e;

    public d(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f9163a;
        byte[] bArr = this.f9165c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f9166d = 0;
            this.f9167e = read;
            return;
        }
        throw new EOFException();
    }

    public String b() throws IOException {
        int i2;
        int i3;
        synchronized (this.f9163a) {
            if (this.f9165c != null) {
                if (this.f9166d >= this.f9167e) {
                    c();
                }
                for (int i4 = this.f9166d; i4 != this.f9167e; i4++) {
                    if (this.f9165c[i4] == 10) {
                        if (i4 != this.f9166d) {
                            i3 = i4 - 1;
                            if (this.f9165c[i3] == 13) {
                                String str = new String(this.f9165c, this.f9166d, i3 - this.f9166d, this.f9164b.name());
                                this.f9166d = i4 + 1;
                                return str;
                            }
                        }
                        i3 = i4;
                        String str2 = new String(this.f9165c, this.f9166d, i3 - this.f9166d, this.f9164b.name());
                        this.f9166d = i4 + 1;
                        return str2;
                    }
                }
                c cVar = new c(this, (this.f9167e - this.f9166d) + 80);
                loop1:
                while (true) {
                    cVar.write(this.f9165c, this.f9166d, this.f9167e - this.f9166d);
                    this.f9167e = -1;
                    c();
                    i2 = this.f9166d;
                    while (true) {
                        if (i2 != this.f9167e) {
                            if (this.f9165c[i2] == 10) {
                                break loop1;
                            }
                            i2++;
                        }
                    }
                }
                if (i2 != this.f9166d) {
                    cVar.write(this.f9165c, this.f9166d, i2 - this.f9166d);
                }
                this.f9166d = i2 + 1;
                String cVar2 = cVar.toString();
                return cVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public void close() throws IOException {
        synchronized (this.f9163a) {
            if (this.f9165c != null) {
                this.f9165c = null;
                this.f9163a.close();
            }
        }
    }

    public d(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(e.f9168a)) {
            this.f9163a = inputStream;
            this.f9164b = charset;
            this.f9165c = new byte[i2];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public boolean a() {
        return this.f9167e == -1;
    }
}
