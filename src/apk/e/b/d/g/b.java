package e.b.d.g;

import e.b.d.a.d;
import e.b.n;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler */
public final class b extends n implements l {

    /* renamed from: b reason: collision with root package name */
    static final C0090b f8198b = new C0090b(0, f8199c);

    /* renamed from: c reason: collision with root package name */
    static final i f8199c = new i("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);

    /* renamed from: d reason: collision with root package name */
    static final int f8200d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e reason: collision with root package name */
    static final c f8201e = new c(new i("RxComputationShutdown"));

    /* renamed from: f reason: collision with root package name */
    final ThreadFactory f8202f;

    /* renamed from: g reason: collision with root package name */
    final AtomicReference<C0090b> f8203g;

    /* compiled from: ComputationScheduler */
    static final class a extends e.b.n.b {

        /* renamed from: a reason: collision with root package name */
        private final d f8204a = new d();

        /* renamed from: b reason: collision with root package name */
        private final e.b.b.a f8205b = new e.b.b.a();

        /* renamed from: c reason: collision with root package name */
        private final d f8206c = new d();

        /* renamed from: d reason: collision with root package name */
        private final c f8207d;

        /* renamed from: e reason: collision with root package name */
        volatile boolean f8208e;

        a(c cVar) {
            this.f8207d = cVar;
            this.f8206c.b(this.f8204a);
            this.f8206c.b(this.f8205b);
        }

        public boolean a() {
            return this.f8208e;
        }

        public void b() {
            if (!this.f8208e) {
                this.f8208e = true;
                this.f8206c.b();
            }
        }

        public e.b.b.b a(Runnable runnable) {
            if (this.f8208e) {
                return e.b.d.a.c.INSTANCE;
            }
            return this.f8207d.a(runnable, 0, TimeUnit.MILLISECONDS, this.f8204a);
        }

        public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (this.f8208e) {
                return e.b.d.a.c.INSTANCE;
            }
            return this.f8207d.a(runnable, j2, timeUnit, this.f8205b);
        }
    }

    /* renamed from: e.b.d.g.b$b reason: collision with other inner class name */
    /* compiled from: ComputationScheduler */
    static final class C0090b implements l {

        /* renamed from: a reason: collision with root package name */
        final int f8209a;

        /* renamed from: b reason: collision with root package name */
        final c[] f8210b;

        /* renamed from: c reason: collision with root package name */
        long f8211c;

        C0090b(int i2, ThreadFactory threadFactory) {
            this.f8209a = i2;
            this.f8210b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f8210b[i3] = new c(threadFactory);
            }
        }

        public c a() {
            int i2 = this.f8209a;
            if (i2 == 0) {
                return b.f8201e;
            }
            c[] cVarArr = this.f8210b;
            long j2 = this.f8211c;
            this.f8211c = 1 + j2;
            return cVarArr[(int) (j2 % ((long) i2))];
        }

        public void b() {
            for (c b2 : this.f8210b) {
                b2.b();
            }
        }
    }

    /* compiled from: ComputationScheduler */
    static final class c extends g {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        f8201e.b();
        f8198b.b();
    }

    public b() {
        this(f8199c);
    }

    static int a(int i2, int i3) {
        return (i3 <= 0 || i3 > i2) ? i2 : i3;
    }

    public e.b.n.b a() {
        return new a(((C0090b) this.f8203g.get()).a());
    }

    public void b() {
        C0090b bVar = new C0090b(f8200d, this.f8202f);
        if (!this.f8203g.compareAndSet(f8198b, bVar)) {
            bVar.b();
        }
    }

    public b(ThreadFactory threadFactory) {
        this.f8202f = threadFactory;
        this.f8203g = new AtomicReference<>(f8198b);
        b();
    }

    public e.b.b.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        return ((C0090b) this.f8203g.get()).a().b(runnable, j2, timeUnit);
    }
}
