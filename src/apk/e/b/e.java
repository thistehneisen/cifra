package e.b;

import e.b.c.g;
import e.b.d.e.b.f;
import e.b.d.e.b.h;
import e.b.d.e.b.k;
import e.b.d.e.b.l;
import e.b.d.e.b.o;
import e.b.d.e.b.p;
import e.b.g.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import k.a.b;
import k.a.c;

/* compiled from: Flowable */
public abstract class e<T> implements b<T> {

    /* renamed from: a reason: collision with root package name */
    static final int f8302a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f8302a;
    }

    public static <T> e<T> b() {
        return a.a(e.b.d.e.b.b.f8005b);
    }

    /* access modifiers changed from: protected */
    public abstract void b(c<? super T> cVar);

    public final e<T> d() {
        return a(a(), false, true);
    }

    public final e<T> e() {
        return a.a((e<T>) new f<T>(this));
    }

    public final e<T> f() {
        return a.a((e<T>) new h<T>(this));
    }

    public static <T> e<T> a(Callable<? extends Throwable> callable) {
        e.b.d.b.b.a(callable, "errorSupplier is null");
        return a.a((e<T>) new e.b.d.e.b.c<T>(callable));
    }

    public static <T> e<T> b(Throwable th) {
        e.b.d.b.b.a(th, "throwable is null");
        return a(e.b.d.b.a.a(th));
    }

    public static e<Long> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, e.b.i.b.a());
    }

    public final <R> e<R> b(g<? super T, ? extends b<? extends R>> gVar) {
        return a(gVar, a());
    }

    public static e<Long> a(long j2, TimeUnit timeUnit, n nVar) {
        e.b.d.b.b.a(timeUnit, "unit is null");
        e.b.d.b.b.a(nVar, "scheduler is null");
        return a.a((e<T>) new p<T>(Math.max(0, j2), timeUnit, nVar));
    }

    public final e<T> a(int i2, boolean z, boolean z2) {
        e.b.d.b.b.a(i2, "bufferSize");
        e.b.d.e.b.e eVar = new e.b.d.e.b.e(this, i2, z2, z, e.b.d.b.a.f7958c);
        return a.a((e<T>) eVar);
    }

    public final e<T> a(g<? super e<Throwable>, ? extends b<?>> gVar) {
        e.b.d.b.b.a(gVar, "handler is null");
        return a.a((e<T>) new k<T>(this, gVar));
    }

    public final void a(c<? super T> cVar) {
        if (cVar instanceof f) {
            a((f) cVar);
            return;
        }
        e.b.d.b.b.a(cVar, "s is null");
        a((f<? super T>) new e.b.d.h.a<Object>(cVar));
    }

    public final void a(f<? super T> fVar) {
        e.b.d.b.b.a(fVar, "s is null");
        try {
            c a2 = a.a(this, (c<? super T>) fVar);
            e.b.d.b.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    public final <R> e<R> a(g<? super T, ? extends b<? extends R>> gVar, int i2) {
        return a(gVar, i2, false);
    }

    /* access modifiers changed from: 0000 */
    public <R> e<R> a(g<? super T, ? extends b<? extends R>> gVar, int i2, boolean z) {
        e.b.d.b.b.a(gVar, "mapper is null");
        e.b.d.b.b.a(i2, "bufferSize");
        if (!(this instanceof e.b.d.c.h)) {
            return a.a((e<T>) new o<T>(this, gVar, i2, z));
        }
        Object call = ((e.b.d.c.h) this).call();
        if (call == null) {
            return b();
        }
        return l.a(call, gVar);
    }
}
