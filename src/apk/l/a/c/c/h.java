package l.a.c.c;

import androidx.lifecycle.u;
import kotlin.e.a.a;
import kotlin.e.b.i;
import kotlin.m;
import l.a.c.a.a.C0118a;

/* compiled from: BaseLiveDataDispatcher.kt */
final class h extends i implements a<m> {
    final /* synthetic */ u $liveData;

    h(u uVar) {
        this.$liveData = uVar;
        super(0);
    }

    public final void b() {
        u uVar = this.$liveData;
        l.a.c.a.a aVar = (l.a.c.a.a) uVar.a();
        uVar.b(new C0118a(aVar != null ? aVar.a() : null));
    }
}
