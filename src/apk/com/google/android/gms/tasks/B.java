package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class B<TResult> extends g<TResult> {

    /* renamed from: a reason: collision with root package name */
    private final Object f6187a = new Object();

    /* renamed from: b reason: collision with root package name */
    private final z<TResult> f6188b = new z<>();

    /* renamed from: c reason: collision with root package name */
    private boolean f6189c;

    /* renamed from: d reason: collision with root package name */
    private volatile boolean f6190d;

    /* renamed from: e reason: collision with root package name */
    private TResult f6191e;

    /* renamed from: f reason: collision with root package name */
    private Exception f6192f;

    B() {
    }

    private final void g() {
        q.b(this.f6189c, "Task is not yet complete");
    }

    private final void h() {
        q.b(!this.f6189c, "Task is already complete");
    }

    private final void i() {
        if (this.f6190d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void j() {
        synchronized (this.f6187a) {
            if (this.f6189c) {
                this.f6188b.a((g<TResult>) this);
            }
        }
    }

    public final <X extends Throwable> TResult a(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f6187a) {
            g();
            i();
            if (cls.isInstance(this.f6192f)) {
                throw ((Throwable) cls.cast(this.f6192f));
            } else if (this.f6192f == null) {
                tresult = this.f6191e;
            } else {
                throw new RuntimeExecutionException(this.f6192f);
            }
        }
        return tresult;
    }

    public final TResult b() {
        TResult tresult;
        synchronized (this.f6187a) {
            g();
            i();
            if (this.f6192f == null) {
                tresult = this.f6191e;
            } else {
                throw new RuntimeExecutionException(this.f6192f);
            }
        }
        return tresult;
    }

    public final boolean c() {
        return this.f6190d;
    }

    public final boolean d() {
        boolean z;
        synchronized (this.f6187a) {
            z = this.f6189c;
        }
        return z;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f6187a) {
            z = this.f6189c && !this.f6190d && this.f6192f == null;
        }
        return z;
    }

    public final boolean f() {
        synchronized (this.f6187a) {
            if (this.f6189c) {
                return false;
            }
            this.f6189c = true;
            this.f6190d = true;
            this.f6188b.a((g<TResult>) this);
            return true;
        }
    }

    public final <TContinuationResult> g<TContinuationResult> b(Executor executor, C0609a<TResult, g<TContinuationResult>> aVar) {
        B b2 = new B();
        this.f6188b.a((y<TResult>) new m<TResult>(executor, aVar, b2));
        j();
        return b2;
    }

    public final Exception a() {
        Exception exc;
        synchronized (this.f6187a) {
            exc = this.f6192f;
        }
        return exc;
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f6187a) {
            if (this.f6189c) {
                return false;
            }
            this.f6189c = true;
            this.f6191e = tresult;
            this.f6188b.a((g<TResult>) this);
            return true;
        }
    }

    public final g<TResult> a(Executor executor, e<? super TResult> eVar) {
        this.f6188b.a((y<TResult>) new u<TResult>(executor, eVar));
        j();
        return this;
    }

    public final g<TResult> a(Executor executor, d dVar) {
        this.f6188b.a((y<TResult>) new s<TResult>(executor, dVar));
        j();
        return this;
    }

    public final g<TResult> a(C0611c<TResult> cVar) {
        a(i.f6196a, cVar);
        return this;
    }

    public final g<TResult> a(Executor executor, C0611c<TResult> cVar) {
        this.f6188b.a((y<TResult>) new q<TResult>(executor, cVar));
        j();
        return this;
    }

    public final boolean b(Exception exc) {
        q.a(exc, (Object) "Exception must not be null");
        synchronized (this.f6187a) {
            if (this.f6189c) {
                return false;
            }
            this.f6189c = true;
            this.f6192f = exc;
            this.f6188b.a((g<TResult>) this);
            return true;
        }
    }

    public final <TContinuationResult> g<TContinuationResult> a(Executor executor, C0609a<TResult, TContinuationResult> aVar) {
        B b2 = new B();
        this.f6188b.a((y<TResult>) new k<TResult>(executor, aVar, b2));
        j();
        return b2;
    }

    public final g<TResult> a(Executor executor, C0610b bVar) {
        this.f6188b.a((y<TResult>) new o<TResult>(executor, bVar));
        j();
        return this;
    }

    public final <TContinuationResult> g<TContinuationResult> a(Executor executor, f<TResult, TContinuationResult> fVar) {
        B b2 = new B();
        this.f6188b.a((y<TResult>) new w<TResult>(executor, fVar, b2));
        j();
        return b2;
    }

    public final void a(TResult tresult) {
        synchronized (this.f6187a) {
            h();
            this.f6189c = true;
            this.f6191e = tresult;
        }
        this.f6188b.a((g<TResult>) this);
    }

    public final void a(Exception exc) {
        q.a(exc, (Object) "Exception must not be null");
        synchronized (this.f6187a) {
            h();
            this.f6189c = true;
            this.f6192f = exc;
        }
        this.f6188b.a((g<TResult>) this);
    }
}
