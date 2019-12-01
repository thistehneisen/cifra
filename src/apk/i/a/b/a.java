package i.a.b;

import i.C;
import i.C0728q;
import i.C0729s;
import i.D;
import i.J;
import i.L;
import i.M;
import i.O;
import i.a.e;
import i.a.f;
import io.fabric.sdk.android.a.b.C0730a;
import j.A;
import j.m;
import j.r;
import java.io.IOException;
import java.util.List;

/* compiled from: BridgeInterceptor */
public final class a implements C {

    /* renamed from: a reason: collision with root package name */
    private final C0729s f8577a;

    public a(C0729s sVar) {
        this.f8577a = sVar;
    }

    public M a(i.C.a aVar) throws IOException {
        J request = aVar.request();
        i.J.a f2 = request.f();
        L a2 = request.a();
        String str = "Content-Type";
        String str2 = "Content-Length";
        if (a2 != null) {
            D b2 = a2.b();
            if (b2 != null) {
                f2.b(str, b2.toString());
            }
            long a3 = a2.a();
            String str3 = "Transfer-Encoding";
            if (a3 != -1) {
                f2.b(str2, Long.toString(a3));
                f2.a(str3);
            } else {
                f2.b(str3, "chunked");
                f2.a(str2);
            }
        }
        String str4 = "Host";
        boolean z = false;
        if (request.a(str4) == null) {
            f2.b(str4, e.a(request.g(), false));
        }
        String str5 = "Connection";
        if (request.a(str5) == null) {
            f2.b(str5, "Keep-Alive");
        }
        String str6 = "Accept-Encoding";
        String str7 = "gzip";
        if (request.a(str6) == null && request.a("Range") == null) {
            z = true;
            f2.b(str6, str7);
        }
        List a4 = this.f8577a.a(request.g());
        if (!a4.isEmpty()) {
            f2.b("Cookie", a(a4));
        }
        String str8 = C0730a.HEADER_USER_AGENT;
        if (request.a(str8) == null) {
            f2.b(str8, f.a());
        }
        M a5 = aVar.a(f2.a());
        f.a(this.f8577a, request.g(), a5.e());
        i.M.a h2 = a5.h();
        h2.a(request);
        if (z) {
            String str9 = "Content-Encoding";
            if (str7.equalsIgnoreCase(a5.b(str9)) && f.b(a5)) {
                m mVar = new m(a5.a().d());
                i.A.a a6 = a5.e().a();
                a6.b(str9);
                a6.b(str2);
                h2.a(a6.a());
                h2.a((O) new i(a5.b(str), -1, r.a((A) mVar)));
            }
        }
        return h2.a();
    }

    private String a(List<C0728q> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            C0728q qVar = (C0728q) list.get(i2);
            sb.append(qVar.e());
            sb.append('=');
            sb.append(qVar.i());
        }
        return sb.toString();
    }
}
