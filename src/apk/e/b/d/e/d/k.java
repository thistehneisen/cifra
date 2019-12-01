package e.b.d.e.d;

import e.b.b.b;
import e.b.n;
import e.b.o;
import e.b.p;
import e.b.q;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleObserveOn */
public final class k<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<T> f8169a;

    /* renamed from: b reason: collision with root package name */
    final n f8170b;

    /* compiled from: SingleObserveOn */
    static final class a<T> extends AtomicReference<b> implements p<T>, b, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final p<? super T> downstream;
        Throwable error;
        final n scheduler;
        T value;

        a(p<? super T> pVar, n nVar) {
            this.downstream = pVar;
            this.scheduler = nVar;
        }

        public void a(b bVar) {
            if (e.b.d.a.b.b(this, bVar)) {
                this.downstream.a((b) this);
            }
        }

        public void b(T t) {
            this.value = t;
            e.b.d.a.b.a((AtomicReference<b>) this, this.scheduler.a(this));
        }

        public void run() {
            Throwable th = this.error;
            if (th != null) {
                this.downstream.a(th);
            } else {
                this.downstream.b(this.value);
            }
        }

        public void a(Throwable th) {
            this.error = th;
            e.b.d.a.b.a((AtomicReference<b>) this, this.scheduler.a(this));
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<b>) this);
        }

        public boolean a() {
            return e.b.d.a.b.a((b) get());
        }
    }

    public k(q<T> qVar, n nVar) {
        this.f8169a = qVar;
        this.f8170b = nVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8169a.a(new a(pVar, this.f8170b));
    }
}
