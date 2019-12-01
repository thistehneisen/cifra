package e.b.d.e.b;

import e.b.e;
import e.b.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.c;
import k.a.d;

/* compiled from: FlowableOnBackpressureLatest */
public final class h<T> extends a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest */
    static final class a<T> extends AtomicInteger implements f<T>, d {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current = new AtomicReference<>();
        volatile boolean done;
        final c<? super T> downstream;
        Throwable error;
        final AtomicLong requested = new AtomicLong();
        d upstream;

        a(c<? super T> cVar) {
            this.downstream = cVar;
        }

        public void a(d dVar) {
            if (e.b.d.i.f.a(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.a((d) this);
                dVar.a(Long.MAX_VALUE);
            }
        }

        public void c() {
            this.done = true;
            a();
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet(null);
                }
            }
        }

        public void a(T t) {
            this.current.lazySet(t);
            a();
        }

        public void a(Throwable th) {
            this.error = th;
            this.done = true;
            a();
        }

        public void a(long j2) {
            if (e.b.d.i.f.c(j2)) {
                e.b.d.j.c.a(this.requested, j2);
                a();
            }
        }

        /* access modifiers changed from: 0000 */
        public void a() {
            boolean z;
            if (getAndIncrement() == 0) {
                c<? super T> cVar = this.downstream;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i2 = 1;
                do {
                    long j2 = 0;
                    while (true) {
                        z = false;
                        if (j2 == atomicLong.get()) {
                            break;
                        }
                        boolean z2 = this.done;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z3 = andSet == null;
                        if (!a(z2, z3, cVar, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            cVar.a(andSet);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 == atomicLong.get()) {
                        boolean z4 = this.done;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (a(z4, z, cVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j2 != 0) {
                        e.b.d.j.c.b(atomicLong, j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean a(boolean z, boolean z2, c<?> cVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    atomicReference.lazySet(null);
                    cVar.a(th);
                    return true;
                } else if (z2) {
                    cVar.c();
                    return true;
                }
            }
            return false;
        }
    }

    public h(e<T> eVar) {
        super(eVar);
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        this.f8004b.a((f<? super T>) new a<Object>(cVar));
    }
}
