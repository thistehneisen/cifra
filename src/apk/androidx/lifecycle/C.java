package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ViewModel */
public abstract class C {

    /* renamed from: a reason: collision with root package name */
    private final Map<String, Object> f1603a = new HashMap();

    /* renamed from: b reason: collision with root package name */
    private volatile boolean f1604b = false;

    /* access modifiers changed from: 0000 */
    public final void a() {
        this.f1604b = true;
        Map<String, Object> map = this.f1603a;
        if (map != null) {
            synchronized (map) {
                for (Object a2 : this.f1603a.values()) {
                    a(a2);
                }
            }
        }
        b();
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    private static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
