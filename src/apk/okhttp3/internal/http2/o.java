package okhttp3.internal.http2;

import i.a.d;
import java.io.IOException;

/* compiled from: Http2Connection */
class o extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ w f10624b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ d f10625c;

    o(d dVar, String str, Object[] objArr, w wVar) {
        this.f10625c = dVar;
        this.f10624b = wVar;
        super(str, objArr);
    }

    public void a() {
        try {
            k.this.s.a(this.f10624b);
        } catch (IOException e2) {
            k.this.a(e2);
        }
    }
}
