package androidx.appcompat.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.c;
import b.a.b.a.e;
import java.lang.reflect.Field;

/* compiled from: DrawableUtils */
public class K {

    /* renamed from: a reason: collision with root package name */
    public static final Rect f811a = new Rect();

    /* renamed from: b reason: collision with root package name */
    private static Class<?> f812b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f812b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static boolean a(Drawable drawable) {
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable a2 : ((DrawableContainerState) constantState).getChildren()) {
                    if (!a(a2)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof c) {
            return a(((c) drawable).a());
        } else {
            if (drawable instanceof e) {
                return a(((e) drawable).a());
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    static void b(Drawable drawable) {
        if (VERSION.SDK_INT == 21) {
            if ("android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                d(drawable);
            }
        }
    }

    public static Rect c(Drawable drawable) {
        Field[] fields;
        if (f812b != null) {
            try {
                Drawable h2 = a.h(drawable);
                Object invoke = h2.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(h2, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f812b.getFields()) {
                        String name = field.getName();
                        char c2 = 65535;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        if (c2 == 0) {
                            rect.left = field.getInt(invoke);
                        } else if (c2 == 1) {
                            rect.top = field.getInt(invoke);
                        } else if (c2 == 2) {
                            rect.right = field.getInt(invoke);
                        } else if (c2 == 3) {
                            rect.bottom = field.getInt(invoke);
                        }
                    }
                    return rect;
                }
            } catch (Exception unused) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f811a;
    }

    private static void d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(na.f1007f);
        } else {
            drawable.setState(na.f1010i);
        }
        drawable.setState(state);
    }

    public static Mode a(int i2, Mode mode) {
        if (i2 == 3) {
            return Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return Mode.SRC_IN;
        }
        if (i2 == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }
}
