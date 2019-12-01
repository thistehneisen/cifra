package e.b.d.e.a;

import e.b.c;
import e.b.d;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableAndThenCompletable */
public final class a extends e.b.b {

    /* renamed from: a reason: collision with root package name */
    final d f7983a;

    /* renamed from: b reason: collision with root package name */
    final d f7984b;

    /* renamed from: e.b.d.e.a.a$a reason: collision with other inner class name */
    /* compiled from: CompletableAndThenCompletable */
    static final class C0084a implements c {

        /* renamed from: a reason: collision with root package name */
        final AtomicReference<e.b.b.b> f7985a;

        /* renamed from: b reason: collision with root package name */
        final c f7986b;

        public C0084a(AtomicReference<e.b.b.b> atomicReference, c cVar) {
            this.f7985a = atomicReference;
            this.f7986b = cVar;
        }

        public void a(e.b.b.b bVar) {
            e.b.d.a.b.a(this.f7985a, bVar);
        }

        public void c() {
            this.f7986b.c();
        }

        public void a(Throwable th) {
            this.f7986b.a(th);
        }
    }

    /* compiled from: CompletableAndThenCompletable */
    static final class b extends AtomicReference<e.b.b.b> implements c, e.b.b.b {
        private static final long serialVersionUID = -4101678820158072998L;
        final c actualObserver;
        final d next;

        b(c cVar, d dVar) {
            this.actualObserver = cVar;
            this.next = dVar;
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.b(this, bVar)) {
                this.actualObserver.a((e.b.b.b) this);
            }
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void c() {
            this.next.a(new C0084a(this, this.actualObserver));
        }

        public void a(Throwable th) {
            this.actualObserver.a(th);
        }

        public boolean a() {
            return e.b.d.a.b.a((e.b.b.b) get());
        }
    }

    public a(d dVar, d dVar2) {
        this.f7983a = dVar;
        this.f7984b = dVar2;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        this.f7983a.a(new b(cVar, this.f7984b));
    }
}
