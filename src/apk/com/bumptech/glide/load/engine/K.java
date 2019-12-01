package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.h.h;
import com.bumptech.glide.load.a.d.a;
import com.bumptech.glide.load.b.u;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.f;
import java.util.Collections;
import java.util.List;

/* compiled from: SourceGenerator */
class K implements C0295i, a<Object>, C0295i.a {

    /* renamed from: a reason: collision with root package name */
    private final C0296j<?> f3891a;

    /* renamed from: b reason: collision with root package name */
    private final C0295i.a f3892b;

    /* renamed from: c reason: collision with root package name */
    private int f3893c;

    /* renamed from: d reason: collision with root package name */
    private C0292f f3894d;

    /* renamed from: e reason: collision with root package name */
    private Object f3895e;

    /* renamed from: f reason: collision with root package name */
    private volatile u.a<?> f3896f;

    /* renamed from: g reason: collision with root package name */
    private C0293g f3897g;

    K(C0296j<?> jVar, C0295i.a aVar) {
        this.f3891a = jVar;
        this.f3892b = aVar;
    }

    /* JADX INFO: finally extract failed */
    private void b(Object obj) {
        String str = "SourceGenerator";
        long a2 = h.a();
        try {
            d a3 = this.f3891a.a(obj);
            C0294h hVar = new C0294h(a3, obj, this.f3891a.i());
            this.f3897g = new C0293g(this.f3896f.f3674a, this.f3891a.l());
            this.f3891a.d().a(this.f3897g, hVar);
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Finished encoding source to cache, key: ");
                sb.append(this.f3897g);
                sb.append(", data: ");
                sb.append(obj);
                sb.append(", encoder: ");
                sb.append(a3);
                sb.append(", duration: ");
                sb.append(h.a(a2));
                Log.v(str, sb.toString());
            }
            this.f3896f.f3676c.b();
            this.f3894d = new C0292f(Collections.singletonList(this.f3896f.f3674a), this.f3891a, this);
        } catch (Throwable th) {
            this.f3896f.f3676c.b();
            throw th;
        }
    }

    private boolean c() {
        return this.f3893c < this.f3891a.g().size();
    }

    public boolean a() {
        Object obj = this.f3895e;
        if (obj != null) {
            this.f3895e = null;
            b(obj);
        }
        C0292f fVar = this.f3894d;
        if (fVar != null && fVar.a()) {
            return true;
        }
        this.f3894d = null;
        this.f3896f = null;
        boolean z = false;
        while (!z && c()) {
            List g2 = this.f3891a.g();
            int i2 = this.f3893c;
            this.f3893c = i2 + 1;
            this.f3896f = (u.a) g2.get(i2);
            if (this.f3896f != null && (this.f3891a.e().a(this.f3896f.f3676c.c()) || this.f3891a.c(this.f3896f.f3676c.a()))) {
                this.f3896f.f3676c.a(this.f3891a.j(), this);
                z = true;
            }
        }
        return z;
    }

    public void cancel() {
        u.a<?> aVar = this.f3896f;
        if (aVar != null) {
            aVar.f3676c.cancel();
        }
    }

    public void a(Object obj) {
        s e2 = this.f3891a.e();
        if (obj == null || !e2.a(this.f3896f.f3676c.c())) {
            this.f3892b.a(this.f3896f.f3674a, obj, this.f3896f.f3676c, this.f3896f.f3676c.c(), this.f3897g);
            return;
        }
        this.f3895e = obj;
        this.f3892b.b();
    }

    public void b() {
        throw new UnsupportedOperationException();
    }

    public void a(Exception exc) {
        this.f3892b.a(this.f3897g, exc, this.f3896f.f3676c, this.f3896f.f3676c.c());
    }

    public void a(f fVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar, f fVar2) {
        this.f3892b.a(fVar, obj, dVar, this.f3896f.f3676c.c(), fVar);
    }

    public void a(f fVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar) {
        this.f3892b.a(fVar, exc, dVar, this.f3896f.f3676c.c());
    }
}
