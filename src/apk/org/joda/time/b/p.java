package org.joda.time.b;

import java.util.Locale;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.b;
import org.joda.time.d.t;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: GJEraDateTimeField */
final class p extends b {

    /* renamed from: b reason: collision with root package name */
    private final c f10742b;

    p(c cVar) {
        super(d.D());
        this.f10742b = cVar;
    }

    public int a(long j2) {
        return this.f10742b.i(j2) <= 0 ? 0 : 1;
    }

    public String b(int i2, Locale locale) {
        return q.a(locale).c(i2);
    }

    public int c() {
        return 1;
    }

    public int d() {
        return 0;
    }

    public long d(long j2) {
        if (a(j2) == 0) {
            return this.f10742b.f(0, 1);
        }
        return Long.MAX_VALUE;
    }

    public long e(long j2) {
        if (a(j2) == 1) {
            return this.f10742b.f(0, 1);
        }
        return Long.MIN_VALUE;
    }

    public long f(long j2) {
        return e(j2);
    }

    public h f() {
        return null;
    }

    public long g(long j2) {
        return e(j2);
    }

    public long h(long j2) {
        return e(j2);
    }

    public boolean h() {
        return false;
    }

    public long a(long j2, String str, Locale locale) {
        return b(j2, q.a(locale).b(str));
    }

    public long b(long j2, int i2) {
        org.joda.time.d.h.a((c) this, i2, 0, 1);
        if (a(j2) == i2) {
            return j2;
        }
        return this.f10742b.f(j2, -this.f10742b.i(j2));
    }

    public h a() {
        return t.a(i.c());
    }

    public int a(Locale locale) {
        return q.a(locale).b();
    }
}
