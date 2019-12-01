package e.b.d.g;

import e.b.d.a.c;
import e.b.n.b;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler */
public final class n extends e.b.n {

    /* renamed from: b reason: collision with root package name */
    static final i f8260b = new i("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);

    /* renamed from: c reason: collision with root package name */
    static final ScheduledExecutorService f8261c = Executors.newScheduledThreadPool(0);

    /* renamed from: d reason: collision with root package name */
    final ThreadFactory f8262d;

    /* renamed from: e reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f8263e;

    /* compiled from: SingleScheduler */
    static final class a extends b {

        /* renamed from: a reason: collision with root package name */
        final ScheduledExecutorService f8264a;

        /* renamed from: b reason: collision with root package name */
        final e.b.b.a f8265b = new e.b.b.a();

        /* renamed from: c reason: collision with root package name */
        volatile boolean f8266c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f8264a = scheduledExecutorService;
        }

        public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            Future future;
            if (this.f8266c) {
                return c.INSTANCE;
            }
            k kVar = new k(e.b.g.a.a(runnable), this.f8265b);
            this.f8265b.b(kVar);
            if (j2 <= 0) {
                try {
                    future = this.f8264a.submit(kVar);
                } catch (RejectedExecutionException e2) {
                    b();
                    e.b.g.a.b((Throwable) e2);
                    return c.INSTANCE;
                }
            } else {
                future = this.f8264a.schedule(kVar, j2, timeUnit);
            }
            kVar.a(future);
            return kVar;
        }

        public void b() {
            if (!this.f8266c) {
                this.f8266c = true;
                this.f8265b.b();
            }
        }

        public boolean a() {
            return this.f8266c;
        }
    }

    static {
        f8261c.shutdown();
    }

    public n() {
        this(f8260b);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return m.a(threadFactory);
    }

    public n(ThreadFactory threadFactory) {
        this.f8263e = new AtomicReference<>();
        this.f8262d = threadFactory;
        this.f8263e.lazySet(a(threadFactory));
    }

    public b a() {
        return new a((ScheduledExecutorService) this.f8263e.get());
    }

    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        Future future;
        j jVar = new j(e.b.g.a.a(runnable));
        if (j2 <= 0) {
            try {
                future = ((ScheduledExecutorService) this.f8263e.get()).submit(jVar);
            } catch (RejectedExecutionException e2) {
                e.b.g.a.b((Throwable) e2);
                return c.INSTANCE;
            }
        } else {
            future = ((ScheduledExecutorService) this.f8263e.get()).schedule(jVar, j2, timeUnit);
        }
        jVar.a(future);
        return jVar;
    }
}
