package com.fasterxml.jackson.core.d;

import com.fasterxml.jackson.core.e.f;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BytesToNameCanonicalizer */
public final class a {

    /* renamed from: a reason: collision with root package name */
    protected final a f4294a;

    /* renamed from: b reason: collision with root package name */
    protected final AtomicReference<b> f4295b;

    /* renamed from: c reason: collision with root package name */
    private final int f4296c;

    /* renamed from: d reason: collision with root package name */
    protected boolean f4297d;

    /* renamed from: e reason: collision with root package name */
    protected final boolean f4298e;

    /* renamed from: f reason: collision with root package name */
    protected int f4299f;

    /* renamed from: g reason: collision with root package name */
    protected int f4300g;

    /* renamed from: h reason: collision with root package name */
    protected int f4301h;

    /* renamed from: i reason: collision with root package name */
    protected int[] f4302i;

    /* renamed from: j reason: collision with root package name */
    protected f[] f4303j;

    /* renamed from: k reason: collision with root package name */
    protected C0058a[] f4304k;

    /* renamed from: l reason: collision with root package name */
    protected int f4305l;
    protected int m;
    private transient boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    protected BitSet r;

    /* renamed from: com.fasterxml.jackson.core.d.a$a reason: collision with other inner class name */
    /* compiled from: BytesToNameCanonicalizer */
    private static final class C0058a {

        /* renamed from: a reason: collision with root package name */
        public final f f4306a;

        /* renamed from: b reason: collision with root package name */
        public final C0058a f4307b;

        /* renamed from: c reason: collision with root package name */
        public final int f4308c;

        /* renamed from: d reason: collision with root package name */
        public final int f4309d;

        C0058a(f fVar, C0058a aVar) {
            this.f4306a = fVar;
            this.f4307b = aVar;
            int i2 = 1;
            if (aVar != null) {
                i2 = 1 + aVar.f4309d;
            }
            this.f4309d = i2;
            this.f4308c = fVar.hashCode();
        }

        public f a(int i2, int i3, int i4) {
            if (this.f4308c == i2 && this.f4306a.a(i3, i4)) {
                return this.f4306a;
            }
            for (C0058a aVar = this.f4307b; aVar != null; aVar = aVar.f4307b) {
                if (aVar.f4308c == i2) {
                    f fVar = aVar.f4306a;
                    if (fVar.a(i3, i4)) {
                        return fVar;
                    }
                }
            }
            return null;
        }

        public f a(int i2, int[] iArr, int i3) {
            if (this.f4308c == i2 && this.f4306a.a(iArr, i3)) {
                return this.f4306a;
            }
            for (C0058a aVar = this.f4307b; aVar != null; aVar = aVar.f4307b) {
                if (aVar.f4308c == i2) {
                    f fVar = aVar.f4306a;
                    if (fVar.a(iArr, i3)) {
                        return fVar;
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: BytesToNameCanonicalizer */
    private static final class b {

        /* renamed from: a reason: collision with root package name */
        public final int f4310a;

        /* renamed from: b reason: collision with root package name */
        public final int f4311b;

        /* renamed from: c reason: collision with root package name */
        public final int[] f4312c;

        /* renamed from: d reason: collision with root package name */
        public final f[] f4313d;

        /* renamed from: e reason: collision with root package name */
        public final C0058a[] f4314e;

        /* renamed from: f reason: collision with root package name */
        public final int f4315f;

        /* renamed from: g reason: collision with root package name */
        public final int f4316g;

        /* renamed from: h reason: collision with root package name */
        public final int f4317h;

        public b(int i2, int i3, int[] iArr, f[] fVarArr, C0058a[] aVarArr, int i4, int i5, int i6) {
            this.f4310a = i2;
            this.f4311b = i3;
            this.f4312c = iArr;
            this.f4313d = fVarArr;
            this.f4314e = aVarArr;
            this.f4315f = i4;
            this.f4316g = i5;
            this.f4317h = i6;
        }

        public b(a aVar) {
            this.f4310a = aVar.f4299f;
            this.f4311b = aVar.f4301h;
            this.f4312c = aVar.f4302i;
            this.f4313d = aVar.f4303j;
            this.f4314e = aVar.f4304k;
            this.f4315f = aVar.f4305l;
            this.f4316g = aVar.m;
            this.f4317h = aVar.f4300g;
        }
    }

    private a(int i2, boolean z, int i3, boolean z2) {
        this.f4294a = null;
        this.f4296c = i3;
        this.f4297d = z;
        this.f4298e = z2;
        int i4 = 16;
        if (i2 >= 16) {
            if (((i2 - 1) & i2) != 0) {
                while (i4 < i2) {
                    i4 += i4;
                }
            } else {
                i4 = i2;
            }
        }
        this.f4295b = new AtomicReference<>(f(i4));
    }

    public static a a() {
        long currentTimeMillis = System.currentTimeMillis();
        return b((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static a b(int i2) {
        return new a(64, true, i2, true);
    }

    private void e() {
        C0058a[] aVarArr = this.f4304k;
        this.f4304k = (C0058a[]) Arrays.copyOf(aVarArr, aVarArr.length * 2);
    }

    private b f(int i2) {
        b bVar = new b(0, i2 - 1, new int[i2], new f[i2], null, 0, 0, 0);
        return bVar;
    }

    private void g() {
        this.f4299f = 0;
        this.f4300g = 0;
        Arrays.fill(this.f4302i, 0);
        Arrays.fill(this.f4303j, null);
        Arrays.fill(this.f4304k, null);
        this.f4305l = 0;
        this.m = 0;
    }

    private void h() {
        int i2;
        this.n = false;
        this.p = false;
        int length = this.f4302i.length;
        int i3 = length + length;
        if (i3 > 65536) {
            g();
            return;
        }
        this.f4302i = new int[i3];
        this.f4301h = i3 - 1;
        f[] fVarArr = this.f4303j;
        this.f4303j = new f[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            f fVar = fVarArr[i5];
            if (fVar != null) {
                i4++;
                int hashCode = fVar.hashCode();
                int i6 = this.f4301h & hashCode;
                this.f4303j[i6] = fVar;
                this.f4302i[i6] = hashCode << 8;
            }
        }
        int i7 = this.m;
        if (i7 == 0) {
            this.f4300g = 0;
            return;
        }
        this.f4305l = 0;
        this.m = 0;
        this.q = false;
        C0058a[] aVarArr = this.f4304k;
        this.f4304k = new C0058a[aVarArr.length];
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            for (C0058a aVar = aVarArr[i9]; aVar != null; aVar = aVar.f4307b) {
                i4++;
                f fVar2 = aVar.f4306a;
                int hashCode2 = fVar2.hashCode();
                int i10 = this.f4301h & hashCode2;
                int[] iArr = this.f4302i;
                int i11 = iArr[i10];
                f[] fVarArr2 = this.f4303j;
                if (fVarArr2[i10] == null) {
                    iArr[i10] = hashCode2 << 8;
                    fVarArr2[i10] = fVar2;
                } else {
                    this.f4305l++;
                    int i12 = i11 & 255;
                    if (i12 == 0) {
                        i2 = this.m;
                        if (i2 <= 254) {
                            this.m = i2 + 1;
                            if (i2 >= this.f4304k.length) {
                                e();
                            }
                        } else {
                            i2 = f();
                        }
                        this.f4302i[i10] = (i11 & -256) | (i2 + 1);
                    } else {
                        i2 = i12 - 1;
                    }
                    C0058a aVar2 = new C0058a(fVar2, this.f4304k[i2]);
                    this.f4304k[i2] = aVar2;
                    i8 = Math.max(i8, aVar2.f4309d);
                }
            }
        }
        this.f4300g = i8;
        if (i4 != this.f4299f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error: count after rehash ");
            sb.append(i4);
            sb.append("; should be ");
            sb.append(this.f4299f);
            throw new RuntimeException(sb.toString());
        }
    }

    private void i() {
        C0058a[] aVarArr = this.f4304k;
        if (aVarArr == null) {
            this.f4304k = new C0058a[32];
        } else {
            this.f4304k = (C0058a[]) Arrays.copyOf(aVarArr, aVarArr.length);
        }
        this.q = false;
    }

    private void j() {
        int[] iArr = this.f4302i;
        this.f4302i = Arrays.copyOf(iArr, iArr.length);
        this.o = false;
    }

    private void k() {
        f[] fVarArr = this.f4303j;
        this.f4303j = (f[]) Arrays.copyOf(fVarArr, fVarArr.length);
        this.p = false;
    }

    public boolean c() {
        return !this.o;
    }

    public a d(int i2) {
        a aVar = new a(this, com.fasterxml.jackson.core.b.a.INTERN_FIELD_NAMES.b(i2), this.f4296c, com.fasterxml.jackson.core.b.a.FAIL_ON_SYMBOL_HASH_OVERFLOW.b(i2), (b) this.f4295b.get());
        return aVar;
    }

    public static f b() {
        return c.b();
    }

    private int f() {
        C0058a[] aVarArr = this.f4304k;
        int i2 = this.m;
        int i3 = Integer.MAX_VALUE;
        int i4 = -1;
        for (int i5 = 0; i5 < i2; i5++) {
            C0058a aVar = aVarArr[i5];
            if (aVar == null) {
                return i5;
            }
            int i6 = aVar.f4309d;
            if (i6 < i3) {
                if (i6 == 1) {
                    return i5;
                }
                i4 = i5;
                i3 = i6;
            }
        }
        return i4;
    }

    public f c(int i2) {
        int a2 = a(i2);
        int i3 = this.f4301h & a2;
        int i4 = this.f4302i[i3];
        if ((((i4 >> 8) ^ a2) << 8) == 0) {
            f fVar = this.f4303j[i3];
            if (fVar == null) {
                return null;
            }
            if (fVar.a(i2)) {
                return fVar;
            }
        } else if (i4 == 0) {
            return null;
        }
        int i5 = i4 & 255;
        if (i5 > 0) {
            C0058a aVar = this.f4304k[i5 - 1];
            if (aVar != null) {
                return aVar.a(a2, i2, 0);
            }
        }
        return null;
    }

    public void d() {
        if (this.f4294a != null && c()) {
            this.f4294a.a(new b(this));
            this.o = true;
            this.p = true;
            this.q = true;
        }
    }

    private void a(b bVar) {
        int i2 = bVar.f4310a;
        b bVar2 = (b) this.f4295b.get();
        if (i2 != bVar2.f4310a) {
            if (i2 > 6000) {
                bVar = f(64);
            }
            this.f4295b.compareAndSet(bVar2, bVar);
        }
    }

    public f b(int i2, int i3) {
        int a2 = i3 == 0 ? a(i2) : a(i2, i3);
        int i4 = this.f4301h & a2;
        int i5 = this.f4302i[i4];
        if ((((i5 >> 8) ^ a2) << 8) == 0) {
            f fVar = this.f4303j[i4];
            if (fVar == null) {
                return null;
            }
            if (fVar.a(i2, i3)) {
                return fVar;
            }
        } else if (i5 == 0) {
            return null;
        }
        int i6 = i5 & 255;
        if (i6 > 0) {
            C0058a aVar = this.f4304k[i6 - 1];
            if (aVar != null) {
                return aVar.a(a2, i2, i3);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void e(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Longest collision chain in symbol table (of size ");
        sb.append(this.f4299f);
        sb.append(") now exceeds maximum, ");
        sb.append(i2);
        sb.append(" -- suspect a DoS attack based on hash collisions");
        throw new IllegalStateException(sb.toString());
    }

    private a(a aVar, boolean z, int i2, boolean z2, b bVar) {
        this.f4294a = aVar;
        this.f4296c = i2;
        this.f4297d = z;
        this.f4298e = z2;
        this.f4295b = null;
        this.f4299f = bVar.f4310a;
        this.f4301h = bVar.f4311b;
        this.f4302i = bVar.f4312c;
        this.f4303j = bVar.f4313d;
        this.f4304k = bVar.f4314e;
        this.f4305l = bVar.f4315f;
        this.m = bVar.f4316g;
        this.f4300g = bVar.f4317h;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = true;
    }

    public f a(String str, int[] iArr, int i2) {
        if (this.f4297d) {
            str = f.f4376a.a(str);
        }
        int i3 = i2 < 3 ? i2 == 1 ? a(iArr[0]) : a(iArr[0], iArr[1]) : a(iArr, i2);
        f a2 = a(i3, str, iArr, i2);
        a(i3, a2);
        return a2;
    }

    public f b(int[] iArr, int i2) {
        if (i2 < 3) {
            int i3 = 0;
            int i4 = iArr[0];
            if (i2 >= 2) {
                i3 = iArr[1];
            }
            return b(i4, i3);
        }
        int a2 = a(iArr, i2);
        int i5 = this.f4301h & a2;
        int i6 = this.f4302i[i5];
        if ((((i6 >> 8) ^ a2) << 8) == 0) {
            f fVar = this.f4303j[i5];
            if (fVar == null || fVar.a(iArr, i2)) {
                return fVar;
            }
        } else if (i6 == 0) {
            return null;
        }
        int i7 = i6 & 255;
        if (i7 > 0) {
            C0058a aVar = this.f4304k[i7 - 1];
            if (aVar != null) {
                return aVar.a(a2, iArr, i2);
            }
        }
        return null;
    }

    public int a(int i2) {
        int i3 = i2 ^ this.f4296c;
        int i4 = i3 + (i3 >>> 15);
        return i4 ^ (i4 >>> 9);
    }

    public int a(int i2, int i3) {
        int i4 = ((i2 ^ (i2 >>> 15)) + (i3 * 33)) ^ this.f4296c;
        return i4 + (i4 >>> 7);
    }

    public int a(int[] iArr, int i2) {
        if (i2 >= 3) {
            int i3 = iArr[0] ^ this.f4296c;
            int i4 = (((i3 + (i3 >>> 9)) * 33) + iArr[1]) * 65599;
            int i5 = (i4 + (i4 >>> 15)) ^ iArr[2];
            int i6 = i5 + (i5 >>> 17);
            for (int i7 = 3; i7 < i2; i7++) {
                int i8 = (i6 * 31) ^ iArr[i7];
                int i9 = i8 + (i8 >>> 3);
                i6 = i9 ^ (i9 << 7);
            }
            int i10 = i6 + (i6 >>> 15);
            return (i10 << 9) ^ i10;
        }
        throw new IllegalArgumentException();
    }

    private void a(int i2, f fVar) {
        int i3;
        if (this.o) {
            j();
        }
        if (this.n) {
            h();
        }
        this.f4299f++;
        int i4 = this.f4301h & i2;
        if (this.f4303j[i4] == null) {
            this.f4302i[i4] = i2 << 8;
            if (this.p) {
                k();
            }
            this.f4303j[i4] = fVar;
        } else {
            if (this.q) {
                i();
            }
            this.f4305l++;
            int i5 = this.f4302i[i4];
            int i6 = i5 & 255;
            if (i6 == 0) {
                i3 = this.m;
                if (i3 <= 254) {
                    this.m = i3 + 1;
                    if (i3 >= this.f4304k.length) {
                        e();
                    }
                } else {
                    i3 = f();
                }
                this.f4302i[i4] = (i5 & -256) | (i3 + 1);
            } else {
                i3 = i6 - 1;
            }
            C0058a aVar = new C0058a(fVar, this.f4304k[i3]);
            int i7 = aVar.f4309d;
            if (i7 > 100) {
                a(i3, aVar);
            } else {
                this.f4304k[i3] = aVar;
                this.f4300g = Math.max(i7, this.f4300g);
            }
        }
        int length = this.f4302i.length;
        int i8 = this.f4299f;
        if (i8 > (length >> 1)) {
            int i9 = length >> 2;
            if (i8 > length - i9) {
                this.n = true;
            } else if (this.f4305l >= i9) {
                this.n = true;
            }
        }
    }

    private void a(int i2, C0058a aVar) {
        BitSet bitSet = this.r;
        if (bitSet == null) {
            this.r = new BitSet();
            this.r.set(i2);
        } else if (!bitSet.get(i2)) {
            this.r.set(i2);
        } else if (!this.f4298e) {
            this.f4297d = false;
        } else {
            e(100);
            throw null;
        }
        this.f4304k[i2] = null;
        this.f4299f -= aVar.f4309d;
        this.f4300g = -1;
    }

    private static f a(int i2, String str, int[] iArr, int i3) {
        if (i3 < 4) {
            if (i3 == 1) {
                return new c(str, i2, iArr[0]);
            }
            if (i3 == 2) {
                return new d(str, i2, iArr[0], iArr[1]);
            }
            if (i3 == 3) {
                e eVar = new e(str, i2, iArr[0], iArr[1], iArr[2]);
                return eVar;
            }
        }
        return g.a(str, i2, iArr, i3);
    }
}
