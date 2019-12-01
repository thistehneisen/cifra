package e.b.d.e.c;

import e.b.b.b;
import e.b.m;

/* compiled from: ObservableIgnoreElements */
public final class l<T> extends a<T, T> {

    /* compiled from: ObservableIgnoreElements */
    static final class a<T> implements m<T>, b {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8095a;

        /* renamed from: b reason: collision with root package name */
        b f8096b;

        a(m<? super T> mVar) {
            this.f8095a = mVar;
        }

        public void a(b bVar) {
            this.f8096b = bVar;
            this.f8095a.a((b) this);
        }

        public void a(T t) {
        }

        public void b() {
            this.f8096b.b();
        }

        public void c() {
            this.f8095a.c();
        }

        public void a(Throwable th) {
            this.f8095a.a(th);
        }

        public boolean a() {
            return this.f8096b.a();
        }
    }

    public l(e.b.l<T> lVar) {
        super(lVar);
    }

    public void b(m<? super T> mVar) {
        this.f8034a.a(new a(mVar));
    }
}
