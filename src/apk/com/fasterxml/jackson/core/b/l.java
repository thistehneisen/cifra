package com.fasterxml.jackson.core.b;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/* compiled from: UTF8Writer */
public final class l extends Writer {

    /* renamed from: a reason: collision with root package name */
    private final c f4243a;

    /* renamed from: b reason: collision with root package name */
    private OutputStream f4244b;

    /* renamed from: c reason: collision with root package name */
    private byte[] f4245c;

    /* renamed from: d reason: collision with root package name */
    private final int f4246d;

    /* renamed from: e reason: collision with root package name */
    private int f4247e;

    /* renamed from: f reason: collision with root package name */
    private int f4248f = 0;

    public l(c cVar, OutputStream outputStream) {
        this.f4243a = cVar;
        this.f4244b = outputStream;
        this.f4245c = cVar.d();
        this.f4246d = this.f4245c.length - 4;
        this.f4247e = 0;
    }

    protected static void b(int i2) throws IOException {
        throw new IOException(c(i2));
    }

    protected static String c(int i2) {
        String str = "Illegal character point (0x";
        if (i2 > 1114111) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(Integer.toHexString(i2));
            sb.append(") to output; max is 0x10FFFF as per RFC 4627");
            return sb.toString();
        } else if (i2 >= 55296) {
            String str2 = ")";
            if (i2 <= 56319) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unmatched first part of surrogate pair (0x");
                sb2.append(Integer.toHexString(i2));
                sb2.append(str2);
                return sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unmatched second part of surrogate pair (0x");
            sb3.append(Integer.toHexString(i2));
            sb3.append(str2);
            return sb3.toString();
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(Integer.toHexString(i2));
            sb4.append(") to output");
            return sb4.toString();
        }
    }

    /* access modifiers changed from: protected */
    public int a(int i2) throws IOException {
        int i3 = this.f4248f;
        this.f4248f = 0;
        if (i2 >= 56320 && i2 <= 57343) {
            return ((i3 - 55296) << 10) + 65536 + (i2 - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Broken surrogate pair: first char 0x");
        sb.append(Integer.toHexString(i3));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(i2));
        sb.append("; illegal combination");
        throw new IOException(sb.toString());
    }

    public void close() throws IOException {
        OutputStream outputStream = this.f4244b;
        if (outputStream != null) {
            int i2 = this.f4247e;
            if (i2 > 0) {
                outputStream.write(this.f4245c, 0, i2);
                this.f4247e = 0;
            }
            OutputStream outputStream2 = this.f4244b;
            this.f4244b = null;
            byte[] bArr = this.f4245c;
            if (bArr != null) {
                this.f4245c = null;
                this.f4243a.b(bArr);
            }
            outputStream2.close();
            int i3 = this.f4248f;
            this.f4248f = 0;
            if (i3 > 0) {
                b(i3);
                throw null;
            }
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this.f4244b;
        if (outputStream != null) {
            int i2 = this.f4247e;
            if (i2 > 0) {
                outputStream.write(this.f4245c, 0, i2);
                this.f4247e = 0;
            }
            this.f4244b.flush();
        }
    }

    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    public Writer append(char c2) throws IOException {
        write((int) c2);
        return this;
    }

    public void write(char[] cArr, int i2, int i3) throws IOException {
        if (i3 < 2) {
            if (i3 == 1) {
                write((int) cArr[i2]);
            }
            return;
        }
        if (this.f4248f > 0) {
            int i4 = i2 + 1;
            i3--;
            write(a(cArr[i2]));
            i2 = i4;
        }
        int i5 = this.f4247e;
        byte[] bArr = this.f4245c;
        int i6 = this.f4246d;
        int i7 = i3 + r9;
        while (r9 < i7) {
            if (i5 >= i6) {
                this.f4244b.write(bArr, 0, i5);
                i5 = 0;
            }
            int i8 = r9 + 1;
            char c2 = cArr[r9];
            if (c2 < 128) {
                int i9 = i5 + 1;
                bArr[i5] = (byte) c2;
                int i10 = i7 - i8;
                int i11 = i6 - i9;
                if (i10 > i11) {
                    i10 = i11;
                }
                int i12 = i10 + i8;
                while (true) {
                    r9 = i8;
                    i5 = i9;
                    if (r9 >= i12) {
                        continue;
                        break;
                    }
                    i8 = r9 + 1;
                    c2 = cArr[r9];
                    if (c2 >= 128) {
                        break;
                    }
                    i9 = i5 + 1;
                    bArr[i5] = (byte) c2;
                }
            }
            if (c2 < 2048) {
                int i13 = i5 + 1;
                bArr[i5] = (byte) ((c2 >> 6) | 192);
                i5 = i13 + 1;
                bArr[i13] = (byte) ((c2 & '?') | 128);
                r9 = i8;
            } else if (c2 < 55296 || c2 > 57343) {
                int i14 = i5 + 1;
                bArr[i5] = (byte) ((c2 >> 12) | 224);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((c2 >> 6) & 63) | 128);
                int i16 = i15 + 1;
                bArr[i15] = (byte) ((c2 & '?') | 128);
                r9 = i8;
                i5 = i16;
            } else if (c2 <= 56319) {
                this.f4248f = c2;
                if (i8 >= i7) {
                    break;
                }
                r9 = i8 + 1;
                int a2 = a(cArr[i8]);
                if (a2 <= 1114111) {
                    int i17 = i5 + 1;
                    bArr[i5] = (byte) ((a2 >> 18) | 240);
                    int i18 = i17 + 1;
                    bArr[i17] = (byte) (((a2 >> 12) & 63) | 128);
                    int i19 = i18 + 1;
                    bArr[i18] = (byte) (((a2 >> 6) & 63) | 128);
                    i5 = i19 + 1;
                    bArr[i19] = (byte) ((a2 & 63) | 128);
                } else {
                    this.f4247e = i5;
                    b(a2);
                    throw null;
                }
            } else {
                this.f4247e = i5;
                b(c2);
                throw null;
            }
        }
        this.f4247e = i5;
    }

    public void write(int i2) throws IOException {
        int i3;
        if (this.f4248f > 0) {
            i2 = a(i2);
        } else if (i2 >= 55296 && i2 <= 57343) {
            if (i2 <= 56319) {
                this.f4248f = i2;
                return;
            } else {
                b(i2);
                throw null;
            }
        }
        int i4 = this.f4247e;
        if (i4 >= this.f4246d) {
            this.f4244b.write(this.f4245c, 0, i4);
            this.f4247e = 0;
        }
        if (i2 < 128) {
            byte[] bArr = this.f4245c;
            int i5 = this.f4247e;
            this.f4247e = i5 + 1;
            bArr[i5] = (byte) i2;
        } else {
            int i6 = this.f4247e;
            if (i2 < 2048) {
                byte[] bArr2 = this.f4245c;
                int i7 = i6 + 1;
                bArr2[i6] = (byte) ((i2 >> 6) | 192);
                i3 = i7 + 1;
                bArr2[i7] = (byte) ((i2 & 63) | 128);
            } else if (i2 <= 65535) {
                byte[] bArr3 = this.f4245c;
                int i8 = i6 + 1;
                bArr3[i6] = (byte) ((i2 >> 12) | 224);
                int i9 = i8 + 1;
                bArr3[i8] = (byte) (((i2 >> 6) & 63) | 128);
                int i10 = i9 + 1;
                bArr3[i9] = (byte) ((i2 & 63) | 128);
                i3 = i10;
            } else if (i2 <= 1114111) {
                byte[] bArr4 = this.f4245c;
                int i11 = i6 + 1;
                bArr4[i6] = (byte) ((i2 >> 18) | 240);
                int i12 = i11 + 1;
                bArr4[i11] = (byte) (((i2 >> 12) & 63) | 128);
                int i13 = i12 + 1;
                bArr4[i12] = (byte) (((i2 >> 6) & 63) | 128);
                i3 = i13 + 1;
                bArr4[i13] = (byte) ((i2 & 63) | 128);
            } else {
                b(i2);
                throw null;
            }
            this.f4247e = i3;
        }
    }

    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    public void write(String str, int i2, int i3) throws IOException {
        if (i3 < 2) {
            if (i3 == 1) {
                write((int) str.charAt(i2));
            }
            return;
        }
        if (this.f4248f > 0) {
            int i4 = i2 + 1;
            i3--;
            write(a(str.charAt(i2)));
            i2 = i4;
        }
        int i5 = this.f4247e;
        byte[] bArr = this.f4245c;
        int i6 = this.f4246d;
        int i7 = i3 + r9;
        while (r9 < i7) {
            if (i5 >= i6) {
                this.f4244b.write(bArr, 0, i5);
                i5 = 0;
            }
            int i8 = r9 + 1;
            char charAt = str.charAt(r9);
            if (charAt < 128) {
                int i9 = i5 + 1;
                bArr[i5] = (byte) charAt;
                int i10 = i7 - i8;
                int i11 = i6 - i9;
                if (i10 > i11) {
                    i10 = i11;
                }
                int i12 = i10 + i8;
                while (true) {
                    r9 = i8;
                    i5 = i9;
                    if (r9 >= i12) {
                        continue;
                        break;
                    }
                    i8 = r9 + 1;
                    charAt = str.charAt(r9);
                    if (charAt >= 128) {
                        break;
                    }
                    i9 = i5 + 1;
                    bArr[i5] = (byte) charAt;
                }
            }
            if (charAt < 2048) {
                int i13 = i5 + 1;
                bArr[i5] = (byte) ((charAt >> 6) | 192);
                i5 = i13 + 1;
                bArr[i13] = (byte) ((charAt & '?') | 128);
                r9 = i8;
            } else if (charAt < 55296 || charAt > 57343) {
                int i14 = i5 + 1;
                bArr[i5] = (byte) ((charAt >> 12) | 224);
                int i15 = i14 + 1;
                bArr[i14] = (byte) (((charAt >> 6) & 63) | 128);
                int i16 = i15 + 1;
                bArr[i15] = (byte) ((charAt & '?') | 128);
                r9 = i8;
                i5 = i16;
            } else if (charAt <= 56319) {
                this.f4248f = charAt;
                if (i8 >= i7) {
                    break;
                }
                r9 = i8 + 1;
                int a2 = a(str.charAt(i8));
                if (a2 <= 1114111) {
                    int i17 = i5 + 1;
                    bArr[i5] = (byte) ((a2 >> 18) | 240);
                    int i18 = i17 + 1;
                    bArr[i17] = (byte) (((a2 >> 12) & 63) | 128);
                    int i19 = i18 + 1;
                    bArr[i18] = (byte) (((a2 >> 6) & 63) | 128);
                    i5 = i19 + 1;
                    bArr[i19] = (byte) ((a2 & 63) | 128);
                } else {
                    this.f4247e = i5;
                    b(a2);
                    throw null;
                }
            } else {
                this.f4247e = i5;
                b(charAt);
                throw null;
            }
        }
        this.f4247e = i5;
    }
}
