package com.bumptech.glide.h;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream */
public class d extends InputStream {

    /* renamed from: a reason: collision with root package name */
    private static final Queue<d> f3517a = n.a(0);

    /* renamed from: b reason: collision with root package name */
    private InputStream f3518b;

    /* renamed from: c reason: collision with root package name */
    private IOException f3519c;

    d() {
    }

    public static d a(InputStream inputStream) {
        d dVar;
        synchronized (f3517a) {
            dVar = (d) f3517a.poll();
        }
        if (dVar == null) {
            dVar = new d();
        }
        dVar.b(inputStream);
        return dVar;
    }

    public int available() throws IOException {
        return this.f3518b.available();
    }

    /* access modifiers changed from: 0000 */
    public void b(InputStream inputStream) {
        this.f3518b = inputStream;
    }

    public void close() throws IOException {
        this.f3518b.close();
    }

    public void mark(int i2) {
        this.f3518b.mark(i2);
    }

    public boolean markSupported() {
        return this.f3518b.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f3518b.read(bArr);
        } catch (IOException e2) {
            this.f3519c = e2;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f3518b.reset();
    }

    public long skip(long j2) {
        try {
            return this.f3518b.skip(j2);
        } catch (IOException e2) {
            this.f3519c = e2;
            return 0;
        }
    }

    public void b() {
        this.f3519c = null;
        this.f3518b = null;
        synchronized (f3517a) {
            f3517a.offer(this);
        }
    }

    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f3518b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f3519c = e2;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f3518b.read();
        } catch (IOException e2) {
            this.f3519c = e2;
            return -1;
        }
    }

    public IOException a() {
        return this.f3519c;
    }
}
