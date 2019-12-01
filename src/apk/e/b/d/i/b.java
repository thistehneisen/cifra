package e.b.d.i;

import k.a.c;

/* compiled from: DeferredScalarSubscription */
public class b<T> extends a<T> {
    private static final long serialVersionUID = -2151279923272604993L;
    protected final c<? super T> downstream;
    protected T value;

    public b(c<? super T> cVar) {
        this.downstream = cVar;
    }

    public final void a(long j2) {
        if (f.c(j2)) {
            do {
                int i2 = get();
                if ((i2 & -2) == 0) {
                    if (i2 == 1) {
                        if (compareAndSet(1, 3)) {
                            T t = this.value;
                            if (t != null) {
                                this.value = null;
                                c<? super T> cVar = this.downstream;
                                cVar.a(t);
                                if (get() != 4) {
                                    cVar.c();
                                }
                            }
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    public final int b(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void c(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & -3) == 0) {
                if (i2 == 2) {
                    lazySet(3);
                    c<? super T> cVar = this.downstream;
                    cVar.a(t);
                    if (get() != 4) {
                        cVar.c();
                    }
                    return;
                }
                this.value = t;
                if (!compareAndSet(0, 1)) {
                    i2 = get();
                    if (i2 == 4) {
                        this.value = null;
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        this.value = t;
        lazySet(16);
        c<? super T> cVar2 = this.downstream;
        cVar2.a(t);
        if (get() != 4) {
            cVar2.c();
        }
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }
}
