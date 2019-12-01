package i;

import i.a.e;
import j.f;
import j.g;
import j.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: MultipartBody */
public final class E extends L {

    /* renamed from: a reason: collision with root package name */
    public static final D f8446a = D.a("multipart/mixed");

    /* renamed from: b reason: collision with root package name */
    public static final D f8447b = D.a("multipart/alternative");

    /* renamed from: c reason: collision with root package name */
    public static final D f8448c = D.a("multipart/digest");

    /* renamed from: d reason: collision with root package name */
    public static final D f8449d = D.a("multipart/parallel");

    /* renamed from: e reason: collision with root package name */
    public static final D f8450e = D.a("multipart/form-data");

    /* renamed from: f reason: collision with root package name */
    private static final byte[] f8451f = {58, 32};

    /* renamed from: g reason: collision with root package name */
    private static final byte[] f8452g = {13, 10};

    /* renamed from: h reason: collision with root package name */
    private static final byte[] f8453h = {45, 45};

    /* renamed from: i reason: collision with root package name */
    private final i f8454i;

    /* renamed from: j reason: collision with root package name */
    private final D f8455j;

    /* renamed from: k reason: collision with root package name */
    private final D f8456k;

    /* renamed from: l reason: collision with root package name */
    private final List<b> f8457l;
    private long m = -1;

    /* compiled from: MultipartBody */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final i f8458a;

        /* renamed from: b reason: collision with root package name */
        private D f8459b;

        /* renamed from: c reason: collision with root package name */
        private final List<b> f8460c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(D d2) {
            if (d2 == null) {
                throw new NullPointerException("type == null");
            } else if (d2.a().equals("multipart")) {
                this.f8459b = d2;
                return this;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("multipart != ");
                sb.append(d2);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public a(String str) {
            this.f8459b = E.f8446a;
            this.f8460c = new ArrayList();
            this.f8458a = i.c(str);
        }

        public a a(A a2, L l2) {
            a(b.a(a2, l2));
            return this;
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f8460c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public E a() {
            if (!this.f8460c.isEmpty()) {
                return new E(this.f8458a, this.f8459b, this.f8460c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* compiled from: MultipartBody */
    public static final class b {

        /* renamed from: a reason: collision with root package name */
        final A f8461a;

        /* renamed from: b reason: collision with root package name */
        final L f8462b;

        private b(A a2, L l2) {
            this.f8461a = a2;
            this.f8462b = l2;
        }

        public static b a(A a2, L l2) {
            if (l2 == null) {
                throw new NullPointerException("body == null");
            } else if (a2 != null && a2.b("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            } else if (a2 == null || a2.b("Content-Length") == null) {
                return new b(a2, l2);
            } else {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
        }
    }

    E(i iVar, D d2, List<b> list) {
        this.f8454i = iVar;
        this.f8455j = d2;
        StringBuilder sb = new StringBuilder();
        sb.append(d2);
        sb.append("; boundary=");
        sb.append(iVar.g());
        this.f8456k = D.a(sb.toString());
        this.f8457l = e.a(list);
    }

    public long a() throws IOException {
        long j2 = this.m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a(null, true);
        this.m = a2;
        return a2;
    }

    public D b() {
        return this.f8456k;
    }

    public void a(g gVar) throws IOException {
        a(gVar, false);
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [j.g] */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r13v3, types: [j.f] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r13v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    private long a(g gVar, boolean z) throws IOException {
        f fVar;
        if (z) {
            r13 = new f();
            fVar = r13;
            r13 = r13;
        } else {
            r13 = gVar;
            fVar = 0;
        }
        int size = this.f8457l.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.f8457l.get(i2);
            A a2 = bVar.f8461a;
            L l2 = bVar.f8462b;
            r13.write(f8453h);
            r13.a(this.f8454i);
            r13.write(f8452g);
            if (a2 != null) {
                int b2 = a2.b();
                for (int i3 = 0; i3 < b2; i3++) {
                    r13.a(a2.a(i3)).write(f8451f).a(a2.b(i3)).write(f8452g);
                }
            }
            D b3 = l2.b();
            if (b3 != null) {
                r13.a("Content-Type: ").a(b3.toString()).write(f8452g);
            }
            long a3 = l2.a();
            if (a3 != -1) {
                r13.a("Content-Length: ").g(a3).write(f8452g);
            } else if (z) {
                fVar.a();
                return -1;
            }
            r13.write(f8452g);
            if (z) {
                j2 += a3;
            } else {
                l2.a(r13);
            }
            r13.write(f8452g);
        }
        r13.write(f8453h);
        r13.a(this.f8454i);
        r13.write(f8453h);
        r13.write(f8452g);
        if (z) {
            j2 += fVar.size();
            fVar.a();
        }
        return j2;
    }
}
