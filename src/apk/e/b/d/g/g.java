package e.b.d.g;

import e.b.d.a.c;
import e.b.g.a;
import e.b.n.b;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker */
public class g extends b implements e.b.b.b {

    /* renamed from: a reason: collision with root package name */
    private final ScheduledExecutorService f8248a;

    /* renamed from: b reason: collision with root package name */
    volatile boolean f8249b;

    public g(ThreadFactory threadFactory) {
        this.f8248a = m.a(threadFactory);
    }

    public e.b.b.b a(Runnable runnable) {
        return a(runnable, 0, null);
    }

    public e.b.b.b b(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        j jVar = new j(a.a(runnable));
        if (j2 <= 0) {
            try {
                future = this.f8248a.submit(jVar);
            } catch (RejectedExecutionException e2) {
                a.b((Throwable) e2);
                return c.INSTANCE;
            }
        } else {
            future = this.f8248a.schedule(jVar, j2, timeUnit);
        }
        jVar.a(future);
        return jVar;
    }

    public void c() {
        if (!this.f8249b) {
            this.f8249b = true;
            this.f8248a.shutdown();
        }
    }

    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (this.f8249b) {
            return c.INSTANCE;
        }
        return a(runnable, j2, timeUnit, null);
    }

    public k a(Runnable runnable, long j2, TimeUnit timeUnit, e.b.d.a.a aVar) {
        Future future;
        k kVar = new k(a.a(runnable), aVar);
        if (aVar != null && !aVar.b(kVar)) {
            return kVar;
        }
        if (j2 <= 0) {
            try {
                future = this.f8248a.submit(kVar);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.a(kVar);
                }
                a.b((Throwable) e2);
            }
        } else {
            future = this.f8248a.schedule(kVar, j2, timeUnit);
        }
        kVar.a(future);
        return kVar;
    }

    public void b() {
        if (!this.f8249b) {
            this.f8249b = true;
            this.f8248a.shutdownNow();
        }
    }

    public boolean a() {
        return this.f8249b;
    }
}
