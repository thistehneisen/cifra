package org.joda.time.c;

import org.joda.time.a;
import org.joda.time.e;
import org.joda.time.r;

/* compiled from: ReadableInstantConverter */
class o extends a implements h, l {

    /* renamed from: a reason: collision with root package name */
    static final o f10783a = new o();

    protected o() {
    }

    public long a(Object obj, a aVar) {
        return ((r) obj).n();
    }

    public a b(Object obj, a aVar) {
        return aVar == null ? e.a(((r) obj).getChronology()) : aVar;
    }

    public Class<?> a() {
        return r.class;
    }
}
