package e.b.k;

import e.b.d.j.h;
import e.b.f;
import k.a.c;
import k.a.d;

/* compiled from: SerializedSubscriber */
public final class a<T> implements f<T>, d {

    /* renamed from: a reason: collision with root package name */
    final c<? super T> f8368a;

    /* renamed from: b reason: collision with root package name */
    final boolean f8369b;

    /* renamed from: c reason: collision with root package name */
    d f8370c;

    /* renamed from: d reason: collision with root package name */
    boolean f8371d;

    /* renamed from: e reason: collision with root package name */
    e.b.d.j.a<Object> f8372e;

    /* renamed from: f reason: collision with root package name */
    volatile boolean f8373f;

    public a(c<? super T> cVar) {
        this(cVar, false);
    }

    public void a(d dVar) {
        if (e.b.d.i.f.a(this.f8370c, dVar)) {
            this.f8370c = dVar;
            this.f8368a.a((d) this);
        }
    }

    public void c() {
        if (!this.f8373f) {
            synchronized (this) {
                if (!this.f8373f) {
                    if (this.f8371d) {
                        e.b.d.j.a<Object> aVar = this.f8372e;
                        if (aVar == null) {
                            aVar = new e.b.d.j.a<>(4);
                            this.f8372e = aVar;
                        }
                        aVar.a(h.a());
                        return;
                    }
                    this.f8373f = true;
                    this.f8371d = true;
                    this.f8368a.c();
                }
            }
        }
    }

    public void cancel() {
        this.f8370c.cancel();
    }

    public a(c<? super T> cVar, boolean z) {
        this.f8368a = cVar;
        this.f8369b = z;
    }

    public void a(T t) {
        if (!this.f8373f) {
            if (t == null) {
                this.f8370c.cancel();
                a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f8373f) {
                    if (this.f8371d) {
                        e.b.d.j.a<Object> aVar = this.f8372e;
                        if (aVar == null) {
                            aVar = new e.b.d.j.a<>(4);
                            this.f8372e = aVar;
                        }
                        h.d(t);
                        aVar.a(t);
                        return;
                    }
                    this.f8371d = true;
                    this.f8368a.a(t);
                    a();
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
        r2.f8368a.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    public void a(Throwable th) {
        if (this.f8373f) {
            e.b.g.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f8373f) {
                if (this.f8371d) {
                    this.f8373f = true;
                    e.b.d.j.a<Object> aVar = this.f8372e;
                    if (aVar == null) {
                        aVar = new e.b.d.j.a<>(4);
                        this.f8372e = aVar;
                    }
                    Object a2 = h.a(th);
                    if (this.f8369b) {
                        aVar.a(a2);
                    } else {
                        aVar.b(a2);
                    }
                } else {
                    this.f8373f = true;
                    this.f8371d = true;
                    z = false;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        e.b.d.j.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.f8372e;
                if (aVar == null) {
                    this.f8371d = false;
                    return;
                }
                this.f8372e = null;
            }
        } while (!aVar.a(this.f8368a));
    }

    public void a(long j2) {
        this.f8370c.a(j2);
    }
}
