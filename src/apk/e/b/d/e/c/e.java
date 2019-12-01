package e.b.d.e.c;

import e.b.b.b;
import e.b.l;
import e.b.m;
import io.reactivex.exceptions.CompositeException;

/* compiled from: ObservableDoOnEach */
public final class e<T> extends a<T, T> {

    /* renamed from: b reason: collision with root package name */
    final e.b.c.e<? super T> f8055b;

    /* renamed from: c reason: collision with root package name */
    final e.b.c.e<? super Throwable> f8056c;

    /* renamed from: d reason: collision with root package name */
    final e.b.c.a f8057d;

    /* renamed from: e reason: collision with root package name */
    final e.b.c.a f8058e;

    /* compiled from: ObservableDoOnEach */
    static final class a<T> implements m<T>, b {

        /* renamed from: a reason: collision with root package name */
        final m<? super T> f8059a;

        /* renamed from: b reason: collision with root package name */
        final e.b.c.e<? super T> f8060b;

        /* renamed from: c reason: collision with root package name */
        final e.b.c.e<? super Throwable> f8061c;

        /* renamed from: d reason: collision with root package name */
        final e.b.c.a f8062d;

        /* renamed from: e reason: collision with root package name */
        final e.b.c.a f8063e;

        /* renamed from: f reason: collision with root package name */
        b f8064f;

        /* renamed from: g reason: collision with root package name */
        boolean f8065g;

        a(m<? super T> mVar, e.b.c.e<? super T> eVar, e.b.c.e<? super Throwable> eVar2, e.b.c.a aVar, e.b.c.a aVar2) {
            this.f8059a = mVar;
            this.f8060b = eVar;
            this.f8061c = eVar2;
            this.f8062d = aVar;
            this.f8063e = aVar2;
        }

        public void a(b bVar) {
            if (e.b.d.a.b.a(this.f8064f, bVar)) {
                this.f8064f = bVar;
                this.f8059a.a((b) this);
            }
        }

        public void b() {
            this.f8064f.b();
        }

        public void c() {
            if (!this.f8065g) {
                try {
                    this.f8062d.run();
                    this.f8065g = true;
                    this.f8059a.c();
                    try {
                        this.f8063e.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        e.b.g.a.b(th);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    a(th2);
                }
            }
        }

        public boolean a() {
            return this.f8064f.a();
        }

        public void a(T t) {
            if (!this.f8065g) {
                try {
                    this.f8060b.accept(t);
                    this.f8059a.a(t);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f8064f.b();
                    a(th);
                }
            }
        }

        public void a(Throwable th) {
            if (this.f8065g) {
                e.b.g.a.b(th);
                return;
            }
            this.f8065g = true;
            try {
                this.f8061c.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f8059a.a(th);
            try {
                this.f8063e.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                e.b.g.a.b(th3);
            }
        }
    }

    public e(l<T> lVar, e.b.c.e<? super T> eVar, e.b.c.e<? super Throwable> eVar2, e.b.c.a aVar, e.b.c.a aVar2) {
        super(lVar);
        this.f8055b = eVar;
        this.f8056c = eVar2;
        this.f8057d = aVar;
        this.f8058e = aVar2;
    }

    public void b(m<? super T> mVar) {
        l<T> lVar = this.f8034a;
        a aVar = new a(mVar, this.f8055b, this.f8056c, this.f8057d, this.f8058e);
        lVar.a(aVar);
    }
}
