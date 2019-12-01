package e.b.d.e.d;

import e.b.b.b;
import e.b.c.e;
import e.b.o;
import e.b.p;
import e.b.q;

/* compiled from: SingleDoOnSuccess */
public final class d<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<T> f8152a;

    /* renamed from: b reason: collision with root package name */
    final e<? super T> f8153b;

    /* compiled from: SingleDoOnSuccess */
    final class a implements p<T> {

        /* renamed from: a reason: collision with root package name */
        final p<? super T> f8154a;

        a(p<? super T> pVar) {
            this.f8154a = pVar;
        }

        public void a(b bVar) {
            this.f8154a.a(bVar);
        }

        public void b(T t) {
            try {
                d.this.f8153b.accept(t);
                this.f8154a.b(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f8154a.a(th);
            }
        }

        public void a(Throwable th) {
            this.f8154a.a(th);
        }
    }

    public d(q<T> qVar, e<? super T> eVar) {
        this.f8152a = qVar;
        this.f8153b = eVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8152a.a(new a(pVar));
    }
}
