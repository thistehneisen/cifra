package org.joda.time.b;

import java.util.Locale;
import org.joda.time.d;
import org.joda.time.d.m;
import org.joda.time.h;

/* compiled from: GJDayOfWeekDateTimeField */
final class o extends m {

    /* renamed from: d reason: collision with root package name */
    private final c f10741d;

    o(c cVar, h hVar) {
        super(d.B(), hVar);
        this.f10741d = cVar;
    }

    public int a(long j2) {
        return this.f10741d.b(j2);
    }

    public String b(int i2, Locale locale) {
        return q.a(locale).b(i2);
    }

    public int c() {
        return 7;
    }

    public int d() {
        return 1;
    }

    public h f() {
        return this.f10741d.C();
    }

    public String a(int i2, Locale locale) {
        return q.a(locale).a(i2);
    }

    /* access modifiers changed from: protected */
    public int a(String str, Locale locale) {
        return q.a(locale).a(str);
    }

    public int a(Locale locale) {
        return q.a(locale).a();
    }
}
