package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.nb reason: case insensitive filesystem */
final class C0405nb extends Ra<Double> implements Mb<Double>, C0465xc, RandomAccess {

    /* renamed from: b reason: collision with root package name */
    private static final C0405nb f5292b;

    /* renamed from: c reason: collision with root package name */
    private double[] f5293c;

    /* renamed from: d reason: collision with root package name */
    private int f5294d;

    static {
        C0405nb nbVar = new C0405nb(new double[0], 0);
        f5292b = nbVar;
        nbVar.a();
    }

    C0405nb() {
        this(new double[10], 0);
    }

    private final String f(int i2) {
        int i3 = this.f5294d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final void a(double d2) {
        a(this.f5294d, d2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        e();
        Fb.a(collection);
        if (!(collection instanceof C0405nb)) {
            return super.addAll(collection);
        }
        C0405nb nbVar = (C0405nb) collection;
        int i2 = nbVar.f5294d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f5294d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            double[] dArr = this.f5293c;
            if (i4 > dArr.length) {
                this.f5293c = Arrays.copyOf(dArr, i4);
            }
            System.arraycopy(nbVar.f5293c, 0, this.f5293c, this.f5294d, nbVar.f5294d);
            this.f5294d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final /* synthetic */ Mb b(int i2) {
        if (i2 >= this.f5294d) {
            return new C0405nb(Arrays.copyOf(this.f5293c, i2), this.f5294d);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0405nb)) {
            return super.equals(obj);
        }
        C0405nb nbVar = (C0405nb) obj;
        if (this.f5294d != nbVar.f5294d) {
            return false;
        }
        double[] dArr = nbVar.f5293c;
        for (int i2 = 0; i2 < this.f5294d; i2++) {
            if (Double.doubleToLongBits(this.f5293c[i2]) != Double.doubleToLongBits(dArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        a(i2);
        return Double.valueOf(this.f5293c[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f5294d; i3++) {
            i2 = (i2 * 31) + Fb.a(Double.doubleToLongBits(this.f5293c[i3]));
        }
        return i2;
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f5294d; i2++) {
            if (obj.equals(Double.valueOf(this.f5293c[i2]))) {
                double[] dArr = this.f5293c;
                System.arraycopy(dArr, i2 + 1, dArr, i2, (this.f5294d - i2) - 1);
                this.f5294d--;
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
            double[] dArr = this.f5293c;
            System.arraycopy(dArr, i3, dArr, i2, this.f5294d - i3);
            this.f5294d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        e();
        a(i2);
        double[] dArr = this.f5293c;
        double d2 = dArr[i2];
        dArr[i2] = doubleValue;
        return Double.valueOf(d2);
    }

    public final int size() {
        return this.f5294d;
    }

    private C0405nb(double[] dArr, int i2) {
        this.f5293c = dArr;
        this.f5294d = i2;
    }

    private final void a(int i2, double d2) {
        e();
        if (i2 >= 0) {
            int i3 = this.f5294d;
            if (i2 <= i3) {
                double[] dArr = this.f5293c;
                if (i3 < dArr.length) {
                    System.arraycopy(dArr, i2, dArr, i2 + 1, i3 - i2);
                } else {
                    double[] dArr2 = new double[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(dArr, 0, dArr2, 0, i2);
                    System.arraycopy(this.f5293c, i2, dArr2, i2 + 1, this.f5294d - i2);
                    this.f5293c = dArr2;
                }
                this.f5293c[i2] = d2;
                this.f5294d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(f(i2));
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        a(i2);
        double[] dArr = this.f5293c;
        double d2 = dArr[i2];
        int i3 = this.f5294d;
        if (i2 < i3 - 1) {
            System.arraycopy(dArr, i2 + 1, dArr, i2, (i3 - i2) - 1);
        }
        this.f5294d--;
        this.modCount++;
        return Double.valueOf(d2);
    }

    private final void a(int i2) {
        if (i2 < 0 || i2 >= this.f5294d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }
}
