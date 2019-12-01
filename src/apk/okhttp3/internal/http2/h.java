package okhttp3.internal.http2;

import i.a.d;
import java.io.IOException;
import java.util.List;

/* compiled from: Http2Connection */
class h extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10582b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ List f10583c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ boolean f10584d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ k f10585e;

    h(k kVar, String str, Object[] objArr, int i2, List list, boolean z) {
        this.f10585e = kVar;
        this.f10582b = i2;
        this.f10583c = list;
        this.f10584d = z;
        super(str, objArr);
    }

    public void a() {
        boolean onHeaders = this.f10585e.f10604k.onHeaders(this.f10582b, this.f10583c, this.f10584d);
        if (onHeaders) {
            try {
                this.f10585e.s.a(this.f10582b, a.CANCEL);
            } catch (IOException unused) {
                return;
            }
        }
        if (onHeaders || this.f10584d) {
            synchronized (this.f10585e) {
                this.f10585e.u.remove(Integer.valueOf(this.f10582b));
            }
        }
    }
}
