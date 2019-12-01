package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.f;
import io.fabric.sdk.android.o;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: PinningTrustManager */
class j implements X509TrustManager {

    /* renamed from: a reason: collision with root package name */
    private static final X509Certificate[] f9114a = new X509Certificate[0];

    /* renamed from: b reason: collision with root package name */
    private final TrustManager[] f9115b;

    /* renamed from: c reason: collision with root package name */
    private final k f9116c;

    /* renamed from: d reason: collision with root package name */
    private final long f9117d;

    /* renamed from: e reason: collision with root package name */
    private final List<byte[]> f9118e = new LinkedList();

    /* renamed from: f reason: collision with root package name */
    private final Set<X509Certificate> f9119f = Collections.synchronizedSet(new HashSet());

    public j(k kVar, i iVar) {
        this.f9115b = a(kVar);
        this.f9116c = kVar;
        this.f9117d = iVar.getPinCreationTimeInMillis();
        for (String a2 : iVar.getPins()) {
            this.f9118e.add(a(a2));
        }
    }

    private TrustManager[] a(k kVar) {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init(kVar.f9120a);
            return instance.getTrustManagers();
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        if (!this.f9119f.contains(x509CertificateArr[0])) {
            a(x509CertificateArr, str);
            a(x509CertificateArr);
            this.f9119f.add(x509CertificateArr[0]);
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return f9114a;
    }

    private boolean a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            for (byte[] equals : this.f9118e) {
                if (Arrays.equals(equals, digest)) {
                    return true;
                }
            }
            return false;
        } catch (NoSuchAlgorithmException e2) {
            throw new CertificateException(e2);
        }
    }

    private void a(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        for (TrustManager trustManager : this.f9115b) {
            ((X509TrustManager) trustManager).checkServerTrusted(x509CertificateArr, str);
        }
    }

    private void a(X509Certificate[] x509CertificateArr) throws CertificateException {
        if (this.f9117d == -1 || System.currentTimeMillis() - this.f9117d <= 15552000000L) {
            X509Certificate[] a2 = a.a(x509CertificateArr, this.f9116c);
            int length = a2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!a(a2[i2])) {
                    i2++;
                } else {
                    return;
                }
            }
            throw new CertificateException("No valid pins found in chain!");
        }
        o e2 = f.e();
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pins are stale, (");
        sb.append(System.currentTimeMillis() - this.f9117d);
        sb.append(" millis vs ");
        sb.append(15552000000L);
        sb.append(" millis) falling back to system trust.");
        e2.a("Fabric", sb.toString());
    }

    private byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i2 = 0; i2 < length; i2 += 2) {
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }
}
