package org.joda.time.b;

import java.util.Locale;
import org.joda.time.b.a.C0124a;
import org.joda.time.d;
import org.joda.time.d.j;
import org.joda.time.d.k;
import org.joda.time.d.l;
import org.joda.time.d.n;
import org.joda.time.d.o;
import org.joda.time.d.u;
import org.joda.time.g;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: BasicChronology */
abstract class c extends a {
    private static final h K = j.f10809a;
    private static final h L = new n(i.j(), 1000);
    private static final h M = new n(i.h(), 60000);
    private static final h N = new n(i.f(), 3600000);
    /* access modifiers changed from: private */
    public static final h O = new n(i.e(), 43200000);
    /* access modifiers changed from: private */
    public static final h P = new n(i.b(), 86400000);
    private static final h Q = new n(i.k(), 604800000);
    private static final org.joda.time.c R = new l(d.K(), K, L);
    private static final org.joda.time.c S = new l(d.J(), K, P);
    private static final org.joda.time.c T = new l(d.P(), L, M);
    private static final org.joda.time.c U = new l(d.O(), L, P);
    private static final org.joda.time.c V = new l(d.M(), M, N);
    private static final org.joda.time.c W = new l(d.L(), M, P);
    private static final org.joda.time.c X = new l(d.H(), N, P);
    private static final org.joda.time.c Y = new l(d.I(), N, O);
    private static final org.joda.time.c Z = new u(X, d.y());
    private static final org.joda.time.c aa = new u(Y, d.z());
    private static final org.joda.time.c ba = new a();
    private static final long serialVersionUID = 8283225332206808863L;
    private final transient b[] ca = new b[1024];
    private final int iMinDaysInFirstWeek;

    /* compiled from: BasicChronology */
    private static class a extends l {
        a() {
            super(d.G(), c.O, c.P);
        }

        public long a(long j2, String str, Locale locale) {
            return b(j2, q.a(locale).c(str));
        }

        public String b(int i2, Locale locale) {
            return q.a(locale).d(i2);
        }

        public int a(Locale locale) {
            return q.a(locale).c();
        }
    }

    /* compiled from: BasicChronology */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        public final int f10719a;

        /* renamed from: b reason: collision with root package name */
        public final long f10720b;

        b(int i2, long j2) {
            this.f10719a = i2;
            this.f10720b = j2;
        }
    }

    c(org.joda.time.a aVar, Object obj, int i2) {
        super(aVar, obj);
        if (i2 < 1 || i2 > 7) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid min days in first week: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        this.iMinDaysInFirstWeek = i2;
    }

    private long b(int i2, int i3, int i4, int i5) {
        long a2 = a(i2, i3, i4);
        if (a2 == Long.MIN_VALUE) {
            a2 = a(i2, i3, i4 + 1);
            i5 -= 86400000;
        }
        long j2 = ((long) i5) + a2;
        int i6 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i6 < 0 && a2 > 0) {
            return Long.MAX_VALUE;
        }
        if (i6 <= 0 || a2 >= 0) {
            return j2;
        }
        return Long.MIN_VALUE;
    }

    /* access modifiers changed from: 0000 */
    public abstract long P();

    /* access modifiers changed from: 0000 */
    public abstract long Q();

    /* access modifiers changed from: 0000 */
    public abstract long R();

    /* access modifiers changed from: 0000 */
    public abstract long S();

    /* access modifiers changed from: 0000 */
    public int T() {
        return 31;
    }

    /* access modifiers changed from: 0000 */
    public int U() {
        return 366;
    }

    /* access modifiers changed from: 0000 */
    public int V() {
        return 12;
    }

    /* access modifiers changed from: 0000 */
    public abstract int W();

    /* access modifiers changed from: 0000 */
    public abstract int X();

    public int Y() {
        return this.iMinDaysInFirstWeek;
    }

    /* access modifiers changed from: 0000 */
    public abstract int a(int i2, int i3);

    /* access modifiers changed from: 0000 */
    public abstract long a(int i2);

    public long a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        org.joda.time.a L2 = L();
        if (L2 != null) {
            return L2.a(i2, i3, i4, i5);
        }
        org.joda.time.d.h.a(d.J(), i5, 0, 86399999);
        return b(i2, i3, i4, i5);
    }

    /* access modifiers changed from: 0000 */
    public abstract long b(int i2, int i3);

    /* access modifiers changed from: 0000 */
    public long c(int i2) {
        long f2 = f(i2);
        int b2 = b(f2);
        return b2 > 8 - this.iMinDaysInFirstWeek ? f2 + (((long) (8 - b2)) * 86400000) : f2 - (((long) (b2 - 1)) * 86400000);
    }

    /* access modifiers changed from: 0000 */
    public int d(long j2) {
        int i2 = i(j2);
        return a(i2, d(j2, i2));
    }

    /* access modifiers changed from: 0000 */
    public abstract int d(long j2, int i2);

    /* access modifiers changed from: 0000 */
    public int e(int i2) {
        return (int) ((c(i2 + 1) - c(i2)) / 604800000);
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (Y() != cVar.Y() || !k().equals(cVar.k())) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public long f(int i2) {
        return h(i2).f10720b;
    }

    /* access modifiers changed from: 0000 */
    public abstract long f(long j2, int i2);

    /* access modifiers changed from: 0000 */
    public int g(long j2) {
        return e(j2, i(j2));
    }

    /* access modifiers changed from: 0000 */
    public abstract boolean g(int i2);

    /* access modifiers changed from: 0000 */
    public int h(long j2) {
        int i2 = i(j2);
        int e2 = e(j2, i2);
        if (e2 == 1) {
            return i(j2 + 604800000);
        }
        return e2 > 51 ? i(j2 - 1209600000) : i2;
    }

    public int hashCode() {
        return (getClass().getName().hashCode() * 11) + k().hashCode() + Y();
    }

    /* access modifiers changed from: 0000 */
    public int i(long j2) {
        long S2 = S();
        long P2 = (j2 >> 1) + P();
        if (P2 < 0) {
            P2 = (P2 - S2) + 1;
        }
        int i2 = (int) (P2 / S2);
        long f2 = f(i2);
        long j3 = j2 - f2;
        if (j3 < 0) {
            return i2 - 1;
        }
        long j4 = 31536000000L;
        if (j3 < 31536000000L) {
            return i2;
        }
        if (g(i2)) {
            j4 = 31622400000L;
        }
        return f2 + j4 <= j2 ? i2 + 1 : i2;
    }

    /* access modifiers changed from: 0000 */
    public boolean j(long j2) {
        return false;
    }

    public g k() {
        org.joda.time.a L2 = L();
        if (L2 != null) {
            return L2.k();
        }
        return g.f10938a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(60);
        String name = getClass().getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            name = name.substring(lastIndexOf + 1);
        }
        sb.append(name);
        sb.append('[');
        g k2 = k();
        if (k2 != null) {
            sb.append(k2.c());
        }
        if (Y() != 4) {
            sb.append(",mdfw=");
            sb.append(Y());
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public int f(long j2) {
        return d(j2, i(j2));
    }

    /* access modifiers changed from: 0000 */
    public int b(int i2) {
        return g(i2) ? 366 : 365;
    }

    /* access modifiers changed from: 0000 */
    public long b(int i2, int i3, int i4) {
        return f(i2) + b(i2, i3) + (((long) (i4 - 1)) * 86400000);
    }

    /* access modifiers changed from: 0000 */
    public long c(int i2, int i3) {
        return f(i2) + b(i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public int d(int i2) {
        return V();
    }

    /* access modifiers changed from: 0000 */
    public int e(long j2, int i2) {
        long c2 = c(i2);
        if (j2 < c2) {
            return e(i2 - 1);
        }
        if (j2 >= c(i2 + 1)) {
            return 1;
        }
        return ((int) ((j2 - c2) / 604800000)) + 1;
    }

    private b h(int i2) {
        int i3 = i2 & 1023;
        b bVar = this.ca[i3];
        if (bVar != null && bVar.f10719a == i2) {
            return bVar;
        }
        b bVar2 = new b(i2, a(i2));
        this.ca[i3] = bVar2;
        return bVar2;
    }

    public long a(int i2, int i3, int i4, int i5, int i6, int i7, int i8) throws IllegalArgumentException {
        org.joda.time.a L2 = L();
        if (L2 != null) {
            return L2.a(i2, i3, i4, i5, i6, i7, i8);
        }
        org.joda.time.d.h.a(d.H(), i5, 0, 23);
        org.joda.time.d.h.a(d.M(), i6, 0, 59);
        org.joda.time.d.h.a(d.P(), i7, 0, 59);
        org.joda.time.d.h.a(d.K(), i8, 0, 999);
        return b(i2, i3, i4, (int) ((long) ((i5 * 3600000) + (i6 * 60000) + (i7 * 1000) + i8)));
    }

    /* access modifiers changed from: 0000 */
    public int b(long j2, int i2) {
        return ((int) ((j2 - f(i2)) / 86400000)) + 1;
    }

    /* access modifiers changed from: 0000 */
    public int c(long j2) {
        return b(j2, i(j2));
    }

    /* access modifiers changed from: 0000 */
    public int c(long j2, int i2) {
        return d(j2);
    }

    /* access modifiers changed from: 0000 */
    public int b(long j2) {
        long j3;
        if (j2 >= 0) {
            j3 = j2 / 86400000;
        } else {
            j3 = (j2 - 86399999) / 86400000;
            if (j3 < -3) {
                return ((int) ((j3 + 4) % 7)) + 7;
            }
        }
        return ((int) ((j3 + 3) % 7)) + 1;
    }

    /* access modifiers changed from: 0000 */
    public int e(long j2) {
        if (j2 >= 0) {
            return (int) (j2 % 86400000);
        }
        return ((int) ((j2 + 1) % 86400000)) + 86399999;
    }

    /* access modifiers changed from: protected */
    public void a(C0124a aVar) {
        aVar.f10707a = K;
        aVar.f10708b = L;
        aVar.f10709c = M;
        aVar.f10710d = N;
        aVar.f10711e = O;
        aVar.f10712f = P;
        aVar.f10713g = Q;
        aVar.m = R;
        aVar.n = S;
        aVar.o = T;
        aVar.p = U;
        aVar.q = V;
        aVar.r = W;
        aVar.s = X;
        aVar.u = Y;
        aVar.t = Z;
        aVar.v = aa;
        aVar.w = ba;
        aVar.E = new k(this);
        aVar.F = new s(aVar.E, this);
        aVar.H = new org.joda.time.d.g(new k(aVar.F, 99), d.x(), 100);
        aVar.f10717k = aVar.H.a();
        aVar.G = new k(new o((org.joda.time.d.g) aVar.H), d.U(), 1);
        aVar.I = new p(this);
        aVar.x = new o(this, aVar.f10712f);
        aVar.y = new d(this, aVar.f10712f);
        aVar.z = new e(this, aVar.f10712f);
        aVar.D = new r(this);
        aVar.B = new j(this);
        aVar.A = new i(this, aVar.f10713g);
        aVar.C = new k(new o(aVar.B, aVar.f10717k, d.S(), 100), d.S(), 1);
        aVar.f10716j = aVar.E.a();
        aVar.f10715i = aVar.D.a();
        aVar.f10714h = aVar.B.a();
    }

    /* access modifiers changed from: 0000 */
    public int a(long j2) {
        int i2 = i(j2);
        return a(j2, i2, d(j2, i2));
    }

    /* access modifiers changed from: 0000 */
    public int a(long j2, int i2) {
        return a(j2, i2, d(j2, i2));
    }

    /* access modifiers changed from: 0000 */
    public int a(long j2, int i2, int i3) {
        return ((int) ((j2 - (f(i2) + b(i2, i3))) / 86400000)) + 1;
    }

    /* access modifiers changed from: 0000 */
    public long a(int i2, int i3, int i4) {
        org.joda.time.d.h.a(d.T(), i2, X() - 1, W() + 1);
        org.joda.time.d.h.a(d.N(), i3, 1, d(i2));
        org.joda.time.d.h.a(d.A(), i4, 1, a(i2, i3));
        long b2 = b(i2, i3, i4);
        int i5 = (b2 > 0 ? 1 : (b2 == 0 ? 0 : -1));
        if (i5 < 0 && i2 == W() + 1) {
            return Long.MAX_VALUE;
        }
        if (i5 <= 0 || i2 != X() - 1) {
            return b2;
        }
        return Long.MIN_VALUE;
    }
}
