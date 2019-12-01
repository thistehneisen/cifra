package b.p;

import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewUtilsApi19 */
class ca extends fa {

    /* renamed from: a reason: collision with root package name */
    private static Method f2871a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f2872b;

    /* renamed from: c reason: collision with root package name */
    private static Method f2873c;

    /* renamed from: d reason: collision with root package name */
    private static boolean f2874d;

    ca() {
    }

    public void a(View view) {
    }

    public void a(View view, float f2) {
        b();
        Method method = f2871a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Float.valueOf(f2)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            view.setAlpha(f2);
        }
    }

    public float b(View view) {
        a();
        Method method = f2873c;
        if (method != null) {
            try {
                return ((Float) method.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return super.b(view);
    }

    public void c(View view) {
    }

    private void a() {
        if (!f2874d) {
            try {
                f2873c = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f2873c.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", e2);
            }
            f2874d = true;
        }
    }

    private void b() {
        if (!f2872b) {
            try {
                f2871a = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f2871a.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", e2);
            }
            f2872b = true;
        }
    }
}
