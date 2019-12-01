package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.h.a;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements j {

    /* renamed from: a reason: collision with root package name */
    private static int f362a;

    /* renamed from: b reason: collision with root package name */
    private static Field f363b;

    /* renamed from: c reason: collision with root package name */
    private static Field f364c;

    /* renamed from: d reason: collision with root package name */
    private static Field f365d;

    /* renamed from: e reason: collision with root package name */
    private Activity f366e;

    ImmLeaksCleaner(Activity activity) {
        this.f366e = activity;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        r3.isActive();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0044 */
    public void a(l lVar, a aVar) {
        if (aVar == a.ON_DESTROY) {
            if (f362a == 0) {
                a();
            }
            if (f362a == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.f366e.getSystemService("input_method");
                try {
                    Object obj = f363b.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                View view = (View) f364c.get(inputMethodManager);
                                if (view != null) {
                                    if (!view.isAttachedToWindow()) {
                                        f365d.set(inputMethodManager, null);
                                    }
                                }
                            } catch (IllegalAccessException unused) {
                            } catch (ClassCastException unused2) {
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (IllegalAccessException unused3) {
                }
            }
        }
    }

    private static void a() {
        try {
            f362a = 2;
            f364c = InputMethodManager.class.getDeclaredField("mServedView");
            f364c.setAccessible(true);
            f365d = InputMethodManager.class.getDeclaredField("mNextServedView");
            f365d.setAccessible(true);
            f363b = InputMethodManager.class.getDeclaredField("mH");
            f363b.setAccessible(true);
            f362a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
