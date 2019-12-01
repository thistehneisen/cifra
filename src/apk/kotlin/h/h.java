package kotlin.h;

import kotlin.e.a.b;
import kotlin.e.b.i;

/* compiled from: _SequencesJvm.kt */
final class h extends i implements b<Object, Boolean> {
    final /* synthetic */ Class $klass;

    h(Class cls) {
        this.$klass = cls;
        super(1);
    }

    public final boolean a(Object obj) {
        return this.$klass.isInstance(obj);
    }
}
