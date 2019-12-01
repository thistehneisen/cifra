package io.intercom.com.bumptech.glide.f;

/* compiled from: ThumbnailRequestCoordinator */
public class k implements d, c {

    /* renamed from: a reason: collision with root package name */
    private final d f9369a;

    /* renamed from: b reason: collision with root package name */
    private c f9370b;

    /* renamed from: c reason: collision with root package name */
    private c f9371c;

    /* renamed from: d reason: collision with root package name */
    private boolean f9372d;

    k() {
        this(null);
    }

    private boolean f() {
        d dVar = this.f9369a;
        return dVar == null || dVar.c(this);
    }

    private boolean g() {
        d dVar = this.f9369a;
        return dVar == null || dVar.b(this);
    }

    private boolean h() {
        d dVar = this.f9369a;
        return dVar == null || dVar.d(this);
    }

    private boolean i() {
        d dVar = this.f9369a;
        return dVar != null && dVar.d();
    }

    public void a(c cVar, c cVar2) {
        this.f9370b = cVar;
        this.f9371c = cVar2;
    }

    public boolean b(c cVar) {
        return g() && cVar.equals(this.f9370b) && !d();
    }

    public boolean c(c cVar) {
        return f() && cVar.equals(this.f9370b);
    }

    public void clear() {
        this.f9372d = false;
        this.f9371c.clear();
        this.f9370b.clear();
    }

    public boolean d(c cVar) {
        return h() && (cVar.equals(this.f9370b) || !this.f9370b.b());
    }

    public void e(c cVar) {
        if (!cVar.equals(this.f9371c)) {
            d dVar = this.f9369a;
            if (dVar != null) {
                dVar.e(this);
            }
            if (!this.f9371c.isComplete()) {
                this.f9371c.clear();
            }
        }
    }

    public boolean isCancelled() {
        return this.f9370b.isCancelled();
    }

    public boolean isComplete() {
        return this.f9370b.isComplete() || this.f9371c.isComplete();
    }

    public boolean isRunning() {
        return this.f9370b.isRunning();
    }

    public void pause() {
        this.f9372d = false;
        this.f9370b.pause();
        this.f9371c.pause();
    }

    public k(d dVar) {
        this.f9369a = dVar;
    }

    public boolean b() {
        return this.f9370b.b() || this.f9371c.b();
    }

    public boolean c() {
        return this.f9370b.c();
    }

    public boolean d() {
        return i() || b();
    }

    public void f(c cVar) {
        if (cVar.equals(this.f9370b)) {
            d dVar = this.f9369a;
            if (dVar != null) {
                dVar.f(this);
            }
        }
    }

    public void a() {
        this.f9370b.a();
        this.f9371c.a();
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof k)) {
            return false;
        }
        k kVar = (k) cVar;
        c cVar2 = this.f9370b;
        if (cVar2 == null) {
            if (kVar.f9370b != null) {
                return false;
            }
        } else if (!cVar2.a(kVar.f9370b)) {
            return false;
        }
        c cVar3 = this.f9371c;
        if (cVar3 == null) {
            if (kVar.f9371c != null) {
                return false;
            }
        } else if (!cVar3.a(kVar.f9371c)) {
            return false;
        }
        return true;
    }

    public void e() {
        this.f9372d = true;
        if (!this.f9370b.isComplete() && !this.f9371c.isRunning()) {
            this.f9371c.e();
        }
        if (this.f9372d && !this.f9370b.isRunning()) {
            this.f9370b.e();
        }
    }
}
