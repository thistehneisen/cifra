package com.touchin.vtb.a;

import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import org.joda.time.b;

/* compiled from: TasksArchiveAdapter.kt */
final class F extends i implements c<H, H, Boolean> {

    /* renamed from: a reason: collision with root package name */
    public static final F f6887a = new F();

    F() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return Boolean.valueOf(a((H) obj, (H) obj2));
    }

    public final boolean a(H h2, H h3) {
        h.b(h2, "prevElement");
        h.b(h3, "currentElement");
        return new b(h2.a().c()).f().a() != new b(h3.a().c()).f().a();
    }
}
