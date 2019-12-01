package com.fasterxml.jackson.core.a;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.c.d;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.e.a;
import com.fasterxml.jackson.core.g;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: ParserBase */
public abstract class b extends c {

    /* renamed from: c reason: collision with root package name */
    static final BigInteger f4165c = BigInteger.valueOf(-2147483648L);

    /* renamed from: d reason: collision with root package name */
    static final BigInteger f4166d = BigInteger.valueOf(2147483647L);

    /* renamed from: e reason: collision with root package name */
    static final BigInteger f4167e = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: f reason: collision with root package name */
    static final BigInteger f4168f = BigInteger.valueOf(Long.MAX_VALUE);

    /* renamed from: g reason: collision with root package name */
    static final BigDecimal f4169g = new BigDecimal(f4167e);

    /* renamed from: h reason: collision with root package name */
    static final BigDecimal f4170h = new BigDecimal(f4168f);

    /* renamed from: i reason: collision with root package name */
    static final BigDecimal f4171i = new BigDecimal(f4165c);

    /* renamed from: j reason: collision with root package name */
    static final BigDecimal f4172j = new BigDecimal(f4166d);
    protected byte[] A;
    protected int B;
    protected int C;
    protected long D;
    protected double E;
    protected BigInteger F;
    protected BigDecimal G;
    protected boolean H;
    protected int I;
    protected int J;
    protected int K;

    /* renamed from: k reason: collision with root package name */
    protected final c f4173k;

    /* renamed from: l reason: collision with root package name */
    protected boolean f4174l;
    protected int m = 0;
    protected int n = 0;
    protected long o = 0;
    protected int p = 1;
    protected int q = 0;
    protected long r = 0;
    protected int s = 1;
    protected int t = 0;
    protected d u;
    protected g v;
    protected final com.fasterxml.jackson.core.e.g w;
    protected char[] x;
    protected boolean y;
    protected com.fasterxml.jackson.core.e.b z;

    protected b(c cVar, int i2) {
        com.fasterxml.jackson.core.c.b bVar = null;
        this.x = null;
        this.y = false;
        this.z = null;
        this.B = 0;
        this.f4348a = i2;
        this.f4173k = cVar;
        this.w = cVar.e();
        if (a.STRICT_DUPLICATE_DETECTION.b(i2)) {
            bVar = com.fasterxml.jackson.core.c.b.a((e) this);
        }
        this.u = d.a(bVar);
    }

    private void f(int i2) throws IOException {
        if (i2 == 16) {
            try {
                this.G = this.w.b();
                this.B = 16;
            } catch (NumberFormatException e2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed numeric value '");
                sb.append(this.w.d());
                sb.append("'");
                b(sb.toString(), (Throwable) e2);
                throw null;
            }
        } else {
            this.E = this.w.c();
            this.B = 8;
        }
    }

    /* access modifiers changed from: protected */
    public void H() throws JsonParseException {
        if (!this.u.f()) {
            StringBuilder sb = new StringBuilder();
            sb.append(": expected close marker for ");
            sb.append(this.u.c());
            sb.append(" (from ");
            sb.append(this.u.a(this.f4173k.g()));
            sb.append(")");
            f(sb.toString());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract void L() throws IOException;

    /* access modifiers changed from: protected */
    public final int M() throws JsonParseException {
        H();
        return -1;
    }

    /* access modifiers changed from: protected */
    public void N() throws IOException {
        this.w.l();
        char[] cArr = this.x;
        if (cArr != null) {
            this.x = null;
            this.f4173k.b(cArr);
        }
    }

    /* access modifiers changed from: protected */
    public void O() throws IOException {
        int i2 = this.B;
        if ((i2 & 16) != 0) {
            this.E = this.G.doubleValue();
        } else if ((i2 & 4) != 0) {
            this.E = this.F.doubleValue();
        } else if ((i2 & 2) != 0) {
            this.E = (double) this.D;
        } else if ((i2 & 1) != 0) {
            this.E = (double) this.C;
        } else {
            K();
            throw null;
        }
        this.B |= 8;
    }

    /* access modifiers changed from: protected */
    public void P() throws IOException {
        int i2 = this.B;
        if ((i2 & 2) != 0) {
            long j2 = this.D;
            int i3 = (int) j2;
            if (((long) i3) == j2) {
                this.C = i3;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Numeric value (");
                sb.append(j());
                sb.append(") out of range of int");
                e(sb.toString());
                throw null;
            }
        } else if ((i2 & 4) != 0) {
            if (f4165c.compareTo(this.F) > 0 || f4166d.compareTo(this.F) < 0) {
                T();
                throw null;
            }
            this.C = this.F.intValue();
        } else if ((i2 & 8) != 0) {
            double d2 = this.E;
            if (d2 < -2.147483648E9d || d2 > 2.147483647E9d) {
                T();
                throw null;
            }
            this.C = (int) d2;
        } else if ((i2 & 16) == 0) {
            K();
            throw null;
        } else if (f4171i.compareTo(this.G) > 0 || f4172j.compareTo(this.G) < 0) {
            T();
            throw null;
        } else {
            this.C = this.G.intValue();
        }
        this.B |= 1;
    }

    /* access modifiers changed from: protected */
    public void Q() throws IOException {
        int i2 = this.B;
        if ((i2 & 1) != 0) {
            this.D = (long) this.C;
        } else if ((i2 & 4) != 0) {
            if (f4167e.compareTo(this.F) > 0 || f4168f.compareTo(this.F) < 0) {
                U();
                throw null;
            }
            this.D = this.F.longValue();
        } else if ((i2 & 8) != 0) {
            double d2 = this.E;
            if (d2 < -9.223372036854776E18d || d2 > 9.223372036854776E18d) {
                U();
                throw null;
            }
            this.D = (long) d2;
        } else if ((i2 & 16) == 0) {
            K();
            throw null;
        } else if (f4169g.compareTo(this.G) > 0 || f4170h.compareTo(this.G) < 0) {
            U();
            throw null;
        } else {
            this.D = this.G.longValue();
        }
        this.B |= 2;
    }

    /* access modifiers changed from: protected */
    public abstract boolean R() throws IOException;

    /* access modifiers changed from: protected */
    public final void S() throws IOException {
        if (!R()) {
            I();
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public void T() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Numeric value (");
        sb.append(j());
        sb.append(") out of range of int (");
        sb.append(Integer.MIN_VALUE);
        sb.append(" - ");
        sb.append(Integer.MAX_VALUE);
        sb.append(")");
        e(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void U() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Numeric value (");
        sb.append(j());
        sb.append(") out of range of long (");
        sb.append(Long.MIN_VALUE);
        sb.append(" - ");
        sb.append(Long.MAX_VALUE);
        sb.append(")");
        e(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, char c2) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.u.a(this.f4173k.g()));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Unexpected close marker '");
        sb3.append((char) i2);
        sb3.append("': expected '");
        sb3.append(c2);
        sb3.append("' (for ");
        sb3.append(this.u.c());
        sb3.append(" starting at ");
        sb3.append(sb2);
        sb3.append(")");
        e(sb3.toString());
        throw null;
    }

    public com.fasterxml.jackson.core.d b() {
        int i2 = (this.m - this.q) + 1;
        com.fasterxml.jackson.core.d dVar = new com.fasterxml.jackson.core.d(this.f4173k.g(), -1, ((long) this.m) + this.o, this.p, i2);
        return dVar;
    }

    public String c() throws IOException {
        g gVar = this.f4175b;
        if (gVar == g.START_OBJECT || gVar == g.START_ARRAY) {
            return this.u.i().h();
        }
        return this.u.h();
    }

    public void close() throws IOException {
        if (!this.f4174l) {
            this.f4174l = true;
            try {
                L();
            } finally {
                N();
            }
        }
    }

    public double e() throws IOException {
        int i2 = this.B;
        if ((i2 & 8) == 0) {
            if (i2 == 0) {
                e(8);
            }
            if ((this.B & 8) == 0) {
                O();
            }
        }
        return this.E;
    }

    public Object f() throws IOException {
        return null;
    }

    public float g() throws IOException {
        return (float) e();
    }

    public int h() throws IOException {
        int i2 = this.B;
        if ((i2 & 1) == 0) {
            if (i2 == 0) {
                e(1);
            }
            if ((this.B & 1) == 0) {
                P();
            }
        }
        return this.C;
    }

    public long i() throws IOException {
        int i2 = this.B;
        if ((i2 & 2) == 0) {
            if (i2 == 0) {
                e(2);
            }
            if ((this.B & 2) == 0) {
                Q();
            }
        }
        return this.D;
    }

    /* access modifiers changed from: protected */
    public void g(String str) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid numeric value: ");
        sb.append(str);
        e(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public final g a(boolean z2, int i2, int i3, int i4) {
        if (i3 >= 1 || i4 >= 1) {
            return b(z2, i2, i3, i4);
        }
        return a(z2, i2);
    }

    /* access modifiers changed from: protected */
    public final g b(boolean z2, int i2, int i3, int i4) {
        this.H = z2;
        this.I = i2;
        this.J = i3;
        this.K = i4;
        this.B = 0;
        return g.VALUE_NUMBER_FLOAT;
    }

    /* access modifiers changed from: protected */
    public final g a(boolean z2, int i2) {
        this.H = z2;
        this.I = i2;
        this.J = 0;
        this.K = 0;
        this.B = 0;
        return g.VALUE_NUMBER_INT;
    }

    /* access modifiers changed from: protected */
    public void c(int i2, String str) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected character (");
        sb.append(c.b(i2));
        sb.append(") in numeric value");
        String sb2 = sb.toString();
        if (str != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(": ");
            sb3.append(str);
            sb2 = sb3.toString();
        }
        e(sb2);
        throw null;
    }

    /* access modifiers changed from: protected */
    public void e(int i2) throws IOException {
        g gVar = this.f4175b;
        if (gVar == g.VALUE_NUMBER_INT) {
            char[] j2 = this.w.j();
            int k2 = this.w.k();
            int i3 = this.I;
            if (this.H) {
                k2++;
            }
            if (i3 <= 9) {
                int b2 = com.fasterxml.jackson.core.b.g.b(j2, k2, i3);
                if (this.H) {
                    b2 = -b2;
                }
                this.C = b2;
                this.B = 1;
            } else if (i3 <= 18) {
                long c2 = com.fasterxml.jackson.core.b.g.c(j2, k2, i3);
                if (this.H) {
                    c2 = -c2;
                }
                if (i3 == 10) {
                    if (this.H) {
                        if (c2 >= -2147483648L) {
                            this.C = (int) c2;
                            this.B = 1;
                            return;
                        }
                    } else if (c2 <= 2147483647L) {
                        this.C = (int) c2;
                        this.B = 1;
                        return;
                    }
                }
                this.D = c2;
                this.B = 2;
            } else {
                a(i2, j2, k2, i3);
            }
        } else if (gVar == g.VALUE_NUMBER_FLOAT) {
            f(i2);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Current token (");
            sb.append(this.f4175b);
            sb.append(") not numeric, can not use numeric value accessors");
            e(sb.toString());
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    public final g a(String str, double d2) {
        this.w.a(str);
        this.E = d2;
        this.B = 8;
        return g.VALUE_NUMBER_FLOAT;
    }

    private void a(int i2, char[] cArr, int i3, int i4) throws IOException {
        String d2 = this.w.d();
        try {
            if (com.fasterxml.jackson.core.b.g.a(cArr, i3, i4, this.H)) {
                this.D = Long.parseLong(d2);
                this.B = 2;
                return;
            }
            this.F = new BigInteger(d2);
            this.B = 4;
        } catch (NumberFormatException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed numeric value '");
            sb.append(d2);
            sb.append("'");
            b(sb.toString(), (Throwable) e2);
            throw null;
        }
    }
}
