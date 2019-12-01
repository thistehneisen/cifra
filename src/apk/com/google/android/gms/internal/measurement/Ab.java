package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class Ab extends Ra<Float> implements Mb<Float>, C0465xc, RandomAccess {

    /* renamed from: b reason: collision with root package name */
    private static final Ab f4848b;

    /* renamed from: c reason: collision with root package name */
    private float[] f4849c;

    /* renamed from: d reason: collision with root package name */
    private int f4850d;

    static {
        Ab ab = new Ab(new float[0], 0);
        f4848b = ab;
        ab.a();
    }

    Ab() {
        this(new float[10], 0);
    }

    private final String f(int i2) {
        int i3 = this.f4850d;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    public final void a(float f2) {
        a(this.f4850d, f2);
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        a(i2, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        e();
        Fb.a(collection);
        if (!(collection instanceof Ab)) {
            return super.addAll(collection);
        }
        Ab ab = (Ab) collection;
        int i2 = ab.f4850d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f4850d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.f4849c;
            if (i4 > fArr.length) {
                this.f4849c = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(ab.f4849c, 0, this.f4849c, this.f4850d, ab.f4850d);
            this.f4850d = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final /* synthetic */ Mb b(int i2) {
        if (i2 >= this.f4850d) {
            return new Ab(Arrays.copyOf(this.f4849c, i2), this.f4850d);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ab)) {
            return super.equals(obj);
        }
        Ab ab = (Ab) obj;
        if (this.f4850d != ab.f4850d) {
            return false;
        }
        float[] fArr = ab.f4849c;
        for (int i2 = 0; i2 < this.f4850d; i2++) {
            if (Float.floatToIntBits(this.f4849c[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        a(i2);
        return Float.valueOf(this.f4849c[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f4850d; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.f4849c[i3]);
        }
        return i2;
    }

    public final boolean remove(Object obj) {
        e();
        for (int i2 = 0; i2 < this.f4850d; i2++) {
            if (obj.equals(Float.valueOf(this.f4849c[i2]))) {
                float[] fArr = this.f4849c;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.f4850d - i2) - 1);
                this.f4850d--;
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
            float[] fArr = this.f4849c;
            System.arraycopy(fArr, i3, fArr, i2, this.f4850d - i3);
            this.f4850d -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        e();
        a(i2);
        float[] fArr = this.f4849c;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    public final int size() {
        return this.f4850d;
    }

    private Ab(float[] fArr, int i2) {
        this.f4849c = fArr;
        this.f4850d = i2;
    }

    private final void a(int i2, float f2) {
        e();
        if (i2 >= 0) {
            int i3 = this.f4850d;
            if (i2 <= i3) {
                float[] fArr = this.f4849c;
                if (i3 < fArr.length) {
                    System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
                } else {
                    float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
                    System.arraycopy(fArr, 0, fArr2, 0, i2);
                    System.arraycopy(this.f4849c, i2, fArr2, i2 + 1, this.f4850d - i2);
                    this.f4849c = fArr2;
                }
                this.f4849c[i2] = f2;
                this.f4850d++;
                this.modCount++;
                return;
            }
        }
        throw new IndexOutOfBoundsException(f(i2));
    }

    public final /* synthetic */ Object remove(int i2) {
        e();
        a(i2);
        float[] fArr = this.f4849c;
        float f2 = fArr[i2];
        int i3 = this.f4850d;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.f4850d--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    private final void a(int i2) {
        if (i2 < 0 || i2 >= this.f4850d) {
            throw new IndexOutOfBoundsException(f(i2));
        }
    }
}
