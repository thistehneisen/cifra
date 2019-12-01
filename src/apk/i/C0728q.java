package i;

import com.appsflyer.share.Constants;
import i.a.e;
import io.intercom.okhttp3.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* renamed from: i.q reason: case insensitive filesystem */
/* compiled from: Cookie */
public final class C0728q {

    /* renamed from: a reason: collision with root package name */
    private static final Pattern f8739a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: b reason: collision with root package name */
    private static final Pattern f8740b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: c reason: collision with root package name */
    private static final Pattern f8741c = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: d reason: collision with root package name */
    private static final Pattern f8742d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: e reason: collision with root package name */
    private final String f8743e;

    /* renamed from: f reason: collision with root package name */
    private final String f8744f;

    /* renamed from: g reason: collision with root package name */
    private final long f8745g;

    /* renamed from: h reason: collision with root package name */
    private final String f8746h;

    /* renamed from: i reason: collision with root package name */
    private final String f8747i;

    /* renamed from: j reason: collision with root package name */
    private final boolean f8748j;

    /* renamed from: k reason: collision with root package name */
    private final boolean f8749k;

    /* renamed from: l reason: collision with root package name */
    private final boolean f8750l;
    private final boolean m;

    /* renamed from: i.q$a */
    /* compiled from: Cookie */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        String f8751a;

        /* renamed from: b reason: collision with root package name */
        String f8752b;

        /* renamed from: c reason: collision with root package name */
        long f8753c = HttpDate.MAX_DATE;

        /* renamed from: d reason: collision with root package name */
        String f8754d;

        /* renamed from: e reason: collision with root package name */
        String f8755e = Constants.URL_PATH_DELIMITER;

        /* renamed from: f reason: collision with root package name */
        boolean f8756f;

        /* renamed from: g reason: collision with root package name */
        boolean f8757g;

        /* renamed from: h reason: collision with root package name */
        boolean f8758h;

        /* renamed from: i reason: collision with root package name */
        boolean f8759i;

        public a a(long j2) {
            if (j2 <= 0) {
                j2 = Long.MIN_VALUE;
            }
            if (j2 > HttpDate.MAX_DATE) {
                j2 = 253402300799999L;
            }
            this.f8753c = j2;
            this.f8758h = true;
            return this;
        }

        public a b(String str) {
            a(str, true);
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.f8751a = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public a d(String str) {
            if (str.startsWith(Constants.URL_PATH_DELIMITER)) {
                this.f8755e = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.f8752b = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }

        public a b() {
            this.f8757g = true;
            return this;
        }

        public a a(String str) {
            a(str, false);
            return this;
        }

        private a a(String str, boolean z) {
            if (str != null) {
                String a2 = e.a(str);
                if (a2 != null) {
                    this.f8754d = a2;
                    this.f8759i = z;
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected domain: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("domain == null");
        }

        public a c() {
            this.f8756f = true;
            return this;
        }

        public C0728q a() {
            return new C0728q(this);
        }
    }

    private C0728q(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f8743e = str;
        this.f8744f = str2;
        this.f8745g = j2;
        this.f8746h = str3;
        this.f8747i = str4;
        this.f8748j = z;
        this.f8749k = z2;
        this.m = z3;
        this.f8750l = z4;
    }

    public String a() {
        return this.f8746h;
    }

    public long b() {
        return this.f8745g;
    }

    public boolean c() {
        return this.m;
    }

    public boolean d() {
        return this.f8749k;
    }

    public String e() {
        return this.f8743e;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof C0728q)) {
            return false;
        }
        C0728q qVar = (C0728q) obj;
        if (qVar.f8743e.equals(this.f8743e) && qVar.f8744f.equals(this.f8744f) && qVar.f8746h.equals(this.f8746h) && qVar.f8747i.equals(this.f8747i) && qVar.f8745g == this.f8745g && qVar.f8748j == this.f8748j && qVar.f8749k == this.f8749k && qVar.f8750l == this.f8750l && qVar.m == this.m) {
            z = true;
        }
        return z;
    }

    public String f() {
        return this.f8747i;
    }

    public boolean g() {
        return this.f8750l;
    }

    public boolean h() {
        return this.f8748j;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.f8743e.hashCode()) * 31) + this.f8744f.hashCode()) * 31) + this.f8746h.hashCode()) * 31) + this.f8747i.hashCode()) * 31;
        long j2 = this.f8745g;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f8748j ^ true ? 1 : 0)) * 31) + (this.f8749k ^ true ? 1 : 0)) * 31) + (this.f8750l ^ true ? 1 : 0)) * 31) + (this.m ^ true ? 1 : 0);
    }

    public String i() {
        return this.f8744f;
    }

    public String toString() {
        return a(false);
    }

    private static boolean b(B b2, String str) {
        String c2 = b2.c();
        if (c2.equals(str)) {
            return true;
        }
        if (!c2.startsWith(str) || (!str.endsWith(Constants.URL_PATH_DELIMITER) && c2.charAt(str.length()) != '/')) {
            return false;
        }
        return true;
    }

    public boolean a(B b2) {
        boolean z;
        if (this.m) {
            z = b2.g().equals(this.f8746h);
        } else {
            z = a(b2.g(), this.f8746h);
        }
        if (!z || !b(b2, this.f8747i)) {
            return false;
        }
        if (!this.f8748j || b2.h()) {
            return true;
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        if (!str.endsWith(str2) || str.charAt((str.length() - str2.length()) - 1) != '.' || e.c(str)) {
            return false;
        }
        return true;
    }

    private static long b(String str) {
        long j2 = Long.MIN_VALUE;
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 0) {
                j2 = parseLong;
            }
            return j2;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                if (!str.startsWith("-")) {
                    j2 = Long.MAX_VALUE;
                }
                return j2;
            }
            throw e2;
        }
    }

    C0728q(a aVar) {
        String str = aVar.f8751a;
        if (str != null) {
            String str2 = aVar.f8752b;
            if (str2 != null) {
                String str3 = aVar.f8754d;
                if (str3 != null) {
                    this.f8743e = str;
                    this.f8744f = str2;
                    this.f8745g = aVar.f8753c;
                    this.f8746h = str3;
                    this.f8747i = aVar.f8755e;
                    this.f8748j = aVar.f8756f;
                    this.f8749k = aVar.f8757g;
                    this.f8750l = aVar.f8758h;
                    this.m = aVar.f8759i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }

    public static C0728q a(B b2, String str) {
        return a(System.currentTimeMillis(), b2, str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0131  */
    static C0728q a(long j2, B b2, String str) {
        long j3;
        String g2;
        String str2;
        C0728q qVar;
        String str3;
        String str4;
        String str5;
        int lastIndexOf;
        String str6 = str;
        int length = str.length();
        char c2 = ';';
        int a2 = e.a(str6, 0, length, ';');
        char c3 = '=';
        int a3 = e.a(str6, 0, a2, '=');
        if (a3 == a2) {
            return null;
        }
        String c4 = e.c(str6, 0, a3);
        if (c4.isEmpty() || e.b(c4) != -1) {
            return null;
        }
        String c5 = e.c(str6, a3 + 1, a2);
        if (e.b(c5) != -1) {
            return null;
        }
        int i2 = a2 + 1;
        String str7 = null;
        String str8 = null;
        long j4 = -1;
        long j5 = 253402300799999L;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = false;
        while (i2 < length) {
            int a4 = e.a(str6, i2, length, c2);
            int a5 = e.a(str6, i2, a4, c3);
            String c6 = e.c(str6, i2, a5);
            String c7 = a5 < a4 ? e.c(str6, a5 + 1, a4) : "";
            if (c6.equalsIgnoreCase("expires")) {
                try {
                    j5 = a(c7, 0, c7.length());
                } catch (IllegalArgumentException unused) {
                }
            } else if (c6.equalsIgnoreCase("max-age")) {
                j4 = b(c7);
            } else {
                if (c6.equalsIgnoreCase("domain")) {
                    str7 = a(c7);
                    z3 = false;
                } else if (c6.equalsIgnoreCase("path")) {
                    str8 = c7;
                } else if (c6.equalsIgnoreCase("secure")) {
                    z = true;
                } else if (c6.equalsIgnoreCase("httponly")) {
                    z2 = true;
                }
                i2 = a4 + 1;
                c2 = ';';
                c3 = '=';
            }
            z4 = true;
            i2 = a4 + 1;
            c2 = ';';
            c3 = '=';
        }
        long j6 = Long.MIN_VALUE;
        if (j4 != Long.MIN_VALUE) {
            if (j4 != -1) {
                j6 = j2 + (j4 <= 9223372036854775L ? j4 * 1000 : Long.MAX_VALUE);
                if (j6 < j2 || j6 > HttpDate.MAX_DATE) {
                    j3 = 253402300799999L;
                }
            } else {
                j3 = j5;
            }
            g2 = b2.g();
            if (str7 != null) {
                str2 = g2;
                qVar = null;
            } else if (!a(g2, str7)) {
                return null;
            } else {
                qVar = null;
                str2 = str7;
            }
            if (g2.length() == str2.length() && PublicSuffixDatabase.a().a(str2) == null) {
                return qVar;
            }
            str3 = Constants.URL_PATH_DELIMITER;
            str4 = str8;
            if (str4 != null || !str4.startsWith(str3)) {
                String c8 = b2.c();
                lastIndexOf = c8.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = c8.substring(0, lastIndexOf);
                }
                str5 = str3;
            } else {
                str5 = str4;
            }
            C0728q qVar2 = new C0728q(c4, c5, j3, str2, str5, z, z2, z3, z4);
            return qVar2;
        }
        j3 = j6;
        g2 = b2.g();
        if (str7 != null) {
        }
        if (g2.length() == str2.length()) {
        }
        str3 = Constants.URL_PATH_DELIMITER;
        str4 = str8;
        if (str4 != null) {
        }
        String c82 = b2.c();
        lastIndexOf = c82.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str5 = str3;
        C0728q qVar22 = new C0728q(c4, c5, j3, str2, str5, z, z2, z3, z4);
        return qVar22;
    }

    private static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = f8742d.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(f8742d).matches()) {
                int parseInt = Integer.parseInt(matcher.group(1));
                int parseInt2 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
                i8 = parseInt2;
                i5 = parseInt;
            } else if (i6 == -1 && matcher.usePattern(f8741c).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(f8740b).matches()) {
                i7 = f8740b.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(f8739a).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(e.f8661i);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static String a(String str) {
        String str2 = ".";
        if (!str.endsWith(str2)) {
            if (str.startsWith(str2)) {
                str = str.substring(1);
            }
            String a2 = e.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<C0728q> a(B b2, A a2) {
        List c2 = a2.c("Set-Cookie");
        int size = c2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            C0728q a3 = a(b2, (String) c2.get(i2));
            if (a3 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a3);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    /* access modifiers changed from: 0000 */
    public String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8743e);
        sb.append('=');
        sb.append(this.f8744f);
        if (this.f8750l) {
            if (this.f8745g == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(i.a.b.e.a(new Date(this.f8745g)));
            }
        }
        if (!this.m) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f8746h);
        }
        sb.append("; path=");
        sb.append(this.f8747i);
        if (this.f8748j) {
            sb.append("; secure");
        }
        if (this.f8749k) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
