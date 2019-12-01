package kotlinx.coroutines;

import kotlin.e.b.h;
import kotlinx.coroutines.internal.a;

/* compiled from: Debug.kt */
public final class c {

    /* renamed from: a reason: collision with root package name */
    public static final boolean f10357a;

    /* renamed from: b reason: collision with root package name */
    public static final boolean f10358b = a.a("kotlinx.coroutines.stacktrace.recovery", true);

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r0.equals("auto") != false) goto L_0x0026;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r0.equals("on") != false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r0.equals("") != false) goto L_0x0048;
     */
    static {
        boolean z;
        String a2 = a.a("kotlinx.coroutines.debug");
        if (a2 != null) {
            int hashCode = a2.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    } else if (a2.equals("off")) {
                        z = false;
                        f10357a = z;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("System property 'kotlinx.coroutines.debug' has unrecognized value '");
                sb.append(a2);
                sb.append('\'');
                throw new IllegalStateException(sb.toString().toString());
            }
            z = true;
            f10357a = z;
        }
        z = b.class.desiredAssertionStatus();
        f10357a = z;
    }

    public static final String a(Object obj) {
        h.b(obj, "receiver$0");
        String simpleName = obj.getClass().getSimpleName();
        h.a((Object) simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    public static final String b(Object obj) {
        h.b(obj, "receiver$0");
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        h.a((Object) hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }
}
