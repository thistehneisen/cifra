package e.b.d.e.d;

import e.b.b.b;
import e.b.c.g;
import e.b.o;
import e.b.p;
import e.b.q;
import io.reactivex.exceptions.CompositeException;

/* compiled from: SingleOnErrorReturn */
public final class l<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<? extends T> f8171a;

    /* renamed from: b reason: collision with root package name */
    final g<? super Throwable, ? extends T> f8172b;

    /* renamed from: c reason: collision with root package name */
    final T f8173c;

    /* compiled from: SingleOnErrorReturn */
    final class a implements p<T> {

        /* renamed from: a reason: collision with root package name */
        private final p<? super T> f8174a;

        a(p<? super T> pVar) {
            this.f8174a = pVar;
        }

        public void a(Throwable th) {
            T t;
            l lVar = l.this;
            g<? super Throwable, ? extends T> gVar = lVar.f8172b;
            if (gVar != null) {
                try {
                    t = gVar.apply(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f8174a.a((Throwable) new CompositeException(th, th2));
                    return;
                }
            } else {
                t = lVar.f8173c;
            }
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.f8174a.a((Throwable) nullPointerException);
                return;
            }
            this.f8174a.b(t);
        }

        public void b(T t) {
            this.f8174a.b(t);
        }

        public void a(b bVar) {
            this.f8174a.a(bVar);
        }
    }

    public l(q<? extends T> qVar, g<? super Throwable, ? extends T> gVar, T t) {
        this.f8171a = qVar;
        this.f8172b = gVar;
        this.f8173c = t;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8171a.a(new a(pVar));
    }
}
