package i;

import i.a.e;
import j.f;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpUrl */
public final class B {

    /* renamed from: a reason: collision with root package name */
    private static final char[] f8422a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b reason: collision with root package name */
    final String f8423b;

    /* renamed from: c reason: collision with root package name */
    private final String f8424c;

    /* renamed from: d reason: collision with root package name */
    private final String f8425d;

    /* renamed from: e reason: collision with root package name */
    final String f8426e;

    /* renamed from: f reason: collision with root package name */
    final int f8427f;

    /* renamed from: g reason: collision with root package name */
    private final List<String> f8428g;

    /* renamed from: h reason: collision with root package name */
    private final List<String> f8429h;

    /* renamed from: i reason: collision with root package name */
    private final String f8430i;

    /* renamed from: j reason: collision with root package name */
    private final String f8431j;

    /* compiled from: HttpUrl */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        String f8432a;

        /* renamed from: b reason: collision with root package name */
        String f8433b;

        /* renamed from: c reason: collision with root package name */
        String f8434c;

        /* renamed from: d reason: collision with root package name */
        String f8435d;

        /* renamed from: e reason: collision with root package name */
        int f8436e = -1;

        /* renamed from: f reason: collision with root package name */
        final List<String> f8437f = new ArrayList();

        /* renamed from: g reason: collision with root package name */
        List<String> f8438g;

        /* renamed from: h reason: collision with root package name */
        String f8439h;

        public a() {
            String str = "";
            this.f8433b = str;
            this.f8434c = str;
            this.f8437f.add(str);
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected port: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f8436e = i2;
            return this;
        }

        public a b(String str) {
            if (str != null) {
                String a2 = a(str, 0, str.length());
                if (a2 != null) {
                    this.f8435d = a2;
                    return this;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected host: ");
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            throw new NullPointerException("host == null");
        }

        public a c(String str) {
            if (str != null) {
                this.f8434c = B.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public a d(String str) {
            if (str != null) {
                String str2 = "http";
                if (str.equalsIgnoreCase(str2)) {
                    this.f8432a = str2;
                } else {
                    String str3 = "https";
                    if (str.equalsIgnoreCase(str3)) {
                        this.f8432a = str3;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("unexpected scheme: ");
                        sb.append(str);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public a e(String str) {
            if (str != null) {
                this.f8433b = B.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f8432a;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (!this.f8433b.isEmpty() || !this.f8434c.isEmpty()) {
                sb.append(this.f8433b);
                if (!this.f8434c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f8434c);
                }
                sb.append('@');
            }
            String str2 = this.f8435d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f8435d);
                    sb.append(']');
                } else {
                    sb.append(this.f8435d);
                }
            }
            if (!(this.f8436e == -1 && this.f8432a == null)) {
                int b2 = b();
                String str3 = this.f8432a;
                if (str3 == null || b2 != B.a(str3)) {
                    sb.append(':');
                    sb.append(b2);
                }
            }
            B.b(sb, this.f8437f);
            if (this.f8438g != null) {
                sb.append('?');
                B.a(sb, this.f8438g);
            }
            if (this.f8439h != null) {
                sb.append('#');
                sb.append(this.f8439h);
            }
            return sb.toString();
        }

        private static int f(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private static int e(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i2;
                        }
                    }
                }
            }
            return -1;
        }

        public a a(String str) {
            List<String> list;
            if (str != null) {
                list = B.e(B.a(str, " \"'<>#", true, false, true, true));
            } else {
                list = null;
            }
            this.f8438g = list;
            return this;
        }

        /* access modifiers changed from: 0000 */
        public a c() {
            int size = this.f8437f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f8437f.set(i2, B.a((String) this.f8437f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f8438g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = (String) this.f8438g.get(i3);
                    if (str != null) {
                        this.f8438g.set(i3, B.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f8439h;
            if (str2 != null) {
                this.f8439h = B.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        /* access modifiers changed from: 0000 */
        public int b() {
            int i2 = this.f8436e;
            return i2 != -1 ? i2 : B.a(this.f8432a);
        }

        public a a(String str, String str2) {
            String str3;
            if (str != null) {
                if (this.f8438g == null) {
                    this.f8438g = new ArrayList();
                }
                this.f8438g.add(B.a(str, " \"'<>#&=", true, false, true, true));
                List<String> list = this.f8438g;
                if (str2 != null) {
                    str3 = B.a(str2, " \"'<>#&=", true, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public a b(String str, String str2) {
            String str3;
            if (str != null) {
                if (this.f8438g == null) {
                    this.f8438g = new ArrayList();
                }
                this.f8438g.add(B.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                List<String> list = this.f8438g;
                if (str2 != null) {
                    str3 = B.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true);
                } else {
                    str3 = null;
                }
                list.add(str3);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Regions count limit reached
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:89)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:695)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
            	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
            	at jadx.core.ProcessClass.process(ProcessClass.java:30)
            	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
            	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
            	at jadx.core.ProcessClass.process(ProcessClass.java:35)
            	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
            	at jadx.api.JavaClass.decompile(JavaClass.java:62)
            	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void d(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f8437f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f8437f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f8437f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = i.a.e.a(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i.B.a.d(java.lang.String, int, int):void");
        }

        private void d() {
            List<String> list = this.f8437f;
            String str = "";
            if (!((String) list.remove(list.size() - 1)).isEmpty() || this.f8437f.isEmpty()) {
                this.f8437f.add(str);
                return;
            }
            List<String> list2 = this.f8437f;
            list2.set(list2.size() - 1, str);
        }

        private static int b(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(B.a(str, i2, i3, "", false, false, false, true, null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        public B a() {
            if (this.f8432a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f8435d != null) {
                return new B(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        private static int c(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        /* access modifiers changed from: 0000 */
        public a a(B b2, String str) {
            int a2;
            int i2;
            B b3 = b2;
            String str2 = str;
            int a3 = e.a(str2, 0, str.length());
            int b4 = e.b(str2, a3, str.length());
            int e2 = e(str2, a3, b4);
            if (e2 != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f8432a = "https";
                    a3 += 6;
                } else {
                    if (str.regionMatches(true, a3, "http:", 0, 5)) {
                        this.f8432a = "http";
                        a3 += 5;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        sb.append(str2.substring(0, e2));
                        sb.append("'");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            } else if (b3 != null) {
                this.f8432a = b3.f8423b;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f2 = f(str2, a3, b4);
            char c2 = '?';
            char c3 = '#';
            if (f2 >= 2 || b3 == null || !b3.f8423b.equals(this.f8432a)) {
                int i3 = a3 + f2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = e.a(str2, i3, b4, "@/\\?#");
                    char charAt = a2 != b4 ? str2.charAt(a2) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        int i4 = a2;
                        int c4 = c(str2, i3, i4);
                        int i5 = c4 + 1;
                    } else {
                        if (charAt == '@') {
                            String str3 = "%40";
                            if (!z) {
                                int a4 = e.a(str2, i3, a2, ':');
                                int i6 = a4;
                                String str4 = str3;
                                i2 = a2;
                                String a5 = B.a(str, i3, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                if (z2) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(this.f8433b);
                                    sb2.append(str4);
                                    sb2.append(a5);
                                    a5 = sb2.toString();
                                }
                                this.f8433b = a5;
                                if (i6 != i2) {
                                    this.f8434c = B.a(str, i6 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                String str5 = str3;
                                i2 = a2;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(this.f8434c);
                                sb3.append(str5);
                                sb3.append(B.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null));
                                this.f8434c = sb3.toString();
                            }
                            i3 = i2 + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                int i42 = a2;
                int c42 = c(str2, i3, i42);
                int i52 = c42 + 1;
                if (i52 < i42) {
                    this.f8435d = a(str2, i3, c42);
                    this.f8436e = b(str2, i52, i42);
                    if (this.f8436e == -1) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        sb4.append(str2.substring(i52, i42));
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString());
                    }
                } else {
                    this.f8435d = a(str2, i3, c42);
                    this.f8436e = B.a(this.f8432a);
                }
                if (this.f8435d != null) {
                    a3 = i42;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    sb5.append(str2.substring(i3, c42));
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString());
                }
            } else {
                this.f8433b = b2.f();
                this.f8434c = b2.b();
                this.f8435d = b3.f8426e;
                this.f8436e = b3.f8427f;
                this.f8437f.clear();
                this.f8437f.addAll(b2.d());
                if (a3 == b4 || str2.charAt(a3) == '#') {
                    a(b2.e());
                }
            }
            int a6 = e.a(str2, a3, b4, "?#");
            d(str2, a3, a6);
            if (a6 < b4 && str2.charAt(a6) == '?') {
                int a7 = e.a(str2, a6, b4, '#');
                this.f8438g = B.e(B.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, null));
                a6 = a7;
            }
            if (a6 < b4 && str2.charAt(a6) == '#') {
                this.f8439h = B.a(str, 1 + a6, b4, "", true, false, false, false, null);
            }
            return this;
        }

        private void a(String str, int i2, int i3, boolean z, boolean z2) {
            String a2 = B.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (!f(a2)) {
                if (g(a2)) {
                    d();
                    return;
                }
                List<String> list = this.f8437f;
                if (((String) list.get(list.size() - 1)).isEmpty()) {
                    List<String> list2 = this.f8437f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f8437f.add(a2);
                }
                if (z) {
                    this.f8437f.add("");
                }
            }
        }

        private static String a(String str, int i2, int i3) {
            return e.a(B.a(str, i2, i3, false));
        }
    }

    B(a aVar) {
        this.f8423b = aVar.f8432a;
        this.f8424c = a(aVar.f8433b, false);
        this.f8425d = a(aVar.f8434c, false);
        this.f8426e = aVar.f8435d;
        this.f8427f = aVar.b();
        this.f8428g = a(aVar.f8437f, false);
        List<String> list = aVar.f8438g;
        String str = null;
        this.f8429h = list != null ? a(list, true) : null;
        String str2 = aVar.f8439h;
        if (str2 != null) {
            str = a(str2, false);
        }
        this.f8430i = str;
        this.f8431j = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.f8425d.isEmpty()) {
            return "";
        }
        return this.f8431j.substring(this.f8431j.indexOf(58, this.f8423b.length() + 3) + 1, this.f8431j.indexOf(64));
    }

    public String c() {
        int indexOf = this.f8431j.indexOf(47, this.f8423b.length() + 3);
        String str = this.f8431j;
        return this.f8431j.substring(indexOf, e.a(str, indexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int indexOf = this.f8431j.indexOf(47, this.f8423b.length() + 3);
        String str = this.f8431j;
        int a2 = e.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = e.a(this.f8431j, i2, a2, '/');
            arrayList.add(this.f8431j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String e() {
        if (this.f8429h == null) {
            return null;
        }
        int indexOf = this.f8431j.indexOf(63) + 1;
        String str = this.f8431j;
        return this.f8431j.substring(indexOf, e.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof B) && ((B) obj).f8431j.equals(this.f8431j);
    }

    public String f() {
        if (this.f8424c.isEmpty()) {
            return "";
        }
        int length = this.f8423b.length() + 3;
        String str = this.f8431j;
        return this.f8431j.substring(length, e.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f8426e;
    }

    public boolean h() {
        return this.f8423b.equals("https");
    }

    public int hashCode() {
        return this.f8431j.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f8432a = this.f8423b;
        aVar.f8433b = f();
        aVar.f8434c = b();
        aVar.f8435d = this.f8426e;
        aVar.f8436e = this.f8427f != a(this.f8423b) ? this.f8427f : -1;
        aVar.f8437f.clear();
        aVar.f8437f.addAll(d());
        aVar.a(e());
        aVar.f8439h = a();
        return aVar;
    }

    public List<String> j() {
        return this.f8428g;
    }

    public int k() {
        return this.f8427f;
    }

    public String l() {
        if (this.f8429h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f8429h);
        return sb.toString();
    }

    public String m() {
        a c2 = c("/...");
        String str = "";
        c2.e(str);
        c2.c(str);
        return c2.a().toString();
    }

    public String n() {
        return this.f8423b;
    }

    public URI o() {
        a i2 = i();
        i2.c();
        String aVar = i2.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String toString() {
        return this.f8431j;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = (String) list.get(i2);
            String str2 = (String) list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public a c(String str) {
        try {
            a aVar = new a();
            aVar.a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append((String) list.get(i2));
        }
    }

    static List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public B f(String str) {
        a c2 = c(str);
        if (c2 != null) {
            return c2.a();
        }
        return null;
    }

    public static B d(String str) {
        try {
            return b(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static B b(String str) {
        a aVar = new a();
        aVar.a((B) null, str);
        return aVar.a();
    }

    public String a() {
        if (this.f8430i == null) {
            return null;
        }
        return this.f8431j.substring(this.f8431j.indexOf(35) + 1);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = (String) list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                f fVar = new f();
                fVar.a(str, i2, i4);
                a(fVar, str, i4, i3, z);
                return fVar.e();
            }
        }
        return str.substring(i2, i3);
    }

    static void a(f fVar, String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37) {
                int i4 = i2 + 2;
                if (i4 < i3) {
                    int a2 = e.a(str.charAt(i2 + 1));
                    int a3 = e.a(str.charAt(i4));
                    if (!(a2 == -1 || a3 == -1)) {
                        fVar.writeByte((a2 << 4) + a3);
                        i2 = i4;
                        i2 += Character.charCount(codePointAt);
                    }
                    fVar.c(codePointAt);
                    i2 += Character.charCount(codePointAt);
                }
            }
            if (codePointAt == 43 && z) {
                fVar.writeByte(32);
                i2 += Character.charCount(codePointAt);
            }
            fVar.c(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        if (i4 >= i3 || str.charAt(i2) != '%' || e.a(str.charAt(i2 + 1)) == -1 || e.a(str.charAt(i4)) == -1) {
            return false;
        }
        return true;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i4 = i3;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i5, i3)))) && (codePointAt != 43 || !z3))) {
                    i5 += Character.charCount(codePointAt);
                }
            }
            f fVar = new f();
            int i6 = i2;
            fVar.a(str, i2, i5);
            a(fVar, str, i5, i3, str2, z, z2, z3, z4, charset);
            return fVar.e();
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static void a(f fVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        f fVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    fVar.a(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !a(str, i2, i3)))))) {
                    if (fVar2 == null) {
                        fVar2 = new f();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        fVar2.c(codePointAt);
                    } else {
                        fVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!fVar2.o()) {
                        byte readByte = fVar2.readByte() & 255;
                        fVar.writeByte(37);
                        fVar.writeByte((int) f8422a[(readByte >> 4) & 15]);
                        fVar.writeByte((int) f8422a[readByte & 15]);
                    }
                } else {
                    fVar.c(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
