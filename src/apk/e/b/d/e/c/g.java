package e.b.d.e.c;

import e.b.d.c.b;
import e.b.k;
import e.b.l;
import e.b.m;
import e.b.o;
import e.b.p;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAtSingle */
public final class g<T> extends o<T> implements b<T> {

    /* renamed from: a reason: collision with root package name */
    final l<T> f8076a;

    /* renamed from: b reason: collision with root package name */
    final long f8077b;

    /* renamed from: c reason: collision with root package name */
    final T f8078c;

    /* compiled from: ObservableElementAtSingle */
    static final class a<T> implements m<T>, e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        final p<? super T> f8079a;

        /* renamed from: b reason: collision with root package name */
        final long f8080b;

        /* renamed from: c reason: collision with root package name */
        final T f8081c;

        /* renamed from: d reason: collision with root package name */
        e.b.b.b f8082d;

        /* renamed from: e reason: collision with root package name */
        long f8083e;

        /* renamed from: f reason: collision with root package name */
        boolean f8084f;

        a(p<? super T> pVar, long j2, T t) {
            this.f8079a = pVar;
            this.f8080b = j2;
            this.f8081c = t;
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.f8082d, bVar)) {
                this.f8082d = bVar;
                this.f8079a.a((e.b.b.b) this);
            }
        }

        public void b() {
            this.f8082d.b();
        }

        public void c() {
            if (!this.f8084f) {
                this.f8084f = true;
                T t = this.f8081c;
                if (t != null) {
                    this.f8079a.b(t);
                } else {
                    this.f8079a.a((Throwable) new NoSuchElementException());
                }
            }
        }

        public boolean a() {
            return this.f8082d.a();
        }

        public void a(T t) {
            if (!this.f8084f) {
                long j2 = this.f8083e;
                if (j2 == this.f8080b) {
                    this.f8084f = true;
                    this.f8082d.b();
                    this.f8079a.b(t);
                    return;
                }
                this.f8083e = j2 + 1;
            }
        }

        public void a(Throwable th) {
            if (this.f8084f) {
                e.b.g.a.b(th);
                return;
            }
            this.f8084f = true;
            this.f8079a.a(th);
        }
    }

    public g(l<T> lVar, long j2, T t) {
        this.f8076a = lVar;
        this.f8077b = j2;
        this.f8078c = t;
    }

    public k<T> a() {
        f fVar = new f(this.f8076a, this.f8077b, this.f8078c, true);
        return e.b.g.a.a((k<T>) fVar);
    }

    public void b(p<? super T> pVar) {
        this.f8076a.a(new a(pVar, this.f8077b, this.f8078c));
    }
}
