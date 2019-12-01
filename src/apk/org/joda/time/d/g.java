package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;

/* compiled from: DividedDateTimeField */
public class g extends d {

    /* renamed from: c reason: collision with root package name */
    final int f10802c;

    /* renamed from: d reason: collision with root package name */
    final h f10803d;

    /* renamed from: e reason: collision with root package name */
    final h f10804e;

    /* renamed from: f reason: collision with root package name */
    private final int f10805f;

    /* renamed from: g reason: collision with root package name */
    private final int f10806g;

    public g(c cVar, d dVar, int i2) {
        this(cVar, cVar.f(), dVar, i2);
    }

    public int a(long j2) {
        int a2 = j().a(j2);
        if (a2 >= 0) {
            return a2 / this.f10802c;
        }
        return ((a2 + 1) / this.f10802c) - 1;
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, this.f10805f, this.f10806g);
        return j().b(j2, (i2 * this.f10802c) + a(j().a(j2)));
    }

    public int c() {
        return this.f10806g;
    }

    public int d() {
        return this.f10805f;
    }

    public long e(long j2) {
        c j3 = j();
        return j3.e(j3.b(j2, a(j2) * this.f10802c));
    }

    public h f() {
        h hVar = this.f10804e;
        if (hVar != null) {
            return hVar;
        }
        return super.f();
    }

    public g(c cVar, h hVar, d dVar, int i2) {
        super(cVar, dVar);
        if (i2 >= 2) {
            h a2 = cVar.a();
            if (a2 == null) {
                this.f10803d = null;
            } else {
                this.f10803d = new p(a2, dVar.E(), i2);
            }
            this.f10804e = hVar;
            this.f10802c = i2;
            int d2 = cVar.d();
            int i3 = d2 >= 0 ? d2 / i2 : ((d2 + 1) / i2) - 1;
            int c2 = cVar.c();
            int i4 = c2 >= 0 ? c2 / i2 : ((c2 + 1) / i2) - 1;
            this.f10805f = i3;
            this.f10806g = i4;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public long c(long j2) {
        return b(j2, a(j().c(j2)));
    }

    public long a(long j2, int i2) {
        return j().a(j2, i2 * this.f10802c);
    }

    public long a(long j2, long j3) {
        return j().a(j2, j3 * ((long) this.f10802c));
    }

    public h a() {
        return this.f10803d;
    }

    private int a(int i2) {
        if (i2 >= 0) {
            return i2 % this.f10802c;
        }
        int i3 = this.f10802c;
        return (i3 - 1) + ((i2 + 1) % i3);
    }
}
