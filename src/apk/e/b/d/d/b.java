package e.b.d.d;

import e.b.d.c.e;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BasicIntQueueDisposable */
public abstract class b<T> extends AtomicInteger implements e<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
