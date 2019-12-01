package e.a.b;

/* compiled from: Segment */
final class x {

    /* renamed from: a reason: collision with root package name */
    final byte[] f7918a;

    /* renamed from: b reason: collision with root package name */
    int f7919b;

    /* renamed from: c reason: collision with root package name */
    int f7920c;

    /* renamed from: d reason: collision with root package name */
    boolean f7921d;

    /* renamed from: e reason: collision with root package name */
    boolean f7922e;

    /* renamed from: f reason: collision with root package name */
    x f7923f;

    /* renamed from: g reason: collision with root package name */
    x f7924g;

    x() {
        this.f7918a = new byte[8192];
        this.f7922e = true;
        this.f7921d = false;
    }

    public x a(x xVar) {
        xVar.f7924g = this;
        xVar.f7923f = this.f7923f;
        this.f7923f.f7924g = xVar;
        this.f7923f = xVar;
        return xVar;
    }

    public x b() {
        x xVar = this.f7923f;
        if (xVar == this) {
            xVar = null;
        }
        x xVar2 = this.f7924g;
        xVar2.f7923f = this.f7923f;
        this.f7923f.f7924g = xVar2;
        this.f7923f = null;
        this.f7924g = null;
        return xVar;
    }

    /* access modifiers changed from: 0000 */
    public x c() {
        this.f7921d = true;
        x xVar = new x(this.f7918a, this.f7919b, this.f7920c, true, false);
        return xVar;
    }

    /* access modifiers changed from: 0000 */
    public x d() {
        x xVar = new x((byte[]) this.f7918a.clone(), this.f7919b, this.f7920c, false, true);
        return xVar;
    }

    x(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f7918a = bArr;
        this.f7919b = i2;
        this.f7920c = i3;
        this.f7921d = z;
        this.f7922e = z2;
    }

    public x a(int i2) {
        x xVar;
        if (i2 <= 0 || i2 > this.f7920c - this.f7919b) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            xVar = c();
        } else {
            xVar = y.a();
            System.arraycopy(this.f7918a, this.f7919b, xVar.f7918a, 0, i2);
        }
        xVar.f7920c = xVar.f7919b + i2;
        this.f7919b += i2;
        this.f7924g.a(xVar);
        return xVar;
    }

    public void a() {
        x xVar = this.f7924g;
        if (xVar == this) {
            throw new IllegalStateException();
        } else if (xVar.f7922e) {
            int i2 = this.f7920c - this.f7919b;
            if (i2 <= (8192 - xVar.f7920c) + (xVar.f7921d ? 0 : xVar.f7919b)) {
                a(this.f7924g, i2);
                b();
                y.a(this);
            }
        }
    }

    public void a(x xVar, int i2) {
        if (xVar.f7922e) {
            int i3 = xVar.f7920c;
            if (i3 + i2 > 8192) {
                if (!xVar.f7921d) {
                    int i4 = i3 + i2;
                    int i5 = xVar.f7919b;
                    if (i4 - i5 <= 8192) {
                        byte[] bArr = xVar.f7918a;
                        System.arraycopy(bArr, i5, bArr, 0, i3 - i5);
                        xVar.f7920c -= xVar.f7919b;
                        xVar.f7919b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f7918a, this.f7919b, xVar.f7918a, xVar.f7920c, i2);
            xVar.f7920c += i2;
            this.f7919b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
