package e.b.d.g;

import e.b.n;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler */
public final class e extends n {

    /* renamed from: b reason: collision with root package name */
    static final i f8227b;

    /* renamed from: c reason: collision with root package name */
    static final i f8228c;

    /* renamed from: d reason: collision with root package name */
    private static final long f8229d = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* renamed from: e reason: collision with root package name */
    private static final TimeUnit f8230e = TimeUnit.SECONDS;

    /* renamed from: f reason: collision with root package name */
    static final c f8231f = new c(new i("RxCachedThreadSchedulerShutdown"));

    /* renamed from: g reason: collision with root package name */
    static final a f8232g = new a(0, null, f8227b);

    /* renamed from: h reason: collision with root package name */
    final ThreadFactory f8233h;

    /* renamed from: i reason: collision with root package name */
    final AtomicReference<a> f8234i;

    /* compiled from: IoScheduler */
    static final class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final long f8235a;

        /* renamed from: b reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f8236b;

        /* renamed from: c reason: collision with root package name */
        final e.b.b.a f8237c;

        /* renamed from: d reason: collision with root package name */
        private final ScheduledExecutorService f8238d;

        /* renamed from: e reason: collision with root package name */
        private final Future<?> f8239e;

        /* renamed from: f reason: collision with root package name */
        private final ThreadFactory f8240f;

        a(long j2, TimeUnit timeUnit, ThreadFactory threadFactory) {
            Future<?> future;
            this.f8235a = timeUnit != null ? timeUnit.toNanos(j2) : 0;
            this.f8236b = new ConcurrentLinkedQueue<>();
            this.f8237c = new e.b.b.a();
            this.f8240f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, e.f8228c);
                long j3 = this.f8235a;
                future = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                future = null;
            }
            this.f8238d = scheduledExecutorService;
            this.f8239e = future;
        }

        /* access modifiers changed from: 0000 */
        public void a(c cVar) {
            cVar.a(c() + this.f8235a);
            this.f8236b.offer(cVar);
        }

        /* access modifiers changed from: 0000 */
        public c b() {
            if (this.f8237c.a()) {
                return e.f8231f;
            }
            while (!this.f8236b.isEmpty()) {
                c cVar = (c) this.f8236b.poll();
                if (cVar != null) {
                    return cVar;
                }
            }
            c cVar2 = new c(this.f8240f);
            this.f8237c.b(cVar2);
            return cVar2;
        }

        /* access modifiers changed from: 0000 */
        public long c() {
            return System.nanoTime();
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            this.f8237c.b();
            Future<?> future = this.f8239e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f8238d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        public void run() {
            a();
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            if (!this.f8236b.isEmpty()) {
                long c2 = c();
                Iterator it = this.f8236b.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.d() > c2) {
                        return;
                    }
                    if (this.f8236b.remove(cVar)) {
                        this.f8237c.a((e.b.b.b) cVar);
                    }
                }
            }
        }
    }

    /* compiled from: IoScheduler */
    static final class b extends e.b.n.b {

        /* renamed from: a reason: collision with root package name */
        private final e.b.b.a f8241a;

        /* renamed from: b reason: collision with root package name */
        private final a f8242b;

        /* renamed from: c reason: collision with root package name */
        private final c f8243c;

        /* renamed from: d reason: collision with root package name */
        final AtomicBoolean f8244d = new AtomicBoolean();

        b(a aVar) {
            this.f8242b = aVar;
            this.f8241a = new e.b.b.a();
            this.f8243c = aVar.b();
        }

        public boolean a() {
            return this.f8244d.get();
        }

        public void b() {
            if (this.f8244d.compareAndSet(false, true)) {
                this.f8241a.b();
                this.f8242b.a(this.f8243c);
            }
        }

        public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f8241a.a()) {
                return e.b.d.a.c.INSTANCE;
            }
            return this.f8243c.a(runnable, j2, timeUnit, this.f8241a);
        }
    }

    /* compiled from: IoScheduler */
    static final class c extends g {

        /* renamed from: c reason: collision with root package name */
        private long f8245c = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public void a(long j2) {
            this.f8245c = j2;
        }

        public long d() {
            return this.f8245c;
        }
    }

    static {
        f8231f.b();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f8227b = new i("RxCachedThreadScheduler", max);
        f8228c = new i("RxCachedWorkerPoolEvictor", max);
        f8232g.d();
    }

    public e() {
        this(f8227b);
    }

    public e.b.n.b a() {
        return new b((a) this.f8234i.get());
    }

    public void b() {
        a aVar = new a(f8229d, f8230e, this.f8233h);
        if (!this.f8234i.compareAndSet(f8232g, aVar)) {
            aVar.d();
        }
    }

    public e(ThreadFactory threadFactory) {
        this.f8233h = threadFactory;
        this.f8234i = new AtomicReference<>(f8232g);
        b();
    }
}
