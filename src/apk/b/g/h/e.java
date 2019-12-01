package b.g.h;

/* compiled from: Pools */
public class e<T> implements d<T> {

    /* renamed from: a reason: collision with root package name */
    private final Object[] f2621a;

    /* renamed from: b reason: collision with root package name */
    private int f2622b;

    public e(int i2) {
        if (i2 > 0) {
            this.f2621a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean b(T t) {
        for (int i2 = 0; i2 < this.f2622b; i2++) {
            if (this.f2621a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    public T a() {
        int i2 = this.f2622b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        T[] tArr = this.f2621a;
        T t = tArr[i3];
        tArr[i3] = null;
        this.f2622b = i2 - 1;
        return t;
    }

    public boolean a(T t) {
        if (!b(t)) {
            int i2 = this.f2622b;
            Object[] objArr = this.f2621a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f2622b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
