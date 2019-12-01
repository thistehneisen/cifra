package i;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: i.m reason: case insensitive filesystem */
/* compiled from: CipherSuite */
public final class C0724m {
    public static final C0724m A = a("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final C0724m Aa = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final C0724m B = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final C0724m Ba = a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final C0724m C = a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final C0724m Ca = a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final C0724m D = a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final C0724m Da = a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final C0724m E = a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final C0724m Ea = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final C0724m F = a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final C0724m Fa = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final C0724m G = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final C0724m Ga = a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final C0724m H = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final C0724m Ha = a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final C0724m I = a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final C0724m Ia = a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final C0724m J = a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final C0724m Ja = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final C0724m K = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final C0724m Ka = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final C0724m L = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final C0724m La = a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final C0724m M = a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final C0724m Ma = a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final C0724m N = a("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final C0724m Na = a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final C0724m O = a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final C0724m Oa = a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final C0724m P = a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final C0724m Pa = a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final C0724m Q = a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final C0724m Qa = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final C0724m R = a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final C0724m Ra = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final C0724m S = a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final C0724m Sa = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final C0724m T = a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final C0724m Ta = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final C0724m U = a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final C0724m Ua = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final C0724m V = a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final C0724m Va = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final C0724m W = a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final C0724m Wa = a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final C0724m X = a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final C0724m Xa = a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final C0724m Y = a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final C0724m Ya = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final C0724m Z = a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final C0724m Za = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final C0724m _a = a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* renamed from: a reason: collision with root package name */
    static final Comparator<String> f8712a = C0713b.f8668a;
    public static final C0724m aa = a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final C0724m ab = a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* renamed from: b reason: collision with root package name */
    private static final Map<String, C0724m> f8713b = new LinkedHashMap();
    public static final C0724m ba = a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final C0724m bb = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: c reason: collision with root package name */
    public static final C0724m f8714c = a("SSL_RSA_WITH_NULL_MD5", 1);
    public static final C0724m ca = a("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final C0724m cb = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* renamed from: d reason: collision with root package name */
    public static final C0724m f8715d = a("SSL_RSA_WITH_NULL_SHA", 2);
    public static final C0724m da = a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final C0724m db = a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* renamed from: e reason: collision with root package name */
    public static final C0724m f8716e = a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final C0724m ea = a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final C0724m eb = a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* renamed from: f reason: collision with root package name */
    public static final C0724m f8717f = a("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final C0724m fa = a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final C0724m fb = a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* renamed from: g reason: collision with root package name */
    public static final C0724m f8718g = a("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final C0724m ga = a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final C0724m gb = a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* renamed from: h reason: collision with root package name */
    public static final C0724m f8719h = a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final C0724m ha = a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final C0724m hb = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: i reason: collision with root package name */
    public static final C0724m f8720i = a("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final C0724m ia = a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final C0724m ib = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: j reason: collision with root package name */
    public static final C0724m f8721j = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final C0724m ja = a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final C0724m jb = a("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* renamed from: k reason: collision with root package name */
    public static final C0724m f8722k = a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final C0724m ka = a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final C0724m kb = a("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* renamed from: l reason: collision with root package name */
    public static final C0724m f8723l = a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final C0724m la = a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final C0724m lb = a("TLS_AES_128_GCM_SHA256", 4865);
    public static final C0724m m = a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final C0724m ma = a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final C0724m mb = a("TLS_AES_256_GCM_SHA384", 4866);
    public static final C0724m n = a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final C0724m na = a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final C0724m nb = a("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final C0724m o = a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final C0724m oa = a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final C0724m ob = a("TLS_AES_128_CCM_SHA256", 4868);
    public static final C0724m p = a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final C0724m pa = a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final C0724m pb = a("TLS_AES_128_CCM_8_SHA256", 4869);
    public static final C0724m q = a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final C0724m qa = a("TLS_FALLBACK_SCSV", 22016);
    public static final C0724m r = a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final C0724m ra = a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final C0724m s = a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final C0724m sa = a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final C0724m t = a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final C0724m ta = a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final C0724m u = a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final C0724m ua = a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final C0724m v = a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final C0724m va = a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final C0724m w = a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final C0724m wa = a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final C0724m x = a("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final C0724m xa = a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final C0724m y = a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final C0724m ya = a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final C0724m z = a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final C0724m za = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    final String qb;

    private C0724m(String str) {
        if (str != null) {
            this.qb = str;
            return;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ int a(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        int i2 = 4;
        while (true) {
            int i3 = -1;
            if (i2 < min) {
                char charAt = str.charAt(i2);
                char charAt2 = str2.charAt(i2);
                if (charAt != charAt2) {
                    if (charAt >= charAt2) {
                        i3 = 1;
                    }
                    return i3;
                }
                i2++;
            } else {
                int length = str.length();
                int length2 = str2.length();
                if (length == length2) {
                    return 0;
                }
                if (length >= length2) {
                    i3 = 1;
                }
                return i3;
            }
        }
    }

    private static String b(String str) {
        String str2 = "TLS_";
        String str3 = "SSL_";
        if (str.startsWith(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append(str.substring(4));
            return sb.toString();
        }
        if (str.startsWith(str3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(str.substring(4));
            str = sb2.toString();
        }
        return str;
    }

    public String toString() {
        return this.qb;
    }

    public static synchronized C0724m a(String str) {
        C0724m mVar;
        synchronized (C0724m.class) {
            mVar = (C0724m) f8713b.get(str);
            if (mVar == null) {
                mVar = (C0724m) f8713b.get(b(str));
                if (mVar == null) {
                    mVar = new C0724m(str);
                }
                f8713b.put(str, mVar);
            }
        }
        return mVar;
    }

    static List<C0724m> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String a2 : strArr) {
            arrayList.add(a(a2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static C0724m a(String str, int i2) {
        C0724m mVar = new C0724m(str);
        f8713b.put(str, mVar);
        return mVar;
    }
}
