package retrofit2;

import i.A;
import i.B;
import i.D;
import i.E;
import i.E.b;
import i.J;
import i.L;
import j.f;
import j.g;
import java.io.IOException;

/* compiled from: RequestBuilder */
final class t {

    /* renamed from: a reason: collision with root package name */
    private static final char[] f11047a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b reason: collision with root package name */
    private final String f11048b;

    /* renamed from: c reason: collision with root package name */
    private final B f11049c;

    /* renamed from: d reason: collision with root package name */
    private String f11050d;

    /* renamed from: e reason: collision with root package name */
    private i.B.a f11051e;

    /* renamed from: f reason: collision with root package name */
    private final i.J.a f11052f = new i.J.a();

    /* renamed from: g reason: collision with root package name */
    private D f11053g;

    /* renamed from: h reason: collision with root package name */
    private final boolean f11054h;

    /* renamed from: i reason: collision with root package name */
    private i.E.a f11055i;

    /* renamed from: j reason: collision with root package name */
    private i.y.a f11056j;

    /* renamed from: k reason: collision with root package name */
    private L f11057k;

    /* compiled from: RequestBuilder */
    private static class a extends L {

        /* renamed from: a reason: collision with root package name */
        private final L f11058a;

        /* renamed from: b reason: collision with root package name */
        private final D f11059b;

        a(L l2, D d2) {
            this.f11058a = l2;
            this.f11059b = d2;
        }

        public long a() throws IOException {
            return this.f11058a.a();
        }

        public D b() {
            return this.f11059b;
        }

        public void a(g gVar) throws IOException {
            this.f11058a.a(gVar);
        }
    }

    t(String str, B b2, String str2, A a2, D d2, boolean z, boolean z2, boolean z3) {
        this.f11048b = str;
        this.f11049c = b2;
        this.f11050d = str2;
        this.f11053g = d2;
        this.f11054h = z;
        if (a2 != null) {
            this.f11052f.a(a2);
        }
        if (z2) {
            this.f11056j = new i.y.a();
        } else if (z3) {
            this.f11055i = new i.E.a();
            this.f11055i.a(E.f8450e);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            D b2 = D.b(str2);
            if (b2 != null) {
                this.f11053g = b2;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed content type: ");
            sb.append(str2);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f11052f.a(str, str2);
    }

    /* access modifiers changed from: 0000 */
    public void b(String str, String str2, boolean z) {
        String str3 = this.f11050d;
        if (str3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(str);
            sb.append("}");
            this.f11050d = str3.replace(sb.toString(), a(str2, z));
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: 0000 */
    public void c(String str, String str2, boolean z) {
        String str3 = this.f11050d;
        if (str3 != null) {
            this.f11051e = this.f11049c.c(str3);
            if (this.f11051e != null) {
                this.f11050d = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.f11049c);
                sb.append(", Relative: ");
                sb.append(this.f11050d);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (z) {
            this.f11051e.a(str, str2);
        } else {
            this.f11051e.b(str, str2);
        }
    }

    private static String a(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                f fVar = new f();
                fVar.a(str, 0, i2);
                a(fVar, str, i2, length, z);
                return fVar.e();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void a(f fVar, String str, int i2, int i3, boolean z) {
        f fVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(codePointAt) != -1 || (!z && (codePointAt == 47 || codePointAt == 37))) {
                    if (fVar2 == null) {
                        fVar2 = new f();
                    }
                    fVar2.c(codePointAt);
                    while (!fVar2.o()) {
                        byte readByte = fVar2.readByte() & 255;
                        fVar.writeByte(37);
                        fVar.writeByte((int) f11047a[(readByte >> 4) & 15]);
                        fVar.writeByte((int) f11047a[readByte & 15]);
                    }
                } else {
                    fVar.c(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(String str, String str2, boolean z) {
        if (z) {
            this.f11056j.b(str, str2);
        } else {
            this.f11056j.a(str, str2);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(A a2, L l2) {
        this.f11055i.a(a2, l2);
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        this.f11055i.a(bVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(L l2) {
        this.f11057k = l2;
    }

    /* access modifiers changed from: 0000 */
    public J a() {
        B b2;
        i.B.a aVar = this.f11051e;
        if (aVar != null) {
            b2 = aVar.a();
        } else {
            b2 = this.f11049c.f(this.f11050d);
            if (b2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.f11049c);
                sb.append(", Relative: ");
                sb.append(this.f11050d);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        L l2 = this.f11057k;
        if (l2 == null) {
            i.y.a aVar2 = this.f11056j;
            if (aVar2 != null) {
                l2 = aVar2.a();
            } else {
                i.E.a aVar3 = this.f11055i;
                if (aVar3 != null) {
                    l2 = aVar3.a();
                } else if (this.f11054h) {
                    l2 = L.a(null, new byte[0]);
                }
            }
        }
        D d2 = this.f11053g;
        if (d2 != null) {
            if (l2 != null) {
                l2 = new a(l2, d2);
            } else {
                this.f11052f.a("Content-Type", d2.toString());
            }
        }
        i.J.a aVar4 = this.f11052f;
        aVar4.a(b2);
        aVar4.a(this.f11048b, l2);
        return aVar4.a();
    }
}
