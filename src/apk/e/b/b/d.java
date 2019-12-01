package e.b.b;

import e.b.d.b.b;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ReferenceDisposable */
abstract class d<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    d(T t) {
        b.a(t, "value is null");
        super(t);
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t);

    public final boolean a() {
        return get() == null;
    }

    public final void b() {
        if (get() != null) {
            Object andSet = getAndSet(null);
            if (andSet != null) {
                a(andSet);
            }
        }
    }
}
