package com.bumptech.glide.f;

/* compiled from: ErrorRequestCoordinator */
public final class b implements d, c {

    /* renamed from: a reason: collision with root package name */
    private final d f3459a;

    /* renamed from: b reason: collision with root package name */
    private c f3460b;

    /* renamed from: c reason: collision with root package name */
    private c f3461c;

    public b(d dVar) {
        this.f3459a = dVar;
    }

    private boolean g() {
        d dVar = this.f3459a;
        return dVar == null || dVar.f(this);
    }

    private boolean h() {
        d dVar = this.f3459a;
        return dVar == null || dVar.c(this);
    }

    private boolean i() {
        d dVar = this.f3459a;
        return dVar == null || dVar.d(this);
    }

    private boolean j() {
        d dVar = this.f3459a;
        return dVar != null && dVar.d();
    }

    public void a(c cVar, c cVar2) {
        this.f3460b = cVar;
        this.f3461c = cVar2;
    }

    public boolean b() {
        return (this.f3460b.c() ? this.f3461c : this.f3460b).b();
    }

    public boolean c() {
        return this.f3460b.c() && this.f3461c.c();
    }

    public void clear() {
        this.f3460b.clear();
        if (this.f3461c.isRunning()) {
            this.f3461c.clear();
        }
    }

    public boolean d(c cVar) {
        return i() && g(cVar);
    }

    public void e() {
        if (!this.f3460b.isRunning()) {
            this.f3460b.e();
        }
    }

    public boolean f() {
        return (this.f3460b.c() ? this.f3461c : this.f3460b).f();
    }

    public boolean isComplete() {
        return (this.f3460b.c() ? this.f3461c : this.f3460b).isComplete();
    }

    public boolean isRunning() {
        return (this.f3460b.c() ? this.f3461c : this.f3460b).isRunning();
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f3460b) || (this.f3460b.c() && cVar.equals(this.f3461c));
    }

    public void b(c cVar) {
        if (!cVar.equals(this.f3461c)) {
            if (!this.f3461c.isRunning()) {
                this.f3461c.e();
            }
            return;
        }
        d dVar = this.f3459a;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    public boolean c(c cVar) {
        return h() && g(cVar);
    }

    public boolean d() {
        return j() || b();
    }

    public boolean f(c cVar) {
        return g() && g(cVar);
    }

    public void a() {
        this.f3460b.a();
        this.f3461c.a();
    }

    public void e(c cVar) {
        d dVar = this.f3459a;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof b)) {
            return false;
        }
        b bVar = (b) cVar;
        if (!this.f3460b.a(bVar.f3460b) || !this.f3461c.a(bVar.f3461c)) {
            return false;
        }
        return true;
    }
}
