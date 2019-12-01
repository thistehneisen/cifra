package i.a.a;

import i.C;
import i.C.a;
import i.H;
import i.J;
import i.M;
import i.O;
import i.a.b.f;
import i.a.b.g;
import i.a.b.i;
import i.a.c;
import i.a.e;
import j.A;
import j.r;
import j.z;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: CacheInterceptor */
public final class b implements C {

    /* renamed from: a reason: collision with root package name */
    final e f8560a;

    public b(e eVar) {
        this.f8560a = eVar;
    }

    static boolean b(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    public M a(a aVar) throws IOException {
        e eVar = this.f8560a;
        M b2 = eVar != null ? eVar.b(aVar.request()) : null;
        d a2 = new d.a(System.currentTimeMillis(), aVar.request(), b2).a();
        J j2 = a2.f8561a;
        M m = a2.f8562b;
        e eVar2 = this.f8560a;
        if (eVar2 != null) {
            eVar2.a(a2);
        }
        if (b2 != null && m == null) {
            e.a((Closeable) b2.a());
        }
        if (j2 == null && m == null) {
            M.a aVar2 = new M.a();
            aVar2.a(aVar.request());
            aVar2.a(H.HTTP_1_1);
            aVar2.a(504);
            aVar2.a("Unsatisfiable Request (only-if-cached)");
            aVar2.a(e.f8656d);
            aVar2.b(-1);
            aVar2.a(System.currentTimeMillis());
            return aVar2.a();
        } else if (j2 == null) {
            M.a h2 = m.h();
            h2.a(a(m));
            return h2.a();
        } else {
            try {
                M a3 = aVar.a(j2);
                if (a3 == null && b2 != null) {
                }
                if (m != null) {
                    if (a3.c() == 304) {
                        M.a h3 = m.h();
                        h3.a(a(m.e(), a3.e()));
                        h3.b(a3.l());
                        h3.a(a3.j());
                        h3.a(a(m));
                        h3.b(a(a3));
                        M a4 = h3.a();
                        a3.a().close();
                        this.f8560a.trackConditionalCacheHit();
                        this.f8560a.a(m, a4);
                        return a4;
                    }
                    e.a((Closeable) m.a());
                }
                M.a h4 = a3.h();
                h4.a(a(m));
                h4.b(a(a3));
                M a5 = h4.a();
                if (this.f8560a != null) {
                    if (f.b(a5) && d.a(a5, j2)) {
                        return a(this.f8560a.a(a5), a5);
                    }
                    if (g.a(j2.e())) {
                        try {
                            this.f8560a.a(j2);
                        } catch (IOException unused) {
                        }
                    }
                }
                return a5;
            } finally {
                if (b2 != null) {
                    e.a((Closeable) b2.a());
                }
            }
        }
    }

    private static M a(M m) {
        if (m == null || m.a() == null) {
            return m;
        }
        M.a h2 = m.h();
        h2.a((O) null);
        return h2.a();
    }

    private M a(c cVar, M m) throws IOException {
        if (cVar == null) {
            return m;
        }
        z body = cVar.body();
        if (body == null) {
            return m;
        }
        a aVar = new a(this, m.a().d(), cVar, r.a(body));
        String b2 = m.b("Content-Type");
        long b3 = m.a().b();
        M.a h2 = m.h();
        h2.a((O) new i(b2, b3, r.a((A) aVar)));
        return h2.a();
    }

    private static i.A a(i.A a2, i.A a3) {
        i.A.a aVar = new i.A.a();
        int b2 = a2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            String a4 = a2.a(i2);
            String b3 = a2.b(i2);
            if ((!"Warning".equalsIgnoreCase(a4) || !b3.startsWith("1")) && (a(a4) || !b(a4) || a3.b(a4) == null)) {
                c.f8601a.a(aVar, a4, b3);
            }
        }
        int b4 = a3.b();
        for (int i3 = 0; i3 < b4; i3++) {
            String a5 = a3.a(i3);
            if (!a(a5) && b(a5)) {
                c.f8601a.a(aVar, a5, a3.b(i3));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
