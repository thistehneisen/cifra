package e.a.b;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
final class z extends j {

    /* renamed from: e reason: collision with root package name */
    final transient byte[][] f7927e;

    /* renamed from: f reason: collision with root package name */
    final transient int[] f7928f;

    z(g gVar, int i2) {
        super(null);
        E.a(gVar.f7883c, 0, (long) i2);
        int i3 = 0;
        x xVar = gVar.f7882b;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = xVar.f7920c;
            int i7 = xVar.f7919b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                xVar = xVar.f7923f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f7927e = new byte[i5][];
        this.f7928f = new int[(i5 * 2)];
        x xVar2 = gVar.f7882b;
        int i8 = 0;
        while (i3 < i2) {
            this.f7927e[i8] = xVar2.f7918a;
            i3 += xVar2.f7920c - xVar2.f7919b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f7928f;
            iArr[i8] = i3;
            iArr[this.f7927e.length + i8] = xVar2.f7919b;
            xVar2.f7921d = true;
            i8++;
            xVar2 = xVar2.f7923f;
        }
    }

    private j i() {
        return new j(g());
    }

    private Object writeReplace() {
        return i();
    }

    public String a() {
        return i().a();
    }

    public String b() {
        return i().b();
    }

    public j c() {
        return i().c();
    }

    public j d() {
        return i().d();
    }

    public j e() {
        return i().e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (a(0, r5, 0, size()) != false) goto L_0x0021;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (jVar.size() == size()) {
            }
        }
        z = false;
        return z;
    }

    public j f() {
        return i().f();
    }

    public byte[] g() {
        int[] iArr = this.f7928f;
        byte[][] bArr = this.f7927e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f7928f;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f7927e[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    public String h() {
        return i().h();
    }

    public int hashCode() {
        int i2 = this.f7893c;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f7927e.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f7927e[i3];
            int[] iArr = this.f7928f;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.f7893c = i4;
        return i4;
    }

    public int size() {
        return this.f7928f[this.f7927e.length - 1];
    }

    public String toString() {
        return i().toString();
    }

    private int c(int i2) {
        int binarySearch = Arrays.binarySearch(this.f7928f, 0, this.f7927e.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public j a(int i2, int i3) {
        return i().a(i2, i3);
    }

    public byte b(int i2) {
        int i3;
        E.a((long) this.f7928f[this.f7927e.length - 1], (long) i2, 1);
        int c2 = c(i2);
        if (c2 == 0) {
            i3 = 0;
        } else {
            i3 = this.f7928f[c2 - 1];
        }
        int[] iArr = this.f7928f;
        byte[][] bArr = this.f7927e;
        return bArr[c2][(i2 - i3) + iArr[bArr.length + c2]];
    }

    /* access modifiers changed from: 0000 */
    public void a(g gVar) {
        int length = this.f7927e.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f7928f;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            x xVar = new x(this.f7927e[i2], i4, (i4 + i5) - i3, true, false);
            x xVar2 = gVar.f7882b;
            if (xVar2 == null) {
                xVar.f7924g = xVar;
                xVar.f7923f = xVar;
                gVar.f7882b = xVar;
            } else {
                xVar2.f7924g.a(xVar);
            }
            i2++;
            i3 = i5;
        }
        gVar.f7883c += (long) i3;
    }

    public boolean a(int i2, j jVar, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int c2 = c(i2);
        while (i4 > 0) {
            if (c2 == 0) {
                i5 = 0;
            } else {
                i5 = this.f7928f[c2 - 1];
            }
            int min = Math.min(i4, ((this.f7928f[c2] - i5) + i5) - i2);
            int[] iArr = this.f7928f;
            byte[][] bArr = this.f7927e;
            if (!jVar.a(i3, bArr[c2], (i2 - i5) + iArr[bArr.length + c2], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            c2++;
        }
        return true;
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int c2 = c(i2);
        while (i4 > 0) {
            if (c2 == 0) {
                i5 = 0;
            } else {
                i5 = this.f7928f[c2 - 1];
            }
            int min = Math.min(i4, ((this.f7928f[c2] - i5) + i5) - i2);
            int[] iArr = this.f7928f;
            byte[][] bArr2 = this.f7927e;
            if (!E.a(bArr2[c2], (i2 - i5) + iArr[bArr2.length + c2], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            c2++;
        }
        return true;
    }
}
