package okhttp3.internal.http2;

import i.a.d;
import j.f;
import java.io.IOException;

/* compiled from: Http2Connection */
class i extends d {

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f10586b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ f f10587c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ int f10588d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ boolean f10589e;

    /* renamed from: f reason: collision with root package name */
    final /* synthetic */ k f10590f;

    i(k kVar, String str, Object[] objArr, int i2, f fVar, int i3, boolean z) {
        this.f10590f = kVar;
        this.f10586b = i2;
        this.f10587c = fVar;
        this.f10588d = i3;
        this.f10589e = z;
        super(str, objArr);
    }

    public void a() {
        try {
            boolean a2 = this.f10590f.f10604k.a(this.f10586b, this.f10587c, this.f10588d, this.f10589e);
            if (a2) {
                this.f10590f.s.a(this.f10586b, a.CANCEL);
            }
            if (a2 || this.f10589e) {
                synchronized (this.f10590f) {
                    this.f10590f.u.remove(Integer.valueOf(this.f10586b));
                }
            }
        } catch (IOException unused) {
        }
    }
}
