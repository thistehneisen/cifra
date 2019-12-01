package e.b.d.e.d;

import e.b.b.b;
import e.b.c;
import e.b.d;
import e.b.d.d.j;
import e.b.o;
import e.b.p;
import e.b.q;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleDelayWithCompletable */
public final class a<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<T> f8141a;

    /* renamed from: b reason: collision with root package name */
    final d f8142b;

    /* renamed from: e.b.d.e.d.a$a reason: collision with other inner class name */
    /* compiled from: SingleDelayWithCompletable */
    static final class C0087a<T> extends AtomicReference<b> implements c, b {
        private static final long serialVersionUID = -8565274649390031272L;
        final p<? super T> downstream;
        final q<T> source;

        C0087a(p<? super T> pVar, q<T> qVar) {
            this.downstream = pVar;
            this.source = qVar;
        }

        public void a(b bVar) {
            if (e.b.d.a.b.b(this, bVar)) {
                this.downstream.a((b) this);
            }
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<b>) this);
        }

        public void c() {
            this.source.a(new j(this, this.downstream));
        }

        public void a(Throwable th) {
            this.downstream.a(th);
        }

        public boolean a() {
            return e.b.d.a.b.a((b) get());
        }
    }

    public a(q<T> qVar, d dVar) {
        this.f8141a = qVar;
        this.f8142b = dVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        this.f8142b.a(new C0087a(pVar, this.f8141a));
    }
}
