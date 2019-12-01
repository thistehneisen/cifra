package e.b.d.e.d;

import e.b.c.e;
import e.b.o;
import e.b.p;
import e.b.q;
import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleDoOnError */
public final class b<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<T> f8143a;

    /* renamed from: b reason: collision with root package name */
    final e<? super Throwable> f8144b;

    /* compiled from: SingleDoOnError */
    final class a implements p<T> {

        /* renamed from: a reason: collision with root package name */
        private final p<? super T> f8145a;

        a(p<? super T> pVar) {
            this.f8145a = pVar;
        }

        public void a(e.b.b.b bVar) {
            this.f8145a.a(bVar);
        }

        public void b(T t) {
            this.f8145a.b(t);
        }

        public void a(Throwable th) {
            try {
                b.this.f8144b.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f8145a.a(th);
        }
    }

    public b(q<T> qVar, e<? super Throwable> eVar) {
        this.f8143a = qVar;
        this.f8144b = eVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8143a.a(new a(pVar));
    }
}
