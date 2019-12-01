package e.b.d.b;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;

/* compiled from: Functions */
public final class a {

    /* renamed from: a reason: collision with root package name */
    static final e.b.c.g<Object, Object> f7956a = new i();

    /* renamed from: b reason: collision with root package name */
    public static final Runnable f7957b = new f();

    /* renamed from: c reason: collision with root package name */
    public static final e.b.c.a f7958c = new c();

    /* renamed from: d reason: collision with root package name */
    static final e.b.c.e<Object> f7959d = new d();

    /* renamed from: e reason: collision with root package name */
    public static final e.b.c.e<Throwable> f7960e = new g();

    /* renamed from: f reason: collision with root package name */
    public static final e.b.c.e<Throwable> f7961f = new n();

    /* renamed from: g reason: collision with root package name */
    public static final e.b.c.h f7962g = new e();

    /* renamed from: h reason: collision with root package name */
    static final e.b.c.i<Object> f7963h = new o();

    /* renamed from: i reason: collision with root package name */
    static final e.b.c.i<Object> f7964i = new h();

    /* renamed from: j reason: collision with root package name */
    static final Callable<Object> f7965j = new m();

    /* renamed from: k reason: collision with root package name */
    static final Comparator<Object> f7966k = new l();

    /* renamed from: l reason: collision with root package name */
    public static final e.b.c.e<k.a.d> f7967l = new k();

    /* renamed from: e.b.d.b.a$a reason: collision with other inner class name */
    /* compiled from: Functions */
    static final class C0083a<T1, T2, R> implements e.b.c.g<Object[], R> {

        /* renamed from: a reason: collision with root package name */
        final e.b.c.b<? super T1, ? super T2, ? extends R> f7968a;

        C0083a(e.b.c.b<? super T1, ? super T2, ? extends R> bVar) {
            this.f7968a = bVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f7968a.apply(objArr[0], objArr[1]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 2 expected but got ");
            sb.append(objArr.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* compiled from: Functions */
    static final class b<T1, T2, T3, T4, R> implements e.b.c.g<Object[], R> {

        /* renamed from: a reason: collision with root package name */
        final e.b.c.f<T1, T2, T3, T4, R> f7969a;

        b(e.b.c.f<T1, T2, T3, T4, R> fVar) {
            this.f7969a = fVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return this.f7969a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 4 expected but got ");
            sb.append(objArr.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* compiled from: Functions */
    static final class c implements e.b.c.a {
        c() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions */
    static final class d implements e.b.c.e<Object> {
        d() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions */
    static final class e implements e.b.c.h {
        e() {
        }
    }

    /* compiled from: Functions */
    static final class f implements Runnable {
        f() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions */
    static final class g implements e.b.c.e<Throwable> {
        g() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            e.b.g.a.b(th);
        }
    }

    /* compiled from: Functions */
    static final class h implements e.b.c.i<Object> {
        h() {
        }

        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions */
    static final class i implements e.b.c.g<Object, Object> {
        i() {
        }

        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions */
    static final class j<T, U> implements Callable<U>, e.b.c.g<T, U> {

        /* renamed from: a reason: collision with root package name */
        final U f7970a;

        j(U u) {
            this.f7970a = u;
        }

        public U apply(T t) throws Exception {
            return this.f7970a;
        }

        public U call() throws Exception {
            return this.f7970a;
        }
    }

    /* compiled from: Functions */
    static final class k implements e.b.c.e<k.a.d> {
        k() {
        }

        /* renamed from: a */
        public void accept(k.a.d dVar) throws Exception {
            dVar.a(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions */
    static final class l implements Comparator<Object> {
        l() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions */
    static final class m implements Callable<Object> {
        m() {
        }

        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions */
    static final class n implements e.b.c.e<Throwable> {
        n() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            e.b.g.a.b((Throwable) new OnErrorNotImplementedException(th));
        }
    }

    /* compiled from: Functions */
    static final class o implements e.b.c.i<Object> {
        o() {
        }

        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T1, T2, R> e.b.c.g<Object[], R> a(e.b.c.b<? super T1, ? super T2, ? extends R> bVar) {
        b.a(bVar, "f is null");
        return new C0083a(bVar);
    }

    public static <T> e.b.c.g<T, T> b() {
        return f7956a;
    }

    public static <T1, T2, T3, T4, R> e.b.c.g<Object[], R> a(e.b.c.f<T1, T2, T3, T4, R> fVar) {
        b.a(fVar, "f is null");
        return new b(fVar);
    }

    public static <T> e.b.c.e<T> a() {
        return f7959d;
    }

    public static <T> Callable<T> a(T t) {
        return new j(t);
    }
}
