package org.joda.time.b;

import org.joda.time.c;
import org.joda.time.d.d;
import org.joda.time.d.h;

/* compiled from: GJYearOfEraDateTimeField */
final class s extends d {

    /* renamed from: c reason: collision with root package name */
    private final c f10755c;

    s(c cVar, c cVar2) {
        super(cVar, org.joda.time.d.V());
        this.f10755c = cVar2;
    }

    public int a(long j2) {
        int a2 = j().a(j2);
        return a2 <= 0 ? 1 - a2 : a2;
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, 1, c());
        if (this.f10755c.i(j2) <= 0) {
            i2 = 1 - i2;
        }
        return super.b(j2, i2);
    }

    public int c() {
        return j().c();
    }

    public int d() {
        return 1;
    }

    public long d(long j2) {
        return j().d(j2);
    }

    public long e(long j2) {
        return j().e(j2);
    }

    public org.joda.time.h f() {
        return this.f10755c.j();
    }

    public long a(long j2, int i2) {
        return j().a(j2, i2);
    }

    public long c(long j2) {
        return j().c(j2);
    }

    public long a(long j2, long j3) {
        return j().a(j2, j3);
    }
}
