package org.joda.time.b;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.h;
import org.joda.time.d.i;

/* compiled from: BasicMonthOfYearDateTimeField */
class g extends i {

    /* renamed from: d reason: collision with root package name */
    private final c f10723d;

    /* renamed from: e reason: collision with root package name */
    private final int f10724e = this.f10723d.V();

    /* renamed from: f reason: collision with root package name */
    private final int f10725f;

    g(c cVar, int i2) {
        super(d.N(), cVar.Q());
        this.f10723d = cVar;
        this.f10725f = i2;
    }

    public int a(long j2) {
        return this.f10723d.f(j2);
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, 1, this.f10724e);
        int i3 = this.f10723d.i(j2);
        int a2 = this.f10723d.a(j2, i3);
        int a3 = this.f10723d.a(i3, i2);
        if (a2 > a3) {
            a2 = a3;
        }
        return this.f10723d.b(i3, i2, a2) + ((long) this.f10723d.e(j2));
    }

    public int c() {
        return this.f10724e;
    }

    public int d() {
        return 1;
    }

    public long e(long j2) {
        int i2 = this.f10723d.i(j2);
        return this.f10723d.c(i2, this.f10723d.d(j2, i2));
    }

    public org.joda.time.h f() {
        return this.f10723d.K();
    }

    public boolean h() {
        return false;
    }

    public long a(long j2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (i2 == 0) {
            return j2;
        }
        long e2 = (long) this.f10723d.e(j2);
        int i8 = this.f10723d.i(j2);
        int d2 = this.f10723d.d(j2, i8);
        int i9 = d2 - 1;
        int i10 = i9 + i2;
        if (d2 <= 0 || i10 >= 0) {
            i3 = i10;
            i4 = i8;
        } else {
            if (Math.signum((float) (this.f10724e + i2)) == Math.signum((float) i2)) {
                i4 = i8 - 1;
                i7 = i2 + this.f10724e;
            } else {
                i4 = i8 + 1;
                i7 = i2 - this.f10724e;
            }
            i3 = i7 + i9;
        }
        if (i3 >= 0) {
            int i11 = this.f10724e;
            i6 = i4 + (i3 / i11);
            i5 = (i3 % i11) + 1;
        } else {
            i6 = (i4 + (i3 / this.f10724e)) - 1;
            int abs = Math.abs(i3);
            int i12 = this.f10724e;
            int i13 = abs % i12;
            if (i13 == 0) {
                i13 = i12;
            }
            i5 = (this.f10724e - i13) + 1;
            if (i5 == 1) {
                i6++;
            }
        }
        int a2 = this.f10723d.a(j2, i8, d2);
        int a3 = this.f10723d.a(i6, i5);
        if (a2 > a3) {
            a2 = a3;
        }
        return this.f10723d.b(i6, i5, a2) + e2;
    }

    public long c(long j2) {
        return j2 - e(j2);
    }

    public boolean b(long j2) {
        int i2 = this.f10723d.i(j2);
        if (!this.f10723d.g(i2) || this.f10723d.d(j2, i2) != this.f10725f) {
            return false;
        }
        return true;
    }

    public org.joda.time.h b() {
        return this.f10723d.h();
    }

    public long a(long j2, long j3) {
        long j4;
        long j5;
        long j6 = j2;
        long j7 = j3;
        int i2 = (int) j7;
        if (((long) i2) == j7) {
            return a(j6, i2);
        }
        long e2 = (long) this.f10723d.e(j6);
        int i3 = this.f10723d.i(j6);
        int d2 = this.f10723d.d(j6, i3);
        long j8 = ((long) (d2 - 1)) + j7;
        if (j8 >= 0) {
            long j9 = (long) i3;
            int i4 = this.f10724e;
            j4 = j9 + (j8 / ((long) i4));
            j5 = (j8 % ((long) i4)) + 1;
        } else {
            j4 = (((long) i3) + (j8 / ((long) this.f10724e))) - 1;
            long abs = Math.abs(j8);
            int i5 = this.f10724e;
            int i6 = (int) (abs % ((long) i5));
            if (i6 != 0) {
                i5 = i6;
            }
            j5 = (long) ((this.f10724e - i5) + 1);
            if (j5 == 1) {
                j4++;
            }
        }
        if (j4 < ((long) this.f10723d.X()) || j4 > ((long) this.f10723d.W())) {
            StringBuilder sb = new StringBuilder();
            sb.append("Magnitude of add amount is too large: ");
            sb.append(j7);
            throw new IllegalArgumentException(sb.toString());
        }
        int i7 = (int) j4;
        int i8 = (int) j5;
        int a2 = this.f10723d.a(j6, i3, d2);
        int a3 = this.f10723d.a(i7, i8);
        if (a2 > a3) {
            a2 = a3;
        }
        return this.f10723d.b(i7, i8, a2) + e2;
    }
}
