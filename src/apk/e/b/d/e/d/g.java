package e.b.d.e.d;

import e.b.b;
import e.b.c;
import e.b.d;
import e.b.p;
import e.b.q;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMapCompletable */
public final class g<T> extends b {

    /* renamed from: a reason: collision with root package name */
    final q<T> f8161a;

    /* renamed from: b reason: collision with root package name */
    final e.b.c.g<? super T, ? extends d> f8162b;

    /* compiled from: SingleFlatMapCompletable */
    static final class a<T> extends AtomicReference<e.b.b.b> implements p<T>, c, e.b.b.b {
        private static final long serialVersionUID = -2177128922851101253L;
        final c downstream;
        final e.b.c.g<? super T, ? extends d> mapper;

        a(c cVar, e.b.c.g<? super T, ? extends d> gVar) {
            this.downstream = cVar;
            this.mapper = gVar;
        }

        public boolean a() {
            return e.b.d.a.b.a((e.b.b.b) get());
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void c() {
            this.downstream.c();
        }

        public void a(e.b.b.b bVar) {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, bVar);
        }

        public void b(T t) {
            try {
                Object apply = this.mapper.apply(t);
                e.b.d.b.b.a(apply, "The mapper returned a null CompletableSource");
                d dVar = (d) apply;
                if (!a()) {
                    dVar.a(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a(th);
            }
        }

        public void a(Throwable th) {
            this.downstream.a(th);
        }
    }

    public g(q<T> qVar, e.b.c.g<? super T, ? extends d> gVar) {
        this.f8161a = qVar;
        this.f8162b = gVar;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        a aVar = new a(cVar, this.f8162b);
        cVar.a((e.b.b.b) aVar);
        this.f8161a.a(aVar);
    }
}
