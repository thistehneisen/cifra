package com.fasterxml.jackson.core.b;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: MergedStream */
public final class f extends InputStream {

    /* renamed from: a reason: collision with root package name */
    private final c f4212a;

    /* renamed from: b reason: collision with root package name */
    private final InputStream f4213b;

    /* renamed from: c reason: collision with root package name */
    private byte[] f4214c;

    /* renamed from: d reason: collision with root package name */
    private int f4215d;

    /* renamed from: e reason: collision with root package name */
    private final int f4216e;

    public f(c cVar, InputStream inputStream, byte[] bArr, int i2, int i3) {
        this.f4212a = cVar;
        this.f4213b = inputStream;
        this.f4214c = bArr;
        this.f4215d = i2;
        this.f4216e = i3;
    }

    private void a() {
        byte[] bArr = this.f4214c;
        if (bArr != null) {
            this.f4214c = null;
            c cVar = this.f4212a;
            if (cVar != null) {
                cVar.a(bArr);
            }
        }
    }

    public int available() throws IOException {
        if (this.f4214c != null) {
            return this.f4216e - this.f4215d;
        }
        return this.f4213b.available();
    }

    public void close() throws IOException {
        a();
        this.f4213b.close();
    }

    public void mark(int i2) {
        if (this.f4214c == null) {
            this.f4213b.mark(i2);
        }
    }

    public boolean markSupported() {
        return this.f4214c == null && this.f4213b.markSupported();
    }

    public int read() throws IOException {
        byte[] bArr = this.f4214c;
        if (bArr == null) {
            return this.f4213b.read();
        }
        int i2 = this.f4215d;
        this.f4215d = i2 + 1;
        byte b2 = bArr[i2] & 255;
        if (this.f4215d >= this.f4216e) {
            a();
        }
        return b2;
    }

    public void reset() throws IOException {
        if (this.f4214c == null) {
            this.f4213b.reset();
        }
    }

    public long skip(long j2) throws IOException {
        long j3;
        if (this.f4214c != null) {
            int i2 = this.f4216e;
            int i3 = this.f4215d;
            long j4 = (long) (i2 - i3);
            if (j4 > j2) {
                this.f4215d = i3 + ((int) j2);
                return j2;
            }
            a();
            j3 = j4 + 0;
            j2 -= j4;
        } else {
            j3 = 0;
        }
        if (j2 > 0) {
            j3 += this.f4213b.skip(j2);
        }
        return j3;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f4214c == null) {
            return this.f4213b.read(bArr, i2, i3);
        }
        int i4 = this.f4216e - this.f4215d;
        if (i3 > i4) {
            i3 = i4;
        }
        System.arraycopy(this.f4214c, this.f4215d, bArr, i2, i3);
        this.f4215d += i3;
        if (this.f4215d >= this.f4216e) {
            a();
        }
        return i3;
    }
}
