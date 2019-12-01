package e.b.d.e.b;

import e.b.c.g;
import e.b.e;
import java.util.concurrent.Callable;
import k.a.b;
import k.a.c;
import k.a.d;

/* compiled from: FlowableScalarXMap */
public final class l {

    /* compiled from: FlowableScalarXMap */
    static final class a<T, R> extends e<R> {

        /* renamed from: b reason: collision with root package name */
        final T f8016b;

        /* renamed from: c reason: collision with root package name */
        final g<? super T, ? extends b<? extends R>> f8017c;

        a(T t, g<? super T, ? extends b<? extends R>> gVar) {
            this.f8016b = t;
            this.f8017c = gVar;
        }

        public void b(c<? super R> cVar) {
            try {
                Object apply = this.f8017c.apply(this.f8016b);
                e.b.d.b.b.a(apply, "The mapper returned a null Publisher");
                b bVar = (b) apply;
                if (bVar instanceof Callable) {
                    try {
                        Object call = ((Callable) bVar).call();
                        if (call == null) {
                            e.b.d.i.c.a(cVar);
                            return;
                        }
                        cVar.a((d) new e.b.d.i.d(cVar, call));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        e.b.d.i.c.a(th, cVar);
                    }
                } else {
                    bVar.a(cVar);
                }
            } catch (Throwable th2) {
                e.b.d.i.c.a(th2, cVar);
            }
        }
    }

    public static <T, R> boolean a(b<T> bVar, c<? super R> cVar, g<? super T, ? extends b<? extends R>> gVar) {
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            Object call = ((Callable) bVar).call();
            if (call == null) {
                e.b.d.i.c.a(cVar);
                return true;
            }
            try {
                Object apply = gVar.apply(call);
                e.b.d.b.b.a(apply, "The mapper returned a null Publisher");
                b bVar2 = (b) apply;
                if (bVar2 instanceof Callable) {
                    try {
                        Object call2 = ((Callable) bVar2).call();
                        if (call2 == null) {
                            e.b.d.i.c.a(cVar);
                            return true;
                        }
                        cVar.a((d) new e.b.d.i.d(cVar, call2));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        e.b.d.i.c.a(th, cVar);
                        return true;
                    }
                } else {
                    bVar2.a(cVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                e.b.d.i.c.a(th2, cVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            e.b.d.i.c.a(th3, cVar);
            return true;
        }
    }

    public static <T, U> e<U> a(T t, g<? super T, ? extends b<? extends U>> gVar) {
        return e.b.g.a.a((e<T>) new a<T>(t, gVar));
    }
}
