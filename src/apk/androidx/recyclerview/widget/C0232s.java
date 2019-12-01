package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.s reason: case insensitive filesystem */
/* compiled from: DiffUtil */
public class C0232s {

    /* renamed from: a reason: collision with root package name */
    private static final Comparator<f> f1972a = new r();

    /* renamed from: androidx.recyclerview.widget.s$a */
    /* compiled from: DiffUtil */
    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int i2, int i3);

        public abstract int b();

        public abstract boolean b(int i2, int i3);

        public abstract Object c(int i2, int i3);
    }

    /* renamed from: androidx.recyclerview.widget.s$b */
    /* compiled from: DiffUtil */
    public static class b {

        /* renamed from: a reason: collision with root package name */
        private final List<f> f1973a;

        /* renamed from: b reason: collision with root package name */
        private final int[] f1974b;

        /* renamed from: c reason: collision with root package name */
        private final int[] f1975c;

        /* renamed from: d reason: collision with root package name */
        private final a f1976d;

        /* renamed from: e reason: collision with root package name */
        private final int f1977e;

        /* renamed from: f reason: collision with root package name */
        private final int f1978f;

        /* renamed from: g reason: collision with root package name */
        private final boolean f1979g;

        b(a aVar, List<f> list, int[] iArr, int[] iArr2, boolean z) {
            this.f1973a = list;
            this.f1974b = iArr;
            this.f1975c = iArr2;
            Arrays.fill(this.f1974b, 0);
            Arrays.fill(this.f1975c, 0);
            this.f1976d = aVar;
            this.f1977e = aVar.b();
            this.f1978f = aVar.a();
            this.f1979g = z;
            a();
            b();
        }

        private void a() {
            f fVar = this.f1973a.isEmpty() ? null : (f) this.f1973a.get(0);
            if (fVar == null || fVar.f1987a != 0 || fVar.f1988b != 0) {
                f fVar2 = new f();
                fVar2.f1987a = 0;
                fVar2.f1988b = 0;
                fVar2.f1990d = false;
                fVar2.f1989c = 0;
                fVar2.f1991e = false;
                this.f1973a.add(0, fVar2);
            }
        }

        private void b() {
            int i2 = this.f1977e;
            int i3 = this.f1978f;
            for (int size = this.f1973a.size() - 1; size >= 0; size--) {
                f fVar = (f) this.f1973a.get(size);
                int i4 = fVar.f1987a;
                int i5 = fVar.f1989c;
                int i6 = i4 + i5;
                int i7 = fVar.f1988b + i5;
                if (this.f1979g) {
                    while (i2 > i6) {
                        a(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        b(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < fVar.f1989c; i8++) {
                    int i9 = fVar.f1987a + i8;
                    int i10 = fVar.f1988b + i8;
                    int i11 = this.f1976d.a(i9, i10) ? 1 : 2;
                    this.f1974b[i9] = (i10 << 5) | i11;
                    this.f1975c[i10] = (i9 << 5) | i11;
                }
                i2 = fVar.f1987a;
                i3 = fVar.f1988b;
            }
        }

        private void a(int i2, int i3, int i4) {
            if (this.f1974b[i2 - 1] == 0) {
                a(i2, i3, i4, false);
            }
        }

        private boolean a(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i6 = i2 - 1;
                i5 = i6;
            }
            while (i4 >= 0) {
                f fVar = (f) this.f1973a.get(i4);
                int i7 = fVar.f1987a;
                int i8 = fVar.f1989c;
                int i9 = i7 + i8;
                int i10 = fVar.f1988b + i8;
                int i11 = 8;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i9; i12--) {
                        if (this.f1976d.b(i12, i5)) {
                            if (!this.f1976d.a(i12, i5)) {
                                i11 = 4;
                            }
                            this.f1975c[i5] = (i12 << 5) | 16;
                            this.f1974b[i12] = (i5 << 5) | i11;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i13 = i3 - 1; i13 >= i10; i13--) {
                        if (this.f1976d.b(i5, i13)) {
                            if (!this.f1976d.a(i5, i13)) {
                                i11 = 4;
                            }
                            int i14 = i2 - 1;
                            this.f1974b[i14] = (i13 << 5) | 16;
                            this.f1975c[i13] = (i14 << 5) | i11;
                            return true;
                        }
                    }
                    continue;
                }
                i6 = fVar.f1987a;
                i3 = fVar.f1988b;
                i4--;
            }
            return false;
        }

        private void b(int i2, int i3, int i4) {
            if (this.f1975c[i3 - 1] == 0) {
                a(i2, i3, i4, true);
            }
        }

        private void b(List<d> list, E e2, int i2, int i3, int i4) {
            if (!this.f1979g) {
                e2.c(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.f1974b[i6] & 31;
                if (i7 == 0) {
                    e2.c(i2 + i5, 1);
                    for (d dVar : list) {
                        dVar.f1981b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.f1974b[i6] >> 5;
                    d a2 = a(list, i8, false);
                    e2.a(i2 + i5, a2.f1981b - 1);
                    if (i7 == 4) {
                        e2.a(a2.f1981b - 1, 1, this.f1976d.c(i6, i8));
                    }
                } else if (i7 == 16) {
                    list.add(new d(i6, i2 + i5, true));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown flag for pos ");
                    sb.append(i6);
                    sb.append(" ");
                    sb.append(Long.toBinaryString((long) i7));
                    throw new IllegalStateException(sb.toString());
                }
            }
        }

        public void a(E e2) {
            C0221g gVar;
            if (e2 instanceof C0221g) {
                gVar = (C0221g) e2;
            } else {
                gVar = new C0221g(e2);
            }
            ArrayList arrayList = new ArrayList();
            int i2 = this.f1977e;
            int i3 = this.f1978f;
            for (int size = this.f1973a.size() - 1; size >= 0; size--) {
                f fVar = (f) this.f1973a.get(size);
                int i4 = fVar.f1989c;
                int i5 = fVar.f1987a + i4;
                int i6 = fVar.f1988b + i4;
                if (i5 < i2) {
                    b(arrayList, gVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    a(arrayList, gVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.f1974b;
                    int i8 = fVar.f1987a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        gVar.a(i8 + i7, 1, this.f1976d.c(i8 + i7, fVar.f1988b + i7));
                    }
                }
                i2 = fVar.f1987a;
                i3 = fVar.f1988b;
            }
            gVar.a();
        }

        private static d a(List<d> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                d dVar = (d) list.get(size);
                if (dVar.f1980a == i2 && dVar.f1982c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        d dVar2 = (d) list.get(size);
                        dVar2.f1981b += z ? 1 : -1;
                        size++;
                    }
                    return dVar;
                }
                size--;
            }
            return null;
        }

        private void a(List<d> list, E e2, int i2, int i3, int i4) {
            if (!this.f1979g) {
                e2.b(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int i6 = i4 + i5;
                int i7 = this.f1975c[i6] & 31;
                if (i7 == 0) {
                    e2.b(i2, 1);
                    for (d dVar : list) {
                        dVar.f1981b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = this.f1975c[i6] >> 5;
                    e2.a(a(list, i8, true).f1981b, i2);
                    if (i7 == 4) {
                        e2.a(i2, 1, this.f1976d.c(i8, i6));
                    }
                } else if (i7 == 16) {
                    list.add(new d(i6, i2, false));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown flag for pos ");
                    sb.append(i6);
                    sb.append(" ");
                    sb.append(Long.toBinaryString((long) i7));
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.s$c */
    /* compiled from: DiffUtil */
    public static abstract class c<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);

        public Object c(T t, T t2) {
            return null;
        }
    }

    /* renamed from: androidx.recyclerview.widget.s$d */
    /* compiled from: DiffUtil */
    private static class d {

        /* renamed from: a reason: collision with root package name */
        int f1980a;

        /* renamed from: b reason: collision with root package name */
        int f1981b;

        /* renamed from: c reason: collision with root package name */
        boolean f1982c;

        public d(int i2, int i3, boolean z) {
            this.f1980a = i2;
            this.f1981b = i3;
            this.f1982c = z;
        }
    }

    /* renamed from: androidx.recyclerview.widget.s$e */
    /* compiled from: DiffUtil */
    static class e {

        /* renamed from: a reason: collision with root package name */
        int f1983a;

        /* renamed from: b reason: collision with root package name */
        int f1984b;

        /* renamed from: c reason: collision with root package name */
        int f1985c;

        /* renamed from: d reason: collision with root package name */
        int f1986d;

        public e() {
        }

        public e(int i2, int i3, int i4, int i5) {
            this.f1983a = i2;
            this.f1984b = i3;
            this.f1985c = i4;
            this.f1986d = i5;
        }
    }

    /* renamed from: androidx.recyclerview.widget.s$f */
    /* compiled from: DiffUtil */
    static class f {

        /* renamed from: a reason: collision with root package name */
        int f1987a;

        /* renamed from: b reason: collision with root package name */
        int f1988b;

        /* renamed from: c reason: collision with root package name */
        int f1989c;

        /* renamed from: d reason: collision with root package name */
        boolean f1990d;

        /* renamed from: e reason: collision with root package name */
        boolean f1991e;

        f() {
        }
    }

    public static b a(a aVar) {
        return a(aVar, true);
    }

    public static b a(a aVar, boolean z) {
        e eVar;
        int b2 = aVar.b();
        int a2 = aVar.a();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(0, b2, 0, a2));
        int abs = Math.abs(b2 - a2) + b2 + a2;
        int i2 = abs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar2 = (e) arrayList2.remove(arrayList2.size() - 1);
            f a3 = a(aVar, eVar2.f1983a, eVar2.f1984b, eVar2.f1985c, eVar2.f1986d, iArr, iArr2, abs);
            if (a3 != null) {
                if (a3.f1989c > 0) {
                    arrayList.add(a3);
                }
                a3.f1987a += eVar2.f1983a;
                a3.f1988b += eVar2.f1985c;
                if (arrayList3.isEmpty()) {
                    eVar = new e();
                } else {
                    eVar = (e) arrayList3.remove(arrayList3.size() - 1);
                }
                eVar.f1983a = eVar2.f1983a;
                eVar.f1985c = eVar2.f1985c;
                if (a3.f1991e) {
                    eVar.f1984b = a3.f1987a;
                    eVar.f1986d = a3.f1988b;
                } else if (a3.f1990d) {
                    eVar.f1984b = a3.f1987a - 1;
                    eVar.f1986d = a3.f1988b;
                } else {
                    eVar.f1984b = a3.f1987a;
                    eVar.f1986d = a3.f1988b - 1;
                }
                arrayList2.add(eVar);
                if (!a3.f1991e) {
                    int i3 = a3.f1987a;
                    int i4 = a3.f1989c;
                    eVar2.f1983a = i3 + i4;
                    eVar2.f1985c = a3.f1988b + i4;
                } else if (a3.f1990d) {
                    int i5 = a3.f1987a;
                    int i6 = a3.f1989c;
                    eVar2.f1983a = i5 + i6 + 1;
                    eVar2.f1985c = a3.f1988b + i6;
                } else {
                    int i7 = a3.f1987a;
                    int i8 = a3.f1989c;
                    eVar2.f1983a = i7 + i8;
                    eVar2.f1985c = a3.f1988b + i8 + 1;
                }
                arrayList2.add(eVar2);
            } else {
                arrayList3.add(eVar2);
            }
        }
        Collections.sort(arrayList, f1972a);
        b bVar = new b(aVar, arrayList, iArr, iArr2, z);
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r1[r13 - 1] < r1[r13 + r5]) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        if (r2[r13 - 1] < r2[r13 + 1]) goto L_0x00c7;
     */
    private static f a(a aVar, int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12;
        a aVar2 = aVar;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i13 = i3 - i2;
        int i14 = i5 - i4;
        int i15 = 1;
        if (i13 < 1 || i14 < 1) {
            return null;
        }
        int i16 = i13 - i14;
        int i17 = ((i13 + i14) + 1) / 2;
        int i18 = (i6 - i17) - 1;
        int i19 = i6 + i17 + 1;
        Arrays.fill(iArr3, i18, i19, 0);
        Arrays.fill(iArr4, i18 + i16, i19 + i16, i13);
        boolean z3 = i16 % 2 != 0;
        int i20 = 0;
        while (i20 <= i17) {
            int i21 = -i20;
            int i22 = i21;
            while (i22 <= i20) {
                if (i22 != i21) {
                    if (i22 != i20) {
                        int i23 = i6 + i22;
                    }
                    i11 = iArr3[(i6 + i22) - i15] + i15;
                    z2 = true;
                    i12 = i11 - i22;
                    while (i11 < i13 && i12 < i14 && aVar2.b(i2 + i11, i4 + i12)) {
                        i11++;
                        i12++;
                    }
                    int i24 = i6 + i22;
                    iArr3[i24] = i11;
                    if (z3 || i22 < (i16 - i20) + 1 || i22 > (i16 + i20) - 1 || iArr3[i24] < iArr4[i24]) {
                        i22 += 2;
                        i15 = 1;
                    } else {
                        f fVar = new f();
                        fVar.f1987a = iArr4[i24];
                        fVar.f1988b = fVar.f1987a - i22;
                        fVar.f1989c = iArr3[i24] - iArr4[i24];
                        fVar.f1990d = z2;
                        fVar.f1991e = false;
                        return fVar;
                    }
                }
                i11 = iArr3[i6 + i22 + i15];
                z2 = false;
                i12 = i11 - i22;
                while (i11 < i13) {
                    i11++;
                    i12++;
                }
                int i242 = i6 + i22;
                iArr3[i242] = i11;
                if (z3) {
                }
                i22 += 2;
                i15 = 1;
            }
            int i25 = i21;
            while (i25 <= i20) {
                int i26 = i25 + i16;
                if (i26 != i20 + i16) {
                    if (i26 != i21 + i16) {
                        int i27 = i6 + i26;
                        i10 = 1;
                    } else {
                        i10 = 1;
                    }
                    i7 = iArr4[(i6 + i26) + i10] - i10;
                    z = true;
                    i8 = i7 - i26;
                    while (true) {
                        if (i7 > 0 && i8 > 0) {
                            i9 = i13;
                            if (!aVar2.b((i2 + i7) - 1, (i4 + i8) - 1)) {
                                break;
                            }
                            i7--;
                            i8--;
                            i13 = i9;
                        } else {
                            i9 = i13;
                        }
                    }
                    i9 = i13;
                    int i28 = i6 + i26;
                    iArr4[i28] = i7;
                    if (!z3 || i26 < i21 || i26 > i20 || iArr3[i28] < iArr4[i28]) {
                        i25 += 2;
                        i13 = i9;
                    } else {
                        f fVar2 = new f();
                        fVar2.f1987a = iArr4[i28];
                        fVar2.f1988b = fVar2.f1987a - i26;
                        fVar2.f1989c = iArr3[i28] - iArr4[i28];
                        fVar2.f1990d = z;
                        fVar2.f1991e = true;
                        return fVar2;
                    }
                } else {
                    i10 = 1;
                }
                i7 = iArr4[(i6 + i26) - i10];
                z = false;
                i8 = i7 - i26;
                while (true) {
                    if (i7 > 0) {
                        break;
                    }
                    break;
                    i7--;
                    i8--;
                    i13 = i9;
                }
                i9 = i13;
                int i282 = i6 + i26;
                iArr4[i282] = i7;
                if (!z3) {
                }
                i25 += 2;
                i13 = i9;
            }
            i20++;
            i13 = i13;
            i15 = 1;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
