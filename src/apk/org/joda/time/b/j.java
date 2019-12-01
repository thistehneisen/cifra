package org.joda.time.b;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.h;
import org.joda.time.d.i;

/* compiled from: BasicWeekyearDateTimeField */
final class j extends i {

    /* renamed from: d reason: collision with root package name */
    private final c f10728d;

    j(c cVar) {
        super(d.R(), cVar.R());
        this.f10728d = cVar;
    }

    public int a(long j2) {
        return this.f10728d.h(j2);
    }

    public long b(long j2, int i2) {
        h.a((c) this, Math.abs(i2), this.f10728d.X(), this.f10728d.W());
        int a2 = a(j2);
        if (a2 == i2) {
            return j2;
        }
        int b2 = this.f10728d.b(j2);
        int e2 = this.f10728d.e(a2);
        int e3 = this.f10728d.e(i2);
        if (e3 < e2) {
            e2 = e3;
        }
        int g2 = this.f10728d.g(j2);
        if (g2 <= e2) {
            e2 = g2;
        }
        long f2 = this.f10728d.f(j2, i2);
        int a3 = a(f2);
        if (a3 < i2) {
            f2 += 604800000;
        } else if (a3 > i2) {
            f2 -= 604800000;
        }
        return this.f10728d.f().b(f2 + (((long) (e2 - this.f10728d.g(f2))) * 604800000), b2);
    }

    public int c() {
        return this.f10728d.W();
    }

    public int d() {
        return this.f10728d.X();
    }

    public long e(long j2) {
        long e2 = this.f10728d.B().e(j2);
        int g2 = this.f10728d.g(e2);
        return g2 > 1 ? e2 - (((long) (g2 - 1)) * 604800000) : e2;
    }

    public org.joda.time.h f() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public long a(long j2, int i2) {
        return i2 == 0 ? j2 : b(j2, a(j2) + i2);
    }

    public long c(long j2) {
        return j2 - e(j2);
    }

    public long a(long j2, long j3) {
        return a(j2, h.a(j3));
    }

    public boolean b(long j2) {
        c cVar = this.f10728d;
        return cVar.e(cVar.h(j2)) > 52;
    }

    public org.joda.time.h b() {
        return this.f10728d.C();
    }
}
