package org.joda.time.c;

import java.util.Date;
import org.joda.time.a;

/* compiled from: DateConverter */
final class f extends a implements h, l {

    /* renamed from: a reason: collision with root package name */
    static final f f10779a = new f();

    protected f() {
    }

    public long a(Object obj, a aVar) {
        return ((Date) obj).getTime();
    }

    public Class<?> a() {
        return Date.class;
    }
}
