package l.a.c.c;

import androidx.lifecycle.u;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;
import l.a.c.a.a;

/* compiled from: BaseLiveDataDispatcher.kt */
final class g extends i implements b<Throwable, m> {
    final /* synthetic */ u $liveData;

    g(u uVar) {
        this.$liveData = uVar;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Throwable) obj);
        return m.f10346a;
    }

    public final void a(Throwable th) {
        h.b(th, "throwable");
        u uVar = this.$liveData;
        a aVar = (a) uVar.a();
        uVar.b(new a.b(th, aVar != null ? aVar.a() : null));
    }
}
