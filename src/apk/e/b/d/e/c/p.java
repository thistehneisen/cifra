package e.b.d.e.c;

import e.b.d.c.e;
import e.b.d.c.j;
import e.b.d.d.b;
import e.b.d.f.c;
import e.b.d.g.o;
import e.b.l;
import e.b.m;
import e.b.n;

/* compiled from: ObservableObserveOn */
public final class p<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final n f8103b;

    /* renamed from: c reason: collision with root package name */
    final boolean f8104c;

    /* renamed from: d reason: collision with root package name */
    final int f8105d;

    /* compiled from: ObservableObserveOn */
    static final class a<T> extends b<T> implements m<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final m<? super T> downstream;
        Throwable error;
        boolean outputFused;
        j<T> queue;
        int sourceMode;
        e.b.b.b upstream;
        final n.b worker;

        a(m<? super T> mVar, n.b bVar, boolean z, int i2) {
            this.downstream = mVar;
            this.worker = bVar;
            this.delayError = z;
            this.bufferSize = i2;
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof e) {
                    e eVar = (e) bVar;
                    int b2 = eVar.b(7);
                    if (b2 == 1) {
                        this.sourceMode = b2;
                        this.queue = eVar;
                        this.done = true;
                        this.downstream.a((e.b.b.b) this);
                        f();
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
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.b();
                this.worker.b();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void c() {
            if (!this.done) {
                this.done = true;
                f();
            }
        }

        public void clear() {
            this.queue.clear();
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            int i2 = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (this.delayError || !z || th == null) {
                    this.downstream.a(null);
                    if (z) {
                        this.disposed = true;
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.downstream.a(th2);
                        } else {
                            this.downstream.c();
                        }
                        this.worker.b();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    this.disposed = true;
                    this.downstream.a(th);
                    this.worker.b();
                    return;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void e() {
            j<T> jVar = this.queue;
            m<? super T> mVar = this.downstream;
            int i2 = 1;
            while (!a(this.done, jVar.isEmpty(), mVar)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        Object poll = jVar.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, mVar)) {
                            if (z2) {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            } else {
                                mVar.a(poll);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.disposed = true;
                        this.upstream.b();
                        jVar.clear();
                        mVar.a(th);
                        this.worker.b();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void f() {
            if (getAndIncrement() == 0) {
                this.worker.a((Runnable) this);
            }
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void run() {
            if (this.outputFused) {
                d();
            } else {
                e();
            }
        }

        public int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void a(T t) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                f();
            }
        }

        public void a(Throwable th) {
            if (this.done) {
                e.b.g.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            f();
        }

        public boolean a() {
            return this.disposed;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(boolean z, boolean z2, m<? super T> mVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (this.delayError) {
                    if (z2) {
                        this.disposed = true;
                        if (th != null) {
                            mVar.a(th);
                        } else {
                            mVar.c();
                        }
                        this.worker.b();
                        return true;
                    }
                } else if (th != null) {
                    this.disposed = true;
                    this.queue.clear();
                    mVar.a(th);
                    this.worker.b();
                    return true;
                } else if (z2) {
                    this.disposed = true;
                    mVar.c();
                    this.worker.b();
                    return true;
                }
            }
            return false;
        }
    }

    public p(l<T> lVar, n nVar, boolean z, int i2) {
        super(lVar);
        this.f8103b = nVar;
        this.f8104c = z;
        this.f8105d = i2;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        n nVar = this.f8103b;
        if (nVar instanceof o) {
            this.f8034a.a(mVar);
            return;
        }
        this.f8034a.a(new a(mVar, nVar.a(), this.f8104c, this.f8105d));
    }
}
