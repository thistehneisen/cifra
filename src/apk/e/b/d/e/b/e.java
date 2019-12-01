package e.b.d.e.b;

import e.b.d.c.i;
import e.b.d.f.b;
import e.b.f;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
import k.a.c;
import k.a.d;

/* compiled from: FlowableOnBackpressureBuffer */
public final class e<T> extends a<T, T> {

    /* renamed from: c reason: collision with root package name */
    final int f8010c;

    /* renamed from: d reason: collision with root package name */
    final boolean f8011d;

    /* renamed from: e reason: collision with root package name */
    final boolean f8012e;

    /* renamed from: f reason: collision with root package name */
    final e.b.c.a f8013f;

    /* compiled from: FlowableOnBackpressureBuffer */
    static final class a<T> extends e.b.d.i.a<T> implements f<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final c<? super T> downstream;
        Throwable error;
        final e.b.c.a onOverflow;
        boolean outputFused;
        final i<T> queue;
        final AtomicLong requested = new AtomicLong();
        d upstream;

        a(c<? super T> cVar, int i2, boolean z, boolean z2, e.b.c.a aVar) {
            i<T> iVar;
            this.downstream = cVar;
            this.onOverflow = aVar;
            this.delayError = z2;
            if (z) {
                iVar = new e.b.d.f.c<>(i2);
            } else {
                iVar = new b<>(i2);
            }
            this.queue = iVar;
        }

        public void a(d dVar) {
            if (e.b.d.i.f.a(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.a((d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        public int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public void c() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.c();
            } else {
                a();
            }
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void a(T t) {
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    missingBackpressureException.initCause(th);
                }
                a((Throwable) missingBackpressureException);
                return;
            }
            if (this.outputFused) {
                this.downstream.a(null);
            } else {
                a();
            }
        }

        public void a(Throwable th) {
            this.error = th;
            this.done = true;
            if (this.outputFused) {
                this.downstream.a(th);
            } else {
                a();
            }
        }

        public void a(long j2) {
            if (!this.outputFused && e.b.d.i.f.c(j2)) {
                e.b.d.j.c.a(this.requested, j2);
                a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            int i2;
            if (getAndIncrement() == 0) {
                i<T> iVar = this.queue;
                c<? super T> cVar = this.downstream;
                int i3 = 1;
                while (!a(this.done, iVar.isEmpty(), cVar)) {
                    long j2 = this.requested.get();
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.done;
                        Object poll = iVar.poll();
                        boolean z2 = poll == null;
                        if (!a(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            cVar.a(poll);
                            j3++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !a(this.done, iVar.isEmpty(), cVar)) {
                        if (!(j3 == 0 || j2 == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-j3);
                        }
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(boolean z, boolean z2, c<? super T> cVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                if (!this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        cVar.a(th);
                        return true;
                    } else if (z2) {
                        cVar.c();
                        return true;
                    }
                } else if (z2) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        cVar.a(th2);
                    } else {
                        cVar.c();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public e(e.b.e<T> eVar, int i2, boolean z, boolean z2, e.b.c.a aVar) {
        super(eVar);
        this.f8010c = i2;
        this.f8011d = z;
        this.f8012e = z2;
        this.f8013f = aVar;
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        e.b.e<T> eVar = this.f8004b;
        a aVar = new a(cVar, this.f8010c, this.f8011d, this.f8012e, this.f8013f);
        eVar.a((f<? super T>) aVar);
    }
}
