package e.b.d.e.c;

import e.b.c.e;
import e.b.d.a.f;
import e.b.k;
import e.b.m;
import e.b.n;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRefCount */
public final class q<T> extends k<T> {

    /* renamed from: a reason: collision with root package name */
    final e.b.e.a<T> f8106a;

    /* renamed from: b reason: collision with root package name */
    final int f8107b;

    /* renamed from: c reason: collision with root package name */
    final long f8108c;

    /* renamed from: d reason: collision with root package name */
    final TimeUnit f8109d;

    /* renamed from: e reason: collision with root package name */
    final n f8110e;

    /* renamed from: f reason: collision with root package name */
    a f8111f;

    /* compiled from: ObservableRefCount */
    static final class a extends AtomicReference<e.b.b.b> implements Runnable, e<e.b.b.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final q<?> parent;
        long subscriberCount;
        e.b.b.b timer;

        a(q<?> qVar) {
            this.parent = qVar;
        }

        /* renamed from: a */
        public void accept(e.b.b.b bVar) throws Exception {
            e.b.d.a.b.a((AtomicReference<e.b.b.b>) this, bVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((e.b.d.a.e) this.parent.f8106a).b(bVar);
                }
            }
        }

        public void run() {
            this.parent.c(this);
        }
    }

    /* compiled from: ObservableRefCount */
    static final class b<T> extends AtomicBoolean implements m<T>, e.b.b.b {
        private static final long serialVersionUID = -7419642935409022375L;
        final a connection;
        final m<? super T> downstream;
        final q<T> parent;
        e.b.b.b upstream;

        b(m<? super T> mVar, q<T> qVar, a aVar) {
            this.downstream = mVar;
            this.parent = qVar;
            this.connection = aVar;
        }

        public void a(T t) {
            this.downstream.a(t);
        }

        public void b() {
            this.upstream.b();
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
            }
        }

        public void c() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.downstream.c();
            }
        }

        public void a(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.downstream.a(th);
                return;
            }
            e.b.g.a.b(th);
        }

        public boolean a() {
            return this.upstream.a();
        }

        public void a(e.b.b.b bVar) {
            if (e.b.d.a.b.a(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.a((e.b.b.b) this);
            }
        }
    }

    public q(e.b.e.a<T> aVar) {
        this(aVar, 1, 0, TimeUnit.NANOSECONDS, e.b.i.b.d());
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        return;
     */
    public void a(a aVar) {
        synchronized (this) {
            if (this.f8111f != null) {
                if (this.f8111f == aVar) {
                    long j2 = aVar.subscriberCount - 1;
                    aVar.subscriberCount = j2;
                    if (j2 == 0) {
                        if (aVar.connected) {
                            if (this.f8108c == 0) {
                                c(aVar);
                                return;
                            }
                            f fVar = new f();
                            aVar.timer = fVar;
                            fVar.a(this.f8110e.a(aVar, this.f8108c, this.f8109d));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(m<? super T> mVar) {
        a aVar;
        boolean z;
        synchronized (this) {
            aVar = this.f8111f;
            if (aVar == null) {
                aVar = new a(this);
                this.f8111f = aVar;
            }
            long j2 = aVar.subscriberCount;
            if (j2 == 0 && aVar.timer != null) {
                aVar.timer.b();
            }
            long j3 = j2 + 1;
            aVar.subscriberCount = j3;
            z = true;
            if (aVar.connected || j3 != ((long) this.f8107b)) {
                z = false;
            } else {
                aVar.connected = true;
            }
        }
        this.f8106a.a((m<? super T>) new b<Object>(mVar, this, aVar));
        if (z) {
            this.f8106a.b(aVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void c(a aVar) {
        synchronized (this) {
            if (aVar.subscriberCount == 0 && aVar == this.f8111f) {
                this.f8111f = null;
                e.b.b.b bVar = (e.b.b.b) aVar.get();
                e.b.d.a.b.a((AtomicReference<e.b.b.b>) aVar);
                if (this.f8106a instanceof e.b.b.b) {
                    ((e.b.b.b) this.f8106a).b();
                } else if (this.f8106a instanceof e.b.d.a.e) {
                    if (bVar == null) {
                        aVar.disconnectedEarly = true;
                    } else {
                        ((e.b.d.a.e) this.f8106a).b(bVar);
                    }
                }
            }
        }
    }

    public q(e.b.e.a<T> aVar, int i2, long j2, TimeUnit timeUnit, n nVar) {
        this.f8106a = aVar;
        this.f8107b = i2;
        this.f8108c = j2;
        this.f8109d = timeUnit;
        this.f8110e = nVar;
    }

    /* access modifiers changed from: 0000 */
    public void b(a aVar) {
        synchronized (this) {
            if (this.f8111f != null && this.f8111f == aVar) {
                this.f8111f = null;
                if (aVar.timer != null) {
                    aVar.timer.b();
                }
            }
            long j2 = aVar.subscriberCount - 1;
            aVar.subscriberCount = j2;
            if (j2 == 0) {
                if (this.f8106a instanceof e.b.b.b) {
                    ((e.b.b.b) this.f8106a).b();
                } else if (this.f8106a instanceof e.b.d.a.e) {
                    ((e.b.d.a.e) this.f8106a).b((e.b.b.b) aVar.get());
                }
            }
        }
    }
}
