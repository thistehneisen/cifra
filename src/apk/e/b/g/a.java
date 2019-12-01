package e.b.g;

import e.b.b;
import e.b.c.d;
import e.b.c.e;
import e.b.c.g;
import e.b.d.j.f;
import e.b.k;
import e.b.m;
import e.b.n;
import e.b.o;
import e.b.p;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import java.util.concurrent.Callable;
import k.a.c;

/* compiled from: RxJavaPlugins */
public final class a {

    /* renamed from: a reason: collision with root package name */
    static volatile e<? super Throwable> f8309a;

    /* renamed from: b reason: collision with root package name */
    static volatile g<? super Runnable, ? extends Runnable> f8310b;

    /* renamed from: c reason: collision with root package name */
    static volatile g<? super Callable<n>, ? extends n> f8311c;

    /* renamed from: d reason: collision with root package name */
    static volatile g<? super Callable<n>, ? extends n> f8312d;

    /* renamed from: e reason: collision with root package name */
    static volatile g<? super Callable<n>, ? extends n> f8313e;

    /* renamed from: f reason: collision with root package name */
    static volatile g<? super Callable<n>, ? extends n> f8314f;

    /* renamed from: g reason: collision with root package name */
    static volatile g<? super n, ? extends n> f8315g;

    /* renamed from: h reason: collision with root package name */
    static volatile g<? super n, ? extends n> f8316h;

    /* renamed from: i reason: collision with root package name */
    static volatile g<? super n, ? extends n> f8317i;

    /* renamed from: j reason: collision with root package name */
    static volatile g<? super e.b.e, ? extends e.b.e> f8318j;

    /* renamed from: k reason: collision with root package name */
    static volatile g<? super k, ? extends k> f8319k;

    /* renamed from: l reason: collision with root package name */
    static volatile g<? super e.b.e.a, ? extends e.b.e.a> f8320l;
    static volatile g<? super e.b.g, ? extends e.b.g> m;
    static volatile g<? super o, ? extends o> n;
    static volatile g<? super b, ? extends b> o;
    static volatile e.b.c.b<? super e.b.e, ? super c, ? extends c> p;
    static volatile e.b.c.b<? super k, ? super m, ? extends m> q;
    static volatile e.b.c.b<? super o, ? super p, ? extends p> r;
    static volatile e.b.c.b<? super b, ? super e.b.c, ? extends e.b.c> s;
    static volatile d t;
    static volatile boolean u;

    public static boolean a() {
        return u;
    }

    public static n b(Callable<n> callable) {
        e.b.d.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<n>, ? extends n> gVar = f8311c;
        if (gVar == null) {
            return a(callable);
        }
        return a(gVar, callable);
    }

    public static n c(Callable<n> callable) {
        e.b.d.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<n>, ? extends n> gVar = f8313e;
        if (gVar == null) {
            return a(callable);
        }
        return a(gVar, callable);
    }

    public static n d(Callable<n> callable) {
        e.b.d.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<n>, ? extends n> gVar = f8314f;
        if (gVar == null) {
            return a(callable);
        }
        return a(gVar, callable);
    }

    public static n e(Callable<n> callable) {
        e.b.d.b.b.a(callable, "Scheduler Callable can't be null");
        g<? super Callable<n>, ? extends n> gVar = f8312d;
        if (gVar == null) {
            return a(callable);
        }
        return a(gVar, callable);
    }

    public static n a(n nVar) {
        g<? super n, ? extends n> gVar = f8315g;
        if (gVar == null) {
            return nVar;
        }
        return (n) a(gVar, (T) nVar);
    }

    static boolean a(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    public static void b(Throwable th) {
        e<? super Throwable> eVar = f8309a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new UndeliverableException(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static n c(n nVar) {
        g<? super n, ? extends n> gVar = f8316h;
        if (gVar == null) {
            return nVar;
        }
        return (n) a(gVar, (T) nVar);
    }

    public static Runnable a(Runnable runnable) {
        e.b.d.b.b.a(runnable, "run is null");
        g<? super Runnable, ? extends Runnable> gVar = f8310b;
        if (gVar == null) {
            return runnable;
        }
        return (Runnable) a(gVar, (T) runnable);
    }

    public static <T> c<? super T> a(e.b.e<T> eVar, c<? super T> cVar) {
        e.b.c.b<? super e.b.e, ? super c, ? extends c> bVar = p;
        return bVar != null ? (c) a(bVar, eVar, cVar) : cVar;
    }

    public static n b(n nVar) {
        g<? super n, ? extends n> gVar = f8317i;
        if (gVar == null) {
            return nVar;
        }
        return (n) a(gVar, (T) nVar);
    }

    public static <T> m<? super T> a(k<T> kVar, m<? super T> mVar) {
        e.b.c.b<? super k, ? super m, ? extends m> bVar = q;
        return bVar != null ? (m) a(bVar, kVar, mVar) : mVar;
    }

    public static boolean b() {
        d dVar = t;
        if (dVar == null) {
            return false;
        }
        try {
            return dVar.getAsBoolean();
        } catch (Throwable th) {
            throw f.a(th);
        }
    }

    public static <T> p<? super T> a(o<T> oVar, p<? super T> pVar) {
        e.b.c.b<? super o, ? super p, ? extends p> bVar = r;
        return bVar != null ? (p) a(bVar, oVar, pVar) : pVar;
    }

    public static e.b.c a(b bVar, e.b.c cVar) {
        e.b.c.b<? super b, ? super e.b.c, ? extends e.b.c> bVar2 = s;
        return bVar2 != null ? (e.b.c) a(bVar2, bVar, cVar) : cVar;
    }

    public static <T> e.b.g<T> a(e.b.g<T> gVar) {
        g<? super e.b.g, ? extends e.b.g> gVar2 = m;
        return gVar2 != null ? (e.b.g) a(gVar2, (T) gVar) : gVar;
    }

    public static <T> e.b.e<T> a(e.b.e<T> eVar) {
        g<? super e.b.e, ? extends e.b.e> gVar = f8318j;
        return gVar != null ? (e.b.e) a(gVar, (T) eVar) : eVar;
    }

    public static <T> k<T> a(k<T> kVar) {
        g<? super k, ? extends k> gVar = f8319k;
        return gVar != null ? (k) a(gVar, (T) kVar) : kVar;
    }

    public static <T> e.b.e.a<T> a(e.b.e.a<T> aVar) {
        g<? super e.b.e.a, ? extends e.b.e.a> gVar = f8320l;
        return gVar != null ? (e.b.e.a) a(gVar, (T) aVar) : aVar;
    }

    public static <T> o<T> a(o<T> oVar) {
        g<? super o, ? extends o> gVar = n;
        return gVar != null ? (o) a(gVar, (T) oVar) : oVar;
    }

    public static b a(b bVar) {
        g<? super b, ? extends b> gVar = o;
        return gVar != null ? (b) a(gVar, (T) bVar) : bVar;
    }

    static <T, R> R a(g<T, R> gVar, T t2) {
        try {
            return gVar.apply(t2);
        } catch (Throwable th) {
            throw f.a(th);
        }
    }

    static <T, U, R> R a(e.b.c.b<T, U, R> bVar, T t2, U u2) {
        try {
            return bVar.apply(t2, u2);
        } catch (Throwable th) {
            throw f.a(th);
        }
    }

    static n a(Callable<n> callable) {
        try {
            Object call = callable.call();
            e.b.d.b.b.a(call, "Scheduler Callable result can't be null");
            return (n) call;
        } catch (Throwable th) {
            throw f.a(th);
        }
    }

    static n a(g<? super Callable<n>, ? extends n> gVar, Callable<n> callable) {
        Object a2 = a(gVar, (T) callable);
        e.b.d.b.b.a(a2, "Scheduler Callable result can't be null");
        return (n) a2;
    }
}
