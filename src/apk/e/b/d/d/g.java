package e.b.d.d;

import e.b.g.a;
import e.b.m;

/* compiled from: DeferredScalarDisposable */
public class g<T> extends b<T> {
    private static final long serialVersionUID = -5502432239815349361L;
    protected final m<? super T> downstream;
    protected T value;

    public g(m<? super T> mVar) {
        this.downstream = mVar;
    }

    public final boolean a() {
        return get() == 4;
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
        if ((i2 & 54) == 0) {
            m<? super T> mVar = this.downstream;
            if (i2 == 8) {
                this.value = t;
                lazySet(16);
                mVar.a(null);
            } else {
                lazySet(2);
                mVar.a(t);
            }
            if (get() != 4) {
                mVar.c();
            }
        }
    }

    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    public final void b(Throwable th) {
        if ((get() & 54) != 0) {
            a.b(th);
            return;
        }
        lazySet(2);
        this.downstream.a(th);
    }

    public void b() {
        set(4);
        this.value = null;
    }
}
