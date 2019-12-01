package e.b.d.e.d;

import e.b.d.i.b;
import e.b.e;
import e.b.p;
import e.b.q;
import k.a.c;
import k.a.d;

/* compiled from: SingleToFlowable */
public final class n<T> extends e<T> {

    /* renamed from: b reason: collision with root package name */
    final q<? extends T> f8178b;

    /* compiled from: SingleToFlowable */
    static final class a<T> extends b<T> implements p<T> {
        private static final long serialVersionUID = 187782011903685568L;
        e.b.b.b upstream;

        a(c<? super T> cVar) {
            super(cVar);
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a((d) this);
            }
        }

        public void b(T t) {
            c(t);
        }

        public void cancel() {
            super.cancel();
            this.upstream.b();
        }

        public void a(Throwable th) {
            this.downstream.a(th);
        }
    }

    public n(q<? extends T> qVar) {
        this.f8178b = qVar;
    }

    public void b(c<? super T> cVar) {
        this.f8178b.a(new a(cVar));
    }
}
