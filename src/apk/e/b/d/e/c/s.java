package e.b.d.e.c;

import e.b.c.g;
import e.b.d.a.c;
import e.b.d.b.b;
import e.b.d.c.e;
import e.b.l;
import e.b.m;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableScalarXMap */
public final class s {

    /* compiled from: ObservableScalarXMap */
    public static final class a<T> extends AtomicInteger implements e<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;
        final m<? super T> observer;
        final T value;

        public a(m<? super T> mVar, T t) {
            this.observer = mVar;
            this.value = t;
        }

        public boolean a() {
            return get() == 3;
        }

        public void b() {
            set(3);
        }

        public void clear() {
            lazySet(3);
        }

        public boolean isEmpty() {
            return get() != 1;
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.a(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.c();
                }
            }
        }

        public int b(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }
    }

    public static <T, R> boolean a(l<T> lVar, m<? super R> mVar, g<? super T, ? extends l<? extends R>> gVar) {
        if (!(lVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) lVar).call();
            if (call == null) {
                c.a(mVar);
                return true;
            }
            try {
                Object apply = gVar.apply(call);
                b.a(apply, "The mapper returned a null ObservableSource");
                l lVar2 = (l) apply;
                if (lVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) lVar2).call();
                        if (call2 == null) {
                            c.a(mVar);
                            return true;
                        }
                        a aVar = new a(mVar, call2);
                        mVar.a((e.b.b.b) aVar);
                        aVar.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        c.a(th, mVar);
                        return true;
                    }
                } else {
                    lVar2.a(mVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                c.a(th2, mVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            c.a(th3, mVar);
            return true;
        }
    }
}
