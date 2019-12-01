package e.b.d.e.a;

import e.b.b;
import e.b.c;
import e.b.c.e;
import e.b.d;
import io.reactivex.exceptions.CompositeException;

/* compiled from: CompletablePeek */
public final class g extends b {

    /* renamed from: a reason: collision with root package name */
    final d f7994a;

    /* renamed from: b reason: collision with root package name */
    final e<? super e.b.b.b> f7995b;

    /* renamed from: c reason: collision with root package name */
    final e<? super Throwable> f7996c;

    /* renamed from: d reason: collision with root package name */
    final e.b.c.a f7997d;

    /* renamed from: e reason: collision with root package name */
    final e.b.c.a f7998e;

    /* renamed from: f reason: collision with root package name */
    final e.b.c.a f7999f;

    /* renamed from: g reason: collision with root package name */
    final e.b.c.a f8000g;

    /* compiled from: CompletablePeek */
    final class a implements c, e.b.b.b {

        /* renamed from: a reason: collision with root package name */
        final c f8001a;

        /* renamed from: b reason: collision with root package name */
        e.b.b.b f8002b;

        a(c cVar) {
            this.f8001a = cVar;
        }

        public void a(e.b.b.b bVar) {
            try {
                g.this.f7995b.accept(bVar);
                if (e.b.d.a.b.a(this.f8002b, bVar)) {
                    this.f8002b = bVar;
                    this.f8001a.a((e.b.b.b) this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.b();
                this.f8002b = e.b.d.a.b.DISPOSED;
                e.b.d.a.c.a(th, this.f8001a);
            }
        }

        public void b() {
            try {
                g.this.f8000g.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                e.b.g.a.b(th);
            }
            this.f8002b.b();
        }

        public void c() {
            if (this.f8002b != e.b.d.a.b.DISPOSED) {
                try {
                    g.this.f7997d.run();
                    g.this.f7998e.run();
                    this.f8001a.c();
                    d();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f8001a.a(th);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void d() {
            try {
                g.this.f7999f.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                e.b.g.a.b(th);
            }
        }

        public void a(Throwable th) {
            if (this.f8002b == e.b.d.a.b.DISPOSED) {
                e.b.g.a.b(th);
                return;
            }
            try {
                g.this.f7996c.accept(th);
                g.this.f7998e.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f8001a.a(th);
            d();
        }

        public boolean a() {
            return this.f8002b.a();
        }
    }

    public g(d dVar, e<? super e.b.b.b> eVar, e<? super Throwable> eVar2, e.b.c.a aVar, e.b.c.a aVar2, e.b.c.a aVar3, e.b.c.a aVar4) {
        this.f7994a = dVar;
        this.f7995b = eVar;
        this.f7996c = eVar2;
        this.f7997d = aVar;
        this.f7998e = aVar2;
        this.f7999f = aVar3;
        this.f8000g = aVar4;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        this.f7994a.a(new a(cVar));
    }
}
