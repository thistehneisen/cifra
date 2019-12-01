package l.a.c.c;

import androidx.lifecycle.u;
import kotlin.e.a.b;
import kotlin.e.b.i;
import kotlin.m;
import l.a.c.a.a.d;

/* compiled from: BaseLiveDataDispatcher.kt */
final class f extends i implements b<T, m> {
    final /* synthetic */ u $liveData;

    f(u uVar) {
        this.$liveData = uVar;
        super(1);
    }

    public final void a(T t) {
        this.$liveData.b(new d(t));
    }
}
