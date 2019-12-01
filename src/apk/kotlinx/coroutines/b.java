package kotlinx.coroutines;

import kotlin.c.f;
import kotlin.c.f.c;
import kotlin.e.b.h;

/* compiled from: CoroutineContext.kt */
public final class b extends kotlin.c.a implements g<String> {

    /* renamed from: a reason: collision with root package name */
    public static final a f10355a = new a(null);

    /* renamed from: b reason: collision with root package name */
    private final long f10356b;

    /* compiled from: CoroutineContext.kt */
    public static final class a implements c<b> {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                if (this.f10356b == ((b) obj).f10356b) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public <R> R fold(R r, kotlin.e.a.c<? super R, ? super kotlin.c.f.b, ? extends R> cVar) {
        h.b(cVar, "operation");
        return kotlinx.coroutines.g.a.a(this, r, cVar);
    }

    public <E extends kotlin.c.f.b> E get(c<E> cVar) {
        h.b(cVar, "key");
        return kotlinx.coroutines.g.a.a((g<S>) this, cVar);
    }

    public int hashCode() {
        long j2 = this.f10356b;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public f minusKey(c<?> cVar) {
        h.b(cVar, "key");
        return kotlinx.coroutines.g.a.b(this, cVar);
    }

    public f plus(f fVar) {
        h.b(fVar, "context");
        return kotlinx.coroutines.g.a.a((g<S>) this, fVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CoroutineId(");
        sb.append(this.f10356b);
        sb.append(')');
        return sb.toString();
    }
}
