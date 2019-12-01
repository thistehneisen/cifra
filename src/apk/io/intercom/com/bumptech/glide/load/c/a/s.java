package io.intercom.com.bumptech.glide.load.c.a;

import io.intercom.com.bumptech.glide.load.engine.a.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RecyclableBufferedInputStream */
public class s extends FilterInputStream {

    /* renamed from: a reason: collision with root package name */
    private volatile byte[] f9625a;

    /* renamed from: b reason: collision with root package name */
    private int f9626b;

    /* renamed from: c reason: collision with root package name */
    private int f9627c;

    /* renamed from: d reason: collision with root package name */
    private int f9628d;

    /* renamed from: e reason: collision with root package name */
    private int f9629e;

    /* renamed from: f reason: collision with root package name */
    private final b f9630f;

    /* compiled from: RecyclableBufferedInputStream */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public s(InputStream inputStream, b bVar) {
        this(inputStream, bVar, 65536);
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.f9627c = this.f9625a.length;
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f9625a == null || inputStream == null) {
            c();
            throw null;
        }
        return (this.f9626b - this.f9629e) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f9625a != null) {
            this.f9630f.put(this.f9625a);
            this.f9625a = null;
        }
    }

    public void close() throws IOException {
        if (this.f9625a != null) {
            this.f9630f.put(this.f9625a);
            this.f9625a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i2) {
        this.f9627c = Math.max(this.f9627c, i2);
        this.f9628d = this.f9629e;
    }

    public boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0026=Splitter:B:19:0x0026, B:11:0x0019=Splitter:B:11:0x0019, B:28:0x003b=Splitter:B:28:0x003b} */
    public synchronized int read() throws IOException {
        byte[] bArr = this.f9625a;
        InputStream inputStream = this.in;
        if (bArr == null || inputStream == null) {
            c();
            throw null;
        } else if (this.f9629e >= this.f9626b && a(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr != this.f9625a) {
                bArr = this.f9625a;
                if (bArr == null) {
                    c();
                    throw null;
                }
            }
            if (this.f9626b - this.f9629e <= 0) {
                return -1;
            }
            int i2 = this.f9629e;
            this.f9629e = i2 + 1;
            return bArr[i2] & 255;
        }
    }

    public synchronized void reset() throws IOException {
        if (this.f9625a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.f9628d) {
            this.f9629e = this.f9628d;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Mark has been invalidated, pos: ");
            sb.append(this.f9629e);
            sb.append(" markLimit: ");
            sb.append(this.f9627c);
            throw new a(sb.toString());
        }
    }

    public synchronized long skip(long j2) throws IOException {
        byte[] bArr = this.f9625a;
        InputStream inputStream = this.in;
        if (bArr == null) {
            c();
            throw null;
        } else if (j2 < 1) {
            return 0;
        } else {
            if (inputStream == null) {
                c();
                throw null;
            } else if (((long) (this.f9626b - this.f9629e)) >= j2) {
                this.f9629e = (int) (((long) this.f9629e) + j2);
                return j2;
            } else {
                long j3 = (long) (this.f9626b - this.f9629e);
                this.f9629e = this.f9626b;
                if (this.f9628d == -1 || j2 > ((long) this.f9627c)) {
                    return j3 + inputStream.skip(j2 - j3);
                } else if (a(inputStream, bArr) == -1) {
                    return j3;
                } else {
                    long j4 = j2 - j3;
                    if (((long) (this.f9626b - this.f9629e)) >= j4) {
                        this.f9629e = (int) (((long) this.f9629e) + j4);
                        return j2;
                    }
                    long j5 = (j3 + ((long) this.f9626b)) - ((long) this.f9629e);
                    this.f9629e = this.f9626b;
                    return j5;
                }
            }
        }
    }

    s(InputStream inputStream, b bVar, int i2) {
        super(inputStream);
        this.f9628d = -1;
        this.f9630f = bVar;
        this.f9625a = (byte[]) bVar.b(i2, byte[].class);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2 = this.f9628d;
        if (i2 != -1) {
            int i3 = this.f9629e - i2;
            int i4 = this.f9627c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f9626b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > i4) {
                        length = i4;
                    }
                    byte[] bArr2 = (byte[]) this.f9630f.b(length, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f9625a = bArr2;
                    this.f9630f.put(bArr);
                    bArr = bArr2;
                } else {
                    int i5 = this.f9628d;
                    if (i5 > 0) {
                        System.arraycopy(bArr, i5, bArr, 0, bArr.length - i5);
                    }
                }
                this.f9629e -= this.f9628d;
                this.f9628d = 0;
                this.f9626b = 0;
                int i6 = this.f9629e;
                int read = inputStream.read(bArr, i6, bArr.length - i6);
                this.f9626b = read <= 0 ? this.f9629e : this.f9629e + read;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f9628d = -1;
            this.f9629e = 0;
            this.f9626b = read2;
        }
        return read2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005e, code lost:
        return r5;
     */
    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte[] bArr2 = this.f9625a;
        if (bArr2 == null) {
            c();
            throw null;
        } else if (i3 == 0) {
            return 0;
        } else {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                if (this.f9629e < this.f9626b) {
                    int i6 = this.f9626b - this.f9629e >= i3 ? i3 : this.f9626b - this.f9629e;
                    System.arraycopy(bArr2, this.f9629e, bArr, i2, i6);
                    this.f9629e += i6;
                    if (i6 != i3 && inputStream.available() != 0) {
                        i2 += i6;
                        i4 = i3 - i6;
                    }
                } else {
                    i4 = i3;
                }
                while (true) {
                    int i7 = -1;
                    if (this.f9628d == -1 && i4 >= bArr2.length) {
                        i5 = inputStream.read(bArr, i2, i4);
                        if (i5 == -1) {
                            if (i4 != i3) {
                                i7 = i3 - i4;
                            }
                        }
                    } else if (a(inputStream, bArr2) != -1) {
                        if (bArr2 != this.f9625a) {
                            bArr2 = this.f9625a;
                            if (bArr2 == null) {
                                c();
                                throw null;
                            }
                        }
                        i5 = this.f9626b - this.f9629e >= i4 ? i4 : this.f9626b - this.f9629e;
                        System.arraycopy(bArr2, this.f9629e, bArr, i2, i5);
                        this.f9629e += i5;
                    } else if (i4 != i3) {
                        i7 = i3 - i4;
                    }
                    i4 -= i5;
                    if (i4 == 0) {
                        return i3;
                    }
                    if (inputStream.available() == 0) {
                        return i3 - i4;
                    }
                    i2 += i5;
                }
            } else {
                c();
                throw null;
            }
        }
    }
}
