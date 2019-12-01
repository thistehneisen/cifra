package e.b.d.j;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AtomicThrowable */
public final class b extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean a(Throwable th) {
        return f.a(this, th);
    }

    public Throwable a() {
        return f.a((AtomicReference<Throwable>) this);
    }
}
