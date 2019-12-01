package e.b.d.g;

import e.b.b.b;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AbstractDirectTask */
abstract class a extends AtomicReference<Future<?>> implements b, e.b.i.a {

    /* renamed from: a reason: collision with root package name */
    protected static final FutureTask<Void> f8196a = new FutureTask<>(e.b.d.b.a.f7957b, null);

    /* renamed from: b reason: collision with root package name */
    protected static final FutureTask<Void> f8197b = new FutureTask<>(e.b.d.b.a.f7957b, null);
    private static final long serialVersionUID = 1811839108042568751L;
    protected final Runnable runnable;
    protected Thread runner;

    a(Runnable runnable2) {
        this.runnable = runnable2;
    }

    public final boolean a() {
        Future future = (Future) get();
        return future == f8196a || future == f8197b;
    }

    public final void b() {
        Future future = (Future) get();
        if (future != f8196a) {
            FutureTask<Void> futureTask = f8197b;
            if (future != futureTask && compareAndSet(future, futureTask) && future != null) {
                future.cancel(this.runner != Thread.currentThread());
            }
        }
    }

    public final void a(Future<?> future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 != f8196a) {
                if (future2 == f8197b) {
                    future.cancel(this.runner != Thread.currentThread());
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
