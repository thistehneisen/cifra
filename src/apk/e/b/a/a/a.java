package e.b.a.a;

import e.b.c.g;
import e.b.n;
import java.util.concurrent.Callable;

/* compiled from: RxAndroidPlugins */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static volatile g<Callable<n>, n> f7935a;

    /* renamed from: b reason: collision with root package name */
    private static volatile g<n, n> f7936b;

    public static n a(n nVar) {
        if (nVar != null) {
            g<n, n> gVar = f7936b;
            if (gVar == null) {
                return nVar;
            }
            return (n) a(gVar, (T) nVar);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static n b(Callable<n> callable) {
        if (callable != null) {
            g<Callable<n>, n> gVar = f7935a;
            if (gVar == null) {
                return a(callable);
            }
            return a(gVar, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    static n a(Callable<n> callable) {
        try {
            n nVar = (n) callable.call();
            if (nVar != null) {
                return nVar;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            throw null;
        }
    }

    static n a(g<Callable<n>, n> gVar, Callable<n> callable) {
        n nVar = (n) a(gVar, (T) callable);
        if (nVar != null) {
            return nVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R a(g<T, R> gVar, T t) {
        try {
            return gVar.apply(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            throw null;
        }
    }
}
