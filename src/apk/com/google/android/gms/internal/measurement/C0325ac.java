package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.ac reason: case insensitive filesystem */
final class C0325ac extends Ra<Long> implements Nb, C0465xc, RandomAccess {

    /* renamed from: b reason: collision with root package name */
    private static final C0325ac f5119b;

    /* renamed from: c reason: collision with root package name */
    private long[] f5120c;

    /* renamed from: d reason: collision with root package name */
    private int f5121d;

    static {
        C0325ac acVar = new C0325ac(new long[0], 0);
        f5119b = acVar;
        acVar.a();
    }

    C0325ac() {
        this(new long[10], 0);
    }

    public static C0325ac f() {
        return f5119b;
    }

    public final void a(long j2) {
        a(this.f5121d, j2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        e();
        Fb.a(collection);
        if (!(collection instanceof C0325ac)) {
            return super.addAll(collection);
        }
        C0325ac acVar = (C0325ac) collection;
        int i2 = acVar.f5121d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f5121d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            long[] jArr = this.f5120c;
            if (i4 > jArr.length) {
                this.f5120c = Arrays.copyOf(jArr, i4);
            }
            System.arraycopy(acVar.f5120c, 0, this.f5120c, this.f5121d, acVar.f5121d);
            this.f5121d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    /* renamed from: c */
    public final Nb b(int i2) {
        if (i2 >= this.f5121d) {
            return new C0325ac(Arrays.copyOf(this.f5120c, i2), this.f5121d);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0325ac)) {
            return super.equals(obj);
        }
        C0325ac acVar = (C0325ac) obj;
        if (this.f5121d != acVar.f5121d) {
            return false;
        }
        long[] jArr = acVar.f5120c;
        for (int i2 = 0; i2 < this.f5121d; i2++) {
            if (this.f5120c[i2] != jArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        return Long.valueOf(getLong(i2));
    }

    public final long getLong(int i2) {
        a(i2);
        return this.f5120c[i2];
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f5121d; i3++) {
            i2 = (i2 * 31) + Fb.a(this.f5120c[i3]);
        }
        return i2;
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f5121d; i2++) {
            if (obj.equals(Long.valueOf(this.f5120c[i2]))) {
                long[] jArr = this.f5120c;
                System.arraycopy(jArr, i2 + 1, jArr, i2, (this.f5121d - i2) - 1);
                this.f5121d--;
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
            long[] jArr = this.f5120c;
            System.arraycopy(jArr, i3, jArr, i2, this.f5121d - i3);
            this.f5121d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        long longValue = ((Long) obj).longValue();
        e();
        a(i2);
        long[] jArr = this.f5120c;
        long j2 = jArr[i2];
        jArr[i2] = longValue;
        return Long.valueOf(j2);
    }

    public final int size() {
        return this.f5121d;
    }

    private C0325ac(long[] jArr, int i2) {
        this.f5120c = jArr;
        this.f5121d = i2;
    }

    private final void a(int i2, long j2) {
        e();
        if (i2 >= 0) {
            int i3 = this.f5121d;
            if (i2 <= i3) {
                long[] jArr = this.f5120c;
                if (i3 < jArr.length) {
                    System.arraycopy(jArr, i2, jArr, i2 + 1, i3 - i2);
                } else {
                    long[] jArr2 = new long[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(jArr, 0, jArr2, 0, i2);
                    System.arraycopy(this.f5120c, i2, jArr2, i2 + 1, this.f5121d - i2);
                    this.f5120c = jArr2;
                }
                this.f5120c[i2] = j2;
                this.f5121d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(f(i2));
    }

    private final String f(int i2) {
        int i3 = this.f5121d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        a(i2);
        long[] jArr = this.f5120c;
        long j2 = jArr[i2];
        int i3 = this.f5121d;
        if (i2 < i3 - 1) {
            System.arraycopy(jArr, i2 + 1, jArr, i2, (i3 - i2) - 1);
        }
        this.f5121d--;
        this.modCount++;
        return Long.valueOf(j2);
    }

    private final void a(int i2) {
        if (i2 < 0 || i2 >= this.f5121d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }
}
