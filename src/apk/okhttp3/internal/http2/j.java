package okhttp3.internal.http2;

import i.a.d;

/* compiled from: Http2Connection */
class j extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10591b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ a f10592c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ k f10593d;

    j(k kVar, String str, Object[] objArr, int i2, a aVar) {
        this.f10593d = kVar;
        this.f10591b = i2;
        this.f10592c = aVar;
        super(str, objArr);
    }

    public void a() {
        this.f10593d.f10604k.a(this.f10591b, this.f10592c);
        synchronized (this.f10593d) {
            this.f10593d.u.remove(Integer.valueOf(this.f10591b));
        }
    }
}
