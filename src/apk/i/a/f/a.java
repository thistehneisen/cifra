package i.a.f;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: BasicCertificateChainCleaner */
public final class a extends c {

    /* renamed from: a reason: collision with root package name */
    private final e f8665a;

    public a(e eVar) {
        this.f8665a = eVar;
    }

    public List<Certificate> a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add((Certificate) arrayDeque.removeFirst());
        boolean z = false;
        for (int i2 = 0; i2 < 9; i2++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate findByIssuerAndSignature = this.f8665a.findByIssuerAndSignature(x509Certificate);
            if (findByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals(findByIssuerAndSignature)) {
                    arrayList.add(findByIssuerAndSignature);
                }
                if (a(findByIssuerAndSignature, findByIssuerAndSignature)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (a(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Failed to find a trusted cert that signed ");
                sb.append(x509Certificate);
                throw new SSLPeerUnverifiedException(sb.toString());
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Certificate chain too long: ");
        sb2.append(arrayList);
        throw new SSLPeerUnverifiedException(sb2.toString());
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a) || !((a) obj).f8665a.equals(this.f8665a)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.f8665a.hashCode();
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
