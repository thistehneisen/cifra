package e.b.d.e.c;

import e.b.b;
import e.b.c;
import e.b.k;
import e.b.l;

/* compiled from: ObservableIgnoreElementsCompletable */
public final class m<T> extends b implements e.b.d.c.b<T> {

    /* renamed from: a reason: collision with root package name */
    final l<T> f8097a;

    /* compiled from: ObservableIgnoreElementsCompletable */
    static final class a<T> implements e.b.m<T>, e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        final c f8098a;

        /* renamed from: b reason: collision with root package name */
        e.b.b.b f8099b;

        a(c cVar) {
            this.f8098a = cVar;
        }

        public void a(e.b.b.b bVar) {
            this.f8099b = bVar;
            this.f8098a.a((e.b.b.b) this);
        }

        public void a(T t) {
        }

        public void b() {
            this.f8099b.b();
        }

        public void c() {
            this.f8098a.c();
        }

        public void a(Throwable th) {
            this.f8098a.a(th);
        }

        public boolean a() {
            return this.f8099b.a();
        }
    }

    public m(l<T> lVar) {
        this.f8097a = lVar;
    }

    public k<T> a() {
        return e.b.g.a.a((k<T>) new l<T>(this.f8097a));
    }

    public void b(c cVar) {
        this.f8097a.a(new a(cVar));
    }
}
