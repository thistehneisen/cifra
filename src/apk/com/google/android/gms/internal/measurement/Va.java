package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class Va extends Ra<Boolean> implements Mb<Boolean>, C0465xc, RandomAccess {

    /* renamed from: b reason: collision with root package name */
    private static final Va f5055b;

    /* renamed from: c reason: collision with root package name */
    private boolean[] f5056c;

    /* renamed from: d reason: collision with root package name */
    private int f5057d;

    static {
        Va va = new Va(new boolean[0], 0);
        f5055b = va;
        va.a();
    }

    Va() {
        this(new boolean[10], 0);
    }

    private final String f(int i2) {
        int i3 = this.f5057d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final void a(boolean z) {
        a(this.f5057d, z);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        e();
        Fb.a(collection);
        if (!(collection instanceof Va)) {
            return super.addAll(collection);
        }
        Va va = (Va) collection;
        int i2 = va.f5057d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f5057d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.f5056c;
            if (i4 > zArr.length) {
                this.f5056c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(va.f5056c, 0, this.f5056c, this.f5057d, va.f5057d);
            this.f5057d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final /* synthetic */ Mb b(int i2) {
        if (i2 >= this.f5057d) {
            return new Va(Arrays.copyOf(this.f5056c, i2), this.f5057d);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Va)) {
            return super.equals(obj);
        }
        Va va = (Va) obj;
        if (this.f5057d != va.f5057d) {
            return false;
        }
        boolean[] zArr = va.f5056c;
        for (int i2 = 0; i2 < this.f5057d; i2++) {
            if (this.f5056c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        a(i2);
        return Boolean.valueOf(this.f5056c[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f5057d; i3++) {
            i2 = (i2 * 31) + Fb.a(this.f5056c[i3]);
        }
        return i2;
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f5057d; i2++) {
            if (obj.equals(Boolean.valueOf(this.f5056c[i2]))) {
                boolean[] zArr = this.f5056c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f5057d - i2) - 1);
                this.f5057d--;
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
            boolean[] zArr = this.f5056c;
            System.arraycopy(zArr, i3, zArr, i2, this.f5057d - i3);
            this.f5057d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        e();
        a(i2);
        boolean[] zArr = this.f5056c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.f5057d;
    }

    private Va(boolean[] zArr, int i2) {
        this.f5056c = zArr;
        this.f5057d = i2;
    }

    private final void a(int i2, boolean z) {
        e();
        if (i2 >= 0) {
            int i3 = this.f5057d;
            if (i2 <= i3) {
                boolean[] zArr = this.f5056c;
                if (i3 < zArr.length) {
                    System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
                } else {
                    boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(zArr, 0, zArr2, 0, i2);
                    System.arraycopy(this.f5056c, i2, zArr2, i2 + 1, this.f5057d - i2);
                    this.f5056c = zArr2;
                }
                this.f5056c[i2] = z;
                this.f5057d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(f(i2));
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        a(i2);
        boolean[] zArr = this.f5056c;
        boolean z = zArr[i2];
        int i3 = this.f5057d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f5057d--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    private final void a(int i2) {
        if (i2 < 0 || i2 >= this.f5057d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }
}
