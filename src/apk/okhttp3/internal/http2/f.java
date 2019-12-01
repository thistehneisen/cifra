package okhttp3.internal.http2;

import i.a.d;
import java.io.IOException;

/* compiled from: Http2Connection */
class f extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10576b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ long f10577c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ k f10578d;

    f(k kVar, String str, Object[] objArr, int i2, long j2) {
        this.f10578d = kVar;
        this.f10576b = i2;
        this.f10577c = j2;
        super(str, objArr);
    }

    public void a() {
        try {
            this.f10578d.s.a(this.f10576b, this.f10577c);
        } catch (IOException e2) {
            this.f10578d.a(e2);
        }
    }
}
