package com.bumptech.glide.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import b.g.h.d;
import com.bumptech.glide.f.a.g;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.h.a.d.c;
import com.bumptech.glide.h.n;
import com.bumptech.glide.j;
import com.bumptech.glide.load.engine.G;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.u;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest */
public final class i<R> implements c, g, g, c {

    /* renamed from: a reason: collision with root package name */
    private static final d<i<?>> f3464a = com.bumptech.glide.h.a.d.a(150, (com.bumptech.glide.h.a.d.a<T>) new h<T>());

    /* renamed from: b reason: collision with root package name */
    private static final boolean f3465b = Log.isLoggable("Request", 2);
    private Drawable A;
    private int B;
    private int C;
    private RuntimeException D;

    /* renamed from: c reason: collision with root package name */
    private boolean f3466c;

    /* renamed from: d reason: collision with root package name */
    private final String f3467d;

    /* renamed from: e reason: collision with root package name */
    private final com.bumptech.glide.h.a.g f3468e;

    /* renamed from: f reason: collision with root package name */
    private e<R> f3469f;

    /* renamed from: g reason: collision with root package name */
    private d f3470g;

    /* renamed from: h reason: collision with root package name */
    private Context f3471h;

    /* renamed from: i reason: collision with root package name */
    private com.bumptech.glide.g f3472i;

    /* renamed from: j reason: collision with root package name */
    private Object f3473j;

    /* renamed from: k reason: collision with root package name */
    private Class<R> f3474k;

    /* renamed from: l reason: collision with root package name */
    private a<?> f3475l;
    private int m;
    private int n;
    private j o;
    private h<R> p;
    private List<e<R>> q;
    private u r;
    private com.bumptech.glide.f.b.c<? super R> s;
    private Executor t;
    private G<R> u;
    private u.d v;
    private long w;
    private a x;
    private Drawable y;
    private Drawable z;

    /* compiled from: SingleRequest */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    i() {
        this.f3467d = f3465b ? String.valueOf(super.hashCode()) : null;
        this.f3468e = com.bumptech.glide.h.a.g.a();
    }

    public static <R> i<R> a(Context context, com.bumptech.glide.g gVar, Object obj, Class<R> cls, a<?> aVar, int i2, int i3, j jVar, h<R> hVar, e<R> eVar, List<e<R>> list, d dVar, u uVar, com.bumptech.glide.f.b.c<? super R> cVar, Executor executor) {
        i<R> iVar = (i) f3464a.a();
        if (iVar == null) {
            iVar = new i<>();
        }
        iVar.b(context, gVar, obj, cls, aVar, i2, i3, jVar, hVar, eVar, list, dVar, uVar, cVar, executor);
        return iVar;
    }

    private synchronized void b(Context context, com.bumptech.glide.g gVar, Object obj, Class<R> cls, a<?> aVar, int i2, int i3, j jVar, h<R> hVar, e<R> eVar, List<e<R>> list, d dVar, u uVar, com.bumptech.glide.f.b.c<? super R> cVar, Executor executor) {
        this.f3471h = context;
        this.f3472i = gVar;
        this.f3473j = obj;
        this.f3474k = cls;
        this.f3475l = aVar;
        this.m = i2;
        this.n = i3;
        this.o = jVar;
        this.p = hVar;
        this.f3469f = eVar;
        this.q = list;
        this.f3470g = dVar;
        this.r = uVar;
        this.s = cVar;
        this.t = executor;
        this.x = a.PENDING;
        if (this.D == null && gVar.g()) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private void g() {
        if (this.f3466c) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean h() {
        d dVar = this.f3470g;
        return dVar == null || dVar.f(this);
    }

    private boolean i() {
        d dVar = this.f3470g;
        return dVar == null || dVar.c(this);
    }

    private boolean j() {
        d dVar = this.f3470g;
        return dVar == null || dVar.d(this);
    }

    private void k() {
        g();
        this.f3468e.b();
        this.p.a((g) this);
        u.d dVar = this.v;
        if (dVar != null) {
            dVar.a();
            this.v = null;
        }
    }

    private Drawable l() {
        if (this.y == null) {
            this.y = this.f3475l.d();
            if (this.y == null && this.f3475l.c() > 0) {
                this.y = a(this.f3475l.c());
            }
        }
        return this.y;
    }

    private Drawable m() {
        if (this.A == null) {
            this.A = this.f3475l.e();
            if (this.A == null && this.f3475l.f() > 0) {
                this.A = a(this.f3475l.f());
            }
        }
        return this.A;
    }

    private Drawable n() {
        if (this.z == null) {
            this.z = this.f3475l.k();
            if (this.z == null && this.f3475l.l() > 0) {
                this.z = a(this.f3475l.l());
            }
        }
        return this.z;
    }

    private boolean o() {
        d dVar = this.f3470g;
        return dVar == null || !dVar.d();
    }

    private void p() {
        d dVar = this.f3470g;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    private void q() {
        d dVar = this.f3470g;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    private synchronized void r() {
        if (i()) {
            Drawable drawable = null;
            if (this.f3473j == null) {
                drawable = m();
            }
            if (drawable == null) {
                drawable = l();
            }
            if (drawable == null) {
                drawable = n();
            }
            this.p.onLoadFailed(drawable);
        }
    }

    public synchronized boolean c() {
        return this.x == a.FAILED;
    }

    public synchronized void clear() {
        g();
        this.f3468e.b();
        if (this.x != a.CLEARED) {
            k();
            if (this.u != null) {
                a(this.u);
            }
            if (h()) {
                this.p.onLoadCleared(n());
            }
            this.x = a.CLEARED;
        }
    }

    public com.bumptech.glide.h.a.g d() {
        return this.f3468e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a4, code lost:
        return;
     */
    public synchronized void e() {
        g();
        this.f3468e.b();
        this.w = com.bumptech.glide.h.h.a();
        if (this.f3473j == null) {
            if (n.b(this.m, this.n)) {
                this.B = this.m;
                this.C = this.n;
            }
            a(new GlideException("Received null model"), m() == null ? 5 : 3);
        } else if (this.x == a.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (this.x == a.COMPLETE) {
            a(this.u, com.bumptech.glide.load.a.MEMORY_CACHE);
        } else {
            this.x = a.WAITING_FOR_SIZE;
            if (n.b(this.m, this.n)) {
                a(this.m, this.n);
            } else {
                this.p.b(this);
            }
            if ((this.x == a.RUNNING || this.x == a.WAITING_FOR_SIZE) && i()) {
                this.p.onLoadStarted(n());
            }
            if (f3465b) {
                StringBuilder sb = new StringBuilder();
                sb.append("finished run method in ");
                sb.append(com.bumptech.glide.h.h.a(this.w));
                a(sb.toString());
            }
        }
    }

    public synchronized boolean f() {
        return this.x == a.CLEARED;
    }

    public synchronized boolean isComplete() {
        return this.x == a.COMPLETE;
    }

    public synchronized boolean isRunning() {
        return this.x == a.RUNNING || this.x == a.WAITING_FOR_SIZE;
    }

    public synchronized void a() {
        g();
        this.f3471h = null;
        this.f3472i = null;
        this.f3473j = null;
        this.f3474k = null;
        this.f3475l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.q = null;
        this.f3469f = null;
        this.f3470g = null;
        this.s = null;
        this.v = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = -1;
        this.C = -1;
        this.D = null;
        f3464a.a(this);
    }

    public synchronized boolean b() {
        return isComplete();
    }

    private void a(G<?> g2) {
        this.r.b(g2);
        this.u = null;
    }

    private Drawable a(int i2) {
        return com.bumptech.glide.load.c.c.a.a((Context) this.f3472i, i2, this.f3475l.q() != null ? this.f3475l.q() : this.f3471h.getTheme());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f0, code lost:
        return;
     */
    public synchronized void a(int i2, int i3) {
        synchronized (this) {
            try {
                this.f3468e.b();
                if (f3465b) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Got onSizeReady in ");
                    sb.append(com.bumptech.glide.h.h.a(this.w));
                    a(sb.toString());
                }
                if (this.x == a.WAITING_FOR_SIZE) {
                    this.x = a.RUNNING;
                    float p2 = this.f3475l.p();
                    this.B = a(i2, p2);
                    this.C = a(i3, p2);
                    if (f3465b) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("finished setup for calling load in ");
                        sb2.append(com.bumptech.glide.h.h.a(this.w));
                        a(sb2.toString());
                    }
                    try {
                        try {
                            this.v = this.r.a(this.f3472i, this.f3473j, this.f3475l.o(), this.B, this.C, this.f3475l.n(), this.f3474k, this.o, this.f3475l.b(), this.f3475l.r(), this.f3475l.B(), this.f3475l.w(), this.f3475l.h(), this.f3475l.u(), this.f3475l.t(), this.f3475l.s(), this.f3475l.g(), this, this.t);
                            if (this.x != a.RUNNING) {
                                this.v = null;
                            }
                            if (f3465b) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("finished onSizeReady in ");
                                sb3.append(com.bumptech.glide.h.h.a(this.w));
                                a(sb3.toString());
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    public synchronized void a(G<?> g2, com.bumptech.glide.load.a aVar) {
        this.f3468e.b();
        this.v = null;
        if (g2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive a Resource<R> with an object of ");
            sb.append(this.f3474k);
            sb.append(" inside, but instead got null.");
            a(new GlideException(sb.toString()));
            return;
        }
        Object obj = g2.get();
        if (obj != null) {
            if (this.f3474k.isAssignableFrom(obj.getClass())) {
                if (!j()) {
                    a(g2);
                    this.x = a.COMPLETE;
                    return;
                }
                a(g2, obj, aVar);
                return;
            }
        }
        a(g2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected to receive an object of ");
        sb2.append(this.f3474k);
        sb2.append(" but instead got ");
        sb2.append(obj != null ? obj.getClass() : "");
        sb2.append("{");
        sb2.append(obj);
        sb2.append("} inside Resource{");
        sb2.append(g2);
        sb2.append("}.");
        sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        a(new GlideException(sb2.toString()));
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ac A[Catch:{ all -> 0x00be }] */
    private synchronized void a(G<R> g2, R r2, com.bumptech.glide.load.a aVar) {
        boolean z2;
        boolean o2 = o();
        this.x = a.COMPLETE;
        this.u = g2;
        if (this.f3472i.e() <= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Finished loading ");
            sb.append(r2.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(aVar);
            sb.append(" for ");
            sb.append(this.f3473j);
            sb.append(" with size [");
            sb.append(this.B);
            sb.append("x");
            sb.append(this.C);
            sb.append("] in ");
            sb.append(com.bumptech.glide.h.h.a(this.w));
            sb.append(" ms");
            Log.d("Glide", sb.toString());
        }
        boolean z3 = true;
        this.f3466c = true;
        try {
            if (this.q != null) {
                z2 = false;
                for (e a2 : this.q) {
                    z2 |= a2.a(r2, this.f3473j, this.p, aVar, o2);
                }
            } else {
                z2 = false;
            }
            if (this.f3469f != null) {
                if (this.f3469f.a(r2, this.f3473j, this.p, aVar, o2)) {
                    if (!z3 && !z2) {
                        this.p.a(r2, this.s.a(aVar, o2));
                    }
                    this.f3466c = false;
                    q();
                }
            }
            z3 = false;
            if (!z3 && !z2) {
            }
            this.f3466c = false;
            q();
        } catch (Throwable th) {
            this.f3466c = false;
            throw th;
        }
    }

    public synchronized void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX INFO: finally extract failed */
    private synchronized void a(GlideException glideException, int i2) {
        boolean z2;
        this.f3468e.b();
        glideException.a((Exception) this.D);
        int e2 = this.f3472i.e();
        if (e2 <= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Load failed for ");
            sb.append(this.f3473j);
            sb.append(" with size [");
            sb.append(this.B);
            sb.append("x");
            sb.append(this.C);
            sb.append("]");
            Log.w("Glide", sb.toString(), glideException);
            if (e2 <= 4) {
                glideException.a("Glide");
            }
        }
        this.v = null;
        this.x = a.FAILED;
        boolean z3 = true;
        this.f3466c = true;
        try {
            if (this.q != null) {
                z2 = false;
                for (e a2 : this.q) {
                    z2 |= a2.a(glideException, this.f3473j, this.p, o());
                }
            } else {
                z2 = false;
            }
            if (this.f3469f == null || !this.f3469f.a(glideException, this.f3473j, this.p, o())) {
                z3 = false;
            }
            if (!z2 && !z3) {
                r();
            }
            this.f3466c = false;
            p();
        } catch (Throwable th) {
            this.f3466c = false;
            throw th;
        }
    }

    public synchronized boolean a(c cVar) {
        boolean z2 = false;
        if (!(cVar instanceof i)) {
            return false;
        }
        i iVar = (i) cVar;
        synchronized (iVar) {
            if (this.m == iVar.m && this.n == iVar.n && n.a(this.f3473j, iVar.f3473j) && this.f3474k.equals(iVar.f3474k) && this.f3475l.equals(iVar.f3475l) && this.o == iVar.o && a(iVar)) {
                z2 = true;
            }
        }
        return z2;
    }

    private synchronized boolean a(i<?> iVar) {
        boolean z2;
        synchronized (iVar) {
            z2 = false;
            if ((this.q == null ? 0 : this.q.size()) == (iVar.q == null ? 0 : iVar.q.size())) {
                z2 = true;
            }
        }
        return z2;
    }

    private void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.f3467d);
        Log.v("Request", sb.toString());
    }
}
