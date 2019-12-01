package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.b.a;
import com.fasterxml.jackson.core.b.b;
import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.core.j;
import java.io.IOException;
import java.io.Writer;

/* compiled from: WriterBasedJsonGenerator */
public final class i extends c {
    protected static final char[] n = a.b();
    protected final Writer o;
    protected char[] p;
    protected int q = 0;
    protected int r = 0;
    protected int s;
    protected char[] t;
    protected j u;

    public i(c cVar, int i2, h hVar, Writer writer) {
        super(cVar, i2, hVar);
        this.o = writer;
        this.p = cVar.a();
        this.s = this.p.length;
    }

    private void i(long j2) throws IOException {
        if (this.r + 23 >= this.s) {
            h();
        }
        char[] cArr = this.p;
        int i2 = this.r;
        this.r = i2 + 1;
        cArr[i2] = '\"';
        this.r = com.fasterxml.jackson.core.b.h.a(j2, cArr, this.r);
        char[] cArr2 = this.p;
        int i3 = this.r;
        this.r = i3 + 1;
        cArr2[i3] = '\"';
    }

    private void j(String str) throws IOException {
        int length = str.length();
        int i2 = this.s;
        if (length > i2) {
            i(str);
            return;
        }
        if (this.r + length > i2) {
            h();
        }
        str.getChars(0, length, this.p, this.r);
        if (this.f4278l != null) {
            g(length);
        } else {
            int i3 = this.f4277k;
            if (i3 != 0) {
                c(length, i3);
            } else {
                f(length);
            }
        }
    }

    private void k(String str) throws IOException {
        int i2 = this.s;
        int i3 = this.r;
        int i4 = i2 - i3;
        str.getChars(0, i4, this.p, i3);
        this.r += i4;
        h();
        int length = str.length() - i4;
        while (true) {
            int i5 = this.s;
            if (length > i5) {
                int i6 = i4 + i5;
                str.getChars(i4, i6, this.p, 0);
                this.q = 0;
                this.r = i5;
                h();
                length -= i5;
                i4 = i6;
            } else {
                str.getChars(i4, i4 + length, this.p, 0);
                this.q = 0;
                this.r = length;
                return;
            }
        }
    }

    public void a(j jVar) throws IOException {
        e(jVar.getValue());
    }

    public void b() throws IOException, JsonGenerationException {
        if (this.f4163f.d()) {
            com.fasterxml.jackson.core.i iVar = this.f4249a;
            if (iVar != null) {
                iVar.b(this, this.f4163f.b());
            } else {
                if (this.r >= this.s) {
                    h();
                }
                char[] cArr = this.p;
                int i2 = this.r;
                this.r = i2 + 1;
                cArr[i2] = ']';
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
        int a2 = this.f4163f.a(str);
        if (a2 != 4) {
            boolean z = true;
            if (a2 != 1) {
                z = false;
            }
            b(str, z);
            return;
        }
        b("Can not write a field name, expecting a value");
        throw null;
    }

    public void close() throws IOException {
        super.close();
        if (this.p != null && a(com.fasterxml.jackson.core.c.a.AUTO_CLOSE_JSON_CONTENT)) {
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
        if (this.o != null) {
            if (this.f4275i.h() || a(com.fasterxml.jackson.core.c.a.AUTO_CLOSE_TARGET)) {
                this.o.close();
            } else if (a(com.fasterxml.jackson.core.c.a.FLUSH_PASSED_TO_STREAM)) {
                this.o.flush();
            }
        }
        i();
    }

    public void d() throws IOException {
        h("write null value");
        k();
    }

    public void e() throws IOException, JsonGenerationException {
        h("start an array");
        this.f4163f = this.f4163f.g();
        com.fasterxml.jackson.core.i iVar = this.f4249a;
        if (iVar != null) {
            iVar.e(this);
            return;
        }
        if (this.r >= this.s) {
            h();
        }
        char[] cArr = this.p;
        int i2 = this.r;
        this.r = i2 + 1;
        cArr[i2] = '[';
    }

    public void f() throws IOException, JsonGenerationException {
        h("start an object");
        this.f4163f = this.f4163f.h();
        com.fasterxml.jackson.core.i iVar = this.f4249a;
        if (iVar != null) {
            iVar.a(this);
            return;
        }
        if (this.r >= this.s) {
            h();
        }
        char[] cArr = this.p;
        int i2 = this.r;
        this.r = i2 + 1;
        cArr[i2] = '{';
    }

    public void flush() throws IOException {
        h();
        if (this.o != null && a(com.fasterxml.jackson.core.c.a.FLUSH_PASSED_TO_STREAM)) {
            this.o.flush();
        }
    }

    /* access modifiers changed from: protected */
    public void g(String str) throws IOException {
        int j2 = this.f4163f.j();
        if (j2 == 5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not ");
            sb.append(str);
            sb.append(", expecting field name");
            b(sb.toString());
            throw null;
        } else if (j2 != 0) {
            if (j2 == 1) {
                this.f4249a.c(this);
            } else if (j2 == 2) {
                this.f4249a.h(this);
            } else if (j2 == 3) {
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

    public void h(long j2) throws IOException {
        h("write number");
        if (this.f4162e) {
            i(j2);
            return;
        }
        if (this.r + 21 >= this.s) {
            h();
        }
        this.r = com.fasterxml.jackson.core.b.h.a(j2, this.p, this.r);
    }

    public void a(char[] cArr, int i2, int i3) throws IOException {
        if (i3 < 32) {
            if (i3 > this.s - this.r) {
                h();
            }
            System.arraycopy(cArr, i2, this.p, this.r, i3);
            this.r += i3;
            return;
        }
        h();
        this.o.write(cArr, i2, i3);
    }

    private void d(int i2) throws IOException {
        char c2;
        int[] iArr = this.f4276j;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            do {
                c2 = this.p[i3];
                if (c2 < length && iArr[c2] != 0) {
                    break;
                }
                i3++;
            } while (i3 < i2);
            int i5 = i3 - i4;
            if (i5 > 0) {
                this.o.write(this.p, i4, i5);
                if (i3 >= i2) {
                    return;
                }
            }
            i3++;
            i4 = a(this.p, i3, i2, c2, iArr[c2]);
        }
    }

    public void c() throws IOException, JsonGenerationException {
        if (this.f4163f.e()) {
            com.fasterxml.jackson.core.i iVar = this.f4249a;
            if (iVar != null) {
                iVar.a(this, this.f4163f.b());
            } else {
                if (this.r >= this.s) {
                    h();
                }
                char[] cArr = this.p;
                int i2 = this.r;
                this.r = i2 + 1;
                cArr[i2] = '}';
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

    /* access modifiers changed from: protected */
    public void i() {
        char[] cArr = this.p;
        if (cArr != null) {
            this.p = null;
            this.f4275i.a(cArr);
        }
    }

    /* access modifiers changed from: protected */
    public void h(String str) throws IOException {
        char c2;
        if (this.f4249a != null) {
            g(str);
            return;
        }
        int j2 = this.f4163f.j();
        if (j2 != 5) {
            if (j2 == 1) {
                c2 = ',';
            } else if (j2 == 2) {
                c2 = ':';
            } else if (j2 == 3) {
                j jVar = this.m;
                if (jVar != null) {
                    e(jVar.getValue());
                }
                return;
            } else {
                return;
            }
            if (this.r >= this.s) {
                h();
            }
            char[] cArr = this.p;
            int i2 = this.r;
            cArr[i2] = c2;
            this.r = i2 + 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can not ");
        sb.append(str);
        sb.append(", expecting field name");
        b(sb.toString());
        throw null;
    }

    public void a(char c2) throws IOException {
        if (this.r >= this.s) {
            h();
        }
        char[] cArr = this.p;
        int i2 = this.r;
        this.r = i2 + 1;
        cArr[i2] = c2;
    }

    public void e(String str) throws IOException {
        int length = str.length();
        int i2 = this.s - this.r;
        if (i2 == 0) {
            h();
            i2 = this.s - this.r;
        }
        if (i2 >= length) {
            str.getChars(0, length, this.p, this.r);
            this.r += length;
            return;
        }
        k(str);
    }

    public void f(String str) throws IOException {
        h("write text value");
        if (str == null) {
            k();
            return;
        }
        if (this.r >= this.s) {
            h();
        }
        char[] cArr = this.p;
        int i2 = this.r;
        this.r = i2 + 1;
        cArr[i2] = '\"';
        j(str);
        if (this.r >= this.s) {
            h();
        }
        char[] cArr2 = this.p;
        int i3 = this.r;
        this.r = i3 + 1;
        cArr2[i3] = '\"';
    }

    private void i(String str) throws IOException {
        h();
        int length = str.length();
        int i2 = 0;
        while (true) {
            int i3 = this.s;
            if (i2 + i3 > length) {
                i3 = length - i2;
            }
            int i4 = i2 + i3;
            str.getChars(i2, i4, this.p, 0);
            if (this.f4278l != null) {
                e(i3);
            } else {
                int i5 = this.f4277k;
                if (i5 != 0) {
                    b(i3, i5);
                } else {
                    d(i3);
                }
            }
            if (i4 < length) {
                i2 = i4;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str, boolean z) throws IOException {
        if (this.f4249a != null) {
            c(str, z);
            return;
        }
        if (this.r + 1 >= this.s) {
            h();
        }
        if (z) {
            char[] cArr = this.p;
            int i2 = this.r;
            this.r = i2 + 1;
            cArr[i2] = ',';
        }
        if (!a(com.fasterxml.jackson.core.c.a.QUOTE_FIELD_NAMES)) {
            j(str);
            return;
        }
        char[] cArr2 = this.p;
        int i3 = this.r;
        this.r = i3 + 1;
        cArr2[i3] = '\"';
        j(str);
        if (this.r >= this.s) {
            h();
        }
        char[] cArr3 = this.p;
        int i4 = this.r;
        this.r = i4 + 1;
        cArr3[i4] = '\"';
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A[SYNTHETIC] */
    private void g(int i2) throws IOException, JsonGenerationException {
        char c2;
        int i3;
        int i4;
        int i5 = this.r + i2;
        int[] iArr = this.f4276j;
        int i6 = this.f4277k;
        if (i6 < 1) {
            i6 = 65535;
        }
        int min = Math.min(iArr.length, i6 + 1);
        b bVar = this.f4278l;
        while (this.r < i5) {
            while (true) {
                c2 = this.p[this.r];
                if (c2 < min) {
                    i4 = iArr[c2];
                    if (i4 != 0) {
                        break;
                    }
                    i3 = this.r + 1;
                    this.r = i3;
                    if (i3 >= i5) {
                        return;
                    }
                } else if (c2 > i6) {
                    i4 = -1;
                    break;
                } else {
                    j a2 = bVar.a(c2);
                    this.u = a2;
                    if (a2 != null) {
                        i4 = -2;
                        break;
                    }
                    i3 = this.r + 1;
                    this.r = i3;
                    if (i3 >= i5) {
                    }
                }
            }
            int i7 = this.r;
            int i8 = this.q;
            int i9 = i7 - i8;
            if (i9 > 0) {
                this.o.write(this.p, i8, i9);
            }
            this.r++;
            a(c2, i4);
        }
    }

    public void a(int i2) throws IOException {
        h("write number");
        if (this.f4162e) {
            c(i2);
            return;
        }
        if (this.r + 11 >= this.s) {
            h();
        }
        this.r = com.fasterxml.jackson.core.b.h.a(i2, this.p, this.r);
    }

    private char[] j() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this.t = cArr;
        return cArr;
    }

    /* access modifiers changed from: protected */
    public void c(String str, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this.f4249a.g(this);
        } else {
            this.f4249a.d(this);
        }
        if (a(com.fasterxml.jackson.core.c.a.QUOTE_FIELD_NAMES)) {
            if (this.r >= this.s) {
                h();
            }
            char[] cArr = this.p;
            int i2 = this.r;
            this.r = i2 + 1;
            cArr[i2] = '\"';
            j(str);
            if (this.r >= this.s) {
                h();
            }
            char[] cArr2 = this.p;
            int i3 = this.r;
            this.r = i3 + 1;
            cArr2[i3] = '\"';
            return;
        }
        j(str);
    }

    private final void k() throws IOException {
        if (this.r + 4 >= this.s) {
            h();
        }
        int i2 = this.r;
        char[] cArr = this.p;
        cArr[i2] = 'n';
        int i3 = i2 + 1;
        cArr[i3] = 'u';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        int i5 = i4 + 1;
        cArr[i5] = 'l';
        this.r = i5 + 1;
    }

    private void e(int i2) throws IOException, JsonGenerationException {
        char c2;
        int[] iArr = this.f4276j;
        int i3 = this.f4277k;
        if (i3 < 1) {
            i3 = 65535;
        }
        int min = Math.min(iArr.length, i3 + 1);
        b bVar = this.f4278l;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i2) {
            while (true) {
                c2 = this.p[i4];
                if (c2 >= min) {
                    if (c2 <= i3) {
                        j a2 = bVar.a(c2);
                        this.u = a2;
                        if (a2 != null) {
                            i6 = -2;
                            break;
                        }
                    } else {
                        i6 = -1;
                        break;
                    }
                } else {
                    i6 = iArr[c2];
                    if (i6 != 0) {
                        break;
                    }
                }
                i4++;
                if (i4 >= i2) {
                    break;
                }
            }
            int i7 = i4 - i5;
            if (i7 > 0) {
                this.o.write(this.p, i5, i7);
                if (i4 >= i2) {
                    return;
                }
            }
            i4++;
            i5 = a(this.p, i4, i2, c2, i6);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r6.p;
        r3 = r6.r;
        r6.r = r3 + 1;
        r2 = r2[r3];
        a(r2, r7[r2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r4 = r6.q;
        r3 = r3 - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r3 <= 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r6.o.write(r2, r4, r3);
     */
    private void f(int i2) throws IOException {
        int i3 = this.r + i2;
        int[] iArr = this.f4276j;
        int length = iArr.length;
        while (this.r < i3) {
            while (true) {
                char[] cArr = this.p;
                int i4 = this.r;
                char c2 = cArr[i4];
                if (c2 < length && iArr[c2] != 0) {
                    break;
                }
                int i5 = this.r + 1;
                this.r = i5;
                if (i5 >= i3) {
                    return;
                }
            }
        }
    }

    public void a(double d2) throws IOException {
        if (this.f4162e || (a(com.fasterxml.jackson.core.c.a.QUOTE_NON_NUMERIC_NUMBERS) && (Double.isNaN(d2) || Double.isInfinite(d2)))) {
            f(String.valueOf(d2));
            return;
        }
        h("write number");
        e(String.valueOf(d2));
    }

    /* access modifiers changed from: protected */
    public void h() throws IOException {
        int i2 = this.r;
        int i3 = this.q;
        int i4 = i2 - i3;
        if (i4 > 0) {
            this.q = 0;
            this.r = 0;
            this.o.write(this.p, i3, i4);
        }
    }

    private void b(int i2, int i3) throws IOException, JsonGenerationException {
        char c2;
        int[] iArr = this.f4276j;
        int min = Math.min(iArr.length, i3 + 1);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i2) {
            while (true) {
                c2 = this.p[i4];
                if (c2 >= min) {
                    if (c2 > i3) {
                        i6 = -1;
                        break;
                    }
                } else {
                    i6 = iArr[c2];
                    if (i6 != 0) {
                        break;
                    }
                }
                i4++;
                if (i4 >= i2) {
                    break;
                }
            }
            int i7 = i4 - i5;
            if (i7 > 0) {
                this.o.write(this.p, i5, i7);
                if (i4 >= i2) {
                    return;
                }
            }
            i4++;
            i5 = a(this.p, i4, i2, c2, i6);
        }
    }

    public void a(float f2) throws IOException {
        if (this.f4162e || (a(com.fasterxml.jackson.core.c.a.QUOTE_NON_NUMERIC_NUMBERS) && (Float.isNaN(f2) || Float.isInfinite(f2)))) {
            f(String.valueOf(f2));
            return;
        }
        h("write number");
        e(String.valueOf(f2));
    }

    private void c(int i2) throws IOException {
        if (this.r + 13 >= this.s) {
            h();
        }
        char[] cArr = this.p;
        int i3 = this.r;
        this.r = i3 + 1;
        cArr[i3] = '\"';
        this.r = com.fasterxml.jackson.core.b.h.a(i2, cArr, this.r);
        char[] cArr2 = this.p;
        int i4 = this.r;
        this.r = i4 + 1;
        cArr2[i4] = '\"';
    }

    public void a(boolean z) throws IOException {
        int i2;
        h("write boolean value");
        if (this.r + 5 >= this.s) {
            h();
        }
        int i3 = this.r;
        char[] cArr = this.p;
        if (z) {
            cArr[i3] = 't';
            int i4 = i3 + 1;
            cArr[i4] = 'r';
            int i5 = i4 + 1;
            cArr[i5] = 'u';
            i2 = i5 + 1;
            cArr[i2] = 'e';
        } else {
            cArr[i3] = 'f';
            int i6 = i3 + 1;
            cArr[i6] = 'a';
            int i7 = i6 + 1;
            cArr[i7] = 'l';
            int i8 = i7 + 1;
            cArr[i8] = 's';
            i2 = i8 + 1;
            cArr[i2] = 'e';
        }
        this.r = i2 + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040 A[SYNTHETIC] */
    private void c(int i2, int i3) throws IOException, JsonGenerationException {
        char c2;
        int i4;
        int i5;
        int i6 = this.r + i2;
        int[] iArr = this.f4276j;
        int min = Math.min(iArr.length, i3 + 1);
        while (this.r < i6) {
            while (true) {
                c2 = this.p[this.r];
                if (c2 < min) {
                    i5 = iArr[c2];
                    if (i5 != 0) {
                        break;
                    }
                    i4 = this.r + 1;
                    this.r = i4;
                    if (i4 >= i6) {
                        return;
                    }
                } else {
                    if (c2 > i3) {
                        i5 = -1;
                        break;
                    }
                    i4 = this.r + 1;
                    this.r = i4;
                    if (i4 >= i6) {
                    }
                }
            }
            int i7 = this.r;
            int i8 = this.q;
            int i9 = i7 - i8;
            if (i9 > 0) {
                this.o.write(this.p, i8, i9);
            }
            this.r++;
            a(c2, i5);
        }
    }

    private void a(char c2, int i2) throws IOException, JsonGenerationException {
        String str;
        int i3;
        if (i2 >= 0) {
            int i4 = this.r;
            if (i4 >= 2) {
                int i5 = i4 - 2;
                this.q = i5;
                char[] cArr = this.p;
                int i6 = i5 + 1;
                cArr[i5] = '\\';
                cArr[i6] = (char) i2;
                return;
            }
            char[] cArr2 = this.t;
            if (cArr2 == null) {
                cArr2 = j();
            }
            this.q = this.r;
            cArr2[1] = (char) i2;
            this.o.write(cArr2, 0, 2);
        } else if (i2 != -2) {
            int i7 = this.r;
            if (i7 >= 6) {
                char[] cArr3 = this.p;
                int i8 = i7 - 6;
                this.q = i8;
                cArr3[i8] = '\\';
                int i9 = i8 + 1;
                cArr3[i9] = 'u';
                if (c2 > 255) {
                    int i10 = (c2 >> 8) & 255;
                    int i11 = i9 + 1;
                    char[] cArr4 = n;
                    cArr3[i11] = cArr4[i10 >> 4];
                    i3 = i11 + 1;
                    cArr3[i3] = cArr4[i10 & 15];
                    c2 = (char) (c2 & 255);
                } else {
                    int i12 = i9 + 1;
                    cArr3[i12] = '0';
                    i3 = i12 + 1;
                    cArr3[i3] = '0';
                }
                int i13 = i3 + 1;
                char[] cArr5 = n;
                cArr3[i13] = cArr5[c2 >> 4];
                cArr3[i13 + 1] = cArr5[c2 & 15];
                return;
            }
            char[] cArr6 = this.t;
            if (cArr6 == null) {
                cArr6 = j();
            }
            this.q = this.r;
            if (c2 > 255) {
                int i14 = (c2 >> 8) & 255;
                char c3 = c2 & 255;
                char[] cArr7 = n;
                cArr6[10] = cArr7[i14 >> 4];
                cArr6[11] = cArr7[i14 & 15];
                cArr6[12] = cArr7[c3 >> 4];
                cArr6[13] = cArr7[c3 & 15];
                this.o.write(cArr6, 8, 6);
            } else {
                char[] cArr8 = n;
                cArr6[6] = cArr8[c2 >> 4];
                cArr6[7] = cArr8[c2 & 15];
                this.o.write(cArr6, 2, 6);
            }
        } else {
            j jVar = this.u;
            if (jVar == null) {
                str = this.f4278l.a(c2).getValue();
            } else {
                str = jVar.getValue();
                this.u = null;
            }
            int length = str.length();
            int i15 = this.r;
            if (i15 >= length) {
                int i16 = i15 - length;
                this.q = i16;
                str.getChars(0, length, this.p, i16);
                return;
            }
            this.q = i15;
            this.o.write(str);
        }
    }

    private int a(char[] cArr, int i2, int i3, char c2, int i4) throws IOException, JsonGenerationException {
        String str;
        int i5;
        if (i4 >= 0) {
            if (i2 <= 1 || i2 >= i3) {
                char[] cArr2 = this.t;
                if (cArr2 == null) {
                    cArr2 = j();
                }
                cArr2[1] = (char) i4;
                this.o.write(cArr2, 0, 2);
            } else {
                i2 -= 2;
                cArr[i2] = '\\';
                cArr[i2 + 1] = (char) i4;
            }
            return i2;
        } else if (i4 != -2) {
            if (i2 <= 5 || i2 >= i3) {
                char[] cArr3 = this.t;
                if (cArr3 == null) {
                    cArr3 = j();
                }
                this.q = this.r;
                if (c2 > 255) {
                    int i6 = (c2 >> 8) & 255;
                    char c3 = c2 & 255;
                    char[] cArr4 = n;
                    cArr3[10] = cArr4[i6 >> 4];
                    cArr3[11] = cArr4[i6 & 15];
                    cArr3[12] = cArr4[c3 >> 4];
                    cArr3[13] = cArr4[c3 & 15];
                    this.o.write(cArr3, 8, 6);
                } else {
                    char[] cArr5 = n;
                    cArr3[6] = cArr5[c2 >> 4];
                    cArr3[7] = cArr5[c2 & 15];
                    this.o.write(cArr3, 2, 6);
                }
            } else {
                int i7 = i2 - 6;
                int i8 = i7 + 1;
                cArr[i7] = '\\';
                int i9 = i8 + 1;
                cArr[i8] = 'u';
                if (c2 > 255) {
                    int i10 = (c2 >> 8) & 255;
                    int i11 = i9 + 1;
                    char[] cArr6 = n;
                    cArr[i9] = cArr6[i10 >> 4];
                    i5 = i11 + 1;
                    cArr[i11] = cArr6[i10 & 15];
                    c2 = (char) (c2 & 255);
                } else {
                    int i12 = i9 + 1;
                    cArr[i9] = '0';
                    i5 = i12 + 1;
                    cArr[i12] = '0';
                }
                int i13 = i5 + 1;
                char[] cArr7 = n;
                cArr[i5] = cArr7[c2 >> 4];
                cArr[i13] = cArr7[c2 & 15];
                i2 = i13 - 5;
            }
            return i2;
        } else {
            j jVar = this.u;
            if (jVar == null) {
                str = this.f4278l.a(c2).getValue();
            } else {
                str = jVar.getValue();
                this.u = null;
            }
            int length = str.length();
            if (i2 < length || i2 >= i3) {
                this.o.write(str);
            } else {
                i2 -= length;
                str.getChars(0, length, cArr, i2);
            }
            return i2;
        }
    }
}
