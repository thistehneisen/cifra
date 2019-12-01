package i;

import j.g;
import java.io.IOException;

/* compiled from: RequestBody */
class K extends L {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ D f8513a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ int f8514b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ byte[] f8515c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ int f8516d;

    K(D d2, int i2, byte[] bArr, int i3) {
        this.f8513a = d2;
        this.f8514b = i2;
        this.f8515c = bArr;
        this.f8516d = i3;
    }

    public long a() {
        return (long) this.f8514b;
    }

    public D b() {
        return this.f8513a;
    }

    public void a(g gVar) throws IOException {
        gVar.write(this.f8515c, this.f8516d, this.f8514b);
    }
}
