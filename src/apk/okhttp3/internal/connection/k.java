package okhttp3.internal.connection;

import i.B;
import i.C0716e;
import i.C0721j;
import i.C0723l;
import i.C0725n;
import i.G;
import i.J;
import i.a.c;
import i.a.d.e;
import i.x;
import j.C0790c;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Transmitter */
public final class k {

    /* renamed from: a reason: collision with root package name */
    private final G f10515a;

    /* renamed from: b reason: collision with root package name */
    private final g f10516b;

    /* renamed from: c reason: collision with root package name */
    private final C0721j f10517c;

    /* renamed from: d reason: collision with root package name */
    private final x f10518d;

    /* renamed from: e reason: collision with root package name */
    private final C0790c f10519e = new j(this);

    /* renamed from: f reason: collision with root package name */
    private Object f10520f;

    /* renamed from: g reason: collision with root package name */
    private J f10521g;

    /* renamed from: h reason: collision with root package name */
    private e f10522h;

    /* renamed from: i reason: collision with root package name */
    public f f10523i;

    /* renamed from: j reason: collision with root package name */
    private d f10524j;

    /* renamed from: k reason: collision with root package name */
    private boolean f10525k;

    /* renamed from: l reason: collision with root package name */
    private boolean f10526l;
    private boolean m;
    private boolean n;
    private boolean o;

    /* compiled from: Transmitter */
    static final class a extends WeakReference<k> {

        /* renamed from: a reason: collision with root package name */
        final Object f10527a;

        a(k kVar, Object obj) {
            super(kVar);
            this.f10527a = obj;
        }
    }

    public k(G g2, C0721j jVar) {
        this.f10515a = g2;
        this.f10516b = c.f8601a.a(g2.e());
        this.f10517c = jVar;
        this.f10518d = g2.j().a(jVar);
        this.f10519e.a((long) g2.b(), TimeUnit.MILLISECONDS);
    }

    private IOException b(IOException iOException) {
        if (this.n || !this.f10519e.i()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void a() {
        this.f10520f = e.a().a("response.body().close()");
        this.f10518d.b(this.f10517c);
    }

    public void c() {
        d dVar;
        f fVar;
        synchronized (this.f10516b) {
            this.m = true;
            dVar = this.f10524j;
            if (this.f10522h == null || this.f10522h.a() == null) {
                fVar = this.f10523i;
            } else {
                fVar = this.f10522h.a();
            }
        }
        if (dVar != null) {
            dVar.a();
        } else if (fVar != null) {
            fVar.a();
        }
    }

    public void d() {
        synchronized (this.f10516b) {
            if (!this.o) {
                this.f10524j = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public boolean e() {
        boolean z;
        synchronized (this.f10516b) {
            z = this.f10524j != null;
        }
        return z;
    }

    public boolean f() {
        boolean z;
        synchronized (this.f10516b) {
            z = this.m;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public Socket g() {
        int i2 = 0;
        int size = this.f10523i.p.size();
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((Reference) this.f10523i.p.get(i2)).get() == this) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            f fVar = this.f10523i;
            fVar.p.remove(i2);
            this.f10523i = null;
            if (!fVar.p.isEmpty()) {
                return null;
            }
            fVar.q = System.nanoTime();
            if (this.f10516b.a(fVar)) {
                return fVar.f();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public void h() {
        if (!this.n) {
            this.n = true;
            this.f10519e.i();
            return;
        }
        throw new IllegalStateException();
    }

    public void i() {
        this.f10519e.h();
    }

    public void a(J j2) {
        J j3 = this.f10521g;
        if (j3 != null) {
            if (i.a.e.a(j3.g(), j2.g()) && this.f10522h.b()) {
                return;
            }
            if (this.f10524j != null) {
                throw new IllegalStateException();
            } else if (this.f10522h != null) {
                a((IOException) null, true);
                this.f10522h = null;
            }
        }
        this.f10521g = j2;
        e eVar = new e(this, this.f10516b, a(j2.g()), this.f10517c, this.f10518d);
        this.f10522h = eVar;
    }

    public boolean b() {
        return this.f10522h.c() && this.f10522h.b();
    }

    private C0716e a(B b2) {
        C0723l lVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (b2.h()) {
            SSLSocketFactory B = this.f10515a.B();
            hostnameVerifier = this.f10515a.m();
            sSLSocketFactory = B;
            lVar = this.f10515a.c();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            lVar = null;
        }
        C0716e eVar = new C0716e(b2.g(), b2.k(), this.f10515a.i(), this.f10515a.x(), sSLSocketFactory, hostnameVerifier, lVar, this.f10515a.t(), this.f10515a.s(), this.f10515a.r(), this.f10515a.f(), this.f10515a.u());
        return eVar;
    }

    /* access modifiers changed from: 0000 */
    public d a(i.C.a aVar, boolean z) {
        synchronized (this.f10516b) {
            if (this.o) {
                throw new IllegalStateException("released");
            } else if (this.f10524j != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        d dVar = new d(this, this.f10517c, this.f10518d, this.f10522h, this.f10522h.a(this.f10515a, aVar, z));
        synchronized (this.f10516b) {
            this.f10524j = dVar;
            this.f10525k = false;
            this.f10526l = false;
        }
        return dVar;
    }

    /* access modifiers changed from: 0000 */
    public void a(f fVar) {
        if (this.f10523i == null) {
            this.f10523i = fVar;
            fVar.p.add(new a(this, this.f10520f));
            return;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        r6 = a(r6, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003e, code lost:
        return r6;
     */
    public IOException a(d dVar, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        synchronized (this.f10516b) {
            if (dVar != this.f10524j) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.f10525k;
                this.f10525k = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.f10526l) {
                    z3 = true;
                }
                this.f10526l = true;
            }
            if (!this.f10525k || !this.f10526l || !z3) {
                z4 = false;
            } else {
                f b2 = this.f10524j.b();
                b2.m++;
                this.f10524j = null;
            }
        }
    }

    public IOException a(IOException iOException) {
        synchronized (this.f10516b) {
            this.o = true;
        }
        return a(iOException, false);
    }

    private IOException a(IOException iOException, boolean z) {
        f fVar;
        Socket g2;
        boolean z2;
        boolean z3;
        synchronized (this.f10516b) {
            if (z) {
                if (this.f10524j != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            fVar = this.f10523i;
            g2 = (this.f10523i == null || this.f10524j != null || (!z && !this.o)) ? null : g();
            if (this.f10523i != null) {
                fVar = null;
            }
            z2 = true;
            z3 = this.o && this.f10524j == null;
        }
        i.a.e.a(g2);
        if (fVar != null) {
            this.f10518d.b(this.f10517c, (C0725n) fVar);
        }
        if (z3) {
            if (iOException == null) {
                z2 = false;
            }
            iOException = b(iOException);
            if (z2) {
                this.f10518d.a(this.f10517c, iOException);
            } else {
                this.f10518d.a(this.f10517c);
            }
        }
        return iOException;
    }
}
