package com.bumptech.glide.f;

/* compiled from: ThumbnailRequestCoordinator */
public class j implements d, c {

    /* renamed from: a reason: collision with root package name */
    private final d f3483a;

    /* renamed from: b reason: collision with root package name */
    private c f3484b;

    /* renamed from: c reason: collision with root package name */
    private c f3485c;

    /* renamed from: d reason: collision with root package name */
    private boolean f3486d;

    j() {
        this(null);
    }

    private boolean g() {
        d dVar = this.f3483a;
        return dVar == null || dVar.f(this);
    }

    private boolean h() {
        d dVar = this.f3483a;
        return dVar == null || dVar.c(this);
    }

    private boolean i() {
        d dVar = this.f3483a;
        return dVar == null || dVar.d(this);
    }

    private boolean j() {
        d dVar = this.f3483a;
        return dVar != null && dVar.d();
    }

    public void a(c cVar, c cVar2) {
        this.f3484b = cVar;
        this.f3485c = cVar2;
    }

    public void b(c cVar) {
        if (cVar.equals(this.f3484b)) {
            d dVar = this.f3483a;
            if (dVar != null) {
                dVar.b(this);
            }
        }
    }

    public boolean c(c cVar) {
        return h() && cVar.equals(this.f3484b) && !d();
    }

    public void clear() {
        this.f3486d = false;
        this.f3485c.clear();
        this.f3484b.clear();
    }

    public boolean d(c cVar) {
        return i() && (cVar.equals(this.f3484b) || !this.f3484b.b());
    }

    public void e(c cVar) {
        if (!cVar.equals(this.f3485c)) {
            d dVar = this.f3483a;
            if (dVar != null) {
                dVar.e(this);
            }
            if (!this.f3485c.isComplete()) {
                this.f3485c.clear();
            }
        }
    }

    public boolean f(c cVar) {
        return g() && cVar.equals(this.f3484b);
    }

    public boolean isComplete() {
        return this.f3484b.isComplete() || this.f3485c.isComplete();
    }

    public boolean isRunning() {
        return this.f3484b.isRunning();
    }

    public j(d dVar) {
        this.f3483a = dVar;
    }

    public boolean c() {
        return this.f3484b.c();
    }

    public boolean d() {
        return j() || b();
    }

    public boolean f() {
        return this.f3484b.f();
    }

    public void a() {
        this.f3484b.a();
        this.f3485c.a();
    }

    public boolean b() {
        return this.f3484b.b() || this.f3485c.b();
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof j)) {
            return false;
        }
        j jVar = (j) cVar;
        c cVar2 = this.f3484b;
        if (cVar2 == null) {
            if (jVar.f3484b != null) {
                return false;
            }
        } else if (!cVar2.a(jVar.f3484b)) {
            return false;
        }
        c cVar3 = this.f3485c;
        if (cVar3 == null) {
            if (jVar.f3485c != null) {
                return false;
            }
        } else if (!cVar3.a(jVar.f3485c)) {
            return false;
        }
        return true;
    }

    public void e() {
        this.f3486d = true;
        if (!this.f3484b.isComplete() && !this.f3485c.isRunning()) {
            this.f3485c.e();
        }
        if (this.f3486d && !this.f3484b.isRunning()) {
            this.f3484b.e();
        }
    }
}
