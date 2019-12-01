package kotlin.h;

import java.util.Iterator;
import kotlin.e.b.a.a;

/* compiled from: Sequences.kt */
public final class k implements Iterator<R>, a {

    /* renamed from: a reason: collision with root package name */
    private final Iterator<T> f10329a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ l f10330b;

    k(l lVar) {
        this.f10330b = lVar;
        this.f10329a = lVar.f10331a.iterator();
    }

    public boolean hasNext() {
        return this.f10329a.hasNext();
    }

    public R next() {
        return this.f10330b.f10332b.a(this.f10329a.next());
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
