package b.e.b;

/* compiled from: Pools */
class h<T> implements g<T> {

    /* renamed from: a reason: collision with root package name */
    private final Object[] f2455a;

    /* renamed from: b reason: collision with root package name */
    private int f2456b;

    h(int i2) {
        if (i2 > 0) {
            this.f2455a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public T a() {
        int i2 = this.f2456b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        T[] tArr = this.f2455a;
        T t = tArr[i3];
        tArr[i3] = null;
        this.f2456b = i2 - 1;
        return t;
    }

    public boolean a(T t) {
        int i2 = this.f2456b;
        Object[] objArr = this.f2455a;
        if (i2 >= objArr.length) {
            return false;
        }
        objArr[i2] = t;
        this.f2456b = i2 + 1;
        return true;
    }

    public void a(T[] tArr, int i2) {
        if (i2 > tArr.length) {
            i2 = tArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            T t = tArr[i3];
            int i4 = this.f2456b;
            Object[] objArr = this.f2455a;
            if (i4 < objArr.length) {
                objArr[i4] = t;
                this.f2456b = i4 + 1;
            }
        }
    }
}
