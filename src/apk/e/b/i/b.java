package e.b.i;

import e.b.d.g.o;
import e.b.n;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers */
public final class b {

    /* renamed from: a reason: collision with root package name */
    static final n f8336a = e.b.g.a.e(new h());

    /* renamed from: b reason: collision with root package name */
    static final n f8337b = e.b.g.a.b((Callable<n>) new C0093b<n>());

    /* renamed from: c reason: collision with root package name */
    static final n f8338c = e.b.g.a.c((Callable<n>) new c<n>());

    /* renamed from: d reason: collision with root package name */
    static final n f8339d = o.b();

    /* renamed from: e reason: collision with root package name */
    static final n f8340e = e.b.g.a.d(new f());

    /* compiled from: Schedulers */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        static final n f8341a = new e.b.d.g.b();
    }

    /* renamed from: e.b.i.b$b reason: collision with other inner class name */
    /* compiled from: Schedulers */
    static final class C0093b implements Callable<n> {
        C0093b() {
        }

        public n call() throws Exception {
            return a.f8341a;
        }
    }

    /* compiled from: Schedulers */
    static final class c implements Callable<n> {
        c() {
        }

        public n call() throws Exception {
            return d.f8342a;
        }
    }

    /* compiled from: Schedulers */
    static final class d {

        /* renamed from: a reason: collision with root package name */
        static final n f8342a = new e.b.d.g.e();
    }

    /* compiled from: Schedulers */
    static final class e {

        /* renamed from: a reason: collision with root package name */
        static final n f8343a = new e.b.d.g.f();
    }

    /* compiled from: Schedulers */
    static final class f implements Callable<n> {
        f() {
        }

        public n call() throws Exception {
            return e.f8343a;
        }
    }

    /* compiled from: Schedulers */
    static final class g {

        /* renamed from: a reason: collision with root package name */
        static final n f8344a = new e.b.d.g.n();
    }

    /* compiled from: Schedulers */
    static final class h implements Callable<n> {
        h() {
        }

        public n call() throws Exception {
            return g.f8344a;
        }
    }

    public static n a() {
        return e.b.g.a.a(f8337b);
    }

    public static n b() {
        return e.b.g.a.b(f8338c);
    }

    public static n c() {
        return e.b.g.a.c(f8336a);
    }

    public static n d() {
        return f8339d;
    }

    public static n a(Executor executor) {
        return new e.b.d.g.d(executor, false);
    }
}
