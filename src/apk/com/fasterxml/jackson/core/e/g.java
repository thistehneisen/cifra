package com.fasterxml.jackson.core.e;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: TextBuffer */
public final class g {

    /* renamed from: a reason: collision with root package name */
    static final char[] f4377a = new char[0];

    /* renamed from: b reason: collision with root package name */
    private final a f4378b;

    /* renamed from: c reason: collision with root package name */
    private char[] f4379c;

    /* renamed from: d reason: collision with root package name */
    private int f4380d;

    /* renamed from: e reason: collision with root package name */
    private int f4381e;

    /* renamed from: f reason: collision with root package name */
    private ArrayList<char[]> f4382f;

    /* renamed from: g reason: collision with root package name */
    private boolean f4383g = false;

    /* renamed from: h reason: collision with root package name */
    private int f4384h;

    /* renamed from: i reason: collision with root package name */
    private char[] f4385i;

    /* renamed from: j reason: collision with root package name */
    private int f4386j;

    /* renamed from: k reason: collision with root package name */
    private String f4387k;

    /* renamed from: l reason: collision with root package name */
    private char[] f4388l;

    public g(a aVar) {
        this.f4378b = aVar;
    }

    private void o() {
        this.f4383g = false;
        this.f4382f.clear();
        this.f4384h = 0;
        this.f4386j = 0;
    }

    private char[] p() {
        int i2;
        String str = this.f4387k;
        if (str != null) {
            return str.toCharArray();
        }
        int i3 = this.f4380d;
        if (i3 >= 0) {
            int i4 = this.f4381e;
            if (i4 < 1) {
                return f4377a;
            }
            if (i3 == 0) {
                return Arrays.copyOf(this.f4379c, i4);
            }
            return Arrays.copyOfRange(this.f4379c, i3, i4 + i3);
        }
        int n = n();
        if (n < 1) {
            return f4377a;
        }
        char[] c2 = c(n);
        ArrayList<char[]> arrayList = this.f4382f;
        if (arrayList != null) {
            int size = arrayList.size();
            i2 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                char[] cArr = (char[]) this.f4382f.get(i5);
                int length = cArr.length;
                System.arraycopy(cArr, 0, c2, i2, length);
                i2 += length;
            }
        } else {
            i2 = 0;
        }
        System.arraycopy(this.f4385i, 0, c2, i2, this.f4386j);
        return c2;
    }

    public void a(String str) {
        this.f4379c = null;
        this.f4380d = -1;
        this.f4381e = 0;
        this.f4387k = str;
        this.f4388l = null;
        if (this.f4383g) {
            o();
        }
        this.f4386j = 0;
    }

    public void b(char[] cArr, int i2, int i3) {
        this.f4379c = null;
        this.f4380d = -1;
        this.f4381e = 0;
        this.f4387k = null;
        this.f4388l = null;
        if (this.f4383g) {
            o();
        } else if (this.f4385i == null) {
            this.f4385i = b(i3);
        }
        this.f4384h = 0;
        this.f4386j = 0;
        a(cArr, i2, i3);
    }

    public void c(char[] cArr, int i2, int i3) {
        this.f4387k = null;
        this.f4388l = null;
        this.f4379c = cArr;
        this.f4380d = i2;
        this.f4381e = i3;
        if (this.f4383g) {
            o();
        }
    }

    public String d() {
        if (this.f4387k == null) {
            char[] cArr = this.f4388l;
            if (cArr != null) {
                this.f4387k = new String(cArr);
            } else {
                int i2 = this.f4380d;
                String str = "";
                if (i2 >= 0) {
                    int i3 = this.f4381e;
                    if (i3 < 1) {
                        this.f4387k = str;
                        return str;
                    }
                    this.f4387k = new String(this.f4379c, i2, i3);
                } else {
                    int i4 = this.f4384h;
                    int i5 = this.f4386j;
                    if (i4 == 0) {
                        if (i5 != 0) {
                            str = new String(this.f4385i, 0, i5);
                        }
                        this.f4387k = str;
                    } else {
                        StringBuilder sb = new StringBuilder(i4 + i5);
                        ArrayList<char[]> arrayList = this.f4382f;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                char[] cArr2 = (char[]) this.f4382f.get(i6);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.f4385i, 0, this.f4386j);
                        this.f4387k = sb.toString();
                    }
                }
            }
        }
        return this.f4387k;
    }

    public char[] e() {
        this.f4380d = -1;
        this.f4386j = 0;
        this.f4381e = 0;
        this.f4379c = null;
        this.f4387k = null;
        this.f4388l = null;
        if (this.f4383g) {
            o();
        }
        char[] cArr = this.f4385i;
        if (cArr != null) {
            return cArr;
        }
        char[] b2 = b(0);
        this.f4385i = b2;
        return b2;
    }

    public char[] f() {
        char[] cArr = this.f4385i;
        int length = cArr.length;
        int i2 = (length >> 1) + length;
        if (i2 > 262144) {
            i2 = (length >> 2) + length;
        }
        char[] copyOf = Arrays.copyOf(cArr, i2);
        this.f4385i = copyOf;
        return copyOf;
    }

    public char[] g() {
        if (this.f4382f == null) {
            this.f4382f = new ArrayList<>();
        }
        this.f4383g = true;
        this.f4382f.add(this.f4385i);
        int length = this.f4385i.length;
        this.f4384h += length;
        this.f4386j = 0;
        int i2 = length + (length >> 1);
        if (i2 < 1000) {
            i2 = 1000;
        } else if (i2 > 262144) {
            i2 = 262144;
        }
        char[] c2 = c(i2);
        this.f4385i = c2;
        return c2;
    }

    public char[] h() {
        if (this.f4380d >= 0) {
            e(1);
        } else {
            char[] cArr = this.f4385i;
            if (cArr == null) {
                this.f4385i = b(0);
            } else if (this.f4386j >= cArr.length) {
                d(1);
            }
        }
        return this.f4385i;
    }

    public int i() {
        return this.f4386j;
    }

    public char[] j() {
        if (this.f4380d >= 0) {
            return this.f4379c;
        }
        char[] cArr = this.f4388l;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f4387k;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.f4388l = charArray;
            return charArray;
        } else if (!this.f4383g) {
            return this.f4385i;
        } else {
            return a();
        }
    }

    public int k() {
        int i2 = this.f4380d;
        if (i2 >= 0) {
            return i2;
        }
        return 0;
    }

    public void l() {
        if (this.f4378b == null) {
            m();
        } else if (this.f4385i != null) {
            m();
            char[] cArr = this.f4385i;
            this.f4385i = null;
            this.f4378b.a(2, cArr);
        }
    }

    public void m() {
        this.f4380d = -1;
        this.f4386j = 0;
        this.f4381e = 0;
        this.f4379c = null;
        this.f4387k = null;
        this.f4388l = null;
        if (this.f4383g) {
            o();
        }
    }

    public int n() {
        if (this.f4380d >= 0) {
            return this.f4381e;
        }
        char[] cArr = this.f4388l;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f4387k;
        if (str != null) {
            return str.length();
        }
        return this.f4384h + this.f4386j;
    }

    public String toString() {
        return d();
    }

    public double c() throws NumberFormatException {
        return com.fasterxml.jackson.core.b.g.a(d());
    }

    private char[] c(int i2) {
        return new char[i2];
    }

    public char[] a() {
        char[] cArr = this.f4388l;
        if (cArr != null) {
            return cArr;
        }
        char[] p = p();
        this.f4388l = p;
        return p;
    }

    private void e(int i2) {
        int i3 = this.f4381e;
        this.f4381e = 0;
        char[] cArr = this.f4379c;
        this.f4379c = null;
        int i4 = this.f4380d;
        this.f4380d = -1;
        int i5 = i2 + i3;
        char[] cArr2 = this.f4385i;
        if (cArr2 == null || i5 > cArr2.length) {
            this.f4385i = b(i5);
        }
        if (i3 > 0) {
            System.arraycopy(cArr, i4, this.f4385i, 0, i3);
        }
        this.f4384h = 0;
        this.f4386j = i3;
    }

    public void a(char[] cArr, int i2, int i3) {
        if (this.f4380d >= 0) {
            e(i3);
        }
        this.f4387k = null;
        this.f4388l = null;
        char[] cArr2 = this.f4385i;
        int length = cArr2.length;
        int i4 = this.f4386j;
        int i5 = length - i4;
        if (i5 >= i3) {
            System.arraycopy(cArr, i2, cArr2, i4, i3);
            this.f4386j += i3;
            return;
        }
        if (i5 > 0) {
            System.arraycopy(cArr, i2, cArr2, i4, i5);
            i2 += i5;
            i3 -= i5;
        }
        do {
            d(i3);
            int min = Math.min(this.f4385i.length, i3);
            System.arraycopy(cArr, i2, this.f4385i, 0, min);
            this.f4386j += min;
            i2 += min;
            i3 -= min;
        } while (i3 > 0);
    }

    private char[] b(int i2) {
        a aVar = this.f4378b;
        if (aVar != null) {
            return aVar.b(2, i2);
        }
        return new char[Math.max(i2, 1000)];
    }

    public BigDecimal b() throws NumberFormatException {
        char[] cArr = this.f4388l;
        if (cArr != null) {
            return com.fasterxml.jackson.core.b.g.a(cArr);
        }
        int i2 = this.f4380d;
        if (i2 >= 0) {
            char[] cArr2 = this.f4379c;
            if (cArr2 != null) {
                return com.fasterxml.jackson.core.b.g.a(cArr2, i2, this.f4381e);
            }
        }
        if (this.f4384h == 0) {
            char[] cArr3 = this.f4385i;
            if (cArr3 != null) {
                return com.fasterxml.jackson.core.b.g.a(cArr3, 0, this.f4386j);
            }
        }
        return com.fasterxml.jackson.core.b.g.a(a());
    }

    private void d(int i2) {
        if (this.f4382f == null) {
            this.f4382f = new ArrayList<>();
        }
        char[] cArr = this.f4385i;
        this.f4383g = true;
        this.f4382f.add(cArr);
        this.f4384h += cArr.length;
        this.f4386j = 0;
        int length = cArr.length;
        int i3 = length + (length >> 1);
        if (i3 < 1000) {
            i3 = 1000;
        } else if (i3 > 262144) {
            i3 = 262144;
        }
        this.f4385i = c(i3);
    }

    public void a(int i2) {
        this.f4386j = i2;
    }
}
