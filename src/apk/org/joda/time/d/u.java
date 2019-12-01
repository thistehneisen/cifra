package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;

/* compiled from: ZeroIsMaxDateTimeField */
public final class u extends d {
    public u(c cVar, d dVar) {
        super(cVar, dVar);
        if (cVar.d() != 0) {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        }
    }

    public int a(long j2) {
        int a2 = j().a(j2);
        return a2 == 0 ? c() : a2;
    }

    public long b(long j2, int i2) {
        int c2 = c();
        h.a((c) this, i2, 1, c2);
        if (i2 == c2) {
            i2 = 0;
        }
        return j().b(j2, i2);
    }

    public int c() {
        return j().c() + 1;
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

    public long f(long j2) {
        return j().f(j2);
    }

    public long g(long j2) {
        return j().g(j2);
    }

    public long h(long j2) {
        return j().h(j2);
    }

    public long c(long j2) {
        return j().c(j2);
    }

    public long a(long j2, int i2) {
        return j().a(j2, i2);
    }

    public long a(long j2, long j3) {
        return j().a(j2, j3);
    }

    public boolean b(long j2) {
        return j().b(j2);
    }

    public h b() {
        return j().b();
    }
}
