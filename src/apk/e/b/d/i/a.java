package e.b.d.i;

import e.b.d.c.g;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BasicIntQueueSubscription */
public abstract class a<T> extends AtomicInteger implements g<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
