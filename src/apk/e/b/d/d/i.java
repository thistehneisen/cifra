package e.b.d.d;

import e.b.b.b;
import e.b.c.e;
import e.b.f.a;
import e.b.m;
import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LambdaObserver */
public final class i<T> extends AtomicReference<b> implements m<T>, b, a {
    private static final long serialVersionUID = -7251123623727029452L;
    final e.b.c.a onComplete;
    final e<? super Throwable> onError;
    final e<? super T> onNext;
    final e<? super b> onSubscribe;

    public i(e<? super T> eVar, e<? super Throwable> eVar2, e.b.c.a aVar, e<? super b> eVar3) {
        this.onNext = eVar;
        this.onError = eVar2;
        this.onComplete = aVar;
        this.onSubscribe = eVar3;
    }

    public void a(b bVar) {
        if (e.b.d.a.b.b(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.b();
                a(th);
            }
        }
    }

    public void b() {
        e.b.d.a.b.a((AtomicReference<b>) this);
    }

    public void c() {
        if (!a()) {
            lazySet(e.b.d.a.b.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                e.b.g.a.b(th);
            }
        }
    }

    public void a(T t) {
        if (!a()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ((b) get()).b();
                a(th);
            }
        }
    }

    public void a(Throwable th) {
        if (!a()) {
            lazySet(e.b.d.a.b.DISPOSED);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                e.b.g.a.b((Throwable) new CompositeException(th, th2));
            }
        } else {
            e.b.g.a.b(th);
        }
    }

    public boolean a() {
        return get() == e.b.d.a.b.DISPOSED;
    }
}
