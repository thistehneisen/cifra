package e.b;

import e.b.c.f;
import e.b.c.g;
import e.b.d.b.b;
import e.b.d.e.d.c;
import e.b.d.e.d.d;
import e.b.d.e.d.e;
import e.b.d.e.d.h;
import e.b.d.e.d.i;
import e.b.d.e.d.j;
import e.b.d.e.d.k;
import e.b.d.e.d.l;
import e.b.d.e.d.m;
import e.b.d.e.d.n;
import e.b.d.e.d.p;
import e.b.g.a;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

/* compiled from: Single */
public abstract class o<T> implements q<T> {
    public static <T> o<T> a(Callable<? extends Throwable> callable) {
        b.a(callable, "errorSupplier is null");
        return a.a((o<T>) new e<T>(callable));
    }

    public static <T> o<T> b(Callable<? extends T> callable) {
        b.a(callable, "callable is null");
        return a.a((o<T>) new h<T>(callable));
    }

    /* access modifiers changed from: protected */
    public abstract void b(p<? super T> pVar);

    public final o<T> c(e.b.c.e<? super T> eVar) {
        b.a(eVar, "onSuccess is null");
        return a.a((o<T>) new d<T>(this, eVar));
    }

    public final o<T> d(g<? super e<Throwable>, ? extends k.a.b<?>> gVar) {
        return a(e().a(gVar));
    }

    public final e<T> e() {
        if (this instanceof e.b.d.c.a) {
            return ((e.b.d.c.a) this).b();
        }
        return a.a((e<T>) new n<T>(this));
    }

    public final k<T> f() {
        if (this instanceof e.b.d.c.b) {
            return ((e.b.d.c.b) this).a();
        }
        return a.a((k<T>) new e.b.d.e.d.o<T>(this));
    }

    public final b d() {
        return a.a((b) new e.b.d.e.a.e(this));
    }

    public static <T> o<T> a(Throwable th) {
        b.a(th, "error is null");
        return a(e.b.d.b.a.a(th));
    }

    public final o<T> b(e.b.c.e<? super e.b.b.b> eVar) {
        b.a(eVar, "onSubscribe is null");
        return a.a((o<T>) new c<T>(this, eVar));
    }

    public final T c() {
        e.b.d.d.d dVar = new e.b.d.d.d();
        a((p<? super T>) dVar);
        return dVar.a();
    }

    public static <T> o<T> a(T t) {
        b.a(t, "value is null");
        return a.a((o<T>) new i<T>(t));
    }

    public final b b(g<? super T, ? extends d> gVar) {
        b.a(gVar, "mapper is null");
        return a.a((b) new e.b.d.e.d.g(this, gVar));
    }

    public final <R> o<R> c(g<? super T, ? extends R> gVar) {
        b.a(gVar, "mapper is null");
        return a.a((o<T>) new j<T>(this, gVar));
    }

    public static <T1, T2, R> o<R> a(q<? extends T1> qVar, q<? extends T2> qVar2, e.b.c.b<? super T1, ? super T2, ? extends R> bVar) {
        b.a(qVar, "source1 is null");
        b.a(qVar2, "source2 is null");
        return a(e.b.d.b.a.a(bVar), (q<? extends T>[]) new q[]{qVar, qVar2});
    }

    public final o<T> b(T t) {
        b.a(t, "value is null");
        return a.a((o<T>) new l<T>(this, null, t));
    }

    public final o<T> b(n nVar) {
        b.a(nVar, "scheduler is null");
        return a.a((o<T>) new m<T>(this, nVar));
    }

    public static <T1, T2, T3, T4, R> o<R> a(q<? extends T1> qVar, q<? extends T2> qVar2, q<? extends T3> qVar3, q<? extends T4> qVar4, f<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> fVar) {
        b.a(qVar, "source1 is null");
        b.a(qVar2, "source2 is null");
        b.a(qVar3, "source3 is null");
        b.a(qVar4, "source4 is null");
        return a(e.b.d.b.a.a(fVar), (q<? extends T>[]) new q[]{qVar, qVar2, qVar3, qVar4});
    }

    public static <T, R> o<R> a(g<? super Object[], ? extends R> gVar, q<? extends T>... qVarArr) {
        b.a(gVar, "zipper is null");
        b.a(qVarArr, "sources is null");
        if (qVarArr.length == 0) {
            return a((Throwable) new NoSuchElementException());
        }
        return a.a((o<T>) new p<T>(qVarArr, gVar));
    }

    public final o<T> a(e.b.c.e<? super Throwable> eVar) {
        b.a(eVar, "onError is null");
        return a.a((o<T>) new e.b.d.e.d.b<T>(this, eVar));
    }

    public final <R> o<R> a(g<? super T, ? extends q<? extends R>> gVar) {
        b.a(gVar, "mapper is null");
        return a.a((o<T>) new e.b.d.e.d.f<T>(this, gVar));
    }

    public final o<T> a(n nVar) {
        b.a(nVar, "scheduler is null");
        return a.a((o<T>) new k<T>(this, nVar));
    }

    public final e.b.b.b a(e.b.c.e<? super T> eVar, e.b.c.e<? super Throwable> eVar2) {
        b.a(eVar, "onSuccess is null");
        b.a(eVar2, "onError is null");
        e.b.d.d.f fVar = new e.b.d.d.f(eVar, eVar2);
        a((p<? super T>) fVar);
        return fVar;
    }

    public final void a(p<? super T> pVar) {
        b.a(pVar, "subscriber is null");
        p a2 = a.a(this, pVar);
        b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    private static <T> o<T> a(e<T> eVar) {
        return a.a((o<T>) new e.b.d.e.b.n<T>(eVar, null));
    }
}
