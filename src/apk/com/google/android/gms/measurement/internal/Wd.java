package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.f;
import com.google.android.gms.common.g;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.sf;
import io.fabric.sdk.android.a.c.c;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class Wd extends C0528jc {

    /* renamed from: c reason: collision with root package name */
    private static final String[] f5754c = {"firebase_", "google_", "ga_"};

    /* renamed from: d reason: collision with root package name */
    private static final List<String> f5755d = Collections.unmodifiableList(Arrays.asList(new String[]{"source", "medium", "campaign", "term", "content"}));

    /* renamed from: e reason: collision with root package name */
    private SecureRandom f5756e;

    /* renamed from: f reason: collision with root package name */
    private final AtomicLong f5757f = new AtomicLong(0);

    /* renamed from: g reason: collision with root package name */
    private int f5758g;

    /* renamed from: h reason: collision with root package name */
    private Integer f5759h = null;

    Wd(Ob ob) {
        super(ob);
    }

    static boolean a(String str) {
        q.b(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(c.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    private static boolean g(String str) {
        q.a(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static int h(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        return "_id".equals(str) ? 256 : 36;
    }

    static MessageDigest t() {
        int i2 = 0;
        while (i2 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i2++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final boolean b(String str, String str2) {
        if (str2 == null) {
            e().v().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            e().v().a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                e().v().a("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    e().v().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean c(String str, String str2) {
        if (str2 == null) {
            e().v().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            e().v().a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        e().v().a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            e().v().a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean d(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!g(str)) {
                if (this.f5987a.m()) {
                    e().v().a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C0532kb.a(str));
                }
                return false;
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (this.f5987a.m()) {
                e().v().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (!g(str2)) {
            e().v().a("Invalid admob_app_id. Analytics disabled.", C0532kb.a(str2));
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String v = g().v();
        b();
        return v.equals(str);
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ C0495d k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ C0522ib l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ Wd m() {
        return super.m();
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void s() {
        j();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                e().w().a("Utils falling back to Random for random id");
            }
        }
        this.f5757f.set(nextLong);
    }

    public final long u() {
        long andIncrement;
        long j2;
        if (this.f5757f.get() == 0) {
            synchronized (this.f5757f) {
                long nextLong = new Random(System.nanoTime() ^ c().currentTimeMillis()).nextLong();
                int i2 = this.f5758g + 1;
                this.f5758g = i2;
                j2 = nextLong + ((long) i2);
            }
            return j2;
        }
        synchronized (this.f5757f) {
            this.f5757f.compareAndSet(-1, 1);
            andIncrement = this.f5757f.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: 0000 */
    public final SecureRandom v() {
        j();
        if (this.f5756e == null) {
            this.f5756e = new SecureRandom();
        }
        return this.f5756e;
    }

    public final int w() {
        if (this.f5759h == null) {
            this.f5759h = Integer.valueOf(f.a().a(a()) / 1000);
        }
        return this.f5759h.intValue();
    }

    /* access modifiers changed from: 0000 */
    public final String x() {
        byte[] bArr = new byte[16];
        v().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    static boolean e(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* access modifiers changed from: 0000 */
    public final Bundle a(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            String str5 = "gclid";
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter(str5);
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(str5, str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String str6 = "aclid";
            String queryParameter3 = uri.getQueryParameter(str6);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(str6, queryParameter3);
            }
            String str7 = "cp1";
            String queryParameter4 = uri.getQueryParameter(str7);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(str7, queryParameter4);
            }
            String str8 = "anid";
            String queryParameter5 = uri.getQueryParameter(str8);
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(str8, queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            e().w().a("Install referrer url isn't a hierarchical URI", e2);
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ C0532kb e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ fe g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ C0576tb f() {
        return super.f();
    }

    /* access modifiers changed from: 0000 */
    public final int b(String str) {
        String str2 = "event";
        if (!c(str2, str)) {
            return 2;
        }
        if (!a(str2, C0553oc.f6047a, str)) {
            return 13;
        }
        if (!a(str2, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final int c(String str) {
        String str2 = "user property";
        if (!c(str2, str)) {
            return 6;
        }
        if (!a(str2, C0563qc.f6068a, str)) {
            return 15;
        }
        if (!a(str2, 24, str)) {
            return 6;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final boolean d(String str) {
        j();
        if (com.google.android.gms.common.b.c.a(a()).a(str) == 0) {
            return true;
        }
        e().A().a("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final int b(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = a("user property referrer", str, h(str), obj, false);
        } else {
            z = a("user property", str, h(str), obj, false);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: 0000 */
    public final Object c(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return a(h(str), obj, true);
        }
        return a(h(str), obj, false);
    }

    public final /* bridge */ /* synthetic */ Ib d() {
        return super.d();
    }

    private static boolean b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
            return false;
        } catch (NameNotFoundException unused) {
        }
    }

    private final boolean c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo b2 = com.google.android.gms.common.b.c.a(context).b(str, 64);
            if (!(b2 == null || b2.signatures == null || b2.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(b2.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e2) {
            e().t().a("Error obtaining certificate", e2);
        } catch (NameNotFoundException e3) {
            e().t().a("Package name not found", e3);
        }
        return true;
    }

    public static Bundle b(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i2 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i2 < parcelableArr.length) {
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i2++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i2 < list.size()) {
                        Object obj2 = list.get(i2);
                        if (obj2 instanceof Bundle) {
                            list.set(i2, new Bundle((Bundle) obj2));
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle2;
    }

    public final /* bridge */ /* synthetic */ d c() {
        return super.c();
    }

    static boolean a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            e().v().a("Name is required and can't be null. Type", str);
            return false;
        }
        q.a(str2);
        String[] strArr2 = f5754c;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i2])) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            e().v().a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            q.a(strArr);
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z2 = false;
                    break;
                } else if (e(str2, strArr[i3])) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            if (z2) {
                e().v().a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Bundle> b(List<de> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (de deVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", deVar.f5877a);
            bundle.putString("origin", deVar.f5878b);
            bundle.putLong("creation_timestamp", deVar.f5880d);
            bundle.putString("name", deVar.f5879c.f5706b);
            C0538lc.a(bundle, deVar.f5879c.f());
            bundle.putBoolean("active", deVar.f5881e);
            String str = deVar.f5882f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            C0525j jVar = deVar.f5883g;
            if (jVar != null) {
                bundle.putString("timed_out_event_name", jVar.f5953a);
                C0520i iVar = deVar.f5883g.f5954b;
                if (iVar != null) {
                    bundle.putBundle("timed_out_event_params", iVar.f());
                }
            }
            bundle.putLong("trigger_timeout", deVar.f5884h);
            C0525j jVar2 = deVar.f5885i;
            if (jVar2 != null) {
                bundle.putString("triggered_event_name", jVar2.f5953a);
                C0520i iVar2 = deVar.f5885i.f5954b;
                if (iVar2 != null) {
                    bundle.putBundle("triggered_event_params", iVar2.f());
                }
            }
            bundle.putLong("triggered_timestamp", deVar.f5879c.f5707c);
            bundle.putLong("time_to_live", deVar.f5886j);
            C0525j jVar3 = deVar.f5887k;
            if (jVar3 != null) {
                bundle.putString("expired_event_name", jVar3.f5953a);
                C0520i iVar3 = deVar.f5887k.f5954b;
                if (iVar3 != null) {
                    bundle.putBundle("expired_event_params", iVar3.f());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(String str, int i2, String str2) {
        if (str2 == null) {
            e().v().a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i2) {
            return true;
        } else {
            e().v().a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
            return false;
        }
    }

    private final boolean a(String str, String str2, int i2, Object obj, boolean z) {
        Parcelable[] parcelableArr;
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.codePointCount(0, valueOf.length()) > i2) {
                    e().y().a("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                    return false;
                }
            } else if ((obj instanceof Bundle) && z) {
                return true;
            } else {
                if ((obj instanceof Parcelable[]) && z) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (!(parcelable instanceof Bundle)) {
                            e().y().a("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof ArrayList) || !z) {
                    return false;
                } else {
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj2 = arrayList.get(i3);
                        i3++;
                        if (!(obj2 instanceof Bundle)) {
                            e().y().a("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ ee b() {
        return super.b();
    }

    static boolean a(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    private static Object a(int i2, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return a(String.valueOf(obj), i2, z);
            }
            return null;
        }
    }

    public static String a(String str, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i2) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final Object a(String str, Object obj) {
        int i2 = 256;
        if ("_ev".equals(str)) {
            return a(256, obj, true);
        }
        if (!e(str)) {
            i2 = 100;
        }
        return a(i2, obj, false);
    }

    static Bundle[] a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        if (a(r2, 40, r15) == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (a(r2, 40, r15) == false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0147  */
    public final Bundle a(String str, String str2, Bundle bundle, List<String> list, boolean z, boolean z2) {
        Set<String> set;
        int i2;
        String str3;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        int i6;
        String str4 = str;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        String[] strArr = null;
        if (bundle2 == null) {
            return null;
        }
        Bundle bundle3 = new Bundle(bundle2);
        if (g().e(str4, C0535l.Ca)) {
            set = new TreeSet<>(bundle.keySet());
        } else {
            set = bundle.keySet();
        }
        int i7 = 0;
        for (String str5 : set) {
            if (list2 == null || !list2.contains(str5)) {
                i2 = 14;
                String str6 = "event param";
                if (z) {
                    if (b(str6, str5)) {
                        if (!a(str6, strArr, str5)) {
                            i6 = 14;
                            if (i6 == 0) {
                                if (c(str6, str5)) {
                                    if (a(str6, strArr, str5)) {
                                    }
                                }
                                i2 = 3;
                            } else {
                                i2 = i6;
                            }
                            String str7 = "_ev";
                            if (i2 == 0) {
                                if (a(bundle3, i2)) {
                                    bundle3.putString(str7, a(str5, 40, true));
                                    if (i2 == 3) {
                                        a(bundle3, (Object) str5);
                                    }
                                }
                                bundle3.remove(str5);
                            } else {
                                Object obj = bundle2.get(str5);
                                j();
                                if (z2) {
                                    if (obj instanceof Parcelable[]) {
                                        i5 = ((Parcelable[]) obj).length;
                                    } else {
                                        if (obj instanceof ArrayList) {
                                            i5 = ((ArrayList) obj).size();
                                        }
                                        z4 = true;
                                        if (!z4) {
                                            i4 = 17;
                                            str3 = str7;
                                            i3 = 40;
                                            if (i4 != 0 || str3.equals(str5)) {
                                                if (a(str5)) {
                                                    i7++;
                                                    if (i7 > 25) {
                                                        StringBuilder sb = new StringBuilder(48);
                                                        sb.append("Event can't contain more than 25 params");
                                                        e().v().a(sb.toString(), l().a(str2), l().a(bundle2));
                                                        a(bundle3, 5);
                                                        bundle3.remove(str5);
                                                    }
                                                }
                                                String str8 = str2;
                                            } else {
                                                if (a(bundle3, i4)) {
                                                    bundle3.putString(str3, a(str5, i3, true));
                                                    a(bundle3, bundle2.get(str5));
                                                }
                                                bundle3.remove(str5);
                                            }
                                        }
                                    }
                                    if (i5 > 1000) {
                                        e().y().a("Parameter array is too long; discarded. Value kind, name, array length", "param", str5, Integer.valueOf(i5));
                                        z4 = false;
                                        if (!z4) {
                                        }
                                    }
                                    z4 = true;
                                    if (!z4) {
                                    }
                                }
                                if ((!g().f(str4) || !e(str2)) && !e(str5)) {
                                    str3 = str7;
                                    i3 = 40;
                                    z3 = a("param", str5, 100, obj, z2);
                                } else {
                                    str3 = str7;
                                    i3 = 40;
                                    z3 = a("param", str5, 256, obj, z2);
                                }
                                i4 = z3 ? 0 : 4;
                                if (i4 != 0) {
                                }
                                if (a(str5)) {
                                }
                                String str82 = str2;
                            }
                            strArr = null;
                        }
                    }
                    i6 = 3;
                    if (i6 == 0) {
                    }
                    String str72 = "_ev";
                    if (i2 == 0) {
                    }
                    strArr = null;
                }
                i6 = 0;
                if (i6 == 0) {
                }
                String str722 = "_ev";
                if (i2 == 0) {
                }
                strArr = null;
            }
            i2 = 0;
            String str7222 = "_ev";
            if (i2 == 0) {
            }
            strArr = null;
        }
        return bundle3;
    }

    private static boolean a(Bundle bundle, int i2) {
        String str = "_err";
        if (bundle.getLong(str) != 0) {
            return false;
        }
        bundle.putLong(str, (long) i2);
        return true;
    }

    private static void a(Bundle bundle, Object obj) {
        q.a(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    e().y().a("Not putting event parameter. Invalid value type. name, type", l().b(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final void a(int i2, String str, String str2, int i3) {
        a((String) null, i2, str, str2, i3);
    }

    /* access modifiers changed from: 0000 */
    public final void a(String str, int i2, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        a(bundle, i2);
        if (g().e(str, C0535l.va)) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                bundle.putString(str2, str3);
            }
        } else if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", (long) i3);
        }
        this.f5987a.b();
        this.f5987a.y().b("auto", "_err", bundle);
    }

    static long a(byte[] bArr) {
        q.a(bArr);
        int i2 = 0;
        q.b(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << i2;
            i2 += 8;
            length--;
        }
        return j2;
    }

    static boolean a(Context context, boolean z) {
        q.a(context);
        if (VERSION.SDK_INT >= 24) {
            return b(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return b(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean a(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        if (bool == null) {
            return false;
        }
        return bool.equals(bool2);
    }

    static boolean a(List<String> list, List<String> list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null) {
            return false;
        }
        return list.equals(list2);
    }

    /* access modifiers changed from: 0000 */
    public final Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a2 = a(str, bundle.get(str));
                if (a2 == null) {
                    e().y().a("Param value can't be null", l().b(str));
                } else {
                    a(bundle2, str, a2);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: 0000 */
    public final C0525j a(String str, String str2, Bundle bundle, String str3, long j2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (b(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            String str4 = "_o";
            bundle2.putString(str4, str3);
            C0525j jVar = new C0525j(str2, new C0520i(a(a(str, str2, bundle2, e.a(str4), false, false))), str3, j2);
            return jVar;
        }
        e().t().a("Invalid conditional property event name", l().c(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: 0000 */
    public final long a(Context context, String str) {
        j();
        q.a(context);
        q.b(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest t = t();
        if (t == null) {
            e().t().a("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!c(context, str)) {
                    PackageInfo b2 = com.google.android.gms.common.b.c.a(context).b(a().getPackageName(), 64);
                    if (b2.signatures != null && b2.signatures.length > 0) {
                        return a(t.digest(b2.signatures[0].toByteArray()));
                    }
                    e().w().a("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e2) {
                e().t().a("Package name not found", e2);
            }
        }
        return 0;
    }

    static byte[] a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final int a(int i2) {
        return f.a().a(a(), (int) g.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public static long a(long j2, long j3) {
        return (j2 + (j3 * 60000)) / 86400000;
    }

    /* access modifiers changed from: 0000 */
    public final void a(Bundle bundle, long j2) {
        String str = "_et";
        long j3 = bundle.getLong(str);
        if (j3 != 0) {
            e().w().a("Params already contained engagement", Long.valueOf(j3));
        }
        bundle.putLong(str, j2 + j3);
    }

    public final void a(sf sfVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning string value to wrapper", e2);
        }
    }

    public final void a(sf sfVar, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j2);
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning long value to wrapper", e2);
        }
    }

    public final void a(sf sfVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning int value to wrapper", e2);
        }
    }

    public final void a(sf sfVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning byte array to wrapper", e2);
        }
    }

    public final void a(sf sfVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning boolean value to wrapper", e2);
        }
    }

    public final void a(sf sfVar, Bundle bundle) {
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning bundle value to wrapper", e2);
        }
    }

    public static Bundle a(List<Rd> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (Rd rd : list) {
            String str = rd.f5710f;
            if (str != null) {
                bundle.putString(rd.f5706b, str);
            } else {
                Long l2 = rd.f5708d;
                if (l2 != null) {
                    bundle.putLong(rd.f5706b, l2.longValue());
                } else {
                    Double d2 = rd.f5712h;
                    if (d2 != null) {
                        bundle.putDouble(rd.f5706b, d2.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public final void a(sf sfVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            sfVar.c(bundle);
        } catch (RemoteException e2) {
            this.f5987a.e().w().a("Error returning bundle list to wrapper", e2);
        }
    }

    public final URL a(long j2, String str, String str2) {
        try {
            q.b(str2);
            q.b(str);
            return new URL(String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j2), Integer.valueOf(w())}), str2, str}));
        } catch (IllegalArgumentException | MalformedURLException e2) {
            e().t().a("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Context a() {
        return super.a();
    }
}
