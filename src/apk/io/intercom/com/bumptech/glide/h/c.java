package io.intercom.com.bumptech.glide.h;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream */
public class c extends InputStream {

    /* renamed from: a reason: collision with root package name */
    private static final Queue<c> f9393a = j.a(0);

    /* renamed from: b reason: collision with root package name */
    private InputStream f9394b;

    /* renamed from: c reason: collision with root package name */
    private IOException f9395c;

    c() {
    }

    public static c a(InputStream inputStream) {
        c cVar;
        synchronized (f9393a) {
            cVar = (c) f9393a.poll();
        }
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(inputStream);
        return cVar;
    }

    public int available() throws IOException {
        return this.f9394b.available();
    }

    /* access modifiers changed from: 0000 */
    public void b(InputStream inputStream) {
        this.f9394b = inputStream;
    }

    public void close() throws IOException {
        this.f9394b.close();
    }

    public void mark(int i2) {
        this.f9394b.mark(i2);
    }

    public boolean markSupported() {
        return this.f9394b.markSupported();
    }

    public int read(byte[] bArr) throws IOException {
        try {
            return this.f9394b.read(bArr);
        } catch (IOException e2) {
            this.f9395c = e2;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.f9394b.reset();
    }

    public long skip(long j2) throws IOException {
        try {
            return this.f9394b.skip(j2);
        } catch (IOException e2) {
            this.f9395c = e2;
            return 0;
        }
    }

    public void b() {
        this.f9395c = null;
        this.f9394b = null;
        synchronized (f9393a) {
            f9393a.offer(this);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            return this.f9394b.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f9395c = e2;
            return -1;
        }
    }

    public int read() throws IOException {
        try {
            return this.f9394b.read();
        } catch (IOException e2) {
            this.f9395c = e2;
            return -1;
        }
    }

    public IOException a() {
        return this.f9395c;
    }
}
