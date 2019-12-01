package e.b.d.e.d;

import e.b.b.b;
import e.b.c.e;
import e.b.o;
import e.b.p;
import e.b.q;

/* compiled from: SingleDoOnSubscribe */
public final class c<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<T> f8147a;

    /* renamed from: b reason: collision with root package name */
    final e<? super b> f8148b;

    /* compiled from: SingleDoOnSubscribe */
    static final class a<T> implements p<T> {

        /* renamed from: a reason: collision with root package name */
        final p<? super T> f8149a;

        /* renamed from: b reason: collision with root package name */
        final e<? super b> f8150b;

        /* renamed from: c reason: collision with root package name */
        boolean f8151c;

        a(p<? super T> pVar, e<? super b> eVar) {
            this.f8149a = pVar;
            this.f8150b = eVar;
        }

        public void a(b bVar) {
            try {
                this.f8150b.accept(bVar);
                this.f8149a.a(bVar);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f8151c = true;
                bVar.b();
                e.b.d.a.c.a(th, this.f8149a);
            }
        }

        public void b(T t) {
            if (!this.f8151c) {
                this.f8149a.b(t);
            }
        }

        public void a(Throwable th) {
            if (this.f8151c) {
                e.b.g.a.b(th);
            } else {
                this.f8149a.a(th);
            }
        }
    }

    public c(q<T> qVar, e<? super b> eVar) {
        this.f8147a = qVar;
        this.f8148b = eVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8147a.a(new a(pVar, this.f8148b));
    }
}
