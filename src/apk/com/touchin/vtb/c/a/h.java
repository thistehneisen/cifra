package com.touchin.vtb.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.touchin.vtb.VTBAccountingApplication;
import com.touchin.vtb.api.A;
import com.touchin.vtb.api.m;
import com.touchin.vtb.api.v;
import com.touchin.vtb.api.y;
import com.touchin.vtb.f.a.c;
import com.touchin.vtb.f.b.C0668v;
import com.touchin.vtb.f.b.K;
import com.touchin.vtb.f.b.P;
import com.touchin.vtb.f.b.ra;
import com.touchin.vtb.f.b.sa;
import com.touchin.vtb.f.b.ta;
import com.touchin.vtb.h.a.k;
import com.touchin.vtb.h.a.s;
import com.touchin.vtb.h.b.e;
import com.touchin.vtb.h.b.g;
import com.touchin.vtb.h.b.j;
import com.touchin.vtb.h.c.B;
import com.touchin.vtb.h.c.C;
import com.touchin.vtb.h.c.C0673a;
import com.touchin.vtb.h.c.C0674b;
import com.touchin.vtb.h.c.C0675c;
import com.touchin.vtb.h.c.d;
import com.touchin.vtb.h.c.l;
import com.touchin.vtb.h.c.n;
import com.touchin.vtb.h.c.p;
import com.touchin.vtb.h.c.q;
import com.touchin.vtb.h.c.r;
import com.touchin.vtb.h.c.x;
import com.touchin.vtb.h.c.z;
import com.touchin.vtb.h.d.b;
import com.touchin.vtb.h.d.f;
import com.touchin.vtb.h.d.i;
import i.G;
import java.util.Map;
import l.a.c.c.t;
import retrofit2.w;

/* compiled from: DaggerApplicationComponent */
public final class h implements a {
    private n A;
    private d B;
    private l C;
    private j D;
    private f.a.a<v> E;
    private K F;
    private i G;
    private f.a.a<y> H;
    private P I;
    private s J;
    private b K;
    private com.touchin.vtb.h.d.d L;
    private f M;
    private com.touchin.vtb.h.a.j N;
    private e O;
    private g P;
    private com.touchin.vtb.h.c.f Q;
    private com.touchin.vtb.h.a.l R;
    private com.touchin.vtb.h.a.b S;

    /* renamed from: a reason: collision with root package name */
    private d f7190a;

    /* renamed from: b reason: collision with root package name */
    private f f7191b;

    /* renamed from: c reason: collision with root package name */
    private f.a.a<m> f7192c;

    /* renamed from: d reason: collision with root package name */
    private f.a.a<G> f7193d;

    /* renamed from: e reason: collision with root package name */
    private c f7194e;

    /* renamed from: f reason: collision with root package name */
    private f.a.a<w> f7195f;

    /* renamed from: g reason: collision with root package name */
    private f.a.a<A> f7196g;

    /* renamed from: h reason: collision with root package name */
    private f.a.a<w> f7197h;

    /* renamed from: i reason: collision with root package name */
    private f.a.a<com.touchin.vtb.api.j> f7198i;

    /* renamed from: j reason: collision with root package name */
    private e f7199j;

    /* renamed from: k reason: collision with root package name */
    private f.a.a<ru.touchin.roboswag.core.observables.storable.i<String, Boolean, Boolean>> f7200k;

    /* renamed from: l reason: collision with root package name */
    private f.a.a<c> f7201l;
    private f.a.a<sa> m;
    private f.a.a<ru.touchin.roboswag.core.observables.storable.i<String, String, String>> n;
    private f.a.a<ru.touchin.roboswag.core.observables.storable.i<String, String, String>> o;
    private f.a.a<ru.touchin.roboswag.core.observables.storable.i<String, Boolean, Boolean>> p;
    private ra q;
    private com.touchin.vtb.h.c.A r;
    private C s;
    private C0674b t;
    private x u;
    private com.touchin.vtb.h.c.s v;
    private f.a.a<com.touchin.vtb.api.e> w;
    private f.a.a<ru.touchin.roboswag.core.observables.storable.i<String, Long, Long>> x;
    private C0668v y;
    private q z;

    /* compiled from: DaggerApplicationComponent */
    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public i f7202a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public b f7203b;
        /* access modifiers changed from: private */

        /* renamed from: c reason: collision with root package name */
        public r f7204c;

        private a() {
        }

        public a a() {
            if (this.f7202a == null) {
                this.f7202a = new i();
            }
            if (this.f7203b != null) {
                if (this.f7204c == null) {
                    this.f7204c = new r();
                }
                return new h(this);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(b.class.getCanonicalName());
            sb.append(" must be set");
            throw new IllegalStateException(sb.toString());
        }

        public a a(b bVar) {
            d.a.e.a(bVar);
            this.f7203b = bVar;
            return this;
        }
    }

    public static a a() {
        return new a();
    }

    private Map<Class<? extends androidx.lifecycle.C>, f.a.a<androidx.lifecycle.C>> b() {
        d.a.d a2 = d.a.d.a(22);
        a2.a(z.class, this.r);
        a2.a(B.class, this.s);
        a2.a(C0673a.class, this.t);
        a2.a(com.touchin.vtb.h.c.v.class, this.u);
        a2.a(r.class, this.v);
        a2.a(p.class, this.z);
        a2.a(com.touchin.vtb.h.c.m.class, this.A);
        a2.a(C0675c.class, this.B);
        a2.a(com.touchin.vtb.h.c.i.class, this.C);
        a2.a(com.touchin.vtb.h.b.i.class, this.D);
        a2.a(com.touchin.vtb.h.d.g.class, this.G);
        a2.a(com.touchin.vtb.h.a.r.class, this.J);
        a2.a(com.touchin.vtb.h.d.a.class, this.K);
        a2.a(com.touchin.vtb.h.d.c.class, this.L);
        a2.a(com.touchin.vtb.h.d.e.class, this.M);
        a2.a(com.touchin.vtb.h.a.d.class, this.N);
        a2.a(com.touchin.vtb.h.b.d.class, this.O);
        a2.a(com.touchin.vtb.h.b.f.class, this.P);
        a2.a(com.touchin.vtb.h.c.e.class, this.Q);
        a2.a(com.touchin.vtb.h.a.m.class, com.touchin.vtb.h.a.n.a());
        a2.a(k.class, this.R);
        a2.a(com.touchin.vtb.h.a.a.class, this.S);
        return a2.a();
    }

    private t c() {
        return new t(b());
    }

    private h(a aVar) {
        a(aVar);
    }

    private void a(a aVar) {
        this.f7190a = d.a(aVar.f7203b);
        this.f7191b = f.a(aVar.f7203b, (f.a.a<Context>) this.f7190a);
        this.f7192c = d.a.b.a(com.touchin.vtb.api.n.a(this.f7191b, this.f7190a));
        this.f7193d = d.a.b.a(m.a(aVar.f7202a, this.f7192c));
        this.f7194e = c.a(aVar.f7203b, (f.a.a<com.touchin.vtb.b.i>) this.f7191b);
        this.f7195f = d.a.b.a(n.a(aVar.f7202a, this.f7193d, (f.a.a<com.touchin.vtb.api.d>) this.f7194e));
        this.f7196g = d.a.b.a(q.a(aVar.f7202a, this.f7195f));
        this.f7197h = d.a.b.a(l.a(aVar.f7202a, this.f7193d));
        this.f7198i = d.a.b.a(k.a(aVar.f7202a, this.f7197h));
        this.f7199j = e.a(aVar.f7203b, (f.a.a<Context>) this.f7190a);
        this.f7200k = d.a.b.a(u.a(aVar.f7204c, (f.a.a<SharedPreferences>) this.f7199j));
        this.f7201l = d.a.b.a(com.touchin.vtb.f.a.d.a(this.f7190a, this.f7200k));
        this.m = d.a.b.a(ta.a());
        this.n = d.a.b.a(v.a(aVar.f7204c, (f.a.a<SharedPreferences>) this.f7199j));
        this.o = d.a.b.a(w.a(aVar.f7204c, (f.a.a<SharedPreferences>) this.f7199j));
        this.p = d.a.b.a(t.a(aVar.f7204c, (f.a.a<SharedPreferences>) this.f7199j));
        this.q = ra.a(this.f7196g, this.f7198i, this.f7201l, this.m, this.n, this.o, this.p);
        this.r = com.touchin.vtb.h.c.A.a(this.q);
        this.s = C.a(this.q);
        this.t = C0674b.a(this.q);
        this.u = x.a(this.q);
        this.v = com.touchin.vtb.h.c.s.a(this.q);
        this.w = d.a.b.a(j.a(aVar.f7202a, this.f7195f));
        this.x = d.a.b.a(s.a(aVar.f7204c, (f.a.a<SharedPreferences>) this.f7199j));
        this.y = C0668v.a(this.w, this.q, this.o, this.x);
        this.z = q.a(this.y, this.m);
        this.A = n.a(this.y, this.m);
        this.B = d.a(this.q);
        this.C = l.a(this.f7201l);
        this.D = j.a(this.q, this.m);
        this.E = d.a.b.a(o.a(aVar.f7202a, this.f7195f));
        this.F = K.a(this.E, this.o);
        this.G = i.a(this.m, this.F);
        this.H = d.a.b.a(p.a(aVar.f7202a, this.f7195f));
        this.I = P.a(this.H, this.o);
        this.J = s.a(this.I);
        this.K = b.a(this.F);
        this.L = com.touchin.vtb.h.d.d.a(this.F, this.q);
        this.M = f.a(this.F);
        this.N = com.touchin.vtb.h.a.j.a(this.m, this.y);
        this.O = e.a(this.y, this.q, this.m);
        this.P = g.a(this.q);
        this.Q = com.touchin.vtb.h.c.f.a(this.q);
        this.R = com.touchin.vtb.h.a.l.a(this.m);
        this.S = com.touchin.vtb.h.a.b.a(this.y);
    }

    private VTBAccountingApplication b(VTBAccountingApplication vTBAccountingApplication) {
        com.touchin.vtb.g.a(vTBAccountingApplication, c());
        return vTBAccountingApplication;
    }

    public void a(VTBAccountingApplication vTBAccountingApplication) {
        b(vTBAccountingApplication);
    }
}
