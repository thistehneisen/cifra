package e.b.d.f;

import e.b.d.c.i;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MpscLinkedQueue */
public final class a<T> implements i<T> {

    /* renamed from: a reason: collision with root package name */
    private final AtomicReference<C0089a<T>> f8183a = new AtomicReference<>();

    /* renamed from: b reason: collision with root package name */
    private final AtomicReference<C0089a<T>> f8184b = new AtomicReference<>();

    /* renamed from: e.b.d.f.a$a reason: collision with other inner class name */
    /* compiled from: MpscLinkedQueue */
    static final class C0089a<E> extends AtomicReference<C0089a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        C0089a() {
        }

        public E a() {
            E b2 = b();
            a((E) null);
            return b2;
        }

        public E b() {
            return this.value;
        }

        public C0089a<E> c() {
            return (C0089a) get();
        }

        C0089a(E e2) {
            a(e2);
        }

        public void a(E e2) {
            this.value = e2;
        }

        public void a(C0089a<E> aVar) {
            lazySet(aVar);
        }
    }

    public a() {
        C0089a aVar = new C0089a();
        a(aVar);
        b(aVar);
    }

    /* access modifiers changed from: 0000 */
    public C0089a<T> a() {
        return (C0089a) this.f8184b.get();
    }

    /* access modifiers changed from: 0000 */
    public C0089a<T> b(C0089a<T> aVar) {
        return (C0089a) this.f8183a.getAndSet(aVar);
    }

    /* access modifiers changed from: 0000 */
    public C0089a<T> c() {
        return (C0089a) this.f8183a.get();
    }

    public void clear() {
        while (poll() != null) {
            if (isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return b() == c();
    }

    public boolean offer(T t) {
        if (t != null) {
            C0089a aVar = new C0089a(t);
            b(aVar).a(aVar);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T poll() {
        C0089a c2;
        C0089a a2 = a();
        C0089a c3 = a2.c();
        if (c3 != null) {
            T a3 = c3.a();
            a(c3);
            return a3;
        } else if (a2 == c()) {
            return null;
        } else {
            do {
                c2 = a2.c();
            } while (c2 == null);
            T a4 = c2.a();
            a(c2);
            return a4;
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(C0089a<T> aVar) {
        this.f8184b.lazySet(aVar);
    }

    /* access modifiers changed from: 0000 */
    public C0089a<T> b() {
        return (C0089a) this.f8184b.get();
    }
}
