package org.joda.time.b;

import org.joda.time.d;
import org.joda.time.d.m;
import org.joda.time.h;

/* compiled from: BasicWeekOfWeekyearDateTimeField */
final class i extends m {

    /* renamed from: d reason: collision with root package name */
    private final c f10727d;

    i(c cVar, h hVar) {
        super(d.Q(), hVar);
        this.f10727d = cVar;
    }

    public int a(long j2) {
        return this.f10727d.g(j2);
    }

    public int c() {
        return 53;
    }

    public long c(long j2) {
        return super.c(j2 + 259200000);
    }

    public int d() {
        return 1;
    }

    public long d(long j2) {
        return super.d(j2 + 259200000) - 259200000;
    }

    public long e(long j2) {
        return super.e(j2 + 259200000) - 259200000;
    }

    public h f() {
        return this.f10727d.F();
    }

    public int i(long j2) {
        return this.f10727d.e(this.f10727d.h(j2));
    }

    /* access modifiers changed from: protected */
    public int d(long j2, int i2) {
        if (i2 > 52) {
            return i(j2);
        }
        return 52;
    }
}
