package l.a.c.c;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.g.e;
import kotlin.m;
import l.a.d.b.a.c;

/* compiled from: Destroyable.kt */
final /* synthetic */ class o extends g implements b<Throwable, m> {

    /* renamed from: c reason: collision with root package name */
    public static final o f10390c = new o();

    o() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Throwable) obj);
        return m.f10346a;
    }

    public final String f() {
        return "assertion";
    }

    public final e g() {
        return kotlin.e.b.o.a(c.class);
    }

    public final String i() {
        return "assertion(Ljava/lang/Throwable;)V";
    }

    public final void a(Throwable th) {
        h.b(th, "p1");
        c.a(th);
    }
}
