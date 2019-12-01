package e.b.d.g;

import e.b.n;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler */
public final class o extends n {

    /* renamed from: b reason: collision with root package name */
    private static final o f8267b = new o();

    /* compiled from: TrampolineScheduler */
    static final class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final Runnable f8268a;

        /* renamed from: b reason: collision with root package name */
        private final c f8269b;

        /* renamed from: c reason: collision with root package name */
        private final long f8270c;

        a(Runnable runnable, c cVar, long j2) {
            this.f8268a = runnable;
            this.f8269b = cVar;
            this.f8270c = j2;
        }

        public void run() {
            if (!this.f8269b.f8278d) {
                long a2 = this.f8269b.a(TimeUnit.MILLISECONDS);
                long j2 = this.f8270c;
                if (j2 > a2) {
                    try {
                        Thread.sleep(j2 - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        e.b.g.a.b((Throwable) e2);
                        return;
                    }
                }
                if (!this.f8269b.f8278d) {
                    this.f8268a.run();
                }
            }
        }
    }

    /* compiled from: TrampolineScheduler */
    static final class b implements Comparable<b> {

        /* renamed from: a reason: collision with root package name */
        final Runnable f8271a;

        /* renamed from: b reason: collision with root package name */
        final long f8272b;

        /* renamed from: c reason: collision with root package name */
        final int f8273c;

        /* renamed from: d reason: collision with root package name */
        volatile boolean f8274d;

        b(Runnable runnable, Long l2, int i2) {
            this.f8271a = runnable;
            this.f8272b = l2.longValue();
            this.f8273c = i2;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2 = e.b.d.b.b.a(this.f8272b, bVar.f8272b);
            return a2 == 0 ? e.b.d.b.b.a(this.f8273c, bVar.f8273c) : a2;
        }
    }

    /* compiled from: TrampolineScheduler */
    static final class c extends e.b.n.b implements e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        final PriorityBlockingQueue<b> f8275a = new PriorityBlockingQueue<>();

        /* renamed from: b reason: collision with root package name */
        private final AtomicInteger f8276b = new AtomicInteger();

        /* renamed from: c reason: collision with root package name */
        final AtomicInteger f8277c = new AtomicInteger();

        /* renamed from: d reason: collision with root package name */
        volatile boolean f8278d;

        /* compiled from: TrampolineScheduler */
        final class a implements Runnable {

            /* renamed from: a reason: collision with root package name */
            final b f8279a;

            a(b bVar) {
                this.f8279a = bVar;
            }

            public void run() {
                b bVar = this.f8279a;
                bVar.f8274d = true;
                c.this.f8275a.remove(bVar);
            }
        }

        c() {
        }

        public e.b.b.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        public void b() {
            this.f8278d = true;
        }

        public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return a(new a(runnable, this, a2), a2);
        }

        /* access modifiers changed from: 0000 */
        public e.b.b.b a(Runnable runnable, long j2) {
            if (this.f8278d) {
                return e.b.d.a.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j2), this.f8277c.incrementAndGet());
            this.f8275a.add(bVar);
            if (this.f8276b.getAndIncrement() != 0) {
                return e.b.b.c.a(new a(bVar));
            }
            int i2 = 1;
            while (!this.f8278d) {
                b bVar2 = (b) this.f8275a.poll();
                if (bVar2 == null) {
                    i2 = this.f8276b.addAndGet(-i2);
                    if (i2 == 0) {
                        return e.b.d.a.c.INSTANCE;
                    }
                } else if (!bVar2.f8274d) {
                    bVar2.f8271a.run();
                }
            }
            this.f8275a.clear();
            return e.b.d.a.c.INSTANCE;
        }

        public boolean a() {
            return this.f8278d;
        }
    }

    o() {
    }

    public static o b() {
        return f8267b;
    }

    public e.b.n.b a() {
        return new c();
    }

    public e.b.b.b a(Runnable runnable) {
        e.b.g.a.a(runnable).run();
        return e.b.d.a.c.INSTANCE;
    }

    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            e.b.g.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            e.b.g.a.b((Throwable) e2);
        }
        return e.b.d.a.c.INSTANCE;
    }
}
