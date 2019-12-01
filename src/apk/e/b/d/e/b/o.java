package e.b.d.e.b;

import e.b.c.g;
import e.b.d.c.j;
import e.b.e;
import e.b.f;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.c;
import k.a.d;

/* compiled from: FlowableSwitchMap */
public final class o<T, R> extends a<T, R> {

    /* renamed from: c reason: collision with root package name */
    final g<? super T, ? extends k.a.b<? extends R>> f8027c;

    /* renamed from: d reason: collision with root package name */
    final int f8028d;

    /* renamed from: e reason: collision with root package name */
    final boolean f8029e;

    /* compiled from: FlowableSwitchMap */
    static final class a<T, R> extends AtomicReference<d> implements f<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long index;
        final b<T, R> parent;
        volatile j<R> queue;

        a(b<T, R> bVar, long j2, int i2) {
            this.parent = bVar;
            this.index = j2;
            this.bufferSize = i2;
        }

        public void a(d dVar) {
            if (e.b.d.i.f.a((AtomicReference<d>) this, dVar)) {
                if (dVar instanceof e.b.d.c.g) {
                    e.b.d.c.g gVar = (e.b.d.c.g) dVar;
                    int b2 = gVar.b(7);
                    if (b2 == 1) {
                        this.fusionMode = b2;
                        this.queue = gVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    } else if (b2 == 2) {
                        this.fusionMode = b2;
                        this.queue = gVar;
                        dVar.a((long) this.bufferSize);
                        return;
                    }
                }
                this.queue = new e.b.d.f.b(this.bufferSize);
                dVar.a((long) this.bufferSize);
            }
        }

        public void c() {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                this.done = true;
                bVar.b();
            }
        }

        public void a(R r) {
            b<T, R> bVar = this.parent;
            if (this.index == bVar.unique) {
                if (this.fusionMode != 0 || this.queue.offer(r)) {
                    bVar.b();
                } else {
                    a((Throwable) new MissingBackpressureException("Queue full?!"));
                }
            }
        }

        public void a(Throwable th) {
            b<T, R> bVar = this.parent;
            if (this.index != bVar.unique || !bVar.error.a(th)) {
                e.b.g.a.b(th);
                return;
            }
            if (!bVar.delayErrors) {
                bVar.upstream.cancel();
            }
            this.done = true;
            bVar.b();
        }

        public void a() {
            e.b.d.i.f.a((AtomicReference<d>) this);
        }
    }

    /* compiled from: FlowableSwitchMap */
    static final class b<T, R> extends AtomicInteger implements f<T>, d {

        /* renamed from: a reason: collision with root package name */
        static final a<Object, Object> f8030a = new a<>(null, -1, 1);
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final c<? super R> downstream;
        final e.b.d.j.b error;
        final g<? super T, ? extends k.a.b<? extends R>> mapper;
        final AtomicLong requested = new AtomicLong();
        volatile long unique;
        d upstream;

        static {
            f8030a.a();
        }

        b(c<? super R> cVar, g<? super T, ? extends k.a.b<? extends R>> gVar, int i2, boolean z) {
            this.downstream = cVar;
            this.mapper = gVar;
            this.bufferSize = i2;
            this.delayErrors = z;
            this.error = new e.b.d.j.b();
        }

        public void a(d dVar) {
            if (e.b.d.i.f.a(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.a((d) this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e5, code lost:
            r14 = true;
         */
        public void b() {
            boolean z;
            Object obj;
            if (getAndIncrement() == 0) {
                c<? super R> cVar = this.downstream;
                int i2 = 1;
                while (!this.cancelled) {
                    if (this.done) {
                        if (this.delayErrors) {
                            if (this.active.get() == null) {
                                if (((Throwable) this.error.get()) != null) {
                                    cVar.a(this.error.a());
                                } else {
                                    cVar.c();
                                }
                                return;
                            }
                        } else if (((Throwable) this.error.get()) != null) {
                            a();
                            cVar.a(this.error.a());
                            return;
                        } else if (this.active.get() == null) {
                            cVar.c();
                            return;
                        }
                    }
                    a aVar = (a) this.active.get();
                    j jVar = aVar != null ? aVar.queue : null;
                    if (jVar != null) {
                        if (aVar.done) {
                            if (!this.delayErrors) {
                                if (((Throwable) this.error.get()) != null) {
                                    a();
                                    cVar.a(this.error.a());
                                    return;
                                } else if (jVar.isEmpty()) {
                                    this.active.compareAndSet(aVar, null);
                                }
                            } else if (jVar.isEmpty()) {
                                this.active.compareAndSet(aVar, null);
                            }
                        }
                        long j2 = this.requested.get();
                        long j3 = 0;
                        while (true) {
                            z = false;
                            if (j3 != j2) {
                                if (!this.cancelled) {
                                    boolean z2 = aVar.done;
                                    try {
                                        obj = jVar.poll();
                                    } catch (Throwable th) {
                                        Throwable th2 = th;
                                        io.reactivex.exceptions.a.b(th2);
                                        aVar.a();
                                        this.error.a(th2);
                                        obj = null;
                                        z2 = true;
                                    }
                                    boolean z3 = obj == null;
                                    if (aVar != this.active.get()) {
                                        break;
                                    }
                                    if (z2) {
                                        if (this.delayErrors) {
                                            if (z3) {
                                                this.active.compareAndSet(aVar, null);
                                                break;
                                            }
                                        } else if (((Throwable) this.error.get()) == null) {
                                            if (z3) {
                                                this.active.compareAndSet(aVar, null);
                                                break;
                                            }
                                        } else {
                                            cVar.a(this.error.a());
                                            return;
                                        }
                                    }
                                    if (z3) {
                                        break;
                                    }
                                    cVar.a(obj);
                                    j3++;
                                } else {
                                    return;
                                }
                            } else {
                                break;
                            }
                        }
                        if (j3 != 0 && !this.cancelled) {
                            if (j2 != Long.MAX_VALUE) {
                                this.requested.addAndGet(-j3);
                            }
                            ((d) aVar.get()).a(j3);
                        }
                        if (z) {
                            continue;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                this.active.lazySet(null);
            }
        }

        public void c() {
            if (!this.done) {
                this.done = true;
                b();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                a();
            }
        }

        public void a(T t) {
            if (!this.done) {
                long j2 = this.unique + 1;
                this.unique = j2;
                a aVar = (a) this.active.get();
                if (aVar != null) {
                    aVar.a();
                }
                try {
                    Object apply = this.mapper.apply(t);
                    e.b.d.b.b.a(apply, "The publisher returned is null");
                    k.a.b bVar = (k.a.b) apply;
                    a aVar2 = new a(this, j2, this.bufferSize);
                    while (true) {
                        a<Object, Object> aVar3 = (a) this.active.get();
                        if (aVar3 != f8030a) {
                            if (this.active.compareAndSet(aVar3, aVar2)) {
                                bVar.a(aVar2);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.upstream.cancel();
                    a(th);
                }
            }
        }

        public void a(Throwable th) {
            if (this.done || !this.error.a(th)) {
                e.b.g.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                a();
            }
            this.done = true;
            b();
        }

        public void a(long j2) {
            if (e.b.d.i.f.c(j2)) {
                e.b.d.j.c.a(this.requested, j2);
                if (this.unique == 0) {
                    this.upstream.a(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            a<Object, Object> aVar = (a) this.active.get();
            a<Object, Object> aVar2 = f8030a;
            if (aVar != aVar2) {
                a<Object, Object> aVar3 = (a) this.active.getAndSet(aVar2);
                if (aVar3 != f8030a && aVar3 != null) {
                    aVar3.a();
                }
            }
        }
    }

    public o(e<T> eVar, g<? super T, ? extends k.a.b<? extends R>> gVar, int i2, boolean z) {
        super(eVar);
        this.f8027c = gVar;
        this.f8028d = i2;
        this.f8029e = z;
    }

    /* access modifiers changed from: protected */
    public void b(c<? super R> cVar) {
        if (!l.a(this.f8004b, cVar, this.f8027c)) {
            this.f8004b.a((f<? super T>) new b<Object>(cVar, this.f8027c, this.f8028d, this.f8029e));
        }
    }
}
