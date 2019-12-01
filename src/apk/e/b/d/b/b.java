package e.b.d.b;

import e.b.c.c;

/* compiled from: ObjectHelper */
public final class b {

    /* renamed from: a reason: collision with root package name */
    static final c<Object, Object> f7971a = new a();

    /* compiled from: ObjectHelper */
    static final class a implements c<Object, Object> {
        a() {
        }

        public boolean test(Object obj, Object obj2) {
            return b.a(obj, obj2);
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int a(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> c<T, T> a() {
        return f7971a;
    }

    public static int a(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" > 0 required but it was ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }
}
