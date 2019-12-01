package i;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* compiled from: Route */
public final class P {

    /* renamed from: a reason: collision with root package name */
    final C0716e f8544a;

    /* renamed from: b reason: collision with root package name */
    final Proxy f8545b;

    /* renamed from: c reason: collision with root package name */
    final InetSocketAddress f8546c;

    public P(C0716e eVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (eVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f8544a = eVar;
            this.f8545b = proxy;
            this.f8546c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public C0716e a() {
        return this.f8544a;
    }

    public Proxy b() {
        return this.f8545b;
    }

    public boolean c() {
        return this.f8544a.f8679i != null && this.f8545b.type() == Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f8546c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof P) {
            P p = (P) obj;
            if (p.f8544a.equals(this.f8544a) && p.f8545b.equals(this.f8545b) && p.f8546c.equals(this.f8546c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f8544a.hashCode()) * 31) + this.f8545b.hashCode()) * 31) + this.f8546c.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Route{");
        sb.append(this.f8546c);
        sb.append("}");
        return sb.toString();
    }
}
