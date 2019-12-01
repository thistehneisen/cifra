package kotlin;

import java.io.Serializable;

/* compiled from: Result.kt */
public final class h<T> implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final a f10321a = new a(null);
    private final Object value;

    /* compiled from: Result.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* compiled from: Result.kt */
    public static final class b implements Serializable {
        public final Throwable exception;

        public b(Throwable th) {
            kotlin.e.b.h.b(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && kotlin.e.b.h.a((Object) this.exception, (Object) ((b) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Failure(");
            sb.append(this.exception);
            sb.append(')');
            return sb.toString();
        }
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static boolean a(Object obj, Object obj2) {
        return (obj2 instanceof h) && kotlin.e.b.h.a(obj, ((h) obj2).a());
    }

    public static int b(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static String d(Object obj) {
        if (obj instanceof b) {
            return obj.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Success(");
        sb.append(obj);
        sb.append(')');
        return sb.toString();
    }

    public final /* synthetic */ Object a() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return a(this.value, obj);
    }

    public int hashCode() {
        return b(this.value);
    }

    public String toString() {
        return d(this.value);
    }
}
