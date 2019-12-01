package kotlin.c;

import kotlin.c.f.b;
import kotlin.c.f.c;
import kotlin.e.b.h;

/* compiled from: CoroutineContextImpl.kt */
public abstract class a implements b {
    private final c<?> key;

    public a(c<?> cVar) {
        h.b(cVar, "key");
        this.key = cVar;
    }

    public <R> R fold(R r, kotlin.e.a.c<? super R, ? super b, ? extends R> cVar) {
        h.b(cVar, "operation");
        return kotlin.c.f.b.a.a(this, r, cVar);
    }

    public <E extends b> E get(c<E> cVar) {
        h.b(cVar, "key");
        return kotlin.c.f.b.a.a((b) this, cVar);
    }

    public c<?> getKey() {
        return this.key;
    }

    public f minusKey(c<?> cVar) {
        h.b(cVar, "key");
        return kotlin.c.f.b.a.b(this, cVar);
    }

    public f plus(f fVar) {
        h.b(fVar, "context");
        return kotlin.c.f.b.a.a((b) this, fVar);
    }
}
