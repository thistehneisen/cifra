package org.joda.time.b;

import org.joda.time.d;
import org.joda.time.d.m;
import org.joda.time.h;

/* compiled from: BasicDayOfYearDateTimeField */
final class e extends m {

    /* renamed from: d reason: collision with root package name */
    private final c f10722d;

    e(c cVar, h hVar) {
        super(d.C(), hVar);
        this.f10722d = cVar;
    }

    public int a(long j2) {
        return this.f10722d.c(j2);
    }

    public boolean b(long j2) {
        return this.f10722d.j(j2);
    }

    public int c() {
        return this.f10722d.U();
    }

    public int d() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int d(long j2, int i2) {
        int U = this.f10722d.U() - 1;
        return (i2 > U || i2 < 1) ? i(j2) : U;
    }

    public h f() {
        return this.f10722d.K();
    }

    public int i(long j2) {
        return this.f10722d.b(this.f10722d.i(j2));
    }
}
