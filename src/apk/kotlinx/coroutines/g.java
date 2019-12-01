package kotlinx.coroutines;

import kotlin.c.f;
import kotlin.c.f.b;
import kotlin.e.a.c;
import kotlin.e.b.h;

/* compiled from: ThreadContextElement.kt */
public interface g<S> extends b {

    /* compiled from: ThreadContextElement.kt */
    public static final class a {
        public static <S, R> R a(g<S> gVar, R r, c<? super R, ? super b, ? extends R> cVar) {
            h.b(cVar, "operation");
            return kotlin.c.f.b.a.a(gVar, r, cVar);
        }

        public static <S, E extends b> E a(g<S> gVar, f.c<E> cVar) {
            h.b(cVar, "key");
            return kotlin.c.f.b.a.a((b) gVar, cVar);
        }

        public static <S> f a(g<S> gVar, f fVar) {
            h.b(fVar, "context");
            return kotlin.c.f.b.a.a((b) gVar, fVar);
        }

        public static <S> f b(g<S> gVar, f.c<?> cVar) {
            h.b(cVar, "key");
            return kotlin.c.f.b.a.b(gVar, cVar);
        }
    }
}
