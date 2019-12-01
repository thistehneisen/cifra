package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.a.b;
import com.fasterxml.jackson.core.b.a;
import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.d;
import com.fasterxml.jackson.core.d.f;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: UTF8StreamJsonParser */
public class h extends b {
    private static final int[] L = a.g();
    protected static final int[] M = a.e();
    protected com.fasterxml.jackson.core.h N;
    protected final com.fasterxml.jackson.core.d.a O;
    protected int[] P = new int[16];
    protected boolean Q = false;
    private int R;
    protected InputStream S;
    protected byte[] T;
    protected boolean U;

    public h(c cVar, int i2, InputStream inputStream, com.fasterxml.jackson.core.h hVar, com.fasterxml.jackson.core.d.a aVar, byte[] bArr, int i3, int i4, boolean z) {
        super(cVar, i2);
        this.S = inputStream;
        this.N = hVar;
        this.O = aVar;
        this.T = bArr;
        this.m = i3;
        this.n = i4;
        this.q = i3;
        this.o = (long) (-i3);
        this.U = z;
    }

    private static final int d(int i2, int i3) {
        return i3 == 4 ? i2 : i2 | (-1 << (i3 << 3));
    }

    private final g da() {
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

    private final void ea() throws IOException {
        int[] d2 = a.d();
        while (true) {
            if (this.m >= this.n && !R()) {
                break;
            }
            byte[] bArr = this.T;
            int i2 = this.m;
            this.m = i2 + 1;
            byte b2 = bArr[i2] & 255;
            int i3 = d2[b2];
            if (i3 != 0) {
                if (i3 == 2) {
                    t(b2);
                } else if (i3 == 3) {
                    u(b2);
                } else if (i3 == 4) {
                    v(b2);
                } else if (i3 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (i3 == 13) {
                    aa();
                } else if (i3 == 42) {
                    if (this.m >= this.n && !R()) {
                        break;
                    }
                    byte[] bArr2 = this.T;
                    int i4 = this.m;
                    if (bArr2[i4] == 47) {
                        this.m = i4 + 1;
                        return;
                    }
                } else {
                    k(b2);
                    throw null;
                }
            }
        }
        f(" in a comment");
        throw null;
    }

    private final int fa() throws IOException {
        int i2 = this.m;
        if (i2 + 4 >= this.n) {
            return b(false);
        }
        byte[] bArr = this.T;
        byte b2 = bArr[i2];
        if (b2 == 58) {
            int i3 = i2 + 1;
            this.m = i3;
            byte b3 = bArr[i3];
            if (b3 <= 32) {
                if (b3 == 32 || b3 == 9) {
                    byte[] bArr2 = this.T;
                    int i4 = this.m + 1;
                    this.m = i4;
                    byte b4 = bArr2[i4];
                    if (b4 > 32) {
                        if (b4 == 47 || b4 == 35) {
                            return b(true);
                        }
                        this.m++;
                        return b4;
                    }
                }
                return b(true);
            } else if (b3 == 47 || b3 == 35) {
                return b(true);
            } else {
                this.m++;
                return b3;
            }
        } else {
            if (b2 == 32 || b2 == 9) {
                byte[] bArr3 = this.T;
                int i5 = this.m + 1;
                this.m = i5;
                b2 = bArr3[i5];
            }
            if (b2 != 58) {
                return b(false);
            }
            byte[] bArr4 = this.T;
            int i6 = this.m + 1;
            this.m = i6;
            byte b5 = bArr4[i6];
            if (b5 <= 32) {
                if (b5 == 32 || b5 == 9) {
                    byte[] bArr5 = this.T;
                    int i7 = this.m + 1;
                    this.m = i7;
                    byte b6 = bArr5[i7];
                    if (b6 > 32) {
                        if (b6 == 47 || b6 == 35) {
                            return b(true);
                        }
                        this.m++;
                        return b6;
                    }
                }
                return b(true);
            } else if (b5 == 47 || b5 == 35) {
                return b(true);
            } else {
                this.m++;
                return b5;
            }
        }
    }

    private final void ga() throws IOException {
        if (!a(e.a.ALLOW_COMMENTS)) {
            a(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
            throw null;
        } else if (this.m < this.n || R()) {
            byte[] bArr = this.T;
            int i2 = this.m;
            this.m = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (b2 == 47) {
                ha();
            } else if (b2 == 42) {
                ea();
            } else {
                a((int) b2, "was expecting either '*' or '/' for a comment");
                throw null;
            }
        } else {
            f(" in a comment");
            throw null;
        }
    }

    private final void ha() throws IOException {
        int[] d2 = a.d();
        while (true) {
            if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i2 = this.m;
                this.m = i2 + 1;
                byte b2 = bArr[i2] & 255;
                int i3 = d2[b2];
                if (i3 != 0) {
                    if (i3 == 2) {
                        t(b2);
                    } else if (i3 == 3) {
                        u(b2);
                    } else if (i3 == 4) {
                        v(b2);
                    } else if (i3 == 10) {
                        this.p++;
                        this.q = this.m;
                        return;
                    } else if (i3 == 13) {
                        aa();
                        return;
                    } else if (i3 != 42 && i3 < 0) {
                        k(b2);
                        throw null;
                    }
                }
            } else {
                return;
            }
        }
    }

    private final int ia() throws IOException {
        while (true) {
            int i2 = this.m;
            if (i2 >= this.n) {
                return ja();
            }
            byte[] bArr = this.T;
            this.m = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (b2 > 32) {
                if (b2 != 47 && b2 != 35) {
                    return b2;
                }
                this.m--;
                return ja();
            } else if (b2 != 32) {
                if (b2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (b2 == 13) {
                    aa();
                } else if (b2 != 9) {
                    d((int) b2);
                    throw null;
                }
            }
        }
    }

    private final int ja() throws IOException {
        byte b2;
        while (true) {
            if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i2 = this.m;
                this.m = i2 + 1;
                b2 = bArr[i2] & 255;
                if (b2 > 32) {
                    if (b2 == 47) {
                        ga();
                    } else if (b2 != 35 || !ma()) {
                        return b2;
                    }
                } else if (b2 == 32) {
                    continue;
                } else if (b2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (b2 == 13) {
                    aa();
                } else if (b2 != 9) {
                    d((int) b2);
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
        return b2;
    }

    private final int ka() throws IOException {
        if (this.m >= this.n && !R()) {
            return M();
        }
        byte[] bArr = this.T;
        int i2 = this.m;
        this.m = i2 + 1;
        byte b2 = bArr[i2] & 255;
        if (b2 <= 32) {
            if (b2 != 32) {
                if (b2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (b2 == 13) {
                    aa();
                } else if (b2 != 9) {
                    d((int) b2);
                    throw null;
                }
            }
            while (true) {
                int i3 = this.m;
                if (i3 >= this.n) {
                    return la();
                }
                byte[] bArr2 = this.T;
                this.m = i3 + 1;
                byte b3 = bArr2[i3] & 255;
                if (b3 > 32) {
                    if (b3 != 47 && b3 != 35) {
                        return b3;
                    }
                    this.m--;
                    return la();
                } else if (b3 != 32) {
                    if (b3 == 10) {
                        this.p++;
                        this.q = this.m;
                    } else if (b3 == 13) {
                        aa();
                    } else if (b3 != 9) {
                        d((int) b3);
                        throw null;
                    }
                }
            }
        } else if (b2 != 47 && b2 != 35) {
            return b2;
        } else {
            this.m--;
            return la();
        }
    }

    private final int la() throws IOException {
        byte b2;
        while (true) {
            if (this.m >= this.n && !R()) {
                return M();
            }
            byte[] bArr = this.T;
            int i2 = this.m;
            this.m = i2 + 1;
            b2 = bArr[i2] & 255;
            if (b2 > 32) {
                if (b2 == 47) {
                    ga();
                } else if (b2 != 35 || !ma()) {
                    return b2;
                }
            } else if (b2 == 32) {
                continue;
            } else if (b2 == 10) {
                this.p++;
                this.q = this.m;
            } else if (b2 == 13) {
                aa();
            } else if (b2 != 9) {
                d((int) b2);
                throw null;
            }
        }
        return b2;
    }

    private final boolean ma() throws IOException {
        if (!a(e.a.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        ha();
        return true;
    }

    private final int na() throws IOException {
        if (this.m >= this.n && !R()) {
            return 48;
        }
        byte b2 = this.T[this.m] & 255;
        if (b2 < 48 || b2 > 57) {
            return 48;
        }
        if (a(e.a.ALLOW_NUMERIC_LEADING_ZEROS)) {
            this.m++;
            if (b2 == 48) {
                do {
                    if (this.m >= this.n && !R()) {
                        break;
                    }
                    byte[] bArr = this.T;
                    int i2 = this.m;
                    b2 = bArr[i2] & 255;
                    if (b2 < 48 || b2 > 57) {
                        return 48;
                    }
                    this.m = i2 + 1;
                } while (b2 == 48);
            }
            return b2;
        }
        g("Leading zeroes not allowed");
        throw null;
    }

    private final int o(int i2) throws IOException {
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i3 = this.m;
        this.m = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            return ((i2 & 31) << 6) | (b2 & 63);
        }
        a((int) b2 & 255, this.m);
        throw null;
    }

    private int oa() throws IOException {
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i2 = this.m;
        this.m = i2 + 1;
        return bArr[i2] & 255;
    }

    private final int p(int i2) throws IOException {
        if (this.m >= this.n) {
            S();
        }
        int i3 = i2 & 15;
        byte[] bArr = this.T;
        int i4 = this.m;
        this.m = i4 + 1;
        byte b2 = bArr[i4];
        if ((b2 & 192) == 128) {
            byte b3 = (i3 << 6) | (b2 & 63);
            if (this.m >= this.n) {
                S();
            }
            byte[] bArr2 = this.T;
            int i5 = this.m;
            this.m = i5 + 1;
            byte b4 = bArr2[i5];
            if ((b4 & 192) == 128) {
                return (b3 << 6) | (b4 & 63);
            }
            a((int) b4 & 255, this.m);
            throw null;
        }
        a((int) b2 & 255, this.m);
        throw null;
    }

    private final int q(int i2) throws IOException {
        int i3 = i2 & 15;
        byte[] bArr = this.T;
        int i4 = this.m;
        this.m = i4 + 1;
        byte b2 = bArr[i4];
        if ((b2 & 192) == 128) {
            byte b3 = (i3 << 6) | (b2 & 63);
            int i5 = this.m;
            this.m = i5 + 1;
            byte b4 = bArr[i5];
            if ((b4 & 192) == 128) {
                return (b3 << 6) | (b4 & 63);
            }
            a((int) b4 & 255, this.m);
            throw null;
        }
        a((int) b2 & 255, this.m);
        throw null;
    }

    private final int r(int i2) throws IOException {
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i3 = this.m;
        this.m = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            byte b3 = ((i2 & 7) << 6) | (b2 & 63);
            if (this.m >= this.n) {
                S();
            }
            byte[] bArr2 = this.T;
            int i4 = this.m;
            this.m = i4 + 1;
            byte b4 = bArr2[i4];
            if ((b4 & 192) == 128) {
                byte b5 = (b3 << 6) | (b4 & 63);
                if (this.m >= this.n) {
                    S();
                }
                byte[] bArr3 = this.T;
                int i5 = this.m;
                this.m = i5 + 1;
                byte b6 = bArr3[i5];
                if ((b6 & 192) == 128) {
                    return ((b5 << 6) | (b6 & 63)) - 65536;
                }
                a((int) b6 & 255, this.m);
                throw null;
            }
            a((int) b4 & 255, this.m);
            throw null;
        }
        a((int) b2 & 255, this.m);
        throw null;
    }

    private final g s(int i2) throws IOException {
        if (i2 == 34) {
            this.Q = true;
            g gVar = g.VALUE_STRING;
            this.f4175b = gVar;
            return gVar;
        } else if (i2 == 45) {
            g Z = Z();
            this.f4175b = Z;
            return Z;
        } else if (i2 == 91) {
            this.u = this.u.a(this.s, this.t);
            g gVar2 = g.START_ARRAY;
            this.f4175b = gVar2;
            return gVar2;
        } else if (i2 == 102) {
            a("false", 1);
            g gVar3 = g.VALUE_FALSE;
            this.f4175b = gVar3;
            return gVar3;
        } else if (i2 == 110) {
            a("null", 1);
            g gVar4 = g.VALUE_NULL;
            this.f4175b = gVar4;
            return gVar4;
        } else if (i2 == 116) {
            a("true", 1);
            g gVar5 = g.VALUE_TRUE;
            this.f4175b = gVar5;
            return gVar5;
        } else if (i2 != 123) {
            switch (i2) {
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
                    g j2 = j(i2);
                    this.f4175b = j2;
                    return j2;
                default:
                    g h2 = h(i2);
                    this.f4175b = h2;
                    return h2;
            }
        } else {
            this.u = this.u.b(this.s, this.t);
            g gVar6 = g.START_OBJECT;
            this.f4175b = gVar6;
            return gVar6;
        }
    }

    private final void t(int i2) throws IOException {
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i3 = this.m;
        this.m = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) != 128) {
            a((int) b2 & 255, this.m);
            throw null;
        }
    }

    private final void u(int i2) throws IOException {
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i3 = this.m;
        this.m = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            if (this.m >= this.n) {
                S();
            }
            byte[] bArr2 = this.T;
            int i4 = this.m;
            this.m = i4 + 1;
            byte b3 = bArr2[i4];
            if ((b3 & 192) != 128) {
                a((int) b3 & 255, this.m);
                throw null;
            }
            return;
        }
        a((int) b2 & 255, this.m);
        throw null;
    }

    private final void v(int i2) throws IOException {
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i3 = this.m;
        this.m = i3 + 1;
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            if (this.m >= this.n) {
                S();
            }
            byte[] bArr2 = this.T;
            int i4 = this.m;
            this.m = i4 + 1;
            byte b3 = bArr2[i4];
            if ((b3 & 192) == 128) {
                if (this.m >= this.n) {
                    S();
                }
                byte[] bArr3 = this.T;
                int i5 = this.m;
                this.m = i5 + 1;
                byte b4 = bArr3[i5];
                if ((b4 & 192) != 128) {
                    a((int) b4 & 255, this.m);
                    throw null;
                }
                return;
            }
            a((int) b3 & 255, this.m);
            throw null;
        }
        a((int) b2 & 255, this.m);
        throw null;
    }

    private final void w(int i2) throws IOException {
        this.m++;
        if (i2 != 9) {
            if (i2 == 10) {
                this.p++;
                this.q = this.m;
            } else if (i2 == 13) {
                aa();
            } else if (i2 != 32) {
                c(i2);
                throw null;
            }
        }
    }

    public String E() throws IOException, JsonParseException {
        if (this.f4175b != g.VALUE_STRING) {
            return super.c((String) null);
        }
        if (this.Q) {
            this.Q = false;
            W();
        }
        return this.w.d();
    }

    public g F() throws IOException {
        g gVar;
        this.B = 0;
        if (this.f4175b == g.FIELD_NAME) {
            return da();
        }
        if (this.Q) {
            ba();
        }
        int ka = ka();
        if (ka < 0) {
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
        if (ka == 93) {
            if (this.u.d()) {
                this.u = this.u.i();
                g gVar2 = g.END_ARRAY;
                this.f4175b = gVar2;
                return gVar2;
            }
            a(ka, '}');
            throw null;
        } else if (ka != 125) {
            if (this.u.g()) {
                if (ka == 44) {
                    ka = ia();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("was expecting comma to separate ");
                    sb.append(this.u.c());
                    sb.append(" entries");
                    a(ka, sb.toString());
                    throw null;
                }
            }
            if (!this.u.e()) {
                return s(ka);
            }
            this.u.a(i(ka).a());
            this.f4175b = g.FIELD_NAME;
            int fa = fa();
            if (fa == 34) {
                this.Q = true;
                this.v = g.VALUE_STRING;
                return this.f4175b;
            }
            if (fa == 45) {
                gVar = Z();
            } else if (fa == 91) {
                gVar = g.START_ARRAY;
            } else if (fa == 102) {
                a("false", 1);
                gVar = g.VALUE_FALSE;
            } else if (fa == 110) {
                a("null", 1);
                gVar = g.VALUE_NULL;
            } else if (fa == 116) {
                a("true", 1);
                gVar = g.VALUE_TRUE;
            } else if (fa != 123) {
                switch (fa) {
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
                        gVar = j(fa);
                        break;
                    default:
                        gVar = h(fa);
                        break;
                }
            } else {
                gVar = g.START_OBJECT;
            }
            this.v = gVar;
            return this.f4175b;
        } else if (this.u.e()) {
            this.u = this.u.i();
            g gVar3 = g.END_OBJECT;
            this.f4175b = gVar3;
            return gVar3;
        } else {
            a(ka, ']');
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void L() throws IOException {
        if (this.S != null) {
            if (this.f4173k.h() || a(e.a.AUTO_CLOSE_SOURCE)) {
                this.S.close();
            }
            this.S = null;
        }
    }

    /* access modifiers changed from: protected */
    public void N() throws IOException {
        super.N();
        this.O.d();
        if (this.U) {
            byte[] bArr = this.T;
            if (bArr != null) {
                this.T = com.fasterxml.jackson.core.e.b.f4364a;
                this.f4173k.a(bArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean R() throws IOException {
        long j2 = this.o;
        int i2 = this.n;
        this.o = j2 + ((long) i2);
        this.q -= i2;
        InputStream inputStream = this.S;
        if (inputStream != null) {
            byte[] bArr = this.T;
            int length = bArr.length;
            if (length == 0) {
                return false;
            }
            int read = inputStream.read(bArr, 0, length);
            if (read > 0) {
                this.m = 0;
                this.n = read;
                return true;
            }
            L();
            if (read == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("InputStream.read() returned 0 characters when trying to read ");
                sb.append(this.T.length);
                sb.append(" bytes");
                throw new IOException(sb.toString());
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public char V() throws IOException {
        String str = " in character escape sequence";
        if (this.m < this.n || R()) {
            byte[] bArr = this.T;
            int i2 = this.m;
            this.m = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 == 34 || b2 == 47 || b2 == 92) {
                return (char) b2;
            }
            if (b2 == 98) {
                return 8;
            }
            if (b2 == 102) {
                return 12;
            }
            if (b2 == 110) {
                return 10;
            }
            if (b2 == 114) {
                return 13;
            }
            if (b2 == 116) {
                return 9;
            }
            if (b2 != 117) {
                char f2 = (char) f(b2);
                a(f2);
                return f2;
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < 4) {
                if (this.m < this.n || R()) {
                    byte[] bArr2 = this.T;
                    int i5 = this.m;
                    this.m = i5 + 1;
                    byte b3 = bArr2[i5];
                    int a2 = a.a(b3);
                    if (a2 >= 0) {
                        i4 = (i4 << 4) | a2;
                        i3++;
                    } else {
                        a((int) b3, "expected a hex-digit for character escape sequence");
                        throw null;
                    }
                } else {
                    f(str);
                    throw null;
                }
            }
            return (char) i4;
        }
        f(str);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void W() throws IOException {
        int i2 = this.m;
        if (i2 >= this.n) {
            S();
            i2 = this.m;
        }
        int i3 = 0;
        char[] e2 = this.w.e();
        int[] iArr = L;
        int min = Math.min(this.n, e2.length + i2);
        byte[] bArr = this.T;
        while (true) {
            if (i2 >= min) {
                break;
            }
            byte b2 = bArr[i2] & 255;
            if (iArr[b2] == 0) {
                i2++;
                int i4 = i3 + 1;
                e2[i3] = (char) b2;
                i3 = i4;
            } else if (b2 == 34) {
                this.m = i2 + 1;
                this.w.a(i3);
                return;
            }
        }
        this.m = i2;
        a(e2, i3);
    }

    /* access modifiers changed from: protected */
    public g X() throws IOException {
        char[] e2 = this.w.e();
        int[] iArr = L;
        byte[] bArr = this.T;
        int i2 = 0;
        while (true) {
            if (this.m >= this.n) {
                S();
            }
            if (i2 >= e2.length) {
                e2 = this.w.g();
                i2 = 0;
            }
            int i3 = this.n;
            int length = this.m + (e2.length - i2);
            if (length < i3) {
                i3 = length;
            }
            while (true) {
                int i4 = this.m;
                if (i4 >= i3) {
                    break;
                }
                this.m = i4 + 1;
                int i5 = bArr[i4] & 255;
                if (i5 != 39 && iArr[i5] == 0) {
                    int i6 = i2 + 1;
                    e2[i2] = (char) i5;
                    i2 = i6;
                } else if (i5 == 39) {
                    this.w.a(i2);
                    return g.VALUE_STRING;
                } else {
                    int i7 = iArr[i5];
                    if (i7 != 1) {
                        if (i7 == 2) {
                            i5 = o(i5);
                        } else if (i7 != 3) {
                            if (i7 != 4) {
                                if (i5 < 32) {
                                    b(i5, "string value");
                                }
                                k(i5);
                                throw null;
                            }
                            int r = r(i5);
                            int i8 = i2 + 1;
                            e2[i2] = (char) (55296 | (r >> 10));
                            if (i8 >= e2.length) {
                                e2 = this.w.g();
                                i8 = 0;
                            }
                            int i9 = i8;
                            i5 = 56320 | (r & 1023);
                            i2 = i9;
                        } else if (this.n - this.m >= 2) {
                            i5 = q(i5);
                        } else {
                            i5 = p(i5);
                        }
                    } else if (i5 != 39) {
                        i5 = V();
                    }
                    if (i2 >= e2.length) {
                        e2 = this.w.g();
                        i2 = 0;
                    }
                    int i10 = i2 + 1;
                    e2[i2] = (char) i5;
                    i2 = i10;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r8v18 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r8v3
      assigns: []
      uses: []
      mth insns count: 121
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
    /* JADX WARNING: Unknown variable types count: 2 */
    public f Y() throws IOException {
        int i2;
        ? r0;
        int i3;
        int i4;
        int i5;
        if (this.m < this.n || R()) {
            byte[] bArr = this.T;
            int i6 = this.m;
            this.m = i6 + 1;
            int i7 = bArr[i6] & 255;
            if (i7 == 39) {
                return com.fasterxml.jackson.core.d.a.b();
            }
            int[] iArr = this.P;
            int[] iArr2 = M;
            int[] iArr3 = iArr;
            int i8 = 0;
            int i9 = 0;
            ? r8 = 0;
            while (r0 != 39) {
                if (!(r0 == 34 || iArr2[r0] == 0)) {
                    if (r0 != 92) {
                        b((int) r0, "name");
                    } else {
                        r0 = V();
                    }
                    if (r0 > 127) {
                        if (i2 >= 4) {
                            if (i9 >= iArr3.length) {
                                iArr3 = a(iArr3, iArr3.length);
                                this.P = iArr3;
                            }
                            int i10 = i9 + 1;
                            iArr3[i9] = r8;
                            i9 = i10;
                            i2 = 0;
                            r8 = 0;
                        }
                        if (r0 < 2048) {
                            i5 = (r8 << 8) | (r0 >> 6) | 192;
                            i2++;
                        } else {
                            int i11 = (r8 << 8) | (r0 >> 12) | 224;
                            int i12 = i2 + 1;
                            if (i12 >= 4) {
                                if (i9 >= iArr3.length) {
                                    int[] a2 = a(iArr3, iArr3.length);
                                    this.P = a2;
                                    iArr3 = a2;
                                }
                                int i13 = i9 + 1;
                                iArr3[i9] = i11;
                                i9 = i13;
                                i12 = 0;
                                i11 = 0;
                            }
                            i5 = (i11 << 8) | ((r0 >> 6) & 63) | 128;
                            i2 = i12 + 1;
                        }
                        r0 = (r0 & true) | true;
                    }
                }
                if (i2 < 4) {
                    i8 = i2 + 1;
                    i4 = r0 | (r8 << 8);
                } else {
                    if (i9 >= iArr3.length) {
                        iArr3 = a(iArr3, iArr3.length);
                        this.P = iArr3;
                    }
                    int i14 = i9 + 1;
                    iArr3[i9] = r8;
                    i4 = r0;
                    i9 = i14;
                    i8 = 1;
                }
                if (this.m < this.n || R()) {
                    byte[] bArr2 = this.T;
                    int i15 = this.m;
                    this.m = i15 + 1;
                    i7 = bArr2[i15] & 255;
                    r8 = i4;
                } else {
                    f(" in field name");
                    throw null;
                }
            }
            if (i2 > 0) {
                if (i9 >= iArr3.length) {
                    int[] a3 = a(iArr3, iArr3.length);
                    this.P = a3;
                    iArr3 = a3;
                }
                i3 = i9 + 1;
                iArr3[i9] = d(r8, i2);
            } else {
                i3 = i9;
            }
            f b2 = this.O.b(iArr3, i3);
            if (b2 == null) {
                b2 = a(iArr3, i3, i2);
            }
            return b2;
        }
        f(": was expecting closing ''' for name");
        throw null;
    }

    /* access modifiers changed from: protected */
    public g Z() throws IOException {
        byte b2;
        char[] e2 = this.w.e();
        e2[0] = '-';
        if (this.m >= this.n) {
            S();
        }
        byte[] bArr = this.T;
        int i2 = this.m;
        this.m = i2 + 1;
        int i3 = bArr[i2] & 255;
        if (i3 < 48 || i3 > 57) {
            return a(i3, true);
        }
        if (i3 == 48) {
            i3 = na();
        }
        int i4 = 2;
        e2[1] = (char) i3;
        int length = (this.m + e2.length) - 2;
        int i5 = this.n;
        if (length > i5) {
            length = i5;
        }
        int i6 = 1;
        while (true) {
            int i7 = this.m;
            if (i7 >= length) {
                return a(e2, i4, true, i6);
            }
            byte[] bArr2 = this.T;
            this.m = i7 + 1;
            b2 = bArr2[i7] & 255;
            if (b2 >= 48 && b2 <= 57) {
                i6++;
                int i8 = i4 + 1;
                e2[i4] = (char) b2;
                i4 = i8;
            }
        }
        if (b2 == 46 || b2 == 101 || b2 == 69) {
            return a(e2, i4, (int) b2, true, i6);
        }
        this.m--;
        this.w.a(i4);
        if (this.u.f()) {
            w(b2);
        }
        return a(true, i6);
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
    public final void aa() throws IOException {
        if (this.m < this.n || R()) {
            byte[] bArr = this.T;
            int i2 = this.m;
            if (bArr[i2] == 10) {
                this.m = i2 + 1;
            }
        }
        this.p++;
        this.q = this.m;
    }

    public d b() {
        d dVar = new d(this.f4173k.g(), this.o + ((long) this.m), -1, this.p, (this.m - this.q) + 1);
        return dVar;
    }

    /* access modifiers changed from: protected */
    public void ba() throws IOException {
        this.Q = false;
        int[] iArr = L;
        byte[] bArr = this.T;
        while (true) {
            int i2 = this.m;
            int i3 = this.n;
            if (i2 >= i3) {
                S();
                i2 = this.m;
                i3 = this.n;
            }
            while (true) {
                if (i2 >= i3) {
                    this.m = i2;
                    break;
                }
                int i4 = i2 + 1;
                byte b2 = bArr[i2] & 255;
                if (iArr[b2] != 0) {
                    this.m = i4;
                    if (b2 != 34) {
                        int i5 = iArr[b2];
                        if (i5 == 1) {
                            V();
                        } else if (i5 == 2) {
                            t(b2);
                        } else if (i5 == 3) {
                            u(b2);
                        } else if (i5 == 4) {
                            v(b2);
                        } else if (b2 < 32) {
                            b((int) b2, "string value");
                        } else {
                            k(b2);
                            throw null;
                        }
                    } else {
                        return;
                    }
                } else {
                    i2 = i4;
                }
            }
        }
    }

    public String c(String str) throws IOException, JsonParseException {
        if (this.f4175b != g.VALUE_STRING) {
            return super.c(str);
        }
        if (this.Q) {
            this.Q = false;
            W();
        }
        return this.w.d();
    }

    /* access modifiers changed from: protected */
    public f ca() throws IOException {
        if (this.m < this.n || R()) {
            byte[] bArr = this.T;
            int i2 = this.m;
            this.m = i2 + 1;
            byte b2 = bArr[i2] & 255;
            if (b2 == 34) {
                return com.fasterxml.jackson.core.d.a.b();
            }
            return a(this.P, 0, 0, (int) b2, 0);
        }
        f(": was expecting closing '\"' for name");
        throw null;
    }

    /* access modifiers changed from: protected */
    public int f(int i2) throws IOException {
        int i3;
        char c2;
        int i4 = i2 & 255;
        if (i4 <= 127) {
            return i4;
        }
        if ((i4 & 224) == 192) {
            i3 = i4 & 31;
            c2 = 1;
        } else if ((i4 & 240) == 224) {
            i3 = i4 & 15;
            c2 = 2;
        } else if ((i4 & 248) == 240) {
            i3 = i4 & 7;
            c2 = 3;
        } else {
            l(i4 & 255);
            throw null;
        }
        int oa = oa();
        if ((oa & 192) == 128) {
            int i5 = (i3 << 6) | (oa & 63);
            if (c2 <= 1) {
                return i5;
            }
            int oa2 = oa();
            if ((oa2 & 192) == 128) {
                int i6 = (i5 << 6) | (oa2 & 63);
                if (c2 <= 2) {
                    return i6;
                }
                int oa3 = oa();
                if ((oa3 & 192) == 128) {
                    return (i6 << 6) | (oa3 & 63);
                }
                m(oa3 & 255);
                throw null;
            }
            m(oa2 & 255);
            throw null;
        }
        m(oa & 255);
        throw null;
    }

    /* access modifiers changed from: protected */
    public f g(int i2) throws IOException {
        if (i2 == 39 && a(e.a.ALLOW_SINGLE_QUOTES)) {
            return Y();
        }
        if (a(e.a.ALLOW_UNQUOTED_FIELD_NAMES)) {
            int[] h2 = a.h();
            if (h2[i2] == 0) {
                int[] iArr = this.P;
                int i3 = 0;
                byte b2 = i2;
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i3 < 4) {
                        i3++;
                        i5 = (i5 << 8) | b2;
                    } else {
                        if (i4 >= iArr.length) {
                            iArr = a(iArr, iArr.length);
                            this.P = iArr;
                        }
                        int i6 = i4 + 1;
                        iArr[i4] = i5;
                        i4 = i6;
                        i5 = b2;
                        i3 = 1;
                    }
                    if (this.m < this.n || R()) {
                        byte[] bArr = this.T;
                        int i7 = this.m;
                        b2 = bArr[i7] & 255;
                        if (h2[b2] != 0) {
                            if (i3 > 0) {
                                if (i4 >= iArr.length) {
                                    int[] a2 = a(iArr, iArr.length);
                                    this.P = a2;
                                    iArr = a2;
                                }
                                int i8 = i4 + 1;
                                iArr[i4] = i5;
                                i4 = i8;
                            }
                            f b3 = this.O.b(iArr, i4);
                            if (b3 == null) {
                                b3 = a(iArr, i4, i3);
                            }
                            return b3;
                        }
                        this.m = i7 + 1;
                    } else {
                        f(" in field name");
                        throw null;
                    }
                }
            } else {
                a(i2, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
                throw null;
            }
        } else {
            a((int) (char) f(i2), "was expecting double-quote to start field name");
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public g h(int i2) throws IOException {
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
                } else if (i2 == 93 || i2 == 125) {
                    a(i2, "expected a value");
                    throw null;
                }
            } else if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i3 = this.m;
                this.m = i3 + 1;
                return a((int) bArr[i3] & 255, false);
            } else {
                J();
                throw null;
            }
        } else if (a(e.a.ALLOW_SINGLE_QUOTES)) {
            return X();
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
    public final f i(int i2) throws IOException {
        if (i2 != 34) {
            return g(i2);
        }
        int i3 = this.m;
        if (i3 + 9 > this.n) {
            return ca();
        }
        byte[] bArr = this.T;
        int[] iArr = M;
        this.m = i3 + 1;
        byte b2 = bArr[i3] & 255;
        if (iArr[b2] == 0) {
            int i4 = this.m;
            this.m = i4 + 1;
            byte b3 = bArr[i4] & 255;
            if (iArr[b3] == 0) {
                byte b4 = (b2 << 8) | b3;
                int i5 = this.m;
                this.m = i5 + 1;
                byte b5 = bArr[i5] & 255;
                if (iArr[b5] == 0) {
                    byte b6 = (b4 << 8) | b5;
                    int i6 = this.m;
                    this.m = i6 + 1;
                    byte b7 = bArr[i6] & 255;
                    if (iArr[b7] == 0) {
                        byte b8 = (b6 << 8) | b7;
                        int i7 = this.m;
                        this.m = i7 + 1;
                        byte b9 = bArr[i7] & 255;
                        if (iArr[b9] == 0) {
                            this.R = b8;
                            return n(b9);
                        } else if (b9 == 34) {
                            return c(b8, 4);
                        } else {
                            return b(b8, b9, 4);
                        }
                    } else if (b7 == 34) {
                        return c(b6, 3);
                    } else {
                        return b(b6, b7, 3);
                    }
                } else if (b5 == 34) {
                    return c(b4, 2);
                } else {
                    return b(b4, b5, 2);
                }
            } else if (b3 == 34) {
                return c(b2, 1);
            } else {
                return b(b2, b3, 1);
            }
        } else if (b2 == 34) {
            return com.fasterxml.jackson.core.d.a.b();
        } else {
            return b(0, b2, 0);
        }
    }

    public String j() throws IOException, JsonParseException {
        g gVar = this.f4175b;
        if (gVar != g.VALUE_STRING) {
            return a(gVar);
        }
        if (this.Q) {
            this.Q = false;
            W();
        }
        return this.w.d();
    }

    /* access modifiers changed from: protected */
    public void k(int i2) throws JsonParseException {
        if (i2 < 32) {
            d(i2);
            throw null;
        } else {
            l(i2);
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void l(int i2) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 start byte 0x");
        sb.append(Integer.toHexString(i2));
        e(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void m(int i2) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 middle byte 0x");
        sb.append(Integer.toHexString(i2));
        e(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public final f n(int i2) throws IOException {
        byte[] bArr = this.T;
        int[] iArr = M;
        int i3 = this.m;
        this.m = i3 + 1;
        byte b2 = bArr[i3] & 255;
        if (iArr[b2] == 0) {
            byte b3 = (i2 << 8) | b2;
            int i4 = this.m;
            this.m = i4 + 1;
            byte b4 = bArr[i4] & 255;
            if (iArr[b4] == 0) {
                byte b5 = (b3 << 8) | b4;
                int i5 = this.m;
                this.m = i5 + 1;
                byte b6 = bArr[i5] & 255;
                if (iArr[b6] == 0) {
                    byte b7 = (b5 << 8) | b6;
                    int i6 = this.m;
                    this.m = i6 + 1;
                    byte b8 = bArr[i6] & 255;
                    if (iArr[b8] == 0) {
                        return b((int) b8, (int) b7);
                    }
                    if (b8 == 34) {
                        return a(this.R, (int) b7, 4);
                    }
                    return a(this.R, (int) b7, (int) b8, 4);
                } else if (b6 == 34) {
                    return a(this.R, (int) b5, 3);
                } else {
                    return a(this.R, (int) b5, (int) b6, 3);
                }
            } else if (b4 == 34) {
                return a(this.R, (int) b3, 2);
            } else {
                return a(this.R, (int) b3, (int) b4, 2);
            }
        } else if (b2 == 34) {
            return a(this.R, i2, 1);
        } else {
            return a(this.R, i2, (int) b2, 1);
        }
    }

    /* access modifiers changed from: protected */
    public final f b(int i2, int i3) throws IOException {
        int[] iArr = this.P;
        iArr[0] = this.R;
        iArr[1] = i3;
        byte[] bArr = this.T;
        int[] iArr2 = M;
        byte b2 = i2;
        int i4 = 2;
        while (true) {
            int i5 = this.m;
            if (i5 + 4 <= this.n) {
                this.m = i5 + 1;
                byte b3 = bArr[i5] & 255;
                if (iArr2[b3] == 0) {
                    byte b4 = (b2 << 8) | b3;
                    int i6 = this.m;
                    this.m = i6 + 1;
                    byte b5 = bArr[i6] & 255;
                    if (iArr2[b5] == 0) {
                        byte b6 = (b4 << 8) | b5;
                        int i7 = this.m;
                        this.m = i7 + 1;
                        byte b7 = bArr[i7] & 255;
                        if (iArr2[b7] == 0) {
                            int i8 = (b6 << 8) | b7;
                            int i9 = this.m;
                            this.m = i9 + 1;
                            b2 = bArr[i9] & 255;
                            if (iArr2[b2] == 0) {
                                int[] iArr3 = this.P;
                                if (i4 >= iArr3.length) {
                                    this.P = a(iArr3, i4);
                                }
                                int i10 = i4 + 1;
                                this.P[i4] = i8;
                                i4 = i10;
                            } else if (b2 == 34) {
                                return a(this.P, i4, i8, 4);
                            } else {
                                return a(this.P, i4, i8, (int) b2, 4);
                            }
                        } else if (b7 == 34) {
                            return a(this.P, i4, (int) b6, 3);
                        } else {
                            return a(this.P, i4, (int) b6, (int) b7, 3);
                        }
                    } else if (b5 == 34) {
                        return a(this.P, i4, (int) b4, 2);
                    } else {
                        return a(this.P, i4, (int) b4, (int) b5, 2);
                    }
                } else if (b3 == 34) {
                    return a(this.P, i4, b2, 1);
                } else {
                    return a(this.P, i4, b2, (int) b3, 1);
                }
            } else {
                return a(this.P, i4, 0, b2, 0);
            }
        }
    }

    private final g a(char[] cArr, int i2, boolean z, int i3) throws IOException {
        byte b2;
        char[] cArr2 = cArr;
        int i4 = i2;
        int i5 = i3;
        while (true) {
            if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i6 = this.m;
                this.m = i6 + 1;
                b2 = bArr[i6] & 255;
                if (b2 <= 57 && b2 >= 48) {
                    if (i4 >= cArr2.length) {
                        i4 = 0;
                        cArr2 = this.w.g();
                    }
                    int i7 = i4 + 1;
                    cArr2[i4] = (char) b2;
                    i5++;
                    i4 = i7;
                }
            } else {
                this.w.a(i4);
                return a(z, i5);
            }
        }
        if (b2 == 46 || b2 == 101 || b2 == 69) {
            return a(cArr2, i4, (int) b2, z, i5);
        }
        this.m--;
        this.w.a(i4);
        if (this.u.f()) {
            byte[] bArr2 = this.T;
            int i8 = this.m;
            this.m = i8 + 1;
            w(bArr2[i8] & 255);
        }
        return a(z, i5);
    }

    private final f c(int i2, int i3) throws JsonParseException {
        int d2 = d(i2, i3);
        f c2 = this.O.c(d2);
        if (c2 != null) {
            return c2;
        }
        int[] iArr = this.P;
        iArr[0] = d2;
        return a(iArr, 1, i3);
    }

    /* access modifiers changed from: protected */
    public g j(int i2) throws IOException {
        byte b2;
        char[] e2 = this.w.e();
        if (i2 == 48) {
            i2 = na();
        }
        e2[0] = (char) i2;
        int length = (this.m + e2.length) - 1;
        int i3 = this.n;
        if (length > i3) {
            length = i3;
        }
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int i6 = this.m;
            if (i6 >= length) {
                return a(e2, i4, false, i5);
            }
            byte[] bArr = this.T;
            this.m = i6 + 1;
            b2 = bArr[i6] & 255;
            if (b2 >= 48 && b2 <= 57) {
                i5++;
                int i7 = i4 + 1;
                e2[i4] = (char) b2;
                i4 = i7;
            }
        }
        if (b2 == 46 || b2 == 101 || b2 == 69) {
            return a(e2, i4, (int) b2, false, i5);
        }
        this.m--;
        this.w.a(i4);
        if (this.u.f()) {
            w(b2);
        }
        return a(false, i5);
    }

    private final g a(char[] cArr, int i2, int i3, boolean z, int i4) throws IOException {
        boolean z2;
        int i5;
        char[] cArr2;
        int i6;
        byte b2;
        int i7;
        int i8 = i3;
        int i9 = 0;
        if (i8 == 46) {
            i6 = i2 + 1;
            cArr[i2] = (char) i8;
            cArr2 = cArr;
            byte b3 = i8;
            int i10 = 0;
            while (true) {
                if (this.m >= this.n && !R()) {
                    z2 = true;
                    break;
                }
                byte[] bArr = this.T;
                int i11 = this.m;
                this.m = i11 + 1;
                b3 = bArr[i11] & 255;
                if (b3 < 48 || b3 > 57) {
                    z2 = false;
                } else {
                    i10++;
                    if (i6 >= cArr2.length) {
                        cArr2 = this.w.g();
                        i6 = 0;
                    }
                    int i12 = i6 + 1;
                    cArr2[i6] = (char) b3;
                    i6 = i12;
                }
            }
            z2 = false;
            if (i10 != 0) {
                int i13 = b3;
                i5 = i10;
                i8 = i13;
            } else {
                c(b3, "Decimal point not followed by a digit");
                throw null;
            }
        } else {
            cArr2 = cArr;
            i6 = i2;
            i5 = 0;
            z2 = false;
        }
        if (b2 == 101 || b2 == 69) {
            if (i6 >= cArr2.length) {
                cArr2 = this.w.g();
                i6 = 0;
            }
            int i14 = i6 + 1;
            cArr2[i6] = (char) b2;
            if (this.m >= this.n) {
                S();
            }
            byte[] bArr2 = this.T;
            int i15 = this.m;
            this.m = i15 + 1;
            b2 = bArr2[i15] & 255;
            if (b2 == 45 || b2 == 43) {
                if (i14 >= cArr2.length) {
                    cArr2 = this.w.g();
                    i14 = 0;
                }
                int i16 = i14 + 1;
                cArr2[i14] = (char) b2;
                if (this.m >= this.n) {
                    S();
                }
                byte[] bArr3 = this.T;
                int i17 = this.m;
                this.m = i17 + 1;
                b2 = bArr3[i17] & 255;
                i14 = i16;
            }
            int i18 = 0;
            while (true) {
                if (b2 <= 57 && b2 >= 48) {
                    i18++;
                    if (i14 >= cArr2.length) {
                        cArr2 = this.w.g();
                        i14 = 0;
                    }
                    int i19 = i14 + 1;
                    cArr2[i14] = (char) b2;
                    if (this.m >= this.n && !R()) {
                        i9 = i18;
                        i7 = i19;
                        z2 = true;
                        break;
                    }
                    byte[] bArr4 = this.T;
                    int i20 = this.m;
                    this.m = i20 + 1;
                    b2 = bArr4[i20] & 255;
                    i14 = i19;
                } else {
                    i9 = i18;
                    i7 = i14;
                }
            }
            i9 = i18;
            i7 = i14;
            if (i9 == 0) {
                c(b2, "Exponent indicator not followed by a digit");
                throw null;
            }
        }
        if (!z2) {
            this.m--;
            if (this.u.f()) {
                w(b2);
            }
        }
        this.w.a(i6);
        return b(z, i4, i5, i9);
    }

    /* access modifiers changed from: protected */
    public void h(String str) throws IOException {
        a(str, "'null', 'true', 'false' or NaN");
        throw null;
    }

    private final f b(int i2, int i3, int i4) throws IOException {
        return a(this.P, 0, i2, i3, i4);
    }

    private final void b(String str, int i2) throws IOException {
        int length = str.length();
        do {
            if ((this.m < this.n || R()) && this.T[this.m] == str.charAt(i2)) {
                this.m++;
                i2++;
            } else {
                h(str.substring(0, i2));
                throw null;
            }
        } while (i2 < length);
        if (this.m < this.n || R()) {
            byte b2 = this.T[this.m] & 255;
            if (!(b2 < 48 || b2 == 93 || b2 == 125)) {
                a(str, i2, (int) b2);
            }
        }
    }

    private final int b(boolean z) throws IOException {
        while (true) {
            if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i2 = this.m;
                this.m = i2 + 1;
                byte b2 = bArr[i2] & 255;
                if (b2 > 32) {
                    if (b2 == 47) {
                        ga();
                    } else if (b2 != 35 || !ma()) {
                        if (z) {
                            return b2;
                        }
                        if (b2 == 58) {
                            z = true;
                        } else if (b2 < 32) {
                            d((int) b2);
                            throw null;
                        } else {
                            a((int) b2, "was expecting a colon to separate field name and value");
                            throw null;
                        }
                    }
                } else if (b2 == 32) {
                    continue;
                } else if (b2 == 10) {
                    this.p++;
                    this.q = this.m;
                } else if (b2 == 13) {
                    aa();
                } else if (b2 != 9) {
                    d((int) b2);
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
    }

    private final f a(int i2, int i3, int i4, int i5) throws IOException {
        int[] iArr = this.P;
        iArr[0] = i2;
        return a(iArr, 1, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public final f a(int[] iArr, int i2, int i3, int i4, int i5) throws IOException {
        int[] iArr2 = M;
        while (true) {
            if (iArr2[i4] != 0) {
                if (i4 == 34) {
                    if (r10 > 0) {
                        if (i2 >= iArr.length) {
                            iArr = a(iArr, iArr.length);
                            this.P = iArr;
                        }
                        int i6 = i2 + 1;
                        iArr[i2] = d(r8, r10);
                        i2 = i6;
                    }
                    f b2 = this.O.b(iArr, i2);
                    return b2 == null ? a(iArr, i2, r10) : b2;
                }
                if (i4 != 92) {
                    b(i4, "name");
                } else {
                    i4 = V();
                }
                if (i4 > 127) {
                    if (r10 >= 4) {
                        if (i2 >= iArr.length) {
                            iArr = a(iArr, iArr.length);
                            this.P = iArr;
                        }
                        int i7 = i2 + 1;
                        iArr[i2] = r8;
                        i2 = i7;
                        r8 = 0;
                        r10 = 0;
                    }
                    if (i4 < 2048) {
                        r8 = (r8 << 8) | (i4 >> 6) | 192;
                        r10++;
                    } else {
                        int i8 = (r8 << 8) | (i4 >> 12) | 224;
                        int i9 = r10 + 1;
                        if (i9 >= 4) {
                            if (i2 >= iArr.length) {
                                iArr = a(iArr, iArr.length);
                                this.P = iArr;
                            }
                            int i10 = i2 + 1;
                            iArr[i2] = i8;
                            i2 = i10;
                            i8 = 0;
                            i9 = 0;
                        }
                        r8 = (i8 << 8) | ((i4 >> 6) & 63) | 128;
                        r10 = i9 + 1;
                    }
                    i4 = (i4 & 63) | 128;
                }
            }
            if (r10 < 4) {
                i5 = r10 + 1;
                i3 = (r8 << 8) | i4;
            } else {
                if (i2 >= iArr.length) {
                    iArr = a(iArr, iArr.length);
                    this.P = iArr;
                }
                int i11 = i2 + 1;
                iArr[i2] = r8;
                i3 = i4;
                i2 = i11;
                i5 = 1;
            }
            if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i12 = this.m;
                this.m = i12 + 1;
                i4 = bArr[i12] & 255;
            } else {
                f(" in field name");
                throw null;
            }
        }
    }

    private final f a(int i2, int i3, int i4) throws JsonParseException {
        int d2 = d(i3, i4);
        f b2 = this.O.b(i2, d2);
        if (b2 != null) {
            return b2;
        }
        int[] iArr = this.P;
        iArr[0] = i2;
        iArr[1] = d2;
        return a(iArr, 2, i4);
    }

    private final f a(int[] iArr, int i2, int i3, int i4) throws JsonParseException {
        if (i2 >= iArr.length) {
            iArr = a(iArr, iArr.length);
            this.P = iArr;
        }
        int i5 = i2 + 1;
        iArr[i2] = d(i3, i4);
        f b2 = this.O.b(iArr, i5);
        return b2 == null ? a(iArr, i5, i4) : b2;
    }

    private final f a(int[] iArr, int i2, int i3) throws JsonParseException {
        int i4;
        int i5;
        int i6;
        int[] iArr2 = iArr;
        int i7 = i2;
        int i8 = i3;
        int i9 = ((i7 << 2) - 4) + i8;
        if (i8 < 4) {
            int i10 = i7 - 1;
            i4 = iArr2[i10];
            iArr2[i10] = i4 << ((4 - i8) << 3);
        } else {
            i4 = 0;
        }
        char[] e2 = this.w.e();
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            int i13 = (iArr2[i11 >> 2] >> ((3 - (i11 & 3)) << 3)) & 255;
            i11++;
            if (i13 > 127) {
                if ((i13 & 224) == 192) {
                    i5 = i13 & 31;
                    i6 = 1;
                } else if ((i13 & 240) == 224) {
                    i5 = i13 & 15;
                    i6 = 2;
                } else if ((i13 & 248) == 240) {
                    i5 = i13 & 7;
                    i6 = 3;
                } else {
                    l(i13);
                    throw null;
                }
                if (i11 + i6 <= i9) {
                    int i14 = iArr2[i11 >> 2] >> ((3 - (i11 & 3)) << 3);
                    i11++;
                    if ((i14 & 192) == 128) {
                        int i15 = (i5 << 6) | (i14 & 63);
                        if (i6 > 1) {
                            int i16 = iArr2[i11 >> 2] >> ((3 - (i11 & 3)) << 3);
                            i11++;
                            if ((i16 & 192) == 128) {
                                int i17 = (i16 & 63) | (i15 << 6);
                                if (i6 > 2) {
                                    int i18 = iArr2[i11 >> 2] >> ((3 - (i11 & 3)) << 3);
                                    i11++;
                                    if ((i18 & 192) == 128) {
                                        i15 = (i17 << 6) | (i18 & 63);
                                    } else {
                                        m(i18 & 255);
                                        throw null;
                                    }
                                } else {
                                    i15 = i17;
                                }
                            } else {
                                m(i16);
                                throw null;
                            }
                        }
                        if (i6 > 2) {
                            int i19 = i15 - 65536;
                            if (i12 >= e2.length) {
                                e2 = this.w.f();
                            }
                            int i20 = i12 + 1;
                            e2[i12] = (char) ((i19 >> 10) + 55296);
                            i13 = (i19 & 1023) | 56320;
                            i12 = i20;
                        } else {
                            i13 = i15;
                        }
                    } else {
                        m(i14);
                        throw null;
                    }
                } else {
                    f(" in field name");
                    throw null;
                }
            }
            if (i12 >= e2.length) {
                e2 = this.w.f();
            }
            int i21 = i12 + 1;
            e2[i12] = (char) i13;
            i12 = i21;
        }
        String str = new String(e2, 0, i12);
        if (i8 < 4) {
            iArr2[i7 - 1] = i4;
        }
        return this.O.a(str, iArr2, i7);
    }

    private final void a(char[] cArr, int i2) throws IOException {
        int[] iArr = L;
        byte[] bArr = this.T;
        while (true) {
            int i3 = this.m;
            if (i3 >= this.n) {
                S();
                i3 = this.m;
            }
            if (i2 >= cArr.length) {
                cArr = this.w.g();
                i2 = 0;
            }
            int min = Math.min(this.n, (cArr.length - i2) + i3);
            while (true) {
                if (i3 >= min) {
                    this.m = i3;
                    break;
                }
                int i4 = i3 + 1;
                int i5 = bArr[i3] & 255;
                if (iArr[i5] != 0) {
                    this.m = i4;
                    if (i5 == 34) {
                        this.w.a(i2);
                        return;
                    }
                    int i6 = iArr[i5];
                    if (i6 == 1) {
                        i5 = V();
                    } else if (i6 == 2) {
                        i5 = o(i5);
                    } else if (i6 != 3) {
                        if (i6 == 4) {
                            int r = r(i5);
                            int i7 = i2 + 1;
                            cArr[i2] = (char) (55296 | (r >> 10));
                            if (i7 >= cArr.length) {
                                cArr = this.w.g();
                                i7 = 0;
                            }
                            i5 = (r & 1023) | 56320;
                            i2 = i7;
                        } else if (i5 < 32) {
                            b(i5, "string value");
                        } else {
                            k(i5);
                            throw null;
                        }
                    } else if (this.n - this.m >= 2) {
                        i5 = q(i5);
                    } else {
                        i5 = p(i5);
                    }
                    if (i2 >= cArr.length) {
                        cArr = this.w.g();
                        i2 = 0;
                    }
                    int i8 = i2 + 1;
                    cArr[i2] = (char) i5;
                    i2 = i8;
                } else {
                    int i9 = i2 + 1;
                    cArr[i2] = (char) i5;
                    i3 = i4;
                    i2 = i9;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=byte, for r4v0, types: [int] */
    public g a(byte b2, boolean z) throws IOException {
        String str;
        if (b2 == 73) {
            if (this.m < this.n || R()) {
                byte[] bArr = this.T;
                int i2 = this.m;
                this.m = i2 + 1;
                b2 = bArr[i2];
                if (b2 == 78) {
                    str = z ? "-INF" : "+INF";
                } else if (b2 == 110) {
                    str = z ? "-Infinity" : "+Infinity";
                }
                a(str, 3);
                if (a(e.a.ALLOW_NON_NUMERIC_NUMBERS)) {
                    return a(str, z ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Non-standard token '");
                sb.append(str);
                sb.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                e(sb.toString());
                throw null;
            }
            J();
            throw null;
        }
        c(b2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void a(String str, int i2) throws IOException {
        int length = str.length();
        if (this.m + length >= this.n) {
            b(str, i2);
            return;
        }
        while (this.T[this.m] == str.charAt(i2)) {
            this.m++;
            i2++;
            if (i2 >= length) {
                byte b2 = this.T[this.m] & 255;
                if (!(b2 < 48 || b2 == 93 || b2 == 125)) {
                    a(str, i2, (int) b2);
                }
                return;
            }
        }
        h(str.substring(0, i2));
        throw null;
    }

    private final void a(String str, int i2, int i3) throws IOException {
        if (Character.isJavaIdentifierPart((char) f(i3))) {
            h(str.substring(0, i2));
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        while (true) {
            if (this.m >= this.n && !R()) {
                break;
            }
            byte[] bArr = this.T;
            int i2 = this.m;
            this.m = i2 + 1;
            char f2 = (char) f(bArr[i2]);
            if (!Character.isJavaIdentifierPart(f2)) {
                break;
            }
            sb.append(f2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unrecognized token '");
        sb2.append(sb.toString());
        sb2.append("': was expecting ");
        sb2.append(str2);
        e(sb2.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) throws JsonParseException {
        this.m = i3;
        m(i2);
        throw null;
    }

    public static int[] a(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        return Arrays.copyOf(iArr, iArr.length + i2);
    }
}
