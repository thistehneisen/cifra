package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class Hb extends Ra<Integer> implements Kb, C0465xc, RandomAccess {

    /* renamed from: b reason: collision with root package name */
    private static final Hb f4955b;

    /* renamed from: c reason: collision with root package name */
    private int[] f4956c;

    /* renamed from: d reason: collision with root package name */
    private int f4957d;

    static {
        Hb hb = new Hb(new int[0], 0);
        f4955b = hb;
        hb.a();
    }

    Hb() {
        this(new int[10], 0);
    }

    public static Hb f() {
        return f4955b;
    }

    private final void g(int i2) {
        if (i2 < 0 || i2 >= this.f4957d) {
            throw new IndexOutOfBoundsException(h(i2));
        }
    }

    private final String h(int i2) {
        int i3 = this.f4957d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final int a(int i2) {
        g(i2);
        return this.f4956c[i2];
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        e();
        Fb.a(collection);
        if (!(collection instanceof Hb)) {
            return super.addAll(collection);
        }
        Hb hb = (Hb) collection;
        int i2 = hb.f4957d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4957d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            int[] iArr = this.f4956c;
            if (i4 > iArr.length) {
                this.f4956c = Arrays.copyOf(iArr, i4);
            }
            System.arraycopy(hb.f4956c, 0, this.f4956c, this.f4957d, hb.f4957d);
            this.f4957d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: d */
    public final Kb b(int i2) {
        if (i2 >= this.f4957d) {
            return new Hb(Arrays.copyOf(this.f4956c, i2), this.f4957d);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hb)) {
            return super.equals(obj);
        }
        Hb hb = (Hb) obj;
        if (this.f4957d != hb.f4957d) {
            return false;
        }
        int[] iArr = hb.f4956c;
        for (int i2 = 0; i2 < this.f4957d; i2++) {
            if (this.f4956c[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(a(i2));
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4957d; i3++) {
            i2 = (i2 * 31) + this.f4956c[i3];
        }
        return i2;
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f4957d; i2++) {
            if (obj.equals(Integer.valueOf(this.f4956c[i2]))) {
                int[] iArr = this.f4956c;
                System.arraycopy(iArr, i2 + 1, iArr, i2, (this.f4957d - i2) - 1);
                this.f4957d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        e();
        if (i3 >= i2) {
            int[] iArr = this.f4956c;
            System.arraycopy(iArr, i3, iArr, i2, this.f4957d - i3);
            this.f4957d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        int intValue = ((Integer) obj).intValue();
        e();
        g(i2);
        int[] iArr = this.f4956c;
        int i3 = iArr[i2];
        iArr[i2] = intValue;
        return Integer.valueOf(i3);
    }

    public final int size() {
        return this.f4957d;
    }

    private Hb(int[] iArr, int i2) {
        this.f4956c = iArr;
        this.f4957d = i2;
    }

    public final void f(int i2) {
        a(this.f4957d, i2);
    }

    private final void a(int i2, int i3) {
        e();
        if (i2 >= 0) {
            int i4 = this.f4957d;
            if (i2 <= i4) {
                int[] iArr = this.f4956c;
                if (i4 < iArr.length) {
                    System.arraycopy(iArr, i2, iArr, i2 + 1, i4 - i2);
                } else {
                    int[] iArr2 = new int[(((i4 * 3) / 2) + 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    System.arraycopy(this.f4956c, i2, iArr2, i2 + 1, this.f4957d - i2);
                    this.f4956c = iArr2;
                }
                this.f4956c[i2] = i3;
                this.f4957d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(h(i2));
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        g(i2);
        int[] iArr = this.f4956c;
        int i3 = iArr[i2];
        int i4 = this.f4957d;
        if (i2 < i4 - 1) {
            System.arraycopy(iArr, i2 + 1, iArr, i2, (i4 - i2) - 1);
        }
        this.f4957d--;
        this.modCount++;
        return Integer.valueOf(i3);
    }
}
