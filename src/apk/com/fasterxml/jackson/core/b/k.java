package com.fasterxml.jackson.core.b;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* compiled from: UTF32Reader */
public class k extends Reader {

    /* renamed from: a reason: collision with root package name */
    protected final c f4232a;

    /* renamed from: b reason: collision with root package name */
    protected InputStream f4233b;

    /* renamed from: c reason: collision with root package name */
    protected byte[] f4234c;

    /* renamed from: d reason: collision with root package name */
    protected int f4235d;

    /* renamed from: e reason: collision with root package name */
    protected int f4236e;

    /* renamed from: f reason: collision with root package name */
    protected final boolean f4237f;

    /* renamed from: g reason: collision with root package name */
    protected char f4238g = 0;

    /* renamed from: h reason: collision with root package name */
    protected int f4239h = 0;

    /* renamed from: i reason: collision with root package name */
    protected int f4240i = 0;

    /* renamed from: j reason: collision with root package name */
    protected final boolean f4241j;

    /* renamed from: k reason: collision with root package name */
    protected char[] f4242k = null;

    public k(c cVar, InputStream inputStream, byte[] bArr, int i2, int i3, boolean z) {
        boolean z2 = false;
        this.f4232a = cVar;
        this.f4233b = inputStream;
        this.f4234c = bArr;
        this.f4235d = i2;
        this.f4236e = i3;
        this.f4237f = z;
        if (inputStream != null) {
            z2 = true;
        }
        this.f4241j = z2;
    }

    private void a(int i2, int i3) throws IOException {
        int i4 = this.f4240i + i2;
        int i5 = this.f4239h;
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected EOF in the middle of a 4-byte UTF-32 char: got ");
        sb.append(i2);
        sb.append(", needed ");
        sb.append(i3);
        sb.append(", at char #");
        sb.append(i5);
        sb.append(", byte #");
        sb.append(i4);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private void b() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    public void close() throws IOException {
        InputStream inputStream = this.f4233b;
        if (inputStream != null) {
            this.f4233b = null;
            a();
            inputStream.close();
        }
    }

    public int read() throws IOException {
        if (this.f4242k == null) {
            this.f4242k = new char[1];
        }
        if (read(this.f4242k, 0, 1) < 1) {
            return -1;
        }
        return this.f4242k[0];
    }

    private void a(int i2, int i3, String str) throws IOException {
        int i4 = (this.f4240i + this.f4235d) - 1;
        int i5 = this.f4239h + i3;
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-32 character 0x");
        sb.append(Integer.toHexString(i2));
        sb.append(str);
        sb.append(" at char #");
        sb.append(i5);
        sb.append(", byte #");
        sb.append(i4);
        sb.append(")");
        throw new CharConversionException(sb.toString());
    }

    private boolean a(int i2) throws IOException {
        int i3;
        this.f4240i += this.f4236e - i2;
        if (i2 > 0) {
            int i4 = this.f4235d;
            if (i4 > 0) {
                byte[] bArr = this.f4234c;
                System.arraycopy(bArr, i4, bArr, 0, i2);
                this.f4235d = 0;
            }
            this.f4236e = i2;
        } else {
            this.f4235d = 0;
            InputStream inputStream = this.f4233b;
            int read = inputStream == null ? -1 : inputStream.read(this.f4234c);
            if (read < 1) {
                this.f4236e = 0;
                if (read < 0) {
                    if (this.f4241j) {
                        a();
                    }
                    return false;
                }
                b();
                throw null;
            }
            this.f4236e = read;
        }
        while (true) {
            int i5 = this.f4236e;
            if (i5 >= 4) {
                return true;
            }
            InputStream inputStream2 = this.f4233b;
            if (inputStream2 == null) {
                i3 = -1;
            } else {
                byte[] bArr2 = this.f4234c;
                i3 = inputStream2.read(bArr2, i5, bArr2.length - i5);
            }
            if (i3 >= 1) {
                this.f4236e += i3;
            } else if (i3 < 0) {
                if (this.f4241j) {
                    a();
                }
                a(this.f4236e, 4);
                throw null;
            } else {
                b();
                throw null;
            }
        }
    }

    public int read(char[] cArr, int i2, int i3) throws IOException {
        int i4;
        int i5;
        byte b2;
        int i6;
        if (this.f4234c == null) {
            return -1;
        }
        if (i3 < 1) {
            return i3;
        }
        if (i2 < 0 || i2 + i3 > cArr.length) {
            a(cArr, i2, i3);
            throw null;
        }
        int i7 = i3 + i2;
        char c2 = this.f4238g;
        if (c2 != 0) {
            i4 = i2 + 1;
            cArr[i2] = c2;
            this.f4238g = 0;
        } else {
            int i8 = this.f4236e - this.f4235d;
            if (i8 < 4 && !a(i8)) {
                return -1;
            }
            i4 = i2;
        }
        while (true) {
            if (i4 >= i7) {
                i5 = i4;
                break;
            }
            int i9 = this.f4235d;
            if (this.f4237f) {
                byte[] bArr = this.f4234c;
                b2 = (bArr[i9] << 24) | ((bArr[i9 + 1] & 255) << 16) | ((bArr[i9 + 2] & 255) << 8);
                i6 = bArr[i9 + 3] & 255;
            } else {
                byte[] bArr2 = this.f4234c;
                b2 = (bArr2[i9] & 255) | ((bArr2[i9 + 1] & 255) << 8) | ((bArr2[i9 + 2] & 255) << 16);
                i6 = bArr2[i9 + 3] << 24;
            }
            byte b3 = i6 | b2;
            this.f4235d += 4;
            if (b3 > 65535) {
                if (b3 <= 1114111) {
                    int i10 = b3 - 65536;
                    i5 = i4 + 1;
                    cArr[i4] = (char) ((i10 >> 10) + 55296);
                    b3 = (i10 & 1023) | 56320;
                    if (i5 >= i7) {
                        this.f4238g = (char) b3;
                        break;
                    }
                    i4 = i5;
                } else {
                    int i11 = i4 - i2;
                    StringBuilder sb = new StringBuilder();
                    sb.append("(above ");
                    sb.append(Integer.toHexString(1114111));
                    sb.append(") ");
                    a((int) b3, i11, sb.toString());
                    throw null;
                }
            }
            i5 = i4 + 1;
            cArr[i4] = (char) b3;
            if (this.f4235d >= this.f4236e) {
                break;
            }
            i4 = i5;
        }
        int i12 = i5 - i2;
        this.f4239h += i12;
        return i12;
    }

    private void a() {
        byte[] bArr = this.f4234c;
        if (bArr != null) {
            this.f4234c = null;
            this.f4232a.a(bArr);
        }
    }

    private void a(char[] cArr, int i2, int i3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("read(buf,");
        sb.append(i2);
        sb.append(",");
        sb.append(i3);
        sb.append("), cbuf[");
        sb.append(cArr.length);
        sb.append("]");
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }
}
