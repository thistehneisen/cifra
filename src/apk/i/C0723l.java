package i;

import i.a.f.c;
import j.i;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: i.l reason: case insensitive filesystem */
/* compiled from: CertificatePinner */
public final class C0723l {

    /* renamed from: a reason: collision with root package name */
    public static final C0723l f8704a = new a().a();

    /* renamed from: b reason: collision with root package name */
    private final Set<b> f8705b;

    /* renamed from: c reason: collision with root package name */
    private final c f8706c;

    /* renamed from: i.l$a */
    /* compiled from: CertificatePinner */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final List<b> f8707a = new ArrayList();

        public a a(String str, String... strArr) {
            if (str != null) {
                for (String bVar : strArr) {
                    this.f8707a.add(new b(str, bVar));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public C0723l a() {
            return new C0723l(new LinkedHashSet(this.f8707a), null);
        }
    }

    /* renamed from: i.l$b */
    /* compiled from: CertificatePinner */
    static final class b {

        /* renamed from: a reason: collision with root package name */
        final String f8708a;

        /* renamed from: b reason: collision with root package name */
        final String f8709b;

        /* renamed from: c reason: collision with root package name */
        final String f8710c;

        /* renamed from: d reason: collision with root package name */
        final i f8711d;

        b(String str, String str2) {
            String str3;
            this.f8708a = str;
            String str4 = "http://";
            if (str.startsWith("*.")) {
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                sb.append(str.substring(2));
                str3 = B.b(sb.toString()).g();
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str4);
                sb2.append(str);
                str3 = B.b(sb2.toString()).g();
            }
            this.f8709b = str3;
            String str5 = "sha1/";
            if (str2.startsWith(str5)) {
                this.f8710c = str5;
                this.f8711d = i.a(str2.substring(5));
            } else {
                String str6 = "sha256/";
                if (str2.startsWith(str6)) {
                    this.f8710c = str6;
                    this.f8711d = i.a(str2.substring(7));
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("pins must start with 'sha256/' or 'sha1/': ");
                    sb3.append(str2);
                    throw new IllegalArgumentException(sb3.toString());
                }
            }
            if (this.f8711d == null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("pins must be base64: ");
                sb4.append(str2);
                throw new IllegalArgumentException(sb4.toString());
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x002e, code lost:
            if (r11.regionMatches(false, r6, r7, 0, r7.length()) != false) goto L_0x0032;
         */
        public boolean a(String str) {
            if (!this.f8708a.startsWith("*.")) {
                return str.equals(this.f8709b);
            }
            int indexOf = str.indexOf(46);
            boolean z = true;
            if ((str.length() - indexOf) - 1 == this.f8709b.length()) {
                int i2 = indexOf + 1;
                String str2 = this.f8709b;
            }
            z = false;
            return z;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f8708a.equals(bVar.f8708a) && this.f8710c.equals(bVar.f8710c) && this.f8711d.equals(bVar.f8711d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f8708a.hashCode()) * 31) + this.f8710c.hashCode()) * 31) + this.f8711d.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f8710c);
            sb.append(this.f8711d.a());
            return sb.toString();
        }
    }

    C0723l(Set<b> set, c cVar) {
        this.f8705b = set;
        this.f8706c = cVar;
    }

    static i b(X509Certificate x509Certificate) {
        return i.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        String str2;
        List a2 = a(str);
        if (!a2.isEmpty()) {
            c cVar = this.f8706c;
            if (cVar != null) {
                list = cVar.a(list, str);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i2);
                int size2 = a2.size();
                i iVar = null;
                i iVar2 = null;
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = (b) a2.get(i3);
                    if (bVar.f8710c.equals("sha256/")) {
                        if (iVar == null) {
                            iVar = b(x509Certificate);
                        }
                        if (bVar.f8711d.equals(iVar)) {
                            return;
                        }
                    } else if (bVar.f8710c.equals("sha1/")) {
                        if (iVar2 == null) {
                            iVar2 = a(x509Certificate);
                        }
                        if (bVar.f8711d.equals(iVar2)) {
                            return;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unsupported hashAlgorithm: ");
                        sb.append(bVar.f8710c);
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
                sb2.append(a((Certificate) x509Certificate2));
                sb2.append(": ");
                sb2.append(x509Certificate2.getSubjectDN().getName());
                i4++;
            }
            sb2.append("\n  Pinned certificates for ");
            sb2.append(str);
            sb2.append(":");
            int size4 = a2.size();
            for (int i5 = 0; i5 < size4; i5++) {
                b bVar2 = (b) a2.get(i5);
                sb2.append(str2);
                sb2.append(bVar2);
            }
            throw new SSLPeerUnverifiedException(sb2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r3.f8705b.equals(r4.f8705b) != false) goto L_0x0020;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0723l) {
            C0723l lVar = (C0723l) obj;
            if (Objects.equals(this.f8706c, lVar.f8706c)) {
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        return (Objects.hashCode(this.f8706c) * 31) + this.f8705b.hashCode();
    }

    /* access modifiers changed from: 0000 */
    public List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f8705b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: 0000 */
    public C0723l a(c cVar) {
        if (Objects.equals(this.f8706c, cVar)) {
            return this;
        }
        return new C0723l(this.f8705b, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            StringBuilder sb = new StringBuilder();
            sb.append("sha256/");
            sb.append(b((X509Certificate) certificate).a());
            return sb.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static i a(X509Certificate x509Certificate) {
        return i.a(x509Certificate.getPublicKey().getEncoded()).c();
    }
}
