package e.b.d.e.c;

import e.b.c.c;
import e.b.c.g;
import e.b.l;
import e.b.m;

/* compiled from: ObservableDistinctUntilChanged */
public final class d<T, K> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final g<? super T, K> f8049b;

    /* renamed from: c reason: collision with root package name */
    final c<? super K, ? super K> f8050c;

    /* compiled from: ObservableDistinctUntilChanged */
    static final class a<T, K> extends e.b.d.d.a<T, T> {

        /* renamed from: f reason: collision with root package name */
        final g<? super T, K> f8051f;

        /* renamed from: g reason: collision with root package name */
        final c<? super K, ? super K> f8052g;

        /* renamed from: h reason: collision with root package name */
        K f8053h;

        /* renamed from: i reason: collision with root package name */
        boolean f8054i;

        a(m<? super T> mVar, g<? super T, K> gVar, c<? super K, ? super K> cVar) {
            super(mVar);
            this.f8051f = gVar;
            this.f8052g = cVar;
        }

        public void a(T t) {
            if (!this.f7975d) {
                if (this.f7976e != 0) {
                    this.f7972a.a(t);
                    return;
                }
                try {
                    K apply = this.f8051f.apply(t);
                    if (this.f8054i) {
                        boolean test = this.f8052g.test(this.f8053h, apply);
                        this.f8053h = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.f8054i = true;
                        this.f8053h = apply;
                    }
                    this.f7972a.a(t);
                } catch (Throwable th) {
                    b(th);
                }
            }
        }

        public int b(int i2) {
            return a(i2);
        }

        public T poll() throws Exception {
            while (true) {
                T poll = this.f7974c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f8051f.apply(poll);
                if (!this.f8054i) {
                    this.f8054i = true;
                    this.f8053h = apply;
                    return poll;
                } else if (!this.f8052g.test(this.f8053h, apply)) {
                    this.f8053h = apply;
                    return poll;
                } else {
                    this.f8053h = apply;
                }
            }
        }
    }

    public d(l<T> lVar, g<? super T, K> gVar, c<? super K, ? super K> cVar) {
        super(lVar);
        this.f8049b = gVar;
        this.f8050c = cVar;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        this.f8034a.a(new a(mVar, this.f8049b, this.f8050c));
    }
}
