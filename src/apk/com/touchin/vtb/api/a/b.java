package com.touchin.vtb.api.a;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.e.b.h;

/* compiled from: SslMockUtils.kt */
public final class b implements X509TrustManager {
    b() {
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        h.b(x509CertificateArr, "chain");
        h.b(str, "authType");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        h.b(x509CertificateArr, "chain");
        h.b(str, "authType");
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
