package io.intercom.com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import b.g.h.d;
import io.intercom.com.bumptech.glide.f.h;
import io.intercom.com.bumptech.glide.h.a.d.c;
import io.intercom.com.bumptech.glide.h.a.f;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EngineJob */
class u<R> implements a<R>, c {

    /* renamed from: a reason: collision with root package name */
    private static final a f9960a = new a();

    /* renamed from: b reason: collision with root package name */
    private static final Handler f9961b = new Handler(Looper.getMainLooper(), new b());

    /* renamed from: c reason: collision with root package name */
    private final List<h> f9962c;

    /* renamed from: d reason: collision with root package name */
    private final f f9963d;

    /* renamed from: e reason: collision with root package name */
    private final d<u<?>> f9964e;

    /* renamed from: f reason: collision with root package name */
    private final a f9965f;

    /* renamed from: g reason: collision with root package name */
    private final v f9966g;

    /* renamed from: h reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.c.b f9967h;

    /* renamed from: i reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.c.b f9968i;

    /* renamed from: j reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.c.b f9969j;

    /* renamed from: k reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.load.engine.c.b f9970k;

    /* renamed from: l reason: collision with root package name */
    private g f9971l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private E<?> q;
    private io.intercom.com.bumptech.glide.load.a r;
    private boolean s;
    private GlideException t;
    private boolean u;
    private List<h> v;
    private y<?> w;
    private j<R> x;
    private volatile boolean y;

    /* compiled from: EngineJob */
    static class a {
        a() {
        }

        public <R> y<R> a(E<R> e2, boolean z) {
            return new y<>(e2, z, true);
        }
    }

    /* compiled from: EngineJob */
    private static class b implements Callback {
        b() {
        }

        public boolean handleMessage(Message message) {
            u uVar = (u) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                uVar.e();
            } else if (i2 == 2) {
                uVar.c();
            } else if (i2 == 3) {
                uVar.b();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized message: ");
                sb.append(message.what);
                throw new IllegalStateException(sb.toString());
            }
            return true;
        }
    }

    u(io.intercom.com.bumptech.glide.load.engine.c.b bVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar2, io.intercom.com.bumptech.glide.load.engine.c.b bVar3, io.intercom.com.bumptech.glide.load.engine.c.b bVar4, v vVar, d<u<?>> dVar) {
        this(bVar, bVar2, bVar3, bVar4, vVar, dVar, f9960a);
    }

    private void c(h hVar) {
        if (this.v == null) {
            this.v = new ArrayList(2);
        }
        if (!this.v.contains(hVar)) {
            this.v.add(hVar);
        }
    }

    private boolean d(h hVar) {
        List<h> list = this.v;
        return list != null && list.contains(hVar);
    }

    private io.intercom.com.bumptech.glide.load.engine.c.b g() {
        if (this.n) {
            return this.f9969j;
        }
        return this.o ? this.f9970k : this.f9968i;
    }

    /* access modifiers changed from: 0000 */
    public u<R> a(g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f9971l = gVar;
        this.m = z;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        return this;
    }

    public void b(j<R> jVar) {
        io.intercom.com.bumptech.glide.load.engine.c.b bVar;
        this.x = jVar;
        if (jVar.c()) {
            bVar = this.f9967h;
        } else {
            bVar = g();
        }
        bVar.execute(jVar);
    }

    /* access modifiers changed from: 0000 */
    public void e() {
        this.f9963d.b();
        if (this.y) {
            this.q.a();
            a(false);
        } else if (this.f9962c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else if (!this.s) {
            this.w = this.f9965f.a(this.q, this.m);
            this.s = true;
            this.w.d();
            this.f9966g.a(this, this.f9971l, this.w);
            int size = this.f9962c.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.f9962c.get(i2);
                if (!d(hVar)) {
                    this.w.d();
                    hVar.a(this.w, this.r);
                }
            }
            this.w.g();
            a(false);
        } else {
            throw new IllegalStateException("Already have resource");
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean f() {
        return this.p;
    }

    u(io.intercom.com.bumptech.glide.load.engine.c.b bVar, io.intercom.com.bumptech.glide.load.engine.c.b bVar2, io.intercom.com.bumptech.glide.load.engine.c.b bVar3, io.intercom.com.bumptech.glide.load.engine.c.b bVar4, v vVar, d<u<?>> dVar, a aVar) {
        this.f9962c = new ArrayList(2);
        this.f9963d = f.a();
        this.f9967h = bVar;
        this.f9968i = bVar2;
        this.f9969j = bVar3;
        this.f9970k = bVar4;
        this.f9966g = vVar;
        this.f9964e = dVar;
        this.f9965f = aVar;
    }

    public f d() {
        return this.f9963d;
    }

    /* access modifiers changed from: 0000 */
    public void b(h hVar) {
        j.b();
        this.f9963d.b();
        if (this.s || this.u) {
            c(hVar);
            return;
        }
        this.f9962c.remove(hVar);
        if (this.f9962c.isEmpty()) {
            a();
        }
    }

    /* access modifiers changed from: 0000 */
    public void c() {
        this.f9963d.b();
        if (this.y) {
            a(false);
        } else if (this.f9962c.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        } else if (!this.u) {
            this.u = true;
            this.f9966g.a(this, this.f9971l, null);
            for (h hVar : this.f9962c) {
                if (!d(hVar)) {
                    hVar.a(this.t);
                }
            }
            a(false);
        } else {
            throw new IllegalStateException("Already failed once");
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(h hVar) {
        j.b();
        this.f9963d.b();
        if (this.s) {
            hVar.a(this.w, this.r);
        } else if (this.u) {
            hVar.a(this.t);
        } else {
            this.f9962c.add(hVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        this.f9963d.b();
        if (this.y) {
            this.f9966g.a(this, this.f9971l);
            a(false);
            return;
        }
        throw new IllegalStateException("Not cancelled");
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        if (!this.u && !this.s && !this.y) {
            this.y = true;
            this.x.a();
            this.f9966g.a(this, this.f9971l);
        }
    }

    private void a(boolean z) {
        j.b();
        this.f9962c.clear();
        this.f9971l = null;
        this.w = null;
        this.q = null;
        List<h> list = this.v;
        if (list != null) {
            list.clear();
        }
        this.u = false;
        this.y = false;
        this.s = false;
        this.x.a(z);
        this.x = null;
        this.t = null;
        this.r = null;
        this.f9964e.a(this);
    }

    public void a(E<R> e2, io.intercom.com.bumptech.glide.load.a aVar) {
        this.q = e2;
        this.r = aVar;
        f9961b.obtainMessage(1, this).sendToTarget();
    }

    public void a(GlideException glideException) {
        this.t = glideException;
        f9961b.obtainMessage(2, this).sendToTarget();
    }

    public void a(j<?> jVar) {
        g().execute(jVar);
    }
}
