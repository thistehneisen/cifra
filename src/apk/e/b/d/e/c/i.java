package e.b.d.e.c;

import e.b.l;
import e.b.m;

/* compiled from: ObservableFilter */
public final class i<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final e.b.c.i<? super T> f8086b;

    /* compiled from: ObservableFilter */
    static final class a<T> extends e.b.d.d.a<T, T> {

        /* renamed from: f reason: collision with root package name */
        final e.b.c.i<? super T> f8087f;

        a(m<? super T> mVar, e.b.c.i<? super T> iVar) {
            super(mVar);
            this.f8087f = iVar;
        }

        public void a(T t) {
            if (this.f7976e == 0) {
                try {
                    if (this.f8087f.test(t)) {
                        this.f7972a.a(t);
                    }
                } catch (Throwable th) {
                    b(th);
                }
            } else {
                this.f7972a.a(null);
            }
        }

        public int b(int i2) {
            return a(i2);
        }

        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f7974c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f8087f.test(poll));
            return poll;
        }
    }

    public i(l<T> lVar, e.b.c.i<? super T> iVar) {
        super(lVar);
        this.f8086b = iVar;
    }

    public void b(m<? super T> mVar) {
        this.f8034a.a(new a(mVar, this.f8086b));
    }
}
