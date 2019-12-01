package io.intercom.com.bumptech.glide.load.engine;

import android.os.Looper;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.load.g;

/* compiled from: EngineResource */
class y<Z> implements E<Z> {

    /* renamed from: a reason: collision with root package name */
    private final boolean f9981a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f9982b;

    /* renamed from: c reason: collision with root package name */
    private a f9983c;

    /* renamed from: d reason: collision with root package name */
    private g f9984d;

    /* renamed from: e reason: collision with root package name */
    private int f9985e;

    /* renamed from: f reason: collision with root package name */
    private boolean f9986f;

    /* renamed from: g reason: collision with root package name */
    private final E<Z> f9987g;

    /* compiled from: EngineResource */
    interface a {
        void a(g gVar, y<?> yVar);
    }

    y(E<Z> e2, boolean z, boolean z2) {
        h.a(e2);
        this.f9987g = e2;
        this.f9981a = z;
        this.f9982b = z2;
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar, a aVar) {
        this.f9984d = gVar;
        this.f9983c = aVar;
    }

    public int b() {
        return this.f9987g.b();
    }

    public Class<Z> c() {
        return this.f9987g.c();
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        if (this.f9986f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f9985e++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    /* access modifiers changed from: 0000 */
    public E<Z> e() {
        return this.f9987g;
    }

    /* access modifiers changed from: 0000 */
    public boolean f() {
        return this.f9981a;
    }

    /* access modifiers changed from: 0000 */
    public void g() {
        if (this.f9985e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i2 = this.f9985e - 1;
            this.f9985e = i2;
            if (i2 == 0) {
                this.f9983c.a(this.f9984d, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public Z get() {
        return this.f9987g.get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineResource{isCacheable=");
        sb.append(this.f9981a);
        sb.append(", listener=");
        sb.append(this.f9983c);
        sb.append(", key=");
        sb.append(this.f9984d);
        sb.append(", acquired=");
        sb.append(this.f9985e);
        sb.append(", isRecycled=");
        sb.append(this.f9986f);
        sb.append(", resource=");
        sb.append(this.f9987g);
        sb.append('}');
        return sb.toString();
    }

    public void a() {
        if (this.f9985e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f9986f) {
            this.f9986f = true;
            if (this.f9982b) {
                this.f9987g.a();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }
}
