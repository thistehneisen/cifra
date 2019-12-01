package kotlin.h;

import java.util.Iterator;
import kotlin.e.a.b;
import kotlin.e.b.h;

/* compiled from: Sequences.kt */
public final class l<T, R> implements c<R> {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final c<T> f10331a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final b<T, R> f10332b;

    public l(c<? extends T> cVar, b<? super T, ? extends R> bVar) {
        h.b(cVar, "sequence");
        h.b(bVar, "transformer");
        this.f10331a = cVar;
        this.f10332b = bVar;
    }

    public Iterator<R> iterator() {
        return new k(this);
    }
}
