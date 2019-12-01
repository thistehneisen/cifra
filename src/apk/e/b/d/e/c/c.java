package e.b.d.e.c;

import e.b.l;
import e.b.m;
import e.b.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounceTimed */
public final class c<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final long f8038b;

    /* renamed from: c reason: collision with root package name */
    final TimeUnit f8039c;

    /* renamed from: d reason: collision with root package name */
    final n f8040d;

    /* compiled from: ObservableDebounceTimed */
    static final class a<T> extends AtomicReference<e.b.b.b> implements Runnable, e.b.b.b {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final b<T> parent;
        final T value;

        a(T t, long j2, b<T> bVar) {
            this.value = t;
            this.idx = j2;
            this.parent = bVar;
        }

        public boolean a() {
            return get() == e.b.d.a.b.DISPOSED;
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void a(e.b.b.b bVar) {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, bVar);
        }
    }

    /* compiled from: ObservableDebounceTimed */
    static final class b<T> implements m<T>, e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8041a;

        /* renamed from: b reason: collision with root package name */
        final long f8042b;

        /* renamed from: c reason: collision with root package name */
        final TimeUnit f8043c;

        /* renamed from: d reason: collision with root package name */
        final e.b.n.b f8044d;

        /* renamed from: e reason: collision with root package name */
        e.b.b.b f8045e;

        /* renamed from: f reason: collision with root package name */
        e.b.b.b f8046f;

        /* renamed from: g reason: collision with root package name */
        volatile long f8047g;

        /* renamed from: h reason: collision with root package name */
        boolean f8048h;

        b(m<? super T> mVar, long j2, TimeUnit timeUnit, e.b.n.b bVar) {
            this.f8041a = mVar;
            this.f8042b = j2;
            this.f8043c = timeUnit;
            this.f8044d = bVar;
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.f8045e, bVar)) {
                this.f8045e = bVar;
                this.f8041a.a((e.b.b.b) this);
            }
        }

        public void b() {
            this.f8045e.b();
            this.f8044d.b();
        }

        public void c() {
            if (!this.f8048h) {
                this.f8048h = true;
                e.b.b.b bVar = this.f8046f;
                if (bVar != null) {
                    bVar.b();
                }
                a aVar = (a) bVar;
                if (aVar != null) {
                    aVar.run();
                }
                this.f8041a.c();
                this.f8044d.b();
            }
        }

        public void a(T t) {
            if (!this.f8048h) {
                long j2 = this.f8047g + 1;
                this.f8047g = j2;
                e.b.b.b bVar = this.f8046f;
                if (bVar != null) {
                    bVar.b();
                }
                a aVar = new a(t, j2, this);
                this.f8046f = aVar;
                aVar.a(this.f8044d.a(aVar, this.f8042b, this.f8043c));
            }
        }

        public void a(Throwable th) {
            if (this.f8048h) {
                e.b.g.a.b(th);
                return;
            }
            e.b.b.b bVar = this.f8046f;
            if (bVar != null) {
                bVar.b();
            }
            this.f8048h = true;
            this.f8041a.a(th);
            this.f8044d.b();
        }

        public boolean a() {
            return this.f8044d.a();
        }

        /* access modifiers changed from: 0000 */
        public void a(long j2, T t, a<T> aVar) {
            if (j2 == this.f8047g) {
                this.f8041a.a(t);
                aVar.b();
            }
        }
    }

    public c(l<T> lVar, long j2, TimeUnit timeUnit, n nVar) {
        super(lVar);
        this.f8038b = j2;
        this.f8039c = timeUnit;
        this.f8040d = nVar;
    }

    public void b(m<? super T> mVar) {
        l<T> lVar = this.f8034a;
        b bVar = new b(new e.b.f.b(mVar), this.f8038b, this.f8039c, this.f8040d.a());
        lVar.a(bVar);
    }
}
