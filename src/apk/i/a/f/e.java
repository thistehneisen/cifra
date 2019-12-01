package i.a.f;

import java.security.cert.X509Certificate;

/* compiled from: TrustRootIndex */
public interface e {
    X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate);
}
