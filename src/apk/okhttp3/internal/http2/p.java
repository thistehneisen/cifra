package okhttp3.internal.http2;

import i.A;
import i.C.a;
import i.G;
import i.H;
import i.J;
import i.M;
import i.a.b.c;
import i.a.b.j;
import i.a.b.l;
import i.a.e;
import j.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.f;

/* compiled from: Http2ExchangeCodec */
public final class p implements c {

    /* renamed from: a reason: collision with root package name */
    private static final List<String> f10626a = e.a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* renamed from: b reason: collision with root package name */
    private static final List<String> f10627b = e.a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: c reason: collision with root package name */
    private final a f10628c;

    /* renamed from: d reason: collision with root package name */
    private final f f10629d;

    /* renamed from: e reason: collision with root package name */
    private final k f10630e;

    /* renamed from: f reason: collision with root package name */
    private volatile r f10631f;

    /* renamed from: g reason: collision with root package name */
    private final H f10632g;

    /* renamed from: h reason: collision with root package name */
    private volatile boolean f10633h;

    public p(G g2, f fVar, a aVar, k kVar) {
        H h2;
        this.f10629d = fVar;
        this.f10628c = aVar;
        this.f10630e = kVar;
        if (g2.r().contains(H.H2_PRIOR_KNOWLEDGE)) {
            h2 = H.H2_PRIOR_KNOWLEDGE;
        } else {
            h2 = H.HTTP_2;
        }
        this.f10632g = h2;
    }

    public static List<b> b(J j2) {
        A c2 = j2.c();
        ArrayList arrayList = new ArrayList(c2.b() + 4);
        arrayList.add(new b(b.f10542c, j2.e()));
        arrayList.add(new b(b.f10543d, j.a(j2.g())));
        String a2 = j2.a("Host");
        if (a2 != null) {
            arrayList.add(new b(b.f10545f, a2));
        }
        arrayList.add(new b(b.f10544e, j2.g().n()));
        int b2 = c2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            String lowerCase = c2.a(i2).toLowerCase(Locale.US);
            if (!f10626a.contains(lowerCase) || (lowerCase.equals("te") && c2.b(i2).equals("trailers"))) {
                arrayList.add(new b(lowerCase, c2.b(i2)));
            }
        }
        return arrayList;
    }

    public z a(J j2, long j3) {
        return this.f10631f.d();
    }

    public void cancel() {
        this.f10633h = true;
        if (this.f10631f != null) {
            this.f10631f.a(a.CANCEL);
        }
    }

    public f connection() {
        return this.f10629d;
    }

    public void finishRequest() throws IOException {
        this.f10631f.d().close();
    }

    public void flushRequest() throws IOException {
        this.f10630e.flush();
    }

    public M.a readResponseHeaders(boolean z) throws IOException {
        M.a a2 = a(this.f10631f.i(), this.f10632g);
        if (!z || i.a.c.f8601a.a(a2) != 100) {
            return a2;
        }
        return null;
    }

    public void a(J j2) throws IOException {
        if (this.f10631f == null) {
            this.f10631f = this.f10630e.a(b(j2), j2.a() != null);
            if (!this.f10633h) {
                this.f10631f.h().a((long) this.f10628c.readTimeoutMillis(), TimeUnit.MILLISECONDS);
                this.f10631f.k().a((long) this.f10628c.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
                return;
            }
            this.f10631f.a(a.CANCEL);
            throw new IOException("Canceled");
        }
    }

    public static M.a a(A a2, H h2) throws IOException {
        A.a aVar = new A.a();
        int b2 = a2.b();
        l lVar = null;
        for (int i2 = 0; i2 < b2; i2++) {
            String a3 = a2.a(i2);
            String b3 = a2.b(i2);
            if (a3.equals(":status")) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP/1.1 ");
                sb.append(b3);
                lVar = l.a(sb.toString());
            } else if (!f10627b.contains(a3)) {
                i.a.c.f8601a.a(aVar, a3, b3);
            }
        }
        if (lVar != null) {
            M.a aVar2 = new M.a();
            aVar2.a(h2);
            aVar2.a(lVar.f8599b);
            aVar2.a(lVar.f8600c);
            aVar2.a(aVar.a());
            return aVar2;
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public long b(M m) {
        return i.a.b.f.a(m);
    }

    public j.A a(M m) {
        return this.f10631f.e();
    }
}
