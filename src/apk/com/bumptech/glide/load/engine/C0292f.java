package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.f;
import java.io.File;
import java.util.List;

/* renamed from: com.bumptech.glide.load.engine.f reason: case insensitive filesystem */
/* compiled from: DataCacheGenerator */
class C0292f implements C0295i, a<Object> {

    /* renamed from: a reason: collision with root package name */
    private final List<f> f4007a;

    /* renamed from: b reason: collision with root package name */
    private final C0296j<?> f4008b;

    /* renamed from: c reason: collision with root package name */
    private final C0295i.a f4009c;

    /* renamed from: d reason: collision with root package name */
    private int f4010d;

    /* renamed from: e reason: collision with root package name */
    private f f4011e;

    /* renamed from: f reason: collision with root package name */
    private List<u<File, ?>> f4012f;

    /* renamed from: g reason: collision with root package name */
    private int f4013g;

    /* renamed from: h reason: collision with root package name */
    private volatile u.a<?> f4014h;

    /* renamed from: i reason: collision with root package name */
    private File f4015i;

    C0292f(C0296j<?> jVar, C0295i.a aVar) {
        this(jVar.c(), jVar, aVar);
    }

    private boolean b() {
        return this.f4013g < this.f4012f.size();
    }

    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f4012f == null || !b()) {
                this.f4010d++;
                if (this.f4010d >= this.f4007a.size()) {
                    return false;
                }
                f fVar = (f) this.f4007a.get(this.f4010d);
                this.f4015i = this.f4008b.d().a(new C0293g(fVar, this.f4008b.l()));
                File file = this.f4015i;
                if (file != null) {
                    this.f4011e = fVar;
                    this.f4012f = this.f4008b.a(file);
                    this.f4013g = 0;
                }
            } else {
                this.f4014h = null;
                while (!z && b()) {
                    List<u<File, ?>> list = this.f4012f;
                    int i2 = this.f4013g;
                    this.f4013g = i2 + 1;
                    this.f4014h = ((u) list.get(i2)).a(this.f4015i, this.f4008b.n(), this.f4008b.f(), this.f4008b.i());
                    if (this.f4014h != null && this.f4008b.c(this.f4014h.f3676c.a())) {
                        this.f4014h.f3676c.a(this.f4008b.j(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void cancel() {
        u.a<?> aVar = this.f4014h;
        if (aVar != null) {
            aVar.f3676c.cancel();
        }
    }

    C0292f(List<f> list, C0296j<?> jVar, C0295i.a aVar) {
        this.f4010d = -1;
        this.f4007a = list;
        this.f4008b = jVar;
        this.f4009c = aVar;
    }

    public void a(Object obj) {
        this.f4009c.a(this.f4011e, obj, this.f4014h.f3676c, com.bumptech.glide.load.a.DATA_DISK_CACHE, this.f4011e);
    }

    public void a(Exception exc) {
        this.f4009c.a(this.f4011e, exc, this.f4014h.f3676c, com.bumptech.glide.load.a.DATA_DISK_CACHE);
    }
}
