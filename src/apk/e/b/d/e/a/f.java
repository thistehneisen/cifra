package e.b.d.e.a;

import e.b.b;
import e.b.c;
import e.b.d;
import e.b.n;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableObserveOn */
public final class f extends b {

    /* renamed from: a reason: collision with root package name */
    final d f7992a;

    /* renamed from: b reason: collision with root package name */
    final n f7993b;

    /* compiled from: CompletableObserveOn */
    static final class a extends AtomicReference<e.b.b.b> implements c, e.b.b.b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final c downstream;
        Throwable error;
        final n scheduler;

        a(c cVar, n nVar) {
            this.downstream = cVar;
            this.scheduler = nVar;
        }

        public boolean a() {
            return e.b.d.a.b.a((e.b.b.b) get());
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this);
        }

        public void c() {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, this.scheduler.a(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.error = null;
                this.downstream.a(th);
                return;
            }
            this.downstream.c();
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.b(this, bVar)) {
                this.downstream.a((e.b.b.b) this);
            }
        }

        public void a(Throwable th) {
            this.error = th;
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, this.scheduler.a(this));
        }
    }

    public f(d dVar, n nVar) {
        this.f7992a = dVar;
        this.f7993b = nVar;
    }

    /* access modifiers changed from: protected */
    public void b(c cVar) {
        this.f7992a.a(new a(cVar, this.f7993b));
    }
}
