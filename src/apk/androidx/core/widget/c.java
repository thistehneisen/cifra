package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* compiled from: CompoundButtonCompat */
public final class c {

    /* renamed from: a reason: collision with root package name */
    private static Field f1370a;

    /* renamed from: b reason: collision with root package name */
    private static boolean f1371b;

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof k) {
            ((k) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static void a(CompoundButton compoundButton, Mode mode) {
        if (VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof k) {
            ((k) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static Drawable a(CompoundButton compoundButton) {
        if (VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        String str = "CompoundButtonCompat";
        if (!f1371b) {
            try {
                f1370a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1370a.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i(str, "Failed to retrieve mButtonDrawable field", e2);
            }
            f1371b = true;
        }
        Field field = f1370a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.i(str, "Failed to get button drawable via reflection", e3);
                f1370a = null;
            }
        }
        return null;
    }
}
