package e.b.d.e.b;

import e.b.c.g;
import e.b.e;
import k.a.b;
import k.a.c;
import k.a.d;

/* compiled from: FlowableRetryWhen */
public final class k<T> extends a<T, T> {

    /* renamed from: c reason: collision with root package name */
    final g<? super e<Throwable>, ? extends b<?>> f8015c;

    /* compiled from: FlowableRetryWhen */
    static final class a<T> extends j<T, Throwable> {
        private static final long serialVersionUID = -2680129890138081029L;

        a(c<? super T> cVar, e.b.h.a<Throwable> aVar, d dVar) {
            super(cVar, aVar, dVar);
        }

        public void a(Throwable th) {
            b(th);
        }

        public void c() {
            this.receiver.cancel();
            this.downstream.c();
        }
    }

    public k(e<T> eVar, g<? super e<Throwable>, ? extends b<?>> gVar) {
        super(eVar);
        this.f8015c = gVar;
    }

    public void b(c<? super T> cVar) {
        e.b.k.a aVar = new e.b.k.a(cVar);
        e.b.h.a g2 = e.b.h.c.a(8).g();
        try {
            Object apply = this.f8015c.apply(g2);
            e.b.d.b.b.a(apply, "handler returned a null Publisher");
            b bVar = (b) apply;
            i iVar = new i(this.f8004b);
            a aVar2 = new a(aVar, g2, iVar);
            iVar.subscriber = aVar2;
            cVar.a((d) aVar2);
            bVar.a(iVar);
            iVar.a((Object) Integer.valueOf(0));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            e.b.d.i.c.a(th, cVar);
        }
    }
}
