package b.p;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: ViewUtils */
class ba {

    /* renamed from: a reason: collision with root package name */
    private static final fa f2861a;

    /* renamed from: b reason: collision with root package name */
    private static Field f2862b;

    /* renamed from: c reason: collision with root package name */
    private static boolean f2863c;

    /* renamed from: d reason: collision with root package name */
    static final Property<View, Float> f2864d = new Z(Float.class, "translationAlpha");

    /* renamed from: e reason: collision with root package name */
    static final Property<View, Rect> f2865e = new aa(Rect.class, "clipBounds");

    static {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 22) {
            f2861a = new ea();
        } else if (i2 >= 21) {
            f2861a = new da();
        } else if (i2 >= 19) {
            f2861a = new ca();
        } else {
            f2861a = new fa();
        }
    }

    static void a(View view, float f2) {
        f2861a.a(view, f2);
    }

    static Y b(View view) {
        if (VERSION.SDK_INT >= 18) {
            return new X(view);
        }
        return W.c(view);
    }

    static float c(View view) {
        return f2861a.b(view);
    }

    static ka d(View view) {
        if (VERSION.SDK_INT >= 18) {
            return new ja(view);
        }
        return new ia(view.getWindowToken());
    }

    static void e(View view) {
        f2861a.c(view);
    }

    static void a(View view) {
        f2861a.a(view);
    }

    static void a(View view, int i2) {
        a();
        Field field = f2862b;
        if (field != null) {
            try {
                f2862b.setInt(view, i2 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused) {
            }
        }
    }

    static void b(View view, Matrix matrix) {
        f2861a.b(view, matrix);
    }

    static void a(View view, Matrix matrix) {
        f2861a.a(view, matrix);
    }

    static void a(View view, int i2, int i3, int i4, int i5) {
        f2861a.a(view, i2, i3, i4, i5);
    }

    private static void a() {
        if (!f2863c) {
            try {
                f2862b = View.class.getDeclaredField("mViewFlags");
                f2862b.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtils", "fetchViewFlagsField: ");
            }
            f2863c = true;
        }
    }
}
