package e.b;

import e.b.c.g;
import e.b.c.i;
import e.b.d.b.b;
import e.b.d.e.c.c;
import e.b.d.e.c.d;
import e.b.d.e.c.h;
import e.b.d.e.c.j;
import e.b.d.e.c.m;
import e.b.d.e.c.n;
import e.b.d.e.c.o;
import e.b.d.e.c.p;
import e.b.d.e.c.r;
import e.b.d.e.c.t;
import e.b.d.e.c.u;
import e.b.d.e.c.v;
import e.b.d.e.c.w;
import e.b.d.e.c.x;
import e.b.d.j.e;
import e.b.g.a;
import java.util.concurrent.TimeUnit;

/* compiled from: Observable */
public abstract class k<T> implements l<T> {
    public static int a() {
        return e.a();
    }

    public static <T> k<T> b(T t) {
        b.a(t, "The item is null");
        return a.a((k<T>) new n<T>(t));
    }

    public static <T> k<T> d() {
        return a.a(h.f8085a);
    }

    /* access modifiers changed from: protected */
    public abstract void b(m<? super T> mVar);

    public final o<T> e() {
        return a(0);
    }

    public final b f() {
        return a.a((b) new m(this));
    }

    public final g<T> g() {
        return a.a((g<T>) new t<T>(this));
    }

    public final o<T> h() {
        return a.a((o<T>) new u<T>(this, null));
    }

    public final e.b.b.b i() {
        return a(e.b.d.b.a.a(), e.b.d.b.a.f7961f, e.b.d.b.a.f7958c, e.b.d.b.a.a());
    }

    public static <T> k<T> a(l<? extends T> lVar, l<? extends T> lVar2) {
        b.a(lVar, "source1 is null");
        b.a(lVar2, "source2 is null");
        return a((l<? extends T>[]) new l[]{lVar, lVar2});
    }

    public static k<Long> b(long j2, TimeUnit timeUnit) {
        return b(j2, timeUnit, e.b.i.b.a());
    }

    public static k<Long> b(long j2, TimeUnit timeUnit, n nVar) {
        b.a(timeUnit, "unit is null");
        b.a(nVar, "scheduler is null");
        return a.a((k<T>) new x<T>(Math.max(j2, 0), timeUnit, nVar));
    }

    public static <T> k<T> a(l<? extends T>... lVarArr) {
        if (lVarArr.length == 0) {
            return d();
        }
        if (lVarArr.length == 1) {
            return b(lVarArr[0]);
        }
        return a.a((k<T>) new e.b.d.e.c.b<T>(a((T[]) lVarArr), e.b.d.b.a.b(), a(), e.BOUNDARY));
    }

    public static <T> k<T> b(l<T> lVar) {
        b.a(lVar, "source is null");
        if (lVar instanceof k) {
            return a.a((k) lVar);
        }
        return a.a((k<T>) new e.b.d.e.c.k<T>(lVar));
    }

    public static <T> k<T> a(T... tArr) {
        b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return d();
        }
        if (tArr.length == 1) {
            return b(tArr[0]);
        }
        return a.a((k<T>) new j<T>(tArr));
    }

    public final k<T> b() {
        return a(e.b.d.b.a.b());
    }

    public final <R> k<R> b(g<? super T, ? extends R> gVar) {
        b.a(gVar, "mapper is null");
        return a.a((k<T>) new o<T>(this, gVar));
    }

    public final k<T> b(n nVar) {
        b.a(nVar, "scheduler is null");
        return a.a((k<T>) new v<T>(this, nVar));
    }

    public final k<T> a(l<? extends T> lVar) {
        b.a(lVar, "other is null");
        return a((l<? extends T>) this, lVar);
    }

    public final k<T> b(long j2) {
        if (j2 >= 0) {
            return a.a((k<T>) new w<T>(this, j2));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("count >= 0 required but it was ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final k<T> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, e.b.i.b.a());
    }

    public final k<T> a(long j2, TimeUnit timeUnit, n nVar) {
        b.a(timeUnit, "unit is null");
        b.a(nVar, "scheduler is null");
        c cVar = new c(this, j2, timeUnit, nVar);
        return a.a((k<T>) cVar);
    }

    public final <K> k<T> a(g<? super T, K> gVar) {
        b.a(gVar, "keySelector is null");
        return a.a((k<T>) new d<T>(this, gVar, b.a()));
    }

    private k<T> a(e.b.c.e<? super T> eVar, e.b.c.e<? super Throwable> eVar2, e.b.c.a aVar, e.b.c.a aVar2) {
        b.a(eVar, "onNext is null");
        b.a(eVar2, "onError is null");
        b.a(aVar, "onComplete is null");
        b.a(aVar2, "onAfterTerminate is null");
        e.b.d.e.c.e eVar3 = new e.b.d.e.c.e(this, eVar, eVar2, aVar, aVar2);
        return a.a((k<T>) eVar3);
    }

    public final k<T> a(e.b.c.e<? super T> eVar) {
        e.b.c.e a2 = e.b.d.b.a.a();
        e.b.c.a aVar = e.b.d.b.a.f7958c;
        return a(eVar, a2, aVar, aVar);
    }

    public final o<T> a(long j2) {
        if (j2 >= 0) {
            return a.a((o<T>) new e.b.d.e.c.g<T>(this, j2, null));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("index >= 0 required but it was ");
        sb.append(j2);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final k<T> a(i<? super T> iVar) {
        b.a(iVar, "predicate is null");
        return a.a((k<T>) new e.b.d.e.c.i<T>(this, iVar));
    }

    public final k<T> a(n nVar) {
        return a(nVar, false, a());
    }

    public final k<T> a(n nVar, boolean z, int i2) {
        b.a(nVar, "scheduler is null");
        b.a(i2, "bufferSize");
        return a.a((k<T>) new p<T>(this, nVar, z, i2));
    }

    public final e.b.e.a<T> a(int i2) {
        b.a(i2, "bufferSize");
        return r.a((l<T>) this, i2);
    }

    public final e.b.b.b a(e.b.c.e<? super T> eVar, e.b.c.e<? super Throwable> eVar2, e.b.c.a aVar) {
        return a(eVar, eVar2, aVar, e.b.d.b.a.a());
    }

    public final e.b.b.b a(e.b.c.e<? super T> eVar, e.b.c.e<? super Throwable> eVar2, e.b.c.a aVar, e.b.c.e<? super e.b.b.b> eVar3) {
        b.a(eVar, "onNext is null");
        b.a(eVar2, "onError is null");
        b.a(aVar, "onComplete is null");
        b.a(eVar3, "onSubscribe is null");
        e.b.d.d.i iVar = new e.b.d.d.i(eVar, eVar2, aVar, eVar3);
        a((m<? super T>) iVar);
        return iVar;
    }

    public final void a(m<? super T> mVar) {
        b.a(mVar, "observer is null");
        try {
            m a2 = a.a(this, mVar);
            b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final e<T> a(a aVar) {
        e.b.d.e.b.d dVar = new e.b.d.e.b.d(this);
        int i2 = j.f8345a[aVar.ordinal()];
        if (i2 == 1) {
            return dVar.e();
        }
        if (i2 == 2) {
            return dVar.f();
        }
        if (i2 == 3) {
            return dVar;
        }
        if (i2 != 4) {
            return dVar.d();
        }
        return a.a((e<T>) new e.b.d.e.b.g<T>(dVar));
    }
}
