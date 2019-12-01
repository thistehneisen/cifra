package com.fasterxml.jackson.core.d;

import com.fasterxml.jackson.core.e.f;
import java.util.Arrays;
import java.util.BitSet;

/* compiled from: CharsToNameCanonicalizer */
public final class b {

    /* renamed from: a reason: collision with root package name */
    static final b f4318a = new b();

    /* renamed from: b reason: collision with root package name */
    protected b f4319b;

    /* renamed from: c reason: collision with root package name */
    private final int f4320c;

    /* renamed from: d reason: collision with root package name */
    protected final int f4321d;

    /* renamed from: e reason: collision with root package name */
    protected boolean f4322e;

    /* renamed from: f reason: collision with root package name */
    protected String[] f4323f;

    /* renamed from: g reason: collision with root package name */
    protected a[] f4324g;

    /* renamed from: h reason: collision with root package name */
    protected int f4325h;

    /* renamed from: i reason: collision with root package name */
    protected int f4326i;

    /* renamed from: j reason: collision with root package name */
    protected int f4327j;

    /* renamed from: k reason: collision with root package name */
    protected int f4328k;

    /* renamed from: l reason: collision with root package name */
    protected boolean f4329l;
    protected BitSet m;

    /* compiled from: CharsToNameCanonicalizer */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        public final String f4330a;

        /* renamed from: b reason: collision with root package name */
        public final a f4331b;

        /* renamed from: c reason: collision with root package name */
        public final int f4332c;

        public a(String str, a aVar) {
            this.f4330a = str;
            this.f4331b = aVar;
            int i2 = 1;
            if (aVar != null) {
                i2 = 1 + aVar.f4332c;
            }
            this.f4332c = i2;
        }

        public String a(char[] cArr, int i2, int i3) {
            if (this.f4330a.length() != i3) {
                return null;
            }
            int i4 = 0;
            while (this.f4330a.charAt(i4) == cArr[i2 + i4]) {
                i4++;
                if (i4 >= i3) {
                    return this.f4330a;
                }
            }
            return null;
        }
    }

    private b() {
        this.f4322e = true;
        this.f4321d = -1;
        this.f4329l = true;
        this.f4320c = 0;
        this.f4328k = 0;
        f(64);
    }

    public static b a() {
        long currentTimeMillis = System.currentTimeMillis();
        return b((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static b b(int i2) {
        return f4318a.g(i2);
    }

    private static int e(int i2) {
        return i2 - (i2 >> 2);
    }

    private void f(int i2) {
        this.f4323f = new String[i2];
        this.f4324g = new a[(i2 >> 1)];
        this.f4327j = i2 - 1;
        this.f4325h = 0;
        this.f4328k = 0;
        this.f4326i = e(i2);
    }

    private b g(int i2) {
        b bVar = new b(null, -1, this.f4323f, this.f4324g, this.f4325h, i2, this.f4328k);
        return bVar;
    }

    public b c(int i2) {
        String[] strArr;
        a[] aVarArr;
        int i3;
        int i4;
        int i5;
        synchronized (this) {
            strArr = this.f4323f;
            aVarArr = this.f4324g;
            i3 = this.f4325h;
            i4 = this.f4320c;
            i5 = this.f4328k;
        }
        b bVar = new b(this, i2, strArr, aVarArr, i3, i4, i5);
        return bVar;
    }

    public void d() {
        if (c()) {
            b bVar = this.f4319b;
            if (bVar != null && this.f4322e) {
                bVar.a(this);
                this.f4329l = false;
            }
        }
    }

    public int e() {
        return this.f4325h;
    }

    private void g() {
        String[] strArr;
        int i2 = r1 + r1;
        if (i2 > 65536) {
            this.f4325h = 0;
            this.f4322e = false;
            this.f4323f = new String[64];
            this.f4324g = new a[32];
            this.f4327j = 63;
            this.f4329l = true;
            return;
        }
        a[] aVarArr = this.f4324g;
        this.f4323f = new String[i2];
        this.f4324g = new a[(i2 >> 1)];
        this.f4327j = i2 - 1;
        this.f4326i = e(i2);
        int i3 = 0;
        int i4 = 0;
        for (String str : this.f4323f) {
            if (str != null) {
                i3++;
                int a2 = a(a(str));
                String[] strArr2 = this.f4323f;
                if (strArr2[a2] == null) {
                    strArr2[a2] = str;
                } else {
                    int i5 = a2 >> 1;
                    a aVar = new a(str, this.f4324g[i5]);
                    this.f4324g[i5] = aVar;
                    i4 = Math.max(i4, aVar.f4332c);
                }
            }
        }
        int i6 = r1 >> 1;
        for (int i7 = 0; i7 < i6; i7++) {
            for (a aVar2 = aVarArr[i7]; aVar2 != null; aVar2 = aVar2.f4331b) {
                i3++;
                String str2 = aVar2.f4330a;
                int a3 = a(a(str2));
                String[] strArr3 = this.f4323f;
                if (strArr3[a3] == null) {
                    strArr3[a3] = str2;
                } else {
                    int i8 = a3 >> 1;
                    a aVar3 = new a(str2, this.f4324g[i8]);
                    this.f4324g[i8] = aVar3;
                    i4 = Math.max(i4, aVar3.f4332c);
                }
            }
        }
        this.f4328k = i4;
        this.m = null;
        if (i3 != this.f4325h) {
            StringBuilder sb = new StringBuilder();
            sb.append("Internal error on SymbolTable.rehash(): had ");
            sb.append(this.f4325h);
            sb.append(" entries; now have ");
            sb.append(i3);
            sb.append(".");
            throw new Error(sb.toString());
        }
    }

    public int b() {
        return this.f4320c;
    }

    private void a(b bVar) {
        if (bVar.e() > 12000) {
            synchronized (this) {
                f(256);
                this.f4329l = false;
            }
        } else if (bVar.e() > e()) {
            synchronized (this) {
                this.f4323f = bVar.f4323f;
                this.f4324g = bVar.f4324g;
                this.f4325h = bVar.f4325h;
                this.f4326i = bVar.f4326i;
                this.f4327j = bVar.f4327j;
                this.f4328k = bVar.f4328k;
                this.f4329l = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Longest collision chain in symbol table (of size ");
        sb.append(this.f4325h);
        sb.append(") now exceeds maximum, ");
        sb.append(i2);
        sb.append(" -- suspect a DoS attack based on hash collisions");
        throw new IllegalStateException(sb.toString());
    }

    private void f() {
        String[] strArr = this.f4323f;
        this.f4323f = (String[]) Arrays.copyOf(strArr, strArr.length);
        a[] aVarArr = this.f4324g;
        this.f4324g = (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    private b(b bVar, int i2, String[] strArr, a[] aVarArr, int i3, int i4, int i5) {
        this.f4319b = bVar;
        this.f4321d = i2;
        this.f4322e = com.fasterxml.jackson.core.b.a.CANONICALIZE_FIELD_NAMES.b(i2);
        this.f4323f = strArr;
        this.f4324g = aVarArr;
        this.f4325h = i3;
        this.f4320c = i4;
        int length = strArr.length;
        this.f4326i = e(length);
        this.f4327j = length - 1;
        this.f4328k = i5;
        this.f4329l = false;
    }

    public boolean c() {
        return this.f4329l;
    }

    public String a(char[] cArr, int i2, int i3, int i4) {
        if (i3 < 1) {
            return "";
        }
        if (!this.f4322e) {
            return new String(cArr, i2, i3);
        }
        int a2 = a(i4);
        String str = this.f4323f[a2];
        if (str != null) {
            if (str.length() == i3) {
                int i5 = 0;
                while (str.charAt(i5) == cArr[i2 + i5]) {
                    i5++;
                    if (i5 == i3) {
                        return str;
                    }
                }
            }
            a aVar = this.f4324g[a2 >> 1];
            if (aVar != null) {
                String a3 = aVar.a(cArr, i2, i3);
                if (a3 != null) {
                    return a3;
                }
                String a4 = a(cArr, i2, i3, aVar.f4331b);
                if (a4 != null) {
                    return a4;
                }
            }
        }
        return a(cArr, i2, i3, i4, a2);
    }

    private String a(char[] cArr, int i2, int i3, a aVar) {
        while (aVar != null) {
            String a2 = aVar.a(cArr, i2, i3);
            if (a2 != null) {
                return a2;
            }
            aVar = aVar.f4331b;
        }
        return null;
    }

    private String a(char[] cArr, int i2, int i3, int i4, int i5) {
        if (!this.f4329l) {
            f();
            this.f4329l = true;
        } else if (this.f4325h >= this.f4326i) {
            g();
            i5 = a(a(cArr, i2, i3));
        }
        String str = new String(cArr, i2, i3);
        if (com.fasterxml.jackson.core.b.a.INTERN_FIELD_NAMES.b(this.f4321d)) {
            str = f.f4376a.a(str);
        }
        this.f4325h++;
        String[] strArr = this.f4323f;
        if (strArr[i5] == null) {
            strArr[i5] = str;
        } else {
            int i6 = i5 >> 1;
            a aVar = new a(str, this.f4324g[i6]);
            int i7 = aVar.f4332c;
            if (i7 > 100) {
                a(i6, aVar);
            } else {
                this.f4324g[i6] = aVar;
                this.f4328k = Math.max(i7, this.f4328k);
            }
        }
        return str;
    }

    private void a(int i2, a aVar) {
        BitSet bitSet = this.m;
        if (bitSet == null) {
            this.m = new BitSet();
            this.m.set(i2);
        } else if (!bitSet.get(i2)) {
            this.m.set(i2);
        } else if (!com.fasterxml.jackson.core.b.a.FAIL_ON_SYMBOL_HASH_OVERFLOW.b(this.f4321d)) {
            this.f4322e = false;
        } else {
            d(100);
            throw null;
        }
        this.f4323f[i2 + i2] = aVar.f4330a;
        this.f4324g[i2] = null;
        this.f4325h -= aVar.f4332c;
        this.f4328k = -1;
    }

    public int a(int i2) {
        return (i2 + (i2 >>> 15)) & this.f4327j;
    }

    public int a(char[] cArr, int i2, int i3) {
        int i4 = this.f4320c;
        int i5 = i3 + i2;
        while (i2 < i5) {
            i4 = (i4 * 33) + cArr[i2];
            i2++;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public int a(String str) {
        int length = str.length();
        int i2 = this.f4320c;
        for (int i3 = 0; i3 < length; i3++) {
            i2 = (i2 * 33) + str.charAt(i3);
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
