package e.b.d.e.c;

import e.b.l;
import e.b.m;
import e.b.n;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSubscribeOn */
public final class v<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final n f8130b;

    /* compiled from: ObservableSubscribeOn */
    static final class a<T> extends AtomicReference<e.b.b.b> implements m<T>, e.b.b.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final m<? super T> downstream;
        final AtomicReference<e.b.b.b> upstream = new AtomicReference<>();

        a(m<? super T> mVar) {
            this.downstream = mVar;
        }

        public void a(e.b.b.b bVar) {
            e.b.d.a.b.b(this.upstream, bVar);
        }

        public void b() {
            e.b.d.a.b.a(this.upstream);
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void c() {
            this.downstream.c();
        }

        public void a(T t) {
            this.downstream.a(t);
        }

        public void a(Throwable th) {
            this.downstream.a(th);
        }

        /* access modifiers changed from: 0000 */
        public void b(e.b.b.b bVar) {
            e.b.d.a.b.b(this, bVar);
        }

        public boolean a() {
            return e.b.d.a.b.a((e.b.b.b) get());
        }
    }

    /* compiled from: ObservableSubscribeOn */
    final class b implements Runnable {

        /* renamed from: a reason: collision with root package name */
        private final a<T> f8131a;

        b(a<T> aVar) {
            this.f8131a = aVar;
        }

        public void run() {
            v.this.f8034a.a(this.f8131a);
        }
    }

    public v(l<T> lVar, n nVar) {
        super(lVar);
        this.f8130b = nVar;
    }

    public void b(m<? super T> mVar) {
        a aVar = new a(mVar);
        mVar.a((e.b.b.b) aVar);
        aVar.b(this.f8130b.a(new b(aVar)));
    }
}
