package b.p;

import android.animation.LayoutTransition;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ViewGroupUtilsApi14 */
class U {

    /* renamed from: a reason: collision with root package name */
    private static LayoutTransition f2847a;

    /* renamed from: b reason: collision with root package name */
    private static Field f2848b;

    /* renamed from: c reason: collision with root package name */
    private static boolean f2849c;

    /* renamed from: d reason: collision with root package name */
    private static Method f2850d;

    /* renamed from: e reason: collision with root package name */
    private static boolean f2851e;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    static void a(ViewGroup viewGroup, boolean z) {
        LayoutTransition layoutTransition;
        boolean z2 = false;
        if (f2847a == null) {
            f2847a = new T();
            f2847a.setAnimator(2, null);
            f2847a.setAnimator(0, null);
            f2847a.setAnimator(1, null);
            f2847a.setAnimator(3, null);
            f2847a.setAnimator(4, null);
        }
        if (z) {
            LayoutTransition layoutTransition2 = viewGroup.getLayoutTransition();
            if (layoutTransition2 != null) {
                if (layoutTransition2.isRunning()) {
                    a(layoutTransition2);
                }
                if (layoutTransition2 != f2847a) {
                    viewGroup.setTag(C0278y.transition_layout_save, layoutTransition2);
                }
            }
            viewGroup.setLayoutTransition(f2847a);
            return;
        }
        viewGroup.setLayoutTransition(null);
        String str = "ViewGroupUtilsApi14";
        if (!f2849c) {
            try {
                f2848b = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f2848b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(str, "Failed to access mLayoutSuppressed field by reflection");
            }
            f2849c = true;
        }
        Field field = f2848b;
        if (field != null) {
            try {
                boolean z3 = field.getBoolean(viewGroup);
                if (z3) {
                    try {
                        f2848b.setBoolean(viewGroup, false);
                    } catch (IllegalAccessException unused2) {
                        z2 = z3;
                    }
                }
                z2 = z3;
            } catch (IllegalAccessException unused3) {
                Log.i(str, "Failed to get mLayoutSuppressed field by reflection");
                if (z2) {
                }
                layoutTransition = (LayoutTransition) viewGroup.getTag(C0278y.transition_layout_save);
                if (layoutTransition == null) {
                }
            }
        }
        if (z2) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(C0278y.transition_layout_save);
        if (layoutTransition == null) {
            viewGroup.setTag(C0278y.transition_layout_save, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }

    private static void a(LayoutTransition layoutTransition) {
        String str = "Failed to access cancel method by reflection";
        String str2 = "ViewGroupUtilsApi14";
        if (!f2851e) {
            try {
                f2850d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f2850d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i(str2, str);
            }
            f2851e = true;
        }
        Method method = f2850d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i(str2, str);
            } catch (InvocationTargetException unused3) {
                Log.i(str2, "Failed to invoke cancel method by reflection");
            }
        }
    }
}
