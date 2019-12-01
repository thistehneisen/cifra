package i;

import i.B.a;
import i.a.e;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: i.e reason: case insensitive filesystem */
/* compiled from: Address */
public final class C0716e {

    /* renamed from: a reason: collision with root package name */
    final B f8671a;

    /* renamed from: b reason: collision with root package name */
    final v f8672b;

    /* renamed from: c reason: collision with root package name */
    final SocketFactory f8673c;

    /* renamed from: d reason: collision with root package name */
    final C0718g f8674d;

    /* renamed from: e reason: collision with root package name */
    final List<H> f8675e;

    /* renamed from: f reason: collision with root package name */
    final List<C0727p> f8676f;

    /* renamed from: g reason: collision with root package name */
    final ProxySelector f8677g;

    /* renamed from: h reason: collision with root package name */
    final Proxy f8678h;

    /* renamed from: i reason: collision with root package name */
    final SSLSocketFactory f8679i;

    /* renamed from: j reason: collision with root package name */
    final HostnameVerifier f8680j;

    /* renamed from: k reason: collision with root package name */
    final C0723l f8681k;

    public C0716e(String str, int i2, v vVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C0723l lVar, C0718g gVar, Proxy proxy, List<H> list, List<C0727p> list2, ProxySelector proxySelector) {
        a aVar = new a();
        aVar.d(sSLSocketFactory != null ? "https" : "http");
        aVar.b(str);
        aVar.a(i2);
        this.f8671a = aVar.a();
        if (vVar != null) {
            this.f8672b = vVar;
            if (socketFactory != null) {
                this.f8673c = socketFactory;
                if (gVar != null) {
                    this.f8674d = gVar;
                    if (list != null) {
                        this.f8675e = e.a(list);
                        if (list2 != null) {
                            this.f8676f = e.a(list2);
                            if (proxySelector != null) {
                                this.f8677g = proxySelector;
                                this.f8678h = proxy;
                                this.f8679i = sSLSocketFactory;
                                this.f8680j = hostnameVerifier;
                                this.f8681k = lVar;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public C0723l a() {
        return this.f8681k;
    }

    public List<C0727p> b() {
        return this.f8676f;
    }

    public v c() {
        return this.f8672b;
    }

    public HostnameVerifier d() {
        return this.f8680j;
    }

    public List<H> e() {
        return this.f8675e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0716e) {
            C0716e eVar = (C0716e) obj;
            if (this.f8671a.equals(eVar.f8671a) && a(eVar)) {
                return true;
            }
        }
        return false;
    }

    public Proxy f() {
        return this.f8678h;
    }

    public C0718g g() {
        return this.f8674d;
    }

    public ProxySelector h() {
        return this.f8677g;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f8671a.hashCode()) * 31) + this.f8672b.hashCode()) * 31) + this.f8674d.hashCode()) * 31) + this.f8675e.hashCode()) * 31) + this.f8676f.hashCode()) * 31) + this.f8677g.hashCode()) * 31) + Objects.hashCode(this.f8678h)) * 31) + Objects.hashCode(this.f8679i)) * 31) + Objects.hashCode(this.f8680j)) * 31) + Objects.hashCode(this.f8681k);
    }

    public SocketFactory i() {
        return this.f8673c;
    }

    public SSLSocketFactory j() {
        return this.f8679i;
    }

    public B k() {
        return this.f8671a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f8671a.g());
        sb.append(":");
        sb.append(this.f8671a.k());
        if (this.f8678h != null) {
            sb.append(", proxy=");
            sb.append(this.f8678h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f8677g);
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public boolean a(C0716e eVar) {
        return this.f8672b.equals(eVar.f8672b) && this.f8674d.equals(eVar.f8674d) && this.f8675e.equals(eVar.f8675e) && this.f8676f.equals(eVar.f8676f) && this.f8677g.equals(eVar.f8677g) && Objects.equals(this.f8678h, eVar.f8678h) && Objects.equals(this.f8679i, eVar.f8679i) && Objects.equals(this.f8680j, eVar.f8680j) && Objects.equals(this.f8681k, eVar.f8681k) && k().k() == eVar.k().k();
    }
}
