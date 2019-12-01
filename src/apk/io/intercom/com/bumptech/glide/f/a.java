package io.intercom.com.bumptech.glide.f;

/* compiled from: ErrorRequestCoordinator */
public final class a implements d, c {

    /* renamed from: a reason: collision with root package name */
    private final d f9298a;

    /* renamed from: b reason: collision with root package name */
    private c f9299b;

    /* renamed from: c reason: collision with root package name */
    private c f9300c;

    public a(d dVar) {
        this.f9298a = dVar;
    }

    private boolean f() {
        d dVar = this.f9298a;
        return dVar == null || dVar.c(this);
    }

    private boolean g() {
        d dVar = this.f9298a;
        return dVar == null || dVar.b(this);
    }

    private boolean h() {
        d dVar = this.f9298a;
        return dVar == null || dVar.d(this);
    }

    private boolean i() {
        d dVar = this.f9298a;
        return dVar != null && dVar.d();
    }

    public void a(c cVar, c cVar2) {
        this.f9299b = cVar;
        this.f9300c = cVar2;
    }

    public boolean b() {
        return (this.f9299b.c() ? this.f9300c : this.f9299b).b();
    }

    public boolean c() {
        return this.f9299b.c() && this.f9300c.c();
    }

    public void clear() {
        this.f9299b.clear();
        if (this.f9299b.c()) {
            this.f9300c.clear();
        }
    }

    public boolean d(c cVar) {
        return h() && g(cVar);
    }

    public void e() {
        if (!this.f9299b.isRunning()) {
            this.f9299b.e();
        }
    }

    public boolean isCancelled() {
        return (this.f9299b.c() ? this.f9300c : this.f9299b).isCancelled();
    }

    public boolean isComplete() {
        return (this.f9299b.c() ? this.f9300c : this.f9299b).isComplete();
    }

    public boolean isRunning() {
        return (this.f9299b.c() ? this.f9300c : this.f9299b).isRunning();
    }

    public void pause() {
        if (!this.f9299b.c()) {
            this.f9299b.pause();
        }
        if (this.f9300c.isRunning()) {
            this.f9300c.pause();
        }
    }

    private boolean g(c cVar) {
        return cVar.equals(this.f9299b) || (this.f9299b.c() && cVar.equals(this.f9300c));
    }

    public boolean b(c cVar) {
        return g() && g(cVar);
    }

    public boolean c(c cVar) {
        return f() && g(cVar);
    }

    public boolean d() {
        return i() || b();
    }

    public void f(c cVar) {
        if (!cVar.equals(this.f9300c)) {
            if (!this.f9300c.isRunning()) {
                this.f9300c.e();
            }
            return;
        }
        d dVar = this.f9298a;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    public void a() {
        this.f9299b.a();
        this.f9300c.a();
    }

    public void e(c cVar) {
        d dVar = this.f9298a;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof a)) {
            return false;
        }
        a aVar = (a) cVar;
        if (!this.f9299b.a(aVar.f9299b) || !this.f9300c.a(aVar.f9300c)) {
            return false;
        }
        return true;
    }
}
