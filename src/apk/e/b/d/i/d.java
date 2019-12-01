package e.b.d.i;

import e.b.d.c.g;
import java.util.concurrent.atomic.AtomicInteger;
import k.a.c;

/* compiled from: ScalarSubscription */
public final class d<T> extends AtomicInteger implements g<T> {
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public d(c<? super T> cVar, T t) {
        this.subscriber = cVar;
        this.value = t;
    }

    public void a(long j2) {
        if (f.c(j2) && compareAndSet(0, 1)) {
            c<? super T> cVar = this.subscriber;
            cVar.a(this.value);
            if (get() != 2) {
                cVar.c();
            }
        }
    }

    public int b(int i2) {
        return i2 & 1;
    }

    public void cancel() {
        lazySet(2);
    }

    public void clear() {
        lazySet(1);
    }

    public boolean isEmpty() {
        return get() != 0;
    }

    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }
}
