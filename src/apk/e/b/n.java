package e.b;

import e.b.d.g.g;
import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler */
public abstract class n {

    /* renamed from: a reason: collision with root package name */
    static final long f8374a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler */
    static final class a implements e.b.b.b, Runnable, e.b.i.a {

        /* renamed from: a reason: collision with root package name */
        final Runnable f8375a;

        /* renamed from: b reason: collision with root package name */
        final b f8376b;

        /* renamed from: c reason: collision with root package name */
        Thread f8377c;

        a(Runnable runnable, b bVar) {
            this.f8375a = runnable;
            this.f8376b = bVar;
        }

        public boolean a() {
            return this.f8376b.a();
        }

        public void b() {
            if (this.f8377c == Thread.currentThread()) {
                b bVar = this.f8376b;
                if (bVar instanceof g) {
                    ((g) bVar).c();
                    return;
                }
            }
            this.f8376b.b();
        }

        public void run() {
            this.f8377c = Thread.currentThread();
            try {
                this.f8375a.run();
            } finally {
                b();
                this.f8377c = null;
            }
        }
    }

    /* compiled from: Scheduler */
    public static abstract class b implements e.b.b.b {
        public e.b.b.b a(Runnable runnable) {
            return a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public abstract e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit);

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public e.b.b.b a(Runnable runnable) {
        return a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public abstract b a();

    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        b a2 = a();
        a aVar = new a(e.b.g.a.a(runnable), a2);
        a2.a(aVar, j2, timeUnit);
        return aVar;
    }
}
