package e.b.d.g;

import e.b.d.a.f;
import e.b.n;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ExecutorScheduler */
public final class d extends n {

    /* renamed from: b reason: collision with root package name */
    static final n f8213b = e.b.i.b.c();

    /* renamed from: c reason: collision with root package name */
    final boolean f8214c;

    /* renamed from: d reason: collision with root package name */
    final Executor f8215d;

    /* compiled from: ExecutorScheduler */
    final class a implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final b f8216a;

        a(b bVar) {
            this.f8216a = bVar;
        }

        public void run() {
            b bVar = this.f8216a;
            bVar.direct.a(d.this.a(bVar));
        }
    }

    /* compiled from: ExecutorScheduler */
    static final class b extends AtomicReference<Runnable> implements Runnable, e.b.b.b, e.b.i.a {
        private static final long serialVersionUID = -4101336210206799084L;
        final f direct = new f();
        final f timed = new f();

        b(Runnable runnable) {
            super(runnable);
        }

        public boolean a() {
            return get() == null;
        }

        public void b() {
            if (getAndSet(null) != null) {
                this.timed.b();
                this.direct.b();
            }
        }

        public void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                } finally {
                    lazySet(null);
                    this.timed.lazySet(e.b.d.a.b.DISPOSED);
                    this.direct.lazySet(e.b.d.a.b.DISPOSED);
                }
            }
        }
    }

    /* compiled from: ExecutorScheduler */
    public static final class c extends e.b.n.b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        final boolean f8218a;

        /* renamed from: b reason: collision with root package name */
        final Executor f8219b;

        /* renamed from: c reason: collision with root package name */
        final e.b.d.f.a<Runnable> f8220c;

        /* renamed from: d reason: collision with root package name */
        volatile boolean f8221d;

        /* renamed from: e reason: collision with root package name */
        final AtomicInteger f8222e = new AtomicInteger();

        /* renamed from: f reason: collision with root package name */
        final e.b.b.a f8223f = new e.b.b.a();

        /* compiled from: ExecutorScheduler */
        static final class a extends AtomicBoolean implements Runnable, e.b.b.b {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            a(Runnable runnable) {
                this.actual = runnable;
            }

            public boolean a() {
                return get();
            }

            public void b() {
                lazySet(true);
            }

            public void run() {
                if (!get()) {
                    try {
                        this.actual.run();
                    } finally {
                        lazySet(true);
                    }
                }
            }
        }

        /* compiled from: ExecutorScheduler */
        static final class b extends AtomicInteger implements Runnable, e.b.b.b {
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final e.b.d.a.a tasks;
            volatile Thread thread;

            b(Runnable runnable, e.b.d.a.a aVar) {
                this.run = runnable;
                this.tasks = aVar;
            }

            public boolean a() {
                return get() >= 2;
            }

            public void b() {
                while (true) {
                    int i2 = get();
                    if (i2 < 2) {
                        if (i2 == 0) {
                            if (compareAndSet(0, 4)) {
                                c();
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread2 = this.thread;
                            if (thread2 != null) {
                                thread2.interrupt();
                                this.thread = null;
                            }
                            set(4);
                            c();
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            /* access modifiers changed from: 0000 */
            public void c() {
                e.b.d.a.a aVar = this.tasks;
                if (aVar != null) {
                    aVar.c(this);
                }
            }

            public void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                c();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                c();
                            }
                            throw th;
                        }
                    } else {
                        this.thread = null;
                    }
                }
            }
        }

        /* renamed from: e.b.d.g.d$c$c reason: collision with other inner class name */
        /* compiled from: ExecutorScheduler */
        final class C0091c implements Runnable {

            /* renamed from: a reason: collision with root package name */
            private final f f8224a;

            /* renamed from: b reason: collision with root package name */
            private final Runnable f8225b;

            C0091c(f fVar, Runnable runnable) {
                this.f8224a = fVar;
                this.f8225b = runnable;
            }

            public void run() {
                this.f8224a.a(c.this.a(this.f8225b));
            }
        }

        public c(Executor executor, boolean z) {
            this.f8219b = executor;
            this.f8220c = new e.b.d.f.a<>();
            this.f8218a = z;
        }

        public e.b.b.b a(Runnable runnable) {
            e.b.b.b bVar;
            if (this.f8221d) {
                return e.b.d.a.c.INSTANCE;
            }
            Runnable a2 = e.b.g.a.a(runnable);
            if (this.f8218a) {
                bVar = new b(a2, this.f8223f);
                this.f8223f.b(bVar);
            } else {
                bVar = new a(a2);
            }
            this.f8220c.offer(bVar);
            if (this.f8222e.getAndIncrement() == 0) {
                try {
                    this.f8219b.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f8221d = true;
                    this.f8220c.clear();
                    e.b.g.a.b((Throwable) e2);
                    return e.b.d.a.c.INSTANCE;
                }
            }
            return bVar;
        }

        public void b() {
            if (!this.f8221d) {
                this.f8221d = true;
                this.f8223f.b();
                if (this.f8222e.getAndIncrement() == 0) {
                    this.f8220c.clear();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r1 = r3.f8222e.addAndGet(-r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
            if (r1 != 0) goto L_0x0003;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r3.f8221d == false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            r0.clear();
         */
        public void run() {
            e.b.d.f.a<Runnable> aVar = this.f8220c;
            int i2 = 1;
            while (!this.f8221d) {
                while (true) {
                    Runnable runnable = (Runnable) aVar.poll();
                    if (runnable == null) {
                        break;
                    }
                    runnable.run();
                    if (this.f8221d) {
                        aVar.clear();
                        return;
                    }
                }
            }
            aVar.clear();
        }

        public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (j2 <= 0) {
                return a(runnable);
            }
            if (this.f8221d) {
                return e.b.d.a.c.INSTANCE;
            }
            f fVar = new f();
            f fVar2 = new f(fVar);
            k kVar = new k(new C0091c(fVar2, e.b.g.a.a(runnable)), this.f8223f);
            this.f8223f.b(kVar);
            Executor executor = this.f8219b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    kVar.a(((ScheduledExecutorService) executor).schedule(kVar, j2, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f8221d = true;
                    e.b.g.a.b((Throwable) e2);
                    return e.b.d.a.c.INSTANCE;
                }
            } else {
                kVar.a(new c(d.f8213b.a(kVar, j2, timeUnit)));
            }
            fVar.a(kVar);
            return fVar2;
        }

        public boolean a() {
            return this.f8221d;
        }
    }

    public d(Executor executor, boolean z) {
        this.f8215d = executor;
        this.f8214c = z;
    }

    public e.b.n.b a() {
        return new c(this.f8215d, this.f8214c);
    }

    public e.b.b.b a(Runnable runnable) {
        Runnable a2 = e.b.g.a.a(runnable);
        try {
            if (this.f8215d instanceof ExecutorService) {
                j jVar = new j(a2);
                jVar.a(((ExecutorService) this.f8215d).submit(jVar));
                return jVar;
            } else if (this.f8214c) {
                b bVar = new b(a2, null);
                this.f8215d.execute(bVar);
                return bVar;
            } else {
                a aVar = new a(a2);
                this.f8215d.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e2) {
            e.b.g.a.b((Throwable) e2);
            return e.b.d.a.c.INSTANCE;
        }
    }

    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        Runnable a2 = e.b.g.a.a(runnable);
        if (this.f8215d instanceof ScheduledExecutorService) {
            try {
                j jVar = new j(a2);
                jVar.a(((ScheduledExecutorService) this.f8215d).schedule(jVar, j2, timeUnit));
                return jVar;
            } catch (RejectedExecutionException e2) {
                e.b.g.a.b((Throwable) e2);
                return e.b.d.a.c.INSTANCE;
            }
        } else {
            b bVar = new b(a2);
            bVar.timed.a(f8213b.a(new a(bVar), j2, timeUnit));
            return bVar;
        }
    }
}
