package j;

/* compiled from: Segment */
final class w {

    /* renamed from: a reason: collision with root package name */
    final byte[] f10282a;

    /* renamed from: b reason: collision with root package name */
    int f10283b;

    /* renamed from: c reason: collision with root package name */
    int f10284c;

    /* renamed from: d reason: collision with root package name */
    boolean f10285d;

    /* renamed from: e reason: collision with root package name */
    boolean f10286e;

    /* renamed from: f reason: collision with root package name */
    w f10287f;

    /* renamed from: g reason: collision with root package name */
    w f10288g;

    w() {
        this.f10282a = new byte[8192];
        this.f10286e = true;
        this.f10285d = false;
    }

    public final w a(w wVar) {
        wVar.f10288g = this;
        wVar.f10287f = this.f10287f;
        this.f10287f.f10288g = wVar;
        this.f10287f = wVar;
        return wVar;
    }

    public final w b() {
        w wVar = this.f10287f;
        if (wVar == this) {
            wVar = null;
        }
        w wVar2 = this.f10288g;
        wVar2.f10287f = this.f10287f;
        this.f10287f.f10288g = wVar2;
        this.f10287f = null;
        this.f10288g = null;
        return wVar;
    }

    /* access modifiers changed from: 0000 */
    public final w c() {
        this.f10285d = true;
        w wVar = new w(this.f10282a, this.f10283b, this.f10284c, true, false);
        return wVar;
    }

    w(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f10282a = bArr;
        this.f10283b = i2;
        this.f10284c = i3;
        this.f10285d = z;
        this.f10286e = z2;
    }

    public final w a(int i2) {
        w wVar;
        if (i2 <= 0 || i2 > this.f10284c - this.f10283b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            wVar = c();
        } else {
            wVar = x.a();
            System.arraycopy(this.f10282a, this.f10283b, wVar.f10282a, 0, i2);
        }
        wVar.f10284c = wVar.f10283b + i2;
        this.f10283b += i2;
        this.f10288g.a(wVar);
        return wVar;
    }

    public final void a() {
        w wVar = this.f10288g;
        if (wVar == this) {
            throw new IllegalStateException();
        } else if (wVar.f10286e) {
            int i2 = this.f10284c - this.f10283b;
            if (i2 <= (8192 - wVar.f10284c) + (wVar.f10285d ? 0 : wVar.f10283b)) {
                a(this.f10288g, i2);
                b();
                x.a(this);
            }
        }
    }

    public final void a(w wVar, int i2) {
        if (wVar.f10286e) {
            int i3 = wVar.f10284c;
            if (i3 + i2 > 8192) {
                if (!wVar.f10285d) {
                    int i4 = i3 + i2;
                    int i5 = wVar.f10283b;
                    if (i4 - i5 <= 8192) {
                        byte[] bArr = wVar.f10282a;
                        System.arraycopy(bArr, i5, bArr, 0, i3 - i5);
                        wVar.f10284c -= wVar.f10283b;
                        wVar.f10283b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f10282a, this.f10283b, wVar.f10282a, wVar.f10284c, i2);
            wVar.f10284c += i2;
            this.f10283b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
