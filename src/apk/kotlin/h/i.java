package kotlin.h;

import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: _SequencesJvm.kt */
class i extends g {
    public static <R> c<R> a(c<?> cVar, Class<R> cls) {
        h.b(cVar, "$this$filterIsInstance");
        h.b(cls, "klass");
        c<R> a2 = j.a(cVar, new h(cls));
        if (a2 != null) {
            return a2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
    }
}
