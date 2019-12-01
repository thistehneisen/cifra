package e.b.h;

import e.b.d.j.a;
import e.b.d.j.h;
import k.a.c;
import k.a.d;

/* compiled from: SerializedProcessor */
final class b<T> extends a<T> {

    /* renamed from: b reason: collision with root package name */
    final a<T> f8321b;

    /* renamed from: c reason: collision with root package name */
    boolean f8322c;

    /* renamed from: d reason: collision with root package name */
    a<Object> f8323d;

    /* renamed from: e reason: collision with root package name */
    volatile boolean f8324e;

    b(a<T> aVar) {
        this.f8321b = aVar;
    }

    public void a(d dVar) {
        boolean z = true;
        if (!this.f8324e) {
            synchronized (this) {
                if (!this.f8324e) {
                    if (this.f8322c) {
                        a<Object> aVar = this.f8323d;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f8323d = aVar;
                        }
                        aVar.a(h.a(dVar));
                        return;
                    }
                    this.f8322c = true;
                    z = false;
                }
            }
        }
        if (z) {
            dVar.cancel();
        } else {
            this.f8321b.a(dVar);
            h();
        }
    }

    /* access modifiers changed from: protected */
    public void b(c<? super T> cVar) {
        this.f8321b.a(cVar);
    }

    public void c() {
        if (!this.f8324e) {
            synchronized (this) {
                if (!this.f8324e) {
                    this.f8324e = true;
                    if (this.f8322c) {
                        a<Object> aVar = this.f8323d;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f8323d = aVar;
                        }
                        aVar.a(h.a());
                        return;
                    }
                    this.f8322c = true;
                    this.f8321b.c();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void h() {
        a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.f8323d;
                if (aVar == null) {
                    this.f8322c = false;
                    return;
                }
                this.f8323d = null;
            }
            aVar.a((c<? super U>) this.f8321b);
        }
        while (true) {
        }
    }

    public void a(T t) {
        if (!this.f8324e) {
            synchronized (this) {
                if (!this.f8324e) {
                    if (this.f8322c) {
                        a<Object> aVar = this.f8323d;
                        if (aVar == null) {
                            aVar = new a<>(4);
                            this.f8323d = aVar;
                        }
                        h.d(t);
                        aVar.a(t);
                        return;
                    }
                    this.f8322c = true;
                    this.f8321b.a(t);
                    h();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r0 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        e.b.g.a.b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f8321b.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    public void a(Throwable th) {
        boolean z;
        if (this.f8324e) {
            e.b.g.a.b(th);
            return;
        }
        synchronized (this) {
            if (this.f8324e) {
                z = true;
            } else {
                this.f8324e = true;
                if (this.f8322c) {
                    a<Object> aVar = this.f8323d;
                    if (aVar == null) {
                        aVar = new a<>(4);
                        this.f8323d = aVar;
                    }
                    aVar.b(h.a(th));
                    return;
                }
                z = false;
                this.f8322c = true;
            }
        }
    }
}
