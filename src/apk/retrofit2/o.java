package retrofit2;

import i.C0721j;
import i.D;
import i.M;
import i.O;
import j.A;
import j.h;
import j.r;
import java.io.IOException;

/* compiled from: OkHttpCall */
final class o<T> implements b<T> {

    /* renamed from: a reason: collision with root package name */
    private final x<T, ?> f11010a;

    /* renamed from: b reason: collision with root package name */
    private final Object[] f11011b;

    /* renamed from: c reason: collision with root package name */
    private volatile boolean f11012c;

    /* renamed from: d reason: collision with root package name */
    private C0721j f11013d;

    /* renamed from: e reason: collision with root package name */
    private Throwable f11014e;

    /* renamed from: f reason: collision with root package name */
    private boolean f11015f;

    /* compiled from: OkHttpCall */
    static final class a extends O {

        /* renamed from: a reason: collision with root package name */
        private final O f11016a;

        /* renamed from: b reason: collision with root package name */
        IOException f11017b;

        a(O o) {
            this.f11016a = o;
        }

        public long b() {
            return this.f11016a.b();
        }

        public D c() {
            return this.f11016a.c();
        }

        public void close() {
            this.f11016a.close();
        }

        public h d() {
            return r.a((A) new n(this, this.f11016a.d()));
        }

        /* access modifiers changed from: 0000 */
        public void e() throws IOException {
            IOException iOException = this.f11017b;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    /* compiled from: OkHttpCall */
    static final class b extends O {

        /* renamed from: a reason: collision with root package name */
        private final D f11018a;

        /* renamed from: b reason: collision with root package name */
        private final long f11019b;

        b(D d2, long j2) {
            this.f11018a = d2;
            this.f11019b = j2;
        }

        public long b() {
            return this.f11019b;
        }

        public D c() {
            return this.f11018a;
        }

        public h d() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    o(x<T, ?> xVar, Object[] objArr) {
        this.f11010a = xVar;
        this.f11011b = objArr;
    }

    public void a(d<T> dVar) {
        C0721j jVar;
        Throwable th;
        y.a(dVar, "callback == null");
        synchronized (this) {
            if (!this.f11015f) {
                this.f11015f = true;
                jVar = this.f11013d;
                th = this.f11014e;
                if (jVar == null && th == null) {
                    try {
                        C0721j a2 = a();
                        this.f11013d = a2;
                        jVar = a2;
                    } catch (Throwable th2) {
                        th = th2;
                        y.a(th);
                        this.f11014e = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            dVar.a((b<T>) this, th);
            return;
        }
        if (this.f11012c) {
            jVar.cancel();
        }
        jVar.a(new m(this, dVar));
    }

    public void cancel() {
        C0721j jVar;
        this.f11012c = true;
        synchronized (this) {
            jVar = this.f11013d;
        }
        if (jVar != null) {
            jVar.cancel();
        }
    }

    public u<T> execute() throws IOException {
        C0721j jVar;
        synchronized (this) {
            if (!this.f11015f) {
                this.f11015f = true;
                if (this.f11014e == null) {
                    jVar = this.f11013d;
                    if (jVar == null) {
                        try {
                            jVar = a();
                            this.f11013d = jVar;
                        } catch (IOException | Error | RuntimeException e2) {
                            y.a(e2);
                            this.f11014e = e2;
                            throw e2;
                        }
                    }
                } else if (this.f11014e instanceof IOException) {
                    throw ((IOException) this.f11014e);
                } else if (this.f11014e instanceof RuntimeException) {
                    throw ((RuntimeException) this.f11014e);
                } else {
                    throw ((Error) this.f11014e);
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.f11012c) {
            jVar.cancel();
        }
        return a(jVar.execute());
    }

    public boolean isCanceled() {
        boolean z = true;
        if (this.f11012c) {
            return true;
        }
        synchronized (this) {
            if (this.f11013d == null || !this.f11013d.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    public o<T> clone() {
        return new o<>(this.f11010a, this.f11011b);
    }

    private C0721j a() throws IOException {
        C0721j a2 = this.f11010a.a(this.f11011b);
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    /* access modifiers changed from: 0000 */
    public u<T> a(M m) throws IOException {
        O a2 = m.a();
        i.M.a h2 = m.h();
        h2.a((O) new b(a2.c(), a2.b()));
        M a3 = h2.a();
        int c2 = a3.c();
        if (c2 < 200 || c2 >= 300) {
            try {
                return u.a(y.a(a2), a3);
            } finally {
                a2.close();
            }
        } else if (c2 == 204 || c2 == 205) {
            a2.close();
            return u.a(null, a3);
        } else {
            a aVar = new a(a2);
            try {
                return u.a(this.f11010a.a((O) aVar), a3);
            } catch (RuntimeException e2) {
                aVar.e();
                throw e2;
            }
        }
    }
}
