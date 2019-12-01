package i;

import i.a.e;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake */
public final class z {

    /* renamed from: a reason: collision with root package name */
    private final Q f8776a;

    /* renamed from: b reason: collision with root package name */
    private final C0724m f8777b;

    /* renamed from: c reason: collision with root package name */
    private final List<Certificate> f8778c;

    /* renamed from: d reason: collision with root package name */
    private final List<Certificate> f8779d;

    private z(Q q, C0724m mVar, List<Certificate> list, List<Certificate> list2) {
        this.f8776a = q;
        this.f8777b = mVar;
        this.f8778c = list;
        this.f8779d = list2;
    }

    public static z a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            C0724m a2 = C0724m.a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!"NONE".equals(protocol)) {
                Q a3 = Q.a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = e.a((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = e.a((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new z(a3, a2, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public List<Certificate> b() {
        return this.f8778c;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (this.f8776a.equals(zVar.f8776a) && this.f8777b.equals(zVar.f8777b) && this.f8778c.equals(zVar.f8778c) && this.f8779d.equals(zVar.f8779d)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return ((((((527 + this.f8776a.hashCode()) * 31) + this.f8777b.hashCode()) * 31) + this.f8778c.hashCode()) * 31) + this.f8779d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{tlsVersion=");
        sb.append(this.f8776a);
        sb.append(" cipherSuite=");
        sb.append(this.f8777b);
        sb.append(" peerCertificates=");
        sb.append(a(this.f8778c));
        sb.append(" localCertificates=");
        sb.append(a(this.f8779d));
        sb.append('}');
        return sb.toString();
    }

    public C0724m a() {
        return this.f8777b;
    }

    private List<String> a(List<Certificate> list) {
        ArrayList arrayList = new ArrayList();
        for (Certificate certificate : list) {
            if (certificate instanceof X509Certificate) {
                arrayList.add(String.valueOf(((X509Certificate) certificate).getSubjectDN()));
            } else {
                arrayList.add(certificate.getType());
            }
        }
        return arrayList;
    }
}
