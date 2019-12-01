package e.b.d.e.d;

import e.b.b.b;
import e.b.d.d.g;
import e.b.k;
import e.b.m;
import e.b.p;
import e.b.q;

/* compiled from: SingleToObservable */
public final class o<T> extends k<T> {

    /* renamed from: a reason: collision with root package name */
    final q<? extends T> f8179a;

    /* compiled from: SingleToObservable */
    static final class a<T> extends g<T> implements p<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        b upstream;

        a(m<? super T> mVar) {
            super(mVar);
        }

        public void a(b bVar) {
            if (e.b.d.a.b.a(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a((b) this);
            }
        }

        public void b(T t) {
            c(t);
        }

        public void b() {
            super.b();
            this.upstream.b();
        }

        public void a(Throwable th) {
            b(th);
        }
    }

    public o(q<? extends T> qVar) {
        this.f8179a = qVar;
    }

    public static <T> p<T> c(m<? super T> mVar) {
        return new a(mVar);
    }

    public void b(m<? super T> mVar) {
        this.f8179a.a(c(mVar));
    }
}
