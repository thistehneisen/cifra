package androidx.lifecycle;

import androidx.lifecycle.h.a;
import androidx.lifecycle.h.b;

/* compiled from: LifecycleRegistry */
/* synthetic */ class m {

    /* renamed from: a reason: collision with root package name */
    static final /* synthetic */ int[] f1650a = new int[a.values().length];

    /* renamed from: b reason: collision with root package name */
    static final /* synthetic */ int[] f1651b = new int[b.values().length];

    /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
    /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
    static {
        try {
            f1651b[b.INITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1651b[b.CREATED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1651b[b.STARTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1651b[b.RESUMED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1651b[b.DESTROYED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f1650a[a.ON_CREATE.ordinal()] = 1;
        f1650a[a.ON_STOP.ordinal()] = 2;
        f1650a[a.ON_START.ordinal()] = 3;
        f1650a[a.ON_PAUSE.ordinal()] = 4;
        f1650a[a.ON_RESUME.ordinal()] = 5;
        f1650a[a.ON_DESTROY.ordinal()] = 6;
        f1650a[a.ON_ANY.ordinal()] = 7;
    }
}
