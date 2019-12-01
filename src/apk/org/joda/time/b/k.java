package org.joda.time.b;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.h;
import org.joda.time.d.i;

/* compiled from: BasicYearDateTimeField */
class k extends i {

    /* renamed from: d reason: collision with root package name */
    protected final c f10729d;

    k(c cVar) {
        super(d.T(), cVar.R());
        this.f10729d = cVar;
    }

    public int a(long j2) {
        return this.f10729d.i(j2);
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, this.f10729d.X(), this.f10729d.W());
        return this.f10729d.f(j2, i2);
    }

    public long c(long j2, int i2) {
        h.a((c) this, i2, this.f10729d.X() - 1, this.f10729d.W() + 1);
        return this.f10729d.f(j2, i2);
    }

    public int d() {
        return this.f10729d.X();
    }

    public long e(long j2) {
        return this.f10729d.f(a(j2));
    }

    public org.joda.time.h f() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public long a(long j2, int i2) {
        if (i2 == 0) {
            return j2;
        }
        return b(j2, h.a(a(j2), i2));
    }

    public long d(long j2) {
        int a2 = a(j2);
        return j2 != this.f10729d.f(a2) ? this.f10729d.f(a2 + 1) : j2;
    }

    public boolean b(long j2) {
        return this.f10729d.g(a(j2));
    }

    public long a(long j2, long j3) {
        return a(j2, h.a(j3));
    }

    public org.joda.time.h b() {
        return this.f10729d.h();
    }

    public int c() {
        return this.f10729d.W();
    }

    public long c(long j2) {
        return j2 - e(j2);
    }
}
