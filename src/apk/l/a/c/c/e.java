package l.a.c.c;

import androidx.lifecycle.u;
import kotlin.e.a.b;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.m;
import l.a.c.a.b.C0119b;

/* compiled from: BaseLiveDataDispatcher.kt */
final class e extends i implements b<Throwable, m> {
    final /* synthetic */ u $liveData;

    e(u uVar) {
        this.$liveData = uVar;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        a((Throwable) obj);
        return m.f10346a;
    }

    public final void a(Throwable th) {
        h.b(th, "throwable");
        this.$liveData.b(new C0119b(th));
    }
}
