package e.b;

import e.b.c.e;
import e.b.d.d.h;
import e.b.d.e.a.c;
import e.b.d.e.a.d;
import e.b.d.e.a.f;
import e.b.d.e.a.g;
import e.b.g.a;

/* compiled from: Completable */
public abstract class b implements d {
    public static b a(Throwable th) {
        e.b.d.b.b.a(th, "error is null");
        return a.a((b) new c(th));
    }

    public static b b() {
        return a.a(e.b.d.e.a.b.f7987a);
    }

    /* access modifiers changed from: protected */
    public abstract void b(c cVar);

    public final e.b.b.b c() {
        h hVar = new h();
        a((c) hVar);
        return hVar;
    }

    private static NullPointerException b(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b a(e.b.c.a aVar) {
        e.b.d.b.b.a(aVar, "run is null");
        return a.a((b) new d(aVar));
    }

    public final <T> o<T> a(q<T> qVar) {
        e.b.d.b.b.a(qVar, "next is null");
        return a.a((o<T>) new e.b.d.e.d.a<T>(qVar, this));
    }

    public final b a(d dVar) {
        e.b.d.b.b.a(dVar, "next is null");
        return a.a((b) new e.b.d.e.a.a(this, dVar));
    }

    public final b a(e<? super Throwable> eVar) {
        e a2 = e.b.d.b.a.a();
        e.b.c.a aVar = e.b.d.b.a.f7958c;
        return a(a2, eVar, aVar, aVar, aVar, aVar);
    }

    private b a(e<? super e.b.b.b> eVar, e<? super Throwable> eVar2, e.b.c.a aVar, e.b.c.a aVar2, e.b.c.a aVar3, e.b.c.a aVar4) {
        e.b.d.b.b.a(eVar, "onSubscribe is null");
        e.b.d.b.b.a(eVar2, "onError is null");
        e.b.d.b.b.a(aVar, "onComplete is null");
        e.b.d.b.b.a(aVar2, "onTerminate is null");
        e.b.d.b.b.a(aVar3, "onAfterTerminate is null");
        e.b.d.b.b.a(aVar4, "onDispose is null");
        g gVar = new g(this, eVar, eVar2, aVar, aVar2, aVar3, aVar4);
        return a.a((b) gVar);
    }

    public final b a(n nVar) {
        e.b.d.b.b.a(nVar, "scheduler is null");
        return a.a((b) new f(this, nVar));
    }

    public final void a(c cVar) {
        e.b.d.b.b.a(cVar, "s is null");
        try {
            c a2 = a.a(this, cVar);
            e.b.d.b.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            a.b(th);
            throw b(th);
        }
    }

    public final e.b.b.b a(e.b.c.a aVar, e<? super Throwable> eVar) {
        e.b.d.b.b.a(eVar, "onError is null");
        e.b.d.b.b.a(aVar, "onComplete is null");
        e.b.d.d.e eVar2 = new e.b.d.d.e(eVar, aVar);
        a((c) eVar2);
        return eVar2;
    }
}
