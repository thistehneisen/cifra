package androidx.core.widget;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import b.g.i.B;
import b.g.i.C0243d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: PopupWindowCompat */
public final class i {

    /* renamed from: a reason: collision with root package name */
    private static Method f1372a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f1373b;

    /* renamed from: c reason: collision with root package name */
    private static Field f1374c;

    /* renamed from: d reason: collision with root package name */
    private static boolean f1375d;

    public static void a(PopupWindow popupWindow, View view, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i2, i3, i4);
            return;
        }
        if ((C0243d.a(i4, B.m(view)) & 7) == 5) {
            i2 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i2, i3);
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (i2 >= 21) {
            String str = "PopupWindowCompatApi21";
            if (!f1375d) {
                try {
                    f1374c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f1374c.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i(str, "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                f1375d = true;
            }
            Field field = f1374c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e3) {
                    Log.i(str, "Could not set overlap anchor field in PopupWindow", e3);
                }
            }
        }
    }

    public static void a(PopupWindow popupWindow, int i2) {
        if (VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!f1373b) {
            try {
                f1372a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1372a.setAccessible(true);
            } catch (Exception unused) {
            }
            f1373b = true;
        }
        Method method = f1372a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i2)});
            } catch (Exception unused2) {
            }
        }
    }
}
