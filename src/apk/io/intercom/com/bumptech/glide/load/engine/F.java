package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.a.b.a;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.g;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator */
class F implements C0748g, a<Object> {

    /* renamed from: a reason: collision with root package name */
    private final C0748g.a f9729a;

    /* renamed from: b reason: collision with root package name */
    private final C0749h<?> f9730b;

    /* renamed from: c reason: collision with root package name */
    private int f9731c = 0;

    /* renamed from: d reason: collision with root package name */
    private int f9732d = -1;

    /* renamed from: e reason: collision with root package name */
    private g f9733e;

    /* renamed from: f reason: collision with root package name */
    private List<u<File, ?>> f9734f;

    /* renamed from: g reason: collision with root package name */
    private int f9735g;

    /* renamed from: h reason: collision with root package name */
    private volatile u.a<?> f9736h;

    /* renamed from: i reason: collision with root package name */
    private File f9737i;

    /* renamed from: j reason: collision with root package name */
    private G f9738j;

    F(C0749h<?> hVar, C0748g.a aVar) {
        this.f9730b = hVar;
        this.f9729a = aVar;
    }

    private boolean b() {
        return this.f9735g < this.f9734f.size();
    }

    public boolean a() {
        List c2 = this.f9730b.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List j2 = this.f9730b.j();
        while (true) {
            if (this.f9734f == null || !b()) {
                this.f9732d++;
                if (this.f9732d >= j2.size()) {
                    this.f9731c++;
                    if (this.f9731c >= c2.size()) {
                        return false;
                    }
                    this.f9732d = 0;
                }
                g gVar = (g) c2.get(this.f9731c);
                Class cls = (Class) j2.get(this.f9732d);
                g gVar2 = gVar;
                G g2 = new G(this.f9730b.b(), gVar2, this.f9730b.k(), this.f9730b.l(), this.f9730b.f(), this.f9730b.b(cls), cls, this.f9730b.h());
                this.f9738j = g2;
                this.f9737i = this.f9730b.d().a(this.f9738j);
                File file = this.f9737i;
                if (file != null) {
                    this.f9733e = gVar;
                    this.f9734f = this.f9730b.a(file);
                    this.f9735g = 0;
                }
            } else {
                this.f9736h = null;
                while (!z && b()) {
                    List<u<File, ?>> list = this.f9734f;
                    int i2 = this.f9735g;
                    this.f9735g = i2 + 1;
                    this.f9736h = ((u) list.get(i2)).a(this.f9737i, this.f9730b.l(), this.f9730b.f(), this.f9730b.h());
                    if (this.f9736h != null && this.f9730b.c(this.f9736h.f9546c.a())) {
                        this.f9736h.f9546c.a(this.f9730b.i(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void cancel() {
        u.a<?> aVar = this.f9736h;
        if (aVar != null) {
            aVar.f9546c.cancel();
        }
    }

    public void a(Object obj) {
        this.f9729a.a(this.f9733e, obj, this.f9736h.f9546c, io.intercom.com.bumptech.glide.load.a.RESOURCE_DISK_CACHE, this.f9738j);
    }

    public void a(Exception exc) {
        this.f9729a.a(this.f9738j, exc, this.f9736h.f9546c, io.intercom.com.bumptech.glide.load.a.RESOURCE_DISK_CACHE);
    }
}
