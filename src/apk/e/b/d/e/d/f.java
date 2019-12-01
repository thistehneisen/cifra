package e.b.d.e.d;

import e.b.b.b;
import e.b.c.g;
import e.b.o;
import e.b.p;
import e.b.q;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleFlatMap */
public final class f<T, R> extends o<R> {

    /* renamed from: a reason: collision with root package name */
    final q<? extends T> f8157a;

    /* renamed from: b reason: collision with root package name */
    final g<? super T, ? extends q<? extends R>> f8158b;

    /* compiled from: SingleFlatMap */
    static final class a<T, R> extends AtomicReference<b> implements p<T>, b {
        private static final long serialVersionUID = 3258103020495908596L;
        final p<? super R> downstream;
        final g<? super T, ? extends q<? extends R>> mapper;

        /* renamed from: e.b.d.e.d.f$a$a reason: collision with other inner class name */
        /* compiled from: SingleFlatMap */
        static final class C0088a<R> implements p<R> {

            /* renamed from: a reason: collision with root package name */
            final AtomicReference<b> f8159a;

            /* renamed from: b reason: collision with root package name */
            final p<? super R> f8160b;

            C0088a(AtomicReference<b> atomicReference, p<? super R> pVar) {
                this.f8159a = atomicReference;
                this.f8160b = pVar;
            }

            public void a(b bVar) {
                e.b.d.a.b.a(this.f8159a, bVar);
            }

            public void b(R r) {
                this.f8160b.b(r);
            }

            public void a(Throwable th) {
                this.f8160b.a(th);
            }
        }

        a(p<? super R> pVar, g<? super T, ? extends q<? extends R>> gVar) {
            this.downstream = pVar;
            this.mapper = gVar;
        }

        public boolean a() {
            return e.b.d.a.b.a((b) get());
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<b>) this);
        }

        public void a(b bVar) {
            if (e.b.d.a.b.b(this, bVar)) {
                this.downstream.a((b) this);
            }
        }

        public void b(T t) {
            try {
                Object apply = this.mapper.apply(t);
                e.b.d.b.b.a(apply, "The single returned by the mapper is null");
                q qVar = (q) apply;
                if (!a()) {
                    qVar.a(new C0088a(this, this.downstream));
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.downstream.a(th);
            }
        }

        public void a(Throwable th) {
            this.downstream.a(th);
        }
    }

    public f(q<? extends T> qVar, g<? super T, ? extends q<? extends R>> gVar) {
        this.f8158b = gVar;
        this.f8157a = qVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super R> pVar) {
        this.f8157a.a(new a(pVar, this.f8158b));
    }
}
