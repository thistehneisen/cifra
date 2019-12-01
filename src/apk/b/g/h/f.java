package b.g.h;

/* compiled from: Pools */
public class f<T> extends e<T> {

    /* renamed from: c reason: collision with root package name */
    private final Object f2623c = new Object();

    public f(int i2) {
        super(i2);
    }

    public T a() {
        T a2;
        synchronized (this.f2623c) {
            a2 = super.a();
        }
        return a2;
    }

    public boolean a(T t) {
        boolean a2;
        synchronized (this.f2623c) {
            a2 = super.a(t);
        }
        return a2;
    }
}
