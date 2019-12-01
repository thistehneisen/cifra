package e.b.d.e.b;

import e.b.c.e;
import java.util.concurrent.atomic.AtomicLong;
import k.a.c;
import k.a.d;

/* compiled from: FlowableOnBackpressureDrop */
public final class f<T> extends a<T, T> implements e<T> {

    /* renamed from: c reason: collision with root package name */
    final e<? super T> f8014c = this;

    /* compiled from: FlowableOnBackpressureDrop */
    static final class a<T> extends AtomicLong implements e.b.f<T>, d {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final c<? super T> downstream;
        final e<? super T> onDrop;
        d upstream;

        a(c<? super T> cVar, e<? super T> eVar) {
            this.downstream = cVar;
            this.onDrop = eVar;
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
                    try {
                        this.onDrop.accept(t);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        cancel();
                        a(th);
                    }
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

    public f(e.b.e<T> eVar) {
        super(eVar);
    }

    public void accept(T t) {
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        this.f8004b.a((e.b.f<? super T>) new a<Object>(cVar, this.f8014c));
    }
}
