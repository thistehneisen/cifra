package b.p;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi22 */
class ea extends da {

    /* renamed from: i reason: collision with root package name */
    private static Method f2880i;

    /* renamed from: j reason: collision with root package name */
    private static boolean f2881j;

    ea() {
    }

    @SuppressLint({"PrivateApi"})
    private void e() {
        if (!f2881j) {
            try {
                f2880i = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f2880i.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi22", "Failed to retrieve setLeftTopRightBottom method", e2);
            }
            f2881j = true;
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        e();
        Method method = f2880i;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
