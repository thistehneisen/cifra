package e.b.d.a;

import e.b.b.b;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequentialDisposable */
public final class f extends AtomicReference<b> implements b {
    private static final long serialVersionUID = -754898800686245608L;

    public f() {
    }

    public boolean a(b bVar) {
        return b.a((AtomicReference<b>) this, bVar);
    }

    public void b() {
        b.a((AtomicReference<b>) this);
    }

    public f(b bVar) {
        lazySet(bVar);
    }

    public boolean a() {
        return b.a((b) get());
    }
}
