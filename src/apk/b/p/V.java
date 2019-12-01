package b.p;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi18 */
class V {

    /* renamed from: a reason: collision with root package name */
    private static Method f2852a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f2853b;

    static void a(ViewGroup viewGroup, boolean z) {
        String str = "ViewUtilsApi18";
        a();
        Method method = f2852a;
        if (method != null) {
            try {
                method.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException e2) {
                Log.i(str, "Failed to invoke suppressLayout method", e2);
            } catch (InvocationTargetException e3) {
                Log.i(str, "Error invoking suppressLayout method", e3);
            }
        }
    }

    private static void a() {
        if (!f2853b) {
            try {
                f2852a = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f2852a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", e2);
            }
            f2853b = true;
        }
    }
}
