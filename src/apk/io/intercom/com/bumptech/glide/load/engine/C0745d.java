package io.intercom.com.bumptech.glide.load.engine;

import io.intercom.com.bumptech.glide.load.a.b.a;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.g;
import java.io.File;
import java.util.List;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.d reason: case insensitive filesystem */
/* compiled from: DataCacheGenerator */
class C0745d implements C0748g, a<Object> {

    /* renamed from: a reason: collision with root package name */
    private final List<g> f9864a;

    /* renamed from: b reason: collision with root package name */
    private final C0749h<?> f9865b;

    /* renamed from: c reason: collision with root package name */
    private final C0748g.a f9866c;

    /* renamed from: d reason: collision with root package name */
    private int f9867d;

    /* renamed from: e reason: collision with root package name */
    private g f9868e;

    /* renamed from: f reason: collision with root package name */
    private List<u<File, ?>> f9869f;

    /* renamed from: g reason: collision with root package name */
    private int f9870g;

    /* renamed from: h reason: collision with root package name */
    private volatile u.a<?> f9871h;

    /* renamed from: i reason: collision with root package name */
    private File f9872i;

    C0745d(C0749h<?> hVar, C0748g.a aVar) {
        this(hVar.c(), hVar, aVar);
    }

    private boolean b() {
        return this.f9870g < this.f9869f.size();
    }

    public boolean a() {
        while (true) {
            boolean z = false;
            if (this.f9869f == null || !b()) {
                this.f9867d++;
                if (this.f9867d >= this.f9864a.size()) {
                    return false;
                }
                g gVar = (g) this.f9864a.get(this.f9867d);
                this.f9872i = this.f9865b.d().a(new C0746e(gVar, this.f9865b.k()));
                File file = this.f9872i;
                if (file != null) {
                    this.f9868e = gVar;
                    this.f9869f = this.f9865b.a(file);
                    this.f9870g = 0;
                }
            } else {
                this.f9871h = null;
                while (!z && b()) {
                    List<u<File, ?>> list = this.f9869f;
                    int i2 = this.f9870g;
                    this.f9870g = i2 + 1;
                    this.f9871h = ((u) list.get(i2)).a(this.f9872i, this.f9865b.l(), this.f9865b.f(), this.f9865b.h());
                    if (this.f9871h != null && this.f9865b.c(this.f9871h.f9546c.a())) {
                        this.f9871h.f9546c.a(this.f9865b.i(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void cancel() {
        u.a<?> aVar = this.f9871h;
        if (aVar != null) {
            aVar.f9546c.cancel();
        }
    }

    C0745d(List<g> list, C0749h<?> hVar, C0748g.a aVar) {
        this.f9867d = -1;
        this.f9864a = list;
        this.f9865b = hVar;
        this.f9866c = aVar;
    }

    public void a(Object obj) {
        this.f9866c.a(this.f9868e, obj, this.f9871h.f9546c, io.intercom.com.bumptech.glide.load.a.DATA_DISK_CACHE, this.f9868e);
    }

    public void a(Exception exc) {
        this.f9866c.a(this.f9868e, exc, this.f9871h.f9546c, io.intercom.com.bumptech.glide.load.a.DATA_DISK_CACHE);
    }
}
