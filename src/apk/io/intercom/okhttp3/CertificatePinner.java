package io.intercom.okhttp3;

import e.a.b.j;
import io.intercom.okhttp3.internal.Util;
import io.intercom.okhttp3.internal.tls.CertificateChainCleaner;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                for (String pin : strArr) {
                    this.pins.add(new Pin(str, pin));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), null);
        }
    }

    static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final j hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String str, String str2) {
            String str3;
            this.pattern = str;
            String str4 = "http://";
            if (str.startsWith(WILDCARD)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str.substring(2));
                str3 = HttpUrl.get(sb.toString()).host();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(str);
                str3 = HttpUrl.get(sb2.toString()).host();
            }
            this.canonicalHostname = str3;
            String str5 = "sha1/";
            if (str2.startsWith(str5)) {
                this.hashAlgorithm = str5;
                this.hash = j.a(str2.substring(5));
            } else {
                String str6 = "sha256/";
                if (str2.startsWith(str6)) {
                    this.hashAlgorithm = str6;
                    this.hash = j.a(str2.substring(7));
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("pins must start with 'sha256/' or 'sha1/': ");
                    sb3.append(str2);
                    throw new IllegalArgumentException(sb3.toString());
                }
            }
            if (this.hash == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("pins must be base64: ");
                sb4.append(str2);
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                if (this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
            if (r11.regionMatches(false, r6, r7, 0, r7.length()) != false) goto L_0x0032;
         */
        public boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            int indexOf = str.indexOf(46);
            boolean z = true;
            if ((str.length() - indexOf) - 1 == this.canonicalHostname.length()) {
                int i2 = indexOf + 1;
                String str2 = this.canonicalHostname;
            }
            z = false;
            return z;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.hashAlgorithm);
            sb.append(this.hash.a());
            return sb.toString();
        }
    }

    CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner2) {
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            sb.append(sha256((X509Certificate) certificate).a());
            return sb.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static j sha1(X509Certificate x509Certificate) {
        return j.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    static j sha256(X509Certificate x509Certificate) {
        return j.a(x509Certificate.getPublicKey().getEncoded()).e();
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        String str2;
        List findMatchingPins = findMatchingPins(str);
        if (!findMatchingPins.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
            if (certificateChainCleaner2 != null) {
                list = certificateChainCleaner2.clean(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = findMatchingPins.size();
                j jVar = null;
                j jVar2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    Pin pin = (Pin) findMatchingPins.get(i3);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (jVar == null) {
                            jVar = sha256(x509Certificate);
                        }
                        if (pin.hash.equals(jVar)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (jVar2 == null) {
                            jVar2 = sha1(x509Certificate);
                        }
                        if (pin.hash.equals(jVar2)) {
                            return;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unsupported hashAlgorithm: ");
                        sb.append(pin.hashAlgorithm);
                        throw new AssertionError(sb.toString());
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Certificate pinning failure!");
            sb2.append("\n  Peer certificate chain:");
            int size3 = list.size();
            int i4 = 0;
            while (true) {
                str2 = "\n    ";
                if (i4 >= size3) {
                    break;
                }
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i4);
                sb2.append(str2);
                sb2.append(pin(x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
                i4++;
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            int size4 = findMatchingPins.size();
            for (int i5 = 0; i5 < size4; i5++) {
                Pin pin2 = (Pin) findMatchingPins.get(i5);
                sb2.append(str2);
                sb2.append(pin2);
            }
            throw new SSLPeerUnverifiedException(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r3.pins.equals(r4.pins) != false) goto L_0x0020;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (Util.equal(this.certificateChainCleaner, certificatePinner.certificateChainCleaner)) {
            }
        }
        z = false;
        return z;
    }

    /* access modifiers changed from: 0000 */
    public List<Pin> findMatchingPins(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin pin : this.pins) {
            if (pin.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(pin);
            }
        }
        return emptyList;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner2 = this.certificateChainCleaner;
        return ((certificateChainCleaner2 != null ? certificateChainCleaner2.hashCode() : 0) * 31) + this.pins.hashCode();
    }

    /* access modifiers changed from: 0000 */
    public CertificatePinner withCertificateChainCleaner(CertificateChainCleaner certificateChainCleaner2) {
        if (Util.equal(this.certificateChainCleaner, certificateChainCleaner2)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner2);
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, Arrays.asList(certificateArr));
    }
}
