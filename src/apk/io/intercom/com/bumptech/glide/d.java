package io.intercom.com.bumptech.glide;

import android.content.Context;
import b.d.b;
import io.intercom.com.bumptech.glide.c.n;
import io.intercom.com.bumptech.glide.c.n.a;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.engine.a.f;
import io.intercom.com.bumptech.glide.load.engine.a.k;
import io.intercom.com.bumptech.glide.load.engine.b.a.C0112a;
import io.intercom.com.bumptech.glide.load.engine.b.h;
import io.intercom.com.bumptech.glide.load.engine.b.i;
import io.intercom.com.bumptech.glide.load.engine.b.j;
import io.intercom.com.bumptech.glide.load.engine.s;
import java.util.Map;

/* compiled from: GlideBuilder */
public final class d {

    /* renamed from: a reason: collision with root package name */
    private final Map<Class<?>, o<?, ?>> f9257a = new b();

    /* renamed from: b reason: collision with root package name */
    private s f9258b;

    /* renamed from: c reason: collision with root package name */
    private e f9259c;

    /* renamed from: d reason: collision with root package name */
    private io.intercom.com.bumptech.glide.load.engine.a.b f9260d;

    /* renamed from: e reason: collision with root package name */
    private i f9261e;

    /* renamed from: f reason: collision with root package name */
    private io.intercom.com.bumptech.glide.load.engine.c.b f9262f;

    /* renamed from: g reason: collision with root package name */
    private io.intercom.com.bumptech.glide.load.engine.c.b f9263g;

    /* renamed from: h reason: collision with root package name */
    private C0112a f9264h;

    /* renamed from: i reason: collision with root package name */
    private j f9265i;

    /* renamed from: j reason: collision with root package name */
    private io.intercom.com.bumptech.glide.c.d f9266j;

    /* renamed from: k reason: collision with root package name */
    private int f9267k = 4;

    /* renamed from: l reason: collision with root package name */
    private g f9268l = new g();
    private a m;
    private io.intercom.com.bumptech.glide.load.engine.c.b n;
    private boolean o = true;

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.m = aVar;
    }

    public c a(Context context) {
        if (this.f9262f == null) {
            this.f9262f = io.intercom.com.bumptech.glide.load.engine.c.b.d();
        }
        if (this.f9263g == null) {
            this.f9263g = io.intercom.com.bumptech.glide.load.engine.c.b.c();
        }
        if (this.n == null) {
            this.n = io.intercom.com.bumptech.glide.load.engine.c.b.b();
        }
        if (this.f9265i == null) {
            this.f9265i = new j.a(context).a();
        }
        if (this.f9266j == null) {
            this.f9266j = new io.intercom.com.bumptech.glide.c.g();
        }
        if (this.f9259c == null) {
            int b2 = this.f9265i.b();
            if (b2 > 0) {
                this.f9259c = new k((long) b2);
            } else {
                this.f9259c = new f();
            }
        }
        if (this.f9260d == null) {
            this.f9260d = new io.intercom.com.bumptech.glide.load.engine.a.j(this.f9265i.a());
        }
        if (this.f9261e == null) {
            this.f9261e = new h((long) this.f9265i.c());
        }
        if (this.f9264h == null) {
            this.f9264h = new io.intercom.com.bumptech.glide.load.engine.b.g(context);
        }
        if (this.f9258b == null) {
            s sVar = new s(this.f9261e, this.f9264h, this.f9263g, this.f9262f, io.intercom.com.bumptech.glide.load.engine.c.b.e(), io.intercom.com.bumptech.glide.load.engine.c.b.b(), this.o);
            this.f9258b = sVar;
        }
        n nVar = new n(this.m);
        s sVar2 = this.f9258b;
        i iVar = this.f9261e;
        e eVar = this.f9259c;
        io.intercom.com.bumptech.glide.load.engine.a.b bVar = this.f9260d;
        io.intercom.com.bumptech.glide.c.d dVar = this.f9266j;
        int i2 = this.f9267k;
        g gVar = this.f9268l;
        gVar.F();
        c cVar = new c(context, sVar2, iVar, eVar, bVar, nVar, dVar, i2, gVar, this.f9257a);
        return cVar;
    }
}
