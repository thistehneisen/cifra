package e.b.d.d;

import e.b.b.b;
import e.b.c;
import e.b.f.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EmptyCompletableObserver */
public final class h extends AtomicReference<b> implements c, b, a {
    private static final long serialVersionUID = -7545121636549663526L;

    public boolean a() {
        return get() == e.b.d.a.b.DISPOSED;
    }

    public void b() {
        e.b.d.a.b.a((AtomicReference<b>) this);
    }

    public void c() {
        lazySet(e.b.d.a.b.DISPOSED);
    }

    public void a(Throwable th) {
        lazySet(e.b.d.a.b.DISPOSED);
        e.b.g.a.b((Throwable) new OnErrorNotImplementedException(th));
    }

    public void a(b bVar) {
        e.b.d.a.b.b(this, bVar);
    }
}
