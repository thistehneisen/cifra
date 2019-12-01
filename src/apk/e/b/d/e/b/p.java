package e.b.d.e.b;

import e.b.b.b;
import e.b.d.i.f;
import e.b.e;
import e.b.n;
import io.reactivex.exceptions.MissingBackpressureException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import k.a.c;
import k.a.d;

/* compiled from: FlowableTimer */
public final class p extends e<Long> {

    /* renamed from: b reason: collision with root package name */
    final n f8031b;

    /* renamed from: c reason: collision with root package name */
    final long f8032c;

    /* renamed from: d reason: collision with root package name */
    final TimeUnit f8033d;

    /* compiled from: FlowableTimer */
    static final class a extends AtomicReference<b> implements d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final c<? super Long> downstream;
        volatile boolean requested;

        a(c<? super Long> cVar) {
            this.downstream = cVar;
        }

        public void a(long j2) {
            if (f.c(j2)) {
                this.requested = true;
            }
        }

        public void cancel() {
            e.b.d.a.b.a((AtomicReference<b>) this);
        }

        public void run() {
            if (get() == e.b.d.a.b.DISPOSED) {
                return;
            }
            if (this.requested) {
                this.downstream.a(Long.valueOf(0));
                lazySet(e.b.d.a.c.INSTANCE);
                this.downstream.c();
                return;
            }
            lazySet(e.b.d.a.c.INSTANCE);
            this.downstream.a((Throwable) new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }

        public void a(b bVar) {
            e.b.d.a.b.c(this, bVar);
        }
    }

    public p(long j2, TimeUnit timeUnit, n nVar) {
        this.f8032c = j2;
        this.f8033d = timeUnit;
        this.f8031b = nVar;
    }

    public void b(c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.a((d) aVar);
        aVar.a(this.f8031b.a(aVar, this.f8032c, this.f8033d));
    }
}
