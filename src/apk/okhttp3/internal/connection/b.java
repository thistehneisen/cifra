package okhttp3.internal.connection;

import i.C;
import i.C.a;
import i.G;
import i.J;
import i.M;
import i.a.b.h;
import java.io.IOException;

/* compiled from: ConnectInterceptor */
public final class b implements C {

    /* renamed from: a reason: collision with root package name */
    public final G f10455a;

    public b(G g2) {
        this.f10455a = g2;
    }

    public M a(a aVar) throws IOException {
        h hVar = (h) aVar;
        J request = hVar.request();
        k b2 = hVar.b();
        return hVar.a(request, b2, b2.a(aVar, !request.e().equals("GET")));
    }
}
