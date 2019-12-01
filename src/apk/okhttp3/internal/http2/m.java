package okhttp3.internal.http2;

import i.a.d;
import i.a.d.e;
import java.io.IOException;

/* compiled from: Http2Connection */
class m extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ r f10621b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ d f10622c;

    m(d dVar, String str, Object[] objArr, r rVar) {
        this.f10622c = dVar;
        this.f10621b = rVar;
        super(str, objArr);
    }

    public void a() {
        try {
            k.this.f10596c.a(this.f10621b);
        } catch (IOException e2) {
            e a2 = e.a();
            StringBuilder sb = new StringBuilder();
            sb.append("Http2Connection.Listener failure for ");
            sb.append(k.this.f10598e);
            a2.a(4, sb.toString(), (Throwable) e2);
            try {
                this.f10621b.a(a.PROTOCOL_ERROR, e2);
            } catch (IOException unused) {
            }
        }
    }
}
