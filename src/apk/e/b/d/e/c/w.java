package e.b.d.e.c;

import e.b.b.b;
import e.b.d.a.c;
import e.b.l;
import e.b.m;

/* compiled from: ObservableTake */
public final class w<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final long f8133b;

    /* compiled from: ObservableTake */
    static final class a<T> implements m<T>, b {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8134a;

        /* renamed from: b reason: collision with root package name */
        boolean f8135b;

        /* renamed from: c reason: collision with root package name */
        b f8136c;

        /* renamed from: d reason: collision with root package name */
        long f8137d;

        a(m<? super T> mVar, long j2) {
            this.f8134a = mVar;
            this.f8137d = j2;
        }

        public void a(b bVar) {
            if (e.b.d.a.b.a(this.f8136c, bVar)) {
                this.f8136c = bVar;
                if (this.f8137d == 0) {
                    this.f8135b = true;
                    bVar.b();
                    c.a(this.f8134a);
                    return;
                }
                this.f8134a.a((b) this);
            }
        }

        public void b() {
            this.f8136c.b();
        }

        public void c() {
            if (!this.f8135b) {
                this.f8135b = true;
                this.f8136c.b();
                this.f8134a.c();
            }
        }

        public void a(T t) {
            if (!this.f8135b) {
                long j2 = this.f8137d;
                this.f8137d = j2 - 1;
                if (j2 > 0) {
                    boolean z = this.f8137d == 0;
                    this.f8134a.a(t);
                    if (z) {
                        c();
                    }
                }
            }
        }

        public void a(Throwable th) {
            if (this.f8135b) {
                e.b.g.a.b(th);
                return;
            }
            this.f8135b = true;
            this.f8136c.b();
            this.f8134a.a(th);
        }

        public boolean a() {
            return this.f8136c.a();
        }
    }

    public w(l<T> lVar, long j2) {
        super(lVar);
        this.f8133b = j2;
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        this.f8034a.a(new a(mVar, this.f8133b));
    }
}
