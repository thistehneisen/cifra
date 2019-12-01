package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.a.b;
import com.fasterxml.jackson.core.b.a;
import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import com.fasterxml.jackson.core.h;
import java.io.IOException;
import java.io.Reader;

/* compiled from: ReaderBasedJsonParser */
public class f extends b {
    protected static final int[] L = a.e();
    protected Reader M;
    protected char[] N;
    protected boolean O;
    protected h P;
    protected final com.fasterxml.jackson.core.d.b Q;
    protected final int R;
    protected boolean S = false;

    public f(c cVar, int i2, Reader reader, h hVar, com.fasterxml.jackson.core.d.b bVar, char[] cArr, int i3, int i4, boolean z) {
        super(cVar, i2);
        this.M = reader;
        this.N = cArr;
        this.m = i3;
        this.n = i4;
        this.P = hVar;
        this.Q = bVar;
        this.R = bVar.b();
        this.O = z;
    }

    private final g b(boolean z, int i2) throws IOException {
        int i3;
        char c2;
        boolean z2;
        int i4;
        int i5;
        char c3;
        char c4;
        char c5;
        int i6;
        int i7;
        boolean z3 = z;
        this.m = z3 ? i2 + 1 : i2;
        char[] e2 = this.w.e();
        int i8 = 0;
        if (z3) {
            e2[0] = '-';
            i3 = 1;
        } else {
            i3 = 0;
        }
        int i9 = this.m;
        if (i9 < this.n) {
            char[] cArr = this.N;
            this.m = i9 + 1;
            c2 = cArr[i9];
        } else {
            c2 = i("No digit following minus sign");
        }
        if (c2 == '0') {
            c2 = ra();
        }
        char[] cArr2 = e2;
        int i10 = 0;
        while (true) {
            if (c2 >= '0' && c2 <= '9') {
                i10++;
                if (i3 >= cArr2.length) {
                    cArr2 = this.w.g();
                    i3 = 0;
                }
                int i11 = i3 + 1;
                cArr2[i3] = c2;
                if (this.m >= this.n && !R()) {
                    i3 = i11;
                    c2 = 0;
                    z2 = true;
                    break;
                }
                char[] cArr3 = this.N;
                int i12 = this.m;
                this.m = i12 + 1;
                c2 = cArr3[i12];
                i3 = i11;
            } else {
                z2 = false;
            }
        }
        z2 = false;
        if (i10 != 0) {
            if (c2 == '.') {
                i4 = i3 + 1;
                cArr2[i3] = c2;
                i5 = 0;
                while (true) {
                    if (this.m >= this.n && !R()) {
                        z2 = true;
                        break;
                    }
                    char[] cArr4 = this.N;
                    int i13 = this.m;
                    this.m = i13 + 1;
                    c2 = cArr4[i13];
                    if (c2 < '0' || c2 > '9') {
                        break;
                    }
                    i5++;
                    if (i4 >= cArr2.length) {
                        cArr2 = this.w.g();
                        i4 = 0;
                    }
                    int i14 = i4 + 1;
                    cArr2[i4] = c2;
                    i4 = i14;
                }
                if (i5 == 0) {
                    c(c2, "Decimal point not followed by a digit");
                    throw null;
                }
            } else {
                i4 = i3;
                i5 = 0;
            }
            if (c2 == 'e' || c2 == 'E') {
                if (i4 >= cArr2.length) {
                    cArr2 = this.w.g();
                    i4 = 0;
                }
                int i15 = i4 + 1;
                cArr2[i4] = c2;
                int i16 = this.m;
                String str = "expected a digit for number exponent";
                if (i16 < this.n) {
                    char[] cArr5 = this.N;
                    this.m = i16 + 1;
                    c3 = cArr5[i16];
                } else {
                    c3 = i(str);
                }
                if (c3 == '-' || c3 == '+') {
                    if (i15 >= cArr2.length) {
                        cArr2 = this.w.g();
                        i15 = 0;
                    }
                    int i17 = i15 + 1;
                    cArr2[i15] = c3;
                    int i18 = this.m;
                    if (i18 < this.n) {
                        char[] cArr6 = this.N;
                        this.m = i18 + 1;
                        c4 = cArr6[i18];
                    } else {
                        c4 = i(str);
                    }
                    c5 = c4;
                    i6 = i17;
                } else {
                    c5 = c3;
                    i6 = i15;
                }
                int i19 = 0;
                while (true) {
                    if (c2 <= '9' && c2 >= '0') {
                        i19++;
                        if (i6 >= cArr2.length) {
                            cArr2 = this.w.g();
                            i6 = 0;
                        }
                        i7 = i6 + 1;
                        cArr2[i6] = c2;
                        if (this.m >= this.n && !R()) {
                            i8 = i19;
                            z2 = true;
                            break;
                        }
                        char[] cArr7 = this.N;
                        int i20 = this.m;
                        this.m = i20 + 1;
                        c5 = cArr7[i20];
                        i6 = i7;
                    } else {
                        i7 = i6;
                        i8 = i19;
                    }
                }
                i7 = i6;
                i8 = i19;
                if (i8 == 0) {
                    c(c2, "Exponent indicator not followed by a digit");
                    throw null;
                }
            }
            if (!z2) {
                this.m--;
                if (this.u.f()) {
                    j(c2);
                }
            }
            this.w.a(i4);
            return a(z3, i10, i5, i8);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Missing integer part (next char ");
        sb.append(com.fasterxml.jackson.core.a.c.b(c2));
        sb.append(")");
        g(sb.toString());
        throw null;
    }

    private final void ea() throws IOException {
        int i2 = this.m;
        if (i2 + 4 < this.n) {
            char[] cArr = this.N;
            if (cArr[i2] == 'a') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'l') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 's') {
                        int i5 = i4 + 1;
                        if (cArr[i5] == 'e') {
                            int i6 = i5 + 1;
                            char c2 = cArr[i6];
                            if (c2 < '0' || c2 == ']' || c2 == '}') {
                                this.m = i6;
                                return;
                            }
                        }
                    }
                }
            }
        }
        a("false", 1);
    }

    private final void fa() throws IOException {
        int i2 = this.m;
        if (i2 + 3 < this.n) {
            char[] cArr = this.N;
            if (cArr[i2] == 'u') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'l') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 'l') {
                        int i5 = i4 + 1;
                        char c2 = cArr[i5];
                        if (c2 < '0' || c2 == ']' || c2 == '}') {
                            this.m = i5;
                            return;
                        }
                    }
                }
            }
        }
        a("null", 1);
    }

    private final void ga() throws IOException {
        int i2 = this.m;
        if (i2 + 3 < this.n) {
            char[] cArr = this.N;
            if (cArr[i2] == 'r') {
                int i3 = i2 + 1;
                if (cArr[i3] == 'u') {
                    int i4 = i3 + 1;
                    if (cArr[i4] == 'e') {
                        int i5 = i4 + 1;
                        char c2 = cArr[i5];
                        if (c2 < '0' || c2 == ']' || c2 == '}') {
                            this.m = i5;
                            return;
                        }
                    }
                }
            }
        }
        a("true", 1);
    }

    private final g ha() {
        this.y = false;
        g gVar = this.v;
        this.v = null;
        if (gVar == g.START_ARRAY) {
            this.u = this.u.a(this.s, this.t);
        } else if (gVar == g.START_OBJECT) {
            this.u = this.u.b(this.s, this.t);
        }
        this.f4175b = gVar;
        return gVar;
    }

    private final int ia() throws IOException {
        char c2;
        while (true) {
            if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i2 = this.m;
                this.m = i2 + 1;
                c2 = cArr[i2];
                if (c2 > ' ') {
                    if (c2 == '/') {
                        la();
                    } else if (c2 != '#' || !pa()) {
                        return c2;
                    }
                } else if (c2 >= ' ') {
                    continue;
                } else if (c2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (c2 == 13) {
                    ca();
                } else if (c2 != 9) {
                    d((int) c2);
                    throw null;
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected end-of-input within/between ");
                sb.append(this.u.c());
                sb.append(" entries");
                throw b(sb.toString());
            }
        }
        return c2;
    }

    private void ja() throws IOException {
        while (true) {
            if (this.m >= this.n && !R()) {
                break;
            }
            char[] cArr = this.N;
            int i2 = this.m;
            this.m = i2 + 1;
            char c2 = cArr[i2];
            if (c2 <= '*') {
                if (c2 == '*') {
                    if (this.m >= this.n && !R()) {
                        break;
                    }
                    char[] cArr2 = this.N;
                    int i3 = this.m;
                    if (cArr2[i3] == '/') {
                        this.m = i3 + 1;
                        return;
                    }
                } else if (c2 >= ' ') {
                    continue;
                } else if (c2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (c2 == 13) {
                    ca();
                } else if (c2 != 9) {
                    d((int) c2);
                    throw null;
                }
            }
        }
        f(" in a comment");
        throw null;
    }

    private final int ka() throws IOException {
        int i2 = this.m;
        if (i2 + 4 >= this.n) {
            return b(false);
        }
        char[] cArr = this.N;
        char c2 = cArr[i2];
        if (c2 == ':') {
            int i3 = i2 + 1;
            this.m = i3;
            char c3 = cArr[i3];
            if (c3 <= ' ') {
                if (c3 == ' ' || c3 == 9) {
                    char[] cArr2 = this.N;
                    int i4 = this.m + 1;
                    this.m = i4;
                    char c4 = cArr2[i4];
                    if (c4 > ' ') {
                        if (c4 == '/' || c4 == '#') {
                            return b(true);
                        }
                        this.m++;
                        return c4;
                    }
                }
                return b(true);
            } else if (c3 == '/' || c3 == '#') {
                return b(true);
            } else {
                this.m++;
                return c3;
            }
        } else {
            if (c2 == ' ' || c2 == 9) {
                char[] cArr3 = this.N;
                int i5 = this.m + 1;
                this.m = i5;
                c2 = cArr3[i5];
            }
            if (c2 != ':') {
                return b(false);
            }
            char[] cArr4 = this.N;
            int i6 = this.m + 1;
            this.m = i6;
            char c5 = cArr4[i6];
            if (c5 <= ' ') {
                if (c5 == ' ' || c5 == 9) {
                    char[] cArr5 = this.N;
                    int i7 = this.m + 1;
                    this.m = i7;
                    char c6 = cArr5[i7];
                    if (c6 > ' ') {
                        if (c6 == '/' || c6 == '#') {
                            return b(true);
                        }
                        this.m++;
                        return c6;
                    }
                }
                return b(true);
            } else if (c5 == '/' || c5 == '#') {
                return b(true);
            } else {
                this.m++;
                return c5;
            }
        }
    }

    private void la() throws IOException {
        if (!a(e.a.ALLOW_COMMENTS)) {
            a(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
            throw null;
        } else if (this.m < this.n || R()) {
            char[] cArr = this.N;
            int i2 = this.m;
            this.m = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '/') {
                ma();
            } else if (c2 == '*') {
                ja();
            } else {
                a((int) c2, "was expecting either '*' or '/' for a comment");
                throw null;
            }
        } else {
            f(" in a comment");
            throw null;
        }
    }

    private void ma() throws IOException {
        while (true) {
            if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i2 = this.m;
                this.m = i2 + 1;
                char c2 = cArr[i2];
                if (c2 < ' ') {
                    if (c2 == 10) {
                        this.p++;
                        this.q = this.m;
                        return;
                    } else if (c2 == 13) {
                        ca();
                        return;
                    } else if (c2 != 9) {
                        d((int) c2);
                        throw null;
                    }
                }
            } else {
                return;
            }
        }
    }

    private final int na() throws IOException {
        if (this.m >= this.n && !R()) {
            return M();
        }
        char[] cArr = this.N;
        int i2 = this.m;
        this.m = i2 + 1;
        char c2 = cArr[i2];
        if (c2 <= ' ') {
            if (c2 != ' ') {
                if (c2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (c2 == 13) {
                    ca();
                } else if (c2 != 9) {
                    d((int) c2);
                    throw null;
                }
            }
            while (true) {
                int i3 = this.m;
                if (i3 >= this.n) {
                    return oa();
                }
                char[] cArr2 = this.N;
                this.m = i3 + 1;
                char c3 = cArr2[i3];
                if (c3 > ' ') {
                    if (c3 != '/' && c3 != '#') {
                        return c3;
                    }
                    this.m--;
                    return oa();
                } else if (c3 != ' ') {
                    if (c3 == 10) {
                        this.p++;
                        this.q = this.m;
                    } else if (c3 == 13) {
                        ca();
                    } else if (c3 != 9) {
                        d((int) c3);
                        throw null;
                    }
                }
            }
        } else if (c2 != '/' && c2 != '#') {
            return c2;
        } else {
            this.m--;
            return oa();
        }
    }

    private int oa() throws IOException {
        char c2;
        while (true) {
            if (this.m >= this.n && !R()) {
                return M();
            }
            char[] cArr = this.N;
            int i2 = this.m;
            this.m = i2 + 1;
            c2 = cArr[i2];
            if (c2 > ' ') {
                if (c2 == '/') {
                    la();
                } else if (c2 != '#' || !pa()) {
                    return c2;
                }
            } else if (c2 == ' ') {
                continue;
            } else if (c2 == 10) {
                this.p++;
                this.q = this.m;
            } else if (c2 == 13) {
                ca();
            } else if (c2 != 9) {
                d((int) c2);
                throw null;
            }
        }
        return c2;
    }

    private boolean pa() throws IOException {
        if (!a(e.a.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        ma();
        return true;
    }

    private char qa() throws IOException {
        if (this.m >= this.n && !R()) {
            return '0';
        }
        char c2 = this.N[this.m];
        if (c2 < '0' || c2 > '9') {
            return '0';
        }
        if (a(e.a.ALLOW_NUMERIC_LEADING_ZEROS)) {
            this.m++;
            if (c2 == '0') {
                do {
                    if (this.m >= this.n && !R()) {
                        break;
                    }
                    char[] cArr = this.N;
                    int i2 = this.m;
                    c2 = cArr[i2];
                    if (c2 < '0' || c2 > '9') {
                        return '0';
                    }
                    this.m = i2 + 1;
                } while (c2 == '0');
            }
            return c2;
        }
        g("Leading zeroes not allowed");
        throw null;
    }

    private final char ra() throws IOException {
        int i2 = this.m;
        if (i2 < this.n) {
            char c2 = this.N[i2];
            if (c2 < '0' || c2 > '9') {
                return '0';
            }
        }
        return qa();
    }

    public final String E() throws IOException {
        if (this.f4175b != g.VALUE_STRING) {
            return super.c((String) null);
        }
        if (this.S) {
            this.S = false;
            W();
        }
        return this.w.d();
    }

    public final g F() throws IOException {
        g gVar;
        this.B = 0;
        if (this.f4175b == g.FIELD_NAME) {
            return ha();
        }
        if (this.S) {
            da();
        }
        int na = na();
        if (na < 0) {
            close();
            this.f4175b = null;
            return null;
        }
        long j2 = this.o;
        int i2 = this.m;
        this.r = (j2 + ((long) i2)) - 1;
        this.s = this.p;
        this.t = (i2 - this.q) - 1;
        this.A = null;
        if (na == 93) {
            if (this.u.d()) {
                this.u = this.u.i();
                g gVar2 = g.END_ARRAY;
                this.f4175b = gVar2;
                return gVar2;
            }
            a(na, '}');
            throw null;
        } else if (na != 125) {
            if (this.u.g()) {
                na = i(na);
            }
            boolean e2 = this.u.e();
            if (e2) {
                this.u.a(na == 34 ? aa() : f(na));
                this.f4175b = g.FIELD_NAME;
                na = ka();
            }
            if (na == 34) {
                this.S = true;
                gVar = g.VALUE_STRING;
            } else if (na == 45) {
                gVar = ba();
            } else if (na != 91) {
                if (na != 93) {
                    if (na == 102) {
                        ea();
                        gVar = g.VALUE_FALSE;
                    } else if (na == 110) {
                        fa();
                        gVar = g.VALUE_NULL;
                    } else if (na == 116) {
                        ga();
                        gVar = g.VALUE_TRUE;
                    } else if (na != 123) {
                        if (na != 125) {
                            switch (na) {
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                    gVar = h(na);
                                    break;
                                default:
                                    gVar = g(na);
                                    break;
                            }
                        }
                    } else {
                        if (!e2) {
                            this.u = this.u.b(this.s, this.t);
                        }
                        gVar = g.START_OBJECT;
                    }
                }
                a(na, "expected a value");
                throw null;
            } else {
                if (!e2) {
                    this.u = this.u.a(this.s, this.t);
                }
                gVar = g.START_ARRAY;
            }
            if (e2) {
                this.v = gVar;
                return this.f4175b;
            }
            this.f4175b = gVar;
            return gVar;
        } else if (this.u.e()) {
            this.u = this.u.i();
            g gVar3 = g.END_OBJECT;
            this.f4175b = gVar3;
            return gVar3;
        } else {
            a(na, ']');
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void L() throws IOException {
        if (this.M != null) {
            if (this.f4173k.h() || a(e.a.AUTO_CLOSE_SOURCE)) {
                this.M.close();
            }
            this.M = null;
        }
    }

    /* access modifiers changed from: protected */
    public void N() throws IOException {
        super.N();
        this.Q.d();
        if (this.O) {
            char[] cArr = this.N;
            if (cArr != null) {
                this.N = null;
                this.f4173k.c(cArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean R() throws IOException {
        long j2 = this.o;
        int i2 = this.n;
        this.o = j2 + ((long) i2);
        this.q -= i2;
        Reader reader = this.M;
        if (reader != null) {
            char[] cArr = this.N;
            int read = reader.read(cArr, 0, cArr.length);
            if (read > 0) {
                this.m = 0;
                this.n = read;
                return true;
            }
            L();
            if (read == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Reader returned 0 characters when trying to read ");
                sb.append(this.n);
                throw new IOException(sb.toString());
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public char V() throws IOException {
        String str = " in character escape sequence";
        if (this.m < this.n || R()) {
            char[] cArr = this.N;
            int i2 = this.m;
            this.m = i2 + 1;
            char c2 = cArr[i2];
            if (!(c2 == '\"' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    c2 = 8;
                } else if (c2 == 'f') {
                    return 12;
                } else {
                    if (c2 == 'n') {
                        return 10;
                    }
                    if (c2 == 'r') {
                        return 13;
                    }
                    if (c2 == 't') {
                        return 9;
                    }
                    if (c2 != 'u') {
                        a(c2);
                        return c2;
                    }
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < 4) {
                        if (this.m < this.n || R()) {
                            char[] cArr2 = this.N;
                            int i5 = this.m;
                            this.m = i5 + 1;
                            char c3 = cArr2[i5];
                            int a2 = a.a(c3);
                            if (a2 >= 0) {
                                i4 = (i4 << 4) | a2;
                                i3++;
                            } else {
                                a((int) c3, "expected a hex-digit for character escape sequence");
                                throw null;
                            }
                        } else {
                            f(str);
                            throw null;
                        }
                    }
                    return (char) i4;
                }
            }
            return c2;
        }
        f(str);
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void W() throws IOException {
        int i2 = this.m;
        int i3 = this.n;
        if (i2 < i3) {
            int[] iArr = L;
            int length = iArr.length;
            while (true) {
                char[] cArr = this.N;
                char c2 = cArr[i2];
                if (c2 >= length || iArr[c2] == 0) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                } else if (c2 == '\"') {
                    com.fasterxml.jackson.core.e.g gVar = this.w;
                    int i4 = this.m;
                    gVar.c(cArr, i4, i2 - i4);
                    this.m = i2 + 1;
                    return;
                }
            }
        }
        com.fasterxml.jackson.core.e.g gVar2 = this.w;
        char[] cArr2 = this.N;
        int i5 = this.m;
        gVar2.b(cArr2, i5, i2 - i5);
        this.m = i2;
        X();
    }

    /* access modifiers changed from: protected */
    public void X() throws IOException {
        char[] h2 = this.w.h();
        int i2 = this.w.i();
        int[] iArr = L;
        int length = iArr.length;
        while (true) {
            if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i3 = this.m;
                this.m = i3 + 1;
                char c2 = cArr[i3];
                if (c2 < length && iArr[c2] != 0) {
                    if (c2 == '\"') {
                        this.w.a(i2);
                        return;
                    } else if (c2 == '\\') {
                        c2 = V();
                    } else if (c2 < ' ') {
                        b((int) c2, "string value");
                    }
                }
                if (i2 >= h2.length) {
                    h2 = this.w.g();
                    i2 = 0;
                }
                int i4 = i2 + 1;
                h2[i2] = c2;
                i2 = i4;
            } else {
                f(": was expecting closing quote for a string value");
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public g Y() throws IOException {
        char[] e2 = this.w.e();
        int i2 = this.w.i();
        while (true) {
            if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i3 = this.m;
                this.m = i3 + 1;
                char c2 = cArr[i3];
                if (c2 <= '\\') {
                    if (c2 == '\\') {
                        c2 = V();
                    } else if (c2 <= '\'') {
                        if (c2 == '\'') {
                            this.w.a(i2);
                            return g.VALUE_STRING;
                        } else if (c2 < ' ') {
                            b((int) c2, "string value");
                        }
                    }
                }
                if (i2 >= e2.length) {
                    e2 = this.w.g();
                    i2 = 0;
                }
                int i4 = i2 + 1;
                e2[i2] = c2;
                i2 = i4;
            } else {
                f(": was expecting closing quote for a string value");
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String Z() throws IOException {
        int i2 = this.m;
        int i3 = this.R;
        int i4 = this.n;
        if (i2 < i4) {
            int[] iArr = L;
            int length = iArr.length;
            do {
                char[] cArr = this.N;
                char c2 = cArr[i2];
                if (c2 != '\'') {
                    if (c2 < length && iArr[c2] != 0) {
                        break;
                    }
                    i3 = (i3 * 33) + c2;
                    i2++;
                } else {
                    int i5 = this.m;
                    this.m = i2 + 1;
                    return this.Q.a(cArr, i5, i2 - i5, i3);
                }
            } while (i2 < i4);
        }
        int i6 = this.m;
        this.m = i2;
        return a(i6, i3, 39);
    }

    /* access modifiers changed from: protected */
    public final String a(g gVar) {
        if (gVar == null) {
            return null;
        }
        int b2 = gVar.b();
        if (b2 == 5) {
            return this.u.h();
        }
        if (b2 == 6 || b2 == 7 || b2 == 8) {
            return this.w.d();
        }
        return gVar.a();
    }

    /* access modifiers changed from: protected */
    public final String aa() throws IOException {
        int i2 = this.m;
        int i3 = this.R;
        int[] iArr = L;
        while (true) {
            if (i2 >= this.n) {
                break;
            }
            char[] cArr = this.N;
            char c2 = cArr[i2];
            if (c2 >= iArr.length || iArr[c2] == 0) {
                i3 = (i3 * 33) + c2;
                i2++;
            } else if (c2 == '\"') {
                int i4 = this.m;
                this.m = i2 + 1;
                return this.Q.a(cArr, i4, i2 - i4, i3);
            }
        }
        int i5 = this.m;
        this.m = i2;
        return a(i5, i3, 34);
    }

    /* access modifiers changed from: protected */
    public final g ba() throws IOException {
        int i2 = this.m;
        int i3 = i2 - 1;
        int i4 = this.n;
        if (i2 >= i4) {
            return b(true, i3);
        }
        int i5 = i2 + 1;
        char c2 = this.N[i2];
        if (c2 > '9' || c2 < '0') {
            this.m = i5;
            return a((int) c2, true);
        } else if (c2 == '0') {
            return b(true, i3);
        } else {
            int i6 = 1;
            while (i5 < i4) {
                int i7 = i5 + 1;
                char c3 = this.N[i5];
                if (c3 >= '0' && c3 <= '9') {
                    i6++;
                    i5 = i7;
                } else if (c3 == '.' || c3 == 'e' || c3 == 'E') {
                    this.m = i7;
                    return a(c3, i3, i7, true, i6);
                } else {
                    int i8 = i7 - 1;
                    this.m = i8;
                    if (this.u.f()) {
                        j(c3);
                    }
                    this.w.c(this.N, i3, i8 - i3);
                    return a(true, i6);
                }
            }
            return b(true, i3);
        }
    }

    public final String c(String str) throws IOException {
        if (this.f4175b != g.VALUE_STRING) {
            return super.c(str);
        }
        if (this.S) {
            this.S = false;
            W();
        }
        return this.w.d();
    }

    /* access modifiers changed from: protected */
    public final void ca() throws IOException {
        if (this.m < this.n || R()) {
            char[] cArr = this.N;
            int i2 = this.m;
            if (cArr[i2] == 10) {
                this.m = i2 + 1;
            }
        }
        this.p++;
        this.q = this.m;
    }

    /* access modifiers changed from: protected */
    public final void da() throws IOException {
        this.S = false;
        int i2 = this.m;
        int i3 = this.n;
        char[] cArr = this.N;
        while (true) {
            if (i2 >= i3) {
                this.m = i2;
                if (R()) {
                    i2 = this.m;
                    i3 = this.n;
                } else {
                    f(": was expecting closing quote for a string value");
                    throw null;
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 <= '\\') {
                if (c2 == '\\') {
                    this.m = i4;
                    V();
                    i2 = this.m;
                    i3 = this.n;
                } else if (c2 <= '\"') {
                    if (c2 == '\"') {
                        this.m = i4;
                        return;
                    } else if (c2 < ' ') {
                        this.m = i4;
                        b((int) c2, "string value");
                    }
                }
            }
            i2 = i4;
        }
    }

    /* access modifiers changed from: protected */
    public String f(int i2) throws IOException {
        if (i2 == 39 && a(e.a.ALLOW_SINGLE_QUOTES)) {
            return Z();
        }
        if (a(e.a.ALLOW_UNQUOTED_FIELD_NAMES)) {
            int[] f2 = a.f();
            int length = f2.length;
            boolean z = i2 < length ? f2[i2] == 0 : Character.isJavaIdentifierPart((char) i2);
            if (z) {
                int i3 = this.m;
                int i4 = this.R;
                int i5 = this.n;
                if (i3 < i5) {
                    do {
                        char[] cArr = this.N;
                        char c2 = cArr[i3];
                        if (c2 < length) {
                            if (f2[c2] != 0) {
                                int i6 = this.m - 1;
                                this.m = i3;
                                return this.Q.a(cArr, i6, i3 - i6, i4);
                            }
                        } else if (!Character.isJavaIdentifierPart((char) c2)) {
                            int i7 = this.m - 1;
                            this.m = i3;
                            return this.Q.a(this.N, i7, i3 - i7, i4);
                        }
                        i4 = (i4 * 33) + c2;
                        i3++;
                    } while (i3 < i5);
                }
                int i8 = this.m - 1;
                this.m = i3;
                return a(i8, i4, f2);
            }
            a(i2, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
            throw null;
        }
        a(i2, "was expecting double-quote to start field name");
        throw null;
    }

    /* access modifiers changed from: protected */
    public g g(int i2) throws IOException {
        if (i2 != 39) {
            if (i2 != 43) {
                if (i2 == 73) {
                    String str = "Infinity";
                    a(str, 1);
                    if (a(e.a.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return a(str, Double.POSITIVE_INFINITY);
                    }
                    e("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    throw null;
                } else if (i2 == 78) {
                    String str2 = "NaN";
                    a(str2, 1);
                    if (a(e.a.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return a(str2, Double.NaN);
                    }
                    e("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    throw null;
                }
            } else if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i3 = this.m;
                this.m = i3 + 1;
                return a((int) cArr[i3], false);
            } else {
                J();
                throw null;
            }
        } else if (a(e.a.ALLOW_SINGLE_QUOTES)) {
            return Y();
        }
        if (Character.isJavaIdentifierStart(i2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((char) i2);
            a(sb.toString(), "('true', 'false' or 'null')");
            throw null;
        }
        a(i2, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final g h(int i2) throws IOException {
        int i3 = this.m;
        int i4 = i3 - 1;
        int i5 = this.n;
        if (i2 == 48) {
            return b(false, i4);
        }
        int i6 = 1;
        while (i3 < i5) {
            int i7 = i3 + 1;
            char c2 = this.N[i3];
            if (c2 >= '0' && c2 <= '9') {
                i6++;
                i3 = i7;
            } else if (c2 == '.' || c2 == 'e' || c2 == 'E') {
                this.m = i7;
                return a(c2, i4, i7, false, i6);
            } else {
                int i8 = i7 - 1;
                this.m = i8;
                if (this.u.f()) {
                    j(c2);
                }
                this.w.c(this.N, i4, i8 - i4);
                return a(false, i6);
            }
        }
        this.m = i4;
        return b(false, i4);
    }

    /* access modifiers changed from: protected */
    public char i(String str) throws IOException {
        if (this.m < this.n || R()) {
            char[] cArr = this.N;
            int i2 = this.m;
            this.m = i2 + 1;
            return cArr[i2];
        }
        f(str);
        throw null;
    }

    public final String j() throws IOException {
        g gVar = this.f4175b;
        if (gVar != g.VALUE_STRING) {
            return a(gVar);
        }
        if (this.S) {
            this.S = false;
            W();
        }
        return this.w.d();
    }

    private final int i(int i2) throws IOException {
        if (i2 == 44) {
            while (true) {
                int i3 = this.m;
                if (i3 >= this.n) {
                    return ia();
                }
                char[] cArr = this.N;
                this.m = i3 + 1;
                char c2 = cArr[i3];
                if (c2 > ' ') {
                    if (c2 != '/' && c2 != '#') {
                        return c2;
                    }
                    this.m--;
                    return ia();
                } else if (c2 < ' ') {
                    if (c2 == 10) {
                        this.p++;
                        this.q = this.m;
                    } else if (c2 == 13) {
                        ca();
                    } else if (c2 != 9) {
                        d((int) c2);
                        throw null;
                    }
                }
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("was expecting comma to separate ");
            sb.append(this.u.c());
            sb.append(" entries");
            a(i2, sb.toString());
            throw null;
        }
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [int] */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2, types: [int] */
    /* JADX WARNING: type inference failed for: r8v5, types: [char[]] */
    /* JADX WARNING: type inference failed for: r8v6, types: [char] */
    /* JADX WARNING: type inference failed for: r8v7, types: [int] */
    /* JADX WARNING: type inference failed for: r8v8, types: [char[]] */
    /* JADX WARNING: type inference failed for: r8v9, types: [char] */
    /* JADX WARNING: type inference failed for: r8v11, types: [char[]] */
    /* JADX WARNING: type inference failed for: r8v12, types: [char] */
    /* JADX WARNING: type inference failed for: r8v14 */
    /* JADX WARNING: type inference failed for: r5v3, types: [char[]] */
    /* JADX WARNING: type inference failed for: r10v11, types: [char, int] */
    /* JADX WARNING: type inference failed for: r8v20 */
    /* JADX WARNING: type inference failed for: r8v22 */
    /* JADX WARNING: type inference failed for: r8v23 */
    /* JADX WARNING: type inference failed for: r8v24 */
    /* JADX WARNING: type inference failed for: r8v25 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r10v11, types: [char, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r8v12, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r8v6, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r8v9, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r5v3, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r8v11, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r8v5, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r8v8, types: [char[]] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=null, for r8v0, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v14
      assigns: []
      uses: []
      mth insns count: 71
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Unknown variable types count: 11 */
    private final g a(int r8, int i2, int i3, boolean z, int i4) throws IOException {
        int i5;
        int i6 = this.n;
        int i7 = 0;
        if (r8 == 46) {
            int i8 = 0;
            while (i3 < i6) {
                int i9 = i3 + 1;
                ? r10 = this.N[i3];
                if (r10 >= 48 && r10 <= 57) {
                    i8++;
                    i3 = i9;
                } else if (i8 != 0) {
                    i5 = i8;
                    r8 = r10;
                    i3 = i9;
                } else {
                    c(r10, "Decimal point not followed by a digit");
                    throw null;
                }
            }
            return b(z, i2);
        }
        i5 = 0;
        r8 = r8;
        if (r8 == 101 || r8 == 69) {
            if (r10 >= i6) {
                this.m = i2;
                return b(z, i2);
            }
            int i10 = r10 + 1;
            r8 = this.N[r10];
            if (r8 == 45 || r8 == 43) {
                if (i10 >= i6) {
                    this.m = i2;
                    return b(z, i2);
                }
                r10 = i10 + 1;
                r8 = this.N[i10];
                if (r8 > 57 && r8 >= 48) {
                    i7++;
                    if (r10 >= i6) {
                        this.m = i2;
                    } else {
                        i10 = r10 + 1;
                        r8 = this.N[r10];
                    }
                    this.m = i2;
                    return b(z, i2);
                } else if (i7 == 0) {
                    c(r8, "Exponent indicator not followed by a digit");
                    throw null;
                }
            }
            r10 = i10;
            r8 = r8;
            if (r8 > 57) {
            }
            if (i7 == 0) {
            }
        }
        int i11 = r10 - 1;
        this.m = i11;
        if (this.u.f()) {
            j(r8);
        }
        this.w.c(this.N, i2, i11 - i2);
        return b(z, i4, i5, i7);
    }

    private final void j(int i2) throws IOException {
        this.m++;
        if (i2 != 9) {
            if (i2 == 10) {
                this.p++;
                this.q = this.m;
            } else if (i2 == 13) {
                ca();
            } else if (i2 != 32) {
                c(i2);
                throw null;
            }
        }
    }

    public f(c cVar, int i2, Reader reader, h hVar, com.fasterxml.jackson.core.d.b bVar) {
        super(cVar, i2);
        this.M = reader;
        this.N = cVar.c();
        this.m = 0;
        this.n = 0;
        this.P = hVar;
        this.Q = bVar;
        this.R = bVar.b();
        this.O = true;
    }

    /* access modifiers changed from: protected */
    public void h(String str) throws IOException {
        a(str, "'null', 'true', 'false' or NaN");
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=char, for r10v0, types: [int] */
    public g a(char c2, boolean z) throws IOException {
        if (c2 == 73) {
            if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i2 = this.m;
                this.m = i2 + 1;
                c2 = cArr[i2];
                double d2 = Double.NEGATIVE_INFINITY;
                String str = "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow";
                String str2 = "Non-standard token '";
                if (c2 == 78) {
                    String str3 = z ? "-INF" : "+INF";
                    a(str3, 3);
                    if (a(e.a.ALLOW_NON_NUMERIC_NUMBERS)) {
                        if (!z) {
                            d2 = Double.POSITIVE_INFINITY;
                        }
                        return a(str3, d2);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str3);
                    sb.append(str);
                    e(sb.toString());
                    throw null;
                } else if (c2 == 110) {
                    String str4 = z ? "-Infinity" : "+Infinity";
                    a(str4, 3);
                    if (a(e.a.ALLOW_NON_NUMERIC_NUMBERS)) {
                        if (!z) {
                            d2 = Double.POSITIVE_INFINITY;
                        }
                        return a(str4, d2);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str4);
                    sb2.append(str);
                    e(sb2.toString());
                    throw null;
                }
            } else {
                J();
                throw null;
            }
        }
        c(c2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008e  */
    private String a(int i2, int i3, int i4) throws IOException {
        char c2;
        int i5;
        this.w.c(this.N, i2, this.m - i2);
        char[] h2 = this.w.h();
        int i6 = this.w.i();
        while (true) {
            if (this.m < this.n || R()) {
                char[] cArr = this.N;
                int i7 = this.m;
                this.m = i7 + 1;
                char c3 = cArr[i7];
                if (c3 <= '\\') {
                    if (c3 == '\\') {
                        c2 = V();
                        i3 = (i3 * 33) + c3;
                        i5 = i6 + 1;
                        h2[i6] = c2;
                        if (i5 < h2.length) {
                            h2 = this.w.g();
                            i6 = 0;
                        } else {
                            i6 = i5;
                        }
                    } else if (c3 <= i4) {
                        if (c3 == i4) {
                            this.w.a(i6);
                            com.fasterxml.jackson.core.e.g gVar = this.w;
                            return this.Q.a(gVar.j(), gVar.k(), gVar.n(), i3);
                        } else if (c3 < ' ') {
                            b((int) c3, "name");
                        }
                    }
                }
                c2 = c3;
                i3 = (i3 * 33) + c3;
                i5 = i6 + 1;
                h2[i6] = c2;
                if (i5 < h2.length) {
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(": was expecting closing '");
                sb.append((char) i4);
                sb.append("' for name");
                f(sb.toString());
                throw null;
            }
        }
    }

    private final int b(boolean z) throws IOException {
        while (true) {
            if (this.m >= this.n) {
                S();
            }
            char[] cArr = this.N;
            int i2 = this.m;
            this.m = i2 + 1;
            char c2 = cArr[i2];
            if (c2 > ' ') {
                if (c2 == '/') {
                    la();
                } else if (c2 != '#' || !pa()) {
                    if (z) {
                        return c2;
                    }
                    if (c2 == ':') {
                        z = true;
                    } else if (c2 < ' ') {
                        d((int) c2);
                        throw null;
                    } else {
                        a((int) c2, "was expecting a colon to separate field name and value");
                        throw null;
                    }
                }
            } else if (c2 >= ' ') {
                continue;
            } else if (c2 == 10) {
                this.p++;
                this.q = this.m;
            } else if (c2 == 13) {
                ca();
            } else if (c2 != 9) {
                d((int) c2);
                throw null;
            }
        }
    }

    private String a(int i2, int i3, int[] iArr) throws IOException {
        this.w.c(this.N, i2, this.m - i2);
        char[] h2 = this.w.h();
        int i4 = this.w.i();
        int length = iArr.length;
        while (true) {
            if (this.m >= this.n && !R()) {
                break;
            }
            char c2 = this.N[this.m];
            if (c2 > length) {
                if (!Character.isJavaIdentifierPart(c2)) {
                    break;
                }
            } else if (iArr[c2] != 0) {
                break;
            }
            this.m++;
            i3 = (i3 * 33) + c2;
            int i5 = i4 + 1;
            h2[i4] = c2;
            if (i5 >= h2.length) {
                h2 = this.w.g();
                i4 = 0;
            } else {
                i4 = i5;
            }
        }
        this.w.a(i4);
        com.fasterxml.jackson.core.e.g gVar = this.w;
        return this.Q.a(gVar.j(), gVar.k(), gVar.n(), i3);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, int i2) throws IOException {
        int length = str.length();
        do {
            if (this.m >= this.n && !R()) {
                h(str.substring(0, i2));
                throw null;
            } else if (this.N[this.m] == str.charAt(i2)) {
                this.m++;
                i2++;
            } else {
                h(str.substring(0, i2));
                throw null;
            }
        } while (i2 < length);
        if (this.m < this.n || R()) {
            char c2 = this.N[this.m];
            if (c2 >= '0' && c2 != ']' && c2 != '}' && Character.isJavaIdentifierPart(c2)) {
                h(str.substring(0, i2));
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.m >= this.n && !R()) {
                break;
            }
            char c2 = this.N[this.m];
            if (!Character.isJavaIdentifierPart(c2)) {
                break;
            }
            this.m++;
            sb.append(c2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unrecognized token '");
        sb2.append(sb.toString());
        sb2.append("': was expecting ");
        sb2.append(str2);
        e(sb2.toString());
        throw null;
    }
}
