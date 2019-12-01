package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.f;
import java.io.File;
import java.util.List;

/* compiled from: ResourceCacheGenerator */
class H implements C0295i, a<Object> {

    /* renamed from: a reason: collision with root package name */
    private final C0295i.a f3870a;

    /* renamed from: b reason: collision with root package name */
    private final C0296j<?> f3871b;

    /* renamed from: c reason: collision with root package name */
    private int f3872c;

    /* renamed from: d reason: collision with root package name */
    private int f3873d = -1;

    /* renamed from: e reason: collision with root package name */
    private f f3874e;

    /* renamed from: f reason: collision with root package name */
    private List<u<File, ?>> f3875f;

    /* renamed from: g reason: collision with root package name */
    private int f3876g;

    /* renamed from: h reason: collision with root package name */
    private volatile u.a<?> f3877h;

    /* renamed from: i reason: collision with root package name */
    private File f3878i;

    /* renamed from: j reason: collision with root package name */
    private I f3879j;

    H(C0296j<?> jVar, C0295i.a aVar) {
        this.f3871b = jVar;
        this.f3870a = aVar;
    }

    private boolean b() {
        return this.f3876g < this.f3875f.size();
    }

    public boolean a() {
        List c2 = this.f3871b.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List k2 = this.f3871b.k();
        if (!k2.isEmpty()) {
            while (true) {
                if (this.f3875f == null || !b()) {
                    this.f3873d++;
                    if (this.f3873d >= k2.size()) {
                        this.f3872c++;
                        if (this.f3872c >= c2.size()) {
                            return false;
                        }
                        this.f3873d = 0;
                    }
                    f fVar = (f) c2.get(this.f3872c);
                    Class cls = (Class) k2.get(this.f3873d);
                    f fVar2 = fVar;
                    I i2 = new I(this.f3871b.b(), fVar2, this.f3871b.l(), this.f3871b.n(), this.f3871b.f(), this.f3871b.b(cls), cls, this.f3871b.i());
                    this.f3879j = i2;
                    this.f3878i = this.f3871b.d().a(this.f3879j);
                    File file = this.f3878i;
                    if (file != null) {
                        this.f3874e = fVar;
                        this.f3875f = this.f3871b.a(file);
                        this.f3876g = 0;
                    }
                } else {
                    this.f3877h = null;
                    while (!z && b()) {
                        List<u<File, ?>> list = this.f3875f;
                        int i3 = this.f3876g;
                        this.f3876g = i3 + 1;
                        this.f3877h = ((u) list.get(i3)).a(this.f3878i, this.f3871b.n(), this.f3871b.f(), this.f3871b.i());
                        if (this.f3877h != null && this.f3871b.c(this.f3877h.f3676c.a())) {
                            this.f3877h.f3676c.a(this.f3871b.j(), this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
        } else if (File.class.equals(this.f3871b.m())) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to find any load path from ");
            sb.append(this.f3871b.h());
            sb.append(" to ");
            sb.append(this.f3871b.m());
            throw new IllegalStateException(sb.toString());
        }
    }

    public void cancel() {
        u.a<?> aVar = this.f3877h;
        if (aVar != null) {
            aVar.f3676c.cancel();
        }
    }

    public void a(Object obj) {
        this.f3870a.a(this.f3874e, obj, this.f3877h.f3676c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE, this.f3879j);
    }

    public void a(Exception exc) {
        this.f3870a.a(this.f3879j, exc, this.f3877h.f3676c, com.bumptech.glide.load.a.RESOURCE_DISK_CACHE);
    }
}
