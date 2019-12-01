package i.a.f;

import i.a.d.e;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* compiled from: CertificateChainCleaner */
public abstract class c {
    public static c a(X509TrustManager x509TrustManager) {
        return e.a().a(x509TrustManager);
    }

    public abstract List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
