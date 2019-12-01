package e.b.h;

import e.b.d.b.b;
import e.b.d.i.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k.a.d;

/* compiled from: UnicastProcessor */
public final class c<T> extends a<T> {

    /* renamed from: b reason: collision with root package name */
    final e.b.d.f.c<T> f8325b;

    /* renamed from: c reason: collision with root package name */
    final AtomicReference<Runnable> f8326c;

    /* renamed from: d reason: collision with root package name */
    final boolean f8327d;

    /* renamed from: e reason: collision with root package name */
    volatile boolean f8328e;

    /* renamed from: f reason: collision with root package name */
    Throwable f8329f;

    /* renamed from: g reason: collision with root package name */
    final AtomicReference<k.a.c<? super T>> f8330g;

    /* renamed from: h reason: collision with root package name */
    volatile boolean f8331h;

    /* renamed from: i reason: collision with root package name */
    final AtomicBoolean f8332i;

    /* renamed from: j reason: collision with root package name */
    final e.b.d.i.a<T> f8333j;

    /* renamed from: k reason: collision with root package name */
    final AtomicLong f8334k;

    /* renamed from: l reason: collision with root package name */
    boolean f8335l;

    /* compiled from: UnicastProcessor */
    final class a extends e.b.d.i.a<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        a() {
        }

        public void a(long j2) {
            if (f.c(j2)) {
                e.b.d.j.c.a(c.this.f8334k, j2);
                c.this.i();
            }
        }

        public int b(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            c.this.f8335l = true;
            return 2;
        }

        public void cancel() {
            if (!c.this.f8331h) {
                c cVar = c.this;
                cVar.f8331h = true;
                cVar.h();
                c cVar2 = c.this;
                if (!cVar2.f8335l && cVar2.f8333j.getAndIncrement() == 0) {
                    c.this.f8325b.clear();
                    c.this.f8330g.lazySet(null);
                }
            }
        }

        public void clear() {
            c.this.f8325b.clear();
        }

        public boolean isEmpty() {
            return c.this.f8325b.isEmpty();
        }

        public T poll() {
            return c.this.f8325b.poll();
        }
    }

    c(int i2) {
        this(i2, null, true);
    }

    public static <T> c<T> a(int i2) {
        return new c<>(i2);
    }

    /* access modifiers changed from: protected */
    public void b(k.a.c<? super T> cVar) {
        if (this.f8332i.get() || !this.f8332i.compareAndSet(false, true)) {
            e.b.d.i.c.a(new IllegalStateException("This processor allows only a single Subscriber"), cVar);
            return;
        }
        cVar.a((d) this.f8333j);
        this.f8330g.set(cVar);
        if (this.f8331h) {
            this.f8330g.lazySet(null);
        } else {
            i();
        }
    }

    /* access modifiers changed from: 0000 */
    public void c(k.a.c<? super T> cVar) {
        e.b.d.f.c<T> cVar2 = this.f8325b;
        int i2 = 1;
        boolean z = !this.f8327d;
        while (!this.f8331h) {
            boolean z2 = this.f8328e;
            if (!z || !z2 || this.f8329f == null) {
                cVar.a(null);
                if (z2) {
                    this.f8330g.lazySet(null);
                    Throwable th = this.f8329f;
                    if (th != null) {
                        cVar.a(th);
                    } else {
                        cVar.c();
                    }
                    return;
                }
                i2 = this.f8333j.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                cVar2.clear();
                this.f8330g.lazySet(null);
                cVar.a(this.f8329f);
                return;
            }
        }
        cVar2.clear();
        this.f8330g.lazySet(null);
    }

    /* access modifiers changed from: 0000 */
    public void d(k.a.c<? super T> cVar) {
        int i2;
        long j2;
        e.b.d.f.c<T> cVar2 = this.f8325b;
        boolean z = !this.f8327d;
        int i3 = 1;
        while (true) {
            long j3 = this.f8334k.get();
            long j4 = 0;
            while (true) {
                i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
                if (i2 == 0) {
                    j2 = j4;
                    break;
                }
                boolean z2 = this.f8328e;
                Object poll = cVar2.poll();
                boolean z3 = poll == null;
                Object obj = poll;
                j2 = j4;
                if (!a(z, z2, z3, cVar, cVar2)) {
                    if (z3) {
                        break;
                    }
                    cVar.a(obj);
                    j4 = 1 + j2;
                } else {
                    return;
                }
            }
            k.a.c<? super T> cVar3 = cVar;
            if (i2 == 0) {
                if (a(z, this.f8328e, cVar2.isEmpty(), cVar, cVar2)) {
                    return;
                }
            }
            if (!(j2 == 0 || j3 == Long.MAX_VALUE)) {
                this.f8334k.addAndGet(-j2);
            }
            i3 = this.f8333j.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void h() {
        Runnable runnable = (Runnable) this.f8326c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: 0000 */
    public void i() {
        if (this.f8333j.getAndIncrement() == 0) {
            int i2 = 1;
            k.a.c cVar = (k.a.c) this.f8330g.get();
            while (cVar == null) {
                i2 = this.f8333j.addAndGet(-i2);
                if (i2 != 0) {
                    cVar = (k.a.c) this.f8330g.get();
                } else {
                    return;
                }
            }
            if (this.f8335l) {
                c(cVar);
            } else {
                d(cVar);
            }
        }
    }

    c(int i2, Runnable runnable, boolean z) {
        b.a(i2, "capacityHint");
        this.f8325b = new e.b.d.f.c<>(i2);
        this.f8326c = new AtomicReference<>(runnable);
        this.f8327d = z;
        this.f8330g = new AtomicReference<>();
        this.f8332i = new AtomicBoolean();
        this.f8333j = new a();
        this.f8334k = new AtomicLong();
    }

    /* access modifiers changed from: 0000 */
    public boolean a(boolean z, boolean z2, boolean z3, k.a.c<? super T> cVar, e.b.d.f.c<T> cVar2) {
        if (this.f8331h) {
            cVar2.clear();
            this.f8330g.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.f8329f != null) {
                cVar2.clear();
                this.f8330g.lazySet(null);
                cVar.a(this.f8329f);
                return true;
            } else if (z3) {
                Throwable th = this.f8329f;
                this.f8330g.lazySet(null);
                if (th != null) {
                    cVar.a(th);
                } else {
                    cVar.c();
                }
                return true;
            }
        }
        return false;
    }

    public void a(d dVar) {
        if (this.f8328e || this.f8331h) {
            dVar.cancel();
        } else {
            dVar.a(Long.MAX_VALUE);
        }
    }

    public void a(T t) {
        b.a(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f8328e && !this.f8331h) {
            this.f8325b.offer(t);
            i();
        }
    }

    public void c() {
        if (!this.f8328e && !this.f8331h) {
            this.f8328e = true;
            h();
            i();
        }
    }

    public void a(Throwable th) {
        b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f8328e || this.f8331h) {
            e.b.g.a.b(th);
            return;
        }
        this.f8329f = th;
        this.f8328e = true;
        h();
        i();
    }
}
