package io.intercom.com.bumptech.glide.load.engine;

import android.util.Log;
import io.intercom.com.bumptech.glide.h.d;
import io.intercom.com.bumptech.glide.load.a.b;
import io.intercom.com.bumptech.glide.load.a.b.a;
import io.intercom.com.bumptech.glide.load.b.u;
import io.intercom.com.bumptech.glide.load.g;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator */
class I implements C0748g, a<Object>, C0748g.a {

    /* renamed from: a reason: collision with root package name */
    private final C0749h<?> f9753a;

    /* renamed from: b reason: collision with root package name */
    private final C0748g.a f9754b;

    /* renamed from: c reason: collision with root package name */
    private int f9755c;

    /* renamed from: d reason: collision with root package name */
    private C0745d f9756d;

    /* renamed from: e reason: collision with root package name */
    private Object f9757e;

    /* renamed from: f reason: collision with root package name */
    private volatile u.a<?> f9758f;

    /* renamed from: g reason: collision with root package name */
    private C0746e f9759g;

    I(C0749h<?> hVar, C0748g.a aVar) {
        this.f9753a = hVar;
        this.f9754b = aVar;
    }

    /* JADX INFO: finally extract failed */
    private void b(Object obj) {
        String str = "SourceGenerator";
        long a2 = d.a();
        try {
            io.intercom.com.bumptech.glide.load.d a3 = this.f9753a.a(obj);
            C0747f fVar = new C0747f(a3, obj, this.f9753a.h());
            this.f9759g = new C0746e(this.f9758f.f9544a, this.f9753a.k());
            this.f9753a.d().a(this.f9759g, fVar);
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(this.f9759g);
                sb.append(", data: ");
                sb.append(obj);
                sb.append(", encoder: ");
                sb.append(a3);
                sb.append(", duration: ");
                sb.append(d.a(a2));
                Log.v(str, sb.toString());
            }
            this.f9758f.f9546c.b();
            this.f9756d = new C0745d(Collections.singletonList(this.f9758f.f9544a), this.f9753a, this);
        } catch (Throwable th) {
            this.f9758f.f9546c.b();
            throw th;
        }
    }

    private boolean c() {
        return this.f9755c < this.f9753a.g().size();
    }

    public boolean a() {
        Object obj = this.f9757e;
        if (obj != null) {
            this.f9757e = null;
            b(obj);
        }
        C0745d dVar = this.f9756d;
        if (dVar != null && dVar.a()) {
            return true;
        }
        this.f9756d = null;
        this.f9758f = null;
        boolean z = false;
        while (!z && c()) {
            List g2 = this.f9753a.g();
            int i2 = this.f9755c;
            this.f9755c = i2 + 1;
            this.f9758f = (u.a) g2.get(i2);
            if (this.f9758f != null && (this.f9753a.e().a(this.f9758f.f9546c.c()) || this.f9753a.c(this.f9758f.f9546c.a()))) {
                this.f9758f.f9546c.a(this.f9753a.i(), this);
                z = true;
            }
        }
        return z;
    }

    public void cancel() {
        u.a<?> aVar = this.f9758f;
        if (aVar != null) {
            aVar.f9546c.cancel();
        }
    }

    public void a(Object obj) {
        q e2 = this.f9753a.e();
        if (obj == null || !e2.a(this.f9758f.f9546c.c())) {
            this.f9754b.a(this.f9758f.f9544a, obj, this.f9758f.f9546c, this.f9758f.f9546c.c(), this.f9759g);
            return;
        }
        this.f9757e = obj;
        this.f9754b.b();
    }

    public void b() {
        throw new UnsupportedOperationException();
    }

    public void a(Exception exc) {
        this.f9754b.a(this.f9759g, exc, this.f9758f.f9546c, this.f9758f.f9546c.c());
    }

    public void a(g gVar, Object obj, b<?> bVar, io.intercom.com.bumptech.glide.load.a aVar, g gVar2) {
        this.f9754b.a(gVar, obj, bVar, this.f9758f.f9546c.c(), gVar);
    }

    public void a(g gVar, Exception exc, b<?> bVar, io.intercom.com.bumptech.glide.load.a aVar) {
        this.f9754b.a(gVar, exc, bVar, this.f9758f.f9546c.c());
    }
}
