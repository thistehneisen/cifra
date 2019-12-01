package l.a.d.b.b;

import e.b.c.e;
import e.b.k;
import e.b.l;
import e.b.m;
import e.b.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ObservableRefCountWithCacheTime */
public final class b<T> extends k<T> implements e.b.d.c.c<T> {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final e.b.e.a<? extends T> f10440a;

    /* renamed from: b reason: collision with root package name */
    private final l<T> f10441b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public volatile e.b.b.a f10442c = new e.b.b.a();
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public final AtomicInteger f10443d = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final ReentrantLock f10444e = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public final n f10445f = e.b.i.b.a();
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public final long f10446g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final TimeUnit f10447h;
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public e.b.n.b f10448i;

    /* compiled from: ObservableRefCountWithCacheTime */
    private final class a extends AtomicReference<e.b.b.b> implements m<T>, e.b.b.b {
        private static final long serialVersionUID = 3813126992133394324L;
        private final e.b.b.a currentBase;
        private final e.b.b.b resource;
        private final m<? super T> subscriber;

        public a(m<? super T> mVar, e.b.b.a aVar, e.b.b.b bVar) {
            this.subscriber = mVar;
            this.currentBase = aVar;
            this.resource = bVar;
        }

        private void d() {
            b.this.f10444e.lock();
            try {
                if (b.this.f10442c == this.currentBase) {
                    b.this.j();
                    if (b.this.f10440a instanceof e.b.b.b) {
                        ((e.b.b.b) b.this.f10440a).b();
                    }
                    b.this.f10442c.b();
                    b.this.f10442c = new e.b.b.a();
                    b.this.f10443d.set(0);
                }
            } finally {
                b.this.f10444e.unlock();
            }
        }

        public void a(e.b.b.b bVar) {
            e.b.d.a.b.b(this, bVar);
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
            this.resource.b();
        }

        public void c() {
            d();
            this.subscriber.c();
        }

        public void a(Throwable th) {
            d();
            this.subscriber.a(th);
        }

        public void a(T t) {
            this.subscriber.a(t);
        }

        public boolean a() {
            return e.b.d.a.b.a((e.b.b.b) get());
        }
    }

    /* renamed from: l.a.d.b.b.b$b reason: collision with other inner class name */
    /* compiled from: ObservableRefCountWithCacheTime */
    private final class C0123b implements e<e.b.b.b> {

        /* renamed from: a reason: collision with root package name */
        private final m<? super T> f10449a;

        /* renamed from: b reason: collision with root package name */
        private final AtomicBoolean f10450b;

        public C0123b(m<? super T> mVar, AtomicBoolean atomicBoolean) {
            this.f10449a = mVar;
            this.f10450b = atomicBoolean;
        }

        /* renamed from: a */
        public void accept(e.b.b.b bVar) {
            try {
                b.this.f10442c.b(bVar);
                b.this.a(this.f10449a, b.this.f10442c);
            } finally {
                b.this.f10444e.unlock();
                this.f10450b.set(false);
            }
        }
    }

    /* compiled from: ObservableRefCountWithCacheTime */
    private final class c implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final e.b.b.a f10452a;

        public c(e.b.b.a aVar) {
            this.f10452a = aVar;
        }

        public /* synthetic */ void a() {
            b.this.f10444e.lock();
            try {
                if (b.this.f10443d.get() == 0) {
                    b.this.j();
                    if (b.this.f10440a instanceof e.b.b.b) {
                        ((e.b.b.b) b.this.f10440a).b();
                    }
                    b.this.f10442c.b();
                    b.this.f10442c = new e.b.b.a();
                }
            } finally {
                b.this.f10444e.unlock();
            }
        }

        public void run() {
            b.this.f10444e.lock();
            try {
                if (b.this.f10442c == this.f10452a && b.this.f10443d.decrementAndGet() == 0) {
                    if (b.this.f10448i != null) {
                        b.this.f10448i.b();
                    } else {
                        b.this.f10448i = b.this.f10445f.a();
                    }
                    b.this.f10448i.a(new a(this), b.this.f10446g, b.this.f10447h);
                }
            } finally {
                b.this.f10444e.unlock();
            }
        }
    }

    public b(e.b.e.a<T> aVar, long j2, TimeUnit timeUnit) {
        this.f10440a = aVar;
        this.f10441b = aVar;
        this.f10446g = j2;
        this.f10447h = timeUnit;
    }

    /* access modifiers changed from: private */
    public void j() {
        e.b.n.b bVar = this.f10448i;
        if (bVar != null) {
            bVar.b();
            this.f10448i = null;
        }
    }

    public void b(m<? super T> mVar) {
        this.f10444e.lock();
        if (this.f10443d.incrementAndGet() == 1) {
            j();
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f10440a.b(a(mVar, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                    this.f10444e.unlock();
                }
            }
        } else {
            try {
                a(mVar, this.f10442c);
            } finally {
                this.f10444e.unlock();
            }
        }
    }

    private e<e.b.b.b> a(m<? super T> mVar, AtomicBoolean atomicBoolean) {
        return new C0123b(mVar, atomicBoolean);
    }

    /* access modifiers changed from: private */
    public void a(m<? super T> mVar, e.b.b.a aVar) {
        a aVar2 = new a(mVar, aVar, a(aVar));
        mVar.a((e.b.b.b) aVar2);
        this.f10440a.a((m<? super T>) aVar2);
    }

    private e.b.b.b a(e.b.b.a aVar) {
        return e.b.b.c.a(new c(aVar));
    }
}
