package i.a.a;

import i.A;
import i.C0720i;
import i.J;
import i.M;
import i.a.b.e;
import i.a.b.f;
import i.a.c;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheStrategy */
public final class d {

    /* renamed from: a reason: collision with root package name */
    public final J f8561a;

    /* renamed from: b reason: collision with root package name */
    public final M f8562b;

    /* compiled from: CacheStrategy */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        final long f8563a;

        /* renamed from: b reason: collision with root package name */
        final J f8564b;

        /* renamed from: c reason: collision with root package name */
        final M f8565c;

        /* renamed from: d reason: collision with root package name */
        private Date f8566d;

        /* renamed from: e reason: collision with root package name */
        private String f8567e;

        /* renamed from: f reason: collision with root package name */
        private Date f8568f;

        /* renamed from: g reason: collision with root package name */
        private String f8569g;

        /* renamed from: h reason: collision with root package name */
        private Date f8570h;

        /* renamed from: i reason: collision with root package name */
        private long f8571i;

        /* renamed from: j reason: collision with root package name */
        private long f8572j;

        /* renamed from: k reason: collision with root package name */
        private String f8573k;

        /* renamed from: l reason: collision with root package name */
        private int f8574l = -1;

        public a(long j2, J j3, M m) {
            this.f8563a = j2;
            this.f8564b = j3;
            this.f8565c = m;
            if (m != null) {
                this.f8571i = m.l();
                this.f8572j = m.j();
                A e2 = m.e();
                int b2 = e2.b();
                for (int i2 = 0; i2 < b2; i2++) {
                    String a2 = e2.a(i2);
                    String b3 = e2.b(i2);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f8566d = e.a(b3);
                        this.f8567e = b3;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f8570h = e.a(b3);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f8568f = e.a(b3);
                        this.f8569g = b3;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.f8573k = b3;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.f8574l = f.a(b3, -1);
                    }
                }
            }
        }

        private long b() {
            Date date = this.f8566d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0, this.f8572j - date.getTime());
            }
            int i2 = this.f8574l;
            if (i2 != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) i2));
            }
            long j3 = this.f8572j;
            return j2 + (j3 - this.f8571i) + (this.f8563a - j3);
        }

        private long c() {
            long j2;
            long j3;
            C0720i b2 = this.f8565c.b();
            if (b2.c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) b2.c());
            }
            long j4 = 0;
            if (this.f8570h != null) {
                Date date = this.f8566d;
                if (date != null) {
                    j3 = date.getTime();
                } else {
                    j3 = this.f8572j;
                }
                long time = this.f8570h.getTime() - j3;
                if (time > 0) {
                    j4 = time;
                }
                return j4;
            }
            if (this.f8568f != null && this.f8565c.k().g().l() == null) {
                Date date2 = this.f8566d;
                if (date2 != null) {
                    j2 = date2.getTime();
                } else {
                    j2 = this.f8571i;
                }
                long time2 = j2 - this.f8568f.getTime();
                if (time2 > 0) {
                    j4 = time2 / 10;
                }
            }
            return j4;
        }

        private d d() {
            if (this.f8565c == null) {
                return new d(this.f8564b, null);
            }
            if (this.f8564b.d() && this.f8565c.d() == null) {
                return new d(this.f8564b, null);
            }
            if (!d.a(this.f8565c, this.f8564b)) {
                return new d(this.f8564b, null);
            }
            C0720i b2 = this.f8564b.b();
            if (b2.g() || a(this.f8564b)) {
                return new d(this.f8564b, null);
            }
            C0720i b3 = this.f8565c.b();
            long b4 = b();
            long c2 = c();
            if (b2.c() != -1) {
                c2 = Math.min(c2, TimeUnit.SECONDS.toMillis((long) b2.c()));
            }
            long j2 = 0;
            long millis = b2.e() != -1 ? TimeUnit.SECONDS.toMillis((long) b2.e()) : 0;
            if (!b3.f() && b2.d() != -1) {
                j2 = TimeUnit.SECONDS.toMillis((long) b2.d());
            }
            if (!b3.g()) {
                long j3 = millis + b4;
                if (j3 < j2 + c2) {
                    i.M.a h2 = this.f8565c.h();
                    String str = "Warning";
                    if (j3 >= c2) {
                        h2.a(str, "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (b4 > 86400000 && e()) {
                        h2.a(str, "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new d(null, h2.a());
                }
            }
            String str2 = this.f8573k;
            String str3 = "If-Modified-Since";
            if (str2 != null) {
                str3 = "If-None-Match";
            } else if (this.f8568f != null) {
                str2 = this.f8569g;
            } else if (this.f8566d == null) {
                return new d(this.f8564b, null);
            } else {
                str2 = this.f8567e;
            }
            i.A.a a2 = this.f8564b.c().a();
            c.f8601a.a(a2, str3, str2);
            i.J.a f2 = this.f8564b.f();
            f2.a(a2.a());
            return new d(f2.a(), this.f8565c);
        }

        private boolean e() {
            return this.f8565c.b().c() == -1 && this.f8570h == null;
        }

        public d a() {
            d d2 = d();
            return (d2.f8561a == null || !this.f8564b.b().i()) ? d2 : new d(null, null);
        }

        private static boolean a(J j2) {
            return (j2.a("If-Modified-Since") == null && j2.a("If-None-Match") == null) ? false : true;
        }
    }

    d(J j2, M m) {
        this.f8561a = j2;
        this.f8562b = m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.b().a() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    public static boolean a(M m, J j2) {
        int c2 = m.c();
        boolean z = false;
        if (!(c2 == 200 || c2 == 410 || c2 == 414 || c2 == 501 || c2 == 203 || c2 == 204)) {
            if (c2 != 307) {
                if (!(c2 == 308 || c2 == 404 || c2 == 405)) {
                    switch (c2) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                    }
                }
            }
            if (m.b("Expires") == null) {
                if (m.b().c() == -1) {
                    if (!m.b().b()) {
                    }
                }
            }
        }
        if (!m.b().h() && !j2.b().h()) {
            z = true;
        }
        return z;
    }
}
