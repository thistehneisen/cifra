package b.d;

/* compiled from: SparseArrayCompat */
public class j<E> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private static final Object f2312a = new Object();

    /* renamed from: b reason: collision with root package name */
    private boolean f2313b;

    /* renamed from: c reason: collision with root package name */
    private int[] f2314c;

    /* renamed from: d reason: collision with root package name */
    private Object[] f2315d;

    /* renamed from: e reason: collision with root package name */
    private int f2316e;

    public j() {
        this(10);
    }

    private void c() {
        int i2 = this.f2316e;
        int[] iArr = this.f2314c;
        Object[] objArr = this.f2315d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f2312a) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2313b = false;
        this.f2316e = i3;
    }

    public E a(int i2) {
        return b(i2, null);
    }

    public E b(int i2, E e2) {
        int a2 = e.a(this.f2314c, this.f2316e, i2);
        if (a2 >= 0) {
            E[] eArr = this.f2315d;
            if (eArr[a2] != f2312a) {
                return eArr[a2];
            }
        }
        return e2;
    }

    public void d(int i2) {
        int a2 = e.a(this.f2314c, this.f2316e, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f2315d;
            Object obj = objArr[a2];
            Object obj2 = f2312a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f2313b = true;
            }
        }
    }

    public E e(int i2) {
        if (this.f2313b) {
            c();
        }
        return this.f2315d[i2];
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2316e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2316e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(c(i2));
            sb.append('=');
            Object e2 = e(i2);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i2) {
        this.f2313b = false;
        if (i2 == 0) {
            this.f2314c = e.f2274a;
            this.f2315d = e.f2276c;
            return;
        }
        int b2 = e.b(i2);
        this.f2314c = new int[b2];
        this.f2315d = new Object[b2];
    }

    public int a(E e2) {
        if (this.f2313b) {
            c();
        }
        for (int i2 = 0; i2 < this.f2316e; i2++) {
            if (this.f2315d[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.f2314c = (int[]) this.f2314c.clone();
            jVar.f2315d = (Object[]) this.f2315d.clone();
            return jVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int b() {
        if (this.f2313b) {
            c();
        }
        return this.f2316e;
    }

    public void a() {
        int i2 = this.f2316e;
        Object[] objArr = this.f2315d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2316e = 0;
        this.f2313b = false;
    }

    public int b(int i2) {
        if (this.f2313b) {
            c();
        }
        return e.a(this.f2314c, this.f2316e, i2);
    }

    public void a(int i2, E e2) {
        int i3 = this.f2316e;
        if (i3 == 0 || i2 > this.f2314c[i3 - 1]) {
            if (this.f2313b && this.f2316e >= this.f2314c.length) {
                c();
            }
            int i4 = this.f2316e;
            if (i4 >= this.f2314c.length) {
                int b2 = e.b(i4 + 1);
                int[] iArr = new int[b2];
                Object[] objArr = new Object[b2];
                int[] iArr2 = this.f2314c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f2315d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f2314c = iArr;
                this.f2315d = objArr;
            }
            this.f2314c[i4] = i2;
            this.f2315d[i4] = e2;
            this.f2316e = i4 + 1;
            return;
        }
        c(i2, e2);
    }

    public void c(int i2, E e2) {
        int a2 = e.a(this.f2314c, this.f2316e, i2);
        if (a2 >= 0) {
            this.f2315d[a2] = e2;
        } else {
            int i3 = ~a2;
            if (i3 < this.f2316e) {
                Object[] objArr = this.f2315d;
                if (objArr[i3] == f2312a) {
                    this.f2314c[i3] = i2;
                    objArr[i3] = e2;
                    return;
                }
            }
            if (this.f2313b && this.f2316e >= this.f2314c.length) {
                c();
                i3 = ~e.a(this.f2314c, this.f2316e, i2);
            }
            int i4 = this.f2316e;
            if (i4 >= this.f2314c.length) {
                int b2 = e.b(i4 + 1);
                int[] iArr = new int[b2];
                Object[] objArr2 = new Object[b2];
                int[] iArr2 = this.f2314c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr3 = this.f2315d;
                System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                this.f2314c = iArr;
                this.f2315d = objArr2;
            }
            int i5 = this.f2316e;
            if (i5 - i3 != 0) {
                int[] iArr3 = this.f2314c;
                int i6 = i3 + 1;
                System.arraycopy(iArr3, i3, iArr3, i6, i5 - i3);
                Object[] objArr4 = this.f2315d;
                System.arraycopy(objArr4, i3, objArr4, i6, this.f2316e - i3);
            }
            this.f2314c[i3] = i2;
            this.f2315d[i3] = e2;
            this.f2316e++;
        }
    }

    public int c(int i2) {
        if (this.f2313b) {
            c();
        }
        return this.f2314c[i2];
    }
}
