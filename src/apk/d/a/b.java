package d.a;

import f.a.a;

/* compiled from: DoubleCheck */
public final class b<T> implements a<T>, d.a<T> {

    /* renamed from: a reason: collision with root package name */
    private static final Object f7849a = new Object();

    /* renamed from: b reason: collision with root package name */
    private volatile a<T> f7850b;

    /* renamed from: c reason: collision with root package name */
    private volatile Object f7851c = f7849a;

    private b(a<T> aVar) {
        this.f7850b = aVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != f7849a) || obj == obj2) {
            return obj2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Scoped provider was invoked recursively returning different results: ");
        sb.append(obj);
        sb.append(" & ");
        sb.append(obj2);
        sb.append(". This is likely due to a circular dependency.");
        throw new IllegalStateException(sb.toString());
    }

    public T get() {
        T t = this.f7851c;
        if (t == f7849a) {
            synchronized (this) {
                t = this.f7851c;
                if (t == f7849a) {
                    t = this.f7850b.get();
                    a(this.f7851c, t);
                    this.f7851c = t;
                    this.f7850b = null;
                }
            }
        }
        return t;
    }

    public static <P extends a<T>, T> a<T> a(P p) {
        e.a(p);
        if (p instanceof b) {
            return p;
        }
        return new b(p);
    }
}
