package e.b.d.e.b;

import e.b.d.i.e;
import e.b.f;
import e.b.h.a;
import k.a.c;
import k.a.d;

/* compiled from: FlowableRepeatWhen */
abstract class j<T, U> extends e implements f<T> {
    private static final long serialVersionUID = -5604623027276966720L;
    protected final c<? super T> downstream;
    protected final a<U> processor;
    private long produced;
    protected final d receiver;

    j(c<? super T> cVar, a<U> aVar, d dVar) {
        super(false);
        this.downstream = cVar;
        this.processor = aVar;
        this.receiver = dVar;
    }

    public final void a(d dVar) {
        b(dVar);
    }

    /* access modifiers changed from: protected */
    public final void b(U u) {
        b((d) e.b.d.i.c.INSTANCE);
        long j2 = this.produced;
        if (j2 != 0) {
            this.produced = 0;
            b(j2);
        }
        this.receiver.a(1);
        this.processor.a(u);
    }

    public final void cancel() {
        super.cancel();
        this.receiver.cancel();
    }

    public final void a(T t) {
        this.produced++;
        this.downstream.a(t);
    }
}
