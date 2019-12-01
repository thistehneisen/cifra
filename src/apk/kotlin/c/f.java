package kotlin.c;

import kotlin.TypeCastException;
import kotlin.e.b.h;

/* compiled from: CoroutineContext.kt */
public interface f {

    /* compiled from: CoroutineContext.kt */
    public static final class a {
        public static f a(f fVar, f fVar2) {
            h.b(fVar2, "context");
            return fVar2 == h.f10300a ? fVar : (f) fVar2.fold(fVar, g.f10299a);
        }
    }

    /* compiled from: CoroutineContext.kt */
    public interface b extends f {

        /* compiled from: CoroutineContext.kt */
        public static final class a {
            public static <E extends b> E a(b bVar, c<E> cVar) {
                h.b(cVar, "key");
                if (!h.a((Object) bVar.getKey(), (Object) cVar)) {
                    return null;
                }
                if (bVar != null) {
                    return bVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type E");
            }

            public static f a(b bVar, f fVar) {
                h.b(fVar, "context");
                return a.a(bVar, fVar);
            }

            public static f b(b bVar, c<?> cVar) {
                h.b(cVar, "key");
                return h.a((Object) bVar.getKey(), (Object) cVar) ? h.f10300a : bVar;
            }

            public static <R> R a(b bVar, R r, kotlin.e.a.c<? super R, ? super b, ? extends R> cVar) {
                h.b(cVar, "operation");
                return cVar.a(r, bVar);
            }
        }

        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    public interface c<E extends b> {
    }

    <R> R fold(R r, kotlin.e.a.c<? super R, ? super b, ? extends R> cVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);

    f plus(f fVar);
}
