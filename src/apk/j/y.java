package j;

import java.util.Arrays;

/* compiled from: SegmentedByteString */
final class y extends i {

    /* renamed from: e reason: collision with root package name */
    final transient byte[][] f10291e;

    /* renamed from: f reason: collision with root package name */
    final transient int[] f10292f;

    y(f fVar, int i2) {
        super(null);
        D.a(fVar.f10250c, 0, (long) i2);
        int i3 = 0;
        w wVar = fVar.f10249b;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = wVar.f10284c;
            int i7 = wVar.f10283b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                wVar = wVar.f10287f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f10291e = new byte[i5][];
        this.f10292f = new int[(i5 * 2)];
        w wVar2 = fVar.f10249b;
        int i8 = 0;
        while (i3 < i2) {
            this.f10291e[i8] = wVar2.f10282a;
            i3 += wVar2.f10284c - wVar2.f10283b;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f10292f;
            iArr[i8] = i3;
            iArr[this.f10291e.length + i8] = wVar2.f10283b;
            wVar2.f10285d = true;
            i8++;
            wVar2 = wVar2.f10287f;
        }
    }

    private i h() {
        return new i(f());
    }

    private Object writeReplace() {
        return h();
    }

    public String a() {
        return h().a();
    }

    public String b() {
        return h().b();
    }

    public i c() {
        return h().c();
    }

    public i d() {
        return h().d();
    }

    public i e() {
        return h().e();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (a(0, r5, 0, size()) != false) goto L_0x0021;
     */
    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (iVar.size() == size()) {
            }
        }
        z = false;
        return z;
    }

    public byte[] f() {
        int[] iArr = this.f10292f;
        byte[][] bArr = this.f10291e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f10292f;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f10291e[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    public String g() {
        return h().g();
    }

    public int hashCode() {
        int i2 = this.f10253c;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f10291e.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            byte[] bArr = this.f10291e[i3];
            int[] iArr = this.f10292f;
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
        this.f10253c = i4;
        return i4;
    }

    public int size() {
        return this.f10292f[this.f10291e.length - 1];
    }

    public String toString() {
        return h().toString();
    }

    private int c(int i2) {
        int binarySearch = Arrays.binarySearch(this.f10292f, 0, this.f10291e.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public i a(int i2, int i3) {
        return h().a(i2, i3);
    }

    public byte b(int i2) {
        int i3;
        D.a((long) this.f10292f[this.f10291e.length - 1], (long) i2, 1);
        int c2 = c(i2);
        if (c2 == 0) {
            i3 = 0;
        } else {
            i3 = this.f10292f[c2 - 1];
        }
        int[] iArr = this.f10292f;
        byte[][] bArr = this.f10291e;
        return bArr[c2][(i2 - i3) + iArr[bArr.length + c2]];
    }

    /* access modifiers changed from: 0000 */
    public void a(f fVar) {
        int length = this.f10291e.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f10292f;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            w wVar = new w(this.f10291e[i2], i4, (i4 + i5) - i3, true, false);
            w wVar2 = fVar.f10249b;
            if (wVar2 == null) {
                wVar.f10288g = wVar;
                wVar.f10287f = wVar;
                fVar.f10249b = wVar;
            } else {
                wVar2.f10288g.a(wVar);
            }
            i2++;
            i3 = i5;
        }
        fVar.f10250c += (long) i3;
    }

    public boolean a(int i2, i iVar, int i3, int i4) {
        int i5;
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int c2 = c(i2);
        while (i4 > 0) {
            if (c2 == 0) {
                i5 = 0;
            } else {
                i5 = this.f10292f[c2 - 1];
            }
            int min = Math.min(i4, ((this.f10292f[c2] - i5) + i5) - i2);
            int[] iArr = this.f10292f;
            byte[][] bArr = this.f10291e;
            if (!iVar.a(i3, bArr[c2], (i2 - i5) + iArr[bArr.length + c2], min)) {
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
                i5 = this.f10292f[c2 - 1];
            }
            int min = Math.min(i4, ((this.f10292f[c2] - i5) + i5) - i2);
            int[] iArr = this.f10292f;
            byte[][] bArr2 = this.f10291e;
            if (!D.a(bArr2[c2], (i2 - i5) + iArr[bArr2.length + c2], bArr, i3, min)) {
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
