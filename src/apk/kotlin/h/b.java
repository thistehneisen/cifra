package kotlin.h;

import java.util.Iterator;
import kotlin.e.b.h;

/* compiled from: Sequences.kt */
public final class b<T> implements c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final c<T> f10326a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final boolean f10327b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final kotlin.e.a.b<T, Boolean> f10328c;

    public b(c<? extends T> cVar, boolean z, kotlin.e.a.b<? super T, Boolean> bVar) {
        h.b(cVar, "sequence");
        h.b(bVar, "predicate");
        this.f10326a = cVar;
        this.f10327b = z;
        this.f10328c = bVar;
    }

    public Iterator<T> iterator() {
        return new a(this);
    }
}
