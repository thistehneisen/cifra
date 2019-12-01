package l.a.c.c;

import kotlin.e.a.b;
import kotlin.e.b.g;
import kotlin.e.b.h;
import kotlin.e.b.o;
import kotlin.g.e;
import l.a.d.b.a.c;

/* compiled from: Destroyable.kt */
final /* synthetic */ class m extends g implements b<Throwable, kotlin.m> {

    /* renamed from: c reason: collision with root package name */
    public static final m f10389c = new m();

    m() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Throwable) obj);
        return kotlin.m.f10346a;
    }

    public final String f() {
        return "assertion";
    }

    public final e g() {
        return o.a(c.class);
    }

    public final String i() {
        return "assertion(Ljava/lang/Throwable;)V";
    }

    public final void a(Throwable th) {
        h.b(th, "p1");
        c.a(th);
    }
}
