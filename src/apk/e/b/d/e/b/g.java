package e.b.d.e.b;

import e.b.e;
import e.b.f;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
import k.a.c;
import k.a.d;

/* compiled from: FlowableOnBackpressureError */
public final class g<T> extends a<T, T> {

    /* compiled from: FlowableOnBackpressureError */
    static final class a<T> extends AtomicLong implements f<T>, d {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final c<? super T> downstream;
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
            if (!this.done) {
                this.done = true;
                this.downstream.c();
            }
        }

        public void cancel() {
            this.upstream.cancel();
        }

        public void a(T t) {
            if (!this.done) {
                if (get() != 0) {
                    this.downstream.a(t);
                    e.b.d.j.c.b(this, 1);
                } else {
                    a((Throwable) new MissingBackpressureException("could not emit value due to lack of requests"));
                }
            }
        }

        public void a(Throwable th) {
            if (this.done) {
                e.b.g.a.b(th);
                return;
            }
            this.done = true;
            this.downstream.a(th);
        }

        public void a(long j2) {
            if (e.b.d.i.f.c(j2)) {
                e.b.d.j.c.a((AtomicLong) this, j2);
            }
        }
    }

    public g(e<T> eVar) {
        super(eVar);
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        this.f8004b.a((f<? super T>) new a<Object>(cVar));
    }
}
