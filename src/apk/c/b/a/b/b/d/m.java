package c.b.a.b.b.d;

import java.io.PrintStream;

public final class m {

    /* renamed from: a reason: collision with root package name */
    private static final l f3060a;

    /* renamed from: b reason: collision with root package name */
    private static final int f3061b;

    static final class a extends l {
        a() {
        }

        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    static {
        l lVar;
        Integer num;
        int i2 = 1;
        try {
            num = a();
            if (num != null) {
                try {
                    if (num.intValue() >= 19) {
                        lVar = new q();
                        f3060a = lVar;
                        if (num != null) {
                            i2 = num.intValue();
                        }
                        f3061b = i2;
                    }
                } catch (Throwable th) {
                    th = th;
                    PrintStream printStream = System.err;
                    String name = a.class.getName();
                    StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 133);
                    sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    sb.append(name);
                    sb.append("will be used. The error is: ");
                    printStream.println(sb.toString());
                    th.printStackTrace(System.err);
                    lVar = new a();
                    f3060a = lVar;
                    if (num != null) {
                    }
                    f3061b = i2;
                }
            }
            if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
                lVar = new p();
            } else {
                lVar = new a();
            }
        } catch (Throwable th2) {
            th = th2;
            num = null;
            PrintStream printStream2 = System.err;
            String name2 = a.class.getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 133);
            sb2.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb2.append(name2);
            sb2.append("will be used. The error is: ");
            printStream2.println(sb2.toString());
            th.printStackTrace(System.err);
            lVar = new a();
            f3060a = lVar;
            if (num != null) {
            }
            f3061b = i2;
        }
        f3060a = lVar;
        if (num != null) {
        }
        f3061b = i2;
    }

    public static void a(Throwable th, Throwable th2) {
        f3060a.a(th, th2);
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }
}
