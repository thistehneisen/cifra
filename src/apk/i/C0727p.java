package i;

import i.a.e;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* renamed from: i.p reason: case insensitive filesystem */
/* compiled from: ConnectionSpec */
public final class C0727p {

    /* renamed from: a reason: collision with root package name */
    private static final C0724m[] f8725a = {C0724m.lb, C0724m.mb, C0724m.nb, C0724m.Ya, C0724m.bb, C0724m.Za, C0724m.cb, C0724m.ib, C0724m.hb};

    /* renamed from: b reason: collision with root package name */
    private static final C0724m[] f8726b = {C0724m.lb, C0724m.mb, C0724m.nb, C0724m.Ya, C0724m.bb, C0724m.Za, C0724m.cb, C0724m.ib, C0724m.hb, C0724m.Ja, C0724m.Ka, C0724m.ha, C0724m.ia, C0724m.F, C0724m.J, C0724m.f8721j};

    /* renamed from: c reason: collision with root package name */
    public static final C0727p f8727c;

    /* renamed from: d reason: collision with root package name */
    public static final C0727p f8728d;

    /* renamed from: e reason: collision with root package name */
    public static final C0727p f8729e;

    /* renamed from: f reason: collision with root package name */
    public static final C0727p f8730f = new a(false).a();

    /* renamed from: g reason: collision with root package name */
    final boolean f8731g;

    /* renamed from: h reason: collision with root package name */
    final boolean f8732h;

    /* renamed from: i reason: collision with root package name */
    final String[] f8733i;

    /* renamed from: j reason: collision with root package name */
    final String[] f8734j;

    /* renamed from: i.p$a */
    /* compiled from: ConnectionSpec */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        boolean f8735a;

        /* renamed from: b reason: collision with root package name */
        String[] f8736b;

        /* renamed from: c reason: collision with root package name */
        String[] f8737c;

        /* renamed from: d reason: collision with root package name */
        boolean f8738d;

        a(boolean z) {
            this.f8735a = z;
        }

        public a a(C0724m... mVarArr) {
            if (this.f8735a) {
                String[] strArr = new String[mVarArr.length];
                for (int i2 = 0; i2 < mVarArr.length; i2++) {
                    strArr[i2] = mVarArr[i2].qb;
                }
                a(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (!this.f8735a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f8737c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public a(C0727p pVar) {
            this.f8735a = pVar.f8731g;
            this.f8736b = pVar.f8733i;
            this.f8737c = pVar.f8734j;
            this.f8738d = pVar.f8732h;
        }

        public a a(String... strArr) {
            if (!this.f8735a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f8736b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a a(Q... qArr) {
            if (this.f8735a) {
                String[] strArr = new String[qArr.length];
                for (int i2 = 0; i2 < qArr.length; i2++) {
                    strArr[i2] = qArr[i2].javaName;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f8735a) {
                this.f8738d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C0727p a() {
            return new C0727p(this);
        }
    }

    static {
        a aVar = new a(true);
        aVar.a(f8725a);
        aVar.a(Q.TLS_1_3, Q.TLS_1_2);
        aVar.a(true);
        f8727c = aVar.a();
        a aVar2 = new a(true);
        aVar2.a(f8726b);
        aVar2.a(Q.TLS_1_3, Q.TLS_1_2);
        aVar2.a(true);
        f8728d = aVar2.a();
        a aVar3 = new a(true);
        aVar3.a(f8726b);
        aVar3.a(Q.TLS_1_3, Q.TLS_1_2, Q.TLS_1_1, Q.TLS_1_0);
        aVar3.a(true);
        f8729e = aVar3.a();
    }

    C0727p(a aVar) {
        this.f8731g = aVar.f8735a;
        this.f8733i = aVar.f8736b;
        this.f8734j = aVar.f8737c;
        this.f8732h = aVar.f8738d;
    }

    public List<C0724m> a() {
        String[] strArr = this.f8733i;
        if (strArr != null) {
            return C0724m.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.f8731g;
    }

    public boolean c() {
        return this.f8732h;
    }

    public List<Q> d() {
        String[] strArr = this.f8734j;
        if (strArr != null) {
            return Q.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0727p)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C0727p pVar = (C0727p) obj;
        boolean z = this.f8731g;
        if (z != pVar.f8731g) {
            return false;
        }
        return !z || (Arrays.equals(this.f8733i, pVar.f8733i) && Arrays.equals(this.f8734j, pVar.f8734j) && this.f8732h == pVar.f8732h);
    }

    public int hashCode() {
        if (this.f8731g) {
            return ((((527 + Arrays.hashCode(this.f8733i)) * 31) + Arrays.hashCode(this.f8734j)) * 31) + (this.f8732h ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f8731g) {
            return "ConnectionSpec()";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ConnectionSpec(cipherSuites=");
        String str = "[all enabled]";
        sb.append(Objects.toString(a(), str));
        sb.append(", tlsVersions=");
        sb.append(Objects.toString(d(), str));
        sb.append(", supportsTlsExtensions=");
        sb.append(this.f8732h);
        sb.append(")");
        return sb.toString();
    }

    private C0727p b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f8733i != null) {
            strArr = e.a(C0724m.f8712a, sSLSocket.getEnabledCipherSuites(), this.f8733i);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f8734j != null) {
            strArr2 = e.a(e.f8662j, sSLSocket.getEnabledProtocols(), this.f8734j);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a2 = e.a(C0724m.f8712a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a2 != -1) {
            strArr = e.a(strArr, supportedCipherSuites[a2]);
        }
        a aVar = new a(this);
        aVar.a(strArr);
        aVar.b(strArr2);
        return aVar.a();
    }

    /* access modifiers changed from: 0000 */
    public void a(SSLSocket sSLSocket, boolean z) {
        C0727p b2 = b(sSLSocket, z);
        String[] strArr = b2.f8734j;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f8733i;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f8731g) {
            return false;
        }
        String[] strArr = this.f8734j;
        if (strArr != null && !e.b(e.f8662j, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f8733i;
        if (strArr2 == null || e.b(C0724m.f8712a, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }
}
