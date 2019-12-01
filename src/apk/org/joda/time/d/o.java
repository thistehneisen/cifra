package org.joda.time.d;

import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.h;

/* compiled from: RemainderDateTimeField */
public class o extends d {

    /* renamed from: c reason: collision with root package name */
    final int f10817c;

    /* renamed from: d reason: collision with root package name */
    final h f10818d;

    /* renamed from: e reason: collision with root package name */
    final h f10819e;

    public o(c cVar, h hVar, d dVar, int i2) {
        super(cVar, dVar);
        if (i2 >= 2) {
            this.f10819e = hVar;
            this.f10818d = cVar.a();
            this.f10817c = i2;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    public int a(long j2) {
        int a2 = j().a(j2);
        if (a2 >= 0) {
            return a2 % this.f10817c;
        }
        int i2 = this.f10817c;
        return (i2 - 1) + ((a2 + 1) % i2);
    }

    public long b(long j2, int i2) {
        h.a((c) this, i2, 0, this.f10817c - 1);
        return j().b(j2, (a(j().a(j2)) * this.f10817c) + i2);
    }

    public int c() {
        return this.f10817c - 1;
    }

    public int d() {
        return 0;
    }

    public long d(long j2) {
        return j().d(j2);
    }

    public long e(long j2) {
        return j().e(j2);
    }

    public h f() {
        return this.f10819e;
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

    public long f(long j2) {
        return j().f(j2);
    }

    public h a() {
        return this.f10818d;
    }

    private int a(int i2) {
        if (i2 >= 0) {
            return i2 / this.f10817c;
        }
        return ((i2 + 1) / this.f10817c) - 1;
    }

    public o(g gVar) {
        this(gVar, gVar.g());
    }

    public o(g gVar, d dVar) {
        this(gVar, gVar.j().a(), dVar);
    }

    public o(g gVar, h hVar, d dVar) {
        super(gVar.j(), dVar);
        this.f10817c = gVar.f10802c;
        this.f10818d = hVar;
        this.f10819e = gVar.f10803d;
    }
}
