package e.b.d.e.c;

import e.b.c.g;
import e.b.d.c.j;
import e.b.d.f.c;
import e.b.d.j.e;
import e.b.l;
import e.b.m;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableConcatMap */
public final class b<T, U> extends a<T, U> {

    /* renamed from: b reason: collision with root package name */
    final g<? super T, ? extends l<? extends U>> f8035b;

    /* renamed from: c reason: collision with root package name */
    final int f8036c;

    /* renamed from: d reason: collision with root package name */
    final e f8037d;

    /* compiled from: ObservableConcatMap */
    static final class a<T, R> extends AtomicInteger implements m<T>, e.b.b.b {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final m<? super R> downstream;
        final e.b.d.j.b error = new e.b.d.j.b();
        final g<? super T, ? extends l<? extends R>> mapper;
        final C0085a<R> observer;
        j<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        e.b.b.b upstream;

        /* renamed from: e.b.d.e.c.b$a$a reason: collision with other inner class name */
        /* compiled from: ObservableConcatMap */
        static final class C0085a<R> extends AtomicReference<e.b.b.b> implements m<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final m<? super R> downstream;
            final a<?, R> parent;

            C0085a(m<? super R> mVar, a<?, R> aVar) {
                this.downstream = mVar;
                this.parent = aVar;
            }

            public void a(e.b.b.b bVar) {
                e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, bVar);
            }

            public void c() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.d();
            }

            public void a(R r) {
                this.downstream.a(r);
            }

            public void a(Throwable th) {
                a<?, R> aVar = this.parent;
                if (aVar.error.a(th)) {
                    if (!aVar.tillTheEnd) {
                        aVar.upstream.b();
                    }
                    aVar.active = false;
                    aVar.d();
                    return;
                }
                e.b.g.a.b(th);
            }

            /* access modifiers changed from: 0000 */
            public void a() {
                e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
            }
        }

        a(m<? super R> mVar, g<? super T, ? extends l<? extends R>> gVar, int i2, boolean z) {
            this.downstream = mVar;
            this.mapper = gVar;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.observer = new C0085a<>(mVar, this);
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof e.b.d.c.e) {
                    e.b.d.c.e eVar = (e.b.d.c.e) bVar;
                    int b2 = eVar.b(3);
                    if (b2 == 1) {
                        this.sourceMode = b2;
                        this.queue = eVar;
                        this.done = true;
                        this.downstream.a((e.b.b.b) this);
                        d();
                        return;
                    } else if (b2 == 2) {
                        this.sourceMode = b2;
                        this.queue = eVar;
                        this.downstream.a((e.b.b.b) this);
                        return;
                    }
                }
                this.queue = new c(this.bufferSize);
                this.downstream.a((e.b.b.b) this);
            }
        }

        public void b() {
            this.cancelled = true;
            this.upstream.b();
            this.observer.a();
        }

        public void c() {
            this.done = true;
            d();
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            if (getAndIncrement() == 0) {
                m<? super R> mVar = this.downstream;
                j<T> jVar = this.queue;
                e.b.d.j.b bVar = this.error;
                while (true) {
                    if (!this.active) {
                        if (this.cancelled) {
                            jVar.clear();
                            return;
                        } else if (this.tillTheEnd || ((Throwable) bVar.get()) == null) {
                            boolean z = this.done;
                            try {
                                Object poll = jVar.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    this.cancelled = true;
                                    Throwable a2 = bVar.a();
                                    if (a2 != null) {
                                        mVar.a(a2);
                                    } else {
                                        mVar.c();
                                    }
                                    return;
                                } else if (!z2) {
                                    try {
                                        Object apply = this.mapper.apply(poll);
                                        e.b.d.b.b.a(apply, "The mapper returned a null ObservableSource");
                                        l lVar = (l) apply;
                                        if (lVar instanceof Callable) {
                                            try {
                                                Object call = ((Callable) lVar).call();
                                                if (call != null && !this.cancelled) {
                                                    mVar.a(call);
                                                }
                                            } catch (Throwable th) {
                                                io.reactivex.exceptions.a.b(th);
                                                bVar.a(th);
                                            }
                                        } else {
                                            this.active = true;
                                            lVar.a(this.observer);
                                        }
                                    } catch (Throwable th2) {
                                        io.reactivex.exceptions.a.b(th2);
                                        this.cancelled = true;
                                        this.upstream.b();
                                        jVar.clear();
                                        bVar.a(th2);
                                        mVar.a(bVar.a());
                                        return;
                                    }
                                }
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                this.cancelled = true;
                                this.upstream.b();
                                bVar.a(th3);
                                mVar.a(bVar.a());
                                return;
                            }
                        } else {
                            jVar.clear();
                            this.cancelled = true;
                            mVar.a(bVar.a());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void a(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            d();
        }

        public void a(Throwable th) {
            if (this.error.a(th)) {
                this.done = true;
                d();
                return;
            }
            e.b.g.a.b(th);
        }

        public boolean a() {
            return this.cancelled;
        }
    }

    /* renamed from: e.b.d.e.c.b$b reason: collision with other inner class name */
    /* compiled from: ObservableConcatMap */
    static final class C0086b<T, U> extends AtomicInteger implements m<T>, e.b.b.b {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final m<? super U> downstream;
        int fusionMode;
        final a<U> inner;
        final g<? super T, ? extends l<? extends U>> mapper;
        j<T> queue;
        e.b.b.b upstream;

        /* renamed from: e.b.d.e.c.b$b$a */
        /* compiled from: ObservableConcatMap */
        static final class a<U> extends AtomicReference<e.b.b.b> implements m<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final m<? super U> downstream;
            final C0086b<?, ?> parent;

            a(m<? super U> mVar, C0086b<?, ?> bVar) {
                this.downstream = mVar;
                this.parent = bVar;
            }

            public void a(e.b.b.b bVar) {
                e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, bVar);
            }

            public void c() {
                this.parent.e();
            }

            public void a(U u) {
                this.downstream.a(u);
            }

            public void a(Throwable th) {
                this.parent.b();
                this.downstream.a(th);
            }

            /* access modifiers changed from: 0000 */
            public void a() {
                e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
            }
        }

        C0086b(m<? super U> mVar, g<? super T, ? extends l<? extends U>> gVar, int i2) {
            this.downstream = mVar;
            this.mapper = gVar;
            this.bufferSize = i2;
            this.inner = new a<>(mVar, this);
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof e.b.d.c.e) {
                    e.b.d.c.e eVar = (e.b.d.c.e) bVar;
                    int b2 = eVar.b(3);
                    if (b2 == 1) {
                        this.fusionMode = b2;
                        this.queue = eVar;
                        this.done = true;
                        this.downstream.a((e.b.b.b) this);
                        d();
                        return;
                    } else if (b2 == 2) {
                        this.fusionMode = b2;
                        this.queue = eVar;
                        this.downstream.a((e.b.b.b) this);
                        return;
                    }
                }
                this.queue = new c(this.bufferSize);
                this.downstream.a((e.b.b.b) this);
            }
        }

        public void b() {
            this.disposed = true;
            this.inner.a();
            this.upstream.b();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public void c() {
            if (!this.done) {
                this.done = true;
                d();
            }
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            Object poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.disposed = true;
                                this.downstream.c();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.mapper.apply(poll);
                                    e.b.d.b.b.a(apply, "The mapper returned a null ObservableSource");
                                    l lVar = (l) apply;
                                    this.active = true;
                                    lVar.a(this.inner);
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.b(th);
                                    b();
                                    this.queue.clear();
                                    this.downstream.a(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            b();
                            this.queue.clear();
                            this.downstream.a(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        public void e() {
            this.active = false;
            d();
        }

        public void a(T t) {
            if (!this.done) {
                if (this.fusionMode == 0) {
                    this.queue.offer(t);
                }
                d();
            }
        }

        public void a(Throwable th) {
            if (this.done) {
                e.b.g.a.b(th);
                return;
            }
            this.done = true;
            b();
            this.downstream.a(th);
        }

        public boolean a() {
            return this.disposed;
        }
    }

    public b(l<T> lVar, g<? super T, ? extends l<? extends U>> gVar, int i2, e eVar) {
        super(lVar);
        this.f8035b = gVar;
        this.f8037d = eVar;
        this.f8036c = Math.max(8, i2);
    }

    public void b(m<? super U> mVar) {
        if (!s.a(this.f8034a, mVar, this.f8035b)) {
            e eVar = this.f8037d;
            if (eVar == e.IMMEDIATE) {
                this.f8034a.a(new C0086b(new e.b.f.b(mVar), this.f8035b, this.f8036c));
            } else {
                this.f8034a.a(new a(mVar, this.f8035b, this.f8036c, eVar == e.END));
            }
        }
    }
}
