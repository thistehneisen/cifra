package e.b.d.e.d;

import e.b.b.b;
import e.b.c.g;
import e.b.o;
import e.b.p;
import e.b.q;

/* compiled from: SingleMap */
public final class j<T, R> extends o<R> {

    /* renamed from: a reason: collision with root package name */
    final q<? extends T> f8165a;

    /* renamed from: b reason: collision with root package name */
    final g<? super T, ? extends R> f8166b;

    /* compiled from: SingleMap */
    static final class a<T, R> implements p<T> {

        /* renamed from: a reason: collision with root package name */
        final p<? super R> f8167a;

        /* renamed from: b reason: collision with root package name */
        final g<? super T, ? extends R> f8168b;

        a(p<? super R> pVar, g<? super T, ? extends R> gVar) {
            this.f8167a = pVar;
            this.f8168b = gVar;
        }

        public void a(b bVar) {
            this.f8167a.a(bVar);
        }

        public void b(T t) {
            try {
                Object apply = this.f8168b.apply(t);
                e.b.d.b.b.a(apply, "The mapper function returned a null value.");
                this.f8167a.b(apply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a(th);
            }
        }

        public void a(Throwable th) {
            this.f8167a.a(th);
        }
    }

    public j(q<? extends T> qVar, g<? super T, ? extends R> gVar) {
        this.f8165a = qVar;
        this.f8166b = gVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super R> pVar) {
        this.f8165a.a(new a(pVar, this.f8166b));
    }
}
