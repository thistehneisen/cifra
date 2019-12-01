package e.b.d.f;

import e.b.d.c.i;
import e.b.d.j.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscArrayQueue */
public final class b<E> extends AtomicReferenceArray<E> implements i<E> {

    /* renamed from: a reason: collision with root package name */
    private static final Integer f8185a = Integer.getInteger("jctools.spsc.max.lookahead.step", CodedOutputStream.DEFAULT_BUFFER_SIZE);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    public b(int i2) {
        super(j.a(i2));
        this.lookAheadStep = Math.min(i2 / 4, f8185a.intValue());
    }

    /* access modifiers changed from: 0000 */
    public int a(long j2) {
        return this.mask & ((int) j2);
    }

    /* access modifiers changed from: 0000 */
    public int a(long j2, int i2) {
        return ((int) j2) & i2;
    }

    /* access modifiers changed from: 0000 */
    public void b(long j2) {
        this.consumerIndex.lazySet(j2);
    }

    /* access modifiers changed from: 0000 */
    public void c(long j2) {
        this.producerIndex.lazySet(j2);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public boolean offer(E e2) {
        if (e2 != null) {
            int i2 = this.mask;
            long j2 = this.producerIndex.get();
            int a2 = a(j2, i2);
            if (j2 >= this.producerLookAhead) {
                long j3 = ((long) this.lookAheadStep) + j2;
                if (a(a(j3, i2)) == null) {
                    this.producerLookAhead = j3;
                } else if (a(a2) != null) {
                    return false;
                }
            }
            a(a2, e2);
            c(j2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long j2 = this.consumerIndex.get();
        int a2 = a(j2);
        E a3 = a(a2);
        if (a3 == null) {
            return null;
        }
        b(j2 + 1);
        a(a2, (E) null);
        return a3;
    }

    /* access modifiers changed from: 0000 */
    public void a(int i2, E e2) {
        lazySet(i2, e2);
    }

    /* access modifiers changed from: 0000 */
    public E a(int i2) {
        return get(i2);
    }
}
