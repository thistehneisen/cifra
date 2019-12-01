package e.b.d.d;

import e.b.b.b;
import e.b.c.e;
import e.b.f.a;
import e.b.p;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ConsumerSingleObserver */
public final class f<T> extends AtomicReference<b> implements p<T>, b, a {
    private static final long serialVersionUID = -7012088219455310787L;
    final e<? super Throwable> onError;
    final e<? super T> onSuccess;

    public f(e<? super T> eVar, e<? super Throwable> eVar2) {
        this.onSuccess = eVar;
        this.onError = eVar2;
    }

    public void a(Throwable th) {
        lazySet(e.b.d.a.b.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            e.b.g.a.b((Throwable) new CompositeException(th, th2));
        }
    }

    public void b(T t) {
        lazySet(e.b.d.a.b.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            e.b.g.a.b(th);
        }
    }

    public void a(b bVar) {
        e.b.d.a.b.b(this, bVar);
    }

    public void b() {
        e.b.d.a.b.a((AtomicReference<b>) this);
    }

    public boolean a() {
        return get() == e.b.d.a.b.DISPOSED;
    }
}
