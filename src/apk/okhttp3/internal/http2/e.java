package okhttp3.internal.http2;

import i.a.d;
import java.io.IOException;

/* compiled from: Http2Connection */
class e extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10573b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ a f10574c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ k f10575d;

    e(k kVar, String str, Object[] objArr, int i2, a aVar) {
        this.f10575d = kVar;
        this.f10573b = i2;
        this.f10574c = aVar;
        super(str, objArr);
    }

    public void a() {
        try {
            this.f10575d.b(this.f10573b, this.f10574c);
        } catch (IOException e2) {
            this.f10575d.a(e2);
        }
    }
}
