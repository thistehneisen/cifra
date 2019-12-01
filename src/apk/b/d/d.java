package b.d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ArraySet */
public final class d<E> implements Collection<E>, Set<E> {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f2264a = new int[0];

    /* renamed from: b reason: collision with root package name */
    private static final Object[] f2265b = new Object[0];

    /* renamed from: c reason: collision with root package name */
    private static Object[] f2266c;

    /* renamed from: d reason: collision with root package name */
    private static int f2267d;

    /* renamed from: e reason: collision with root package name */
    private static Object[] f2268e;

    /* renamed from: f reason: collision with root package name */
    private static int f2269f;

    /* renamed from: g reason: collision with root package name */
    private int[] f2270g;

    /* renamed from: h reason: collision with root package name */
    Object[] f2271h;

    /* renamed from: i reason: collision with root package name */
    int f2272i;

    /* renamed from: j reason: collision with root package name */
    private h<E, E> f2273j;

    public d() {
        this(0);
    }

    private int a(Object obj, int i2) {
        int i3 = this.f2272i;
        if (i3 == 0) {
            return -1;
        }
        int a2 = e.a(this.f2270g, i3, i2);
        if (a2 < 0 || obj.equals(this.f2271h[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f2270g[i4] == i2) {
            if (obj.equals(this.f2271h[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f2270g[i5] == i2) {
            if (obj.equals(this.f2271h[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    private h<E, E> e() {
        if (this.f2273j == null) {
            this.f2273j = new c(this);
        }
        return this.f2273j;
    }

    private int f() {
        int i2 = this.f2272i;
        if (i2 == 0) {
            return -1;
        }
        int a2 = e.a(this.f2270g, i2, 0);
        if (a2 < 0 || this.f2271h[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f2270g[i3] == 0) {
            if (this.f2271h[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f2270g[i4] == 0) {
            if (this.f2271h[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    private void h(int i2) {
        if (i2 == 8) {
            synchronized (d.class) {
                if (f2268e != null) {
                    Object[] objArr = f2268e;
                    this.f2271h = objArr;
                    f2268e = (Object[]) objArr[0];
                    this.f2270g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2269f--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (d.class) {
                if (f2266c != null) {
                    Object[] objArr2 = f2266c;
                    this.f2271h = objArr2;
                    f2266c = (Object[]) objArr2[0];
                    this.f2270g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2267d--;
                    return;
                }
            }
        }
        this.f2270g = new int[i2];
        this.f2271h = new Object[i2];
    }

    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = f();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = a(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.f2272i;
        if (i5 >= this.f2270g.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f2270g;
            Object[] objArr = this.f2271h;
            h(i6);
            int[] iArr2 = this.f2270g;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2271h, 0, objArr.length);
            }
            a(iArr, objArr, this.f2272i);
        }
        int i7 = this.f2272i;
        if (i4 < i7) {
            int[] iArr3 = this.f2270g;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f2271h;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f2272i - i4);
        }
        this.f2270g[i4] = i2;
        this.f2271h[i4] = e2;
        this.f2272i++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        a(this.f2272i + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public void clear() {
        int i2 = this.f2272i;
        if (i2 != 0) {
            a(this.f2270g, this.f2271h, i2);
            this.f2270g = f2264a;
            this.f2271h = f2265b;
            this.f2272i = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f2272i) {
                try {
                    if (!set.contains(g(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E g(int i2) {
        return this.f2271h[i2];
    }

    public int hashCode() {
        int[] iArr = this.f2270g;
        int i2 = 0;
        for (int i3 = 0; i3 < this.f2272i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f2272i <= 0;
    }

    public Iterator<E> iterator() {
        return e().e().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        f(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f2272i - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f2271h[i2])) {
                f(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f2272i;
    }

    public Object[] toArray() {
        int i2 = this.f2272i;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f2271h, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2272i * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2272i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object g2 = g(i2);
            if (g2 != this) {
                sb.append(g2);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        if (i2 == 0) {
            this.f2270g = f2264a;
            this.f2271h = f2265b;
        } else {
            h(i2);
        }
        this.f2272i = 0;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f2272i) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2272i);
        }
        System.arraycopy(this.f2271h, 0, tArr, 0, this.f2272i);
        int length = tArr.length;
        int i2 = this.f2272i;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (d.class) {
                if (f2269f < 10) {
                    objArr[0] = f2268e;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2268e = objArr;
                    f2269f++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (d.class) {
                if (f2267d < 10) {
                    objArr[0] = f2266c;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2266c = objArr;
                    f2267d++;
                }
            }
        }
    }

    public E f(int i2) {
        E[] eArr = this.f2271h;
        E e2 = eArr[i2];
        int i3 = this.f2272i;
        if (i3 <= 1) {
            a(this.f2270g, eArr, i3);
            this.f2270g = f2264a;
            this.f2271h = f2265b;
            this.f2272i = 0;
        } else {
            int[] iArr = this.f2270g;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                this.f2272i--;
                int i5 = this.f2272i;
                if (i2 < i5) {
                    int[] iArr2 = this.f2270g;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr = this.f2271h;
                    System.arraycopy(objArr, i6, objArr, i2, this.f2272i - i2);
                }
                this.f2271h[this.f2272i] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f2270g;
                Object[] objArr2 = this.f2271h;
                h(i4);
                this.f2272i--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f2270g, 0, i2);
                    System.arraycopy(objArr2, 0, this.f2271h, 0, i2);
                }
                int i7 = this.f2272i;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f2270g, i2, i7 - i2);
                    System.arraycopy(objArr2, i8, this.f2271h, i2, this.f2272i - i2);
                }
            }
        }
        return e2;
    }

    public void a(int i2) {
        int[] iArr = this.f2270g;
        if (iArr.length < i2) {
            Object[] objArr = this.f2271h;
            h(i2);
            int i3 = this.f2272i;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.f2270g, 0, i3);
                System.arraycopy(objArr, 0, this.f2271h, 0, this.f2272i);
            }
            a(iArr, objArr, this.f2272i);
        }
    }
}
