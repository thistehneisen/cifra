package e.b.d.e.c;

import e.b.b.b;
import e.b.d.a.c;
import e.b.k;
import e.b.m;
import e.b.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTimer */
public final class x extends k<Long> {

    /* renamed from: a reason: collision with root package name */
    final n f8138a;

    /* renamed from: b reason: collision with root package name */
    final long f8139b;

    /* renamed from: c reason: collision with root package name */
    final TimeUnit f8140c;

    /* compiled from: ObservableTimer */
    static final class a extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final m<? super Long> downstream;

        a(m<? super Long> mVar) {
            this.downstream = mVar;
        }

        public boolean a() {
            return get() == e.b.d.a.b.DISPOSED;
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<b>) this);
        }

        public void run() {
            if (!a()) {
                this.downstream.a(Long.valueOf(0));
                lazySet(c.INSTANCE);
                this.downstream.c();
            }
        }

        public void a(b bVar) {
            e.b.d.a.b.c(this, bVar);
        }
    }

    public x(long j2, TimeUnit timeUnit, n nVar) {
        this.f8139b = j2;
        this.f8140c = timeUnit;
        this.f8138a = nVar;
    }

    public void b(m<? super Long> mVar) {
        a aVar = new a(mVar);
        mVar.a((b) aVar);
        aVar.a(this.f8138a.a(aVar, this.f8139b, this.f8140c));
    }
}
