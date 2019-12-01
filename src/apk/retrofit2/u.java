package retrofit2;

import i.M;
import i.O;

/* compiled from: Response */
public final class u<T> {

    /* renamed from: a reason: collision with root package name */
    private final M f11060a;

    /* renamed from: b reason: collision with root package name */
    private final T f11061b;

    /* renamed from: c reason: collision with root package name */
    private final O f11062c;

    private u(M m, T t, O o) {
        this.f11060a = m;
        this.f11061b = t;
        this.f11062c = o;
    }

    public static <T> u<T> a(T t, M m) {
        y.a(m, "rawResponse == null");
        if (m.f()) {
            return new u<>(m, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public int b() {
        return this.f11060a.c();
    }

    public boolean c() {
        return this.f11060a.f();
    }

    public String d() {
        return this.f11060a.g();
    }

    public String toString() {
        return this.f11060a.toString();
    }

    public static <T> u<T> a(O o, M m) {
        y.a(o, "body == null");
        y.a(m, "rawResponse == null");
        if (!m.f()) {
            return new u<>(m, null, o);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public T a() {
        return this.f11061b;
    }
}
