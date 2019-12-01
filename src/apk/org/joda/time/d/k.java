package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;

/* compiled from: OffsetDateTimeField */
public class k extends d {

    /* renamed from: c reason: collision with root package name */
    private final int f10810c;

    /* renamed from: d reason: collision with root package name */
    private final int f10811d;

    /* renamed from: e reason: collision with root package name */
    private final int f10812e;

    public k(c cVar, int i2) {
        this(cVar, cVar == null ? null : cVar.g(), i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int a(long j2) {
        return super.a(j2) + this.f10810c;
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, this.f10811d, this.f10812e);
        return super.b(j2, i2 - this.f10810c);
    }

    public int c() {
        return this.f10812e;
    }

    public int d() {
        return this.f10811d;
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

    public k(c cVar, d dVar, int i2) {
        this(cVar, dVar, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public long a(long j2, int i2) {
        long a2 = super.a(j2, i2);
        h.a((c) this, a(a2), this.f10811d, this.f10812e);
        return a2;
    }

    public long c(long j2) {
        return j().c(j2);
    }

    public long d(long j2) {
        return j().d(j2);
    }

    public k(c cVar, d dVar, int i2, int i3, int i4) {
        super(cVar, dVar);
        if (i2 != 0) {
            this.f10810c = i2;
            if (i3 < cVar.d() + i2) {
                this.f10811d = cVar.d() + i2;
            } else {
                this.f10811d = i3;
            }
            if (i4 > cVar.c() + i2) {
                this.f10812e = cVar.c() + i2;
            } else {
                this.f10812e = i4;
            }
        } else {
            throw new IllegalArgumentException("The offset cannot be zero");
        }
    }

    public boolean b(long j2) {
        return j().b(j2);
    }

    public long a(long j2, long j3) {
        long a2 = super.a(j2, j3);
        h.a((c) this, a(a2), this.f10811d, this.f10812e);
        return a2;
    }

    public h b() {
        return j().b();
    }
}
