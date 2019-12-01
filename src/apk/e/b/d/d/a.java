package e.b.d.d;

import e.b.b.b;
import e.b.d.c.e;
import e.b.m;

/* compiled from: BasicFuseableObserver */
public abstract class a<T, R> implements m<T>, e<R> {

    /* renamed from: a reason: collision with root package name */
    protected final m<? super R> f7972a;

    /* renamed from: b reason: collision with root package name */
    protected b f7973b;

    /* renamed from: c reason: collision with root package name */
    protected e<T> f7974c;

    /* renamed from: d reason: collision with root package name */
    protected boolean f7975d;

    /* renamed from: e reason: collision with root package name */
    protected int f7976e;

    public a(m<? super R> mVar) {
        this.f7972a = mVar;
    }

    public final void a(b bVar) {
        if (e.b.d.a.b.a(this.f7973b, bVar)) {
            this.f7973b = bVar;
            if (bVar instanceof e) {
                this.f7974c = (e) bVar;
            }
            if (e()) {
                this.f7972a.a((b) this);
                d();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f7973b.b();
        a(th);
    }

    public void c() {
        if (!this.f7975d) {
            this.f7975d = true;
            this.f7972a.c();
        }
    }

    public void clear() {
        this.f7974c.clear();
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    public boolean isEmpty() {
        return this.f7974c.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void b() {
        this.f7973b.b();
    }

    public void a(Throwable th) {
        if (this.f7975d) {
            e.b.g.a.b(th);
            return;
        }
        this.f7975d = true;
        this.f7972a.a(th);
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        e<T> eVar = this.f7974c;
        if (eVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int b2 = eVar.b(i2);
        if (b2 != 0) {
            this.f7976e = b2;
        }
        return b2;
    }

    public boolean a() {
        return this.f7973b.a();
    }
}
