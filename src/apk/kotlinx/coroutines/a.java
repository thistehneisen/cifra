package kotlinx.coroutines;

import kotlin.c.e;
import kotlin.c.f;
import kotlin.c.f.b;
import kotlin.c.f.c;
import kotlin.e.b.h;

/* compiled from: CoroutineDispatcher.kt */
public abstract class a extends kotlin.c.a implements e {
    public a() {
        super(e.f10297c);
    }

    public <E extends b> E get(c<E> cVar) {
        h.b(cVar, "key");
        return kotlin.c.e.a.a(this, cVar);
    }

    public f minusKey(c<?> cVar) {
        h.b(cVar, "key");
        return kotlin.c.e.a.b(this, cVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c.a(this));
        sb.append('@');
        sb.append(c.b(this));
        return sb.toString();
    }
}
