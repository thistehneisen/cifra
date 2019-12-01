package e.b.d.e.c;

import e.b.b.b;
import e.b.l;
import e.b.m;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt */
public final class f<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final long f8066b;

    /* renamed from: c reason: collision with root package name */
    final T f8067c;

    /* renamed from: d reason: collision with root package name */
    final boolean f8068d;

    /* compiled from: ObservableElementAt */
    static final class a<T> implements m<T>, b {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8069a;

        /* renamed from: b reason: collision with root package name */
        final long f8070b;

        /* renamed from: c reason: collision with root package name */
        final T f8071c;

        /* renamed from: d reason: collision with root package name */
        final boolean f8072d;

        /* renamed from: e reason: collision with root package name */
        b f8073e;

        /* renamed from: f reason: collision with root package name */
        long f8074f;

        /* renamed from: g reason: collision with root package name */
        boolean f8075g;

        a(m<? super T> mVar, long j2, T t, boolean z) {
            this.f8069a = mVar;
            this.f8070b = j2;
            this.f8071c = t;
            this.f8072d = z;
        }

        public void a(b bVar) {
            if (e.b.d.a.b.a(this.f8073e, bVar)) {
                this.f8073e = bVar;
                this.f8069a.a((b) this);
            }
        }

        public void b() {
            this.f8073e.b();
        }

        public void c() {
            if (!this.f8075g) {
                this.f8075g = true;
                T t = this.f8071c;
                if (t != null || !this.f8072d) {
                    if (t != null) {
                        this.f8069a.a(t);
                    }
                    this.f8069a.c();
                    return;
                }
                this.f8069a.a((Throwable) new NoSuchElementException());
            }
        }

        public boolean a() {
            return this.f8073e.a();
        }

        public void a(T t) {
            if (!this.f8075g) {
                long j2 = this.f8074f;
                if (j2 == this.f8070b) {
                    this.f8075g = true;
                    this.f8073e.b();
                    this.f8069a.a(t);
                    this.f8069a.c();
                    return;
                }
                this.f8074f = j2 + 1;
            }
        }

        public void a(Throwable th) {
            if (this.f8075g) {
                e.b.g.a.b(th);
                return;
            }
            this.f8075g = true;
            this.f8069a.a(th);
        }
    }

    public f(l<T> lVar, long j2, T t, boolean z) {
        super(lVar);
        this.f8066b = j2;
        this.f8067c = t;
        this.f8068d = z;
    }

    public void b(m<? super T> mVar) {
        l<T> lVar = this.f8034a;
        a aVar = new a(mVar, this.f8066b, this.f8067c, this.f8068d);
        lVar.a(aVar);
    }
}
