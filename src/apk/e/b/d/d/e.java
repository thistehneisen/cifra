package e.b.d.d;

import e.b.b.b;
import e.b.c;
import e.b.f.a;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CallbackCompletableObserver */
public final class e extends AtomicReference<b> implements c, b, e.b.c.e<Throwable>, a {
    private static final long serialVersionUID = -4361286194466301354L;
    final e.b.c.a onComplete;
    final e.b.c.e<? super Throwable> onError;

    public e(e.b.c.e<? super Throwable> eVar, e.b.c.a aVar) {
        this.onError = eVar;
        this.onComplete = aVar;
    }

    public void a(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            e.b.g.a.b(th2);
        }
        lazySet(e.b.d.a.b.DISPOSED);
    }

    /* renamed from: b */
    public void accept(Throwable th) {
        e.b.g.a.b((Throwable) new OnErrorNotImplementedException(th));
    }

    public void c() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            e.b.g.a.b(th);
        }
        lazySet(e.b.d.a.b.DISPOSED);
    }

    public void b() {
        e.b.d.a.b.a((AtomicReference<b>) this);
    }

    public void a(b bVar) {
        e.b.d.a.b.b(this, bVar);
    }

    public boolean a() {
        return get() == e.b.d.a.b.DISPOSED;
    }
}
