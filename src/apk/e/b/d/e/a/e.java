package e.b.d.e.a;

import e.b.b;
import e.b.c;
import e.b.p;
import e.b.q;

/* compiled from: CompletableFromSingle */
public final class e<T> extends b {

    /* renamed from: a reason: collision with root package name */
    final q<T> f7990a;

    /* compiled from: CompletableFromSingle */
    static final class a<T> implements p<T> {

        /* renamed from: a reason: collision with root package name */
        final c f7991a;

        a(c cVar) {
            this.f7991a = cVar;
        }

        public void a(Throwable th) {
            this.f7991a.a(th);
        }

        public void b(T t) {
            this.f7991a.c();
        }

        public void a(e.b.b.b bVar) {
            this.f7991a.a(bVar);
        }
    }

    public e(q<T> qVar) {
        this.f7990a = qVar;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        this.f7990a.a(new a(cVar));
    }
}
