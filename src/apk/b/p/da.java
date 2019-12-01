package b.p;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi21 */
class da extends ca {

    /* renamed from: e reason: collision with root package name */
    private static Method f2876e;

    /* renamed from: f reason: collision with root package name */
    private static boolean f2877f;

    /* renamed from: g reason: collision with root package name */
    private static Method f2878g;

    /* renamed from: h reason: collision with root package name */
    private static boolean f2879h;

    da() {
    }

    private void c() {
        if (!f2877f) {
            try {
                f2876e = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f2876e.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e2);
            }
            f2877f = true;
        }
    }

    private void d() {
        if (!f2879h) {
            try {
                f2878g = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                f2878g.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e2);
            }
            f2879h = true;
        }
    }

    public void a(View view, Matrix matrix) {
        c();
        Method method = f2876e;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void b(View view, Matrix matrix) {
        d();
        Method method = f2878g;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }
}
