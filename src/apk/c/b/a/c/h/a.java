package c.b.a.c.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* compiled from: MaterialResources */
public class a {
    public static ColorStateList a(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                ColorStateList a2 = b.a.a.a.a.a(context, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return typedArray.getColorStateList(i2);
    }

    public static Drawable b(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                Drawable b2 = b.a.a.a.a.b(context, resourceId);
                if (b2 != null) {
                    return b2;
                }
            }
        }
        return typedArray.getDrawable(i2);
    }

    public static c c(Context context, TypedArray typedArray, int i2) {
        if (typedArray.hasValue(i2)) {
            int resourceId = typedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                return new c(context, resourceId);
            }
        }
        return null;
    }

    static int a(TypedArray typedArray, int i2, int i3) {
        return typedArray.hasValue(i2) ? i2 : i3;
    }
}
