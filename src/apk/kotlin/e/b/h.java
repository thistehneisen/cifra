package kotlin.e.b;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Intrinsics */
public class h {
    private h() {
    }

    public static void a() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        a((T) kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lateinit property ");
        sb.append(str);
        sb.append(" has not been initialized");
        a(sb.toString());
        throw null;
    }

    private static void c(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter specified as non-null is null: method ");
        sb.append(className);
        sb.append(".");
        sb.append(methodName);
        sb.append(", parameter ");
        sb.append(str);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
        a((T) illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void a(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        a((T) uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            c(str);
            throw null;
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" must not be null");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            a((T) illegalStateException);
            throw illegalStateException;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static <T extends Throwable> T a(T t) {
        a(t, h.class.getName());
        return t;
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t;
    }
}
