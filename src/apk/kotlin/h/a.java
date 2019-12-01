package kotlin.h;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
public final class a implements Iterator<T>, kotlin.e.b.a.a {

    /* renamed from: a reason: collision with root package name */
    private final Iterator<T> f10322a;

    /* renamed from: b reason: collision with root package name */
    private int f10323b = -1;

    /* renamed from: c reason: collision with root package name */
    private T f10324c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ b f10325d;

    a(b bVar) {
        this.f10325d = bVar;
        this.f10322a = bVar.f10326a.iterator();
    }

    private final void a() {
        while (this.f10322a.hasNext()) {
            T next = this.f10322a.next();
            if (((Boolean) this.f10325d.f10328c.a(next)).booleanValue() == this.f10325d.f10327b) {
                this.f10324c = next;
                this.f10323b = 1;
                return;
            }
        }
        this.f10323b = 0;
    }

    public boolean hasNext() {
        if (this.f10323b == -1) {
            a();
        }
        return this.f10323b == 1;
    }

    public T next() {
        if (this.f10323b == -1) {
            a();
        }
        if (this.f10323b != 0) {
            T t = this.f10324c;
            this.f10324c = null;
            this.f10323b = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
