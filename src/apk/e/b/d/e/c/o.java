package e.b.d.e.c;

import e.b.c.g;
import e.b.d.b.b;
import e.b.l;
import e.b.m;

/* compiled from: ObservableMap */
public final class o<T, U> extends a<T, U> {

    /* renamed from: b reason: collision with root package name */
    final g<? super T, ? extends U> f8101b;

    /* compiled from: ObservableMap */
    static final class a<T, U> extends e.b.d.d.a<T, U> {

        /* renamed from: f reason: collision with root package name */
        final g<? super T, ? extends U> f8102f;

        a(m<? super U> mVar, g<? super T, ? extends U> gVar) {
            super(mVar);
            this.f8102f = gVar;
        }

        public void a(T t) {
            if (!this.f7975d) {
                if (this.f7976e != 0) {
                    this.f7972a.a(null);
                    return;
                }
                try {
                    Object apply = this.f8102f.apply(t);
                    b.a(apply, "The mapper function returned a null value.");
                    this.f7972a.a(apply);
                } catch (Throwable th) {
                    b(th);
                }
            }
        }

        public int b(int i2) {
            return a(i2);
        }

        public U poll() throws Exception {
            Object poll = this.f7974c.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f8102f.apply(poll);
            b.a(apply, "The mapper function returned a null value.");
            return apply;
        }
    }

    public o(l<T> lVar, g<? super T, ? extends U> gVar) {
        super(lVar);
        this.f8101b = gVar;
    }

    public void b(m<? super U> mVar) {
        this.f8034a.a(new a(mVar, this.f8101b));
    }
}
