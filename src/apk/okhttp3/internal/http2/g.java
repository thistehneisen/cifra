package okhttp3.internal.http2;

import i.a.d;
import java.io.IOException;
import java.util.List;

/* compiled from: Http2Connection */
class g extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10579b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ List f10580c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ k f10581d;

    g(k kVar, String str, Object[] objArr, int i2, List list) {
        this.f10581d = kVar;
        this.f10579b = i2;
        this.f10580c = list;
        super(str, objArr);
    }

    public void a() {
        if (this.f10581d.f10604k.onRequest(this.f10579b, this.f10580c)) {
            try {
                this.f10581d.s.a(this.f10579b, a.CANCEL);
                synchronized (this.f10581d) {
                    this.f10581d.u.remove(Integer.valueOf(this.f10579b));
                }
            } catch (IOException unused) {
            }
        }
    }
}
