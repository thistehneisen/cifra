package com.bumptech.glide.load.a;

import com.bumptech.glide.load.engine.a.b;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream */
public final class c extends OutputStream {

    /* renamed from: a reason: collision with root package name */
    private final OutputStream f3573a;

    /* renamed from: b reason: collision with root package name */
    private byte[] f3574b;

    /* renamed from: c reason: collision with root package name */
    private b f3575c;

    /* renamed from: d reason: collision with root package name */
    private int f3576d;

    public c(OutputStream outputStream, b bVar) {
        this(outputStream, bVar, 65536);
    }

    private void a() throws IOException {
        int i2 = this.f3576d;
        if (i2 > 0) {
            this.f3573a.write(this.f3574b, 0, i2);
            this.f3576d = 0;
        }
    }

    private void b() throws IOException {
        if (this.f3576d == this.f3574b.length) {
            a();
        }
    }

    private void c() {
        byte[] bArr = this.f3574b;
        if (bArr != null) {
            this.f3575c.put(bArr);
            this.f3574b = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f3573a.close();
            c();
        } catch (Throwable th) {
            this.f3573a.close();
            throw th;
        }
    }

    public void flush() throws IOException {
        a();
        this.f3573a.flush();
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.f3574b;
        int i3 = this.f3576d;
        this.f3576d = i3 + 1;
        bArr[i3] = (byte) i2;
        b();
    }

    c(OutputStream outputStream, b bVar, int i2) {
        this.f3573a = outputStream;
        this.f3575c = bVar;
        this.f3574b = (byte[]) bVar.b(i2, byte[].class);
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            if (this.f3576d != 0 || i5 < this.f3574b.length) {
                int min = Math.min(i5, this.f3574b.length - this.f3576d);
                System.arraycopy(bArr, i6, this.f3574b, this.f3576d, min);
                this.f3576d += min;
                i4 += min;
                b();
            } else {
                this.f3573a.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
