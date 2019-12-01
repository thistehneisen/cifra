package io.intercom.com.bumptech.glide.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import b.g.h.d;
import io.intercom.com.bumptech.glide.e;
import io.intercom.com.bumptech.glide.f.a.g;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.h.a.d.c;
import io.intercom.com.bumptech.glide.h.a.f;
import io.intercom.com.bumptech.glide.load.engine.E;
import io.intercom.com.bumptech.glide.load.engine.GlideException;
import io.intercom.com.bumptech.glide.load.engine.s;

/* compiled from: SingleRequest */
public final class j<R> implements c, g, h, c {

    /* renamed from: a reason: collision with root package name */
    private static final d<j<?>> f9348a = io.intercom.com.bumptech.glide.h.a.d.a(150, (io.intercom.com.bumptech.glide.h.a.d.a<T>) new i<T>());

    /* renamed from: b reason: collision with root package name */
    private static final boolean f9349b = Log.isLoggable("Request", 2);
    private int A;
    private int B;

    /* renamed from: c reason: collision with root package name */
    private boolean f9350c;

    /* renamed from: d reason: collision with root package name */
    private final String f9351d;

    /* renamed from: e reason: collision with root package name */
    private final f f9352e;

    /* renamed from: f reason: collision with root package name */
    private f<R> f9353f;

    /* renamed from: g reason: collision with root package name */
    private d f9354g;

    /* renamed from: h reason: collision with root package name */
    private Context f9355h;

    /* renamed from: i reason: collision with root package name */
    private e f9356i;

    /* renamed from: j reason: collision with root package name */
    private Object f9357j;

    /* renamed from: k reason: collision with root package name */
    private Class<R> f9358k;

    /* renamed from: l reason: collision with root package name */
    private g f9359l;
    private int m;
    private int n;
    private h o;
    private io.intercom.com.bumptech.glide.f.a.h<R> p;
    private f<R> q;
    private s r;
    private io.intercom.com.bumptech.glide.f.b.e<? super R> s;
    private E<R> t;
    private s.d u;
    private long v;
    private a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    /* compiled from: SingleRequest */
    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    j() {
        this.f9351d = f9349b ? String.valueOf(super.hashCode()) : null;
        this.f9352e = f.a();
    }

    public static <R> j<R> a(Context context, e eVar, Object obj, Class<R> cls, g gVar, int i2, int i3, h hVar, io.intercom.com.bumptech.glide.f.a.h<R> hVar2, f<R> fVar, f<R> fVar2, d dVar, s sVar, io.intercom.com.bumptech.glide.f.b.e<? super R> eVar2) {
        j<R> jVar = (j) f9348a.a();
        if (jVar == null) {
            jVar = new j<>();
        }
        jVar.b(context, eVar, obj, cls, gVar, i2, i3, hVar, hVar2, fVar, fVar2, dVar, sVar, eVar2);
        return jVar;
    }

    private void b(Context context, e eVar, Object obj, Class<R> cls, g gVar, int i2, int i3, h hVar, io.intercom.com.bumptech.glide.f.a.h<R> hVar2, f<R> fVar, f<R> fVar2, d dVar, s sVar, io.intercom.com.bumptech.glide.f.b.e<? super R> eVar2) {
        this.f9355h = context;
        this.f9356i = eVar;
        this.f9357j = obj;
        this.f9358k = cls;
        this.f9359l = gVar;
        this.m = i2;
        this.n = i3;
        this.o = hVar;
        this.p = hVar2;
        this.f9353f = fVar;
        this.q = fVar2;
        this.f9354g = dVar;
        this.r = sVar;
        this.s = eVar2;
        this.w = a.PENDING;
    }

    private void g() {
        if (this.f9350c) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean h() {
        d dVar = this.f9354g;
        return dVar == null || dVar.c(this);
    }

    private boolean i() {
        d dVar = this.f9354g;
        return dVar == null || dVar.b(this);
    }

    private boolean j() {
        d dVar = this.f9354g;
        return dVar == null || dVar.d(this);
    }

    private Drawable k() {
        if (this.x == null) {
            this.x = this.f9359l.e();
            if (this.x == null && this.f9359l.d() > 0) {
                this.x = a(this.f9359l.d());
            }
        }
        return this.x;
    }

    private Drawable l() {
        if (this.z == null) {
            this.z = this.f9359l.f();
            if (this.z == null && this.f9359l.g() > 0) {
                this.z = a(this.f9359l.g());
            }
        }
        return this.z;
    }

    private Drawable m() {
        if (this.y == null) {
            this.y = this.f9359l.l();
            if (this.y == null && this.f9359l.m() > 0) {
                this.y = a(this.f9359l.m());
            }
        }
        return this.y;
    }

    private boolean n() {
        d dVar = this.f9354g;
        return dVar == null || !dVar.d();
    }

    private void o() {
        d dVar = this.f9354g;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    private void p() {
        d dVar = this.f9354g;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    private void q() {
        if (i()) {
            Drawable drawable = null;
            if (this.f9357j == null) {
                drawable = l();
            }
            if (drawable == null) {
                drawable = k();
            }
            if (drawable == null) {
                drawable = m();
            }
            this.p.onLoadFailed(drawable);
        }
    }

    public boolean c() {
        return this.w == a.FAILED;
    }

    public void clear() {
        io.intercom.com.bumptech.glide.h.j.b();
        g();
        this.f9352e.b();
        if (this.w != a.CLEARED) {
            f();
            E<R> e2 = this.t;
            if (e2 != null) {
                a(e2);
            }
            if (h()) {
                this.p.onLoadCleared(m());
            }
            this.w = a.CLEARED;
        }
    }

    public f d() {
        return this.f9352e;
    }

    public void e() {
        g();
        this.f9352e.b();
        this.v = io.intercom.com.bumptech.glide.h.d.a();
        if (this.f9357j == null) {
            if (io.intercom.com.bumptech.glide.h.j.b(this.m, this.n)) {
                this.A = this.m;
                this.B = this.n;
            }
            a(new GlideException("Received null model"), l() == null ? 5 : 3);
            return;
        }
        a aVar = this.w;
        if (aVar == a.RUNNING) {
            throw new IllegalArgumentException("Cannot restart a running request");
        } else if (aVar == a.COMPLETE) {
            a(this.t, io.intercom.com.bumptech.glide.load.a.MEMORY_CACHE);
        } else {
            this.w = a.WAITING_FOR_SIZE;
            if (io.intercom.com.bumptech.glide.h.j.b(this.m, this.n)) {
                a(this.m, this.n);
            } else {
                this.p.getSize(this);
            }
            a aVar2 = this.w;
            if ((aVar2 == a.RUNNING || aVar2 == a.WAITING_FOR_SIZE) && i()) {
                this.p.onLoadStarted(m());
            }
            if (f9349b) {
                StringBuilder sb = new StringBuilder();
                sb.append("finished run method in ");
                sb.append(io.intercom.com.bumptech.glide.h.d.a(this.v));
                a(sb.toString());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void f() {
        g();
        this.f9352e.b();
        this.p.removeCallback(this);
        this.w = a.CANCELLED;
        s.d dVar = this.u;
        if (dVar != null) {
            dVar.a();
            this.u = null;
        }
    }

    public boolean isCancelled() {
        a aVar = this.w;
        return aVar == a.CANCELLED || aVar == a.CLEARED;
    }

    public boolean isComplete() {
        return this.w == a.COMPLETE;
    }

    public boolean isRunning() {
        a aVar = this.w;
        return aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
    }

    public void pause() {
        clear();
        this.w = a.PAUSED;
    }

    public void a() {
        g();
        this.f9355h = null;
        this.f9356i = null;
        this.f9357j = null;
        this.f9358k = null;
        this.f9359l = null;
        this.m = -1;
        this.n = -1;
        this.p = null;
        this.q = null;
        this.f9353f = null;
        this.f9354g = null;
        this.s = null;
        this.u = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = -1;
        this.B = -1;
        f9348a.a(this);
    }

    public boolean b() {
        return isComplete();
    }

    private void a(E<?> e2) {
        this.r.b(e2);
        this.t = null;
    }

    private Drawable a(int i2) {
        return io.intercom.com.bumptech.glide.load.c.c.a.a(this.f9356i, i2, this.f9359l.r() != null ? this.f9359l.r() : this.f9355h.getTheme());
    }

    public void a(int i2, int i3) {
        this.f9352e.b();
        if (f9349b) {
            StringBuilder sb = new StringBuilder();
            sb.append("Got onSizeReady in ");
            sb.append(io.intercom.com.bumptech.glide.h.d.a(this.v));
            a(sb.toString());
        }
        if (this.w == a.WAITING_FOR_SIZE) {
            this.w = a.RUNNING;
            float q2 = this.f9359l.q();
            this.A = a(i2, q2);
            this.B = a(i3, q2);
            if (f9349b) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("finished setup for calling load in ");
                sb2.append(io.intercom.com.bumptech.glide.h.d.a(this.v));
                a(sb2.toString());
            }
            s sVar = this.r;
            e eVar = this.f9356i;
            s.d a2 = sVar.a(eVar, this.f9357j, this.f9359l.p(), this.A, this.B, this.f9359l.o(), this.f9358k, this.o, this.f9359l.c(), this.f9359l.s(), this.f9359l.C(), this.f9359l.x(), this.f9359l.i(), this.f9359l.v(), this.f9359l.u(), this.f9359l.t(), this.f9359l.h(), this);
            this.u = a2;
            if (this.w != a.RUNNING) {
                this.u = null;
            }
            if (f9349b) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("finished onSizeReady in ");
                sb3.append(io.intercom.com.bumptech.glide.h.d.a(this.v));
                a(sb3.toString());
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    public void a(E<?> e2, io.intercom.com.bumptech.glide.load.a aVar) {
        this.f9352e.b();
        this.u = null;
        if (e2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected to receive a Resource<R> with an object of ");
            sb.append(this.f9358k);
            sb.append(" inside, but instead got null.");
            a(new GlideException(sb.toString()));
            return;
        }
        Object obj = e2.get();
        if (obj == null || !this.f9358k.isAssignableFrom(obj.getClass())) {
            a(e2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected to receive an object of ");
            sb2.append(this.f9358k);
            sb2.append(" but instead got ");
            String str = "";
            sb2.append(obj != null ? obj.getClass() : str);
            sb2.append("{");
            sb2.append(obj);
            sb2.append("} inside Resource{");
            sb2.append(e2);
            sb2.append("}.");
            if (obj == null) {
                str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
            }
            sb2.append(str);
            a(new GlideException(sb2.toString()));
        } else if (!j()) {
            a(e2);
            this.w = a.COMPLETE;
        } else {
            a(e2, obj, aVar);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0092, code lost:
        if (r7.f9353f.onResourceReady(r9, r7.f9357j, r7.p, r10, r6) == false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x007f, code lost:
        if (r7.q.onResourceReady(r9, r7.f9357j, r7.p, r10, r6) == false) goto L_0x0081;
     */
    private void a(E<R> e2, R r2, io.intercom.com.bumptech.glide.load.a aVar) {
        boolean n2 = n();
        this.w = a.COMPLETE;
        this.t = e2;
        if (this.f9356i.d() <= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("Finished loading ");
            sb.append(r2.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(aVar);
            sb.append(" for ");
            sb.append(this.f9357j);
            sb.append(" with size [");
            sb.append(this.A);
            sb.append("x");
            sb.append(this.B);
            sb.append("] in ");
            sb.append(io.intercom.com.bumptech.glide.h.d.a(this.v));
            sb.append(" ms");
            Log.d("Glide", sb.toString());
        }
        this.f9350c = true;
        try {
            if (this.q != null) {
            }
            if (this.f9353f != null) {
            }
            this.p.onResourceReady(r2, this.s.a(aVar, n2));
            this.f9350c = false;
            p();
        } catch (Throwable th) {
            this.f9350c = false;
            throw th;
        }
    }

    public void a(GlideException glideException) {
        a(glideException, 5);
    }

    /* JADX INFO: finally extract failed */
    private void a(GlideException glideException, int i2) {
        this.f9352e.b();
        int d2 = this.f9356i.d();
        if (d2 <= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Load failed for ");
            sb.append(this.f9357j);
            sb.append(" with size [");
            sb.append(this.A);
            sb.append("x");
            sb.append(this.B);
            sb.append("]");
            String str = "Glide";
            Log.w(str, sb.toString(), glideException);
            if (d2 <= 4) {
                glideException.a(str);
            }
        }
        this.u = null;
        this.w = a.FAILED;
        this.f9350c = true;
        try {
            if ((this.q == null || !this.q.onLoadFailed(glideException, this.f9357j, this.p, n())) && (this.f9353f == null || !this.f9353f.onLoadFailed(glideException, this.f9357j, this.p, n()))) {
                q();
            }
            this.f9350c = false;
            o();
        } catch (Throwable th) {
            this.f9350c = false;
            throw th;
        }
    }

    public boolean a(c cVar) {
        if (!(cVar instanceof j)) {
            return false;
        }
        j jVar = (j) cVar;
        if (this.m != jVar.m || this.n != jVar.n || !io.intercom.com.bumptech.glide.h.j.a(this.f9357j, jVar.f9357j) || !this.f9358k.equals(jVar.f9358k) || !this.f9359l.equals(jVar.f9359l) || this.o != jVar.o) {
            return false;
        }
        if (this.q != null) {
            if (jVar.q == null) {
                return false;
            }
        } else if (jVar.q != null) {
            return false;
        }
        return true;
    }

    private void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.f9351d);
        Log.v("Request", sb.toString());
    }
}
