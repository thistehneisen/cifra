package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.b.a;
import com.fasterxml.jackson.core.b.b;
import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.core.i;
import com.fasterxml.jackson.core.j;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: UTF8JsonGenerator */
public class g extends c {
    static final byte[] n = a.a();
    private static final byte[] o = {110, 117, 108, 108};
    private static final byte[] p = {116, 114, 117, 101};
    private static final byte[] q = {102, 97, 108, 115, 101};
    protected final OutputStream r;
    protected byte[] s;
    protected int t = 0;
    protected final int u;
    protected final int v;
    protected char[] w;
    protected final int x;
    protected boolean y;
    protected boolean z;

    public g(c cVar, int i2, h hVar, OutputStream outputStream) {
        super(cVar, i2, hVar);
        this.r = outputStream;
        this.y = true;
        this.s = cVar.d();
        this.u = this.s.length;
        this.v = this.u >> 3;
        this.w = cVar.a();
        this.x = this.w.length;
        if (a(com.fasterxml.jackson.core.c.a.ESCAPE_NON_ASCII)) {
            b(127);
        }
        this.z = !com.fasterxml.jackson.core.c.a.QUOTE_FIELD_NAMES.b(i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r8 = a((int) r8, r7, r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if ((r6.t + 3) < r6.u) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r2 = r8 + 1;
        r8 = r7[r8];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r8 >= 2048) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r4 = r6.t;
        r6.t = r4 + 1;
        r1[r4] = (byte) ((r8 >> 6) | 192);
        r4 = r6.t;
        r6.t = r4 + 1;
        r1[r4] = (byte) ((r8 & '?') | 128);
        r8 = r2;
     */
    private final void d(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        int i4 = this.u;
        byte[] bArr = this.s;
        while (i2 < i3) {
            while (true) {
                char c2 = cArr[i2];
                if (c2 >= 128) {
                    break;
                }
                if (this.t >= i4) {
                    h();
                }
                int i5 = this.t;
                this.t = i5 + 1;
                bArr[i5] = (byte) c2;
                i2++;
                if (i2 >= i3) {
                    return;
                }
            }
        }
    }

    private final void i(long j2) throws IOException {
        if (this.t + 23 >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i2 = this.t;
        this.t = i2 + 1;
        bArr[i2] = 34;
        this.t = com.fasterxml.jackson.core.b.h.a(j2, bArr, this.t);
        byte[] bArr2 = this.s;
        int i3 = this.t;
        this.t = i3 + 1;
        bArr2[i3] = 34;
    }

    private final void j() throws IOException {
        if (this.t + 4 >= this.u) {
            h();
        }
        System.arraycopy(o, 0, this.s, this.t, 4);
        this.t += 4;
    }

    public void a(j jVar) throws IOException, JsonGenerationException {
        byte[] a2 = jVar.a();
        if (a2.length > 0) {
            a(a2);
        }
    }

    public final void b() throws IOException {
        if (this.f4163f.d()) {
            i iVar = this.f4249a;
            if (iVar != null) {
                iVar.b(this, this.f4163f.b());
            } else {
                if (this.t >= this.u) {
                    h();
                }
                byte[] bArr = this.s;
                int i2 = this.t;
                this.t = i2 + 1;
                bArr[i2] = 93;
            }
            this.f4163f = this.f4163f.i();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Current context not an ARRAY but ");
        sb.append(this.f4163f.c());
        b(sb.toString());
        throw null;
    }

    public void c(String str) throws IOException {
        if (this.f4249a != null) {
            h(str);
            return;
        }
        int a2 = this.f4163f.a(str);
        if (a2 != 4) {
            if (a2 == 1) {
                if (this.t >= this.u) {
                    h();
                }
                byte[] bArr = this.s;
                int i2 = this.t;
                this.t = i2 + 1;
                bArr[i2] = 44;
            }
            if (this.z) {
                b(str, false);
                return;
            }
            int length = str.length();
            if (length > this.x) {
                b(str, true);
                return;
            }
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr2 = this.s;
            int i3 = this.t;
            this.t = i3 + 1;
            bArr2[i3] = 34;
            str.getChars(0, length, this.w, 0);
            if (length <= this.v) {
                if (this.t + length > this.u) {
                    h();
                }
                e(this.w, 0, length);
            } else {
                h(this.w, 0, length);
            }
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr3 = this.s;
            int i4 = this.t;
            this.t = i4 + 1;
            bArr3[i4] = 34;
            return;
        }
        b("Can not write a field name, expecting a value");
        throw null;
    }

    public void close() throws IOException {
        super.close();
        if (this.s != null && a(com.fasterxml.jackson.core.c.a.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                e g2 = g();
                if (!g2.d()) {
                    if (!g2.e()) {
                        break;
                    }
                    c();
                } else {
                    b();
                }
            }
        }
        h();
        if (this.r != null) {
            if (this.f4275i.h() || a(com.fasterxml.jackson.core.c.a.AUTO_CLOSE_TARGET)) {
                this.r.close();
            } else if (a(com.fasterxml.jackson.core.c.a.FLUSH_PASSED_TO_STREAM)) {
                this.r.flush();
            }
        }
        i();
    }

    public final void e() throws IOException {
        g("start an array");
        this.f4163f = this.f4163f.g();
        i iVar = this.f4249a;
        if (iVar != null) {
            iVar.e(this);
            return;
        }
        if (this.t >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i2 = this.t;
        this.t = i2 + 1;
        bArr[i2] = 91;
    }

    public final void f() throws IOException {
        g("start an object");
        this.f4163f = this.f4163f.h();
        i iVar = this.f4249a;
        if (iVar != null) {
            iVar.a(this);
            return;
        }
        if (this.t >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i2 = this.t;
        this.t = i2 + 1;
        bArr[i2] = 123;
    }

    public void flush() throws IOException {
        h();
        if (this.r != null && a(com.fasterxml.jackson.core.c.a.FLUSH_PASSED_TO_STREAM)) {
            this.r.flush();
        }
    }

    /* access modifiers changed from: protected */
    public final void g(String str) throws IOException, JsonGenerationException {
        byte b2;
        int j2 = this.f4163f.j();
        if (j2 == 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not ");
            sb.append(str);
            sb.append(", expecting field name");
            b(sb.toString());
            throw null;
        } else if (this.f4249a == null) {
            if (j2 == 1) {
                b2 = 44;
            } else if (j2 == 2) {
                b2 = 58;
            } else if (j2 == 3) {
                j jVar = this.m;
                if (jVar != null) {
                    byte[] a2 = jVar.a();
                    if (a2.length > 0) {
                        a(a2);
                    }
                }
                return;
            } else {
                return;
            }
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr = this.s;
            int i2 = this.t;
            bArr[i2] = b2;
            this.t = i2 + 1;
        } else {
            b(str, j2);
        }
    }

    /* access modifiers changed from: protected */
    public final void h(String str) throws IOException {
        int a2 = this.f4163f.a(str);
        if (a2 != 4) {
            if (a2 == 1) {
                this.f4249a.g(this);
            } else {
                this.f4249a.d(this);
            }
            if (this.z) {
                b(str, false);
                return;
            }
            int length = str.length();
            if (length > this.x) {
                b(str, true);
                return;
            }
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr = this.s;
            int i2 = this.t;
            this.t = i2 + 1;
            bArr[i2] = 34;
            str.getChars(0, length, this.w, 0);
            if (length <= this.v) {
                if (this.t + length > this.u) {
                    h();
                }
                e(this.w, 0, length);
            } else {
                h(this.w, 0, length);
            }
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr2 = this.s;
            int i3 = this.t;
            this.t = i3 + 1;
            bArr2[i3] = 34;
            return;
        }
        b("Can not write a field name, expecting a value");
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        r0 = r6 + 1;
        r6 = r5[r6];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r6 >= 2048) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r1 = r4.s;
        r2 = r4.t;
        r4.t = r2 + 1;
        r1[r2] = (byte) ((r6 >> 6) | 192);
        r2 = r4.t;
        r4.t = r2 + 1;
        r1[r2] = (byte) ((r6 & '?') | 128);
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r6 = a((int) r6, r5, r0, r7);
     */
    public final void a(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        int i4 = i3 + i3 + i3;
        int i5 = this.t + i4;
        int i6 = this.u;
        if (i5 > i6) {
            if (i6 < i4) {
                d(cArr, i2, i3);
                return;
            }
            h();
        }
        int i7 = i3 + i2;
        loop0:
        while (i2 < i7) {
            while (true) {
                char c2 = cArr[i2];
                if (c2 <= 127) {
                    byte[] bArr = this.s;
                    int i8 = this.t;
                    this.t = i8 + 1;
                    bArr[i8] = (byte) c2;
                    i2++;
                    if (i2 >= i7) {
                        break loop0;
                    }
                } else {
                    break;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        byte[] bArr = this.s;
        if (bArr != null && this.y) {
            this.s = null;
            this.f4275i.b(bArr);
        }
        char[] cArr = this.w;
        if (cArr != null) {
            this.w = null;
            this.f4275i.a(cArr);
        }
    }

    public void e(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i2 = 0;
        while (length > 0) {
            char[] cArr = this.w;
            int length2 = cArr.length;
            if (length < length2) {
                length2 = length;
            }
            int i3 = i2 + length2;
            str.getChars(i2, i3, cArr, 0);
            a(cArr, 0, length2);
            length -= length2;
            i2 = i3;
        }
    }

    public void f(String str) throws IOException {
        g("write text value");
        if (str == null) {
            j();
            return;
        }
        int length = str.length();
        if (length > this.x) {
            b(str, true);
            return;
        }
        str.getChars(0, length, this.w, 0);
        if (length > this.v) {
            c(this.w, 0, length);
            return;
        }
        if (this.t + length >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i2 = this.t;
        this.t = i2 + 1;
        bArr[i2] = 34;
        e(this.w, 0, length);
        if (this.t >= this.u) {
            h();
        }
        byte[] bArr2 = this.s;
        int i3 = this.t;
        this.t = i3 + 1;
        bArr2[i3] = 34;
    }

    /* access modifiers changed from: protected */
    public final void b(String str, int i2) throws IOException, JsonGenerationException {
        if (i2 != 0) {
            if (i2 == 1) {
                this.f4249a.c(this);
            } else if (i2 == 2) {
                this.f4249a.h(this);
            } else if (i2 == 3) {
                this.f4249a.b(this);
            } else {
                a();
                throw null;
            }
        } else if (this.f4163f.d()) {
            this.f4249a.f(this);
        } else if (this.f4163f.e()) {
            this.f4249a.d(this);
        }
    }

    private final void e(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        int i4 = i3 + i2;
        int i5 = this.t;
        byte[] bArr = this.s;
        int[] iArr = this.f4276j;
        while (i2 < i4) {
            char c2 = cArr[i2];
            if (c2 > 127 || iArr[c2] != 0) {
                break;
            }
            int i6 = i5 + 1;
            bArr[i5] = (byte) c2;
            i2++;
            i5 = i6;
        }
        this.t = i5;
        if (i2 >= i4) {
            return;
        }
        if (this.f4278l != null) {
            b(cArr, i2, i4);
        } else if (this.f4277k == 0) {
            f(cArr, i2, i4);
        } else {
            g(cArr, i2, i4);
        }
    }

    private final void g(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        if (this.t + ((i3 - i2) * 6) > this.u) {
            h();
        }
        int i4 = this.t;
        byte[] bArr = this.s;
        int[] iArr = this.f4276j;
        int i5 = this.f4277k;
        while (i2 < i3) {
            int i6 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    int i7 = i4 + 1;
                    bArr[i4] = (byte) c2;
                    i2 = i6;
                    i4 = i7;
                } else {
                    int i8 = iArr[c2];
                    if (i8 > 0) {
                        int i9 = i4 + 1;
                        bArr[i4] = 92;
                        i4 = i9 + 1;
                        bArr[i9] = (byte) i8;
                    } else {
                        i4 = d(c2, i4);
                    }
                }
            } else if (c2 > i5) {
                i4 = d(c2, i4);
            } else if (c2 <= 2047) {
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((c2 >> 6) | 192);
                i4 = i10 + 1;
                bArr[i10] = (byte) ((c2 & '?') | 128);
            } else {
                i4 = c(c2, i4);
            }
            i2 = i6;
        }
        this.t = i4;
    }

    public void a(char c2) throws IOException, JsonGenerationException {
        if (this.t + 3 >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        if (c2 <= 127) {
            int i2 = this.t;
            this.t = i2 + 1;
            bArr[i2] = (byte) c2;
        } else if (c2 < 2048) {
            int i3 = this.t;
            this.t = i3 + 1;
            bArr[i3] = (byte) ((c2 >> 6) | 192);
            int i4 = this.t;
            this.t = i4 + 1;
            bArr[i4] = (byte) ((c2 & '?') | 128);
        } else {
            a((int) c2, (char[]) null, 0, 0);
        }
    }

    public void d() throws IOException, JsonGenerationException {
        g("write null value");
        j();
    }

    private int d(int i2, int i3) throws IOException {
        int i4;
        byte[] bArr = this.s;
        int i5 = i3 + 1;
        bArr[i3] = 92;
        int i6 = i5 + 1;
        bArr[i5] = 117;
        if (i2 > 255) {
            int i7 = 255 & (i2 >> 8);
            int i8 = i6 + 1;
            byte[] bArr2 = n;
            bArr[i6] = bArr2[i7 >> 4];
            i4 = i8 + 1;
            bArr[i8] = bArr2[i7 & 15];
            i2 &= 255;
        } else {
            int i9 = i6 + 1;
            bArr[i6] = 48;
            i4 = i9 + 1;
            bArr[i9] = 48;
        }
        int i10 = i4 + 1;
        byte[] bArr3 = n;
        bArr[i4] = bArr3[i2 >> 4];
        int i11 = i10 + 1;
        bArr[i10] = bArr3[i2 & 15];
        return i11;
    }

    private final void b(String str, boolean z2) throws IOException {
        if (z2) {
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr = this.s;
            int i2 = this.t;
            this.t = i2 + 1;
            bArr[i2] = 34;
        }
        int length = str.length();
        char[] cArr = this.w;
        int i3 = 0;
        while (length > 0) {
            int min = Math.min(this.v, length);
            int i4 = i3 + min;
            str.getChars(i3, i4, cArr, 0);
            if (this.t + min > this.u) {
                h();
            }
            e(cArr, 0, min);
            length -= min;
            i3 = i4;
        }
        if (z2) {
            if (this.t >= this.u) {
                h();
            }
            byte[] bArr2 = this.s;
            int i5 = this.t;
            this.t = i5 + 1;
            bArr2[i5] = 34;
        }
    }

    public void a(int i2) throws IOException, JsonGenerationException {
        g("write number");
        if (this.t + 11 >= this.u) {
            h();
        }
        if (this.f4162e) {
            c(i2);
        } else {
            this.t = com.fasterxml.jackson.core.b.h.a(i2, this.s, this.t);
        }
    }

    public void h(long j2) throws IOException, JsonGenerationException {
        g("write number");
        if (this.f4162e) {
            i(j2);
            return;
        }
        if (this.t + 21 >= this.u) {
            h();
        }
        this.t = com.fasterxml.jackson.core.b.h.a(j2, this.s, this.t);
    }

    private final void f(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        if (this.t + ((i3 - i2) * 6) > this.u) {
            h();
        }
        int i4 = this.t;
        byte[] bArr = this.s;
        int[] iArr = this.f4276j;
        while (i2 < i3) {
            int i5 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    int i6 = i4 + 1;
                    bArr[i4] = (byte) c2;
                    i2 = i5;
                    i4 = i6;
                } else {
                    int i7 = iArr[c2];
                    if (i7 > 0) {
                        int i8 = i4 + 1;
                        bArr[i4] = 92;
                        i4 = i8 + 1;
                        bArr[i8] = (byte) i7;
                    } else {
                        i4 = d(c2, i4);
                    }
                }
            } else if (c2 <= 2047) {
                int i9 = i4 + 1;
                bArr[i4] = (byte) ((c2 >> 6) | 192);
                i4 = i9 + 1;
                bArr[i9] = (byte) ((c2 & '?') | 128);
            } else {
                i4 = c(c2, i4);
            }
            i2 = i5;
        }
        this.t = i4;
    }

    public final void c() throws IOException {
        if (this.f4163f.e()) {
            i iVar = this.f4249a;
            if (iVar != null) {
                iVar.a(this, this.f4163f.b());
            } else {
                if (this.t >= this.u) {
                    h();
                }
                byte[] bArr = this.s;
                int i2 = this.t;
                this.t = i2 + 1;
                bArr[i2] = 125;
            }
            this.f4163f = this.f4163f.i();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Current context not an object but ");
        sb.append(this.f4163f.c());
        b(sb.toString());
        throw null;
    }

    public void a(double d2) throws IOException, JsonGenerationException {
        if (this.f4162e || ((Double.isNaN(d2) || Double.isInfinite(d2)) && a(com.fasterxml.jackson.core.c.a.QUOTE_NON_NUMERIC_NUMBERS))) {
            f(String.valueOf(d2));
            return;
        }
        g("write number");
        e(String.valueOf(d2));
    }

    private final void h(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        do {
            int min = Math.min(this.v, i3);
            if (this.t + min > this.u) {
                h();
            }
            e(cArr, i2, min);
            i2 += min;
            i3 -= min;
        } while (i3 > 0);
    }

    private final void b(char[] cArr, int i2, int i3) throws IOException, JsonGenerationException {
        if (this.t + ((i3 - i2) * 6) > this.u) {
            h();
        }
        int i4 = this.t;
        byte[] bArr = this.s;
        int[] iArr = this.f4276j;
        int i5 = this.f4277k;
        if (i5 <= 0) {
            i5 = 65535;
        }
        b bVar = this.f4278l;
        while (i2 < i3) {
            int i6 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 <= 127) {
                if (iArr[c2] == 0) {
                    int i7 = i4 + 1;
                    bArr[i4] = (byte) c2;
                    i2 = i6;
                    i4 = i7;
                } else {
                    int i8 = iArr[c2];
                    if (i8 > 0) {
                        int i9 = i4 + 1;
                        bArr[i4] = 92;
                        i4 = i9 + 1;
                        bArr[i9] = (byte) i8;
                    } else if (i8 == -2) {
                        j a2 = bVar.a(c2);
                        if (a2 != null) {
                            i4 = a(bArr, i4, a2, i3 - i6);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid custom escape definitions; custom escape not found for character code 0x");
                            sb.append(Integer.toHexString(c2));
                            sb.append(", although was supposed to have one");
                            b(sb.toString());
                            throw null;
                        }
                    } else {
                        i4 = d(c2, i4);
                    }
                }
            } else if (c2 > i5) {
                i4 = d(c2, i4);
            } else {
                j a3 = bVar.a(c2);
                if (a3 != null) {
                    i4 = a(bArr, i4, a3, i3 - i6);
                } else if (c2 <= 2047) {
                    int i10 = i4 + 1;
                    bArr[i4] = (byte) ((c2 >> 6) | 192);
                    i4 = i10 + 1;
                    bArr[i10] = (byte) ((c2 & '?') | 128);
                } else {
                    i4 = c(c2, i4);
                }
            }
            i2 = i6;
        }
        this.t = i4;
    }

    public void a(float f2) throws IOException, JsonGenerationException {
        if (this.f4162e || ((Float.isNaN(f2) || Float.isInfinite(f2)) && a(com.fasterxml.jackson.core.c.a.QUOTE_NON_NUMERIC_NUMBERS))) {
            f(String.valueOf(f2));
            return;
        }
        g("write number");
        e(String.valueOf(f2));
    }

    /* access modifiers changed from: protected */
    public final void h() throws IOException {
        int i2 = this.t;
        if (i2 > 0) {
            this.t = 0;
            this.r.write(this.s, 0, i2);
        }
    }

    private void c(char[] cArr, int i2, int i3) throws IOException {
        if (this.t >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i4 = this.t;
        this.t = i4 + 1;
        bArr[i4] = 34;
        h(this.w, 0, i3);
        if (this.t >= this.u) {
            h();
        }
        byte[] bArr2 = this.s;
        int i5 = this.t;
        this.t = i5 + 1;
        bArr2[i5] = 34;
    }

    public void a(boolean z2) throws IOException, JsonGenerationException {
        g("write boolean value");
        if (this.t + 5 >= this.u) {
            h();
        }
        byte[] bArr = z2 ? p : q;
        int length = bArr.length;
        System.arraycopy(bArr, 0, this.s, this.t, length);
        this.t += length;
    }

    private final void c(int i2) throws IOException {
        if (this.t + 13 >= this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i3 = this.t;
        this.t = i3 + 1;
        bArr[i3] = 34;
        this.t = com.fasterxml.jackson.core.b.h.a(i2, bArr, this.t);
        byte[] bArr2 = this.s;
        int i4 = this.t;
        this.t = i4 + 1;
        bArr2[i4] = 34;
    }

    private final void a(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.t + length > this.u) {
            h();
            if (length > 512) {
                this.r.write(bArr, 0, length);
                return;
            }
        }
        System.arraycopy(bArr, 0, this.s, this.t, length);
        this.t += length;
    }

    private final int c(int i2, int i3) throws IOException {
        byte[] bArr = this.s;
        if (i2 < 55296 || i2 > 57343) {
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 12) | 224);
            int i5 = i4 + 1;
            bArr[i4] = (byte) (((i2 >> 6) & 63) | 128);
            int i6 = i5 + 1;
            bArr[i5] = (byte) ((i2 & 63) | 128);
            return i6;
        }
        int i7 = i3 + 1;
        bArr[i3] = 92;
        int i8 = i7 + 1;
        bArr[i7] = 117;
        int i9 = i8 + 1;
        byte[] bArr2 = n;
        bArr[i8] = bArr2[(i2 >> 12) & 15];
        int i10 = i9 + 1;
        bArr[i9] = bArr2[(i2 >> 8) & 15];
        int i11 = i10 + 1;
        bArr[i10] = bArr2[(i2 >> 4) & 15];
        int i12 = i11 + 1;
        bArr[i11] = bArr2[i2 & 15];
        return i12;
    }

    private final int a(byte[] bArr, int i2, j jVar, int i3) throws IOException, JsonGenerationException {
        byte[] a2 = jVar.a();
        int length = a2.length;
        if (length > 6) {
            return a(bArr, i2, this.u, a2, i3);
        }
        System.arraycopy(a2, 0, bArr, i2, length);
        return i2 + length;
    }

    private final int a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws IOException, JsonGenerationException {
        int length = bArr2.length;
        if (i2 + length > i3) {
            this.t = i2;
            h();
            int i5 = this.t;
            if (length > bArr.length) {
                this.r.write(bArr2, 0, length);
                return i5;
            }
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i2 = i5 + length;
        }
        if ((i4 * 6) + i2 <= i3) {
            return i2;
        }
        h();
        return this.t;
    }

    /* access modifiers changed from: protected */
    public final void b(int i2, int i3) throws IOException {
        int a2 = a(i2, i3);
        if (this.t + 4 > this.u) {
            h();
        }
        byte[] bArr = this.s;
        int i4 = this.t;
        this.t = i4 + 1;
        bArr[i4] = (byte) ((a2 >> 18) | 240);
        int i5 = this.t;
        this.t = i5 + 1;
        bArr[i5] = (byte) (((a2 >> 12) & 63) | 128);
        int i6 = this.t;
        this.t = i6 + 1;
        bArr[i6] = (byte) (((a2 >> 6) & 63) | 128);
        int i7 = this.t;
        this.t = i7 + 1;
        bArr[i7] = (byte) ((a2 & 63) | 128);
    }

    private final int a(int i2, char[] cArr, int i3, int i4) throws IOException {
        if (i2 < 55296 || i2 > 57343) {
            byte[] bArr = this.s;
            int i5 = this.t;
            this.t = i5 + 1;
            bArr[i5] = (byte) ((i2 >> 12) | 224);
            int i6 = this.t;
            this.t = i6 + 1;
            bArr[i6] = (byte) (((i2 >> 6) & 63) | 128);
            int i7 = this.t;
            this.t = i7 + 1;
            bArr[i7] = (byte) ((i2 & 63) | 128);
            return i3;
        } else if (i3 >= i4 || cArr == null) {
            b("Split surrogate on writeRaw() input (last character)");
            throw null;
        } else {
            b(i2, (int) cArr[i3]);
            return i3 + 1;
        }
    }
}
