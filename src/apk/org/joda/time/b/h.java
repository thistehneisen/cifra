package org.joda.time.b;

import java.util.Locale;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.d.b;
import org.joda.time.d.t;
import org.joda.time.i;

/* compiled from: BasicSingleEraDateTimeField */
final class h extends b {

    /* renamed from: b reason: collision with root package name */
    private final String f10726b;

    h(String str) {
        super(d.D());
        this.f10726b = str;
    }

    public int a(long j2) {
        return 1;
    }

    public long a(long j2, String str, Locale locale) {
        if (this.f10726b.equals(str) || "1".equals(str)) {
            return j2;
        }
        throw new IllegalFieldValueException(d.D(), str);
    }

    public long b(long j2, int i2) {
        org.joda.time.d.h.a((c) this, i2, 1, 1);
        return j2;
    }

    public int c() {
        return 1;
    }

    public int d() {
        return 1;
    }

    public long d(long j2) {
        return Long.MAX_VALUE;
    }

    public long e(long j2) {
        return Long.MIN_VALUE;
    }

    public long f(long j2) {
        return Long.MIN_VALUE;
    }

    public org.joda.time.h f() {
        return null;
    }

    public long g(long j2) {
        return Long.MIN_VALUE;
    }

    public long h(long j2) {
        return Long.MIN_VALUE;
    }

    public boolean h() {
        return false;
    }

    public String b(int i2, Locale locale) {
        return this.f10726b;
    }

    public org.joda.time.h a() {
        return t.a(i.c());
    }

    public int a(Locale locale) {
        return this.f10726b.length();
    }
}
