package i.a.b;

import i.C;
import i.C.a;
import i.J;
import i.M;
import i.a.e;
import j.g;
import j.r;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.internal.connection.d;

/* compiled from: CallServerInterceptor */
public final class b implements C {

    /* renamed from: a reason: collision with root package name */
    private final boolean f8578a;

    public b(boolean z) {
        this.f8578a = z;
    }

    public M a(a aVar) throws IOException {
        boolean z;
        M m;
        h hVar = (h) aVar;
        d a2 = hVar.a();
        J request = hVar.request();
        long currentTimeMillis = System.currentTimeMillis();
        a2.a(request);
        M.a aVar2 = null;
        if (!g.b(request.e()) || request.a() == null) {
            a2.h();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.a("Expect"))) {
                a2.e();
                a2.i();
                aVar2 = a2.a(true);
                z = true;
            } else {
                z = false;
            }
            if (aVar2 != null) {
                a2.h();
                if (!a2.b().c()) {
                    a2.g();
                }
            } else if (request.a().c()) {
                a2.e();
                request.a().a(r.a(a2.a(request, true)));
            } else {
                g a3 = r.a(a2.a(request, false));
                request.a().a(a3);
                a3.close();
            }
        }
        if (request.a() == null || !request.a().c()) {
            a2.d();
        }
        if (!z) {
            a2.i();
        }
        if (aVar2 == null) {
            aVar2 = a2.a(false);
        }
        aVar2.a(request);
        aVar2.a(a2.b().b());
        aVar2.b(currentTimeMillis);
        aVar2.a(System.currentTimeMillis());
        M a4 = aVar2.a();
        int c2 = a4.c();
        if (c2 == 100) {
            M.a a5 = a2.a(false);
            a5.a(request);
            a5.a(a2.b().b());
            a5.b(currentTimeMillis);
            a5.a(System.currentTimeMillis());
            a4 = a5.a();
            c2 = a4.c();
        }
        a2.b(a4);
        if (!this.f8578a || c2 != 101) {
            M.a h2 = a4.h();
            h2.a(a2.a(a4));
            m = h2.a();
        } else {
            M.a h3 = a4.h();
            h3.a(e.f8656d);
            m = h3.a();
        }
        String str = "Connection";
        String str2 = "close";
        if (str2.equalsIgnoreCase(m.k().a(str)) || str2.equalsIgnoreCase(m.b(str))) {
            a2.g();
        }
        if ((c2 != 204 && c2 != 205) || m.a().b() <= 0) {
            return m;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(c2);
        sb.append(" had non-zero Content-Length: ");
        sb.append(m.a().b());
        throw new ProtocolException(sb.toString());
    }
}
