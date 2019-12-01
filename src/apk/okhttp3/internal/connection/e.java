package okhttp3.internal.connection;

import i.C;
import i.C0716e;
import i.C0721j;
import i.C0725n;
import i.G;
import i.P;
import i.a.b.c;
import i.x;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import okhttp3.internal.connection.i.a;

/* compiled from: ExchangeFinder */
final class e {

    /* renamed from: a reason: collision with root package name */
    private final k f10476a;

    /* renamed from: b reason: collision with root package name */
    private final C0716e f10477b;

    /* renamed from: c reason: collision with root package name */
    private final g f10478c;

    /* renamed from: d reason: collision with root package name */
    private final C0721j f10479d;

    /* renamed from: e reason: collision with root package name */
    private final x f10480e;

    /* renamed from: f reason: collision with root package name */
    private a f10481f;

    /* renamed from: g reason: collision with root package name */
    private final i f10482g;

    /* renamed from: h reason: collision with root package name */
    private f f10483h;

    /* renamed from: i reason: collision with root package name */
    private boolean f10484i;

    e(k kVar, g gVar, C0716e eVar, C0721j jVar, x xVar) {
        this.f10476a = kVar;
        this.f10478c = gVar;
        this.f10477b = eVar;
        this.f10479d = jVar;
        this.f10480e = xVar;
        this.f10482g = new i(eVar, gVar.f10501f, jVar, xVar);
    }

    private boolean e() {
        f fVar = this.f10476a.f10523i;
        return fVar != null && fVar.f10495l == 0 && i.a.e.a(fVar.e().a().k(), this.f10477b.k());
    }

    public c a(G g2, C.a aVar, boolean z) {
        try {
            return a(aVar.connectTimeoutMillis(), aVar.readTimeoutMillis(), aVar.writeTimeoutMillis(), g2.q(), g2.w(), z).a(g2, aVar);
        } catch (RouteException e2) {
            d();
            throw e2;
        } catch (IOException e3) {
            d();
            throw new RouteException(e3);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean b() {
        boolean z;
        synchronized (this.f10478c) {
            if (!e() && (this.f10481f == null || !this.f10481f.b())) {
                if (!this.f10482g.a()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean c() {
        boolean z;
        synchronized (this.f10478c) {
            z = this.f10484i;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public void d() {
        synchronized (this.f10478c) {
            this.f10484i = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.a(r9) != false) goto L_0x0018;
     */
    private f a(int i2, int i3, int i4, int i5, boolean z, boolean z2) throws IOException {
        while (true) {
            f a2 = a(i2, i3, i4, i5, z);
            synchronized (this.f10478c) {
                if (a2.m == 0) {
                    return a2;
                }
            }
            a2.d();
        }
        while (true) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d7  */
    private f a(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        Socket socket;
        Socket g2;
        f fVar;
        f fVar2;
        P p;
        boolean z2;
        boolean z3;
        List list;
        synchronized (this.f10478c) {
            if (!this.f10476a.f()) {
                this.f10484i = false;
                socket = null;
                P e2 = e() ? this.f10476a.f10523i.e() : null;
                f fVar3 = this.f10476a.f10523i;
                g2 = (this.f10476a.f10523i == null || !this.f10476a.f10523i.f10494k) ? null : this.f10476a.g();
                if (this.f10476a.f10523i != null) {
                    fVar2 = this.f10476a.f10523i;
                    fVar = null;
                } else {
                    fVar = fVar3;
                    fVar2 = null;
                }
                if (fVar2 != null) {
                    p = null;
                } else if (this.f10478c.a(this.f10477b, this.f10476a, null, false)) {
                    fVar2 = this.f10476a.f10523i;
                    p = null;
                    z2 = true;
                } else {
                    p = e2;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        i.a.e.a(g2);
        if (fVar != null) {
            this.f10480e.b(this.f10479d, (C0725n) fVar);
        }
        if (z2) {
            this.f10480e.a(this.f10479d, (C0725n) fVar2);
        }
        if (fVar2 != null) {
            return fVar2;
        }
        if (p == null) {
            a aVar = this.f10481f;
            if (aVar == null || !aVar.b()) {
                this.f10481f = this.f10482g.b();
                z3 = true;
                synchronized (this.f10478c) {
                    if (!this.f10476a.f()) {
                        if (z3) {
                            list = this.f10481f.a();
                            if (this.f10478c.a(this.f10477b, this.f10476a, list, false)) {
                                fVar2 = this.f10476a.f10523i;
                                z2 = true;
                            }
                        } else {
                            list = null;
                        }
                        if (!z2) {
                            if (p == null) {
                                p = this.f10481f.c();
                            }
                            fVar2 = new f(this.f10478c, p);
                            this.f10483h = fVar2;
                        }
                    } else {
                        throw new IOException("Canceled");
                    }
                }
                if (!z2) {
                    this.f10480e.a(this.f10479d, (C0725n) fVar2);
                    return fVar2;
                }
                fVar2.a(i2, i3, i4, i5, z, this.f10479d, this.f10480e);
                this.f10478c.f10501f.a(fVar2.e());
                synchronized (this.f10478c) {
                    this.f10483h = null;
                    if (this.f10478c.a(this.f10477b, this.f10476a, list, true)) {
                        fVar2.f10494k = true;
                        socket = fVar2.f();
                        fVar2 = this.f10476a.f10523i;
                    } else {
                        this.f10478c.b(fVar2);
                        this.f10476a.a(fVar2);
                    }
                }
                i.a.e.a(socket);
                this.f10480e.a(this.f10479d, (C0725n) fVar2);
                return fVar2;
            }
        }
        z3 = false;
        synchronized (this.f10478c) {
        }
        if (!z2) {
        }
    }

    /* access modifiers changed from: 0000 */
    public f a() {
        return this.f10483h;
    }
}
