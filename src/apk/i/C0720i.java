package i;

import i.a.b.f;
import java.util.concurrent.TimeUnit;

/* renamed from: i.i reason: case insensitive filesystem */
/* compiled from: CacheControl */
public final class C0720i {

    /* renamed from: a reason: collision with root package name */
    public static final C0720i f8684a;

    /* renamed from: b reason: collision with root package name */
    public static final C0720i f8685b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f8686c;

    /* renamed from: d reason: collision with root package name */
    private final boolean f8687d;

    /* renamed from: e reason: collision with root package name */
    private final int f8688e;

    /* renamed from: f reason: collision with root package name */
    private final int f8689f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f8690g;

    /* renamed from: h reason: collision with root package name */
    private final boolean f8691h;

    /* renamed from: i reason: collision with root package name */
    private final boolean f8692i;

    /* renamed from: j reason: collision with root package name */
    private final int f8693j;

    /* renamed from: k reason: collision with root package name */
    private final int f8694k;

    /* renamed from: l reason: collision with root package name */
    private final boolean f8695l;
    private final boolean m;
    private final boolean n;
    String o;

    /* renamed from: i.i$a */
    /* compiled from: CacheControl */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        boolean f8696a;

        /* renamed from: b reason: collision with root package name */
        boolean f8697b;

        /* renamed from: c reason: collision with root package name */
        int f8698c = -1;

        /* renamed from: d reason: collision with root package name */
        int f8699d = -1;

        /* renamed from: e reason: collision with root package name */
        int f8700e = -1;

        /* renamed from: f reason: collision with root package name */
        boolean f8701f;

        /* renamed from: g reason: collision with root package name */
        boolean f8702g;

        /* renamed from: h reason: collision with root package name */
        boolean f8703h;

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds((long) i2);
                this.f8699d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("maxStale < 0: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }

        public a b() {
            this.f8696a = true;
            return this;
        }

        public a c() {
            this.f8701f = true;
            return this;
        }

        public C0720i a() {
            return new C0720i(this);
        }
    }

    static {
        a aVar = new a();
        aVar.b();
        f8684a = aVar.a();
        a aVar2 = new a();
        aVar2.c();
        aVar2.a(Integer.MAX_VALUE, TimeUnit.SECONDS);
        f8685b = aVar2.a();
    }

    private C0720i(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.f8686c = z;
        this.f8687d = z2;
        this.f8688e = i2;
        this.f8689f = i3;
        this.f8690g = z3;
        this.f8691h = z4;
        this.f8692i = z5;
        this.f8693j = i4;
        this.f8694k = i5;
        this.f8695l = z6;
        this.m = z7;
        this.n = z8;
        this.o = str;
    }

    private String j() {
        StringBuilder sb = new StringBuilder();
        if (this.f8686c) {
            sb.append("no-cache, ");
        }
        if (this.f8687d) {
            sb.append("no-store, ");
        }
        String str = ", ";
        if (this.f8688e != -1) {
            sb.append("max-age=");
            sb.append(this.f8688e);
            sb.append(str);
        }
        if (this.f8689f != -1) {
            sb.append("s-maxage=");
            sb.append(this.f8689f);
            sb.append(str);
        }
        if (this.f8690g) {
            sb.append("private, ");
        }
        if (this.f8691h) {
            sb.append("public, ");
        }
        if (this.f8692i) {
            sb.append("must-revalidate, ");
        }
        if (this.f8693j != -1) {
            sb.append("max-stale=");
            sb.append(this.f8693j);
            sb.append(str);
        }
        if (this.f8694k != -1) {
            sb.append("min-fresh=");
            sb.append(this.f8694k);
            sb.append(str);
        }
        if (this.f8695l) {
            sb.append("only-if-cached, ");
        }
        if (this.m) {
            sb.append("no-transform, ");
        }
        if (this.n) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f8690g;
    }

    public boolean b() {
        return this.f8691h;
    }

    public int c() {
        return this.f8688e;
    }

    public int d() {
        return this.f8693j;
    }

    public int e() {
        return this.f8694k;
    }

    public boolean f() {
        return this.f8692i;
    }

    public boolean g() {
        return this.f8686c;
    }

    public boolean h() {
        return this.f8687d;
    }

    public boolean i() {
        return this.f8695l;
    }

    public String toString() {
        String str = this.o;
        if (str != null) {
            return str;
        }
        String j2 = j();
        this.o = j2;
        return j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    public static C0720i a(A a2) {
        int i2;
        int i3;
        String str;
        A a3 = a2;
        int b2 = a2.b();
        int i4 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i7 = -1;
        int i8 = -1;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (i4 < b2) {
            String a4 = a3.a(i4);
            String b3 = a3.b(i4);
            if (a4.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = b3;
                    for (i2 = 0; i2 < b3.length(); i2 = i3) {
                        int a5 = f.a(b3, i2, "=,;");
                        String trim = b3.substring(i2, a5).trim();
                        if (a5 == b3.length() || b3.charAt(a5) == ',' || b3.charAt(a5) == ';') {
                            i3 = a5 + 1;
                            str = null;
                        } else {
                            int b4 = f.b(b3, a5 + 1);
                            if (b4 >= b3.length() || b3.charAt(b4) != '\"') {
                                i3 = f.a(b3, b4, ",;");
                                str = b3.substring(b4, i3).trim();
                            } else {
                                int i9 = b4 + 1;
                                int a6 = f.a(b3, i9, "\"");
                                str = b3.substring(i9, a6);
                                i3 = a6 + 1;
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if ("max-age".equalsIgnoreCase(trim)) {
                            i5 = f.a(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i6 = f.a(str, -1);
                        } else if ("private".equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i7 = f.a(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i8 = f.a(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        } else if ("immutable".equalsIgnoreCase(trim)) {
                            z9 = true;
                        }
                        A a7 = a2;
                    }
                    i4++;
                    a3 = a2;
                }
            } else if (!a4.equalsIgnoreCase("Pragma")) {
                i4++;
                a3 = a2;
            }
            z = false;
            while (i2 < b3.length()) {
            }
            i4++;
            a3 = a2;
        }
        C0720i iVar = new C0720i(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
        return iVar;
    }

    C0720i(a aVar) {
        this.f8686c = aVar.f8696a;
        this.f8687d = aVar.f8697b;
        this.f8688e = aVar.f8698c;
        this.f8689f = -1;
        this.f8690g = false;
        this.f8691h = false;
        this.f8692i = false;
        this.f8693j = aVar.f8699d;
        this.f8694k = aVar.f8700e;
        this.f8695l = aVar.f8701f;
        this.m = aVar.f8702g;
        this.n = aVar.f8703h;
    }
}
