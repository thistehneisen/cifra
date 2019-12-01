package l.a.d.b.a;

/* compiled from: Lc */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public static final d f10422a = new d("GENERAL");

    /* renamed from: b reason: collision with root package name */
    public static final int f10423b;

    /* renamed from: c reason: collision with root package name */
    private static boolean f10424c = true;

    /* renamed from: d reason: collision with root package name */
    private static f f10425d = new b(e.ERROR);

    static {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i2 = 0;
        while (i2 < stackTrace.length && !stackTrace[i2].getClassName().equals(c.class.getName())) {
            i2++;
        }
        f10423b = i2 + 1;
    }

    private c() {
    }

    public static f a() {
        return f10425d;
    }

    public static boolean b() {
        return f10424c;
    }

    public static void a(f fVar, boolean z) {
        f10424c = z;
        f10425d = fVar;
    }

    public static void b(String str, Object... objArr) {
        f10422a.c(str, objArr);
    }

    public static void a(String str, Object... objArr) {
        f10422a.a(str, objArr);
    }

    public static void a(Throwable th, String str, Object... objArr) {
        f10422a.a(th, str, objArr);
    }

    public static void a(String str) {
        f10422a.a(str);
    }

    public static void a(Throwable th) {
        f10422a.a(th);
    }

    public static String a(Object obj) {
        return a(obj, 1);
    }

    public static String a(Object obj, int i2) {
        String str;
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[f10423b + i2];
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getMethodName());
        sb.append('(');
        sb.append(stackTraceElement.getFileName());
        sb.append(':');
        sb.append(stackTraceElement.getLineNumber());
        sb.append(')');
        if (obj != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" of object ");
            sb2.append(obj.getClass().getSimpleName());
            sb2.append('(');
            sb2.append(Integer.toHexString(obj.hashCode()));
            sb2.append(')');
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }
}
