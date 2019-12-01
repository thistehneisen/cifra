package com.bumptech.glide;

import android.content.Context;
import b.d.b;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.g;
import com.bumptech.glide.c.n;
import com.bumptech.glide.c.n.a;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.engine.a.k;
import com.bumptech.glide.load.engine.b.a.C0056a;
import com.bumptech.glide.load.engine.b.h;
import com.bumptech.glide.load.engine.b.i;
import com.bumptech.glide.load.engine.b.j;
import com.bumptech.glide.load.engine.u;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: GlideBuilder */
public final class f {

    /* renamed from: a reason: collision with root package name */
    private final Map<Class<?>, o<?, ?>> f3418a = new b();

    /* renamed from: b reason: collision with root package name */
    private u f3419b;

    /* renamed from: c reason: collision with root package name */
    private e f3420c;

    /* renamed from: d reason: collision with root package name */
    private com.bumptech.glide.load.engine.a.b f3421d;

    /* renamed from: e reason: collision with root package name */
    private i f3422e;

    /* renamed from: f reason: collision with root package name */
    private com.bumptech.glide.load.engine.c.b f3423f;

    /* renamed from: g reason: collision with root package name */
    private com.bumptech.glide.load.engine.c.b f3424g;

    /* renamed from: h reason: collision with root package name */
    private C0056a f3425h;

    /* renamed from: i reason: collision with root package name */
    private j f3426i;

    /* renamed from: j reason: collision with root package name */
    private d f3427j;

    /* renamed from: k reason: collision with root package name */
    private int f3428k = 4;

    /* renamed from: l reason: collision with root package name */
    private com.bumptech.glide.f.f f3429l = new com.bumptech.glide.f.f();
    private a m;
    private com.bumptech.glide.load.engine.c.b n;
    private boolean o;
    private List<com.bumptech.glide.f.e<Object>> p;
    private boolean q;

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        this.m = aVar;
    }

    /* access modifiers changed from: 0000 */
    public e a(Context context) {
        if (this.f3423f == null) {
            this.f3423f = com.bumptech.glide.load.engine.c.b.d();
        }
        if (this.f3424g == null) {
            this.f3424g = com.bumptech.glide.load.engine.c.b.c();
        }
        if (this.n == null) {
            this.n = com.bumptech.glide.load.engine.c.b.b();
        }
        if (this.f3426i == null) {
            this.f3426i = new j.a(context).a();
        }
        if (this.f3427j == null) {
            this.f3427j = new g();
        }
        if (this.f3420c == null) {
            int b2 = this.f3426i.b();
            if (b2 > 0) {
                this.f3420c = new k((long) b2);
            } else {
                this.f3420c = new com.bumptech.glide.load.engine.a.f();
            }
        }
        if (this.f3421d == null) {
            this.f3421d = new com.bumptech.glide.load.engine.a.j(this.f3426i.a());
        }
        if (this.f3422e == null) {
            this.f3422e = new h((long) this.f3426i.c());
        }
        if (this.f3425h == null) {
            this.f3425h = new com.bumptech.glide.load.engine.b.g(context);
        }
        if (this.f3419b == null) {
            u uVar = new u(this.f3422e, this.f3425h, this.f3424g, this.f3423f, com.bumptech.glide.load.engine.c.b.e(), com.bumptech.glide.load.engine.c.b.b(), this.o);
            this.f3419b = uVar;
        }
        List<com.bumptech.glide.f.e<Object>> list = this.p;
        if (list == null) {
            this.p = Collections.emptyList();
        } else {
            this.p = Collections.unmodifiableList(list);
        }
        Context context2 = context;
        e eVar = new e(context2, this.f3419b, this.f3422e, this.f3420c, this.f3421d, new n(this.m), this.f3427j, this.f3428k, (com.bumptech.glide.f.f) this.f3429l.E(), this.f3418a, this.p, this.q);
        return eVar;
    }
}
