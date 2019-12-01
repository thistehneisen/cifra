package e.b.d.e.d;

import e.b.b.b;
import e.b.d.a.f;
import e.b.n;
import e.b.o;
import e.b.p;
import e.b.q;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleSubscribeOn */
public final class m<T> extends o<T> {

    /* renamed from: a reason: collision with root package name */
    final q<? extends T> f8176a;

    /* renamed from: b reason: collision with root package name */
    final n f8177b;

    /* compiled from: SingleSubscribeOn */
    static final class a<T> extends AtomicReference<b> implements p<T>, b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final p<? super T> downstream;
        final q<? extends T> source;
        final f task = new f();

        a(p<? super T> pVar, q<? extends T> qVar) {
            this.downstream = pVar;
            this.source = qVar;
        }

        public void a(b bVar) {
            e.b.d.a.b.b(this, bVar);
        }

        public void b(T t) {
            this.downstream.b(t);
        }

        public void run() {
            this.source.a(this);
        }

        public void a(Throwable th) {
            this.downstream.a(th);
        }

        public void b() {
            e.b.d.a.b.a((AtomicReference<b>) this);
            this.task.b();
        }

        public boolean a() {
            return e.b.d.a.b.a((b) get());
        }
    }

    public m(q<? extends T> qVar, n nVar) {
        this.f8176a = qVar;
        this.f8177b = nVar;
    }

    /* access modifiers changed from: protected */
    public void b(p<? super T> pVar) {
        a aVar = new a(pVar, this.f8176a);
        pVar.a((b) aVar);
        aVar.task.a(this.f8177b.a(aVar));
    }
}
