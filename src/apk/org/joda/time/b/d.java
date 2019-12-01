package org.joda.time.b;

import org.joda.time.d.m;
import org.joda.time.h;

/* compiled from: BasicDayOfMonthDateTimeField */
final class d extends m {

    /* renamed from: d reason: collision with root package name */
    private final c f10721d;

    d(c cVar, h hVar) {
        super(org.joda.time.d.A(), hVar);
        this.f10721d = cVar;
    }

    public int a(long j2) {
        return this.f10721d.a(j2);
    }

    public boolean b(long j2) {
        return this.f10721d.j(j2);
    }

    public int c() {
        return this.f10721d.T();
    }

    public int d() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int d(long j2, int i2) {
        return this.f10721d.c(j2, i2);
    }

    public h f() {
        return this.f10721d.x();
    }

    public int i(long j2) {
        return this.f10721d.d(j2);
    }
}
