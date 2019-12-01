package kotlin.c;

import java.io.Serializable;
import kotlin.c.f.b;
import kotlin.e.a.c;

/* compiled from: CoroutineContextImpl.kt */
public final class h implements f, Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final h f10300a = new h();
    private static final long serialVersionUID = 0;

    private h() {
    }

    private final Object readResolve() {
        return f10300a;
    }

    public <R> R fold(R r, c<? super R, ? super b, ? extends R> cVar) {
        kotlin.e.b.h.b(cVar, "operation");
        return r;
    }

    public <E extends b> E get(f.c<E> cVar) {
        kotlin.e.b.h.b(cVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    public f minusKey(f.c<?> cVar) {
        kotlin.e.b.h.b(cVar, "key");
        return this;
    }

    public f plus(f fVar) {
        kotlin.e.b.h.b(fVar, "context");
        return fVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
