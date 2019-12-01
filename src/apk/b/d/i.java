package b.d;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: SimpleArrayMap */
public class i<K, V> {

    /* renamed from: a reason: collision with root package name */
    static Object[] f2305a;

    /* renamed from: b reason: collision with root package name */
    static int f2306b;

    /* renamed from: c reason: collision with root package name */
    static Object[] f2307c;

    /* renamed from: d reason: collision with root package name */
    static int f2308d;

    /* renamed from: e reason: collision with root package name */
    int[] f2309e;

    /* renamed from: f reason: collision with root package name */
    Object[] f2310f;

    /* renamed from: g reason: collision with root package name */
    int f2311g;

    public i() {
        this.f2309e = e.f2274a;
        this.f2310f = e.f2276c;
        this.f2311g = 0;
    }

    private static int a(int[] iArr, int i2, int i3) {
        try {
            return e.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void e(int i2) {
        if (i2 == 8) {
            synchronized (i.class) {
                if (f2307c != null) {
                    Object[] objArr = f2307c;
                    this.f2310f = objArr;
                    f2307c = (Object[]) objArr[0];
                    this.f2309e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2308d--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (i.class) {
                if (f2305a != null) {
                    Object[] objArr2 = f2305a;
                    this.f2310f = objArr2;
                    f2305a = (Object[]) objArr2[0];
                    this.f2309e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2306b--;
                    return;
                }
            }
        }
        this.f2309e = new int[i2];
        this.f2310f = new Object[(i2 << 1)];
    }

    /* access modifiers changed from: 0000 */
    public int b(Object obj) {
        int i2 = this.f2311g * 2;
        Object[] objArr = this.f2310f;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
        } else {
            for (int i4 = 1; i4 < i2; i4 += 2) {
                if (obj.equals(objArr[i4])) {
                    return i4 >> 1;
                }
            }
        }
        return -1;
    }

    public V c(int i2) {
        int i3;
        V[] vArr = this.f2310f;
        int i4 = i2 << 1;
        V v = vArr[i4 + 1];
        int i5 = this.f2311g;
        if (i5 <= 1) {
            a(this.f2309e, (Object[]) vArr, i5);
            this.f2309e = e.f2274a;
            this.f2310f = e.f2276c;
            i3 = 0;
        } else {
            i3 = i5 - 1;
            int[] iArr = this.f2309e;
            int i6 = 8;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i2 < i3) {
                    int[] iArr2 = this.f2309e;
                    int i7 = i2 + 1;
                    int i8 = i3 - i2;
                    System.arraycopy(iArr2, i7, iArr2, i2, i8);
                    Object[] objArr = this.f2310f;
                    System.arraycopy(objArr, i7 << 1, objArr, i4, i8 << 1);
                }
                Object[] objArr2 = this.f2310f;
                int i9 = i3 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i5 > 8) {
                    i6 = i5 + (i5 >> 1);
                }
                int[] iArr3 = this.f2309e;
                Object[] objArr3 = this.f2310f;
                e(i6);
                if (i5 == this.f2311g) {
                    if (i2 > 0) {
                        System.arraycopy(iArr3, 0, this.f2309e, 0, i2);
                        System.arraycopy(objArr3, 0, this.f2310f, 0, i4);
                    }
                    if (i2 < i3) {
                        int i10 = i2 + 1;
                        int i11 = i3 - i2;
                        System.arraycopy(iArr3, i10, this.f2309e, i2, i11);
                        System.arraycopy(objArr3, i10 << 1, this.f2310f, i4, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (i5 == this.f2311g) {
            this.f2311g = i3;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int i2 = this.f2311g;
        if (i2 > 0) {
            int[] iArr = this.f2309e;
            Object[] objArr = this.f2310f;
            this.f2309e = e.f2274a;
            this.f2310f = e.f2276c;
            this.f2311g = 0;
            a(iArr, objArr, i2);
        }
        if (this.f2311g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V d(int i2) {
        return this.f2310f[(i2 << 1) + 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (size() != iVar.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f2311g) {
                try {
                    Object b2 = b(i2);
                    Object d2 = d(i2);
                    Object obj2 = iVar.get(b2);
                    if (d2 == null) {
                        if (obj2 != null || !iVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!d2.equals(obj2)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i3 = 0;
            while (i3 < this.f2311g) {
                try {
                    Object b3 = b(i3);
                    Object d3 = d(i3);
                    Object obj3 = map.get(b3);
                    if (d3 == null) {
                        if (obj3 != null || !map.containsKey(b3)) {
                            return false;
                        }
                    } else if (!d3.equals(obj3)) {
                        return false;
                    }
                    i3++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? this.f2310f[(a2 << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f2309e;
        Object[] objArr = this.f2310f;
        int i2 = this.f2311g;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < i2) {
            Object obj = objArr[i5];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i5 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f2311g <= 0;
    }

    public V put(K k2, V v) {
        int i2;
        int i3;
        int i4 = this.f2311g;
        if (k2 == null) {
            i3 = a();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = a((Object) k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            V[] vArr = this.f2310f;
            V v2 = vArr[i5];
            vArr[i5] = v;
            return v2;
        }
        int i6 = ~i3;
        if (i4 >= this.f2309e.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            int[] iArr = this.f2309e;
            Object[] objArr = this.f2310f;
            e(i7);
            if (i4 == this.f2311g) {
                int[] iArr2 = this.f2309e;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f2310f, 0, objArr.length);
                }
                a(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.f2309e;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr2 = this.f2310f;
            System.arraycopy(objArr2, i6 << 1, objArr2, i8 << 1, (this.f2311g - i6) << 1);
        }
        int i9 = this.f2311g;
        if (i4 == i9) {
            int[] iArr4 = this.f2309e;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr3 = this.f2310f;
                int i10 = i6 << 1;
                objArr3[i10] = k2;
                objArr3[i10 + 1] = v;
                this.f2311g = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v) {
        V v2 = get(k2);
        return v2 == null ? put(k2, v) : v2;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return c(a2);
        }
        return null;
    }

    public V replace(K k2, V v) {
        int a2 = a((Object) k2);
        if (a2 >= 0) {
            return a(a2, v);
        }
        return null;
    }

    public int size() {
        return this.f2311g;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2311g * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2311g; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object b2 = b(i2);
            String str = "(this Map)";
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append(str);
            }
            sb.append('=');
            Object d2 = d(i2);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append(str);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public int a(Object obj, int i2) {
        int i3 = this.f2311g;
        if (i3 == 0) {
            return -1;
        }
        int a2 = a(this.f2309e, i3, i2);
        if (a2 < 0 || obj.equals(this.f2310f[a2 << 1])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f2309e[i4] == i2) {
            if (obj.equals(this.f2310f[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f2309e[i5] == i2) {
            if (obj.equals(this.f2310f[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 >= 0) {
            Object d2 = d(a2);
            if (obj2 == d2 || (obj2 != null && obj2.equals(d2))) {
                c(a2);
                return true;
            }
        }
        return false;
    }

    public boolean replace(K k2, V v, V v2) {
        int a2 = a((Object) k2);
        if (a2 >= 0) {
            V d2 = d(a2);
            if (d2 == v || (v != null && v.equals(d2))) {
                a(a2, v2);
                return true;
            }
        }
        return false;
    }

    public i(int i2) {
        if (i2 == 0) {
            this.f2309e = e.f2274a;
            this.f2310f = e.f2276c;
        } else {
            e(i2);
        }
        this.f2311g = 0;
    }

    public K b(int i2) {
        return this.f2310f[i2 << 1];
    }

    public i(i<K, V> iVar) {
        this();
        if (iVar != null) {
            a(iVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public int a() {
        int i2 = this.f2311g;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f2309e, i2, 0);
        if (a2 < 0 || this.f2310f[a2 << 1] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f2309e[i3] == 0) {
            if (this.f2310f[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f2309e[i4] == 0) {
            if (this.f2310f[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (i.class) {
                if (f2308d < 10) {
                    objArr[0] = f2307c;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2307c = objArr;
                    f2308d++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (i.class) {
                if (f2306b < 10) {
                    objArr[0] = f2305a;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2305a = objArr;
                    f2306b++;
                }
            }
        }
    }

    public void a(int i2) {
        int i3 = this.f2311g;
        int[] iArr = this.f2309e;
        if (iArr.length < i2) {
            Object[] objArr = this.f2310f;
            e(i2);
            if (this.f2311g > 0) {
                System.arraycopy(iArr, 0, this.f2309e, 0, i3);
                System.arraycopy(objArr, 0, this.f2310f, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.f2311g != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public V a(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.f2310f;
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    public void a(i<? extends K, ? extends V> iVar) {
        int i2 = iVar.f2311g;
        a(this.f2311g + i2);
        if (this.f2311g != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(iVar.b(i3), iVar.d(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(iVar.f2309e, 0, this.f2309e, 0, i2);
            System.arraycopy(iVar.f2310f, 0, this.f2310f, 0, i2 << 1);
            this.f2311g = i2;
        }
    }
}
