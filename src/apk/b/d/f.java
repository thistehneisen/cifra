package b.d;

/* compiled from: LongSparseArray */
public class f<E> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private static final Object f2277a = new Object();

    /* renamed from: b reason: collision with root package name */
    private boolean f2278b;

    /* renamed from: c reason: collision with root package name */
    private long[] f2279c;

    /* renamed from: d reason: collision with root package name */
    private Object[] f2280d;

    /* renamed from: e reason: collision with root package name */
    private int f2281e;

    public f() {
        this(10);
    }

    private void c() {
        int i2 = this.f2281e;
        long[] jArr = this.f2279c;
        Object[] objArr = this.f2280d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f2277a) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2278b = false;
        this.f2281e = i3;
    }

    @Deprecated
    public void a(long j2) {
        d(j2);
    }

    public E b(long j2) {
        return b(j2, null);
    }

    public void d(long j2) {
        int a2 = e.a(this.f2279c, this.f2281e, j2);
        if (a2 >= 0) {
            Object[] objArr = this.f2280d;
            Object obj = objArr[a2];
            Object obj2 = f2277a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f2278b = true;
            }
        }
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2281e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2281e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(a(i2));
            sb.append('=');
            Object c2 = c(i2);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i2) {
        this.f2278b = false;
        if (i2 == 0) {
            this.f2279c = e.f2275b;
            this.f2280d = e.f2276c;
            return;
        }
        int c2 = e.c(i2);
        this.f2279c = new long[c2];
        this.f2280d = new Object[c2];
    }

    public long a(int i2) {
        if (this.f2278b) {
            c();
        }
        return this.f2279c[i2];
    }

    public E b(long j2, E e2) {
        int a2 = e.a(this.f2279c, this.f2281e, j2);
        if (a2 >= 0) {
            E[] eArr = this.f2280d;
            if (eArr[a2] != f2277a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public f<E> clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.f2279c = (long[]) this.f2279c.clone();
            fVar.f2280d = (Object[]) this.f2280d.clone();
            return fVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public void a() {
        int i2 = this.f2281e;
        Object[] objArr = this.f2280d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2281e = 0;
        this.f2278b = false;
    }

    public void b(int i2) {
        Object[] objArr = this.f2280d;
        Object obj = objArr[i2];
        Object obj2 = f2277a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f2278b = true;
        }
    }

    public int b() {
        if (this.f2278b) {
            c();
        }
        return this.f2281e;
    }

    public void a(long j2, E e2) {
        int i2 = this.f2281e;
        if (i2 == 0 || j2 > this.f2279c[i2 - 1]) {
            if (this.f2278b && this.f2281e >= this.f2279c.length) {
                c();
            }
            int i3 = this.f2281e;
            if (i3 >= this.f2279c.length) {
                int c2 = e.c(i3 + 1);
                long[] jArr = new long[c2];
                Object[] objArr = new Object[c2];
                long[] jArr2 = this.f2279c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f2280d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f2279c = jArr;
                this.f2280d = objArr;
            }
            this.f2279c[i3] = j2;
            this.f2280d[i3] = e2;
            this.f2281e = i3 + 1;
            return;
        }
        c(j2, e2);
    }

    public void c(long j2, E e2) {
        int a2 = e.a(this.f2279c, this.f2281e, j2);
        if (a2 >= 0) {
            this.f2280d[a2] = e2;
        } else {
            int i2 = ~a2;
            if (i2 < this.f2281e) {
                Object[] objArr = this.f2280d;
                if (objArr[i2] == f2277a) {
                    this.f2279c[i2] = j2;
                    objArr[i2] = e2;
                    return;
                }
            }
            if (this.f2278b && this.f2281e >= this.f2279c.length) {
                c();
                i2 = ~e.a(this.f2279c, this.f2281e, j2);
            }
            int i3 = this.f2281e;
            if (i3 >= this.f2279c.length) {
                int c2 = e.c(i3 + 1);
                long[] jArr = new long[c2];
                Object[] objArr2 = new Object[c2];
                long[] jArr2 = this.f2279c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr3 = this.f2280d;
                System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                this.f2279c = jArr;
                this.f2280d = objArr2;
            }
            int i4 = this.f2281e;
            if (i4 - i2 != 0) {
                long[] jArr3 = this.f2279c;
                int i5 = i2 + 1;
                System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
                Object[] objArr4 = this.f2280d;
                System.arraycopy(objArr4, i2, objArr4, i5, this.f2281e - i2);
            }
            this.f2279c[i2] = j2;
            this.f2280d[i2] = e2;
            this.f2281e++;
        }
    }

    public E c(int i2) {
        if (this.f2278b) {
            c();
        }
        return this.f2280d[i2];
    }

    public int c(long j2) {
        if (this.f2278b) {
            c();
        }
        return e.a(this.f2279c, this.f2281e, j2);
    }
}
