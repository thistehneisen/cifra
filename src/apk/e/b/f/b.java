package e.b.f;

import e.b.d.j.a;
import e.b.d.j.h;
import e.b.m;

/* compiled from: SerializedObserver */
public final class b<T> implements m<T>, e.b.b.b {

    /* renamed from: a reason: collision with root package name */
    final m<? super T> f8303a;

    /* renamed from: b reason: collision with root package name */
    final boolean f8304b;

    /* renamed from: c reason: collision with root package name */
    e.b.b.b f8305c;

    /* renamed from: d reason: collision with root package name */
    boolean f8306d;

    /* renamed from: e reason: collision with root package name */
    a<Object> f8307e;

    /* renamed from: f reason: collision with root package name */
    volatile boolean f8308f;

    public b(m<? super T> mVar) {
        this(mVar, false);
    }

    public void a(e.b.b.b bVar) {
        if (e.b.d.a.b.a(this.f8305c, bVar)) {
            this.f8305c = bVar;
            this.f8303a.a((e.b.b.b) this);
        }
    }

    public void b() {
        this.f8305c.b();
    }

    public void c() {
        if (!this.f8308f) {
            synchronized (this) {
                if (!this.f8308f) {
                    if (this.f8306d) {
                        a<Object> aVar = this.f8307e;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f8307e = aVar;
                        }
                        aVar.a(h.a());
                        return;
                    }
                    this.f8308f = true;
                    this.f8306d = true;
                    this.f8303a.c();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f8307e;
                if (aVar == null) {
                    this.f8306d = false;
                    return;
                }
                this.f8307e = null;
            }
        } while (!aVar.a(this.f8303a));
    }

    public b(m<? super T> mVar, boolean z) {
        this.f8303a = mVar;
        this.f8304b = z;
    }

    public boolean a() {
        return this.f8305c.a();
    }

    public void a(T t) {
        if (!this.f8308f) {
            if (t == null) {
                this.f8305c.b();
                a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f8308f) {
                    if (this.f8306d) {
                        a<Object> aVar = this.f8307e;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f8307e = aVar;
                        }
                        h.d(t);
                        aVar.a(t);
                        return;
                    }
                    this.f8306d = true;
                    this.f8303a.a(t);
                    d();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        e.b.g.a.b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f8303a.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    public void a(Throwable th) {
        if (this.f8308f) {
            e.b.g.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f8308f) {
                if (this.f8306d) {
                    this.f8308f = true;
                    a<Object> aVar = this.f8307e;
                    if (aVar == null) {
                        aVar = new a<>(4);
                        this.f8307e = aVar;
                    }
                    Object a2 = h.a(th);
                    if (this.f8304b) {
                        aVar.a(a2);
                    } else {
                        aVar.b(a2);
                    }
                } else {
                    this.f8308f = true;
                    this.f8306d = true;
                    z = false;
                }
            }
        }
    }
}
