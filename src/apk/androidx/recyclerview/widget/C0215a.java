package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.x;
import b.g.h.d;
import b.g.h.e;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a reason: case insensitive filesystem */
/* compiled from: AdapterHelper */
class C0215a implements a {

    /* renamed from: a reason: collision with root package name */
    private d<b> f1869a;

    /* renamed from: b reason: collision with root package name */
    final ArrayList<b> f1870b;

    /* renamed from: c reason: collision with root package name */
    final ArrayList<b> f1871c;

    /* renamed from: d reason: collision with root package name */
    final C0014a f1872d;

    /* renamed from: e reason: collision with root package name */
    Runnable f1873e;

    /* renamed from: f reason: collision with root package name */
    final boolean f1874f;

    /* renamed from: g reason: collision with root package name */
    final F f1875g;

    /* renamed from: h reason: collision with root package name */
    private int f1876h;

    /* renamed from: androidx.recyclerview.widget.a$a reason: collision with other inner class name */
    /* compiled from: AdapterHelper */
    interface C0014a {
        x a(int i2);

        void a(int i2, int i3);

        void a(int i2, int i3, Object obj);

        void a(b bVar);

        void b(int i2, int i3);

        void b(b bVar);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    /* compiled from: AdapterHelper */
    static class b {

        /* renamed from: a reason: collision with root package name */
        int f1877a;

        /* renamed from: b reason: collision with root package name */
        int f1878b;

        /* renamed from: c reason: collision with root package name */
        Object f1879c;

        /* renamed from: d reason: collision with root package name */
        int f1880d;

        b(int i2, int i3, int i4, Object obj) {
            this.f1877a = i2;
            this.f1878b = i3;
            this.f1880d = i4;
            this.f1879c = obj;
        }

        /* access modifiers changed from: 0000 */
        public String a() {
            int i2 = this.f1877a;
            if (i2 == 1) {
                return "add";
            }
            if (i2 == 2) {
                return "rm";
            }
            if (i2 != 4) {
                return i2 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f1877a;
            if (i2 != bVar.f1877a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f1880d - this.f1878b) == 1 && this.f1880d == bVar.f1878b && this.f1878b == bVar.f1880d) {
                return true;
            }
            if (this.f1880d != bVar.f1880d || this.f1878b != bVar.f1878b) {
                return false;
            }
            Object obj2 = this.f1879c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1879c)) {
                    return false;
                }
            } else if (bVar.f1879c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1877a * 31) + this.f1878b) * 31) + this.f1880d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            sb.append(a());
            sb.append(",s:");
            sb.append(this.f1878b);
            sb.append("c:");
            sb.append(this.f1880d);
            sb.append(",p:");
            sb.append(this.f1879c);
            sb.append("]");
            return sb.toString();
        }
    }

    C0215a(C0014a aVar) {
        this(aVar, false);
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        g(bVar);
    }

    private void d(b bVar) {
        char c2;
        boolean z;
        boolean z2;
        int i2 = bVar.f1878b;
        int i3 = bVar.f1880d + i2;
        int i4 = 0;
        char c3 = 65535;
        int i5 = i2;
        while (i5 < i3) {
            if (this.f1872d.a(i5) != null || d(i5)) {
                if (c3 == 0) {
                    f(a(2, i2, i4, null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i2, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i5 -= i4;
                i3 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i5++;
            c3 = c2;
        }
        if (i4 != bVar.f1880d) {
            a(bVar);
            bVar = a(2, i2, i4, null);
        }
        if (c3 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private void g(b bVar) {
        this.f1871c.add(bVar);
        int i2 = bVar.f1877a;
        if (i2 == 1) {
            this.f1872d.c(bVar.f1878b, bVar.f1880d);
        } else if (i2 == 2) {
            this.f1872d.b(bVar.f1878b, bVar.f1880d);
        } else if (i2 == 4) {
            this.f1872d.a(bVar.f1878b, bVar.f1880d, bVar.f1879c);
        } else if (i2 == 8) {
            this.f1872d.a(bVar.f1878b, bVar.f1880d);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown update op type for ");
            sb.append(bVar);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        int size = this.f1871c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1872d.b((b) this.f1871c.get(i2));
        }
        a((List<b>) this.f1871c);
        this.f1876h = 0;
    }

    /* access modifiers changed from: 0000 */
    public void e() {
        this.f1875g.a(this.f1870b);
        int size = this.f1870b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.f1870b.get(i2);
            int i3 = bVar.f1877a;
            if (i3 == 1) {
                b(bVar);
            } else if (i3 == 2) {
                d(bVar);
            } else if (i3 == 4) {
                e(bVar);
            } else if (i3 == 8) {
                c(bVar);
            }
            Runnable runnable = this.f1873e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1870b.clear();
    }

    /* access modifiers changed from: 0000 */
    public void f() {
        a((List<b>) this.f1870b);
        a((List<b>) this.f1871c);
        this.f1876h = 0;
    }

    C0215a(C0014a aVar, boolean z) {
        this.f1869a = new e(30);
        this.f1870b = new ArrayList<>();
        this.f1871c = new ArrayList<>();
        this.f1876h = 0;
        this.f1872d = aVar;
        this.f1874f = z;
        this.f1875g = new F(this);
    }

    /* access modifiers changed from: 0000 */
    public int b(int i2) {
        return a(i2, 0);
    }

    /* access modifiers changed from: 0000 */
    public boolean c() {
        return this.f1870b.size() > 0;
    }

    /* access modifiers changed from: 0000 */
    public boolean b(int i2, int i3) {
        boolean z = false;
        if (i3 < 1) {
            return false;
        }
        this.f1870b.add(a(1, i2, i3, null));
        this.f1876h |= 1;
        if (this.f1870b.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean c(int i2) {
        return (i2 & this.f1876h) != 0;
    }

    private void f(b bVar) {
        int i2;
        int i3 = bVar.f1877a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d2 = d(bVar.f1878b, i3);
        int i4 = bVar.f1878b;
        int i5 = bVar.f1877a;
        if (i5 == 2) {
            i2 = 0;
        } else if (i5 == 4) {
            i2 = 1;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("op should be remove or update.");
            sb.append(bVar);
            throw new IllegalArgumentException(sb.toString());
        }
        int i6 = d2;
        int i7 = i4;
        int i8 = 1;
        for (int i9 = 1; i9 < bVar.f1880d; i9++) {
            int d3 = d(bVar.f1878b + (i2 * i9), bVar.f1877a);
            int i10 = bVar.f1877a;
            if (i10 == 2 ? d3 == i6 : i10 == 4 && d3 == i6 + 1) {
                i8++;
            } else {
                b a2 = a(bVar.f1877a, i6, i8, bVar.f1879c);
                a(a2, i7);
                a(a2);
                if (bVar.f1877a == 4) {
                    i7 += i8;
                }
                i6 = d3;
                i8 = 1;
            }
        }
        Object obj = bVar.f1879c;
        a(bVar);
        if (i8 > 0) {
            b a3 = a(bVar.f1877a, i6, i8, obj);
            a(a3, i7);
            a(a3);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean c(int i2, int i3) {
        boolean z = false;
        if (i3 < 1) {
            return false;
        }
        this.f1870b.add(a(2, i2, i3, null));
        this.f1876h |= 2;
        if (this.f1870b.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar, int i2) {
        this.f1872d.a(bVar);
        int i3 = bVar.f1877a;
        if (i3 == 2) {
            this.f1872d.d(i2, bVar.f1880d);
        } else if (i3 == 4) {
            this.f1872d.a(i2, bVar.f1880d, bVar.f1879c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        a();
        int size = this.f1870b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.f1870b.get(i2);
            int i3 = bVar.f1877a;
            if (i3 == 1) {
                this.f1872d.b(bVar);
                this.f1872d.c(bVar.f1878b, bVar.f1880d);
            } else if (i3 == 2) {
                this.f1872d.b(bVar);
                this.f1872d.d(bVar.f1878b, bVar.f1880d);
            } else if (i3 == 4) {
                this.f1872d.b(bVar);
                this.f1872d.a(bVar.f1878b, bVar.f1880d, bVar.f1879c);
            } else if (i3 == 8) {
                this.f1872d.b(bVar);
                this.f1872d.a(bVar.f1878b, bVar.f1880d);
            }
            Runnable runnable = this.f1873e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a((List<b>) this.f1870b);
        this.f1876h = 0;
    }

    /* access modifiers changed from: 0000 */
    public int a(int i2, int i3) {
        int size = this.f1871c.size();
        while (i3 < size) {
            b bVar = (b) this.f1871c.get(i3);
            int i4 = bVar.f1877a;
            if (i4 == 8) {
                int i5 = bVar.f1878b;
                if (i5 == i2) {
                    i2 = bVar.f1880d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f1880d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f1878b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f1880d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f1880d;
                }
            }
            i3++;
        }
        return i2;
    }

    private void e(b bVar) {
        int i2 = bVar.f1878b;
        int i3 = bVar.f1880d + i2;
        int i4 = i2;
        int i5 = 0;
        char c2 = 65535;
        while (i2 < i3) {
            if (this.f1872d.a(i2) != null || d(i2)) {
                if (c2 == 0) {
                    f(a(4, i4, i5, bVar.f1879c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i4, i5, bVar.f1879c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != bVar.f1880d) {
            Object obj = bVar.f1879c;
            a(bVar);
            bVar = a(4, i4, i5, obj);
        }
        if (c2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private int d(int i2, int i3) {
        for (int size = this.f1871c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f1871c.get(size);
            int i4 = bVar.f1877a;
            if (i4 == 8) {
                int i5 = bVar.f1878b;
                int i6 = bVar.f1880d;
                if (i5 >= i6) {
                    int i7 = i6;
                    i6 = i5;
                    i5 = i7;
                }
                if (i2 < i5 || i2 > i6) {
                    int i8 = bVar.f1878b;
                    if (i2 < i8) {
                        if (i3 == 1) {
                            bVar.f1878b = i8 + 1;
                            bVar.f1880d++;
                        } else if (i3 == 2) {
                            bVar.f1878b = i8 - 1;
                            bVar.f1880d--;
                        }
                    }
                } else {
                    int i9 = bVar.f1878b;
                    if (i5 == i9) {
                        if (i3 == 1) {
                            bVar.f1880d++;
                        } else if (i3 == 2) {
                            bVar.f1880d--;
                        }
                        i2++;
                    } else {
                        if (i3 == 1) {
                            bVar.f1878b = i9 + 1;
                        } else if (i3 == 2) {
                            bVar.f1878b = i9 - 1;
                        }
                        i2--;
                    }
                }
            } else {
                int i10 = bVar.f1878b;
                if (i10 <= i2) {
                    if (i4 == 1) {
                        i2 -= bVar.f1880d;
                    } else if (i4 == 2) {
                        i2 += bVar.f1880d;
                    }
                } else if (i3 == 1) {
                    bVar.f1878b = i10 + 1;
                } else if (i3 == 2) {
                    bVar.f1878b = i10 - 1;
                }
            }
        }
        for (int size2 = this.f1871c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f1871c.get(size2);
            if (bVar2.f1877a == 8) {
                int i11 = bVar2.f1880d;
                if (i11 == bVar2.f1878b || i11 < 0) {
                    this.f1871c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1880d <= 0) {
                this.f1871c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(int i2, int i3, Object obj) {
        boolean z = false;
        if (i3 < 1) {
            return false;
        }
        this.f1870b.add(a(4, i2, i3, obj));
        this.f1876h |= 4;
        if (this.f1870b.size() == 1) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean a(int i2, int i3, int i4) {
        boolean z = false;
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f1870b.add(a(8, i2, i3, null));
            this.f1876h |= 8;
            if (this.f1870b.size() == 1) {
                z = true;
            }
            return z;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public int a(int i2) {
        int size = this.f1870b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f1870b.get(i3);
            int i4 = bVar.f1877a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f1878b;
                    if (i5 <= i2) {
                        int i6 = bVar.f1880d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f1878b;
                    if (i7 == i2) {
                        i2 = bVar.f1880d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f1880d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f1878b <= i2) {
                i2 += bVar.f1880d;
            }
        }
        return i2;
    }

    public b a(int i2, int i3, int i4, Object obj) {
        b bVar = (b) this.f1869a.a();
        if (bVar == null) {
            return new b(i2, i3, i4, obj);
        }
        bVar.f1877a = i2;
        bVar.f1878b = i3;
        bVar.f1880d = i4;
        bVar.f1879c = obj;
        return bVar;
    }

    private boolean d(int i2) {
        int size = this.f1871c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.f1871c.get(i3);
            int i4 = bVar.f1877a;
            if (i4 == 8) {
                if (a(bVar.f1880d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f1878b;
                int i6 = bVar.f1880d + i5;
                while (i5 < i6) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void a(b bVar) {
        if (!this.f1874f) {
            bVar.f1879c = null;
            this.f1869a.a(bVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a((b) list.get(i2));
        }
        list.clear();
    }

    /* access modifiers changed from: 0000 */
    public boolean d() {
        return !this.f1871c.isEmpty() && !this.f1870b.isEmpty();
    }
}
